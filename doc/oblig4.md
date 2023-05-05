<h1>Referat 12 (21.04.2023)</h1>
<h2>Hvem som var tilstede</h2>
    <p>Sebastian, Jackie, Dorcas, Kjell, Brian, Eivind(på discord)</p>
<h2>Hva dere diskuterte</h2>
    <p>Vi tok en generell oversikt av hva vi trenger til innleveringen, vi så spesielt på punktene om "spesefikke krav". Her manglet det litt. Blant annet : 75% test covrage, en form for factory, javadoc på alle public metoder(ikke minst dem som snakker overens pakker).</p>
    <p>Ettersom det kan bli tett med tid for flere, er det viktig at vi setter <b>en</b> dag der vi møtes for å planlegge i tillegg til flere dager der vi møtes for å kode. Denne dagen (torsdag | 27.04.2023) skal vi møte for å vertfall planlegge hva som videre er nødt til å gjøres. På denne måten kan gruppen forholde seg til en dag der alt av planlegging vil bli tatt</p>
<h2>Hvilke avgjørelser dere tok</h2>
    <p>Vi skal ha begynt eller vertfall ha prøvd å løse implimenteringen av de spesefikke kravene vi mangler</p>
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
    <p>Til neste gang vil vi jobbe med å fullføre det vi mangler av spesefikke krav, det vil helt klart være ting som mangler, spesielt tester og kanskje javadoc. Dette vil da tas på torsdagen</p>
    <ul>
        <li>interaktiv lyd(Dorcas)</li>
        <li>object frabrikk(Eivind)</li>
        <li>Tester med test coverage, Headless applicationtest Sebastian og Kjell prøver.</li>
        <li>lisens og kildebruk(Sebastian,Jackie)</li>
        <li>dokumentasjon i koden i tilleg til innkapsling(Brian og Jackie)</li>
    </ul>


<h1>Referat 13 (25.04.2023)</h1>
<h2>Hvem som var tilstede</h2>
    <p>Alle var tilstede</p>
<h2>Hva dere diskuterte</h2>
    <p>Jackie tok fram et viktig poeng fra tilbakemeldingen på oblig3, det var rapportert at spillerens bevegelse ikke fungerer på linux, dette må undersøkes mer. Det ble også tatt opp at vi må ha oppdatert klassediagrammet til siste innlevering. Model var også kritisert for å være ustrukturert</p>
    <p>Det er en latency bug med bombene, dette mistenker vi har noe med kontrollerne å gjøre</p>
    <p>Facotry design patternet hadde passet best in dersom det produserte tiles. Da kan vi produsere tiles til mappet, powerups, bomber og eksplosjoner </p>
    <p>I tilbakemeldingen ble det spurt om bedre forklaring på hvordan man skal starte spillet.</p>
    <p>Brain prøvde på controller buggen vi har</p>
<h2>Hvilke avgjørelser dere tok</h2>
    <p>factorien skal ta hånd om mye av generering av bomber,eksplosjoner,osv... i model.</p>
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
    <p>Til neste gang vil vi jobbe med å implimentere det vi mangler av spesifikke krav, samt prøve å fikse noe av tilbakemeldingene vi har fått. I tillegg vil vi prøve å fikse controller bug</p>
    <ul>
        <li>uml diagram(Sebastian)</li>
        <li>se på programvare for å test(spotbugs) visst tid til overs</li>
        <li>problem med menyer på linux</li>
        <li>fikse MVC litt</li>
    </ul>
    <ul>
        <li>interaktiv lyd(Dorcas)</li>
        <li>TileFactory frabrikk(Eivind)</li>
        <li>Tester med test coverage, Headless applicationtest Sebastian og Kjell prøver.</li>
        <li>lisens og kildebruk i tillegg til bedre forklaring på hvordan vi starter spillet(Sebastian,Jackie)</li>
        <li>dokumentasjon i koden i tilleg til innkapsling(Brian og Jackie)</li>
    </ul>
    <p>til neste gang vil vi spørre gruppeleder om : mockito , headless application og tester, tilbakemelding om powerups(eivind), spotbugg, linux problemet med spillet(kjell og sebastian), lisens(sebastian og jakcie), spør om MVC struktur</p>

    
<h1>Referat 14 (26.04.2023)</h1>
<h2>Hvem som var tilstede</h2>
    <p>Alle var tilstede</p>
