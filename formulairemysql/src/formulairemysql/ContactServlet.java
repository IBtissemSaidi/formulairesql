package formulairemysql;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	        response.getWriter().append("<form method='post'>id:<input type='text' name='t1' />nom:<input type='text' name='t2' />prenom:<input type='text' name='t3' />email:<input type='text' name='t4' /><input type='submit' value='Valider' /></form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// récupérer les données du formulaire
		
        int id= Integer.parseInt("t1");
        String nom = request.getParameter("t2");
        String prenom = request.getParameter("t3");
        String email = request.getParameter("t4");
        
        
        // ajouter les données à l'objet HttpServletRequest
        request.setAttribute("t1",id );
        request.setAttribute("t2",nom );
        request.setAttribute("t3", prenom);
        request.setAttribute("t4", email);
        
        // rediriger vers la Servlet2
        response.sendRedirect("ContactServlet2");
	}

}
