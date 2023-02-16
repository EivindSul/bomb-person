## Oppgave A2: Konsept
* Spillfigur som kan flyttes høyre, venstre, opp og ned.
* Todimensjonalt spillbrett
    * Brett er et rutenett med størrelse satt på spillstart
    * Vegger/fliser som ikke kan ødelegges
    * Vegger som kan ødelegges
* Spillfigur kan legge ned bomber på ruten de står på
    * Bomber kan ødelegge vegger og skade spillfigurer inkludert egen
    * Eksplosjon går i et kryss fra ruten den detonerte på
    * Kan bare legge ut en bombe når spillet starter
    * Uknuselige vegger kan stoppe eksplosjonen
* Powerups for spillfigur og bomber
    * Finnes i vegger som har blitt ødelagt
    * Spillfigur:
        * Beveger seg raskere (midlertidig og stor boost eller permanent og liten?)
        * Kan legge ut flere bomber (permanent, en ekstra per powerup)
        * Gi spillfigur et ekstra "liv"
    * Bomber:
        * Større eksplosjonsradius (permanent)
        * Maks eksplosjonsradius (midlertidig)
        * Spillfigur kan kaste bombe hvis de står i ro når de legger den ned. (permanent)
* En god illustrasjon for hvordan spillet fungerer vil komme fra Bomberman serien eller Playing with fire 2.



## Oppgave A3: Prosess
* I den første perioden av prosjektet har teamet planlagt å møtes en gang i uken, torsdag kl 10:15 og ellers  holde kontakten via discord serveren. Vi skal følge en kanban strategi via trello hvor vi har en plan på hva vi gjør, har gjort og skal gjøre i fremtiden. Dette er en metode for at alle skal ha en oversikt over hva som blir gjort og hva som kreves for å komme i mål.
* Vi har fordelt litt på arbeided hvor vi har en leder, en nestleder, en kundekontakt og resten utviklere. Lederen har ansvaret for å merge branches inn i main branch.
* Vi deler og oppbevarer felles dokumenter og kode i et git repository hvor alle har tilgang til å legge til å endre filene.

## Oppgave A3: Forventet Produkt

#### Målet for applikasjonen
Å lage en enkel flerspiller-spillapplikasjon som lar to spillere konkurrere om å være den siste som står igjen på spillebrettet.Applikasjonen skal ha et minimum av funksjonalitet som inkluderer vsining av spillevegger/murer og spillerne, bevegelse av spillerne, interaksjon med terrenget, bombefunksjonalitet og et enkelt mål for spillet. Ved oppstart skal spillet ha en start-skjerm som gir brukerne mulighet til å starte et nytt spill, og når  spillet er ferdig skal en game over-skjerm vise resultatene og gi brukerne mulighet  til å spille igjen eller avslutte spillet.

#### Mininimum Viable Product

Vise spillbrett
Vise spillemurer (uknuselig) / spillevegger (knuselig)
Vise spillerne (2 player)
Flytte spiller (opp, ned, venstre, høyre)
Spiller interagerer med terreng
Spiller ikke har mulighet til å gå i gjennom vegger/murer
Spiller kan droppe en bombe
Bomben tar 5 sekunder før den eksploderes.
Bomben kan sprenges som et kryss.
Bomben kan ødelegger veggene, men ikke murene.
Eksplosjonen går ikke i gjennom murene/veggene.
En spiller dør når den blir sprengt av en bombe.
Mål for spillet: "Be the last man standing"
Nytt spillbrett når forrige er ferdig.
Start-skjerm ved oppstart / game over.

#### Brukehistorier

##### Vise spillemurer (uknuselig) / spillevegger (knuselig):

Brukehistorie: Som spiller vil jeg kunne se spillemurer og spillevegger i spillet, slik at jeg kan  navigere og unngå hindringer.
Akseptansekriterie: spillemurer skal være synlig og ikke mulig å ødelegge, men spillevegger skal kunne ødelegges ved hjelp av en bombe.
Arbeidsoppgave: Legg til grafikk for spillemurer og spillevegger, og legg til funksjonalitet får å vise og håndtere dem i spillet.

##### Vise spillerne (2 player):

Brukehistorie: Som spiller vil jeg kunne se to spillere i spillet, slik at jeg kan  se min egen spiller og motstanderen min.
Akseptansekriterie: To spillere skal kunne være synlig samtidig på skjermen, og det skal være tydelig hvilken spillere som tilhører hvilken kontroller.
Arbeidsoppgave: Legg til grafikk for spillerene, og legg til funksjonalitet får å vise og håndtere to spillere samtidig.

##### Flytte spiller (opp, ned, venstre, høyre):

Brukehistorie: Som spiller vil jeg kunne beveger min egen spiller opp, ned, til venstre og høyre, slik at jeg kan navigere i spillet.
Akseptansekriterie: spilleren skal kunne bevege seg i alle fire retninger, og bevegelsen skal være jevn og responsiv.
Arbeidsoppgave: Legg til funksjonalitet får kunne bevege spilleren, og lag animasjoner for bevegelsene.

##### Spiller interagerer med terreng:

