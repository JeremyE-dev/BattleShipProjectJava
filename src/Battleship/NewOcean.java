package Battleship;

public class NewOcean {
	private Ship[][] ships = new Ship[20][20];
	int shotsFired;
	int hitCount;
	int shipsSunk;
	
	
	public NewOcean() {
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
		
		EmptySea test = new EmptySea();
		
		for(int i = 0; i < ships.length; i++) {
			for(int j = 0; j < ships.length; j++) {
			
				ships[i][j] = test;
				
			}
			
		}
	
	}
	
	public Ship[][] getShipArray() {
		return ships;
		
	}
	
	
	
		
		
		
	}






