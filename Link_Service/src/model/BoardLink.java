package model;

public class BoardLink {
	private int boardlink_id, link_id, board_id, deleted;

	public BoardLink() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardLink(int boardlink_id, int link_id, int board_id, int deleted) {
		super();
		this.boardlink_id = boardlink_id;
		this.link_id = link_id;
		this.board_id = board_id;
		this.deleted = deleted;
	}


	public int getBoardlink_id() {
		return boardlink_id;
	}

	public void setBoardlink_id(int boardlink_id) {
		this.boardlink_id = boardlink_id;
	}

	public int getLink_id() {
		return link_id;
	}

	public void setLink_id(int link_id) {
		this.link_id = link_id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	
	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "BoardLink [boardlink_id=" + boardlink_id + ", link_id=" + link_id + ", board_id=" + board_id
				+ ", deleted=" + deleted + "]";
	}	
	
}
