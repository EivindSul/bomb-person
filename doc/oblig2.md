<h1> Referat 1 (20.03.2023-24.03.2023) </h1>

<h2>Hvem som var tilstede</h2>
<p> Alle var tilstede på discord </p>
<h2>Hva dere diskuterte</h2>
<p> Diskuterte om vi skulle møte eller ikke </p>
<p> Diskuterte prosjektet.  </p>
<p> Diskuterte dersom alle hadde lært seg basic ligGDX så vil det bli enklere å begynne å dele ut individuelle oppgaver. </p>
<h2>Hvilke avgjørelser dere tok</h2>
<p> Ble enig om å ikke møte for å heller jobbe med oblig i et annet fag. </p>
<p> Ble enig om å ikke møte for å lære oss libGDX </p>
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
<p>lære oss libGDX til neste møte </p>


<h1> Referat 2 (01.03.2023) </h1>

<h2>Hvem som var tilstede </h2>
<p> Sebastian,Dorcas,Kjell,Brian,Jackie
<h2>Hva dere diskuterte </h2>
<p> Diskuterte libGDX struktur og så på forskjellige implementasjoner av denne
<p> Diskuterte tileMap
<p> Diskuterte branches og hvordan vi ville ha den generelle strukturen på disse
<h2>Hvilke avgjørelser dere tok </h2>
<p> Gjorde avgjørelsen å heller bruke tileMap istedet for egenlagt grid
<p> Gjorde avgjørelsen å slette en del branches som ikke var nødvendig lengre
<h2>Hva dere ble enige om å gjøre til neste gang </h2>
<p>Ble enige om å lære oss tileMap og libGDX videre</p>


<h1>Referat 3 (02.03.2023) </h1>

<h2>Hvem som var tilstede </h2>
<p> Alle var tilstede</p>
<h2>Hva dere diskuterte </h2>
<p> Diskuterte forståelse av tilemap samt libGDX. </p>
<p> Så på forskjellige .TMX maps, dette er maps som kan lages i et eget program "tiled" https://www.mapeditor.org/</p>
<p> Diskuterte gruppe struktur</p>
<p>
Diskuterte UML diagram for MVP link finnes her :
<a href= "https://lucid.app/lucidchart/f14609ae-0436-4114-be3e-44bea107c7d8/edit?viewport_loc=-459%2C-342%2C2368%2C1366%2C0_0&invitationId=inv_e2e85f81-6baa-4527-95c4-17773a7c75f0"> UML Diagram</a>
</p>
<img src="assets/BasicUML.png" width="500" title="hover text">
<p> Diskuterte plan for implimentering av MVP </p>
<h2>Hvilke avgjørelser dere tok </h2>
<p> Vi droppet gruppeleder struktur, beholdt kundeveileder </p>
<p> Vi ble enig om å begynne med implementasjon av klasser rundt model, så binder vi alt sammen ved neste møte. </p>
<h2>Hva dere ble enige om å gjøre til neste gang </h2>
<p> Brian : MenuScreen </p>
<p> Sebastian : GameScreen/Model </p>
<p> Jackie : Controller</p>
<p> Eivind : Player/Bomb </p>
<p> Kjell, Dorcas : MapAssets </p>

<h1>Referat 4</h1>

<h2>Hvem som var tilstede</h2>
<p>Sebastian,Dorcas,Kjell,Brian,Jackie,Eivind</p>
<h2>Hva dere diskuterte</h2>
<p>
Det er nå flere forskjellige branches som ikke fungerer sammen, men med forskjellig funksjonalitet som er ønskelig å implimentere. Hvordan skal vi sette dette sammen?
</p>
<p><b>Hvordan skal vi sette alt sammen</b></p>
<p>Sletter grid</p>
<p>Sletter view</p>
<p>Legge inn map i model? for mvp</p>
<p>Diskuterte player og bombe</p>
<h2>Hvilken avgjørelser dere tok</h2>
<p>Player slipper bombe i en egen liste klasse</p>
<p>Vi lager en merger branch som skal binde alt sammen<p>
<p>Vi sletter view,music og grid i merger branch
<h2>Hva dere ble enig om å gjøre til neste gang</h2>
<p>Eivind jobber med bomben og player</p>
<p>Dorcas jobber med collision</p>
<p>Sebastian jobber med collision</p>
<p>Brian jobber med Game Over screen</p>
<p>Jackie jobber med documentation</p>

<h1> Referat 5 (09.03.2023)</h1>