Brukehistorie: Som spiller vil jeg kunne interagere med terreng, slik at jeg kan ødelegge spillevegger og unngå spillemurer.
Akseptansekriterie: spillemurer skal være synlig og ikke mulig å ødelegge, men spillevegger skal kunne ødelegges ved hjelp av en bombe.
Arbeidsoppgave: Legg til funksjonalitet får å ødelegge spillevegger, og lag kollisjonsdeteksjon for å hindre spilleren i å passere gjennom spillemurer.

##### Spiller kan droppe en bombe:

Brukehistorie: Som en spiller vil jeg kunne slippe en bombe, slik at jeg kan ødelegge spillevegger pg eventuelt skade motstanderen MIN.
Akseptansekriterie: Spilleren skal kunne slippe en bombe ved hjelp av en knapp eller tast, og bomben skal bli synlig på spillbrettet.
Arbeidsoppgave: Legg til funksjonalitet får å slippe en bombe, og legg til grafikk for bomben.

Bomben tar 5 sekunder før den eksploderes.:

Brukehistorie: Som spiller vil jeg at bomben skal ta litt tid før den eksplodere, slik at jeg khar tid til å komme meg unna.
Akseptansekriterie: Bomben skal ta 5 sekunder før den eksplodere og spilleren skal kunne se en teller som viser hvor lang tid det er igjen.
Arbeidsoppgave: Legg til funksjonalitet får å telle ned tiden før bomben eksploderer, og legg til grafikk for telleren.

##### Bomben kan sprenges som et kryss.:

Brukehistorie: Som spiller vil jeg at bomben skal kunne sprenges som et kryss, slik at jeg kan  ødelegge flere spillevegger samtidig.
Akseptansekriterie: Når bomben eksplodere skal den ødelegge spillevegger i et kryssmønster fra eksplosjonspunktet.
Arbeidsoppgave: Legg til funksjonalitet får å sprenge bomben som et kryss, og legg til grafikk for eksplosjonen.

##### Bomben kan ødelegger veggene, men ikke murene.:

Brukehistorie: Som spiller vil jeg at bomben skal kunne ødelegge spillevegger men ikke spillemurer, slik at spillet er balansert og utfordrende.
Akseptansekriterie: Bomben skal kunne ødelegge spillevegger men ikke spillemurer, og grafikken for spillemurer skal forbli intakt etter eksplosjonen.
Arbeidsoppgave: Legg til funksjonalitet får å ødelegge spillevegger, og sørge for at spillemurer ikke blir påvirket av eksplosjonen.

##### Eksplosjonen går ikke i gjennom murene/veggene:

Brukehistorie: Som spiller vil jeg at eksplosjonen fra bomben ikke skal kunne passere gjennom spillemurer eller spillevegger, slik at spillet er balansert og utfordrende.
Akseptansekriterie: Eksplosjonen skal stoppe ved spillevegger og spillemurer, og ikke passere gjennom dem.
Arbeidsoppgave: Legg til kollisjonsdeteksjon for eksplosjonen, og sørge for at den ikke går gjennom spillemurer eller spillevegger.

En spiller dør når den blir sprengt av en bombe:

Brukehistorie: Som spiller vil jeg at min spiller skal dø når den blir truffet av en eksplosjon fra en bombe, slik at jeg kan spille videre eller starte på nytt.
Akseptansekriterie: hvis en spiller blir truffet an en eksplosn fra en bombe, skal spilleren dø og spillet skal gi beskjed om at spilleren er eliminert.
Arbeidsoppgave: Legg til kollisjonsdeteksjon for spilleren og eksplosjonen, og legg til funksjonalitet for å gi beskjed om at spilleren er eliminert.

##### Mål for spillet: "Be the last man standing":

Brukehistorie: Som spiller vil jeg at målet for spillet skal være å være den siste spilleren som står igjen på spillebrettet, slik at jeg prøve å vinne spillet.
Akseptansekriterie: Spillet skal fortsette til det bare er en spiller igjen på spillebrettet, og spilleren som er igjen skal være vinneren.
Arbeidsoppgave: Legg til funksjonalitet får å sjekke om det er mer enn èn spiller igjen på spillebrettet, og gi beskjed om hvem som er vinneren når spillet er ferdig.

##### Nytt spillbrett når forrige er ferdig:

Brukehistorie: Som spiller vil jeg at spillet skal fortsette med et nytt spillbrett når den forrige er ferdig, slik at jeg kan spille flere runder.
Akseptansekriterie: Når det er en vinner på spillebrettet, skal spillet bytte til et nytt spillbrett.
Arbeidsoppgave: Legg til funksjonalitet får å bytte til et nytt spillbrett når spillet er ferdig, og generer nye spillbrett med tilfeldig plassering av spillerne og spilleveggene.

##### Start-skjerm ved oppstart / game over:

Brukehistorie: Som spiller vil jeg at spillet skal ha en start-skjerm ved oppstart og en game over-skjerm når spillet er ferdig, slik at jeg kan starte eller avslutte spillet.
Akseptansekriterie: Spillet skal vise en start-skjerm når det starter opp, og en game over-skjerm når spillet er ferdig. Start-skjerm skal ha en "start spill"-knapp, og game over-skjermen skal ha en "spill igjen"-knapp og en "avslutt"-knapp.
Arbeidsoppgave: Legg til grafikk fog legg funksjonalitet for start-skjermen og game over-skjermen, og legg til funksjonalitet for knappene på begge skjermene.
