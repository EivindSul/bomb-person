<h1>Manuelle Map tester</h1>
<p>Siden vi brukte tiled til å lage og oppdatere mappet ble dette umulig  
å teste, så derfor har vi valgt å lage noen manuelle tester for denne klassen, 
for å se at mappet gjør som forventet</p>


<h3>Tilfeldig Map</h3>
<p>Denne testen ble gjort ved å starte spillet flere ganger for å vit at
mappet faktisk endrer seg for hver gang, og det gjør det.</p>




<h3>Størrelse på mappet</h3>
<p>Størrelsen på mappet skal være likt for hver gang spillet starter,
det skal være 27x27, etter å ha telt antall tiles på kanten stemmer dette</p>


<h3>Player kan slippe bomber</h3>
<p>Bombene er en del av mappet, og bombene skal dukke opp når player1 trykker
på mellomrom og player2 trykker på enter, denne funksjonen fungere som forventet</p>


<h3>Bricks kan ødelegges men ikke walls</h3>
<p>Denne testen er gjort ved  å slippe bomber ved siden av både bricks og wall
og funksjonaliteten er som den skal</p>

<h3>Power ups dukker opp  tilfeldig når bricks ødelegges</h3>
<p>Power ups skal dukke opp 1/4 av gangene en brick  ødelegges, og av å spille
spillet en del ganger ser denne funksjonaliteten til å være  sånn den skal. I tillegg
endrer power upsene hvordan en spiller oppfører seg</p>

<h1>Manuelle tester for screens:</h1>
<p>Disse testene er hovedsakelig visuelle og går på å sjekke at alt er på plass 
og at knappene leder til rette screens eller ut av spillet.</p>

<p>Main-menu: Skal dukke opp når spillet startes, skal inneholde tittelen til spillet 
og tre knapper, «New game»,  «Settings» og «Exit game». Den første skal starte spillet, 
vise brettet og spillerne. Den andre skal lede til regel-skjermen, denne skal ha kontroller 
for spillerne samt informasjon om typene vegger og bomber, samt en knapp som leder tilbake til 
main-menu. Den tredje skal rett å slett gå ut av spillet og ta ned vinduet. </p>


<p>Game-over screen: Kan kommes til ved at en av spillerne blir slått ut, eller hvis man 
trykker Q. Skal stå «game over» som tittel samt tre knapper, «New game», «Main menu» og «Exit game», 
dette skal: 1. Starte et nytt spill. 2. Gå til main-menu. 3. Gå ut av spillet.</p>