<h2>Hva dere diskuterte</h2>
    <p>Fikk hjelp av gruppeleder til å forstå Mockito tester. Fikk tilsendt en tutorial på mockito, her blir oppgaven å "mocke" feltvariabler for å videre teste metoder i klasser</p>
    <p>Fikk rådgivning på mulig endring i MVC. Akkurat nå ligger det funksjonalitet for rendring i model. Denne renderingen bør ikke ligge i model men heller i GameScreen. Enkle getters vil kunne fikse dette</p>
    <p>Fikk beskjed om at forrige tilbakemelding om controller problemer på linux skal bli sett bort ifra</p>
    <p>Vi trenger å ha brukt sportbugs vertfall en gang og ta i bruk tilbakemeldingen fra den.</p>
    <p>Lisens var tydligvis ikke nødvendig, altså det var ikke nødvendig med noen offisiel lisens, det er nok med å referere til grafikk i readme og oppgi hvordan vi ønsker at det skal brukes</p>
    <p>Powerups til eivind, vi har fått tilbakemelding på powerupsene på player ikke er særlig utvidbart. Siden vi ikke har mange powerups akkurat nå, og med henhold til tid, har vi valgt å beholde det slik det er nå, dette er dette et designvalg. Alternativet hadde vert å hatt et interface av powerups og på den måten bare trengt en metode for å applye en powerup på player</p>
<h2>Hvilke avgjørelser dere tok</h2>
    <p>Sebastian og Kjell, pair programmet MVC refraktor, der rendering av map og player blir tatt ut av model og inn i GameScreen, refaktoriseringen var vanskelig. </p>
    <p></p>
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
    <p>Dette er hva vi mangler å gjøre nå :
        <ul><b>Dokumentasjon</b>
            <li>Spotbugs(Brian, Jackie)</li>
            <li>oblig4 (viktig å ta med helgetlige vurderingen av alle forrige obligene)(Brian,Jackie,Sebatian)</li>
            <li>UML Diagram(Sebastian)</li>
            <li>Lisenser(Jackie)</li>
        </ul>
        <ul><b>Funksjonalitet</b>
            <li>Testing(enten refractore MVC eller bruke Mockito, eller begge :D)(Kjell & Sebastian)</li>
            <li>tileFactory(Eivind)</li>
            <li>fikse game over screen til å være mer åpenbart hvem som dør(Brian)</li>
            <li>Collision fix(Dorcas)</li>
        </ul>
    </p>
    <p>neste uke onsdag 3.mai (12-15) skal vi møtes og bli ferdig med oblig</p>

<h1>Referat 15 (03.05.2023)</h1>

<h2>Hvem som var tilstede</h2>
    <p> Sebastian, Kjell, Jackie, Dorcas, Brian</p>
    
<h2>Hva dere diskuterte</h2>
    <p> Hva har vi igjen: </p>
        <ul> 
            <li> Tester </li>
            <li> Tilefactory </li>
            <li> Fikse lyd/ lydeffekter </li>
        </ul>

<h2>Hvilke avgjørelser dere tok</h2>
    <p> Vi valgte å gjøre følgende: </p>
<ul>
<li> Skrive tester i Player klassen. </li>
<li> Skrive på oblig4.md. </li>
<li> Gjøre ferdig tilefactory til neste gang.</li>
</ul>
    
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
    <p> Skrive flere tester </br>
        Planlegge siste utkast til innlevering </br>
        Siste møte: Fredag 05.mai klokka: 10:00 - 15:00 </br>
   </p>

<h1>Referat 16 (05.05.2023)</h1>

<h2>Hvem som var tilstede</h2>
<p> Kjell, Jackie, Brian, Sebastian, Dorcas, Eivind (Alle var tilstede)</p>
    
<h2>Hva dere diskuterte</h2>
    Diskusjon av tester, om vi skal mocke map. Få test coverage til 75%.
    Fikse forsiden av repository, få en ryddigere READ.ME. 

<h2>Hvilke avgjørelser dere tok</h2>
    Vanlige JUnit tester fungerer ikke for mye av koden. 
    Dette skyldes av naturen av LibGdx og problemene med grafikk.
    La inn lisenser og jar.fil beskrivelse i READ.ME. 


