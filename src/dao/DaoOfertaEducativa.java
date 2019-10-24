package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import entidades.OfertaEducativa;


public class DaoOfertaEducativa {
	
	
	public DaoOfertaEducativa() {
		
	}

	
	public ArrayList<OfertaEducativa>listado(long idIes) throws SQLException, Exception {

		Conexion conex = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<OfertaEducativa>listado = new ArrayList<OfertaEducativa>();;
		
		try {
			conex = new Conexion();
			con = conex.getConexion();
			
			ps = con.prepareStatement("SELECT O.IDIES, T.DESCRIPCION, O.IDCICLO, C.NOMBRE, O.TURNO, I.NOMBRE \r\n" + 
					"FROM OFERTAEDUCATIVA O, TURNO T, CICLO C, IES I\r\n" + 
					"WHERE I.IDIES = O.IDIES AND T.IDTURNO = O.TURNO AND C.IDCICLO = O.IDCICLO\r\n" + 
					"AND O.IDIES = ?");
			
			ps.setLong(1, idIes);
			rs = ps.executeQuery();
			
			while(rs.next()) {	
				OfertaEducativa oe = new OfertaEducativa();
			
				oe.setIdCiclo(rs.getLong(1));
				oe.setNombreCiclo(rs.getString(2));
				oe.setIdTurno(rs.getLong(3));
				oe.setNombreTurno(rs.getString(4));
				oe.setPlazas(rs.getLong(5));
				oe.setIdIes(idIes);
		
				listado.add(oe);
			}
			
			for(OfertaEducativa oe: listado) {
				System.out.println(listado.toString());
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
