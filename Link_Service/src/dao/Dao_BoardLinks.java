package dao;

import java.util.ArrayList;

import model.Board;
import model.BoardLink;
import model.Link;

public class Dao_BoardLinks extends Dao {
	
	
	public ArrayList<BoardLink> getBoardLinks(int board_id) throws Exception{	
		ArrayList<BoardLink> boardlinks = new ArrayList<BoardLink>();
		sql = "SELECT * FROM LS_Boardlinks WHERE Board_id=? ORDER BY Boardlink_id DESC"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, board_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					BoardLink boardlink = new BoardLink();
					boardlink.setBoardlink_id(rs.getInt("Boardlink_id"));
					boardlink.setBoard_id(rs.getInt("Board_id"));
					boardlink.setLink_id(rs.getInt("Link_id"));
					boardlinks.add(boardlink);
				}					
			}
			con.close();
		}			
		return boardlinks;
	}
	
	
	public ArrayList<BoardLink> getLinksBoards(int link_id) throws Exception{	
		ArrayList<BoardLink> boardlinks = new ArrayList<BoardLink>();
		sql = "SELECT * FROM LS_Boardlinks WHERE Link_id=? ORDER BY Boardlink_id DESC"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, link_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					BoardLink boardlink = new BoardLink();
					boardlink.setBoardlink_id(rs.getInt("Boardlink_id"));
					boardlink.setBoard_id(rs.getInt("Board_id"));
					boardlink.setLink_id(rs.getInt("Link_id"));
					boardlink.setDeleted(rs.getInt("Deleted"));
					boardlinks.add(boardlink);
				}					
			}
			con.close();
		}			
		return boardlinks;
	}
	
	
	
	public Link findLink(int boardlink_id)throws Exception{		
		Link link= null;
		sql= "SELECT * FROM LS_Boardlinks, LS_Links WHERE LS_Boardlinks.Link_id=LS_Links.Link_id AND Boardlink_id=?";			
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, boardlink_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					link = new Link();
					link.setLink_id(rs.getInt("link_id"));
					link.setLink(rs.getString("link"));
					link.setTitle(rs.getString("title"));
					link.setDetails(rs.getString("details"));
				}					
			}
			con.close();
		}			
		return link;
	}
	
	
	public Board findBoard(int boardlink_id)throws Exception{		
		Board board= null;
		sql= "SELECT * FROM LS_Boardlinks, LS_Boards WHERE LS_Boardlinks.Board_id=LS_Boards.Board_id AND Boardlink_id=?";			
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, boardlink_id);			
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
	
	
 	public int addBoard(BoardLink boardlink){
		int paluuArvo=-1;		
		sql="INSERT INTO LS_Boardlinks(Link_id, Board_id) VALUES(?,?);";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setInt(1, boardlink.getLink_id());
			stmtPrep.setInt(2, boardlink.getBoard_id());			
			stmtPrep.executeUpdate();
			// Haetaan generoitu id			
 			sql="SELECT MAX(Boardlink_id) FROM LS_Boardlinks"; 	
			stmtPrep = con.prepareStatement(sql); 		
    		rs = stmtPrep.executeQuery();  
    		rs.next();
			paluuArvo=rs.getInt(1);
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
		}				
		return paluuArvo;
	}
 	
 	
 	public void deleteBoardlink(int Boardlink_id) throws Exception{		
		sql = "DELETE FROM LS_Boardlinks WHERE Boardlink_id=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, Boardlink_id);			
			stmtPrep.executeUpdate();			
			con.close();
		}		
	}
	
	
/*	THIS IS A SAFECOPY 
 	public boolean addBoard(BoardLink boardlink){
		boolean paluuArvo=true;		
		sql="INSERT INTO LS_Boardlinks(Link_id, Board_id) VALUES(?,?);";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setInt(1, boardlink.getLink_id());
			stmtPrep.setInt(2, boardlink.getBoard_id());			
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
*/	
	
	
	
	

}
