# SIMPLE DROOLS ROYALE GAME

## FUNZIONALITÀ ATTUALMENTE IMPLEMENTATE

- Muoversi in tutte le 8 direzioni
- Attaccare in tutte le 8 direzioni
- Craftare sopra l'apposito simbolo
- Piazzare una trappola (che fa danno random [0, SHARPNESS] a chi prova a craftarla)

## IA in ordine di priorità decrescente

- Se è vicino ad un nemico, lo attacca (****)
- Se ha un nemico all'interno del suo raggio di visione in una delle 4 direzioni principali si avvicina (***)
- Se ha un nemico all'interno del suo raggio di visione in una delle diagonali si avvicina diagonalmente (**)
- Se non ha nessuno a crafta, piazza una trappola o si muove random (*)

## Regole combattimento tra PG1 attaccante e PG2 difensore

- PG1 lancia un D20 e somma la sua DEXTERITY al risultato ottenuto.
- Se il valore ottenuto è inferiore alla somma tra DEFENCE e ELUSION di PG2 l'attacco fallisce altrimenti si procede con lo step successivo
- PG1 lancia il Dado relativo al bonus della sua arma e lo somma il risultato ottenuto al danno base dell'arma e al suo ATTACK
- PG2 sottrae alla sua LIFE il valore ottenuto nel punto precedente

