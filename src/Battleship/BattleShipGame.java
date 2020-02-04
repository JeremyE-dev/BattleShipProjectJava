package Battleship;

import java.util.Scanner;

public class BattleShipGame {

	public static void main(String[] args) {
	
		Ocean Ocean1 = new Ocean();
		Ocean1.placeAllShipsRandomly();
		
		System.out.println("Welcome to One Player Battleship\n"
			+ "in this game you will be playing against the computer\n\n"
			+ "there are a total of 13 ships in the ocean\n"
			+ " 1 - BattleShip (8 spaces) \n 1 - BattleCruiser(7 spaces)\n 2 - Cruisers (6 spaces)\n 2 - LightCruisers (5 spaces)\n"
			+ " 3 - Destroyers (4 spaces) \n 4 - Submarines (3 spaces)\n\n"
			+ "Sink all of the ships to win!!\n\n"
			+ "Lets Begin!\n"
			+ "Here is your beginning Ocean\n\n");
			
		Ocean1.print();
		
		System.out.println();
			
			
			System.out.println("\"S\" = hit a ship, \"x\" = sunken ship, \"-\" = shot at and missed, \".\" = not fired upon\n\n"
			+ "You will can enter 25 shots, 5 shots at a time\n\n"
			+ "enter 5 \"shots\" on one line of input\n\n"
			+ "format of input needs to be number,<space>number;<space> \n\n"
			+ "a single \"shot\" looks like this; 1, 1;\n\n"
			+ "5 shots should look like this: 1, 1; 0, 3; 7, 3; 9, 11; 12, 17\n\n"
			+ "if input format is incorrect an error message will follow and you can enter your shots again\n\n"
			+ "enter your fist 5 coordinates: ");
		
	
	//take initial input
	Scanner console = new Scanner(System.in);
	
	String userInput = console.nextLine(); 
	
	System.out.println();
	
	// will not get to first acceptInput call until valid input entered
	while(!isInputValid(userInput)) {
		

	System.out.println( "Oops! incorrect format: please enter 5 \"shots\" on one line of input\n\n"
				+ "format of input needs to be number,<space>number;<space> \n\n"
				+ "a single \"shot\" looks like this; 1, 1;\n\n"
				+ "5 shots should look like this: 1, 1; 0, 3; 7, 3; 9, 11; 12, 17\n\n"
				+ "please enter your shots again: ");
		
	userInput = console.nextLine();
	}
	

	//input is valid by this point, so acceptI.. is callled
	acceptInput(userInput, Ocean1);
	
	
	//
	while(!Ocean1.isGameOver()) {
		
		System.out.println("Enter your next Coordinates:");
		
		userInput = console.nextLine();
		while(!isInputValid(userInput)) {
			

			System.out.println( "Oops! incorrect format: please enter 5 \"shots\" on one line of input\n\n"
						+ "format of input needs to be number,<space>number;<space> \n\n"
						+ "a single \"shot\" looks like this; 1, 1;\n\n"
						+ "5 shots should look like this: 1, 1; 0, 3; 7, 3; 9, 11; 12, 17\n\n"
						+ "please enter your shots again: ");
				
			userInput = console.nextLine();
		}
		
		
		System.out.println();
		
		acceptInput(userInput, Ocean1);	
		
		if(Ocean1.getShotsFired() > 30) { // increase this number to extend game
			endOfGameReport(Ocean1);
			
			return;
		}
		
	}
	
	endOfGameReport(Ocean1);
	

	}
	

	public static void endOfGameReport(Ocean x) {
		
		
		if (x.getShipsSunk() == x.getAllShips().length) {
		System.out.println("You sunk all of the ships! \n" + "Shots fired: " + x.getShotsFired() + "\n" 
				+ "Hit Count: " + x.getHitCount() + "\n" + "Thank you for playing...");
		}
		
		
		
		else {
		System.out.println("Game Over \n" + "You sunk " + x.getShipsSunk() + 
		" ships \n"
		 + "Shots fired: " + x.getShotsFired() + "\n" 
		+ "Hit Count: " + x.getHitCount());
		
		}
	}
	
	public static boolean isInputValid (String input) {
		try { 
			
			int[] arrayOfInputNums = parseInput(input); 
			int[] arrayOfRows = parseRows(arrayOfInputNums);
			int[] arrayOfColumns = parseColumns(arrayOfInputNums);
			

		}
		
		catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		
		
		catch ( NumberFormatException e){
			return false;
		}
			
		
		return true;
	}
	
