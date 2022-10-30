package sqlPack;

import java.sql.*;

public class MySql {

    static String URL = "jdbc:mysql://localhost/smalldigi";
    static String UserName = "root";
    static String Password = "8275aasl";

    static MySql tempMySql = null;

    public static MySql getMySql(){
        if(tempMySql == null){
            tempMySql = new MySql();
        }
        return tempMySql;
    }

     public Boolean ExecuteSQL(String sqlcmd) throws  SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection(URL,UserName,Password);

            Statement stm  = Con.prepareStatement(sqlcmd);
            stm.execute(sqlcmd);

            Con.close();
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    public void deleteSQl(String sqlcmd) throws ClassNotFoundException,SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL,UserName,Password);

            Statement stm = con.prepareStatement(sqlcmd);
            stm.executeUpdate(sqlcmd);
        }
        catch (Exception a){
            a.printStackTrace();
        }
    }

    public ResultSet ExecuteQuery(String sqlcmd){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection(URL,UserName,Password);

            Statement stm  = Con.prepareStatement(sqlcmd);
            ResultSet resultSet = stm.executeQuery(sqlcmd);

            //Con.close();
            return resultSet;
        }
        catch (Exception ex){
            return null;
        }
    }

    public int GetMaxIntBuyer() throws SQLException {
        String sqlCmd = String.format("SELECT MAX(idCode) FROM buyerlist");
        ResultSet rs = MySql.getMySql().ExecuteQuery(sqlCmd);
        if(rs.next()){
            return rs.getInt(1);
        }
        else
            return 0;
    }

    public int GetMaxIntSeller() throws SQLException {
        String sqlCmd = String.format("SELECT MAX(idCode) FROM sellerlist");
        ResultSet rs = MySql.getMySql().ExecuteQuery(sqlCmd);
        if(rs.next()){
            return rs.getInt(1);
        }
        else
            return 0;
    }

    public int GetMaxIntError() throws SQLException {
        String sqlCmd = String.format("SELECT MAX(idCode) FROM errorlogs");
        ResultSet rs = MySql.getMySql().ExecuteQuery(sqlCmd);
        if(rs.next()){
            return rs.getInt(1);
        }
        else
            return 0;
    }

}
