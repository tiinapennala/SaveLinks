package dao;

import model.User;

public class Dao_Users extends Dao {
	
	// Get user details for login
	public User getUser(String email, String pwd) throws Exception{
		User user=null;		
		sql = "SELECT * FROM LS_Users WHERE Email=? AND Password=?"; 		
		con = yhdista();
		if(con!=null){ //if connection is successful
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, email);	
			stmtPrep.setString(2, pwd);	
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ //if query is successful									
				while(rs.next()){
					user = new User();
					user.setUser_id(rs.getInt("user_id"));
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setEmail(rs.getString("email"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
				}					
			}
			con.close();
		}			
		return user;
	}

	// Add User
	public boolean addUser(User user){
		boolean paluuArvo=true;
		sql="INSERT INTO LS_Users(Firstname, Lastname, Email, Username, Password, Deleted) VALUES(?,?,?,?,?,?);";
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, user.getFirstname());
			stmtPrep.setString(2, user.getLastname());
			stmtPrep.setString(3, user.getEmail());
			stmtPrep.setString(4, user.getUsername());
			stmtPrep.setString(5, user.getPassword());
			stmtPrep.setString(6, "0");
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}

}
	


