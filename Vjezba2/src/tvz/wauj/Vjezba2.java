package tvz.wauj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vjezba2
 */
@WebServlet("/Vjezba2")
public class Vjezba2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vjezba2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				pr.println("<a href=\"index.html\">Nazad na Index</a>");
			}else{
				try {
					prviBroj = Double.parseDouble(prvi);
					imaPrvi = true;
				}catch(Exception e){
					bacenaIznimka = true;
					if(e.getMessage().contains("empty")){
						pr.println("Prvi broj je null!");
						pr.println("<a href=\"index.html\">Nazad na Index</a>");
					}else{
						pr.println("Prvi broj nije broj!");
						pr.println("<a href=\"index.html\">Nazad na Index</a>");
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
							pr.println("<a href=\"index.html\">Nazad na Index</a>");
					}else{
						pr.println("Drugi broj nije broj!");
						pr.println("<a href=\"index.html\">Nazad na Index</a>");
					}
				}
				
				if(bacenaIznimka == false){
					double suma = prviBroj + drugiBroj;
					pr.println("Suma brojeva je: " + suma);
					List<Character> miro = new ArrayList<>();
					List<Integer> ivo = Arrays.asList(new Integer[10]);
					//Arrays.fill(ivo, 0);
					//List<Integer> ivo = new ArrayList<>();
					for(int i=0;i<10;i++){
						ivo.set(i, 0);
					}
					for(int i = 0;i<prvi.length();i++)
					{
						miro.add(prvi.charAt(i));
					}
					for(int i = 0;i<drugi.length();i++)
					{
						miro.add(drugi.charAt(i));
					}
					for(int i = 0;i<miro.size();i++)	
					{
						Integer temp = Character.getNumericValue(miro.get(i));
						ivo.set(temp, 1);
					}
					pr.println("Znamenke: ");
					for(int i = 0;i<ivo.size();i++)
					{
						if(ivo.get(i) == 1)
						{
							System.out.println("Broj:" + i);
							pr.println(i);
						}	
					}
					pr.println("<a href=\"index.html\">Nazad na Index</a>");
				}

			}
			}catch(NullPointerException e){
				if(!imaDrugi){
					pr.println("Drugi broj apsolutno ne postoji");
					pr.println("<a href=\"index.html\">Nazad na Index</a>");
				}else if(!imaPrvi){
					pr.println("Prvi broj apsolutno ne postoji");
					pr.println("<a href=\"index.html\">Nazad na Index</a>");
				}else{
					pr.println("NullPointerException - Krivi upit!");
					pr.println("<a href=\"index.html\">Nazad na Index</a>");
				}
			}
			
			//request.getRequestDispatcher("/").forward(request, response);
			//response.sendRedirect("/Vjezba2");
			/*System.out.println("Printam listu");
			System.out.println("Size Arraylista: " + ivo.size());
			for(int i = 0;i<ivo.size();i++)	
			{
				System.out.println("Broj na " + (i+1) + "poziciji je: " + ivo.get(i));
			}*/
	
	}
}