<h1> Prosjektrapport </h1>
    <p> Som vi gjorde det i oblig3 hadde vi valgt å ikke ha noen spesielle roller enn kun utvikler og kundekontakt (Sebastian). Vi føler at det passet for oss siden vi alle kunne være med å planlegge hvordan vi skal håndtere videre planer. Vi samarbeidet veldig bra som et team. Eivind hadde igjen rollen som skulle legge igjen den siste taggen før endelige innleveringen.  </br>
        Gruppedynamikken har vært veldig bra. Vi har blant annet klart å komme til enighet over når møte skal være: Hva vi skal jobbe med videre og fordeling av hvem som skal gjøre hva. </br>
        Kommunikasjonen har vært veldig bra. Diskusjon og kommunikasjonen har vært gjennom vår Discord server, og kommunikasjonen når vi møtes fysisk har vært enda bedre. Lite misforståelser og mye enigheter, spesielt da vi brukte trello som en oversikt over hva vi holder på med. Gjennom hele prosjektet har det vært noen forskjell over hvem som har committet mer enn andre i gruppa. Det skyldes av at flere har jobbet sammen i en maskin, en form for "pair programming". Alle i gruppa har vært med å bidra til prosjektet. Nesten hver møte har nesten alle eller alle i gruppa møtt opp.  </br>
    </p>
    <p> Det som har vært bra er hvordan vi jobbet som team. Alle eller nesten alle møtt opp de dagene vi skulle møte opp, og alle hadde gjort det de skulle gjøre. 
        Vi hadde gode planer om hv alle skal drive med til neste gang, og var egentlig veldig bra på å tenke på SOLID prinsippene.
        En ting som vi kunne ha gjort annerledes er å bruke de konseptene som er skrevet i boken som Test Driven Development.
        Vi begynte å tenke på testene for seint, noe som gjorde at vi måtte refaktore veldig mye for å teste noen klasser, mens andre kunne ikke testes pga graffiken. Andre konsepter som vi ikke tenkte veldig mye på er det med å følge på Object Calisthenics for å unngå Code Smells. 
        Selv om vi hadde det i bakhodet, var det fortsatt vanskelig å følge alle Object Calisthenics med tanken på størrelsen av prosjektet. Selv med alt dette er vi forsatt veldig stolt av det vi har fått til. Vi har lagd en ganske bra spill som er multiplayer og som har Powerups. Vi har kule lyder
        og spilleren ser og fungerer ganske bra. Alt i alt er vi fornøyd med det vi har fått til.
    </p>

<h1> Krav og Spesifikasjon: </h1>
    <p>
        Vi har refaktorert koden sånn at det følger MVC- prinsippen. Vi har valgt å prioritere refaktorisering av koden, lyd og lydeffekter, få multiplayer til å fungere altså at kontrollerne skal være uavhengig av hverandre, skrive flere tester og lage en tilefactory. Vi har klart å implementere disse tingene og fungerer som det skal. Siden sist oblig3 jobbet vi med å fokusere på powerups. 
    </p>

<h1> Kode seksjon </h1>
    <p> Dette har vi fikset siden sist: Kontrollerne er nå uavhengige. Det vil si at vi har to kontroller som er uavhengige av hverandre og kan nå styres av to spiller.
        Vi har fått fikset refaktorteringen, nå har vi mer oversiktlig over hvor klassene befinner seg.
    </p>
    <p> Her kan du finne det siste klassediagrammet av hvordan våre klasser har blitt delt inn i: (Link)
    </p>
    <p> Spotbugs: Vi har fått testet spotbugs i koden vår. Vi brukte spotBugs mot slutten for å gå gjennom koden å se etter ting som vi hadde oversett mens vi lagde spillet. Jeg skal være ærlig og si det var litt av hvert der. Inkludert var: 13 «bugs» relatert til ubrukte metoder og varibler, noen feil i koden slik som å ikke kaste RuntimeExeptions og å dele på integers når man vil ha en float ut. Disse har blitt fjernet/fikset.
Det var samtidig også noen tilfeller hvor spotBugs foreslo at systemet var mer åpent for å vise frem intern data ved bruken av referanser istedenfor kopier av dataen, et tilfelle av dette kan finnes i Model sin konstruktør ved «this.game = game», men var usikker på om dette var noe som kunne gjøres noe med, så det ble latt være.
Med tanke på det som ble funnet med hjelp av programmet har det vært veldig nyttig, selv bare for å finne deler av koden som var dårlig/trengte små forandringer.
    </p>

