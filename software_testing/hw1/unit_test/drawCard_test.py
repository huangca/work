import dominion_p as d

game = d.initializeGame(2, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall, d.mine], 10)
							

for i in range(6):
    if(d.drawCard(0,game)==-1):
        print('all card in hand')
    else:
        print(game.deck)
        print(game.hand)

for i in range(5):
    if(d.drawCard(1,game)==-1):
        print('all card in hand')
    else:
        print(game.deck)
        print(game.hand)
