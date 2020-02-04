package Battleship;

public class BattleShip extends Ship{
	

	public BattleShip() {
		super();
		super.setLength(8);
		

		
	}

	@Override
	String getShipType() {
		
		return "battleship";
	}


	
	

}
