package Aplication;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		// Atualizar dados
		
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller Set BaseSalary = 2090 WHERE DepartmentId = 1");
			int rows2 = st.executeUpdate("UPDATE seller Set BaseSalary = 3090 WHERE DepartmentId = 2");
			
			
			
			
			System.out.println("rows1 " + rows1);
			System.out.println("rows2 " + rows2);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaçao nao foi concluida! Caused By: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Erro tentando voltar Caused By: " + e1.getMessage());
			} 
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

		
	}

}
