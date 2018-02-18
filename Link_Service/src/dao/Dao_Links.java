package dao;

import java.util.ArrayList;

import model.Link;

public class Dao_Links extends Dao {
	
	public ArrayList<Link> getLinks(String keyword) throws Exception{		
		ArrayList<Link> links = new ArrayList<Link>();
		sql = "SELECT * FROM LS_Links WHERE (Link LIKE ? OR Title LIKE ?) AND Deleted=0 ORDER BY Link_id DESC"; 		
		con=yhdista();
		if(con!=null){ //if connection is successful
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, "%"+keyword+"%");
			stmtPrep.setString(2, "%"+keyword+"%");
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //if query is successful								
				while(rs.next()){
					Link link = new Link();
					link.setLink_id(rs.getInt("link_id"));
					link.setLink(rs.getString("link"));
					link.setTitle(rs.getString("title"));
					link.setDetails(rs.getString("details"));
					links.add(link);
				}					
			}
			con.close();
		}			
		return links;
	}
	
	
	public Link getLink(int link_id) throws Exception{
		Link link=null;		
		sql = "SELECT * FROM LS_Links WHERE Link_id=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, link_id);			
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

	
	public int newLink(Link link){
		int paluuArvo=-1;	
		sql="INSERT INTO LS_Links(Link, Title, Details) VALUES(?,?,?);";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, link.getLink());
			stmtPrep.setString(2, link.getTitle());
			stmtPrep.setString(3, link.getDetails());
			stmtPrep.executeUpdate();
			// Haetaan generoitu id			
 			sql="SELECT MAX(Link_id) FROM LS_Links"; 	
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
	
	
	public boolean editLink(Link link){
		boolean paluuArvo=true;
		sql="UPDATE LS_Links SET Link=?, Title=?, Details=? WHERE Link_id=?;";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql);
			stmtPrep.setString(1, link.getLink());
			stmtPrep.setString(2, link.getTitle());
			stmtPrep.setString(3, link.getDetails());
			stmtPrep.setInt(4, link.getLink_id());
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	
	public void deleteLink(int Link_id) throws Exception{		
		sql = "UPDATE LS_Links SET Deleted=1 WHERE Link_id=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, Link_id);			
			stmtPrep.executeUpdate();			
			con.close();
		}		
	}
	
	
	public void addPicture(String photo, int link_id) throws Exception{		
		sql = "INSERT INTO LS_Photos(Photo_id, Link_id, Priority) VALUES(?,?,?)"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, photo);
			stmtPrep.setInt(2, link_id);
			stmtPrep.setInt(3, 0);
			stmtPrep.executeUpdate();			
			con.close();
		}		
	}
	
	
	public ArrayList<String> getPictures(int link_id) throws Exception{
		ArrayList<String> photos = null;
		sql= "SELECT * FROM LS_Photos WHERE Link_id=? ORDER BY Priority";	
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, link_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				photos = new ArrayList<String>();
				while(rs.next()){
					photos.add(rs.getString("Photo_id"));
				}					
			}
			con.close();
		}			
		return photos;		
	}
	
	public void orderPictures(String photosStr) throws Exception{
		con=yhdista();
		if(con!=null){ 
			String [] photos = photosStr.split(";");
			for(int i=0;i<photos.length;i++){
				sql = "Update LS_Photos SET Priority=? WHERE Photo_id=?"; 	
				stmtPrep = con.prepareStatement(sql); 
				stmtPrep.setInt(1, i);
				stmtPrep.setString(2, photos[i]);
				stmtPrep.executeUpdate();	
			}					
			con.close();
		}		
	}
	

	
	public void deletePicture(String photo_id) throws Exception{		
		sql = "DELETE FROM LS_Photos WHERE Photo_id=?"; 		
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, photo_id);			
			stmtPrep.executeUpdate();			
			con.close();
		}		
	}
	
	
	
	public String haePaaKuva(int link_id) throws Exception{
		String photo=null;
		sql= "SELECT * FROM LS_Photos WHERE Link_id=? ORDER BY Priority LIMIT 1";	
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, link_id);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //jos kysely onnistui									
				while(rs.next()){
					photo=rs.getString("Photo_id");
				}					
			}
			con.close();
		}		
		return photo;
	}
	
}
