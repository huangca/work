import dominion_p as d
import copy
game = d.initializeGame(2, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall, d.mine], 10)
						
game2=copy.deepcopy(game)						
print(game.players)
print(game.supplyCount )
print( game.embargoTokens)
print( game.whoseTurn )
print( game.phase )
print( game.numActions )
print( game.coins )
print(  game.bonus )
print(  game.numBuys )
print(   game.hand )
print(   game.deck )
print(   game.discard )
print(  game.playedCards )
print(  game.kingdomCards )
print(  game.scores )
##adventurer
assert(d.cardEffect(d.adventurer,0,0,0,game,game.bonus,0)==0)	
##baron
game=copy.deepcopy(game2)
assert(d.cardEffect(d.baron,0,1,0,game,game.bonus,0)==0)
#choise 1:
game.hand[game.whoseTurn]=[d.baron,d.estate]
assert(d.cardEffect(d.baron,1,0,0,game,game.bonus,0)==0)
game.hand[game.whoseTurn]=[d.baron]
assert(d.cardEffect(d.baron,0,0,0,game,game.bonus,0)==-1)
##council_room
game=copy.deepcopy(game2)
assert(d.cardEffect(d.council_room,0,0,0,game,game.bonus,0)==0)
##cutpurse
game=copy.deepcopy(game2)
assert(d.cardEffect(d.cutpurse,0,0,0,game,game.bonus,0)==0)
##embargo
game=copy.deepcopy(game2)
game.hand[game.whoseTurn]=[d.embargo]
assert(d.cardEffect(d.embargo,d.adventurer,0,0,game,game.bonus,0)==0)
##feast
game=copy.deepcopy(game2)
assert(d.cardEffect(d.feast,d.adventurer,0,0,game,game.bonus,0)==-1)
assert(d.cardEffect(d.feast,d.embargo,0,0,game,game.bonus,0)==0)
##great_hall
game=copy.deepcopy(game2)
assert(d.cardEffect(d.great_hall,0,0,0,game,game.bonus,0)==0)
##mine
game=copy.deepcopy(game2)
game.hand[game.whoseTurn]=[d.copper]
assert(d.cardEffect(d.mine,0,d.silver,0,game,game.bonus,0)==0)
game.hand[game.whoseTurn]=[d.silver]
assert(d.cardEffect(d.mine,0,d.gold,0,game,game.bonus,0)==0)
game.hand[game.whoseTurn]=[d.council_room]
assert(d.cardEffect(d.mine,0,d.gold,0,game,game.bonus,0)==-1)
##smithy
game=copy.deepcopy(game2)
assert(d.cardEffect(d.smithy,0,0,0,game,game.bonus,0)==0)
##village
game=copy.deepcopy(game2)
assert(d.cardEffect(d.village,0,0,0,game,game.bonus,0)==0)
##sea_hag
game=copy.deepcopy(game2)
game.hand[1]=[d.copper,d.silver]
assert(d.cardEffect(d.sea_hag,0,0,0,game,game.bonus,0)==0)

