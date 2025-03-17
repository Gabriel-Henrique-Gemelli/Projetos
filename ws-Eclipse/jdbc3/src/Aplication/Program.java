package Aplication;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		// inserir dados

		Connection conn = null;
		PreparedStatement st = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			conn = DB.getConnection();

			/*
			 * st = conn.prepareStatement("INSERT INTO seller" +
			 * "(Name, Email, BirthDate, BaseSalary, DepartmentId)" + "VALUES" +
			 * "(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS); // esse volta o ID do valor
			 * alterado
			 * 
			 * st.setString(1, "Carl Purple"); st.setString(2, "Carl@gmail.com");
			 * st.setDate(3, new java.sql.Date(sdf.parse("22/04/2000").getTime()));
			 * st.setDouble(4, 3000.00); st.setInt(5,4);
			 */

			st = conn.prepareStatement("insert into department (Name) values('D1'),('D2')",
					Statement.RETURN_GENERATED_KEYS);
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! ID = " + id);
				}
			} else {
				System.out.println("No rows affected");
			}

			System.out.println("Done! Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
