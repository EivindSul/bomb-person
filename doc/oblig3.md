<h1>Referat 7 (29.03.2023)</h1>
<h2>Hvem som var tilstede</h2>
    <p>Alle var tilstede</p>
<h2>Hva dere diskuterte</h2>
    <p> Noe av hva vi diskuterte idag
        <ul>
            <li>Vi prøver å finne ut hvorfor bombe funksjonen har en bug</li>
            <li>Vi må prøve å finne ut hvordan vi skal drepe spillerne</li>
            <li>Vi trenger animations for player</li>
            <li>Filosofi</li>
            <li>Generelt finne og fikse bugs</li>
            <li>Vi har en del bugs : movement bug, bomb bug</li>
        </ul>
    </p>
    <p>Det er flere ting i koden som må refraktures, blant annet : </p>
    <ul>
        <li>Alt som handler om bomber bør skje i player</li>
        <li>Player</li>
        <li>Model</li>
    </ul>
<h2>Hvilke avgjørelser dere tok</h2>
    <p>Vi skal utvide kontrolleren til et interface. Vi overider selveste metoden som tar input, slik kan vi bruke flere knapper på keyboardet for å oppnå multiplayer</p>
    <p></p>
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
    <p>players bomber skal ligge i player package</p>
    <p>bugs som er blitt diskutert i dette refeatet</p>
    <p>better player texture and better player sprite</p>

<h1>Referat 8 (11.04.2023)</h1>
<h2>Hvem som var tilstede</h2>
    <p>Sebastian,Eivind,Kjell,Jackie,Brian</p>
<h2>Hva dere diskuterte</h2>
    <p> Noe av hva vi diskuterte idag
        <ul>
            <li>Diskuterte og fikset bombe bug</li>
            <li>Hva som er igjen</li>
            <li>Merging i form av staging branch</li>
            <li>Diskuterte refractoring av koden</li>
            <li>Bruken av plantuml</li>
        </ul>
    </p>
    <p>Det er flere ting i koden som må refraktures, dette vil bli tatt opp senere </p>
<h2>Hvilke avgjørelser dere tok</h2>
    <p>Begynt på powerups</p>
    <p>Enighet om refractoring</p>
    <p>Droppe det fine kunstverket tegnet av micheal kjellango(kjell) og heller bruke sprites fra denne <a href="https://www.spriters-resource.com/fullview/7943/">nettsiden</a> </p>
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
    <p>Planlagt møte i morgen, vil derfor ikke stadfeste noe som skal gjøres. Men i morgen og fremover til oblig3 innlevering 14.04.2023 blir vi enig om å jobbe med :
    powerups,
    to players,
    drepe players.
    Markere dette som innlevering, og begynne på enventuell refractoring. Refractoring er ikke enda diskutert med alle og det vil bli nødvenig å gå grundig gjennom dette.
    </p>

<h1>Referat 9 (12.04.2023)</h1>
<h2>Hvem som var tilstede</h2>
    <p>Alle</p>
<h2>Hva dere diskuterte</h2>
    <p> Noe av hva vi diskuterte idag
        <ul>
            <li>Hvordan refrakturere collision inn i model</li>
            <li>Death i model</li>
        </ul>
    </p>
<h2>Hvilke avgjørelser dere tok</h2>
<p>Collision bør bli refractoret</p>
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
<p>Planlagt møte i morgen, vil derfor ikke stadfeste noe som skal gjøres. Men i morgen og fremover til oblig3 innlevering 14.04.2023 blir vi enig om å jobbe med :
    powerups,
    to players,
    drepe players.
    </p>

<h1>Referat 10 (13.04.2023)</h1>
<h2>Hvem som var tilstede</h2>
    <p>Alle</p>
<h2>Hva dere diskuterte</h2>
    <p> Noe av hva vi diskuterte idag
        <ul>
            <li>Player deaths og bombene til tiles</li>
            <li>To players er nå inne i spillet</li>
            <li>Collision er refractoret</li>
        </ul>
    </p>
