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
    private static final String Company_INSERT = "insert into Company values(?, ?)";
    private static final String Company_URL_UPDATE = "update Company set URL = ? where companyName = ?";
    private static final String Company_DELETE = "delete Company where companyname = ?";

    private CompanyDAO() {}

    public static CompanyDAO getInstance() {
        if (companyDAO == null) {
            companyDAO = new CompanyDAO();
        }
        return companyDAO;
    }


    public Company select(String companyName) {
        Company Company = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(URL_SELECT);
            stmt.setString(1, companyName);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String UcompanyName = rs.getString("companyName");
                String Uurl = rs.getString("url");
                Company = new Company(UcompanyName, Uurl);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return Company;
    }

    public List<Company> selectAll() {
        List<Company> CompanyList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(Company_SELECT_ALL);

            rs = stmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("companyName");
                String url = rs.getString("url");
                CompanyList.add(new Company(companyName,url));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return CompanyList;
    }

    public int insert(Company Company) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(Company_INSERT);
            stmt.setString(1, Company.getCompanyName());
            stmt.setString(2, Company.getUrl());
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
            stmt.setString(1, "companyName");
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
