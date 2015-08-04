import dominion_p as d
import copy
game = d.initializeGame(2, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall, d.mine], 10)
						
game2=copy.deepcopy(game)
#regular test
assert(d.isGameOver(game)==0)
# province out
game.supplyCount[d.province]=0

assert(d.isGameOver(game)==1)
#3 action card out
game=copy.deepcopy(game2)
game.supplyCount[d.adventurer]=0
game.supplyCount[d.feast]=0
game.supplyCount[d.gardens]=0
assert(d.isGameOver(game)==1)
