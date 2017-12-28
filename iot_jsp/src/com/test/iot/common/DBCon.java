package com.test.iot.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBCon {

	private static Connection conn;
	public static Connection getCon() {
		if (DBCon.conn == null) {
			Context initContext;
			try {
				initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource) envContext.lookup("jdbc/IOT");
				System.out.print(ds);
				DBCon.conn = ds.getConnection();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(DBCon.conn);
		return DBCon.conn;
	}

	public static void closeCon() {
		try {
			DBCon.conn.close();
			DBCon.conn = null;
			System.out.println("conn 종료됨");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void commit() throws SQLException {
    	conn.commit();
    }
    
    public void rollback() throws SQLException {
    	conn.rollback();
    }
}
