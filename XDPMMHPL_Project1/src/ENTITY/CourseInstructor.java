/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author DELL
 */
public class CourseInstructor {
    private int CourseID;
    private int PersonID;
    
    public CourseInstructor(){
    
    }

    public CourseInstructor(int CourseID, int PersonID) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }
    
    
}
