package model;

public class Board {
	private int board_id;
	private String name;
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int board_id, String name) {
		super();
		this.board_id = board_id;
		this.name = name;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Board [board_id=" + board_id + ", name=" + name + "]";
	}
	
	
	
}
