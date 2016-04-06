package tvz.wauj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//boolean bacenaIznimka = false;
/**
 * Servlet implementation class Prvi
 */
public class Prvi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prvi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pr=response.getWriter();
		response.setContentType("text/html");
		boolean bacenaIznimka = false;
		boolean imaPrvi = false;
		boolean imaDrugi = false;
		double prviBroj = 0, drugiBroj = 0;
		
		String prvi = request.getParameter("t1");
		String drugi = request.getParameter("t2");
		//}else if(prvi.equals(null) || prvi.equals("") ){
		//	pr.println("Prvi broj neispravno unesen!");
		//}else if(drugi.equals(null)|| drugi.equals("")){
		//	pr.println("Drugi broj neispravno unesen!");
			try{
			if((prvi.equals(null) && drugi.equals(null)) || (prvi.equals("") && drugi.equals(""))) {
				pr.println("Nema uopce argumenata!");
			}else{
				try {
					prviBroj = Double.parseDouble(prvi);
					imaPrvi = true;
				}catch(Exception e){
					bacenaIznimka = true;
					if(e.getMessage().contains("empty")){
							pr.println("Prvi broj je null!");
					}else{
						pr.println("Prvi broj nije broj!");
					}
				}
				try{
					drugiBroj = Double.parseDouble(drugi);
					imaDrugi = true;
				}
				catch(Exception e){
					bacenaIznimka = true;
					if(e.getMessage().contains("empty")){
							pr.println("Drugi broj je null!");
					}else{
						pr.println("Drugi broj nije broj!");
					}
				}
				
				if(bacenaIznimka == false){
					double suma = prviBroj + drugiBroj;
					pr.println("Suma brojeva je: " + suma);
				}
			}
			}catch(NullPointerException e){
				if(!imaDrugi){
					pr.println("Drugi broj apsolutno ne postoji");
				}else if(!imaPrvi){
					pr.println("Prvi broj apsolutno ne postoji");
				}else{
				pr.println("NullPointerException - Krivi upit!");
				}
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
