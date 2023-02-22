/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.Lecture;
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
public class LectureDAO {

    // Get list lecture
    public static ArrayList<Lecture> getAllLecture() throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "SELECT * FROM person WHERE person.officeID = 1";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Lecture> listLecture = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String firstName = rs.getString(3);
            String lastName = rs.getString(2);
            Date hireDate = rs.getDate(4);
            listLecture.add(new Lecture(id, firstName, lastName, hireDate));
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return listLecture;
    }

    // Add lecture
    public static boolean addLecture(Lecture lecture) throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "INSERT INTO `person` (`PersonID`, `Firstname`, `Lastname`, "
                + "`HireDate`, `EnrollmentDate`, `officeID`) VALUES (NULL, ?, ?, ?, NULL, 1)";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, lecture.getFirstName().toString());
        pstm.setString(2, lecture.getLastName().toString());
        pstm.setString(3, lecture.getDateTime().toString());

        // lệnh pstm.execute() thực thi truy vấn thành công trả về giá trị false
        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    // delete lecture
    public static boolean deleteLectureById(int id) throws Exception {
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
    public static boolean updateLectureByID(int id, Lecture lec) throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "UPDATE `person` SET `Firstname` = ?, `Lastname` = ?, `HireDate` = ? WHERE `person`.`personID` = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, lec.getFirstName().toString());
        pstm.setString(2, lec.getLastName().toString());
        pstm.setString(3, lec.getDateTime().toString());
        pstm.setInt(4, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    // search lecture
    public static ArrayList<Lecture> searchByName(String keyWordSearch) throws Exception {
        ConnectDAO connect = new ConnectDAO();
        String query = "SELECT * FROM person WHERE (Lastname LIKE ? OR Firstname LIKE ?) AND person.officeID = 1";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, "%" + keyWordSearch + "%");
        pstm.setString(2, "%" + keyWordSearch + "%");

        ResultSet rs = pstm.executeQuery();
        ArrayList<Lecture> listLecture = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String firstName = rs.getString(3);
            String lastName = rs.getString(2);
            Date hireDate = rs.getDate(4);
            listLecture.add(new Lecture(id, lastName, firstName, hireDate));
        }
        rs.close();
        pstm.close();
        connect.getConnect().close();

        return listLecture;
    }

}
