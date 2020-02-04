package Battleship;

public class BattleCruiser extends Ship {


	
	public BattleCruiser() {
		super();
		super.setLength(7);
		

		
	}

	@Override
	String getShipType() {
		
		return "battlecruiser";
	}

}
