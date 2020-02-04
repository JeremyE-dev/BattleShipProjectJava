package Battleship;



import static org.junit.Assert.*;

import org.junit.Test;

/* Test Areas
 * if ship extends beyond array - completed - optional - refactor extends beyond - include true conditions
 * if location is an edge case - completed
 * 
 * 
*/

public class ShipTest {

	// extend beyond array test
	@Test
	//extendBeyondArray - returns true if it extends
	public void horizontalShipDoesNotExtendBeyondArray() {

		Ship BS1 = new BattleShip();
		Ship BC1 = new BattleCruiser();
		Ship C1 = new Cruiser();
		Ship D1 = new Destroyer();
		Ship LC1 = new LightCruiser();
		Ship S1 = new Submarine();
			
		BS1.setHorizontal(true);
		BC1.setHorizontal(true);
		C1.setHorizontal(true);
		D1.setHorizontal(true);
		LC1.setHorizontal(true);
		S1.setHorizontal(true);
		
		Ocean O1 = new Ocean();
	
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (BS1.getLength()); j++) {
				assertFalse(BS1.extendBeyondArray(i, j , O1));
			}
		}
		
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (BC1.getLength()); j++) {
				assertFalse(BC1.extendBeyondArray(i, j , O1));
			}
		}
		
		
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (C1.getLength()); j++) {
				assertFalse(C1.extendBeyondArray(i, j , O1));
			}
		}
		
		
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (D1.getLength()); j++) {
				assertFalse(D1.extendBeyondArray(i, j , O1));
			}
		}
		
		
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (LC1.getLength()); j++) {
				assertFalse(LC1.extendBeyondArray(i, j , O1));
			}
		}
		
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (S1.getLength()); j++) {
				assertFalse(S1.extendBeyondArray(i, j , O1));
			}
		}	
	}
	
	@Test
	public void verticalShipDoesNotExtendBeyondArray() {
		Ship BS1 = new BattleShip();
		Ship BC1 = new BattleCruiser();
		Ship C1 = new Cruiser();
		Ship D1 = new Destroyer();
		Ship LC1 = new LightCruiser();
		Ship S1 = new Submarine();
			
		BS1.setHorizontal(false);
		BC1.setHorizontal(false);
		C1.setHorizontal(false);
		D1.setHorizontal(false);
		LC1.setHorizontal(false);
		S1.setHorizontal(false);
		
		Ocean O1 = new Ocean();
		
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (BS1.getLength()); j++) {
				assertFalse(BS1.extendBeyondArray(j, i , O1));
			}
		}
		
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (BC1.getLength()); j++) {
				assertFalse(BC1.extendBeyondArray(j, i, O1));
			}
		}
		
		
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (C1.getLength()); j++) {
				assertFalse(C1.extendBeyondArray(j, i, O1));
			}
		}
		
		
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (D1.getLength()); j++) {
				assertFalse(D1.extendBeyondArray(j, i, O1));
			}
		}
		
		
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (LC1.getLength()); j++) {
				assertFalse(LC1.extendBeyondArray(j, i, O1));
			}
		}
		
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length - (S1.getLength()); j++) {
				assertFalse(S1.extendBeyondArray(j, i, O1));
			}
		}
		
		
	}

	
	@Test
	public void horizontalShipExtendsBeyondArray() {
		Ship BS1 = new BattleShip();
		Ship BC1 = new BattleCruiser();
		Ship C1 = new Cruiser();
		Ship D1 = new Destroyer();
		Ship LC1 = new LightCruiser();
		Ship S1 = new Submarine();
			
		BS1.setHorizontal(true);
		BC1.setHorizontal(true);
		C1.setHorizontal(true);
		D1.setHorizontal(true);
		LC1.setHorizontal(true);
		S1.setHorizontal(true);
		
		Ocean O1 = new Ocean();
		
	
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (BS1.getLength() - 1); j <= BS1.getLength(); j++) {
				
				assertTrue(BS1.extendBeyondArray(i, j, O1));
			
			}

		}
		
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (C1.getLength() - 1); j <= C1.getLength(); j++) {
				
				assertTrue(C1.extendBeyondArray(i, j, O1));
			
			}

		}
		
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (D1.getLength() - 1); j <= D1.getLength(); j++) {
				
				assertTrue(D1.extendBeyondArray(i, j, O1));
			
			}

		}
		
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (LC1.getLength() - 1); j <= LC1.getLength(); j++) {
				
				assertTrue(LC1.extendBeyondArray(i, j, O1));
			
			}

		}
		
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (BS1.getLength() - 1); j <= BS1.getLength(); j++) {
				
				assertTrue(BS1.extendBeyondArray(i, j, O1));
			
			}

		}
		
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (S1.getLength() - 1); j <= S1.getLength(); j++) {
				
				assertTrue(S1.extendBeyondArray(i, j, O1));
			
			}

		}
		
			
	}
	
	@Test
	public void verticalShipExtendsBeyondArray() {
		
		Ship BS1 = new BattleShip();
		Ship BC1 = new BattleCruiser();
		Ship C1 = new Cruiser();
		Ship D1 = new Destroyer();
		Ship LC1 = new LightCruiser();
		Ship S1 = new Submarine();
			
		BS1.setHorizontal(false);
		BC1.setHorizontal(false);
		C1.setHorizontal(false);
		D1.setHorizontal(false);
		LC1.setHorizontal(false);
		S1.setHorizontal(false);
		
		Ocean O1 = new Ocean();
		
	
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (BS1.getLength() - 1); j <= BS1.getLength(); j++) {
				
				assertTrue(BS1.extendBeyondArray(j, i, O1));
			
			}

		}
		
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (C1.getLength() - 1); j <= C1.getLength(); j++) {
				
				assertTrue(C1.extendBeyondArray(j, i, O1));
			
			}

		}
		
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (D1.getLength() - 1); j <= D1.getLength(); j++) {
				
				assertTrue(D1.extendBeyondArray(j, i, O1));
			
			}

		}
		
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (LC1.getLength() - 1); j <= LC1.getLength(); j++) {
				
				assertTrue(LC1.extendBeyondArray(j, i, O1));
			
			}

		}
		
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (BS1.getLength() - 1); j <= BS1.getLength(); j++) {
				
				assertTrue(BS1.extendBeyondArray(j, i, O1));
			
			}

		}
		
		for (int i = 0; i < O1.getShipArray().length ; i++) {

			for (int j = O1.getShipArray().length - (S1.getLength() - 1); j <= S1.getLength(); j++) {
				
				assertTrue(S1.extendBeyondArray(j, i, O1));
			
			}

		}
		
			
		
	}

	// is it on the edge - horizontal
	// sides of ship front, back, above, below
	Ship BS1 = new BattleShip();
	Ship BC1 = new BattleCruiser();
	Ship C1 = new Cruiser();
	Ship C2 = new Cruiser();
	Ship LC1 = new LightCruiser();
	Ship LC2 = new LightCruiser();
	Ship D1 = new Destroyer();
	Ship D2 = new Destroyer();
	Ship D3 = new Destroyer();
	Ship S1 = new Submarine();
	Ship S2 = new Submarine();
	Ship S3 = new Submarine();
	Ship S4 = new Submarine();
	
	
	
	
	Ocean O1 = new Ocean();
	
	//array of objects
	// 6 ship types
	
	Ship[] arrayOfShipTypes = {BS1, BC1, C1, LC1, D1, S1};
	
	

	@Test
	public void newPlaceOneShipTestIsOccupied() {
	
		
		// loop through whole array and verify it starts off as not occupied i.e. - empty sea
		for(int i = 0; i < O1.getShipArray().length; i++) {
			for(int j = 0; j <O1.getShipArray().length; j++) {
				assertTrue(O1.getShipArray()[i][j].getShipType() == "empty");
				assertFalse(O1.isOccupied(i,j));
			}
		}
		
		/*
		 * following code places ships at locations
		 * known not to be occupied
		 * do not occur on "edges" of array
		 * all coordinates are empty
		 * see 2D array grid  - paper
		 */
		
		//place one Battleship
		int BS1row = 1;
		int BS1column = 2;
		BS1.newPlaceShipAt(1, 2, true, O1);
		for (int i = BS1column; i < BS1column + BS1.getLength(); i++) {
			assertTrue(O1.isOccupied(BS1row, i));
			assertTrue(O1.getShipArray()[BS1row][i].getShipType() == "battleship");
			assertFalse(O1.getShipArray()[BS1row][i].getShipType() == "empty");
		}
		
		int BC1row = 3;
		int BC1column = 3;
		BC1.newPlaceShipAt(3, 3, true, O1);
		for (int i = BC1column; i < BC1column + BC1.getLength(); i++) {
			assertTrue(O1.isOccupied(BC1row, i));
			assertTrue(O1.getShipArray()[BC1row][i].getShipType() == "battlecruiser");
			assertFalse(O1.getShipArray()[BC1row][i].getShipType() == "empty");
		}
		
		
		//Vertical Ship Test -Cruiser 1
		int C1row = 5;
		int C1column = 4;
		C1.newPlaceShipAt(5, 4, false, O1);
		for (int i = C1row; i < C1row + C1.getLength(); i++) {
			assertTrue(O1.isOccupied(i, C1column));
			assertTrue(O1.getShipArray()[i][C1column].getShipType() == "cruiser");
			assertFalse(O1.getShipArray()[i][C1column].getShipType() == "empty");
		}
		
		//vertical Ship Test - Cruiser 2
		int C2row = 5;
		int C2column = 6;
		C2.newPlaceShipAt(5, 6, false, O1);
		for (int i = C2row; i < C2row + C2.getLength(); i++) {
			assertTrue(O1.isOccupied(i, C2column));
			assertTrue(O1.getShipArray()[i][C2column].getShipType() == "cruiser");
			assertFalse(O1.getShipArray()[i][C2column].getShipType() == "empty");
		}
		
		//horizontal ships - Destroyer 1
		
		int D1row = 5;
		int D1column = 13;
		D1.newPlaceShipAt(5, 13, true, O1);
		for (int i = D1column; i < D1column + D1.getLength(); i++) {
			assertTrue(O1.isOccupied(D1row, i));
			assertTrue(O1.getShipArray()[D1row][i].getShipType() == "destroyer");
			assertFalse(O1.getShipArray()[D1row][i].getShipType() == "empty");
		}
		
		//horizontal ship - Destroyer 2
		int D2row = 7;
		int D2column = 13;
		D2.newPlaceShipAt(7, 13, true, O1);
		for (int i = D2column; i < D2column + D2.getLength(); i++) {
			assertTrue(O1.isOccupied(D2row, i));
			assertTrue(O1.getShipArray()[D2row][i].getShipType() == "destroyer");
			assertFalse(O1.getShipArray()[D2row][i].getShipType() == "empty");
		}
		
		//horizontal ship - Destroyer 3
		int D3row = 7;
		int D3column = 13;
		D3.newPlaceShipAt(9, 13, true, O1);
		for (int i = D3column; i < D3column + D3.getLength(); i++) {
			assertTrue(O1.isOccupied(D3row, i));
			assertTrue(O1.getShipArray()[D3row][i].getShipType() == "destroyer");
			assertFalse(O1.getShipArray()[D3row][i].getShipType() == "empty");
		}
				
		//horizontal ship - Light Cruiser 1
		int LC1row = 12;
		int LC1column = 4;
		LC1.newPlaceShipAt(12, 4, true, O1);
		for (int i = LC1column; i < LC1column + LC1.getLength(); i++) {
			assertTrue(O1.isOccupied(LC1row, i));
			assertTrue(O1.getShipArray()[LC1row][i].getShipType() == "lightcruiser");
			assertFalse(O1.getShipArray()[LC1row][i].getShipType() == "empty");
		}
		
		//horizontal ship - Light Cruiser 2
		
		int LC2row = 14;
		int LC2column = 4;
		LC2.newPlaceShipAt(14, 4, true, O1);
		for (int i = LC2column; i < LC2column + LC2.getLength(); i++) {
			assertTrue(O1.isOccupied(LC2row, i));
			assertTrue(O1.getShipArray()[LC2row][i].getShipType() == "lightcruiser");
			assertFalse(O1.getShipArray()[LC2row][i].getShipType() == "empty");
		}
		
		//horizontal ship - Sub 1
		int S1row = 16;
		int S1column = 5;
		S1.newPlaceShipAt(16, 5, true, O1);
		for (int i = S1column; i < S1column + S1.getLength(); i++) {
			assertTrue(O1.isOccupied(S1row, i));
			assertTrue(O1.getShipArray()[S1row][i].getShipType() == "submarine");
			assertFalse(O1.getShipArray()[S1row][i].getShipType() == "empty");
			
		}
		
		//horizontal ship - Sub 2
		int S2row = 16;
		int S2column = 5;
		S2.newPlaceShipAt(18, 5, true, O1);
		for (int i = S2column; i < S2column + S2.getLength(); i++) {
			assertTrue(O1.isOccupied(S2row, i));
			assertTrue(O1.getShipArray()[S2row][i].getShipType() == "submarine");
			assertFalse(O1.getShipArray()[S2row][i].getShipType() == "empty");
		}
		
		//vertical ship - Sub 3
		int S3row = 16;
		int S3column = 10;
		S3.newPlaceShipAt(16, 10, false, O1);
		for (int i = S3row; i < S3row + S3.getLength(); i++) {
			assertTrue(O1.isOccupied(i, S3column));
			assertTrue(O1.getShipArray()[i][S3column].getShipType() == "submarine");
			assertFalse(O1.getShipArray()[i][S3column].getShipType() == "empty");
		}
		
		//vertical ship- Sub 4
		
		int S4row = 12;
		int S4Column = 17;
		S4.newPlaceShipAt(12, 17, false, O1);
		for (int i = S4row; i < S4row + S4.getLength(); i++) {
			assertTrue(O1.isOccupied(i, S4Column));
			assertTrue(O1.getShipArray()[i][S4Column].getShipType() == "submarine");
			assertFalse(O1.getShipArray()[i][S4Column].getShipType() == "empty");
		}
		
	
	}

	
	//GROUP OF 13 Tests to check each ship on TEST BOARD
	// 1 of 13
	@Test
	public void areaAroundBattelShipIsOccupied_EmptySea () {

		BS1.newPlaceShipAt(1, 2, true, O1);
	
		  //duplicate
		  assertFalse(BS1.okToPlaceShipAt(1, 2, true, O1));
		  
		  //above
		  assertFalse(BS1.okToPlaceShipAt(0, 2, true, O1));
		  
		  //below
		  assertFalse(BS1.okToPlaceShipAt(2, 2, true, O1));
		  
		  //left
		  assertFalse(S1.okToPlaceShipAt(0, 1, false, O1));
		  
		  //right
		  assertFalse(S1.okToPlaceShipAt(0, 10, false, O1));
		  
		  //horizontal ship, adjascent to ship and right
		  assertFalse(S1.okToPlaceShipAt(0,10, true, O1));
		  assertFalse(S1.okToPlaceShipAt(1,10, true, O1));
		  assertFalse(S1.okToPlaceShipAt(2,10, true, O1));
		  
		  
		  //True
		  assertTrue(S1.okToPlaceShipAt(0, 0, false, O1));
		  assertTrue(S1.okToPlaceShipAt(0,11, false, O1));
		  assertTrue(S1.okToPlaceShipAt(0,12, false, O1));
		  assertTrue(S1.okToPlaceShipAt(0,13, false, O1));
		  assertTrue(S1.okToPlaceShipAt(0, 11, true, O1));
		  assertTrue(S1.okToPlaceShipAt(1, 11, true, O1));
		  assertTrue(S1.okToPlaceShipAt(2, 11, true, O1));
		  assertTrue(BC1.okToPlaceShipAt(3, 3, true, O1));	

	}
	
	//2 of 13
	@Test
	public void areaAroundBattleCruiserIsOccupied_EmptySea() {
		BC1.newPlaceShipAt(3, 3,true, O1);  
		
		//Duplicate
		  assertFalse(BC1.okToPlaceShipAt(3, 3, true, O1));
		 
		  //above
		  assertFalse(BC1.okToPlaceShipAt(2, 3, true, O1));
		 
		  //below 
		  assertFalse(BC1.okToPlaceShipAt(4, 3, true, O1));
		  
		  //left
		  assertFalse(S1.okToPlaceShipAt(2, 2, false, O1));
		 
		  //right
		  assertFalse(S1.okToPlaceShipAt(2, 10, false, O1));
		 
		  //horizontal ship, adjascent and right
		  assertFalse(S1.okToPlaceShipAt(2, 10, true, O1));
		  assertFalse(S1.okToPlaceShipAt(3, 10, true, O1));
		  assertFalse(S1.okToPlaceShipAt(4, 10, true, O1));
		  
		  //adjascent ship - left
		  assertFalse(S1.okToPlaceShipAt(2, 2, false, O1));
		  assertFalse(S1.okToPlaceShipAt(4, 2, false, O1));
		  
		  //True 
		  assertTrue(BC1.okToPlaceShipAt(0, 3, true, O1));
		  assertTrue(BC1.okToPlaceShipAt(1, 3, true, O1));
		  assertTrue(BC1.okToPlaceShipAt(5, 3, true, O1));
		  assertTrue(BC1.okToPlaceShipAt(2, 12, true, O1));
		  assertTrue(BC1.okToPlaceShipAt(3, 12, true, O1));
		  assertTrue(BC1.okToPlaceShipAt(4, 12, true, O1));	
		
	}

	//3 of 13
	@Test
	public void areaAroundCruiser1IsOccupied_EmptySea() {
	  C1.newPlaceShipAt(5, 4, false, O1); 
		  
		  //Duplicate
		  assertFalse(C1.okToPlaceShipAt(5, 4, false, O1));
		 
		  //above
		  assertFalse(C1.okToPlaceShipAt(4, 1, true, O1));
		  
		  // below
		  assertFalse(C1.okToPlaceShipAt(10, 1, true, O1));
		  
		  //left
		  assertFalse(C1.okToPlaceShipAt(5, 3, false, O1));
		  assertFalse(S1.okToPlaceShipAt(4, 1, true, O1));
		  assertFalse(S1.okToPlaceShipAt(5, 1, true, O1));
		  assertFalse(S1.okToPlaceShipAt(6, 1, true, O1));
		  assertFalse(S1.okToPlaceShipAt(7, 1, true, O1));
		  assertFalse(S1.okToPlaceShipAt(8, 1, true, O1));
		  assertFalse(S1.okToPlaceShipAt(9, 1, true, O1));
		  assertFalse(S1.okToPlaceShipAt(10, 1, true, O1));
		 
		  //right
		  assertFalse(C1.okToPlaceShipAt(5, 5, false, O1));
		  assertFalse(C1.okToPlaceShipAt(6, 5, true, O1));
		  assertFalse(C1.okToPlaceShipAt(7, 5, true, O1));
		  assertFalse(C1.okToPlaceShipAt(8, 5, true, O1));
		  assertFalse(C1.okToPlaceShipAt(9, 5, true, O1));
		  assertFalse(C1.okToPlaceShipAt(10, 5, true, O1));
		  assertFalse(C1.okToPlaceShipAt(11, 5, true, O1));
		  
		 
		  //placing horizontal ship, adjascent to ship and right
		  assertFalse(C1.okToPlaceShipAt(4, 5, true, O1));
		  
		 
		  //True Assertions
		  assertTrue(S1.okToPlaceShipAt(4, 0,true, O1));
		  assertTrue(S1.okToPlaceShipAt(5, 0, true, O1));
		  assertTrue(S1.okToPlaceShipAt(6, 0, true, O1));
		  assertTrue(S1.okToPlaceShipAt(7, 0, true, O1));
		  assertTrue(S1.okToPlaceShipAt(8, 0, true, O1));
		  assertTrue(S1.okToPlaceShipAt(9, 0, true, O1));
		  assertTrue(S1.okToPlaceShipAt(10, 0, true, O1));	
			
	}
	
	//4 of 13
	@Test
	public void areaAroundCruiser2IsOccupied_EmptySea() {
		
		  C2.newPlaceShipAt(5, 6, false, O1);
		  //duplicate location
		  assertFalse(C2.okToPlaceShipAt(5, 6, false, O1));
		  
		  //above
		  assertFalse(S1.okToPlaceShipAt(4, 5, true, O1));
		  
		  //below
		  assertFalse(S1.okToPlaceShipAt(11, 5, true, O1));
		  
		  //left
		  assertFalse(S1.okToPlaceShipAt(4, 3, true, O1));
		  assertFalse(S1.okToPlaceShipAt(5, 3, true, O1));
		  assertFalse(S1.okToPlaceShipAt(6, 3, true, O1));
		  assertFalse(S1.okToPlaceShipAt(7, 3, true, O1));
		  assertFalse(S1.okToPlaceShipAt(8, 3, true, O1));
		  assertFalse(S1.okToPlaceShipAt(9, 3, true, O1));
		  assertFalse(S1.okToPlaceShipAt(10, 3, true, O1));
		  assertFalse(S1.okToPlaceShipAt(11, 3, true, O1));
		  
		  //right
		  assertFalse(S1.okToPlaceShipAt(4, 7, true, O1));
		  assertFalse(S1.okToPlaceShipAt(5, 7, true, O1));
		  assertFalse(S1.okToPlaceShipAt(6, 7, true, O1));
		  assertFalse(S1.okToPlaceShipAt(7, 7, true, O1));
		  assertFalse(S1.okToPlaceShipAt(8, 7, true, O1));
		  assertFalse(S1.okToPlaceShipAt(9, 7, true, O1));
		  assertFalse(S1.okToPlaceShipAt(10, 7, true, O1));
		  assertFalse(S1.okToPlaceShipAt(11, 7, true, O1));
		  
		  //true assertions
		  assertTrue(S1.okToPlaceShipAt(3, 5, true, O1));
		  assertTrue(S1.okToPlaceShipAt(12, 5, true, O1));
		  
		  assertTrue(S1.okToPlaceShipAt(4, 2, true, O1));
		  assertTrue(S1.okToPlaceShipAt(5, 2, true, O1));
		  assertTrue(S1.okToPlaceShipAt(6, 2, true, O1));
		  assertTrue(S1.okToPlaceShipAt(7, 2, true, O1));
		  assertTrue(S1.okToPlaceShipAt(8, 2, true, O1));
		  assertTrue(S1.okToPlaceShipAt(9, 2, true, O1));
		  assertTrue(S1.okToPlaceShipAt(10, 2, true, O1));
		  assertTrue(S1.okToPlaceShipAt(11, 2, true, O1));
		  
		  assertTrue(S1.okToPlaceShipAt(4, 8, true, O1));
		  assertTrue(S1.okToPlaceShipAt(5, 8, true, O1));
		  assertTrue(S1.okToPlaceShipAt(6, 8, true, O1));
		  assertTrue(S1.okToPlaceShipAt(7, 8, true, O1));
		  assertTrue(S1.okToPlaceShipAt(8, 8, true, O1));
		  assertTrue(S1.okToPlaceShipAt(9, 8, true, O1));
		  assertTrue(S1.okToPlaceShipAt(10, 8, true, O1));
		  assertTrue(S1.okToPlaceShipAt(11, 8, true, O1));
	
	}
	
	//5 of 13
	@Test
	public void areaAroundDestroyer1IsOccupied_EmptySea() {
		 D1.newPlaceShipAt(5,13, true, O1); 
		  //Duplicate
		  assertFalse(D1.okToPlaceShipAt(5, 13, true, O1));
		  
		  //above
		  assertFalse(D1.okToPlaceShipAt(4, 13, true, O1));
		  
		  //below
		  assertFalse(D1.okToPlaceShipAt(6, 13, true, O1));
		  
		  //left
		  assertFalse(S1.okToPlaceShipAt(4, 10, true, O1));
		  assertFalse(S1.okToPlaceShipAt(5, 10, true, O1));
		  assertFalse(S1.okToPlaceShipAt(6, 10, true, O1));
		  
		  //right
		  assertFalse(S1.okToPlaceShipAt(4, 17, true, O1));
		  assertFalse(S1.okToPlaceShipAt(5, 17, true, O1));
		  assertFalse(S1.okToPlaceShipAt(6, 17, true, O1));
		  
		 
		  //true
		  assertTrue(C1.okToPlaceShipAt(3, 12, true, O1));
		  assertTrue(C1.okToPlaceShipAt(11, 12, true, O1));
		  assertTrue(LC1.okToPlaceShipAt(5, 11, false, O1));
		  assertTrue(LC1.okToPlaceShipAt(5, 18, false, O1));	
			
	}
	
	//6 of 13
	@Test
	public void areaAroundDestroyer2IsOccupied_EmptySea() {
		D2.newPlaceShipAt(7, 13, true, O1);
		  
		  //Duplicate
		  assertFalse(D2.okToPlaceShipAt(7, 13, true, O1));
		  
		  //above
		  assertFalse(D2.okToPlaceShipAt(6, 13,true, O1));
		  
		  //below
		  assertFalse(D2.okToPlaceShipAt(8, 13,true, O1));
		  
		  //left
		  assertFalse(S1.okToPlaceShipAt(6, 12, false, O1));
		  
		  //right
		  assertFalse(S1.okToPlaceShipAt(6, 17, false, O1));
		  
		  //true 
		  assertTrue(C1.okToPlaceShipAt(3, 12, true, O1));
		  assertTrue(C1.okToPlaceShipAt(11, 12, true, O1));
		  assertTrue(LC1.okToPlaceShipAt(5, 11, false, O1));
		  assertTrue(LC1.okToPlaceShipAt(5, 18, false, O1));	
				
	}
	
	
	//7 of 13
	@Test
	public void areaAroundDestroyer3IsOccupied_EmptySea() {
	  D3.newPlaceShipAt(9, 13, true, O1);
		  
		  //Duplicate
		  assertFalse(D3.okToPlaceShipAt(9, 13, true, O1));
		  
		  //above
		  assertFalse(D3.okToPlaceShipAt(8, 13,true, O1));
		  
		  //below
		  assertFalse(D3.okToPlaceShipAt(10, 13,true, O1));
		  
		  //left
		  assertFalse(S1.okToPlaceShipAt(8, 12, false, O1));
		  
		  //right
		  assertFalse(S1.okToPlaceShipAt(8, 17, false, O1));
		  
		  //true - same as D2
		  assertTrue(C1.okToPlaceShipAt(3, 12, true, O1));
		  assertTrue(C1.okToPlaceShipAt(11, 12, true, O1));
		  assertTrue(LC1.okToPlaceShipAt(5, 11, false, O1));
		  assertTrue(LC1.okToPlaceShipAt(5, 18, false, O1));	
	
	}
	
	// 8 of 13
	@Test
	public void areaAroundLightCruiser1IsOccupied_EmptySea() {
		LC1.newPlaceShipAt(12, 4, true, O1); 
		
		//Duplicate
		assertFalse(LC1.okToPlaceShipAt(12, 4, true, O1));
		
		//above
		assertFalse(LC1.okToPlaceShipAt(11, 4, true, O1));
		
		//below
		assertFalse(LC1.okToPlaceShipAt(13, 4, true, O1));
		
		//left
		assertFalse(S1.okToPlaceShipAt(11, 3, false, O1));
		
		//right
		assertFalse(S1.okToPlaceShipAt(11, 9, false, O1));
		
		//true
		assertTrue(LC1.okToPlaceShipAt(10, 4, true, O1));
		assertTrue(LC1.okToPlaceShipAt(14, 4, true, O1));
		assertTrue(S1.okToPlaceShipAt(11, 2, false, O1));
		assertTrue(S1.okToPlaceShipAt(11, 10, false, O1)); 	
	}
	
	// 9 of 13
	@Test
	public void areaAroundLightCruiser2IsOccupied_EmptySea() {
	LC2.newPlaceShipAt(14, 4, true, O1); 
		
		//Duplicate
		assertFalse(LC2.okToPlaceShipAt(14, 4, true, O1));
		
		//above
		assertFalse(LC2.okToPlaceShipAt(13, 4, true, O1));
		
		//below
		assertFalse(LC2.okToPlaceShipAt(15, 4, true, O1));
		
		//left
		assertFalse(S1.okToPlaceShipAt(13, 3, false, O1));
		
		//right
		assertFalse(S1.okToPlaceShipAt(13, 9, false, O1));
		
		//true
		assertTrue(LC2.okToPlaceShipAt(12, 4, true, O1));
		assertTrue(LC2.okToPlaceShipAt(16, 4, true, O1));
		assertTrue(S1.okToPlaceShipAt(13, 2, false, O1));
		assertTrue(S1.okToPlaceShipAt(13, 10, false, O1)); 	
		
		
	}
	
	//10 of 13
	@Test
	public void areaAroundSub1IsOccupied_EmptySea() {
		S1.newPlaceShipAt(16, 5, true, O1); 
		
		//Duplicate
		assertFalse(S1.okToPlaceShipAt(16, 5, true, O1));
		
		//above
		assertFalse(S1.okToPlaceShipAt(15, 5, true, O1));
		
		//below
		assertFalse(S1.okToPlaceShipAt(17, 5, true, O1));
		
		//left
		assertFalse(S1.okToPlaceShipAt(15, 4, false, O1));
		
		//right
		assertFalse(S1.okToPlaceShipAt(15, 8, false, O1));
		
		//true
		assertTrue(S1.okToPlaceShipAt(14, 5, true, O1));
		assertTrue(S1.okToPlaceShipAt(18, 5, true, O1));
		assertTrue(S1.okToPlaceShipAt(15, 3, false, O1));
		assertTrue(S1.okToPlaceShipAt(15, 9, false, O1));  	
	}
	
	//11 of 13
	@Test
	public void areaAroundSub2IsOccupied_EmptySea() {
		S2.newPlaceShipAt(18, 5, true, O1); 
		
		//Duplicate
		assertFalse(S2.okToPlaceShipAt(18, 5, true, O1));
		
		//above
		assertFalse(S2.okToPlaceShipAt(17, 5, true, O1));
		
		//below
		assertFalse(S2.okToPlaceShipAt(19, 5, true, O1));
		
		//left
		assertFalse(S2.okToPlaceShipAt(17, 4, false, O1));
		
		//right
		assertFalse(S2.okToPlaceShipAt(17, 7, false, O1));
		
		//true
		assertTrue(S2.okToPlaceShipAt(17, 3, false, O1));
		assertTrue(S2.okToPlaceShipAt(17, 9, false, O1));
		assertTrue(S2.okToPlaceShipAt(16, 5, true, O1));
	}
	
	
	//12 of 13
	@Test
	public void areaAroundSub3IsOccupied_EmptySea() {
		S3.newPlaceShipAt(16, 10, false, O1); 
		
		//Duplicate
		assertFalse(S3.okToPlaceShipAt(16, 10, false, O1));
		
		//above
		assertFalse(S3.okToPlaceShipAt(15, 9, true, O1));
		
		//below
		assertFalse(S3.okToPlaceShipAt(19, 9, true, O1));
		
		//left
		assertFalse(S3.okToPlaceShipAt(16, 9, false, O1));
		
		//right
		assertFalse(S3.okToPlaceShipAt(16, 11, false, O1));
		
		//true
		assertTrue(S3.okToPlaceShipAt(16, 8, false, O1));
		assertTrue(S3.okToPlaceShipAt(16, 12, false, O1));
		assertTrue(S3.okToPlaceShipAt(14, 9, true, O1));	
	}
	
	//13 of 13
	@Test
	public void areaAroundSub4IsOccupied_EmptySea() {
		S4.newPlaceShipAt(12, 17, false, O1); 
		
		//Duplicate
		assertFalse(S4.okToPlaceShipAt(12, 17, false, O1));
		
		//above
		assertFalse(S4.okToPlaceShipAt(11, 16, true, O1));
		
		//below
		assertFalse(S4.okToPlaceShipAt(15, 16, true, O1));
		
		//left
		assertFalse(S4.okToPlaceShipAt(12, 16, false, O1));
		
		//right
		assertFalse(S4.okToPlaceShipAt(12, 18,  false, O1));
		
		//true
		assertTrue(S4.okToPlaceShipAt(10, 16, true, O1));
		assertTrue(S4.okToPlaceShipAt(16, 16, true, O1));
		assertTrue(S4.okToPlaceShipAt(12, 15, false, O1));
		assertTrue(S4.okToPlaceShipAt(12, 19, false, O1));

	}
	
	//START HER 5-16 - placing ships
	@Test
	public void OkToPlaceAllOnTestBoard () {
	
		assertTrue(BS1.okToPlaceShipAt(1, 2,true, O1));
		BS1.newPlaceShipAt(1, 2, true, O1);
		
		assertTrue(BC1.okToPlaceShipAt(3, 3, true, O1));
		BC1.newPlaceShipAt(3, 3, true, O1);
		
		assertTrue(C1.okToPlaceShipAt(5, 4, false, O1));
		C1.newPlaceShipAt(5, 4, false, O1);
		
		assertTrue(C2.okToPlaceShipAt(5, 6, false, O1));
		C2.newPlaceShipAt(5, 6, false, O1);
		
		assertTrue(LC1.okToPlaceShipAt(12, 4, true, O1));
		LC1.newPlaceShipAt(12, 4, true, O1);
		
		assertTrue(LC2.okToPlaceShipAt(14, 4, true, O1));
		LC2.newPlaceShipAt(14, 4, true, O1);
		
		assertTrue(S1.okToPlaceShipAt(16, 5, true, O1));
		S1.newPlaceShipAt(16, 5, true, O1);
		
		//assertTrue(S2.okToPlaceShipAt(18, 5, true, O1));
		S2.newPlaceShipAt(18, 5, true, O1);
	
		assertTrue(S3.okToPlaceShipAt(16, 10, false, O1));
		S3.newPlaceShipAt(16, 10, false, O1);
		
		assertTrue(S4.okToPlaceShipAt(12, 17, false, O1));
		S4.newPlaceShipAt(12, 17, false, O1);
		
		assertTrue(D1.okToPlaceShipAt(5, 13, true, O1));
		D1.newPlaceShipAt(5, 13, true, O1);
		
		assertTrue(D2.okToPlaceShipAt(7, 13, true, O1));
		D2.newPlaceShipAt(7, 13, true, O1);
		
		assertTrue(D3.okToPlaceShipAt(9, 13, true, O1));
		D3.newPlaceShipAt(9, 13, true, O1);
		
		
		
	}
	
		@Test
		public void newOkayToPlaceAtEdges() {
		//Sea is empty to isolate edge cases
		//HORIZONTAL
		assertTrue(S1.okToPlaceShipAt(0, 0, true, O1));	
		assertTrue (S1.okToPlaceShipAt(0, 17, true, O1));
		assertTrue (S1.okToPlaceShipAt(1, 0, true, O1));
		assertTrue(S1.okToPlaceShipAt(0, 5, true, O1));
		//assertTrue (S1.okToPlaceShipAt(19, 0, true, O1));
		//assertTrue(S1.okToPlaceShipAt(19, 17, true, O1));
		//assertTrue(S1.okToPlaceShipAt(19, 1, true, O1));
		assertTrue(S1.okToPlaceShipAt(1, 17, true, O1));
		
		//VERTICAL
		assertTrue(S1.okToPlaceShipAt(0, 0, false, O1));
		assertTrue(S1.okToPlaceShipAt(1, 0, false, O1));
		assertTrue(S1.okToPlaceShipAt(17, 0, false, O1));
		assertTrue(S1.okToPlaceShipAt(17, 2, false, O1));
		assertTrue(S1.okToPlaceShipAt(17, 19, false, O1));
		assertTrue(S1.okToPlaceShipAt(1, 19, false, O1));
		assertTrue(S1.okToPlaceShipAt(0, 19, false, O1));
		assertTrue(S1.okToPlaceShipAt(0, 10, false, O1));
		
		
			
		}
		
		
		@Test
		//tests whether shootAt acurrately  detects ship
		public void shootAtContainsShip(){
			Ocean O2 = new Ocean();
			
			BattleShip TestShip = new BattleShip();
			Cruiser testCruiser = new Cruiser();
			BattleCruiser testBC = new BattleCruiser();
			LightCruiser testLC = new LightCruiser();
			Destroyer testD = new Destroyer();
			Submarine testS = new Submarine();
			
			TestShip.newPlaceShipAt(1, 2, true, O2);
			testCruiser.newPlaceShipAt(5, 4, false, O2);
			testBC.newPlaceShipAt(3, 3, true, O2);
			testLC.newPlaceShipAt(12, 4, true, O2);
			testD.newPlaceShipAt(5, 13, true, O2);
			testS.newPlaceShipAt(12, 17, false, O2);
			
			
			//Battleship 1,2 horiz
			assertTrue(TestShip.shootAt(1,2));
			assertFalse(TestShip.shootAt(2,2));
			assertFalse (TestShip.shootAt(5,4));
			
			//Cruiser 5,4 vertical
			assertFalse(testCruiser.shootAt(5, 3));
			
			assertTrue(testCruiser.shootAt(5, 4));
			assertTrue(testCruiser.shootAt(6, 4));
			assertTrue(testCruiser.shootAt(7, 4));
			assertTrue(testCruiser.shootAt(8, 4));
			assertTrue(testCruiser.shootAt(9, 4));
			assertTrue(testCruiser.shootAt(10, 4));
			
			assertFalse(testCruiser.shootAt(11,4));
			
			//Light Cruiser 12,4 horiz
			for(int i = testLC.getBowColumn(); i < testLC.getBowColumn() + testLC.getLength(); i++) {
				assertTrue(testLC.shootAt(testLC.getBowRow(), i));
			}
			
			assertFalse(testLC.shootAt(12, 3));
			assertFalse(testLC.shootAt(12,9));
			
			//BattleCruiser 3,3 horiz
			for(int i = testBC.getBowColumn(); i < testBC.getBowColumn() + testBC.getLength(); i++) {
				assertTrue(testBC.shootAt(testBC.getBowRow(), i));
			}
			
			assertFalse(testBC.shootAt(3,2));
			assertFalse(testBC.shootAt(3,10));
			
			
			//Destroyer 5,13 horiz
			for(int i = testD.getBowColumn(); i < testD.getBowColumn() + testD.getLength(); i++) {
				assertTrue(testD.shootAt(testD.getBowRow(), i));
			}
			assertFalse(testD.shootAt(5,12));
			assertFalse(testD.shootAt(5,17));
			
			//Submarine 12,17 vert
			for(int i = testS.getBowRow(); i < testS.getBowRow() + testS.getLength(); i++) {
				assertTrue(testS.shootAt(i, testS.getBowColumn()));
			}
			
			assertFalse(testS.shootAt(11,17));
			assertFalse(testS.shootAt(15,17));
			
			
		}
	/*
	 * @Test public void testIsSunk() { }
	 */
		
		@Test
		//
		public void shootAtUpdatesHit() {
			
			Ocean O3 = new Ocean();
			Submarine RedS = new Submarine();
			//place ship on board
			RedS.newPlaceShipAt(16, 5, true, O3);
			//call shootAt at known location
			//currently all hit locations are false
			RedS.shootAt(16, 5);
			//after calling shootAt on unsunk ship at valid hit location
			//hit should update to true at that location
			//hit location determined by subtracting the starting column(if horiz)/starting row (if vert) of ship being shot at
			//,from the column given by user 
			assertTrue(RedS.getHit()[5 - RedS.getBowColumn()] == true);
			assertTrue(RedS.getHit()[1] == false);
			assertTrue(RedS.getHit()[2] == false);
			
			//verify functioning method, by placing and calling shootAt on 
			//each ship type
			
			BattleShip RedBS = new BattleShip();
			RedBS.newPlaceShipAt(1, 2, true, O3);
			RedBS.shootAt(1,2);
			RedBS.shootAt(1,3);
		
			assertTrue(RedBS.getHit()[2 - RedBS.getBowColumn()] == true);
			assertTrue(RedBS.getHit()[3 - RedBS.getBowColumn()] == true);
			assertTrue(RedBS.getHit()[4 - RedBS.getBowColumn()] == false);
			assertTrue(RedBS.getHit()[5 - RedBS.getBowColumn()] == false);
			assertTrue(RedBS.getHit()[6 - RedBS.getBowColumn()] == false);
			assertTrue(RedBS.getHit()[7 - RedBS.getBowColumn()] == false);
			assertTrue(RedBS.getHit()[8 - RedBS.getBowColumn()] == false);
			assertTrue(RedBS.getHit()[9 - RedBS.getBowColumn()] == false);
			
			
			BattleCruiser RedBC = new BattleCruiser();
			RedBC.newPlaceShipAt(3, 3,true, O3);
			//occupies row 3, column 3456789
			RedBC.shootAt(3,3);
			RedBC.shootAt(3, 4);
			
			assertTrue(RedBC.getHit()[3 - RedBC.getBowColumn()] == true);
			assertTrue(RedBC.getHit()[4 - RedBC.getBowColumn()] == true);
			assertTrue(RedBC.getHit()[5 - RedBC.getBowColumn()] == false);
			assertTrue(RedBC.getHit()[6 - RedBC.getBowColumn()] == false);
			assertTrue(RedBC.getHit()[7 - RedBC.getBowColumn()] == false);
			assertTrue(RedBC.getHit()[8 - RedBC.getBowColumn()] == false);
			assertTrue(RedBC.getHit()[9 - RedBC.getBowColumn()] == false);
			
			
			Cruiser RedC = new Cruiser();
			RedC.newPlaceShipAt(5, 4, false, O3);
//			occupies row 5 6 7 8 9 10, column 4
			RedC.shootAt(5, 4);
			RedC.shootAt(6, 4);
			
			assertTrue(RedC.getHit()[5 - RedC.getBowRow()] == true);
			assertTrue(RedC.getHit()[6 - RedC.getBowRow()] == true);
			assertTrue(RedC.getHit()[7 - RedC.getBowRow()] == false);
			assertTrue(RedC.getHit()[8 - RedC.getBowRow()] == false);
			assertTrue(RedC.getHit()[9 - RedC.getBowRow()] == false);
			assertTrue(RedC.getHit()[10 - RedC.getBowRow()] == false);
			
			LightCruiser RedLC = new LightCruiser();
			RedLC.newPlaceShipAt(12, 4, true, O3);
//			occupies row 12, column 4 5 6 7 8 
			RedLC.shootAt(12, 4);
			RedLC.shootAt(12, 5);
			assertTrue(RedLC.getHit()[4 - RedLC.getBowColumn()] == true);
			assertTrue(RedLC.getHit()[5 - RedLC.getBowColumn()] == true);
			assertTrue(RedLC.getHit()[6 - RedLC.getBowColumn()] == false);
			assertTrue(RedLC.getHit()[7 - RedLC.getBowColumn()] == false);
			assertTrue(RedLC.getHit()[8 - RedLC.getBowColumn()] == false);
			
			Destroyer RedD = new Destroyer();
			RedD.newPlaceShipAt(5, 13, true, O3);
//			occupies row 5, 13 14 15 16
			RedD.shootAt(5, 13);
			RedD.shootAt(5, 14);
			assertTrue(RedD.getHit()[13 - RedD.getBowColumn()] == true);
			assertTrue(RedD.getHit()[14 - RedD.getBowColumn()] == true);
			assertTrue(RedD.getHit()[15 - RedD.getBowColumn()] == false);
			assertTrue(RedD.getHit()[16 - RedD.getBowColumn()] == false);
		}
		
		@Test
		public void shipIsSunkAfterHits() {
			Ocean O4 = new Ocean();
			BattleShip BlueBS = new BattleShip();
			BlueBS.newPlaceShipAt(1, 2, true, O4);
			BlueBS.shootAt(1, 2);
			BlueBS.shootAt(1, 3);
			BlueBS.shootAt(1, 4);
			BlueBS.shootAt(1, 5);
			BlueBS.shootAt(1, 6);
			BlueBS.shootAt(1, 7);
			BlueBS.shootAt(1, 8);
			assertTrue(BlueBS.isSunk() == false);
			BlueBS.shootAt(1, 9);
			assertTrue(BlueBS.isSunk() == true);
			
			Cruiser BlueC = new Cruiser();
			BlueC.newPlaceShipAt(5, 4, false, O4);
			BlueC.shootAt(5, 4);
			BlueC.shootAt(6, 4);
			BlueC.shootAt(7, 4);
			BlueC.shootAt(8, 4);		
			BlueC.shootAt(9, 4);
			assertTrue(BlueC.isSunk() == false);
			BlueC.shootAt(10, 4);
			assertTrue(BlueC.isSunk() == true);
			
			
		}
		
		@Test
		public void EmptySeaUpdatesShipStatus() {
		Ocean O8 = new Ocean();
		// all ships start as empty
		// ship status should be "."
		EmptySea E = new EmptySea();
		
		E.newPlaceShipAt(0, 0, true, O8);
		E.shootAt(0, 0);
		assertTrue(E.getShipType() == "empty");
		assertTrue(E.toString() == "0");
		assertTrue(E.isSunk() == false);
		assertTrue(E.getBool() == false);
		//start here by testing boolean method - 6-15
		E.setBool(true);
		assertTrue(E.getBool() == true);
		assertTrue(E.shootAt(0, 0) == false);
		
		}
		
		@Test
		public void submarineShipStatusUpdates() {
		Ocean O9 = new Ocean();
		Submarine S1 = new  Submarine();
		
		S1.newPlaceShipAt(0, 0, true, O9);
		S1.shootAt(0, 0);
		S1.shootAt(0, 1);
		
		assertTrue(S1.getShipStatus()[0] == "S");
		assertTrue(S1.getShipStatus()[1]  == "S");
		assertTrue(S1.getShipStatus()[2]  == "Y");
		
		 
	
		}

	}

	

	
	
	
	
	


