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

    
<h1>Refaret 14 (26.04.2023)</h1>
<h2>Hvem som var tilstede</h2>
    <p>Alle var tilstede</p>
<h2>Hva dere diskuterte</h2>
    <p>Fikk hjelp av gruppeleder til å forstå Mockito tester. Fikk tilsendt en tutorial på mockito, her blir oppgaven å "mocke" feltvariabler for å videre teste metoder i klasser</p>
    <p>Fikk rådgivning på mulig endring i MVC. Akkuratt nå ligger det funksjonalitet for rendring i model. Denne renderingen bør ikke ligge i model men heller i GameScreen. Enkle getters vil kunne fikse dette</p>
    <p>Fikk beskjed om at forrige tilbakemelding om controller problemer på linux skal bli sett bort ifra</p>
    <p>Vi trenger å ha brukt sportbugs vertfall en gang og ta i bruk tilbakemeldingen fra den.</p>
    <p>Lisens var tydligvis ikke nødvendig, altså det var ikke nødvendig med noen offisiel lisens, det er nok med å referere til grafikk i readme og oppgi hvordan vi ønsker at det skal brukes</p>
    <p>Powerups til eivind</p>
    <p>Dette er hva vi mangler å gjøre nå :
        <ul><b>Dokumentasjon</b>
            <li>Spotbugs</li>
            <li>Javadocs(spesielt mellom metoder på tvers av pakker)</li>
            <li>oblig4 (viktig å ta med helgetlige vurderingen av alle forrige obliggene)</li>
            <li>UML Diagram</li>
            <li>Lisenser</li>
        </ul>
        <ul><b>Funksjonalitet</b>
            <li>Testing(enten refractore MVC eller bruke Mockito, eller begge :D)</li>
            <li>Merge inn lyder</li>
        </ul>
    </p>
<h2>Hvilke avgjørelser dere tok</h2>
    <p>Sebastian og kjell, pair programmet MVC refractor, der hvor rendering av map og player blir tatt ut av model og inn i GameScreen, refractor var vanskelig fordi, det var vansklig å få til refractoren</p>
<h2>Hva dere ble enige om å gjøre til neste gang</h2>
