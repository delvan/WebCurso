package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	
		private String drive = "com.mysql.jdbc.Driver";
		private String URL = "jdbc:mysql://localhost/icarros";
		private String USER = "root";
		private String SENHA = "admin";
		private Connection conn;
	
	  public Conexao() {
		  
		  try {
			  
			  Class.forName(drive);
			  
			  conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
			  
		  }catch(Exception e) {
			  
			  e.printStackTrace();
			  
		  }	
		  
	  }
	  public Connection getConn() {
		  
		  System.out.println("Sucesso");
		  return conn;
	  }
	  
	  public void fecharConexao() {
		  try {
			  conn.close();
		  }catch (SQLException e) {
			e.printStackTrace();
		}
	  }

}
