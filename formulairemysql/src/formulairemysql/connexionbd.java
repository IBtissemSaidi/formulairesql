package formulairemysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connexionbd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_conta", "root", "");
            System.out.println("Connected!");
            Statement stmt=conn.createStatement();
            
            ResultSet rs=stmt.executeQuery("select * from contact"); 
            while(rs.next())  
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));
                 
               conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}

}
