

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloGrhow
 */
@WebServlet({ "/TrataRequisicao","/HelloGrhow", "/ola", "/servelet/hello", "/ola.html" })
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter saida = response.getWriter();
	
		saida.println("<h1>Hello World</h1>");
		saida.println("<p>Hello World</p>");
		saida.println("Hello World");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		RequestDispatcher despachante = request.getRequestDispatcher("saida.jsp");
			
		
		String usuario = request.getParameter("nmusuario");
		String senha = request.getParameter("nmsenha");
		
		if ( usuario.equals("Leandro") && senha.equals("admin") ) {
			
			sessao.setAttribute("attMensagem", "Usuário Logado com sucesso");
					
		} else{ 
			sessao.setAttribute("attMensagem", "Usuário ou senha incorreta!");
		}
		despachante.forward(request, response);
		
	}

}