<h2> Hvem som var til stedet: </h2>
    <p> Alle var tilstede, noen kom litt før, mens andre kom litt senere.</p>
<h2>Hva dere diskuterte </h2>
    <p> Vi har diskutert om collision og hva som mangler fra collision. </p>
    <p> Diskuterte om vi trengte ett møte til i morgen før fristen på oblig 2 skal leveres inn</p>
<h2>Hvilke avgjørelser dere tok </h2>
    <p> Vi avtalte å ha et møte til i morgen. </p>
    <p> Endret at collision og kontrolleren skal ligge inne i player klassen. </p>
<h2>Hva dere ble enige om å gjøre til neste gang </h2>
    Neste møte vil være i morgen. Vi må alle møte opp for merging og sette sammen mvp før vi leverer oblig 2.

<h1> Referat 6 (10.03.2023)</h1>

<h2> Hvem som var til stedet: </h2>
    <p>Alle var tilstede<p>
<h2>Hva dere diskuterte </h2>
    <p>MVP kanskje for stort</p>
    <p>Implimentering av Dorcas sin brilliante løsning på collision<p>
    <p>Contoller må bli flyttet for kjapp implementasjon av collision, dette fører også til at controller er nødt til å endres til en InputProsessor</p>
    <p>Eivind sin implementasjon av player og bombe og hvordan denne skal implimenteres med resten av koden</p>
    <p>Dorcas og Jackie : collison hadde et problem der visst player beveger seg oppover samtidig til siden vil den stå fast når den treffer en vegg. Det var også et problem med mappet, player sin sprite kan clippe in i en solid tile dette var fordi vi ikke klarte å hente ut rikgige layers når det kom til kollisjon, vi løste dette med å minke player til 14 x 14px og collisionet med null istedet for layer</p>
    <p> Diskuterte UML diagram og dens oppdatering</p>
    <p> Diskutert alle branchesene som har blitt laget for test implementering. Vi bruker branchesene for å stage merging in i hverandres   branches.
    Følgene merges/viktige push har skjedd:
    Dorcas sin fungerende løsning på collision -> merger
    Game over screen (Brian) -> merger
    Oblig2 gjort av Jackie og Brian ->(pushet) Merger
    Eivind sine løsninger på bomber og player -> BombMerger(staging branch for eivind)
    Eivind sin staging branch -> merger
    </p>

<h2>Hvilke avgjørelser dere tok </h2>
    <p>avgjorde at mvp er litt for ambisiøst</p>
    Controller nå en inputprossesor istedet for en klasse, men funksjonalitet nesten det samme, Setter controller som InputProssesor i model.
    Player collision skjer i player ikke i model som før.
    Player bruker velocity for movement, og setter X og Y ved bruk av denne.
    Eivind sin player branch konverterte til Dorcas sin player branch posisjon struktur(getX()getY() i motsettning til en vector)
<h2>Hva dere ble enige om å gjøre til neste gang </h2>
    <p>Gjøre de siste punktene på MVP + Tester som mangler</p>

<h1> Prosjektrapport </h1>
    <p> Etter alle møtene etter oblig1 har vi merket at rollefordeling var bedre med uten en teamleder eller en nestleder ettersom at alle tar lik ansvar for prosjektet.
Vi vil ikke endre på noen rolle, men vi vil unngå å ha en teamleder og en nestleder. Vi vil fremdeles beholde kundekontakt som Sebastian har fortsatt lyst til å være. 
</p>
    <p> Noen roller som vi vil inkludere er en person som tar for seg ansvaret til å legge til en tag for oblig innleveringen (Eivind) og en som tar ansvar for å merge alle branchene sammen slik at vi har kontroll på hovedgrenen i main.</p>
    <p> Vi har fordelt oppgavene slik at vi jobber/programmerer hver for oss i en egen klasse i fritiden siden det gjør det lettere å ikke overskrive andres koder. </p>
    <p> Gruppedynamikken var grei. Vi sørget for at alle i gruppa hadde noe å gjøre til neste møte. Dette gjorde vi ved å planlegge på slutten av hvert møte. </p>
    <p> Kommunikasjonen mellom oss har vært både og. Gjennom discord har det gått relativt fint. Alle i gruppa er aktiv på discord og svarer i løpet av dagen. Den fysiske kommunikasjon har vært veldig bra. Det var lettere å komme til enighet når vi skulle samarbeide fysisk. </p>
    <p> Til nå har vi klart å lage en strukturert struktur (Model, view, controller) som har de fleste funksjonene som vi har klart å implementert. Vi har klart å implementert et grid ved hjelp av tilemap, kontroller, en model som er "kjernen" som binder de fleste klassene sammen. Vi har også klart å implementere en mainscreen, gamescreen og gameoverscreen. </p>
    <p> Alle har vært med å bidra til å skrive og commitet kodebase i prosjektet, men det har vært noen ujevnheter. Siden vi er 6 personer i gruppen, så var fordeling av hva/hvem som skulle gjøre hva ga en litt utfordring. Noen jobbet sammen i par slik at den ene personen fikk flere commit enn den andre, mens noen som jobbet med en ting var avhengig av den andre personen. Et eksempel er at Kjell har ikke commit så mye i oblig 2, fordi han har jobbet sammen med andre og de andre i gruppa og har commitet. </p>
    <p> Tre forbedringspunkter som vi må bli bedre til å følge: Møte opp på riktig tid, har vært en del møter hvor vi fleste har kommet litt sent pga. andre årsaker. </p>

