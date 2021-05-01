package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class Gui {
	
	
	public PlayerAction getActionFromConsole() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PlayerAction action = null;

		System.out.println("What do you want to do? (a,s,d,w)");
		
		String act = reader.readLine();
		switch(act) {
		case "a":
			action = new PlayerAction(Moves.GO_LEFT);
			break;
		case "s":
			action = new PlayerAction(Moves.GO_DOWN);
			break;
		case "d":
			action = new PlayerAction(Moves.GO_RIGHT);
			break;
		case "w":
			action = new PlayerAction(Moves.GO_UP);
			break;
		}
		
		return action;
	}
	
	

	public void printMap(Collection<LocatedOnMap> mapBeing, Collection<Settings> settings) {
		
		Settings setting = settings.iterator().next();
		int dimension = setting.getDimension();
		int time = setting.getTime();
		
		String[][] map = createEmptyMap(dimension);

		//Aggiungo l'hero
		mapBeing.forEach(mapper -> {map[mapper.col][mapper.row] = "[ "+mapper.simbol+" ]";});
		
		System.out.println("Time: "+time%10);
		System.out.println("Limits: cl["+setting.getLimitColLeft()+"], cr["+setting.getLimitColRight()+"], ru["+setting.getLimitRowUp()+"], rd["+setting.getLimitRowDown()+"]");
		printToConsole(map);
	}
	
	
	// Crea mappa vuota
	private String[][] createEmptyMap(int dimension){
		String[][] map = new String[dimension][dimension];
		for (int i = 0; i< dimension; i++) {
			for( int j = 0; j < dimension; j++) {
				map[i][j] = "[   ]";
			}
		}
		return map;
	}
	
	
	
	// Stampano una mappa su console
	private void printToConsole(String[][] map) {
		for(String[] row : map) {
            printRow(row);
        }
	}
	private void printRow(String[] row) {
        for (String i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
        System.out.println();

    }
}
