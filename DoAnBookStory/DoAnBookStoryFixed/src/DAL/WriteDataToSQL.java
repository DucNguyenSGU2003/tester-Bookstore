/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Account;
import DTO.KhachHang;
import DTO.Staff;
import DTO.Supplier;
import GUI.homeManage;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class WriteDataToSQL {

  private static final String USER = "sa";
    private static final String PASSWORD = "01254339970a";
    private static final String SERVER_NAME = "DESKTOP-BQLF5L6\\NGUYENCONGDUC";
    private static final String DATABASE_NAME = "sqlbookstore";
    private static final int PORT = 1433;

    private static SQLServerDataSource configDataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setPortNumber(PORT);
        dataSource.setServerName(SERVER_NAME);
        dataSource.setDatabaseName(DATABASE_NAME);
        dataSource.setEncrypt(false);
        dataSource.setIntegratedSecurity(false);
        dataSource.setTrustServerCertificate(false);
        return dataSource;
    }

    static public int insertDataCustomer(KhachHang KH) {
        SQLServerDataSource ds = configDataSource();

        try (var conn = ds.getConnection()) {
            String sex = "1";
            if (KH.getSex() == "true") {
                sex = "1";
            } else if (KH.getSex() == "0") {
                sex = "0";
            }

            Date d = new Date(System.currentTimeMillis());
            DateFormat df = new SimpleDateFormat();
            df = new SimpleDateFormat("yyyy-MM-dd");
            var sql = "INSERT INTO DBO.CUSTOMER "
                    + "VALUES('" + KH.getMaKH() + "','" + KH.getAccount().getAccount()
                    + "',N'" + KH.getTenKH() + "','" + KH.getNgaySinh() + "',N'" + KH.getDiaChi()
                    + "','" + KH.getPhone() + "'," + sex + ",'" + KH.getDiem() + "','" + KH.getEmail()
                    + "','" + getDay() + "'," + 1 + ")";
//            System.out.println(sql);
            var statement = conn.createStatement();
            try {
                return statement.executeUpdate(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(new homeManage(), "Sai ngày tháng");
                JOptionPane.showMessageDialog(new homeManage(), "Bạn Đã Đăng Kí Thất bại");
                return -1;
            }
        } catch (SQLServerException ex) {

            Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    static public int insertDataSupplier(Supplier sup) {
        SQLServerDataSource ds = configDataSource();

        try (var conn = ds.getConnection()) {
            Date d = new Date(System.currentTimeMillis());
            DateFormat df = new SimpleDateFormat();
            df = new SimpleDateFormat("yyyy-MM-dd");
            var sql = "INSERT INTO DBO.SUPPLIER \n"
                    + "VALUES('" + sup.getID() + "',N'" + sup.getName() + "','" + getDay()
                    + "',N'" + sup.getAddress() + "','" + sup.getPhone() + "','" + sup.getBankAccount()
                    + "','" + sup.getBankName() + "',1);";

//            System.out.println(sql);
            var statement = conn.createStatement();
              try {
                  return statement.executeUpdate(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(new homeManage(), "Sai ngày tháng");
                JOptionPane.showMessageDialog(new homeManage(), "Bạn Đã Đăng Kí Thất bại");
                return -1;
            }
        } catch (SQLServerException ex) {

            Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    static public int insertDataAccount(Account acc) {
        SQLServerDataSource ds = configDataSource();

        try (var conn = ds.getConnection()) {
            var sql = "INSERT INTO DBO.ACCOUNT "
                    + "VALUES('" + acc.getAccount() + "','" + acc.getPassword() + "','" + acc.getPosition() + "','" + getDay() + "'," + 1 + ")";
//            System.out.println(sql);
            var statement = conn.createStatement();
            return statement.executeUpdate(sql);

        } catch (SQLServerException ex) {

            Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    static public int insertDataStaff(Staff sta) {
        SQLServerDataSource ds = configDataSource();
        try (var conn = ds.getConnection()) {
            var sql = "INSERT INTO DBO.STAFF\n"
                    + "VALUES('" + sta.getID() + "','" + sta.getAccountStr() + "',N'" + sta.getName() + "'," + sta.getSex() + ",'" + sta.getBirthDay() + "',N'" + sta.getAddress() + "','" + sta.getPhone() + "','" + sta.getBankAccount() + "',N'" + sta.getBankName() + "','" + sta.getEmail() + "','" + sta.getCCCD() + "','" + sta.getSalary() + "','" + sta.getBonus() + "','" + getDay() + "',1)";
//            System.out.println(sql);
            var statement = conn.createStatement();

//            try {
                return statement.executeUpdate(sql);
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(new homeManage(), "Sai ngày tháng");
//                JOptionPane.showMessageDialog(new homeManage(), "Bạn Đã Đăng Kí Thất bại");
//                return -1;
//            }
        } catch (SQLServerException ex) {
            Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    static public int insertDataBook(DTO.Book book) {
        SQLServerDataSource ds = configDataSource();
        
        try (var conn = ds.getConnection()) {
        // Kiểm tra xem tên sách đã tồn tại trong cơ sở dữ liệu chưa
        var mergeSql = "MERGE INTO DBO.BOOK AS target " +
                       "USING (SELECT ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) AS source (ID, NAME, TYPE, AUTHOR, DATEOFCOMPOSITION,"
                + " PRICE, QUANATY, SOURCE_IMG, ID_SUPPLIER, DETAILS, DATECREATE) " +
                       "ON target.NAME = source.NAME " +
                       "WHEN MATCHED THEN " +
                       "    UPDATE SET " +
                       "        target.QUANATY = CAST(target.QUANATY AS INT) + CAST(source.QUANATY AS INT), " +
                       "        target.PRICE = source.PRICE " +
                       "WHEN NOT MATCHED THEN " +
                       "    INSERT (ID, NAME, TYPE, AUTHOR, DATEOFCOMPOSITION, PRICE, QUANATY, SOURCE_IMG, "
                + "ID_SUPPLIER, DETAILS, DATECREATE, STATE) " +
                       "    VALUES (source.ID, source.NAME, source.TYPE, source.AUTHOR, source.DATEOFCOMPOSITION, "
                + "source.PRICE, source.QUANATY, source.SOURCE_IMG, source.ID_SUPPLIER, source.DETAILS, source.DATECREATE, 1);";
        try (var statement = conn.prepareStatement(mergeSql)) {
            statement.setString(1, book.getID());
            statement.setString(2, book.getName());
            statement.setString(3, book.getType());
            statement.setString(4, book.getAuthor());
            statement.setString(5, book.getDateComposition());
            statement.setString(6, book.getPrice());
            statement.setString(7, book.getQuanaty());
            statement.setString(8, book.getSourceIMG());
            statement.setString(9, book.getID_SUPPLIER());
            statement.setString(10, book.getDetails());
            statement.setString(11, getDay());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                // Nếu không có hàng nào bị ảnh hưởng, có thể xảy ra lỗi hoặc không thực hiện cập nhật gì.
                return -1;
            }
        }
        
        return 1; // Trả về 1 để chỉ ra thành công
    } catch (SQLServerException ex) {
        Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
        return -1; // Trả về -1 để chỉ ra lỗi
    } catch (SQLException ex) {
        Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
        return -1; // Trả về -1 để chỉ ra lỗi
    }
    }

    static public int insertDataBillHomeCusomer(BUS.BillHomeCustomer billHomeCustomer) {
        SQLServerDataSource ds = configDataSource();
        try (var conn = ds.getConnection()) {

            var sql = "INSERT INTO DBO.BILLHOMECUSTOMER\n"
                    + "VALUES('" + billHomeCustomer.getID() + "','" + billHomeCustomer.getIDBook() + "','"
                    + billHomeCustomer.getIDCustomer() + "',N'" + billHomeCustomer.getAddress()
                    + "','" + billHomeCustomer.getQuanaty() + "','" + billHomeCustomer.getPrice()
                    + "','" + billHomeCustomer.getTotal() + "','" + getDay() + "',1);";
//            System.out.println(sql);
            var statement = conn.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLServerException ex) {
            Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static String getDay() {
        Date d = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat();
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(d) + "";
    }

   
    //>>>>>>>>>>>>>>>>>>>>>>.
     public static double tinhTongVon() throws SQLServerException, SQLException {
         LocalDate currentDate = LocalDate.now();
	SQLServerDataSource ds = configDataSource();
        try (var conn = ds.getConnection()) {
            var sql = "SELECT SUM(TienNhapHang) AS total_cost FROM cost WHERE YEAR(ThoiGianNhap) = ? AND MONTH(ThoiGianNhap) = ?";
            try (var statement = conn.prepareStatement(sql)) {
            	statement.setInt(1, currentDate.getYear());
            	statement.setInt(2, currentDate.getMonthValue());
            	ResultSet resultSet = statement.executeQuery();
            	if (resultSet.next()) {
                	return resultSet.getDouble("total_cost");
            	}
	    }
        }
        return 0.0;
    }

public static float tinhTongBill() throws SQLServerException, SQLException {
        LocalDate currentDate = LocalDate.now();
        SQLServerDataSource ds = configDataSource();
	try (var conn = ds.getConnection()) {
          //  var sql = "SELECT SUM(TOTAL) AS total_sum FROM bill WHERE YEAR(STR_TO_DATE(datecreate, '%Y-%m-%d')) = ? AND MONTH(STR_TO_DATE(datecreate, '%Y-%m-%d')) = ?";
           var sql = "SELECT SUM(TOTAL) AS total_sum FROM bill WHERE YEAR(CONVERT(DATETIME, datecreate, 120)) = ? AND MONTH(CONVERT(DATETIME, datecreate, 120)) = ?";
          try (var statement = conn.prepareStatement(sql)) {
            	statement.setInt(1, currentDate.getYear());
            	statement.setInt(2, currentDate.getMonthValue());
            	   ResultSet resultSet = statement.executeQuery();
            	if (resultSet.next()) {
                	return resultSet.getFloat("total_sum");
            	}
	    }
        }
        return 0.0f;
    }

public static double tinhDoanhThu() {
        SQLServerDataSource ds = configDataSource();
	   LocalDate currentDate = LocalDate.now();
        try {
            double totalCost = tinhTongVon();
            float totalSum = tinhTongBill();
            return totalCost - totalSum;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

 public static void main(String[] args) {
      try {
          float sum = DAL.WriteDataToSQL.tinhTongBill();
          System.out.println(sum);
      } catch (SQLException ex) {
          Logger.getLogger(WriteDataToSQL.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

}
