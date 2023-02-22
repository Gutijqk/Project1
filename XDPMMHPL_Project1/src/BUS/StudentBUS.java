/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.StudentDAO;
import ENTITY.Student;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class StudentBUS {

    public static ArrayList<Student> getAllStudent() throws Exception {
        return StudentDAO.getAllStudent();
    }

    public static boolean addStudent(Student student) throws Exception {
        return StudentDAO.addStudent(student);
    }

    public static boolean deleteStudentById(int id) throws Exception {
        return StudentDAO.deleteStudentById(id);
    }

    public static boolean updateStudentByID(int id, Student student) throws Exception {
        return StudentDAO.updateStudentByID(id, student);
    }

    public static ArrayList<Student> searchByName(String keyWordSearch) throws Exception {
        return StudentDAO.searchByName(keyWordSearch);
    }
}