## Krav og Spesifikasjon:
Vi ønsker først å sette opp selve brettet og "hindringene" som skal være på det samt at man kolliderer med hindringene, lage modeller og kontroller for spillere og bomber, samt å sette opp "screens" for selve spillet, main-menu og game-over. Til slutt vil vi jobbe ut at spillet slutter når det bare er en spiller som står igjen.


Målet vårt for denne var å jobbe oss mot MVP'et som vi hadde satt opp i oblig1.md, kravene som vi ønsket å få utført var disse:

*Vise murer (uknuselig) / vegger (knuselig): Gjort*

* Brukerhistorie: Som spiller vil jeg kunne se murer og vegger i spillet, slik at jeg kan navigere og unngå hindringer.
* Akseptansekriterie: Murer skal være synlig og ikke mulig å ødelegge, men vegger skal kunne ødelegges med en bombe.
* Arbeidsoppgave: Legge til grafikk for murer og vegger, og legg til funksjonalitet får å vise og håndtere dem.

*Flytte spiller (opp, ned, venstre, høyre): Gjort*

* Brukerhistorie: Som spiller vil jeg kunne bevege min egen spiller opp, ned, til venstre og høyre, slik at jeg kan navigere i spillet.
* Akseptansekriterie: Spilleren skal kunne bevege seg i alle fire retninger, og bevegelsen skal være jevn og responsiv.
* Arbeidsoppgave: Legg til funksjonalitet får kunne bevege spilleren.

*Spiller interagerer med terreng: Gjort*

* Brukerhistorie: Som spiller vil jeg kunne interagere med terreng, slik at jeg kan ødelegge vegger og unngå murer.
* Akseptansekriterie: Murer skal være synlig og ikke mulig å ødelegge, men vegger skal kunne ødelegges ved hjelp av en bombe.
* Arbeidsoppgave: Legg til funksjonalitet får å ødelegge vegger, og lag kollisjonsdeteksjon for å hindre spilleren i å passere gjennom murer.

*Start-skjerm ved oppstart / game over: Gjort*

* Brukerhistorie: Som spiller vil jeg at spillet skal ha en start-skjerm ved oppstart og en game over-skjerm når spillet er ferdig, slik at jeg kan starte eller avslutte spillet.
* Akseptansekriterie: Spillet skal vise en start-skjerm når det starter opp, og en game over-skjerm når spillet er ferdig. Start-skjerm skal ha en "start spill"-knapp, og game over-skjermen skal ha en "spill igjen"-knapp og en "avslutt"-knapp.
* Arbeidsoppgave: Legg til grafikk fog legg funksjonalitet for start-skjermen og game over-skjermen, og legg til funksjonalitet for knappene på begge skjermene.
* Lagt til: En ekstra screen med reglene og kontrollene til spillet.

*Spiller kan droppe en bombe: Gjort*

* Brukerhistorie: Som en spiller vil jeg kunne slippe en bombe, slik at jeg kan ødelegge vegger og eventuelt skade motstanderen min.
* Akseptansekriterie: Spilleren skal kunne slippe en bombe ved hjelp av en knapp eller tast, og bomben skal bli synlig på spillbrettet.
* Arbeidsoppgave: Legg til funksjonalitet får å slippe en bombe, og legg til grafikk for bomben.

*Bomben tar 5 sekunder før den eksploderes: Gjort*

