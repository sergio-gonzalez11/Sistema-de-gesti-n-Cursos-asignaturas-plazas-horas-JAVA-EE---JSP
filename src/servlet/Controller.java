package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoInstituto;
import dao.DaoOfertaEducativa;
import entidades.Instituto;
import entidades.OfertaEducativa;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String operacion = request.getParameter("operacion");
		
		switch(operacion) {
		
		case "inicio":	
			try {
				DaoInstituto daoi = new DaoInstituto();
				ArrayList<Instituto>lista = new ArrayList<Instituto>(); 
				
				lista = daoi.consultarNombre();
				
				request.setAttribute("lista", lista);
				request.getRequestDispatcher("consultas/oferta.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			
		case "mostarOfertas":
			
			try {
				DaoInstituto daoi = new DaoInstituto();
				ArrayList<Instituto>lista = new ArrayList<Instituto>(); 
				
				DaoOfertaEducativa daoe = new DaoOfertaEducativa();
				ArrayList<OfertaEducativa>listado = new ArrayList<OfertaEducativa>(); 
				
				lista = daoi.consultarNombre();
				
				if(request.getParameter("instituto").equalsIgnoreCase("default")){
					request.setAttribute("lista", lista);
					request.getRequestDispatcher("consultas/ofertas.jsp").forward(request, response);
				}
				
				
				Long idIes = Long.parseLong(request.getParameter("instituto"));
				listado = daoe.listado(idIes);
				
				Instituto i = new Instituto();
				i.setId(idIes);
				
				lista.get(lista.indexOf(i)).setSelected(true);
				
				request.setAttribute("lista", lista);
				request.setAttribute("listado", listado);
				
				request.getRequestDispatcher("consultas/ofertas.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
