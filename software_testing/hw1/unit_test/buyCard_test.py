import dominion_p as d
import copy
game = d.initializeGame(2, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall, d.mine], 10)
							
							

							
game2=copy.deepcopy(game)
##test the regular situation
assert(d.buyCard(d.feast,game)==0)
assert(d.feast in game.discard[game.whoseTurn])	
#test numBuys<1
game=copy.deepcopy(game2)
game.numBuys=0
assert(d.buyCard(d.feast,game)==-1)
#test card in supplyCount <1
game=copy.deepcopy(game2)
game.supplyCount[d.feast]=0
assert(d.buyCard(d.feast,game)==-1)
#test coins<cost of card
game=copy.deepcopy(game2)
game.coins=-1
assert(d.buyCard(d.feast,game)==-1)					