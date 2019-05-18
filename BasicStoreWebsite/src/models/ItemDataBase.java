package models;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import info.MyDBInfo;

public class ItemDataBase {
    private Connection con;
    private Statement stmt;

    private String user = MyDBInfo.MYSQL_USERNAME;
    private String pass = MyDBInfo.MYSQL_PASSWORD;
    private String server = MyDBInfo.MYSQL_DATABASE_SERVER;
    private String dataBase = MyDBInfo.MYSQL_DATABASE_NAME;
    

    public ItemDataBase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection
                    ( "jdbc:mysql://" + server, user, pass);
            stmt = con.createStatement();
            stmt.executeQuery("USE " + dataBase);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public Item getItem(String id){
    	String query = "SELECT * FROM products";
    	query += "\nwhere productid = \'" + id + "\'";
    	Item it = null;
        try {
        	ResultSet rs = stmt.executeQuery(query);
        	rs.next();
            it = new Item(rs.getString("productid"), rs.getString("name"),
                    rs.getString("imagefile"), (int)rs.getLong("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return it;
    }
    
    public List<Item> getAllItems(){
    	List<Item> result = new ArrayList<Item>();
    	String query = "SELECT * FROM products";
    	Item it = null;
        try {
        	ResultSet rs = stmt.executeQuery(query);
        	while(rs.next()) {
	            it = new Item(rs.getString("productid"), rs.getString("name"),
	                    rs.getString("imagefile"), (int)rs.getLong("price"));
	            result.add(it);
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static void main(String[] args) {
    	ItemDataBase db = new ItemDataBase();
    	System.out.println(db.getItem("HC").toString());
    }
}