<h2>Hvilke avgjørelser dere tok</h2>
<p>Bomben,Eksplosjoner og powerups skal være en TileObject</p>
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
<p>Planlagt møte i morgen, vil derfor ikke stadfeste noe som skal gjøres. Men i morgen og fremover til oblig3 innlevering 14.04.2023 blir vi enig om å jobbe med :
    Merge alt vi trenger til innleveringen (oblig 3)
    Fikse små ting og bugs.
    Få inn noen flere tester.
    </p>


<h1>Referat 11 (14.04.2023)</h1>
<h2>Hvem som var tilstede</h2>
    <p>Alle</p>
<h2>Hva dere diskuterte</h2>
    <p> Noe av hva vi diskuterte i dag:
        <ul>
            <li> Implementasjonen av power-ups</li>
            <li> Mulige tester, (mockito til å teste map)</li>
            <li> Merging </li>
        </ul>
    </p>
<h2>Hvilke avgjørelser dere tok</h2>
<p> <ul>
        <li> Merging fra work branch til main branch. </li>
        <li> Fjerne/slette duplikatkoder og koder som ikke brukes. </li>
    </ul> </p>
<h2>Hva dere ble enige om å gjøre til neste gang</h2> 
    <ul>
        <li> Se på mulige implementasjoner av musikk, lydeffekter og andre effekter </li>
        <li> Design på sluttproduktet. </li>
        <li> Flere tester. </li>
        <li> Dokumentasjon av kodebiter. </li>
    </ul>


<h1> Prosjektrapport </h1>
    <p> Etter endringen etter oblig 2 har vi ikke hatt noen spesifikke roller. Det virket bedre at alle hadde den samme rollen (utvikler) og det var lettere for oss til å diskutere og planlegge ting sammen. </p>
    <p> Gruppedynamikken har vært litt rotetet. Siden vi vi har alle hatt noen obliger og innleveringer i andre emner slik at det ble nesten ingen møter før påsken. Vi har hatt en del møter etter påskeferien der vi nesten alle i gruppa har møtt opp på. Kommunikasjonen har vært grei, blant annet planlegging over Discord og hvordan vi skulle jobbe når vi skulle treffes fysisk.</p>
    <p> Igjen, var det litt ujevnt med hvor mye folk i gruppa har commit, siden i denne obligen har det vært mer fokus på finne løsninger på de få 'feature' så gikk det mer ut på å finne de riktige løsningene. Dette ledet til at oppgavene var likt fordelt, men istedenfor var det mange som jobbet på mulig løsninger for de samme oppgavene. </p>
    <p> Neste forbedringspunkter kan være å ha noen tidlige møter før en innlevering. Vi merket i denne obligen så hadde vi nesten alle møtene i samme uke som den obligen skal inn, det skyldtes også at vi hadde påskeferien. </p>


## Krav og Spesifikasjon:
Vi ønsker først å sette opp selve brettet og "hindringene" som skal være på det samt at man kolliderer med hindringene, lage modeller og kontroller for spillere og bomber, samt å sette opp "screens" for selve spillet, main-menu og game-over. Til slutt vil vi jobbe ut at spillet slutter når det bare er en spiller som står igjen.


Målet vårt for denne obligen var å gjøre ferdig de siste punktene som vi hadde som MVP i oblig1.md og oblig2.md: 


*Bomben kan ødelegge veggene, men ikke murene: Gjort*

* Brukerhistorie: Som spiller vil jeg at bomben skal kunne ødelegge vegger men ikke murer, slik at spillet er balansert og utfordrende.
* Akseptansekriterie: Bomben skal kunne ødelegge vegger men ikke murer, og grafikken for murer skal forbli intakt etter eksplosjonen.
* Arbeidsoppgave: Legg til funksjonalitet får å ødelegge vegger, og sørge for at murer ikke blir påvirket av eksplosjonen.

*Eksplosjonen går ikke i gjennom murene/veggene: Gjort*

* Brukerhistorie: Som spiller vil jeg at eksplosjonen fra bomben ikke skal kunne passere gjennom murer eller vegger, slik at spillet er balansert og utfordrende.
* Akseptansekriterie: Eksplosjonen skal stoppe ved vegger og murer, og ikke passere gjennom dem.
* Arbeidsoppgave: Legg til kollisjonsdeteksjon for eksplosjonen, og sørge for at den ikke går gjennom murer eller vegger.

