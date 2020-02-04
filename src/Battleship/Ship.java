package Battleship;

/*
 * Since we don’t really care which end of a ship is the bow and which the stern, 
 * we will consider all ships to be facing up or left. 
 * Other parts of the ship are in higher-numbered rows or columns.
 * You don’t need to write a constructor for this class–
 * Java will automatically supply one for you (with no arguments).
 */

public abstract class Ship {
	private int bowRow;
	private int bowColumn;
	private int length;
	private boolean horizontal;
	private boolean emptyHit = false;
	private boolean[] hit = new boolean[8];
	private String[] shipStatus = new String[] {".",".", "." ,".", ".", ".",".", ".", "."};
	
	
	
	
	// no constructor - java will supply default (as with all classes)

	abstract String getShipType();
	
	/* 
	 * Returns true if it is okay to put a ship of this length 
	 * with its bow in this location, with the given orientation, 
	 * and returns false otherwise. The ship must not overlap another ship, 
	 * or touch another ship (vertically, horizontally, or diagonally), 
	 * and it must not ”stick out” beyond the array. Do not actually change either the ship or the Ocean, 
	 * just says whether it is legal to do so.

	 */
	

	
	//UNIT TESTED METHODS

	
	//assume no coordinate is less than 0
	// return true if extends beyond array
	public boolean extendBeyondArray(int row, int column, Ocean ocean) {
		if (horizontal) {
			if (row > ocean.getShipArray().length || column + length > ocean.getShipArray()[0].length) {
				return true;
			}

			else {
				return false;
			}
		}

		else {
			if (row > ocean.getShipArray().length || row + length > ocean.getShipArray().length) {
				return true;
			}

			else {
				return false;
			}
		}

	}
	
	

	public void newPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	

		
		
	if (horizontal) {
		for (int i = column; i < (column + this.length); i++) {
			ocean.getShipArray()[row][i] = this;
			}
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
	
		ocean.setTestAllShips(this);
		}

