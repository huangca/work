import dominion_p as d
import random

MAX_HAND = 500
MAX_DECK = 500
MAX_PLAYERS =  4
DEBUG = 0
MAX_TEST=100

def playCardTest():
	player=random.randrange(2,5)
	seed=random.randrange(3,11)

	game = d.initializeGame(player, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
								d.embargo, d.feast, d.gardens, d.great_hall, d.mine], seed)
				
#for i in range(MAX_TEST):
	turn=random.randrange(0,player)
	game.whoseTurn=turn
	play=random.choice(game.kingdomCards)
	#play=d.baron
	if play==d.adventurer:
		deck=random.randrange(0,MAX_DECK)
		discard=random.randrange(0,MAX_DECK)
		hand=random.randrange(0,MAX_HAND-1)
		game.deck[turn]=[]
		game.discard[turn]=[]
		game.hand[turn]=[]
		for i in range(deck):
			game.deck[turn].append(random.randrange(d.curse,d.mine+1))
		for j in range(discard):
			game.discard[turn].append(random.randrange(d.curse,d.mine+1))
		for k in range(hand):
			game.hand[turn].append(random.randrange(d.curse,d.mine+1))
		pos=random.randrange(0,hand)
		game.hand[turn].insert(pos,d.adventurer) # insert the kingdom card to position
		choice1=-1 #adventurer does not need player any choise so set all -1 and bonus use default
		choice2=-1
		choice3=-1
		d.playCard(pos,choice1,choice2,choice3,game)
	elif play==d.ambassador:
		pass #still not clearn this card effect
	elif play==d.baron: #I think have some bug at the baron implementation
		hand=random.randrange(0,MAX_HAND-1)
		discard=random.randrange(0,MAX_DECK)
		game.hand[turn]=[]
		game.discard[turn]=[]
		for j in range(discard):
			game.discard[turn].append(random.randrange(d.curse,d.mine+1))
		for k in range(hand):
			game.hand[turn].append(random.randrange(d.curse,d.mine+1))
		pos=random.randrange(0,hand)
		game.hand[turn].insert(pos,d.baron)
		choice1=random.randrange(0,hand)
		choice2=random.randrange(0,2)
		choice3=-1 # don't need 3
		d.playCard(pos,choice1,choice2,choice3,game)
	elif play==d.council_room:
		hand1=[]
		deck1=[]
		for i in range(player):
			hand1.append(random.randrange(0,MAX_HAND-1))
		for j in range(player):
			deck1.append(random.randrange(0,MAX_DECK))
		game.hand[turn]=[]
		game.deck[turn]=[]
		for j in range(hand1[turn]):
			game.hand[turn].append(random.randrange(d.curse,d.mine+1))
		for k in range(deck1[turn]):
			game.deck[turn].append(random.randrange(d.curse,d.mine+1))
		pos=random.randrange(0,hand1[turn])
		game.hand[turn].insert(pos,d.council_room)
		
		for a in range(player):
			if a != turn:
				game.hand[a]=[]
				game.deck[a]=[]
				for b in range(hand1[a]):
					game.hand[a].append(random.randrange(d.curse,d.mine+1))
				for c in range(deck1[a]):
					game.deck[a].append(random.randrange(d.curse,d.mine+1))
		choice1=-1 #don't need choice so set all -1
		choice2=-1
		choice3=-1
		d.playCard(pos,choice1,choice2,choice3,game)
	elif play==d.cutpurse:
		hand1=[]
		deck1=[]
		for i in range(player):
			hand1.append(random.randrange(0,MAX_HAND-1))
		for j in range(player):
			deck1.append(random.randrange(0,MAX_DECK))
		game.hand[turn]=[]
		game.deck[turn]=[]
		for j in range(hand1[turn]): # current player
			game.hand[turn].append(random.randrange(d.curse,d.mine+1))
		for k in range(deck1[turn]):
			game.deck[turn].append(random.randrange(d.curse,d.mine+1))
		pos=random.randrange(0,hand1[turn])
		game.hand[turn].insert(pos,d.cutpurse)
		
		for a in range(player): #other player
			if a !=turn:
				game.hand[a]=[]
				game.deck[a]=[]
				for b in range(hand1[a]):
					game.hand[a].append(random.randrange(d.curse,d.mine+1))
				for c in range(deck1[a]):
					game.deck[a].append(random.randrange(d.curse,d.mine+1))
		
		choice1=-1
		choice2=-1
		choice3=-1
		d.playCard(pos,choice1,choice2,choice3,game)
		
	elif play==d.embargo:
		hand=random.randrange(0,MAX_HAND-1)
		game.hand[turn]=[]
		for i in range(hand):
			game.hand[turn].append(random.randrange(d.curse,d.mine+1))
		pos=random.randrange(0,hand)
		game.hand[turn].insert(pos,d.embargo)
		####random supplyCount
		for card in game.kingdomCards:
			game.supplyCount[card]=random.randrange(0,11)
		#####random embargo token
		for token in game.kingdomCards:
			game.embargoTokens[token]=random.randrange(0,99)
		choice1=random.randrange(d.adventurer,d.mine+1) #random pick one 
		choice2=-1
		choice3=-1
		d.playCard(pos,choice1,choice2,choice3,game)
	elif play==d.feast:
		hand=random.randrange(0,MAX_HAND-1)
		game.hand[turn]=[]
		for i in range(hand):
			game.hand[turn].append(random.randrange(d.curse,d.mine+1))
		pos=random.randrange(0,hand)
		game.hand[turn].insert(pos,d.feast)
		for card in game.kingdomCards:
			game.supplyCount[card]=random.randrange(0,11)
		choice1=random.choice(game.kingdomCards)
		choice2=-1
		choice3=-1
		d.playCard(pos,choice1,choice2,choice3,game)
	elif play==d.great_hall:
		deck=random.randrange(0,MAX_DECK)
		discard=random.randrange(0,MAX_DECK)
		hand=random.randrange(0,MAX_HAND-1)
		game.deck[turn]=[]
		game.discard[turn]=[]
		game.hand[turn]=[]
		for i in range(deck):
			game.deck[turn].append(random.randrange(d.curse,d.mine+1))
		for j in range(discard):
			game.discard[turn].append(random.randrange(d.curse,d.mine+1))
		for k in range(hand):
			game.hand[turn].append(random.randrange(d.curse,d.mine+1))
		pos=random.randrange(0,hand)
		
		game.hand[turn].insert(pos,d.great_hall)
		game.numActions=random.randrange(0,99)
		
		choice1=-1
		choice2=-1
		choice3=-1
		d.playCard(pos,choice1,choice2,choice3,game)
	elif play==d.mine:
		hand=random.randrange(0,MAX_HAND-1)
		game.hand[turn]=[]
		for k in range(hand):
			game.hand[turn].append(random.randrange(d.curse,d.mine+1))
		pos=random.randrange(0,hand)
		game.hand[turn].insert(pos,d.mine)
		for card in range(d.copper,d.gold+1): ##random moey
			game.supplyCount[card]=random.randrange(0,50)
		choice1=random.choice(game.hand[turn])
		choice2=random.randrange(d.copper,d.gold+1)
		choice3=-1
		d.playCard(pos,choice1,choice2,choice3,game)
	elif play==d.smithy:
		deck=random.randrange(0,MAX_DECK)
		discard=random.randrange(0,MAX_DECK)
		hand=random.randrange(0,MAX_HAND-1)
		game.deck[turn]=[]
		game.discard[turn]=[]
		game.hand[turn]=[]
		for i in range(deck):
			game.deck[turn].append(random.randrange(d.curse,d.mine+1))
		for j in range(discard):
			game.discard[turn].append(random.randrange(d.curse,d.mine+1))
		for k in range(hand):
			game.hand[turn].append(random.randrange(d.curse,d.mine+1))
		pos=random.randrange(0,hand)
		game.hand[turn].insert(pos,d.smithy)
		choice1=-1
		choice2=-1
		choice3=-1
		d.playCard(pos,choice1,choice2,choice3,game)
	elif play==d.village:
		deck=random.randrange(0,MAX_DECK)
		discard=random.randrange(0,MAX_DECK)
		hand=random.randrange(0,MAX_HAND-1)
		game.deck[turn]=[]
		game.discard[turn]=[]
		game.hand[turn]=[]
		for i in range(deck):
			game.deck[turn].append(random.randrange(d.curse,d.mine+1))
		for j in range(discard):
			game.discard[turn].append(random.randrange(d.curse,d.mine+1))
		for k in range(hand):
			game.hand[turn].append(random.randrange(d.curse,d.mine+1))
		pos=random.randrange(0,hand)
		game.hand[turn].insert(pos,d.village)
		game.numActions=random.randrange(0,99)
		choice1=-1
		choice2=-1
		choice3=-1
		
		d.playCard(pos,choice1,choice2,choice3,game)
	elif play==d.sea_hag:
		hand=random.randrange(0,MAX_HAND-1)
		game.hand[turn]=[]
		for k in range(hand):
			game.hand[turn].append(random.randrange(d.curse,d.mine+1))
		pos=random.randrange(0,hand)
		game.hand[turn].insert(pos,d.sea_hag)
		
		discard1=[]
		deck1=[]
		for i in range(player):
			discard1.append(random.randrange(0,MAX_HAND-1))
		for j in range(player):
			deck1.append(random.randrange(0,MAX_DECK))
		for a in range(player):
			if a!=turn:
				game.discard[a]=[]
				game.deck[a]=[]
				for b in range(discard1[a]):
					game.discard[a].append(random.randrange(d.curse,d.mine+1))
				for c in range(deck1[a]):
					game.deck[a].append(random.randrange(d.curse,d.mine+1))
		choice1=-1
		choice2=-1
		choice3=-1
		d.playCard(pos,choice1,choice2,choice3,game)
			
		
		
		
		
		
		
		
