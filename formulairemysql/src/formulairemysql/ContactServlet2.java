package formulairemysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactServlet2
 */
@WebServlet("/ContactServlet2")
public class ContactServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String DB_URL = "jdbc:mysql://localhost:3306/db_conta";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "password";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// récupérer les données envoyées par la Servlet1
        int id = (int) request.getAttribute("t1");
        String nom=(String) request.getAttribute("t2");
        String prenom=(String) request.getAttribute("t3");
        String email=(String) request.getAttribute("t4");
        // créer un objet Contact
        Contact contact = new Contact(2, "saidi","ibtissem","email");
        contact.setid(id);
        contact.setnom(nom);
        contact.setprenom(prenom);
        contact.setemail(email);
        
        // insérer le contact dans la base de données MySQL
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO contact  VALUES 2,'saidi','ibtissem','saidiibtissem@gmail.com'")) {
            stmt.setString(1, nom);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // afficher les données du formulaire
        response.setContentType("text/html");
        response.getWriter().append("t1: " + id);
        response.getWriter().append("t2: " + nom);
        response.getWriter().append("t3: " + prenom);
        response.getWriter().append("t4: " + email);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
