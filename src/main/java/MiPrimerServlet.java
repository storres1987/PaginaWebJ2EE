

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AparcamientoPD_DAO;
import vo.AparcamientoPDVO;

/**
 * Servlet implementation class MiPrimerServlet
 */
public class MiPrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MiPrimerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AparcamientoPD_DAO aparcamiento = new AparcamientoPD_DAO();
		ArrayList<AparcamientoPDVO> listaAparcamientos = new ArrayList<AparcamientoPDVO>();
		listaAparcamientos = aparcamiento.getallAparcamientos();
	
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Aparcamientos de discapacitados</h2>");
		
		for (int i = 0; i < listaAparcamientos.size(); i++) {
			out.println("<p>"+ listaAparcamientos.get(i).getId() + "</p>");
			out.println("<p>"+ listaAparcamientos.get(i).getLatitud() + "</p>");
			out.println("<p>"+ listaAparcamientos.get(i).getLongitud() + "</p>");
			out.println("<p>"+ listaAparcamientos.get(i).getTitulo() + "</p>");
		}
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
