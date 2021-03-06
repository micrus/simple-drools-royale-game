package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.mapper.Mapper;

public class GuiConsole implements Gui {

	public GuiConsole() {
		super();
	}

	public Moves getAction() throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Moves action = Moves.BAD_MOVE;

		System.out.println("What do you want to do?");

		String act = reader.readLine();
		switch (act) {
		case "a":
			action = Moves.GO_LEFT;
			break;
		case "s":
			action = Moves.GO_DOWN;
			break;
		case "d":
			action = Moves.GO_RIGHT;
			break;
		case "w":
			action = Moves.GO_UP;
			break;

		case "wa":
			action = Moves.GO_UP_LEFT;
			break;
		case "wd":
			action = Moves.GO_UP_RIGHT;
			break;
		case "sa":
			action = Moves.GO_DOWN_LEFT;
			break;
		case "sd":
			action = Moves.GO_DOWN_RIGHT;
			break;

		case "fd":
			action = Moves.ATTACK_RIGHT;
			break;
		case "fa":
			action = Moves.ATTACK_LEFT;
			break;
		case "fs":
			action = Moves.ATTACK_DOWN;
			break;
		case "fw":
			action = Moves.ATTACK_UP;
			break;

		case "fsd":
			action = Moves.ATTACK_DOWN_RIGHT;
			break;
		case "fsa":
			action = Moves.ATTACK_DOWN_LEFT;
			break;
		case "fwd":
			action = Moves.ATTACK_UP_RIGHT;
			break;
		case "fwa":
			action = Moves.ATTACK_UP_LEFT;
			break;

		case "cr":
			action = Moves.CRAFT;
			break;
		case "tr":
			action = Moves.PUT_TRAP;
			break;
		}

		return action;
	}

	public void showMap(Collection<LocatedOnMap> mapBeing, Settings setting) {

		int dimension = setting.getDimension();
		int time = setting.getTime();

		String[][] map = createEmptyMap(dimension);
		List<LocatedOnMap> characters = mapBeing.stream()
				.filter(mapper -> Character.class.isAssignableFrom(mapper.getClass())).collect(Collectors.toList());
		;

		mapBeing.forEach(mapper -> {
			map[mapper.col][mapper.row] = "[ " + mapper.simbol + " ]";
		});

		// Characters must be shown with higher priority than objects
		characters.forEach(mapper -> {
			map[mapper.col][mapper.row] = "[ " + mapper.simbol + " ]";
		});

		// Aggiungo l'hero
		mapBeing.forEach(mapper -> {
			map[mapper.col][mapper.row] = "[ " + mapper.simbol + " ]";
		});
		
		System.out.println("Time: " + time % 10);

		printToConsole(map);
	}

	// TODO: Inserire controllo sulla dimensione minima?

	public String[][] createEmptyMap(int dimension) {
		String[][] map = new String[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				map[i][j] = "[   ]";
			}
		}
		return map;
	}

	public void showHelp() {
		System.out.println("Invalid command! Below the list of all the possible command that can be performed.");
		System.out.println("Move:");
		System.out.println("\t -a move left");
		System.out.println("\t -w move up");
		System.out.println("\t -d move right");
		System.out.println("\t -s move down");
		System.out.println();
		System.out.println("\t -fa attack left");
		System.out.println("\t -fw attack up");
		System.out.println("\t -fd attack right");
		System.out.println("\t -fs attack down");
		System.out.println();
		System.out.println("\t -dr draft");
		System.out.println();
		System.out.println();
	}

	public void showMessage(String msg) {
		System.out.print(msg);
	}

	// Stampano una mappa su console
	public void printToConsole(String[][] map) {
		for (String[] row : map) {
			this.printRow(row);
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
	
	public int chooseToKeep(String msg) {
		System.out.println(msg);
//		System.out.println("Do you want to keep it or not? (1 or 0)");
		int userChoise = -1;

		while (userChoise < 0 || userChoise > 1) {
			userChoise = new Scanner(System.in).nextInt();
			if (userChoise < 0 || userChoise > 1)
				System.out.println("Accettable values are only 1 (yes) or 0 (no)");
		}

		return userChoise;
	}

	// ########## Fine modifica commit precedente ##########
}
