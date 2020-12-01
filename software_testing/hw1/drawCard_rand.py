import dominion_p as d
import copy
import random


MAX_HAND = 500
MAX_DECK = 500
MAX_PLAYERS =  4
DEBUG = 0
MAX_TEST=100

def drawCardTest():
	player=random.randrange(2,5)
	seed=random.randrange(3,11)

	game = d.initializeGame(player, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
								d.embargo, d.feast, d.gardens, d.great_hall, d.mine], seed)
								
#for i in range(MAX_TEST):
	turn=random.randrange(0,player)
	deck=random.randrange(0,MAX_DECK)
	discard=random.randrange(0,MAX_DECK)
	hand=random.randrange(0,MAX_HAND)
	game.deck[turn]=[]
	game.discard[turn]=[]
	game.hand[turn]=[]
	for i in range(deck):
		game.deck[turn].append(random.randrange(d.curse,d.mine+1))
	for j in range(discard):
		game.discard[turn].append(random.randrange(d.curse,d.mine+1))
	for k in range(hand):
		game.hand[turn].append(random.randrange(d.curse,d.mine+1))
	d.drawCard(turn,game)
	