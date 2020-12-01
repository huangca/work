import dominion_p as d
import copy
game = d.initializeGame(2, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall, d.mine], 10)

# initialze state both player have same card in hand, deck and discard so same point,
#but second player less 1 turn 
assert(d.getWinners(game)==[0,1])					