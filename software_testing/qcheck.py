import pytest
import random
from pytest import list_of
import dominion_p as d



def random_GameState(w,s):
	#x=random.randrange(2,5)
	g=d.initializeGame(w, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall,d.mine], s)
	for i in xrange(10):
		if d.isGameOver(g):
			break
		d.buyCard(random.randrange(7,17),g)
		d.playCard(len(g.hand[g.whoseTurn])-1,random.randrange(1,16),random.randrange(1,16),random.randrange(1,17),g)
		d.endTurn(g)
	return g
	
def random_GameState2(w,s):
	cardlist=[d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.smithy, d.village,d.sea_hag]
	g=d.initializeGame(w, cardlist, s)
	for i in xrange(10):
		if d.isGameOver(g):
			break
		d.buyCard(random.choice(cardlist),g)
		d.playCard(len(g.hand[g.whoseTurn])-1,random.randrange(0,len(g.hand[g.whoseTurn])-1),random.choice(cardlist),random.choice(cardlist),g)
		d.endTurn(g)
	return g



@pytest.mark.parametrize("x",[2,3,4])
@pytest.mark.randomize(c=int,min_num=7, max_num=16)
def test_buyCard(x,c):
	g=d.initializeGame(x, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall,d.mine], 2)
		
	if g.numBuys<1 or g.supplyCount[c]==0 or g.coins<d.getCost(c):
		assert d.buyCard(c, g)==-1
	else:
		assert d.buyCard(c, g)==0

		
		
		

@pytest.mark.parametrize("x",[2,3,4])
@pytest.mark.parametrize("s",[2,3,4,5,6,7,8])
@pytest.mark.randomize(l=list_of(int, items=10),min_num=7, max_num=16)	
def test_initialzeGame(x,l,s):
	g=d.initializeGame(x,l,s)
	if len(l)==len(set(l)):
		assert g==-1


@pytest.mark.parametrize("x",[2,3,4])
@pytest.mark.randomize(s=int,min_num=1, max_num=9)
def test_initialzeGame_2(s,x):
	g=d.initializeGame(x, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall,d.mine], s)
	assert isinstance(g,d.gameState)
	if x==2:
		supply={d.curse:10,d.estate:8,d.duchy:8,d.province:8,d.copper:46,d.silver:40,d.gold:30,d.adventurer:10,d.ambassador:10,d.baron:10,d.council_room:10, d.cutpurse:10,d.embargo:10, d.feast:10, d.gardens:8, d.great_hall:8, d.mine:10}
		assert supply==g.supplyCount
	if x==3:
		supply={d.curse:20,d.estate:12,d.duchy:12,d.province:12,d.copper:39,d.silver:40,d.gold:30,d.adventurer:10,d.ambassador:10,d.baron:10,d.council_room:10, d.cutpurse:10,d.embargo:10, d.feast:10, d.gardens:12, d.great_hall:12, d.mine:10}
		assert supply==g.supplyCount
	if x==4:
		supply={d.curse:30,d.estate:12,d.duchy:12,d.province:12,d.copper:32,d.silver:40,d.gold:30,d.adventurer:10,d.ambassador:10,d.baron:10,d.council_room:10, d.cutpurse:10,d.embargo:10, d.feast:10, d.gardens:12, d.great_hall:12, d.mine:10}
		assert supply==g.supplyCount
		
		
		
# @pytest.mark.parametrize("x",[2,3,4])		
# @pytest.mark.randomize(("c1", "int"),("c2", "int"),("c3", "int"),("c4", "int"),("c5", "int"),("c6", "int"),("c7", "int"),("c8", "int"),("c9", "int"),("c10", "int"),("c11", "int"),min_num=0, max_num=10)		
# def test_isGameOver(x,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11):
	# g=d.initializeGame(x, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            # d.embargo, d.feast, d.gardens, d.great_hall,d.mine], 2)
	# g.supplyCount[7]=c1
	# g.supplyCount[8]=c2
	# g.supplyCount[9]=c3
	# g.supplyCount[10]=c4
	# g.supplyCount[11]=c5
	# g.supplyCount[12]=c6
	# g.supplyCount[13]=c7
	# g.supplyCount[14]=c8
	# g.supplyCount[15]=c9
	# g.supplyCount[16]=c10
	# g.supplyCount[3]=c11
	# count=0
	# for i in xrange(10):
		# exec('if c%s==0:count=count+1')
	
	# if g.supplyCount[d.province]==0:
		# assert d.isGameOver(g)==1
	
	# elif count>=3:
		# assert d.isGameOver(g)==1
	# else:
		# assert d.isGameOver(g)==0
		
		
		

@pytest.mark.randomize(s=int,min_num=2, max_num=4)		
def test_isGameOver(s):
	g=d.initializeGame(s, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                             d.embargo, d.feast, d.gardens, d.great_hall,d.mine], 2)
	for i in xrange(7,17):
		g.supplyCount[i]=random.randrange(0,10)
	g.supplyCount[3]=random.randrange(0,10)
	count=0
	for i in xrange(7,17):
		if g.supplyCount[i]==0:
			count=count+1
	if g.supplyCount[3]==0:
		assert d.isGameOver(g)==1
	elif count>=3:
		assert d.isGameOver(g)==1
	else:
		assert d.isGameOver(g)==0
	

		

