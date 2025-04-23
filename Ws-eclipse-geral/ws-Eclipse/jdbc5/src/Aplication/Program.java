package Aplication;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		// Atualizar dados
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "id = ?");
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Donw! Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage()); 
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

		
	}

}
