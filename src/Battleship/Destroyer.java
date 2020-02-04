package Battleship;

public class Destroyer extends Ship{
	
//	private boolean[] hit = new boolean[8];
//	private String[] shipStatus = new String[4];
	
	public Destroyer() {
		super();
		super.setLength(4);
		
//		for(int i = 0; i < hit.length; i++) {
//			hit[i] = false;
//		}
//		
//		for(int i = 0; i < shipStatus.length; i++) {
//			this.shipStatus[i] = ".";
//		}
		
	}

	@Override
	String getShipType() {
		return "destroyer";
	}

//	public String[] getShipStatus() {
//		return shipStatus;
//	}
//
//	public void setShipStatus(String[] shipStatus) {
//		this.shipStatus = shipStatus;
//	}

}
