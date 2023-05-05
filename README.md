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
* Kompileres med `mvn package`.
<!--* Kjøres med java `-cp target/my-app-1.0-SNAPSHOT.jar com mycompany.app.App`-->
* Krever libgdx version 1.11.0 eller nyere
* Krever Java 17
* Mer info kommer..

## Graphics
<a href="https://poloviiinkin.itch.io/textures?download">lenke for tileset uten egne tegninger</a> </br>
<a href="https://www.spriters-resource.com/fullview/7943/"> Sprite sheet av player. </a> </br>

Resten av bildene fra spillet er selv laget og er åpent for bruk. 

## Sound
Alle lydeffektene i spillet har blitt hentet fra Zapsplat. </br>

<a href="https://www.zapsplat.com/music/small-dying-monster-screech-in-pain-3/"> Når spilleren dør. </a> </br>
<a href="https://www.zapsplat.com/music/designed-huge-fireball-bomb-or-explosion-5/"> Når bomben eksploderes. </a> </br>
<a href="https://www.zapsplat.com/music/barefoot-footsteps-on-small-stones/"> Når spilleren beveger seg. </a> </br>
<a href="https://www.zapsplat.com/music/2x-rucksacks-drop-2/"> Når en bombe droppes. </a> </br>
<a href="https://www.zapsplat.com/music/small-hand-bell-short-ring-3/"> Plukker opp powerups. </a> </br>
<a href="https://www.zapsplat.com/music/clock-watch-or-timer-ticking/"> Tikkelyd fra bomben. </a> </br>


# INF112 libGDX + Maven template 
Simple skeleton with [libGDX](https://libgdx.com/). 

# ~~Known problems~~

~~On Mac OS X:~~

* ~~The application won't start without giving the JVM the `-XstartOnFirstThread` option. In Eclipse, you can set this up with *Run → Run Configurations...*, then choosing the *Arguments* tab and adding `-XstartOnFirstThread` to *VM argument*. [Check this screenshot.](https://git.app.uib.no/inf112/22v/lectures/-/raw/master/img/eclipse-vm-args.png)~~

* ~~On Macs with the M1 processor, a newer version of libgdx is needed. The Maven [`pom.xml`](pom.xml) file has been set up to use version `1.10.1-SNAPSHOT` automatically.~~

# Maven Setup
This project comes with a working Maven `pom.xml` file. You should be able to import it into Eclipse using *File → Import → Maven → Existing Maven Projects* (or *Check out Maven Projects from SCM* to do Git cloning as well). You can also build the project from the command line with `mvn clean compile` and test it with `mvn clean test`.

Pay attention to these folders:
* `src/main/java` – Java source files go here (as usual for Maven) – **IMPORTANT!!** only `.java` files, no data files / assets
* `src/main/resources` – data files go here, for example in an `assets` sub-folder – **IMPORTANT!** put data files here, or they won't get included in the jar file
* `src/test/java` – JUnit tests
* `target/classes` – compiled Java class files

**TODO:** You should probably edit the `pom.xml` and fill in details such as the project `name` and `artifactId`:


```xml

	< !-- FIXME - set group id -->
	<groupId>inf112.skeleton.app</groupId>
	< !-- FIXME - set artifact name -->
	<artifactId>gdx-app</artifactId>
	<version>1.0-SNAPSHOT</version>
	<packaging>jar</packaging>

	< !-- FIXME - set app name -->
	<name>mvn-app</name>
	< !-- FIXME change it to the project's website -->
	<url>http://www.example.com</url>
```

	
## Running
You can run the project from Eclipse, or with Maven using `mvn exec:java`. Change the main class by modifying the `main.class` setting in `pom.xml`:

```
		<main.class>inf112.skeleton.app.Main</main.class>
```

## Jar Files

If you run `mvn package` you get everything bundled up into a `.jar` file + a ‘fat’ Jar file where all the necessary dependencies have been added:

* `target/NAME-VERSION.jar` – your compiled project, packaged in a JAR file
* `target/NAME-VERSION-fat.jar` – your JAR file packaged with dependencies

Run Jar files with, for example, `java -jar target/NAME-VERSION-fat.jar`.

## Git Setup
If you look at *Settings → Repository* in GitLab, you can protect branches – for example, forbid pushing to the `main` branch so everyone have to use merge requests.

## Eclipse Setup

It's usually smart to change Eclipse's Maven settings so that it'll automatically download Javadocs and the source code for your dependencies:

![Turn on Download Sources and Javadoc](https://git.app.uib.no/inf112/22v/lectures/-/raw/master/img/eclipse-maven.png)
