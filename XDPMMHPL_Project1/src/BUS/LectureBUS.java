/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LectureDAO;
import ENTITY.Lecture;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class LectureBUS {

    public static ArrayList<Lecture> getAllLecture() throws Exception {
        return LectureDAO.getAllLecture();
    }

    public static boolean addLecture(Lecture lecture) throws Exception {
        return LectureDAO.addLecture(lecture);
    }

    public static boolean deleteLectureById(int id) throws Exception {
        return LectureDAO.deleteLectureById(id);
    }

    public static boolean updateLectureByID(int id, Lecture lec) throws Exception {
        return LectureDAO.updateLectureByID(id, lec);
    }

    public static ArrayList<Lecture> searchByName(String keyWordSearch) throws Exception {
        return LectureDAO.searchByName(keyWordSearch);
    }
}
