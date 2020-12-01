import dominion_p as d
import buyCard_rand as b
import drawCard_rand as d
import getWinners_rand as g
import isGameOver_rand as i
import playCard_rand as p
import random
import time

MAX_TEST=2000

start = time.time()

for a in range(MAX_TEST):
	switch=random.randrange(0,5)
	if switch==0:
		b.buyCardTest()
	if switch==1:
		d.drawCardTest()
	if switch==2:
		g.getWinnersTest()
	if switch==3:
		i.isGameOverTest()
	if switch==4:
		p.playCardTest()
		
elapsed = time.time()-start
print elapsed