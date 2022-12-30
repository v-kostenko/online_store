package com.solvd.onlineStore.staff;

import com.solvd.onlineStore.util.Prototype;

public class StaffId implements Prototype {
    private String department;
    private int departmentId;

    public StaffId(){
    }

    public StaffId(String department, int departmentId){
        this.department = department;
        this.departmentId = departmentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public StaffId copy(){
        StaffId staffId = new StaffId(this.department, this.departmentId);
        return staffId;
    }
}