	public static void acceptInput(String input, Ocean x) {
		
	
		processUserInput(input, x);
		
		x.updateGameBoardEmptyShips();
		
		x.updateGameBoardRealShips();

		x.print();
		
		System.out.println();
		
	}
	
	
	public static int[] parseInput(String s) {
		 
	
		
		String testNoPunct = s.replaceAll(";","").replaceAll(",", "");
		
		String[] splitString = testNoPunct.split(" ");
		
	    int[] nums = new int[splitString.length];
	       
	        for (int i = 0; i < nums.length; i++) {
	        	nums[i] = Integer.parseInt(splitString[i]);	
			}
	        
	        return nums;
		
	}
	
	//returns array of rows
	public static int[] parseRows(int[] x) {
		
		 int[] rowArray = new int[x.length/2];
	     int[] columnsArray = new int[x.length/2];
	        
	        int rowArrayIndex = 0;
	        int columnArrayIndex = 0;
	        
	        for (int i = 0; i < x.length; i++) {
				if (i % 2 == 0) {
					rowArray[rowArrayIndex] = x[i];
					rowArrayIndex++;
				} else {
					columnsArray[columnArrayIndex] = x[i];
					columnArrayIndex++;
				}
			}
		return rowArray;
		
	}
	
	//returns array of columns
	public static int[] parseColumns(int[] x) {
		
		 int[] rowArray = new int[x.length/2];
	     int[] columnArray = new int[x.length/2];
	        
	        int rowArrayIndex = 0;
	        int columnArrayIndex = 0;
	        
	        for (int i = 0; i < x.length; i++) {
				if (i % 2 == 0) {
					rowArray[rowArrayIndex] = x[i];
					rowArrayIndex++;
				} else {
					columnArray[columnArrayIndex] = x[i];
					columnArrayIndex++;
				}
			}
	        
	        
	        return columnArray;
		
		
		
	}
	
	public static void processUserInput(String s, Ocean o) {
		
		int[] arrayOfInputNums = parseInput(s); 
		int[] arrayOfRows = parseRows(arrayOfInputNums);
		int[] arrayOfColumns = parseColumns(arrayOfInputNums);
		
		for (int i = 0; i < 5; i++) {
			int row = arrayOfRows[i];
			int column = arrayOfColumns[i];
			
			o.getShipArray()[row][column].shootAt(row, column);	
			o.shootAt(row, column);
			
		}
		
		}
			
	
	}
		
		
		
		

	
