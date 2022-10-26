package jav;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DoCompanyAddServlet", value = "/DoCompanyAddServlet")
public class DoCompanyAddServlet extends HttpServlet {

    static final AddDatabase database = AddDatabase.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CompanyDAO dao = new CompanyDAO();
        Company newCompany = new Company();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Servlet</title>");
        out.println("<body>");
        out.println("<main>");
        out.println("<h1>Search Result 📄</h1>");

        String url = "";
        String companyName="";
        if (request.getParameter("url")!=null){
            url = request.getParameter("url");
            companyName=StockCrawling.getCompanyFromUrl(url);
            newCompany.setCompanyName(companyName);
            newCompany.setUrl(url);
            out.println("<li>" + companyName + "</li>");
            if (companyName!="" && dao.checkDuplicate(newCompany)==false){
                dao.insert(newCompany);
                System.out.println("No Duplicates. Inserted Data");
            }else{
                System.out.println("Duplicates. No Inserted Data");
            }
        }
    }
}
