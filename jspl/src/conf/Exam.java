package conf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;

public class Exam {
	
	public void init() {
		InputStream in=this.getClass().getResourceAsStream("/conf/dbconf.properties");
		Properties prop=new Properties();
		try {
			prop.load(in);
			Iterator<Object> it=prop.keySet().iterator();
			Class.forName(prop.getProperty("driver"));
			String url=prop.getProperty("url");
			String id=prop.getProperty("id");
			String pwd=prop.getProperty("pwd");
			Connection con=DriverManager.getConnection(url,id,pwd);
			String sql="select * from customer";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("customerName"));
			}
			System.out.println("연결 성공");
			while(it.hasNext()) {
				String key=(String)it.next();
				System.out.println(key+"="+prop.getProperty(key));
			}
			
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[]args) {
		System.out.println("in main");
		Exam e=new Exam();
		e.init();
	}
}
