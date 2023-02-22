package DAO;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class ConnectDAO {

    String Host = "localhost";
    String UserName = "root";
    String Password = "";
    String DataBase = "school";

    Connection connect = null;
//    Statement statement = null;
//    ResultSet result = null;
    
    public ConnectDAO(){
    
    }

//    public ConnectDAO(String host, String username, String password, String database) {
//        this.Host = host;
//        this.UserName = username;
//        this.Password = password;
//        this.DataBase = database;
//    }

    // Hàm kiểm tra driver
    public static void driverTest() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            throw new Exception("Mysql JDBC Driver not found...");
        }
    }

    // Hàm lấy connection
    public Connection getConnect() throws Exception {
        // Nếu connection null thì khởi tạo mới
        if (this.connect == null) {
            //Kiểm tra driver
            driverTest();

            //Tạo url kết nối tới database
            String url = "jdbc:mysql://" + this.Host + ":3306/" + this.DataBase;

            try {
                //Tạo connection thông qua url            
                this.connect = (Connection) DriverManager.getConnection(url, this.UserName, this.Password);
            } //Nếu không thàng công thì ném lỗi ra ngoài
            catch (java.sql.SQLException e) {
                throw new Exception("Khong the ket noi toi server: " + url + e.getMessage());
            }
        }
        // Trả connection ra ngoài
        return this.connect;
    }

    //Tạo statement để thực thi câu lệnh query
//    private Statement getStatement() throws SQLException, Exception {
//        //Kiểm tra statement = null hoặc đã đóng
//        if (this.statement == null || this.statement.isClosed()) {
//            //Khởi tạo một statement mới
//            this.statement = this.getConnect().createStatement();
//        }
//        //Trả về statement
//        return this.statement;
//    }

    //Hàm thực thi câu lệnh Select lấy dữ liệu từ mySql
//    public ResultSet excuteQuery(String query) throws Exception {
//        try {
//            // Thực thi câu lệnh
//            this.result = this.getStatement().executeQuery(query);
//        } //Nếu không thành công ném lỗi ra ngoài
//        catch (Exception e) {
//            throw new Exception("Error: " + e.getMessage());
//        }
//        return this.result;
//    }

    //Hàm thực thi câu lệnh insert, update, delete
//    public int excuteUpdate(String query) throws Exception {
//        //Khai báo biến int lưu trữ kết quả tình trạng thực thi câu truy vấn
//        int res = Integer.MIN_VALUE;
//        try {
//            //Thực thi câu lệnh
//            res = this.getStatement().executeUpdate(query);
//        } //Nếu không thành công ném lỗi ra ngoài
//        catch (Exception e) {
//            throw new Exception("Error: " + e.getMessage());
//        } finally {
//            //Đóng kết nối
//            this.Close();
//        }
//        return res;
//    }

    //Hàm đóng kết nối
//    public void Close() throws SQLException {
//        //Nếu result chưa đóng, đóng result
//        if (this.result != null && !this.result.isClosed()) {
//            this.result.close();
//            this.result = null;
//        }
//        //Nếu statement chưa đóng, đóng statement
//        if (this.statement != null && !this.statement.isClosed()) {
//            this.statement.close();
//            this.statement = null;
//        }
//        //Nếu connection chưa đóng, đóng connection
//        if (this.connect != null && !this.connect.isClosed()) {
//            this.connect.close(); 
//            this.connect = null;
//        }
//    }

//    public static void main(String[] args) throws Exception {
//        ConnectDAO connect = new ConnectDAO("localhost", "root", "", "qlbandienthoaijava");        
//        if (connect.getConnect() == null) {
//            System.out.print("That bai");
//        } else {
//            System.out.print("Thanh cong");
//        }
//    }
}
