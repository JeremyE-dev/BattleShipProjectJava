package Battleship;

import static org.junit.Assert.*;



import org.junit.Test;

public class OceanTest {
	Ocean O1 = new Ocean();
	
	@Test
	public void constructorHas20EmptySeaObjects() {

	
		for (int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length; j++) {
				assertNotNull(O1.getShipArray()[i][j]);
				assertTrue(O1.getShipArray()[i][j].getShipType() == "empty");

			}
		}

	}
	
	@Test
	/*
	 * isOccupied will return false if emptySea object
	 */
	public void NotOccupiedIfEmptySeaObject() {
	
		for (int i = 0; i < O1.getShipArray().length; i++) {
			for (int j = 0; j < O1.getShipArray().length; j++) {
				assertFalse(O1.isOccupied(i,j));

			}
		}

		
	}
	

	@Test
	/* Tests placement of random ships */
	public void oneShipWasPlaced() { 
		
		BattleShip BS1 = new BattleShip();
	
		//PLACE BATTLESHIP
		Ship BS1p = O1.placeOneShipRand(BS1);
		
		
		if(BS1p.getHorizontal()) {
			for(int i = BS1p.getBowColumn(); i < (BS1p.getBowColumn() + BS1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[BS1p.getBowRow()][i].getShipType() == "battleship");
			}
			
		} else if (!BS1p.getHorizontal()) {
		
			for(int i = BS1p.getBowRow(); i < (BS1p.getBowRow() + BS1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[i][BS1p.getBowColumn()].getShipType() == "battleship");
			}
		
		}
		
		
		//PLACE BATTLECRUISER
		BattleCruiser BC1 = new BattleCruiser();
		Ship BC1p = O1.placeOneShipRand(BC1);
		
		if(BC1p.getHorizontal()) {
			for(int i = BC1p.getBowColumn(); i < (BC1p.getBowColumn() + BC1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[BC1p.getBowRow()][i].getShipType() == "battlecruiser");
			}
			
		} else if (!BC1p.getHorizontal()) {
		
			for(int i = BC1p.getBowRow(); i < (BC1p.getBowRow() + BC1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[i][BC1p.getBowColumn()].getShipType() == "battlecruiser");
			}
		
		}
		
		//PLACE CRUISER
		Cruiser C1 = new Cruiser();
		Ship C1p = O1.placeOneShipRand(C1);
		
		if(C1p.getHorizontal()) {
			for(int i = C1p.getBowColumn(); i < (C1p.getBowColumn() + C1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[C1p.getBowRow()][i].getShipType() == "cruiser");
			}
			
		} else if (!C1p.getHorizontal()) {
		
			for(int i = C1p.getBowRow(); i < (C1p.getBowRow() + C1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[i][C1p.getBowColumn()].getShipType() == "cruiser");
			}
		
		}
		
		//PLACE LIGHTCRUISER
		LightCruiser LC1 = new LightCruiser();
		Ship LC1p = O1.placeOneShipRand(LC1);
		
		if(LC1p.getHorizontal()) {
			for(int i = LC1p.getBowColumn(); i < (LC1p.getBowColumn() + LC1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[LC1p.getBowRow()][i].getShipType() == "lightcruiser");
			}
			
		} else if (!LC1p.getHorizontal()) {
		
			for(int i = LC1p.getBowRow(); i < (LC1p.getBowRow() + LC1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[i][LC1p.getBowColumn()].getShipType() == "lightcruiser");
			}
		
		}
		
		//PLACE DESTROYER
		Destroyer D1 = new Destroyer();
		Ship D1p = O1.placeOneShipRand(D1);
		
		if(D1p.getHorizontal()) {
			for(int i = D1p.getBowColumn(); i < (D1p.getBowColumn() + D1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[D1p.getBowRow()][i].getShipType() == "destroyer");
			}
			
		} else if (!D1p.getHorizontal()) {
		
			for(int i = D1p.getBowRow(); i < (D1p.getBowRow() + D1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[i][D1p.getBowColumn()].getShipType() == "destroyer");
			}
		
		}
		
		//PLACE SUBMARINE
		Submarine S1 = new Submarine();
		Ship S1p = O1.placeOneShipRand(S1);
		
		if(S1p.getHorizontal()) {
			for(int i = S1p.getBowColumn(); i < (S1p.getBowColumn() + S1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[S1p.getBowRow()][i].getShipType() == "submarine");
			}
			
		} else if (!S1p.getHorizontal()) {
		
			for(int i = S1p.getBowRow(); i < (S1p.getBowRow() + S1p.getLength()); i++) {
				assertTrue(O1.getShipArray()[i][S1p.getBowColumn()].getShipType() == "submarine");
			}
		
		}
				
		
	}		
	
	
	/* shootAt test group
	 * Does the location contain a "real" ship
	 * Is that ship sunk
	 * 
	 */
	
	@Test
	public void coordContainsRealShip() {
		Ocean O2 = new Ocean();
		// ocean will be full of empty ships
		BattleShip BS1 = new BattleShip();
		Cruiser C1 = new Cruiser();
		Submarine S1 = new Submarine();
		
		BS1.newPlaceShipAt(1, 2, true, O2);
		C1.newPlaceShipAt(5, 4, false, O2);
		S1.newPlaceShipAt(16, 5, true, O2);
		
		assertTrue(O2.shootAt(1, 2));
		assertTrue(O2.shootAt(5,4));
		assertTrue(O2.shootAt(16, 5));
		
		assertFalse(O2.shootAt(1, 10));
		assertFalse(O2.shootAt(1, 17));
		assertFalse(O2.shootAt(16, 13));
		assertFalse(O2.shootAt(19, 19));
		assertFalse(O2.shootAt(0, 0));
		
		//next sink ships and test 
		BS1.shootAt(1, 2);
		BS1.shootAt(1, 3);
		BS1.shootAt(1, 4);
		BS1.shootAt(1, 5);
		BS1.shootAt(1, 6);
		BS1.shootAt(1, 7);
		BS1.shootAt(1, 8);
		BS1.shootAt(1, 9);
		
		assertFalse(O2.shootAt(1, 2));
		
		C1.shootAt(5, 4);
		C1.shootAt(6, 4);
		C1.shootAt(7, 4);
		C1.shootAt(8, 4);
		C1.shootAt(9, 4);
		C1.shootAt(10, 4);
		
		assertFalse(O2.shootAt(5, 4));
		assertFalse(O2.shootAt(6, 4));
		assertFalse(O2.shootAt(7, 4));
		assertFalse(O2.shootAt(8, 4));
		assertFalse(O2.shootAt(9, 4));
		assertFalse(O2.shootAt(10, 4));
		
		S1.shootAt(16, 5);
		S1.shootAt(16, 6);
		S1.shootAt(16, 7);
		
		assertFalse(O2.shootAt(16, 5));
		assertFalse(O2.shootAt(16, 6));
		assertFalse(O2.shootAt(16, 7));
		
		
		
	}
	
	@Test
	public void shootAtUpdatesAccurately() {
		Ocean O3 = new Ocean();
		BattleShip BS1 = new BattleShip();
		Cruiser C1 = new Cruiser();
		Submarine S1 = new Submarine();
		
		BS1.newPlaceShipAt(1, 2, true, O3);
		C1.newPlaceShipAt(5, 4, false, O3);
		S1.newPlaceShipAt(16, 5, true, O3);
		
		
		
		
		O3.shootAt(0, 0);
		O3.shootAt(5, 5);
		O3.shootAt(16,5);
		
		assertTrue(O3.getShotsFired() == 3);
	}
	
	@Test
	public void shootAtHitsAreUpdated() {
		
		Ocean O4 = new Ocean();
		BattleShip BS1 = new BattleShip();
		Cruiser C1 = new Cruiser();
		Submarine S1 = new Submarine();
		Submarine S1sink = new Submarine();
		
		BS1.newPlaceShipAt(1, 2, true, O4);
		C1.newPlaceShipAt(5, 4, false, O4);
		S1.newPlaceShipAt(16, 5, true, O4);
		S1sink.newPlaceShipAt(12,17, false, O4);
		
		
		O4.shootAt(1,2);
		O4.shootAt(0, 0);
		O4.shootAt(5,4);
		
		assertTrue(O4.getHitCount() == 2);
		

		
	}
	
	@Test
	public void shootAtHitsCountIfNotSunk() {
		Ocean O5 = new Ocean();
		BattleShip BS1 = new BattleShip();
		Cruiser C1 = new Cruiser();
		Submarine S1 = new Submarine();
		Submarine S1sink = new Submarine();
		
		BS1.newPlaceShipAt(1, 2, true, O5);
		C1.newPlaceShipAt(5, 4, false, O5);
		S1.newPlaceShipAt(16, 5, true, O5);
		S1sink.newPlaceShipAt(12,17, false, O5);
		
		

		O5.shootAt(1, 2);
		O5.shootAt(1, 2);
		O5.shootAt(1, 2);
		
		assertTrue(O5.getHitCount() == 3);
		
		O5.shootAt(5, 4);
		O5.shootAt(5, 4);
		O5.shootAt(5, 4);
		
		assertTrue(O5.getHitCount() == 6);
		
		
		O5.shootAt(12, 17);
		O5.shootAt(13, 17);
		O5.shootAt(14, 17);
		
		O5.shootAt(12, 17);
		
		assertTrue(O5.getHitCount() == 9);
		assertTrue(O5.getShotsFired() == 10);	
		
	}
	@Test
	public void numberOfShipsSunkUpdatesAccurately() {
		Ocean O6 = new Ocean();
		
		
	
		
		
		
		O6.getAllShips()[0].newPlaceShipAt(1, 2, true, O6);

		
	
		O6.getAllShips()[0].shootAt(1, 2);
		O6.getAllShips()[0].shootAt(1, 3);
		O6.getAllShips()[0].shootAt(1, 4);
		O6.getAllShips()[0].shootAt(1, 5);
		O6.getAllShips()[0].shootAt(1, 6);
		O6.getAllShips()[0].shootAt(1, 7);
		O6.getAllShips()[0].shootAt(1, 8);
		O6.getAllShips()[0].shootAt(1, 9);
		
		assertTrue(O6.getAllShips()[0].isSunk());
		
	
		O6.setShipsSunk();

		assertTrue(O6.getShipsSunk() == 1);
		
		
	}
	
	@Test
	public void shipStatusUpdatesAccurately() {
		Ocean O7 = new Ocean();
		BattleShip BS1 = new BattleShip();
		BattleCruiser BC1 = new BattleCruiser();
		Submarine S1 = new Submarine();
		S1.newPlaceShipAt(16, 5, true, O7);
		O7.setTestAllShips(S1);
		S1.shootAt(16, 5);
		S1.shootAt(16, 6);
		S1.shootAt(16, 7);
		assertTrue(S1.getHit()[0] == true);
		assertTrue(S1.getHit()[1] == true);
		assertTrue(S1.getHit()[2] == true);
		assertTrue(S1.isSunk());
		
		assertTrue(S1.getShipStatus()[0] == "x");
		assertTrue(S1.getShipStatus()[0] == "x");
		assertTrue(S1.getShipStatus()[0] == "x");
		
		//verify emptySea
		assertTrue(O7.getShipArray()[0][0].getShipType() =="empty");
		assertTrue(O7.getShipArray()[0][0].getShipStatus()[0] ==".");
		
		
		assertTrue (!O7.shootAt(0, 0)); //does not contain valid ship
		O7.shootAt(0, 0);
		
		assertTrue(O7.getShipArray()[0][0].getShipStatus()[0] == "-");
	
		
		
		

		
		
	
		
		
		
	}
	

}