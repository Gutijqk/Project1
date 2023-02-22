/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Department {
    private int DepartmentID;
    private String Name;
    private double Budget;
    private Date StartDate;
    
    public Department(){
    
    }

    public Department(int DepartmentID, String Name, double Budget, Date StartDate) {
        this.DepartmentID = DepartmentID;
        this.Name = Name;
        this.Budget = Budget;
        this.StartDate = StartDate;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getBudget() {
        return Budget;
    }

    public void setBudget(double Budget) {
        this.Budget = Budget;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }   
    
}
