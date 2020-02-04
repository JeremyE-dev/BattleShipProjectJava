package Battleship;

public class EmptySea extends Ship { 

	private boolean bool = false;


	public EmptySea() {
		super.setLength(1); 
			 
	}
	
	/*
	 * returns false indicating nothing was hit
	 */
	public boolean shootAt(int row, int column) {
//		//if this version is called
//		//update hit array to true
//		
	
		super.setEmptyHit(true);
		

		return false;
	}
	
	public boolean getBool() {
		return bool;

	}
	
	public void setBool(boolean x) {
		bool = x;
	}
	
	
	/*
	 *
	 */
	
	
	
	
	
	public boolean isSunk() {
		return false;
	}
	
	public String toString() {
		return "0";
	}
	
	
	public String getShipType() {
		return "empty";
	}
	


	
	
	
	

}
