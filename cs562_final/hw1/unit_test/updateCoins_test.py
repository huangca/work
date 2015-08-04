import dominion_p as d
import copy
game = d.initializeGame(2, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall, d.mine], 10)
							
							

					
							
game2=copy.deepcopy(game)		
print(game.hand)

assert(d.updateCoins(0,game,0)==0)
print(game.coins)
assert(d.updateCoins(0,game2,1)==0)
assert(game.coins+1==game2.coins)

