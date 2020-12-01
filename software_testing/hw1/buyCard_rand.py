import dominion_p as d
import copy
import random


MAX_HAND = 500
MAX_DECK = 500
MAX_PLAYERS =  4
DEBUG = 0
MAX_TEST=100
def buyCardTest():
	player=random.randrange(2,5)
	seed=random.randrange(3,11)

	game = d.initializeGame(player, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
								d.embargo, d.feast, d.gardens, d.great_hall, d.mine], seed)
		
		
#for i in range(MAX_TEST):
	turn=random.randrange(0,player)
	card=random.choice(game.kingdomCards)
	game.supplyCount[card]=random.randrange(0,31)
	game.coins=random.randrange(0,100)
	game.numBuys=random.randrange(0,10)
	
	d.buyCard(card,game)