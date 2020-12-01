import dominion_p as d 
import copy
# this is my shuffle function
# the random.shuffle() function can shuffle empty array so I do not check array is empty or not
# def shuffle(player,state):
	# array=state.deck[player]
	##array.sort()   # in C version it do the sort but I am not sure we have to do it at python
	# random.shuffle(array) 
	# state.deck[player]=array
	# return 0


# if we trust initializeGame() is correct we can use this function initial gamestate
#but need to follow some rule like players have to be 2-4 
card=[]
for i in range(10):
        card.append(i+7)
game = d.initializeGame(3, card, 10)

##we also can create a gamestate break the rules and just fill the deck as test data 
# game=d.gameState(1)
# game.deck[0]=[4,4,4,1,1]

game2=copy.deepcopy(game)
assert(game.deck==game2.deck)

print(game.deck)

print('test shuffle ##################################')
print('shuffle player1 #1')
print(game.deck)
assert(d.shuffle(0,game)==0)
assert(game.deck[0]!=game2.deck[0])



# print('shuffle player1 #2')
# print(game.deck)
# assert(d.shuffle(0,game)==0)
# print(game.deck)

# print('shuffle player1 #3')
# print(game.deck)
# assert(d.shuffle(0,game)==0)
# print(game.deck)

# print('shuffle player2')
# print(game.deck)
# assert(d.shuffle(1,game)==0)
# print(game.deck)

# print('shuffle player3')
# print(game.deck)
# assert(d.shuffle(2,game)==0)
# print(game.deck)

