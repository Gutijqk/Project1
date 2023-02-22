/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class StudentDAO {

    // Get list lecture
    public static ArrayList<Student> getAllStudent() throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "SELECT * FROM person WHERE person.officeID = 2";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Student> listStudent = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String firstName = rs.getString(3);
            String lastName = rs.getString(2);
            Date enrollmentDate = rs.getDate(5);
            listStudent.add(new Student(id, firstName, lastName, enrollmentDate));
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return listStudent;
    }

    // Add lecture
    public static boolean addStudent(Student student) throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "INSERT INTO `person` (`PersonID`, `Firstname`, `Lastname`, "
                + "`HireDate`, `EnrollmentDate`, `officeID`) VALUES (NULL, ?, ?, NULL, ?, 2)";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, student.getFirstName().toString());
        pstm.setString(2, student.getLastName().toString());
        pstm.setString(3, student.getEnrollmentDate().toString());

        // lệnh pstm.execute() thực thi truy vấn thành công trả về giá trị false
        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    // delete lecture
    public static boolean deleteStudentById(int id) throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "DELETE FROM person WHERE person.personID = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    // update lecture
    public static boolean updateStudentByID(int id, Student student) throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "UPDATE `person` SET `Firstname` = ?, `Lastname` = ?, `EnrollmentDate` = ? WHERE `person`.`personID` = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, student.getFirstName().toString());
        pstm.setString(2, student.getLastName().toString());
        pstm.setString(3, student.getEnrollmentDate().toString());
        pstm.setInt(4, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    // search lecture
    public static ArrayList<Student> searchByName(String keyWordSearch) throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "SELECT * FROM person WHERE (Lastname LIKE ? OR Firstname LIKE ?) AND person.officeID = 2";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, "%" + keyWordSearch + "%");
        pstm.setString(2, "%" + keyWordSearch + "%");

        ResultSet rs = pstm.executeQuery();
        ArrayList<Student> listStudent = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String firstName = rs.getString(3);
            String lastName = rs.getString(2);
            Date enrollmentDate = rs.getDate(5);
            listStudent.add(new Student(id, lastName, firstName, enrollmentDate));
        }
        rs.close();
        pstm.close();
        connect.getConnect().close();

        return listStudent;
    }

}
