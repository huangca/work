import dominion_p as d
import random

MAX_HAND = 50
MAX_DECK = 50
MAX_PLAYERS =  4
DEBUG = 0
MAX_TEST=100
def getWinnersTest():
	player=random.randrange(2,5)
	seed=random.randrange(3,11)

	game = d.initializeGame(player, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
								d.embargo, d.feast, d.gardens, d.great_hall, d.mine], seed)
				
			
#for i in range(MAX_TEST):
	turn=random.randrange(0,player)
	game.whoseTurn=turn
	hand1=[]
	deck1=[]
	discard1=[]
	for i in range(player):
		hand1.append(random.randrange(0,MAX_HAND))
		deck1.append(random.randrange(0,MAX_DECK))
		discard1.append(random.randrange(0,MAX_DECK))
	for p in range(player):
		game.hand[p]=[]
		game.deck[p]=[]
		game.discard[p]=[]
		for a in range(hand1[p]):
			game.hand[p].append(random.randrange(d.curse,d.mine+1))
		for b in range(deck1[p]):
			game.deck[p].append(random.randrange(d.curse,d.mine+1))
		for c in range(discard1[p]):
			game.discard[p].append(random.randrange(d.curse,d.mine+1))
	d.getWinners(game)
		
