import random
MAX_HAND = 50
MAX_DECK = 50
MAX_PLAYERS =  4
DEBUG = 0
	
(curse,
estate,
duchy,
province,
copper,
silver,
gold,

adventurer, ambassador, baron,
council_room, cutpurse, embargo,
feast, gardens, great_hall, mine,
smithy, village, sea_hag) =range(20)
   

class gameState:
    def __init__(self,p):
        self.players = p
        self.supplyCount = {}
        self.embargoTokens = {}
        self.whoseTurn = 0
        self.phase = 0
        self.numActions = 1
        self.coins = 0
        self.bonus = 0
        self.numBuys = 1
        self.hand = {}
        self.deck = {}
        self.discard = {}
        self.playedCards = []
        self.kingdomCards = []
        self.scores = {}

   
def initializeGame(players,cards,seed):
	if players>MAX_PLAYERS or players<2:
		return -1
	random.seed(seed)
	g=gameState(players) #may let it as an argumant
	g.kingdomCards=cards
	if len(cards) != 10:
		return -1
	else:
		for i in range(10):
			for j in range(10):
				if i!=j and g.kingdomCards[i]==g.kingdomCards[j]:
					return -1
	if players == 2:
		g.supplyCount[curse]=10
		g.supplyCount[estate]=8
		g.supplyCount[duchy]=8
		g.supplyCount[province]=8
	elif players==3:
		g.supplyCount[curse]=20
		g.supplyCount[estate]=12
		g.supplyCount[duchy]=12
		g.supplyCount[province]=12
	else:
		g.supplyCount[curse]=30
		g.supplyCount[estate]=12
		g.supplyCount[duchy]=12
		g.supplyCount[province]=12
		
	g.supplyCount[copper]=60-7*players
	g.supplyCount[silver]=40
	g.supplyCount[gold]=30
	
	for card in range(adventurer,sea_hag+1):#loop all cards and chosen cards 
		for j in range(10):
			if g.kingdomCards[j]==card:
				if g.kingdomCards[j]== great_hall or g.kingdomCards[j]==gardens:
					if players==2:
						g.supplyCount[card]=8
					else:
						g.supplyCount[card]=12
				else:
					g.supplyCount[card]=10
   		
	for player in range(players):
		g.deck[player]=[]
		g.hand[player]=[]
		g.discard[player]=[]
	for player in range(players):
		for e in range(3):
			g.deck[player].append(estate)
		for d in range(7):
			g.deck[player].append(copper)
	for player in range(players):
		shuffle(player,g)
	for card in cards:
		g.embargoTokens[card]=0
	for card in range(adventurer,sea_hag):
		g.embargoTokens[card]=0
	# for player in range(players):
		# for i in range(5):
			# drawCard(player,g)
	for i in range(5): #drawCard when turn start
		drawCard(g.whoseTurn,g)
	updateCoins(g.whoseTurn,g,0)
	return g
	
def shuffle(player,state):
	array=state.deck[player]
	#array.sort()
	random.shuffle(array)
	state.deck[player]=array
	return 0
	
def drawCard(player,state):
	if len(state.deck[player])==0 and len(state.discard[player])==0:
		return -1
	if len(state.deck[player])==0:
		state.deck[player]=state.discard[player]
		state.discard[player]=[]
		shuffle(player,state)
	state.hand[player].append(state.deck[player][len(state.deck[player])-1])
	state.deck[player].pop(len(state.deck[player])-1)
	return 0
	
def updateCoins(player,state,bonus):
	state.coins=0
	#state.bouns+=bonus "bonus" is money from other card effect(except tr card)
	for card in state.hand[player]:
		if card==copper:
			state.coins+=1
		if card==silver:
			state.coins+=2
		if card==gold:
			state.coins+=3
	state.coins+=bonus
	return 0
	
