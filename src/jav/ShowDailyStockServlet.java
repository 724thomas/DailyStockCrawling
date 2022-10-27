package jav;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowDailyStockServlet", value = "/ShowDailyStockServlet")
public class ShowDailyStockServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CompanyDAO dao = new CompanyDAO();
        List<Company> result;
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Servlet</title>");
        out.println("<body>");
        out.println("<main>");
        if (request.getParameter("search").equals("")){
            out.println("<h1> 전체 주식 데이터 📄</h1>");
        }else{
            out.println("<h1>" + request.getParameter("search") + " 주식 데이터 📄</h1>");
        }

        String searchCompany = request.getParameter("search");

        if (searchCompany.equals("")) {
            System.out.println("Showing All Companies Data.");
            result = dao.selectAll();

        }else{
            System.out.println("Showing " + searchCompany + " Data");
            result = dao.selectSearch(searchCompany);
        }
        for (Company company : result){
            out.println("<li>" + company.toString() + "</li>");
        }
    }
}
