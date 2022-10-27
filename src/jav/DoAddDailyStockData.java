package jav;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DoAddDailyStockData", value = "/DoAddDailyStockData")
public class DoAddDailyStockData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CompanyDAO dao = new CompanyDAO();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Servlet</title>");
        out.println("<body>");
        out.println("<main>");
        out.println("<h1>Search Result 📄</h1>");

        List<Company> allCompanies = dao.selectAll();
        List<String> urlList = dao.selectAllDistinctURL();
        String[] companyNameAndDate = new String[allCompanies.size()];
        int index=0;
        for(Company company : allCompanies){
            companyNameAndDate[index]=company.getCompanyNameAndDate();
            index++;
        }

        Company newCompany;
        String newCompanyNameAndDate;
        boolean exist;
        for (String url : urlList){
            exist=false;
            newCompany=StockCrawling.getCompanyDataFromUrl(url);
            newCompanyNameAndDate=newCompany.getCompanyNameAndDate();


            for (int i=0; i<companyNameAndDate.length; i++){
                if(newCompanyNameAndDate.equals(companyNameAndDate[i])){
                    exist=true;
                }
                System.out.println("NewCompanyNameAndDate : " + newCompanyNameAndDate);
                System.out.println("ExistingCompanyNameAndDate : " + companyNameAndDate[i]);
            }
            if (exist){
                System.out.println("Not Adding Data" + newCompany.getUrl());
            }else{
                dao.insert(newCompany);
                System.out.println("Added New Data " + newCompany.getUrl());
            }
        }
    }
}