def gainCard(card,state,toFlag,player):
	if state.supplyCount[card]<1:
		return -1
	if toFlag==1:
		state.deck[player].append(card)
	elif toFlag==2:
		state.hand[player].append(card)
	else:
		state.discard[player].append(card)
	state.supplyCount[card]-=1
	return 0

def discardCard(card,player,state,trashFlag):
	if trashFlag == 0:
		state.playedCards.append(card)
		state.hand[player].remove(card)
	elif trashFlag == 2:
		state.discard[player].append(card)
		state.hand[player].remove(card)
	elif trashFlag==1: # special for mine
		state.discard[player].append(card)
		state.deck[player].pop(card)
	return 0	


def getCost(card):
	return {
		curse:0,
		estate:2,
		duchy:5,
		province:8,
		copper:0,
		silver:3,
		gold:6,
		adventurer:6,
		council_room:5,
		feast:4,
		gardens:4,
		mine:5,
		#remodel:4,
		smithy:4,
		village:3,
		baron:4,
		great_hall:3,
		#minion:5,
		#steward:3,
		#tribute:5,
		ambassador:3,
		cutpurse:4,
		embargo:2,
		#outpost:5,
		#salvager:4,
		sea_hag:4,
		#treasure_map:4,
	
	}.get(card,-1)
	
	
def buyCard(position,state):
	print(position)
	if state.numBuys<1:
		return -1
	elif state.supplyCount[position]<1:
		return -1
	elif state.coins<getCost(position):
		return -1
	else:
		state.phase=1
		gainCard(position,state,0,state.whoseTurn)
		state.coins-=getCost(position)
		state.numBuys-=1
		for i in range(state.embargoTokens[position]): ##some action maybe let tokens to supply
			gainCard(curse,state,0,state.whoseTurn)
	return 0
	
def endTurn(state):
	state.discard[state.whoseTurn].extend(state.hand[state.whoseTurn])
	state.hand[state.whoseTurn]=[]
	state.discard[state.whoseTurn].extend(state.playedCards)
	if state.whoseTurn<state.players-1:
		state.whoseTurn+=1
	else:
		state.whoseTurn=0
	state.phase=0
	state.numActions=1
	state.coins=0
	state.numBuys=1
	state.playedCards=[]
	state.bonus=0
	###next player draw card not sure should put it here
	for i in range(5):
		drawCard(state.whoseTurn,state)
	updateCoins(state.whoseTurn,state,0)
	return 0
	
def playCard(pos,choice1,choice2,choice3,state):
	card=state.hand[state.whoseTurn][pos]
	if state.phase !=0:
		return -1
	if state.numActions<1:
		return -1
	if card not in state.kingdomCards:
		return -1
	if cardEffect(card,choice1,choice2,choice3,state,state.bonus,pos) < 0:
		return -1
	state.numActions-=1
	discardCard(card,state.whoseTurn,state,0)  ##maybe should put this line to cardeffect
	#updateCoins(state.whoseTurn,state,state.bonus)   #if do this some proble in baron
	return 0
	

