package Battleship;

import java.util.*;


public class Ocean {
	
private Ship[][] ships = new Ship[20][20]; 

private String [][] gameBoard = new String[20][20];

private int shotsFired;

private int hitCount;

private int shipsSunk;

BattleShip BS1 = new BattleShip();
BattleCruiser BC1 = new BattleCruiser();
Cruiser C1 = new Cruiser();
Cruiser C2 = new Cruiser();
LightCruiser LC1 = new LightCruiser();
LightCruiser LC2 = new LightCruiser();
Destroyer D1 = new Destroyer();
Destroyer D2 = new Destroyer();
Destroyer D3 = new Destroyer();
Submarine S1 = new Submarine();
Submarine S2 = new Submarine();
Submarine S3 = new Submarine();
Submarine S4 = new Submarine();


private Ship[] allShips = {BS1, BC1, C1, C2, LC1, LC2, D1, D2, D3, S1, S2, S3, S4};

//array if ships for testing
//one ship
private Ship[] testAllShips = new Ship[1];

public Ocean() {
	this.shotsFired = 0;
	this.hitCount = 0;
	this.shipsSunk = 0;
	
	
	//EmptySea test = new EmptySea();
	
	for(int i = 0; i < ships.length; i++) {
		for(int j = 0; j < ships.length; j++) {
			EmptySea test = new EmptySea();
			ships[i][j] = test;
			
		}
		
	for (int k = 0; k < gameBoard.length; k++) {
		for (int l = 0; l < gameBoard.length; l++) {
			gameBoard[k][l] = ".";

			}
		}	
		
	}
	

		
}

//setter method to help test
public void setTestAllShips(Ship x) {
	testAllShips[0] = x;
	
}


public Ship[] getAllShips() {
	return allShips;
}

/*
 * Place all randomly on the (initially empty) ocean. 
 * Place larger ships before smaller ones, 
 * or you may end up with no legal place to put a large ship. 
 * You will want to use the Random class in the java.util package, 
 * so look that up in the Java API.
 * 
 * 13 ships total (BS - 1, BC -1 , C - 2, LC - 2, D - 3, S - 4)
 */

public void placeAllShipsRandomly() {


for(Ship x: this.getAllShips()) {
	placeOneShipRand(x);
	}

}



public Ship placeOneShipRand(Ship x) {
	int oceanLength = ships.length - 1;
	int oceanLengthMinusShipLength = oceanLength - x.getLength();
	
	Random r = new Random();
	Random rBool = new Random();
	
	boolean randHorizontal = rBool.nextBoolean(); //Randomly true or false
	boolean tempBool = randHorizontal;
	
	int randRow;
	int randColumn;
	int tempRow;
	int tempCol;
	
	if (tempBool) {
		randRow = r.nextInt(oceanLength); 
		randColumn = r.nextInt(oceanLengthMinusShipLength);
			
		tempRow = randRow;
		tempCol = randColumn;
	
	}
	
	else {
		randRow = r.nextInt(oceanLengthMinusShipLength);
		randColumn = r.nextInt(oceanLength); 
			
		tempRow = randRow;
		tempCol = randColumn;
		
	}
	
//**************************************************************

	if (x.okToPlaceShipAt(tempRow, tempCol, tempBool, this)) {
			x.newPlaceShipAt(tempRow, tempCol, tempBool, this);
			return x;
		}
	
	else {
		
			while (!x.okToPlaceShipAt(tempRow, tempCol, tempBool, this)) {

				if (tempBool) {
					randRow = r.nextInt(oceanLength); 
					randColumn = r.nextInt(oceanLengthMinusShipLength);
						
					tempRow = randRow;
					tempCol = randColumn;
				
				}
				
				else {
					randRow = r.nextInt(oceanLengthMinusShipLength);
					randColumn = r.nextInt(oceanLength); 
						
					tempRow = randRow;
					tempCol = randColumn;
					
				}
				
			}

			x.newPlaceShipAt(tempRow, tempCol, tempBool, this);

			return x;

	}
		
}



/*
 *Returns true if given 
 *location contains a ”real” ship, still afloat,
 * (not an EmptySea), 
 *false if it does not. 
 *In addition, this method updates 
 *the number of shots that have been fired, 
 *and the number of hits. 
 *Note: If a location contains a ”real” ship, 
 *shootAt should return true every time the 
 *user shoots at that same location. 
 *Once a ship has been ”sunk”, 
 *additional shots at its location should return false. 
 * 
 */



/*
 * Returns true if location contains a "real" ship, not and EmptySea, false if not
 * This method updates number of shots fired <total by user>
 * This method updates the number of hits <total for game>
 * If location contains "real" ship, shootAt returns true every time user shoots at same location
 * Once a ship is sunk - additional shots will return false
 * 
 * 
 * 
 */


public boolean shootAt(int row, int column) {

	
	if(this.getShipArray()[row][column].getShipType() == "empty" || this.getShipArray()[row][column].isSunk()) {
		shotsFired++;
		
		return false;
	}
	
	else {
		shotsFired++;
		if(this.getShipArray()[row][column].getHorizontal() == true) {
			
			int x = this.getShipArray()[row][column].getBowColumn();
			int y = column;
		
			
			int hitIndex = y - x;
			
			this.getShipArray()[row][column].getHit()[hitIndex]= true;
			hitCount++;
		
			return true;	
				
			}
		else {
			int x = this.getShipArray()[row][column].getBowRow();
			int y = row;
			
			
			int hitIndex = y - x;
			
			this.getShipArray()[row][column].getHit()[hitIndex]= true;
			hitCount++;
			
			
			return true;
		}
		
	}
}


//Helper Ships Sunk



public int getShotsFired() {
	return shotsFired;
}


public String[][] getGameBoard() {
	return gameBoard;
}


public void setGameBoard(String[][] gameBoard) {
	this.gameBoard = gameBoard;
}

/*
 * gets status from ships on board, updates symbol per ship status
 * at the location
 */
public void updateGameBoardEmptyShips () {


	
	for(int i = 0; i < this.getShipArray().length; i++ ) {
		for (int j = 0; j < this.getShipArray().length; j++) {
			if(this.getShipArray()[i][j].getShipType() == "empty" 
					&& this.getShipArray()[i][j].getEmptyHit() == true) {
					gameBoard[i][j] = "-";
			}
			
		}
	}
	
}
	
public void updateGameBoardRealShips() {

	
	
	for(Ship x : this.allShips) {
		int shipRow = x.getBowRow();
		int shipColumn = x.getBowColumn();
		int shipLength = x.getLength();
		boolean shipHoriz = x.getHorizontal();
		String[] s = x.getShipStatus();
		
			if (shipHoriz) {
				for (int i = 0; i < shipLength; i++) { 
					gameBoard[shipRow][shipColumn] = s[i];
					shipColumn++;
				}
			}
		
			else {
				for (int i = 0; i < shipLength; i++) {
					gameBoard[shipRow][shipColumn] = s[i];
					shipRow++;
				}
			}

	}
	
	
	
	}


public void setShotsFired(int shotsFired) {
	this.shotsFired = shotsFired;
}


public int getHitCount() {
	return hitCount;
}


public void setHitCount(int hitCount) {
	this.hitCount = hitCount;
}


public int getShipsSunk() {
	return shipsSunk;
}


public void setShipsSunk() {
	for(Ship x: this.getAllShips()) {
		if(x.isSunk()) {
			shipsSunk++;
		}
	}
}




public boolean isOccupied(int row, int column) {
	if (this.ships[row][column].getShipType() == "empty") {
	 return false;
	}
	
	else {
		return true;
	}
	 
}


public Ship[][] getShipArray() {
	return ships;
}

public void print() {

	


for (int i = 0; i < 20; i++) {
	System.out.printf("%4d", i);
}
System.out.println();



int i = 0; 
for (String[] row : gameBoard) {
	
	

	
	System.out.printf("%-3d", i);

	
	Arrays.toString(row)
		.replace("[", "")
		.replace("]", "")
		.replace( "," , "");
	
	for(String x: row) {
		System.out.printf("%-4s", x);	
	}
	System.out.println();
	
	
	i++;
	
}

	

}

public boolean isGameOver() {
	this.setShipsSunk();
	
	if (this.getShipsSunk() == this.getAllShips().length) {
		return true;
	}
	
	else {
		return false;
	}
	
}



}
