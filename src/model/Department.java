package model;

public class Department {
    private String department;

    public Department() {
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(int chooseDepartment) {
        if (chooseDepartment == 1) {
            this.department = "SALE";
        }
        else if (chooseDepartment == 2) {
            this.department = "ACCOUNTANT";
        }
        else if (chooseDepartment == 3) {
            this.department = "FINANCE";
        }
        else if (chooseDepartment == 4) {
            this.department = "SYSTEM";
        }
        else if (chooseDepartment == 5) {
            this.department = "SOFTWARE";
        }
        else if (chooseDepartment == 6) {
            this.department = "MARKETING";
        }
        else if (chooseDepartment == 7) {
            this.department = "RISK MANAGEMENT";
        }
    }
}
