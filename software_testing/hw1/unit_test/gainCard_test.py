import dominion_p as d
import copy
game = d.initializeGame(2, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall, d.mine], 10)
							
							
							
game2=copy.deepcopy(game)
print(game.supplyCount)
print(game.deck[0])
print(game.hand[0])
# test toFlag ==1
assert(d.gainCard(d.adventurer,game,1,0)==0)
assert(game.supplyCount[d.adventurer]+1==game2.supplyCount[d.adventurer])
assert(d.adventurer in game.deck[0])
#test  toFlag ==2
game2=copy.deepcopy(game)
assert(d.gainCard(d.adventurer,game,2,0)==0)
assert(game.supplyCount[d.adventurer]+1==game2.supplyCount[d.adventurer])
assert(d.adventurer in game.hand[0])
#test toFlag not ==1 and 2
game2=copy.deepcopy(game)
assert(d.gainCard(d.adventurer,game,0,0)==0)
assert(game.supplyCount[d.adventurer]+1==game2.supplyCount[d.adventurer])
assert(d.adventurer in game.discard[0])