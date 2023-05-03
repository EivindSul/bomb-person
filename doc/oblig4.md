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
        <li>interaktiv lyd(dorcas)</li>
        <li>object frabrikk(eivind)</li>
        <li>Tester med test coverage, Headless applicationtest Sebastian og Kjell prøver.</li>
        <li>lisens og kildebruk(sebastian,jackie)</li>
        <li>dokumentasjon i koden i tilleg til innkapsling(Brian og jackie)</li>
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
        <li>uml diagram(sebastian)</li>
        <li>se på programvare for å test(spotbugs) visst tid til overs</li>
        <li>problem med menyer på linux</li>
        <li>fikse MVC litt</li>
    </ul>
    <ul>
        <li>interaktiv lyd(dorcas)</li>
        <li>TileFactory frabrikk(eivind)</li>
        <li>Tester med test coverage, Headless applicationtest Sebastian og Kjell prøver.</li>
        <li>lisens og kildebruk i tillegg til bedre forklaring på hvordan vi starter spillet(sebastian,jackie)</li>
        <li>dokumentasjon i koden i tilleg til innkapsling(Brian og jackie)</li>
    </ul>
    <p>til neste gang vil vi spørre gruppeleder om : mockito , headless application og tester, tilbakemelding om powerups(eivind), spotbugg, linux problemet med spillet(kjell og sebastian), lisens(sebastian og jakcie), spør om MVC struktur</p>

    
<h1>Referat 14 (26.04.2023)</h1>
<h2>Hvem som var tilstede</h2>
    <p>Alle var tilstede</p>
<h2>Hva dere diskuterte</h2>
    <p>Fikk hjelp av gruppeleder til å forstå Mockito tester. Fikk tilsendt en tutorial på mockito, her blir oppgaven å "mocke" feltvariabler for å videre teste metoder i klasser</p>
    <p>Fikk rådgivning på mulig endring i MVC. Akkuratt nå ligger det funksjonalitet for rendring i model. Denne renderingen bør ikke ligge i model men heller i GameScreen. Enkle getters vil kunne fikse dette</p>
    <p>Fikk beskjed om at forrige tilbakemelding om controller problemer på linux skal bli sett bort ifra</p>
    <p>Vi trenger å ha brukt sportbugs vertfall en gang og ta i bruk tilbakemeldingen fra den.</p>
    <p>Lisens var tydligvis ikke nødvendig, altså det var ikke nødvendig med noen offisiel lisens, det er nok med å referere til grafikk i readme og oppgi hvordan vi ønsker at det skal brukes</p>
    <p>Powerups til eivind, vi har fått tilbakemelding på powerupsene på player ikke er særlig utvidbart. Siden vi ikke har mange powerups akkurat nå, og med henhold til tid, har vi valgt å beholde det slik det er nå, dette er dette et designvalg. Alternativet hadde vert å hatt et interface av powerups og på den måten bare trengt en metode for å applye en powerup på player</p>
<h2>Hvilke avgjørelser dere tok</h2>
    <p>Sebastian og kjell, pair programmet MVC refractor, der hvor rendering av map og player blir tatt ut av model og inn i GameScreen, refractor var vanskelig fordi, det var vansklig å få til refractoren</p>
    <p></p>
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
    <p>Dette er hva vi mangler å gjøre nå :
        <ul><b>Dokumentasjon</b>
            <li>Spotbugs(brian, jackie)</li>
            <li>oblig4 (viktig å ta med helgetlige vurderingen av alle forrige obliggene)(brian,jackie,sebatian)</li>
            <li>UML Diagram(sebastian)</li>
            <li>Lisenser(jackie)</li>
        </ul>
        <ul><b>Funksjonalitet</b>
            <li>Testing(enten refractore MVC eller bruke Mockito, eller begge :D)(kjell & sebastian)</li>
            <li>tileFactory(eivind)</li>
            <li>fikse game over screen til å være mer åpenbart hvem som dør(brain)</li>
            <li>Collision fix(dorcas)</li>
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
            <li> Lyden/ lydeffekter </li>
        </ul>
    <p> Hvis vi har tid: </p>
        <ul>
            <li> Powerups </li>
            <li> Flytte map ut av model </li>
        </ul>

<h2>Hvilke avgjørelser dere tok</h2>
    <p> Vi valgte å gjøre følgende: </p>
<ul>
<li> Skrive tester i Player klassen </li>
<li> Skrive på oblig4.md </li>
</ul>
    
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
    <p> Skrive mer tester </br>
        Siste utkast må leveres </br>
        Siste møte: Fredag 05.mai klokka: 10:00 - 15:00 </br>
   </p>


<h1> Prosjektrapport </h1>
    <p> Som vi gjorde det i oblig3 hadde vi valgt å ikke ha noen spesielle roller enn kun utvikler og kundekontakt (Sebastian). Vi mener at det var mer effektivt siden vi alle være med å planlegge hvordan vi skal håndtere videre planer. Vi samarbeidet veldig bra som et team. Eivind hadde igjen rollen som skulle legge igjen den siste taggen før endelige innleveringen.  </br>
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
