/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DepartmentDAO;
import ENTITY.Department;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DepartmentBUS {

    public static ArrayList<Department> getAllDepartment() throws Exception {
        return DepartmentDAO.getAllDepartment();
    }

    public static boolean addDepartment(Department depart) throws Exception {
        return DepartmentDAO.addDepartment(depart);
    }

    public static boolean deleteDepartmentByID(int id) throws Exception {
        return DepartmentDAO.deleteDepartment(id);
    }

    public static boolean updateDepartmentByID(int id, Department depart) throws Exception {
        return DepartmentDAO.updateDepartmentByID(id, depart);
    }

    public static ArrayList<Department> searchByName(String keyWordSearch) {
        return DepartmentDAO.searchByName(keyWordSearch);
    }

}