*En spiller dør når den blir sprengt av en bombe: Gjort*

* Brukerhistorie: Som spiller vil jeg at min spiller skal dø når den blir truffet av en eksplosjon fra en bombe, slik at jeg kan spille videre eller starte på nytt.
* Akseptansekriterie: hvis en spiller blir truffet an en eksplosjon fra en bombe, skal spilleren dø og spillet skal gi beskjed om at spilleren er eliminert.
* Arbeidsoppgave: Legg til kollisjonsdeteksjon for spilleren og eksplosjonen, og legg til funksjonalitet for å gi beskjed om at spilleren er eliminert.

*Mål for spillet: "Be the last man standing": Gjort*

* Brukerhistorie: Som spiller vil jeg at målet for spillet skal være å være den siste spilleren som står igjen på spillebrettet, slik at jeg prøve å vinne spillet.
* Akseptansekriterie: Spillet skal fortsette til det bare er en spiller igjen på spillebrettet, og spilleren som er igjen skal være vinneren.
* Arbeidsoppgave: Legg til funksjonalitet får å sjekke om det er mer enn èn spiller igjen på spillebrettet, og gi beskjed om hvem som er vinneren når spillet er ferdig.

*Vise spillerne (2 spillere, lokal multiplayer): Gjort*

* Brukerhistorie: Som spiller vil jeg kunne se to spillere i spillet, slik at jeg kan se min egen spiller og motstanderen min.
* Akseptansekriterie: To spillere skal kunne være synlig samtidig på skjermen, og det skal være tydelig hvilken spillere som tilhører hvilken kontroller.
* Arbeidsoppgave: Legg til grafikk for spillerene, og legg til funksjonalitet får å vise og håndtere to spillere samtidig.

*Powerups (flere bomber, Større eksplosjonsradius og raskere spiller): Delvis Gjort*
* Brukerhistorie: Som spiller vil jeg ha en fremgang som kan gjøre det lettere å ta ut den andre spilleren ved hjelp av power-ups.
* Akseptansekriterie: Powerups skal kunne være synlig og gi en 'booster' effekt til spilleren som plukker opp power-ups. 
* Arbeidsoppgave: Implementere funksjonalitet for at knuselige murer kan droppe en power-up. I tillegg til at den power-up skal virke etter at en spiller plukker power-up.   

## Kode seksjon

<p>I denne obligen gikk mer ut på å implementere de siste spillbare funksjonene og refaktoring av koden var en ting vi fokuserte mest på. Vi klart å refaktorere ut modelklassen slik at vi får delt opp slik at vi har flere klasser som gjør en spesiell ting. Dette hjelper oss med å følge prinsipper som f.eks. SOLID-prinsippet. Fra oblig 2 hadde vi også mye kode funksjonalitet hos Player-klassen som vi kunne ha delt opp litt mer. Blant annet har vi trukket ut collision ut fra player slik at vi har en egen klasse fra det. </p>
<p>Manuelle tester for screens:</p>
<p>Disse testene er hovedsakelig visuelle og går på å sjekke at alt er på plass og at knappene leder til rette screens eller ut av spillet.</p>

<p>Main-menu: Skal dukke opp når spillet startes, skal inneholde tittelen til spillet og tre knapper, «New game»,  «Settings» og «Exit game». Den første skal starte spillet, vise brettet og spillerne. Den andre skal lede til regel-skjermen, denne skal ha kontroller for spillerne samt informasjon om typene vegger og bomber, samt en knapp som leder tilbake til main-menu. Den tredje skal rett å slett gå ut av spillet og ta ned vinduet. </p>
<p>Game-over screen: Kan kommes til ved at en av spillerne blir slått ut, eller hvis man trykker Q. Skal stå «game over» som tittel samt tre knapper, «New game», «Main menu» og «Exit game», dette skal: 1. Starte et nytt spill. 2. Gå til main-menu. 3. Gå ut av spillet.</p>