package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Programm {

	public static void main(String[] args) {
        
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection(); // estabelece umma conexao 
			
			st = conn.prepareStatement(//executa um comandSQL de modelagem
				    "UPDATE seller "
					+"SET BaseSalary = BaseSalary + ?"  //Comando SQL Pra alterar os vendedores cujo departamento � igual a 2
				    +"WHERE "
			        +"(DepartmentId = ?)");
			st.setDouble(1, 200.00);  // primeiro campo � qual interroga�ao eu quero colocar o valor segundo � o valor
			st.setInt(2, 2);  
			
			int rowsAffected = st.executeUpdate(); //st.executeUpdate retorna o numero de tuplas afetadas
			System.out.println("Done Rows Affected "+ rowsAffected);
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
	}
}	
