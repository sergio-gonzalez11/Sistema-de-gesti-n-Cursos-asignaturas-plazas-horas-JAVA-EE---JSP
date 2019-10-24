package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import entidades.Instituto;


public class DaoInstituto {
	
	public DaoInstituto(){
		
	}

	public ArrayList<Instituto>consultarNombre() throws SQLException, Exception {

		Conexion conex = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Instituto>listado = new ArrayList<Instituto>();
		
		try {
			conex = new Conexion();
			con = conex.getConexion();
			
			ps = con.prepareStatement("SELECT * FROM IES");
			rs = ps.executeQuery();
			
			while(rs.next()) {	
				Instituto in = new Instituto();
			
				in.setId(rs.getLong(1));
				in.setNombre(rs.getString(2));
				
				listado.add(in);
			}
			
			for(Instituto in: listado) {
				System.out.println(in.toString());
			}
			
		
		} catch (SQLException se) {
			throw se;
		}catch (Exception e) {
			throw e;
		}finally{
			if(ps!=null)
				ps.close();
			if(rs!=null)
				rs.close();
			if(con!=null)
				con.close();
		}
		return listado;
	}
}
