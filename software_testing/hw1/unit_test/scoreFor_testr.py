#test scoreFor and score
import dominion_p as d
import copy
game = d.initializeGame(2, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall, d.mine], 10)
							
game.deck[0]=[d.estate,d.duchy]
game.hand[0]=[d.province,d.great_hall]
game.discard[0]=[d.curse,d.gardens]
assert(d.scoreFor(0,game)==10)