@pytest.mark.randomize(s=int,min_num=2, max_num=4)	
def test_endTurn(s):
	g=d.initializeGame(s, [d.adventurer, d.ambassador, d.baron, d.council_room, d.cutpurse,
                            d.embargo, d.feast, d.gardens, d.great_hall,d.mine], 2)
	n=random.randrange(0,s)
	g.whoseTurn=n
	r=d.endTurn(g)
	if r==0:
		assert g.whoseTurn!=n
	
@pytest.mark.randomize(s=int,w=int,min_num=2, max_num=4)	
def test_getWinners(s,w):
	g=random_GameState(w,s)
	r=d.getWinners(g)
	assert len(r)==w

@pytest.mark.parametrize("x",[2,3,4])
@pytest.mark.parametrize("s",[2,3,4,5])	
@pytest.mark.randomize(c=int,min_num=7, max_num=16,ncalls=100)		
def test_playCard(c,x,s):
	g=random_GameState(x,s)
	g2=random_GameState2(x,s)
	#c=d.mine
	if c==d.adventurer:
		g.hand[g.whoseTurn].insert(0,d.adventurer)
		r=d.playCard(0,-1,-1,-1,g)
		assert r==0
		assert g.hand[g.whoseTurn].pop() in (d.copper,d.silver,d.gold)
	elif c==d.ambassador:
		pass
	if c==d.baron:
		g.hand[g.whoseTurn].insert(0,d.baron)
		c1=random.randrange(1,len(g.hand[g.whoseTurn])-1)
		h1=g.hand[g.whoseTurn][c1]
		c2=random.randrange(-1,1)
		r=d.playCard(0,c1,c2,-1,g)
		if h1==d.estate and c2==0:
			assert r==0
		elif c2==-1:
			assert r==0
		else:
			assert r==-1
	elif c==d.council_room:
		h=len(g.hand[g.whoseTurn])
		g.hand[g.whoseTurn].insert(0,d.council_room)
		r=d.playCard(0,-1,-1,-1,g)
		assert r==0
		assert len(g.hand[g.whoseTurn])==h+4
	elif c==d.cutpurse:
		g.hand[g.whoseTurn].insert(0,d.cutpurse)
		r=d.playCard(0,-1,-1,-1,g)
		assert r==0
	elif c==d.embargo:
		g.hand[g.whoseTurn].insert(0,d.embargo)
		ct=random.randrange(7,17)
		nt=g.embargoTokens[ct]
		r=d.playCard(0,ct,-1,-1,g)
		assert r==0
		assert g.embargoTokens[ct]==nt+1
	elif c==d.feast:
		g.hand[g.whoseTurn].insert(0,d.feast)
		ch1=random.randrange(7,17)
		r=d.playCard(0,ch1,-1,-1,g)
		if d.getCost(ch1)<6:
			assert r==0
		else:
			assert r==-1
	elif c==d.great_hall:
		g.hand[g.whoseTurn].insert(0,d.great_hall)
		h=len(g.hand[g.whoseTurn])
		a=g.numActions
		r=d.playCard(0,-1,-1,-1,g)
		assert r==0
		assert len(g.hand[g.whoseTurn])==h
		assert g.numActions==a
	elif c==d.mine:
		g.hand[g.whoseTurn].insert(0,d.mine)
		ch1=random.randrange(1,len(g.hand[g.whoseTurn]))
		h1=g.hand[g.whoseTurn][ch1]
		ch2=random.randrange(4,7)
		r=d.playCard(0,ch1,ch2,-1,g)
		if h1==d.copper and ch2==d.silver:
			assert r==0
		elif (h1==d.silver or h1==d.gold) and ch2==d.gold:
			assert r==0
		else:
			assert r==-1
	elif c==d.smithy: #test for backup action cards, so use g2
		h=len(g2.hand[g2.whoseTurn])
		g2.hand[g2.whoseTurn].insert(0,d.smithy)
		r=d.playCard(0,-1,-1,-1,g2)
		assert r==0
		assert len(g2.hand[g2.whoseTurn])==h+3
	elif c==d.village:
		h=len(g2.hand[g2.whoseTurn])
		a=g2.numActions
		g2.hand[g2.whoseTurn].insert(0,d.village)
		r=d.playCard(0,-1,-1,-1,g2)
		assert r==0
		assert len(g2.hand[g2.whoseTurn])==h+1
		assert g2.numActions==a+2
	elif c==d.sea_hag:
		g2.hand[g2.whoseTurn].insert(0,d.sea_hag)
		r=d.playCard(0,-1,-1,-1)
		assert r==0
		for player in range(g2.players):
			if player != g2.whoseTurn:
				assert g2.deck[player].pop()==d.curse
	else:
		pass
		