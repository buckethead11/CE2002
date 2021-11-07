package Table;


public class Table {
	private int tableID;
	//private TableSize tableSize;
	private int pax;
	private boolean occupied;
	public Table(int tableID,int pax) {
		this.tableID = tableID;
		this.pax = pax;
		occupied = false;
	}
	
	//Getters
	public int getTableID() {
		return this.tableID;
	}
	public int getPax() {
		return this.pax;
	}
	public boolean getOccupied() {
		return this.occupied;
	}
	//Setters
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
	public void setPax(int pax) {
		this.pax = pax;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
}