def cardEffect(card,c1,c2,c3,state,bonus,pos):
	nextPlayer=(state.whoseTurn+1)%state.players
	if card==adventurer:
		treasures=0
		temp=[]
		while treasures<2:
			drawCard(state.whoseTurn,state)
			if state.hand[state.whoseTurn][len(state.hand[state.whoseTurn])-1] not in (copper,silver,gold):
				temp.append(state.hand[state.whoseTurn].pop(len(state.hand[state.whoseTurn])-1))
			else:
				treasures+=1
		state.discard[state.whoseTurn].extend(temp)
		temp=[]
		return 0
	elif card==ambassador: #not understand so  temporary just pass
		if c2>2 or c2<0:
			return -1
	##	if c1==pos:
	##		return -1
		j=0
		pass
	elif card==baron:
		choice1=state.hand[state.whoseTurn][c1]
		choice2=c2
		state.numBuys+=1
		if choice2==0:
			if choice1==estate and choice1 in state.hand[state.whoseTurn]:
				discardCard(choice1,state.whoseTurn,state,0)
				updateCoins(state.whoseTurn,state,4)
				return 0
			else:
				return -1
		else:
			gainCard(estate,state,0,state.whoseTurn)
		return 0
	elif card==council_room:
		for i in range(4):
			drawCard(state.whoseTurn,state)
		state.numBuys+=1
		for i in range(state.players):
			if i !=state.whoseTurn:
				drawCard(i,state)
		return 0
	elif card==cutpurse: # truansform from .c file
		updateCoins(state.whoseTurn,state,2)
		for i in range(state.players):
			if i != state.whoseTurn:
				if copper not in state.hand[i]:
					print(state.hand[i])
				else:
					for card in state.hand[i]:
						if card==copper:
							discardCard(card,i,state,0)
							break
		return 0
	elif card==embargo:
		choice1=c1
		if choice1 not in state.embargoTokens.keys():
			return -1
		updateCoins(state.whoseTurn,state,2)
		#discardCard(embargo,state.whoseTurn,state,0)
		state.embargoTokens[choice1]+=1
		return 0
	elif card==feast:
		choice1=c1
		if getCost(choice1)<6:
			gainCard(choice1,state,0,state.whoseTurn)
		else:
			return -1
		return 0
	elif card==gardens: ## transform from .c file
		return -1
	elif card==great_hall:
		drawCard(state.whoseTurn,state)
		state.numActions+=1
		return 0
	elif card==mine:
		choice1=state.hand[state.whoseTurn][c1]
		choice2=c2
		if choice1 not in state.hand[state.whoseTurn]:
			return -1
		if choice1==copper and choice2==silver:
			discardCard(copper,state.whoseTurn,state,0)
			gainCard(silver,state,2,state.whoseTurn)
			return 0
		elif (choice1==silver or choice1==gold) and choice2==gold:
			discardCard(silver,state.whoseTurn,state,0)
			gainCard(gold,state,2,state.whoseTurn)
			return 0
		else:
			return -1
	elif card==smithy:
		for i in range(3):
			drawCard(state.whoseTurn,state)
		return 0
	elif card==village:
		drawCard(state.whoseTurn,state)
		state.numActions+=2
		return 0
	elif card==sea_hag:
		for player in range(state.players):
			if player != state.whoseTurn:
				#drawCard(player,state)
				discardCard((len(state.deck[player])-1),player,state,1)
				gainCard(curse,state,1,player)
		return 0
	return -1


def isGameOver(state):
	if state.supplyCount[province]==0:
		return 1
	count=0
	for i in state.supplyCount:
		if state.supplyCount[i]==0:
			count=count+1
	if count>=3:
		return 1
	return 0
	
def getWinners(state):
	high_score=0
	players=[]
	for player in range(state.players):
		state.scores[player]=scoreFor(player,state)
		players.append(state.scores[player])
	for i in range(state.players):
		high_score=max(high_score,players[i])
	##add 1 to players who had less turns(from .c file, still don't understand,I guess same point let the less turns player win)
	for i in range(state.players):
		if players[i]==high_score and i > state.whoseTurn:
			players[i]+=1
			
	j=0
	for i in range(state.players):
		if(players[i]>players[j]):
			j=i
	high_score=players[j]
	
	for i in range(state.players):
		if players[i]==high_score:
			players[i]=1
		else:
			players[i]=0
	return players
	
def score(set):
	score=0
	for card in set:
		if card==estate:
			score+=1
		if card==duchy:
			score+=3
		if card==province:
			score+=6
		if card==great_hall:
			score+=1
		if card==curse:
			score-=1
		if card==gardens:
			score+=(int)(len(set)/10)
	return score
	
def scoreFor(player,state):
	lib=state.deck[player]+state.hand[player]+state.discard[player]
	return score(lib)
	
	
	
	
	
		


	
	
