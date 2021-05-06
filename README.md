# SIMPLE DROOLS ROYALE GAME

## FUNZIONALITÀ ATTUALMENTE IMPLEMENTATE

- Codice già strutturato in ottica MVC, implementata una basica view da console.

- Possibilità di muoversi per la mappa
- Impossibilità di muoversi attaverso muri o NPG
- Possibilità di muoversi sopra oggetti da draft per poter scavare 

- Possibilità di poter attaccare in tutte le direzioni
- Semplice sistema di combattimento unidirezionale basato su vita e attacco
- Morte di NPG nel caso la vita raggiunga lo zero a seguito di attacchi 

- Rimpicciolimento della mappa ogni 10 turni di gioco
- Morte di ogni personaggio (hero o NPC) rimasto fuori della mappa
- Vittoria nel caso l'eroe sia l'ultimo rimasto in gioco
- Sconfitta nel caso la vita dell'eroe raggiunga lo 0 o rimanga fuori della mappa

- Struttura per statistiche, ed oggetti da draft
- Meccanismo di bonus-malus ad ogni draft 

- NPG possono riattaccare
- NPG possono fare il craft
- NPG se hanno un character nel raggio di visione gli vanno in contro
- NPG se non hanno niente nel raggio di visione si muovono in una direzione a caso
- NPG se sono circondati da muri stanno fermi

- Refactoring

## TODO 

- Dividerci i compiti
- Finire IA NPG
- Aggiungere possibilità di mettere trappole (dovrebbe essere molto semplice per come è stato strutturato il codice dei drafting object

- Pacchettizzare 
- Implementare GUI 

