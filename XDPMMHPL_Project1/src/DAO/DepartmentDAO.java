/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class DepartmentDAO {

    // get list
    public static ArrayList<Department> getAllDepartment() throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "SELECT * FROM department";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Department> listDepart = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double budget = rs.getDouble(3);
            Date startDate = rs.getDate(4);
            listDepart.add(new Department(id, name, budget, startDate));
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return listDepart;
    }

    // add
    public static boolean addDepartment(Department depart) throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "INSERT INTO `department` (`DepartmentID`, `Name`, `Budget`, "
                + "`StartDate`, `Administrator`) VALUES (NULL, ?, ?, ?, NULL)";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, depart.getName().toString());
        pstm.setDouble(2, depart.getBudget());
        pstm.setString(3, depart.getStartDate().toString());

        // lệnh pstm.execute() thực thi truy vấn thành công trả về giá trị false
        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    // delete
    public static boolean deleteDepartment(int id) throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "DELETE FROM department WHERE department.DepartmentID = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    //update
    public static boolean updateDepartmentByID(int id, Department depart) throws SQLException, Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "UPDATE `department` SET `Name` = ?, `Budget` = ?, `StartDate` = ? WHERE `department`.`DepartmentID` = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, depart.getName().toString());
        pstm.setDouble(2, depart.getBudget());
        pstm.setString(3, depart.getStartDate().toString());
        pstm.setInt(4, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    // Search
    public static ArrayList<Department> searchByName(String keyWordSearch) throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "SELECT * FROM department WHERE Name LIKE ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, "%" + keyWordSearch + "%");

        ResultSet rs = pstm.executeQuery();
        ArrayList<Department> listDepart = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String nameDepart = rs.getString(2);
            double budget = rs.getDouble(3);
            Date startDate = rs.getDate(4);
            listDepart.add(new Department(id, nameDepart, budget, startDate));
        }
        rs.close();
        pstm.close();
        connect.getConnect().close();

        return listDepart;
    }
}
