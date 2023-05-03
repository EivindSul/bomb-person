<h1>Manual Map testing</h1>
<p>
Since we use Tiled to create and update the map this is impossible 
to test, so we have done some manual tests to make sure the map does, 
what we expect from it.
</p>

<h3>Random generating</h3>

<p>This test is done by restarting the over some times and confirmed the 
map change some for each time </p>

<h3>Map size</h3>

<p>The map size is supposed to be the same for each time the
game is started and i supposed to be 27x27, after counting the the
border this is correct</p>

<h3>Bricks are breakable by bombs, not walls</h3>

<p>This is tested by dropping bombs both beside bricks and walls
around the map, and the behaviour is as expected</p>

<h3>Power ups appear at random and can be picked up</h3>

<p>Power ups is supposed to appear 1/4 of the times a brick is broken
by playing the game this looks correct. The power ups change the behaviour 
for the player aswell and dissaper when  picked up as it is suppesed to</p>