/**
 * 
 */
package test;

import java.sql.SQLException;

import dao.DaoInstituto;
import dao.DaoOfertaEducativa;
import entidades.OfertaEducativa;

/**
 * @author usuario
 *
 */
public class TestDaoOfertaEducativa {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, Exception {
		// TODO Auto-generated method stub
/*
		DaoOfertaEducativa doe = new DaoOfertaEducativa();
		
		doe.listado(2);
	*/	
		
		/////////////////////////////////
		
		DaoInstituto daoi = new DaoInstituto();
		
		daoi.consultarNombre();
		
	}

}