//	String userInput = "0, 0; 0, 1; 0, 2; 0, 3; 0, 4";
//	processUserInput(userInput, Ocean1);
//	
//	
//	String input2 = "0, 5; 0, 6; 0,7; 0,8; 0,9;";
//	processUserInput(input2, Ocean1);
//	
//	
//	String input3 = "0,10; 0, 11; 0,12; 0, 13; 0,14";
//	processUserInput(input3, Ocean1);
//	
//	String input4 = "0,15; 0,16; 0,17; 0,18; 0,19";
//	processUserInput(input4, Ocean1);
//	
//	String input5 = "1, 0; 1, 1; 1, 2; 1, 3; 1, 4";
//	processUserInput(input5, Ocean1);
//	
//	String input6 = "1, 5; 1, 6; 1,7; 1,8; 1,9;";
//	processUserInput(input6, Ocean1);
//	
//	String input7 = "1,10; 1, 11; 1,12; 1, 13; 1,14";
//	processUserInput(input7, Ocean1);
//	
//	
//	String input8 = "1,15; 1,16; 1,17; 1,18; 1,19";
//	processUserInput(input8, Ocean1);
//	
//	String input9 = "2, 0; 2, 1; 2, 2; 2, 3; 2, 4";
//	processUserInput(input9, Ocean1);
//	
//	String input10 = "2, 5; 2, 6; 2,7; 2,8; 2,9;";
//	processUserInput(input10, Ocean1);
//	
//	String input11 = "2,10; 2, 11; 2,12; 2, 13; 2,14";
//	processUserInput(input11, Ocean1);
//	
//	
//	String input12 = "2,15; 2,16; 2,17; 2,18; 2,19";
//	processUserInput(input12, Ocean1);
//	
//	String input13 = "3, 0; 3, 1; 3, 2; 3, 3; 3, 4";
//	processUserInput(input13, Ocean1);
//	
//	String input14 = "3, 5; 3, 6; 3,7; 3,8; 3,9;";
//	processUserInput(input14, Ocean1);
//	
//	String input15 = "3,10; 3, 11; 3,12; 3, 13; 3,14";
//	processUserInput(input15, Ocean1);
//	
//	
//	String input16 = "3,15; 3,16; 3,17; 3,18; 3,19";
//	processUserInput(input16, Ocean1);
//	
//	String input17 = "4, 0; 4, 1; 4, 2; 4, 3; 4, 4";
//	processUserInput(input17, Ocean1);
//	
//	String input18 = "4, 5; 4, 6; 4,7; 4,8; 4,9;";
//	processUserInput(input18, Ocean1);
//	
//	String input19 = "4,10; 4, 11; 4,12; 4, 13; 4,14";
//	processUserInput(input19, Ocean1);
//	
//	
//	String input20 = "4,15; 4,16; 4,17; 4,18; 4,19";
//	processUserInput(input20, Ocean1);
//	
//	String input21 = "5, 0; 5, 1; 5, 2; 5, 3; 5, 4";
//	processUserInput(input21, Ocean1);
//	
//	String input22 = "5, 5; 5, 6; 5,7; 5,8; 5,9;";
//	processUserInput(input22, Ocean1);
//	
//	String input23 = "5,10; 5, 11; 5,12; 5, 13; 5,14";
//	processUserInput(input23, Ocean1);
//	
//	
//	String input24 = "5,15; 5,16; 5,17; 5,18; 5,19";
//	processUserInput(input24, Ocean1);
//	
//	
//	String input25 = "6, 0; 6, 1; 6, 2; 6, 3; 6, 4";
//	processUserInput(input25, Ocean1);
//	
//	String input26 = "6, 5; 6, 6; 6,7; 6,8; 6,9;";
//	processUserInput(input26, Ocean1);
//	
//	String input27 = "6,10; 6, 11; 6,12; 6, 13; 6,14";
//	processUserInput(input27, Ocean1);
//	
//	
//	String input28 = "6,15; 6,16; 6,17; 6,18; 6,19";
//	processUserInput(input28, Ocean1);
//	
//	String input29 = "7, 0; 7, 1; 7, 2; 7, 3; 7, 4";
//	processUserInput(input29, Ocean1);
//	
//	String input30 = "7, 5; 7, 6; 7,7; 7,8; 7,9;";
//	processUserInput(input30, Ocean1);
//	
//	String input31 = "7,10; 7, 11; 7,12; 7, 13; 7,14";
//	processUserInput(input31, Ocean1);
//	
//	
//	String input32 = "7,15; 7,16; 7,17; 7,18; 7,19";
//	processUserInput(input32, Ocean1);
//	
//	String input33 = "8, 0; 8, 1; 8, 2; 8, 3; 8, 4";
//	processUserInput(input33, Ocean1);
//	
//	String input34 = "8, 5; 8, 6; 8,7; 8,8; 8,9;";
//	processUserInput(input34, Ocean1);
//	
//	String input35 = "8,10; 8, 11; 8,12; 8, 13; 8,14";
//	processUserInput(input35, Ocean1);
//	
//	
//	String input36 = "8,15; 8,16; 8,17; 8,18; 8,19";
//	processUserInput(input36, Ocean1);
//	
//	
//	String input37 = "9, 0; 9, 1; 9, 2; 9, 3; 9, 4";
//	processUserInput(input37, Ocean1);
//	
//	String input38 = "9, 5; 9, 6; 9,7; 9,8; 9,9;";
//	processUserInput(input38, Ocean1);
//	
//	String input39 = "9,10; 9, 11; 9,12; 9, 13; 9,14";
//	processUserInput(input39, Ocean1);
//	
//	
//	String input40 = "9,15; 9,16; 9,17; 9,18; 9,19";
//	processUserInput(input40, Ocean1);
//	
//	
//	String input41 = "10, 0; 10, 1; 10, 2; 10, 3; 10, 4";
//	processUserInput(input41, Ocean1);
//	
//	String input42 = "10, 5; 10, 6; 10,7; 10,8; 10,9;";
//	processUserInput(input42, Ocean1);
//	
//	String input43 = "10,10; 10, 11; 10,12; 10, 13; 10,14";
//	processUserInput(input43, Ocean1);
//	
//	
//	String input44 = "10,15; 10,16; 10,17; 10,18; 10,19";
//	processUserInput(input44, Ocean1);
//	
//	String input45 = "11, 0; 11, 1; 11, 2; 11, 3; 11, 4";
//	processUserInput(input45, Ocean1);
//	
//	String input46 = "11, 5; 11, 6; 11,7; 11,8; 11,9;";
//	processUserInput(input46, Ocean1);
//	
//	String input47 = "11,10; 11, 11; 11,12; 11, 13; 11,14";
//	processUserInput(input47, Ocean1);
//	
//	
//	String input48 = "11,15; 11,16; 11,17; 11,18; 11,19";
//	processUserInput(input48, Ocean1);
//	
//	String input49 = "12, 0; 12, 1; 12, 2; 12, 3; 12, 4";
//	processUserInput(input49, Ocean1);
//	
//	String input50 = "12, 5; 12, 6; 12,7; 12,8; 12,9;";
//	processUserInput(input50, Ocean1);
//	
//	String input51 = "12,10; 12, 11; 12,12; 12, 13; 12,14";
//	processUserInput(input51, Ocean1);
//	
//	
//	String input52 = "12,15; 12,16; 12,17; 12,18; 12,19";
//	processUserInput(input52, Ocean1);
//	
//	String input53 = "13, 0; 13, 1; 13, 2; 13, 3; 13, 4";
//	processUserInput(input53, Ocean1);
//	
//	String input54 = "13, 5; 13, 6; 13,7; 13,8; 13,9;";
//	processUserInput(input54, Ocean1);
//	
//	String input55 = "13,10; 13, 11; 13,12; 13, 13; 13,14";
//	processUserInput(input55, Ocean1);
//	
//	
//	String input56 = "13,15; 13,16; 13,17; 13,18; 13,19";
//	processUserInput(input56, Ocean1);
//	
//	String input57 = "14, 0; 14, 1; 14, 2; 14, 3; 14, 4";
//	processUserInput(input57, Ocean1);
//	
//	String input58 = "14, 5; 14, 6; 14,7; 14,8; 14,9;";
//	processUserInput(input58, Ocean1);
//	
//	String input59 = "14,10; 14, 11; 14,12; 14, 13; 14,14";
//	processUserInput(input59, Ocean1);
//	
//	
//	String input60 = "14,15; 14,16; 14,17; 14,18; 14,19";
//	processUserInput(input60, Ocean1);
//	
//	String input61 = "15, 0; 15, 1; 15, 2; 15, 3; 15, 4";
//	processUserInput(input61, Ocean1);
//	
//	String input62 = "15, 5; 15, 6; 15,7; 15,8; 15,9;";
//	processUserInput(input62, Ocean1);
//	
//	String input63 = "15,10; 15, 11; 15,12; 15, 13; 15,14";
//	processUserInput(input63, Ocean1);
//	
//	
//	String input64 = "15,15; 15,16; 15,17; 15,18; 15,19";
//	processUserInput(input64, Ocean1);
//	
//	
//	String input65 = "16, 0; 16, 1; 16, 2; 16, 3; 16, 4";
//	processUserInput(input65, Ocean1);
//	
//	String input66 = "16, 5; 16, 6; 16,7; 16,8; 16,9;";
//	processUserInput(input66, Ocean1);
//	
//	String input67 = "16,10; 16, 11; 16,12; 16, 13; 16,14";
//	processUserInput(input67, Ocean1);
//	
//	
//	String input68 = "16,15; 16,16; 16,17; 16,18; 16,19";
//	processUserInput(input68, Ocean1);
//	
//	
//	String input69 = "17, 0; 17, 1; 17, 2; 17, 3; 17, 4";
//	processUserInput(input69, Ocean1);
//	
//	String input70 = "17, 5; 17, 6; 17,7; 17,8; 17,9;";
//	processUserInput(input70, Ocean1);
//	
//	String input71 = "17,10; 17, 11; 17,12; 17, 13; 17,14";
//	processUserInput(input71, Ocean1);
//	
//	
//	String input72 = "17,15; 17,16; 17,17; 17,18; 17,19";
//	processUserInput(input72, Ocean1);
//	
//	String input73 = "18, 0; 18, 1; 18, 2; 18, 3; 18, 4";
//	processUserInput(input73, Ocean1);
//	
//	String input74 = "18, 5; 18, 6; 18,7; 18,8; 18,9;";
//	processUserInput(input74, Ocean1);
//	
//	String input75 = "18,10; 18, 11; 18,12; 18, 13; 18,14";
//	processUserInput(input75, Ocean1);
//	
//	
//	String input76 = "18,15; 18,16; 18,17; 18,18; 18,19";
//	processUserInput(input76, Ocean1);
//	
//	
//
//	String input77 = "19, 0; 19, 1; 19, 2; 19, 3; 19, 4";
//	processUserInput(input77, Ocean1);
//	
//	String input78 = "19, 5; 19, 6; 19,7; 19,8; 19,9;";
//	processUserInput(input78, Ocean1);
//	
//	String input79 = "19,10; 19, 11; 19,12; 19, 13; 19,14";
//	processUserInput(input79, Ocean1);
//	
//	
//	String input80 = "19,15; 19,16; 19,17; 19,18; 19,19";
//	processUserInput(input80, Ocean1);
	
	
	
	
	


