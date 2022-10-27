package jav;

import database.JDBCMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CompanyDAO {
    private static CompanyDAO companyDAO = null;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String Company_SELECT_ALL = "select * from Company";
    private static final String URL_SELECT = "select * from Company where URL = ?";
    private static final String Company_INSERT = "insert into Company values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String Company_URL_UPDATE = "update Company set URL = ? where companyName = ?";
    private static final String Company_DELETE = "delete Company where companyname = ?";
    private static final String Company_SELECT_SEARCH = "select * from Company where COMPANYNAME= ?";
    private static final String Company_DISTINCT_URL = "select distinct URL from Company";

    CompanyDAO() {}

    public static CompanyDAO getInstance() {
        if (companyDAO == null) {
            companyDAO = new CompanyDAO();
        }
        return companyDAO;
    }

    public boolean checkDataDuplicate(Company company){
        try{
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(Company_SELECT_ALL);
            rs = stmt.executeQuery();
            if (rs.next()){
                do{
                    String newCompanyDate = company.getCompanyName()+company.getDate();
                    String checkCompanyDate = rs.getString("COMPANYNAME") + rs.getString("STOCKDATE");
                    System.out.println(newCompanyDate);
                    System.out.println(checkCompanyDate);
                    if (newCompanyDate.equals(checkCompanyDate)){
                        return true;
                    }
                }while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkCompanyDuplicate(Company company){
        try{
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(Company_SELECT_ALL);
            rs = stmt.executeQuery();
            if (rs.next()){
                do{
                    String companyName = rs.getString("COMPANYNAME");
                    if (company.getCompanyName().equals(companyName)){
                        return true;
                    }
                }while (rs.next());
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        return false;
    }

    public Company select(String inputCompanyName) {
        Company Company = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(URL_SELECT);
            stmt.setString(1, inputCompanyName);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String companyName = rs.getString("COMPANYNAME");
                String url = rs.getString("URL");
                int juga = rs.getInt("JUGA");
                int dungrakRate = rs.getInt("DUNGRAKRATE");
                int siga = rs.getInt("SIGA");
                int goga = rs.getInt("GOGA");
                int zeoga = rs.getInt("ZEOGA");
                int georaeryang = rs.getInt("GEORAERYANG");
                String stype = rs.getString("STYPE");
                int vsyesterday = rs.getInt("VSYESTERDAY");
                String date = rs.getString("STOCKDATE");
                Company = new Company(companyName,url,juga,dungrakRate,siga,goga,zeoga,georaeryang,stype,vsyesterday,date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return Company;
    }


    public List<Company> selectSearch(String searchCompanyName){
        List<Company> CompanyList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(Company_SELECT_SEARCH);
            stmt.setString(1, searchCompanyName);

            rs = stmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("COMPANYNAME");
                String url = rs.getString("URL");
                int juga = rs.getInt("JUGA");
                int dungrakRate = rs.getInt("DUNGRAKRATE");
                int siga = rs.getInt("SIGA");
                int goga = rs.getInt("GOGA");
                int zeoga = rs.getInt("ZEOGA");
                int georaeryang = rs.getInt("GEORAERYANG");
                String stype = rs.getString("STYPE");
                int vsyesterday = rs.getInt("VSYESTERDAY");
                String date = rs.getString("STOCKDATE");
                CompanyList.add(new Company(companyName,url,juga,dungrakRate,siga,goga,zeoga,georaeryang,stype,vsyesterday,date));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return CompanyList;
    }


    public List<String> selectAllDistinctURL(){
        List<String> distinctUrlList= new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(Company_DISTINCT_URL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String url = rs.getString("URL");
                distinctUrlList.add(url);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return distinctUrlList;
    }

    public List<Company> selectAll() {
        List<Company> CompanyList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(Company_SELECT_ALL);

            rs = stmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("COMPANYNAME");
                String url = rs.getString("URL");
                int juga = rs.getInt("JUGA");
                int dungrakRate = rs.getInt("DUNGRAKRATE");
                int siga = rs.getInt("SIGA");
                int goga = rs.getInt("GOGA");
                int zeoga = rs.getInt("ZEOGA");
                int georaeryang = rs.getInt("GEORAERYANG");
                String stype = rs.getString("STYPE");
                int vsyesterday = rs.getInt("VSYESTERDAY");
                String date = rs.getString("STOCKDATE");
                CompanyList.add(new Company(companyName,url,juga,dungrakRate,siga,goga,zeoga,georaeryang,stype,vsyesterday,date));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return CompanyList;
    }

    public int insert(Company company) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(Company_INSERT);
            stmt.setString(1, company.getCompanyNameAndDate());
            stmt.setString(2, company.getCompanyName());
            stmt.setString(3, company.getUrl());
            stmt.setFloat(4,company.getJuga());
            stmt.setFloat(5,company.getDungrakRate());
            stmt.setFloat(6,company.getSiga());
            stmt.setFloat(7,company.getGoga());
            stmt.setFloat(8,company.getZeoga());
            stmt.setFloat(9,company.getGeoraeryang());
            stmt.setString(10,company.getStype());
            stmt.setFloat(11,company.getVsyesterday());
            stmt.setString(12,company.getDate());
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    public int update(String uId, String uPw) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(Company_URL_UPDATE);
            stmt.setString(1, "COMPANYNAME");
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    public int delete(String uId) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(Company_DELETE);
            stmt.setString(1, uId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }
}
