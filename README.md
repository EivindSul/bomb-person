# INF112 Project – *Bomberman*

* Team: *Blasters* (Gruppe 8): *Brian Jensvoll-Jorgensen, Dorcas Mihio, Eivind Sulen, Jackie Zhang, Kjell Grytting, Sebastian Matthews*
* Lenke til Trello: [Trello lenke](https://trello.com/w/blasters8).
## Roller:
* **Eivind Sulen**: Utvikler
* **Dorcas Mihio**: Utvikler
* **Sebastian Matthews**: Kundekontakt, Utvikler
* **Jackie Zhang**: Utvikler
* **Kjell Grytting**: Utvikler
* **Brian Jensvoll-Jorgensen**: Utvikler
 
## Om spillet
* Et plass hvor det sprenges og ødeleggelse av området ved hjelp av bomber. Målet er å være den eneste som står igjen på brettet. Du er ikke alene det er en annen spiller som også er her. Hvem kommer til å vinne?
<a href="doc\assets\ClassDiagram2.png">Klasse diagram for spill</a>
<a href="https://lucid.app/lucidchart/f14609ae-0436-4114-be3e-44bea107c7d8/edit?viewport_loc=-2601%2C-103%2C3982%2C2227%2C0_0&invitationId=inv_e2e85f81-6baa-4527-95c4-17773a7c75f0">link til klassediagram</a>

## Kjøring
* kjør spillet med `java -jar ./target/bomberman-1-fat.jar` i terminalen
* Krever libgdx version 1.11.0 eller nyere
* Krever Java 17

## Graphics
<a href="https://poloviiinkin.itch.io/textures?download">lenke for tileset uten egne tegninger</a> <br>
<a href="https://www.spriters-resource.com/fullview/7943/"> Sprite sheet av player. </a> <br>

Resten av bildene fra spillet er selv laget og er åpent for bruk. 

## Sound
Alle lydeffektene i spillet har blitt hentet fra Zapsplat. <br>

<a href="https://www.zapsplat.com/music/small-dying-monster-screech-in-pain-3/"> Når spilleren dør. </a> <br>
<a href="https://www.zapsplat.com/music/designed-huge-fireball-bomb-or-explosion-5/"> Når bomben eksploderes. </a> <br>
<a href="https://www.zapsplat.com/music/barefoot-footsteps-on-small-stones/"> Når spilleren beveger seg. </a> <br>
<a href="https://www.zapsplat.com/music/2x-rucksacks-drop-2/"> Når en bombe droppes. </a> <br>
<a href="https://www.zapsplat.com/music/small-hand-bell-short-ring-3/"> Plukker opp powerups. </a> <br>
<a href="https://www.zapsplat.com/music/clock-watch-or-timer-ticking/"> Tikkelyd fra bomben. </a> <br>


# INF112 libGDX + Maven template 
Simple skeleton with [libGDX](https://libgdx.com/). 

# ~~Known problems~~

~~On Mac OS X:~~

* ~~The application won't start without giving the JVM the `-XstartOnFirstThread` option. In Eclipse, you can set this up with *Run → Run Configurations...*, then choosing the *Arguments* tab and adding `-XstartOnFirstThread` to *VM argument*. [Check this screenshot.](https://git.app.uib.no/inf112/22v/lectures/-/raw/master/img/eclipse-vm-args.png)~~

* ~~On Macs with the M1 processor, a newer version of libgdx is needed. The Maven [`pom.xml`](pom.xml) file has been set up to use version `1.10.1-SNAPSHOT` automatically.~~