package dao;

import java.util.ArrayList;

import model.Board;


public class Dao_Boards extends Dao {
	
	public ArrayList<Board> getBoards(String keyword) throws Exception{		
		ArrayList<Board> boards = new ArrayList<Board>();
		sql = "SELECT * FROM LS_Boards WHERE (Name LIKE ?) AND Deleted=0 ORDER BY Board_id DESC"; 		
		con=yhdista();
		if(con!=null){ //if connection is successful
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, "%"+keyword+"%");
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //if query is successful								
				while(rs.next()){
					Board board = new Board();
					board.setBoard_id(rs.getInt("board_id"));
					board.setName(rs.getString("name"));
					boards.add(board);
				}					
			}
			con.close();
		}			
		return boards;
	}
	
	public Board getBoard(int board_id) throws Exception{
		Board board=null;		
		sql = "SELECT * FROM LS_Boards WHERE Board_id=?";		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, board_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					board = new Board();
					board.setBoard_id(rs.getInt("board_id"));
					board.setName(rs.getString("name"));
				}					
			}
			con.close();
		}			
		return board;
	}
	
	
	public boolean newBoard(Board board){
		boolean paluuArvo=true;		
		sql="INSERT INTO LS_Boards(Name) VALUES(?);";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, board.getName());
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	
	public void deleteBoard(int Board_id) throws Exception{		
		sql = "UPDATE LS_Boards SET Deleted=1 WHERE Board_id=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, Board_id);			
			stmtPrep.executeUpdate();			
			con.close();
		}		
	}
	
	
	
}