* Brukerhistorie: Som spiller vil jeg at bomben skal ta litt tid før den eksplodere, slik at jeg har tid til å komme meg unna.
* Akseptansekriterie: Bomben skal ta 5 sekunder før den eksplodere.
* Arbeidsoppgave: Legg til funksjonalitet får å telle ned tiden før bomben eksploderer.

*Bomben kan sprenges som et kryss: Gjort*

* Brukerhistorie: Som spiller vil jeg at bomben skal kunne sprenges som et kryss, slik at jeg kan ødelegge flere vegger samtidig.
* Akseptansekriterie: Når bomben eksplodere skal den ødelegge vegger i et kryssmønster fra eksplosjonspunktet.
* Arbeidsoppgave: Legg til funksjonalitet får å sprenge bomben som et kryss, og legg til grafikk for eksplosjonen.

*Bomben kan ødelegge veggene, men ikke murene: Ikke gjort*

* Brukerhistorie: Som spiller vil jeg at bomben skal kunne ødelegge vegger men ikke murer, slik at spillet er balansert og utfordrende.
* Akseptansekriterie: Bomben skal kunne ødelegge vegger men ikke murer, og grafikken for murer skal forbli intakt etter eksplosjonen.
* Arbeidsoppgave: Legg til funksjonalitet får å ødelegge vegger, og sørge for at murer ikke blir påvirket av eksplosjonen.

*Eksplosjonen går ikke i gjennom murene/veggene: Ikke gjort*

* Brukerhistorie: Som spiller vil jeg at eksplosjonen fra bomben ikke skal kunne passere gjennom murer eller vegger, slik at spillet er balansert og utfordrende.
* Akseptansekriterie: Eksplosjonen skal stoppe ved vegger og murer, og ikke passere gjennom dem.
* Arbeidsoppgave: Legg til kollisjonsdeteksjon for eksplosjonen, og sørge for at den ikke går gjennom murer eller vegger.

*En spiller dør når den blir sprengt av en bombe: Ikke gjort*

* Brukerhistorie: Som spiller vil jeg at min spiller skal dø når den blir truffet av en eksplosjon fra en bombe, slik at jeg kan spille videre eller starte på nytt.
* Akseptansekriterie: hvis en spiller blir truffet an en eksplosjon fra en bombe, skal spilleren dø og spillet skal gi beskjed om at spilleren er eliminert.
* Arbeidsoppgave: Legg til kollisjonsdeteksjon for spilleren og eksplosjonen, og legg til funksjonalitet for å gi beskjed om at spilleren er eliminert.

*Mål for spillet: "Be the last man standing": Ikke gjort*

* Brukerhistorie: Som spiller vil jeg at målet for spillet skal være å være den siste spilleren som står igjen på spillebrettet, slik at jeg prøve å vinne spillet.
* Akseptansekriterie: Spillet skal fortsette til det bare er en spiller igjen på spillebrettet, og spilleren som er igjen skal være vinneren.
* Arbeidsoppgave: Legg til funksjonalitet får å sjekke om det er mer enn èn spiller igjen på spillebrettet, og gi beskjed om hvem som er vinneren når spillet er ferdig.
*

*Vise spillerne (2 spillere, lokal multiplayer): Delvis gjort*

* Brukerhistorie: Som spiller vil jeg kunne se to spillere i spillet, slik at jeg kan se min egen spiller og motstanderen min.
* Akseptansekriterie: To spillere skal kunne være synlig samtidig på skjermen, og det skal være tydelig hvilken spillere som tilhører hvilken kontroller.
* Arbeidsoppgave: Legg til grafikk for spillerene, og legg til funksjonalitet får å vise og håndtere to spillere samtidig.
* Vi valgte å implementere en spiller først slik at vi var sikre på at spilleren vises på brettet. Den andre spilleren vil komme senere. Eventuelt til oblig 3.

## Kode seksjon
<p> Dette har endret siden sist fra oblig1: Vi fjernet en egendefinert grid til å være en tilemap. Inndeling i package har også blitt endret slik at vi har en strukturert struktur. </p>
<p> Vi har laget et klassediagram som er en grei oversikt som vi har lagt inn i referat 3. Linken under viser også UML-diagrammet.</p>
        <a href= "https://lucid.app/lucidchart/f14609ae-0436-4114-be3e-44bea107c7d8/edit?viewport_loc=-459%2C-342%2C2368%2C1366%2C0_0&invitationId=inv_e2e85f81-6baa-4527-95c4-17773a7c75f0"> UML-diagram</a>