	else {
		for (int i = row; i < (row + this.length); i++) {
			ocean.getShipArray()[i][column] = this;
			}
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		
		ocean.setTestAllShips(this);

		}
		

	}
	
	

	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		//check if extends beyond array -- add later
		if (this.extendBeyondArray(row, column, ocean)) {
			return false;
		}
		
		if (horizontal) return this.horizontalEdgeCheck(row, column, horizontal, ocean);
		
		else return this.verticalEdgeCheck(row, column, horizontal, ocean);
		
	
			
	}
		
	
	//HELPER - newOKToPlaceShipAt
	public boolean horizontalEdgeCheck (int row, int column, boolean horizontal, Ocean ocean) {
		
		// 1 of 9 Does not check - row above or column to left -- bc OOB (out Of Bounds) -TESTED
		if (horizontal && row == 0 && column == 0) {
			for (int i = column ; i <= (column + this.getLength()); i++) {
				if (ocean.isOccupied(row, i) || ocean.isOccupied(row + 1, column)) {
					return false;			
				}
			} 
			// if not false by this point - return true
			
			return true;	
		}
		
		 // 2 of 9 Does not check =row above or column to right - bc OOB -- TESTED 
		if (horizontal && row == 0 && column + (length -1) == 19) { 
			for (int i = column - 1; i < (column + this.getLength()); i++) { 
				if (ocean.isOccupied(row, i) || ocean.isOccupied(row + 1, column)) { 
					return false; 
				} 
				
			} // if not false by this point - return true
		  
			return true;
		  
		  } 
		
		 // 3 of 9 Does not check - row to left -- TESTED 
		if (horizontal && row >= 1 && column == 0 && row < 19) { 
			for (int i = column ; i <= (column + this.getLength()); i++) {
				if (ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, column) || 
						ocean.isOccupied(row + 1, column)) {
					return false; 
				}
		  
		  } // if not false by this point - return true
		  
		  return true; 
		  
		}
		
		 // 4 of 9 Does not check row above -- TESTED 
		if (horizontal && row == 0 && column >= 1) { 
			for (int i = column - 1; i <= (column + this.getLength()); i++) {
				if (ocean.isOccupied(row, i) || ocean.isOccupied(row + 1, i)) {
					return false;
				}
		 
		 } // if not false by this point - return true
		  
		  return true;
		  
		}
		 
		 // 5 of 9 Does not check colum to left or row below -- TESTED 
		if (horizontal && row == 19 && column == 0) {
			for (int i = column; i <= (column + this.getLength()); i++) {
				if (ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, column)) {
					return false;

				}

			} // if not false by this point - return true

			return true;
		}
		
		
		// 6 of 9 Does not check row below or column to right -TESTED 
		if (horizontal && row == 19 && column >= 1 && column + (length - 1) == 19) {
			for (int i = column - 1; i < (column + this.getLength()); i++) {
				if (ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, column)) {
					return false;

				}

			} // if not false by this point - return true

			return true;

		}
		
		
		 // 7 of 9 does not check below
		if (horizontal && row == 19 && column >= 1 && column + (length - 1) < 19) {
			for (int i = column - 1; i <= (column + this.getLength()); i++) {
				if (ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, i)) {
					return false;

				}

			} // if not false by this point - return true

			return true;

		}
		
		 // 8 of 9  Does not check right
		// 
		
		if (horizontal && row < 19 && column + (length - 1) == 19) {
			for (int i = column - 1; i < (column + this.getLength()); i++) {
				if (ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, i)
						|| ocean.isOccupied(row + 1, i)) {
					return false;
				}
			}

			return true;

		  }
		 
	
		
		// 9 of 9 COMMON CASE
		else { 
			for (int i = column - 1; i <= (column + this.getLength()); i++) { 
				if (ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, i) ||
				ocean.isOccupied(row + 1, i)) {
					return false;
				}
			 
			 }
			
			 // if not false by this point - return true
			
			 return true;
			  
		}
	
	
	
	
	}
	// Helper newOKToPlaceShip
	public boolean verticalEdgeCheck (int row, int column, boolean horizontal, Ocean ocean) {
		
		  //1 of 9 -- does not check above or left 
		if(!horizontal && row == 0 && column == 0 && row + (length - 1) < 19) { 
			for (int i = row; i <= (row + this.getLength()); i++) { 
				if (ocean.isOccupied(i, column) || ocean.isOccupied(i, column + 1)) { 
					return false; 
				}
		  
		  }
		  
		  // if not false by this point - return true
		  
		  return true; }
		  
		 
		   
		  
		  //2 of 9 -- Does not check Left
		
		if (!horizontal && row >= 1 && row < 19 && column == 0 && row + (length -1 ) != 19) {
			for (int i = row - 1; i <= (row + this.getLength()); i++) {
				if (ocean.isOccupied(column, i) || ocean.isOccupied(column + 1, i)) {
					return false;
				}

			}

			// if not false by this point - return true

			return true;
		}
		 
		 
		
		  //3 of 9 -- Does not check left or below
		if(!horizontal && row + (length -1 ) == 19 && column == 0) {
			
			for (int i = row - 1; i < (row + this.getLength()); i++) { 
				if (ocean.isOccupied(column, i) || ocean.isOccupied(column + 1, i)) {
					return false;
				}
			 
			 }
			
			 // if not false by this point - return true
			
			 return true;
			
		}
		
		// 4 of 9 -- does not check below
		if (!horizontal &&  row + (length - 1) == 19 && column > 0 && column < 19) {
			for (int i = row - 1; i < (row + this.getLength()); i++) { 
				if (ocean.isOccupied(i, column) || ocean.isOccupied(i, column - 1) ||
				ocean.isOccupied(i, column + 1)) {
					return false;
				}
			 
			 }
			
			 // if not false by this point - return true
			
			 return true;	
		}
		
		// 5 of 9
		if(!horizontal && row + (length -1) == 19 && column == 19) {
			for (int i = row - 1; i < (row + this.getLength()); i++) { 
				if (ocean.isOccupied(column, i) || ocean.isOccupied(column - 1, i)){
					return false;
				}
			 
			 }
			
			 // if not false by this point - return true
			
			 return true;
		}
		
		//6 of 9
		if(!horizontal && row >= 1 && row + (length -1) < 19 && column == 19) {
			for (int i = row - 1; i <= (row + this.getLength()); i++) { 
				if (ocean.isOccupied(column, i) || ocean.isOccupied(column - 1, i)) {
					return false;
				}
			 
			 }
			
			 // if not false by this point - return true
			
			 return true;	
			
		}
		
		//7 of 9
		if(!horizontal && row == 0 && column == 19 && row + (length -1) < 19) {
			for (int i = row; i <= (row + this.getLength()); i++) {
				if (ocean.isOccupied(column, i) || ocean.isOccupied(column - 1, i)) {
					return false;
				}

			}
		
		 // if not false by this point - return true
		
		 return true;
		}	
		
		
		//8 of 9
		// checking s1.0,10 vert
		
		if(!horizontal && row == 0 && column < 19 && row + (length -1) < 19) {

			for (int i = row ; i <= (row + this.getLength()); i++) {
				if (ocean.isOccupied(i, column) || ocean.isOccupied(i, column - 1)
						|| ocean.isOccupied(i, column + 1)) {
					return false;
				}

			}

			// if not false by this point - return true

			return true;

		}
			  

		// 9 of 9 COMMON CASE (checks all four sides for occupation)
		
		// swapped column and row
		else {
			for (int i = row - 1; i <= (row + this.getLength()); i++) {
				if (ocean.isOccupied(i, column) || ocean.isOccupied(i, column - 1)
						|| ocean.isOccupied(i, column + 1)) {
					return false;
				}

			}
		
		 // if not false by this point - return true
		
		 return true;
		}
		
	}

	
	/*
	 * ”Puts” the ship in the ocean. This involves giving values to the bowRow,
	 *  bowColumn, and horizontal instance variables in the ship, 
	 * and it also involves putting a reference to the ship in each
	 *  of 1 or more locations (up to 8) 
	 * in the ships array in the Ocean object. 
	 * (Note: This will be as many as eight identical references; 
	 * you can’t refer to a ”part” of a ship, only to the whole ship.
	 * )
	 */

	//OLD - delete during clean up //
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	if (!this.okToPlaceShipAt(row, column, horizontal, ocean)) { 
		int tempRow = row;
		int tempColumn = column;
		if (horizontal) {
			for(int i = 0; i < length; i++) {
				ocean.getShipArray()[row][tempColumn] = this;
				tempColumn++;
			}
		}
		else {
			for(int j = 0; j < length; j++) {
				ocean.getShipArray()[tempRow][column] = this;
				tempRow++;	
			}
			
		}
			
		
	}
	
	}
	
	/*
	 * If a part of the ship occupies the given row and column, 
	 * and the ship hasn’t been sunk, mark that part of the ship as ”hit” (in the hit array, 0 indicates the bow) 
	 * and return true, otherwise return false.
	 */
	public boolean shootAt(int row, int column) {

		if(this.getShipType() == "empty") {
			this.emptyHit = true;
			this.shipStatus[0] = "-";
			return false;
		}
		
		
		if (this.horizontal) {
			for(int i = this.bowColumn; i < (this.bowColumn + this.length); i++) {
				if (bowRow == row && i == column && !this.isSunk()) {
					this.hit[column - bowColumn] = true;
					
					if(isSunk()) {
						for(int j = 0; j < this.length; j++) {
							this.shipStatus[j] = "x";
						}
					}
					
					
					else {
						this.shipStatus[column - bowColumn] = "S";
					}
					
					return true;
				}
					
			}
			
			return false;
		}
		
		else {
			for(int i = this.bowRow; i < (this.bowRow + this.length); i++ ) {
				if (i == row && bowColumn == column && !this.isSunk()) {
					this.hit[row - bowRow] = true;
					
				
					if(isSunk()) {
						for(int j = 0; j < this.length; j++) {
							this.shipStatus[j] = "x";
						}
					}
					
					else {
					
					this.shipStatus[row - bowRow] = "S";
					
					}
					
					
					return true;
				}
			}
			
			return false;
			
		}
		
				
	}
	
	/*
	 * Return true if every part of the ship has been hit, false otherwise.
	 */
	boolean isSunk() {
		
		for (int i = 0; i < this.getLength(); i++) {
			if (hit[i] == false) {
				return false;
			}

		}
		
	

		return true;
	}
	
	public String toString() {
		return "string"; //placeholder
	}

	public int getBowRow() {
		return bowRow;
	}

	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}

	public int getBowColumn() {
		
		return bowColumn;
	}

	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean[] getHit() {
		return hit;
	}

	public void setHit(boolean[] hit) {
		this.hit = hit;
	}

	public void place (int bowRow, int bowColumn, boolean horizontal, Ocean ocean) {
		if (horizontal) {

			for(int i = 0; i < this.length; i++) {
				ocean.getShipArray()[bowRow][bowColumn + i] = this;



			}
		}
		
	}

	public String[] getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(String[] shipStatus) {
		this.shipStatus = shipStatus;
	}
	
	public void setEmptySeaStatus(int index, String s) {
		this.shipStatus[index] = "-"; 
	}
	
	public boolean getEmptyHit() {
		return emptyHit;
	}
	
	public void setEmptyHit(boolean x) {
		this.emptyHit = x;
	}
	
	
	
	
	
	

}
