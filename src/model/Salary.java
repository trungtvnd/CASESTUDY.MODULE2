package model;

public class Salary {
    public static final double SALARY_BASE = 3500000;
    private double coefficient_salary;
    private double coefficient_specific;

    public Salary() {
    }

    public Salary(double coefficient_salary, Department department, OfficeLevel OfficeLevel) {
        this.coefficient_salary = coefficient_salary;

    }

    public double getCoefficient_salary() {
        return coefficient_salary;
    }

    public void setCoefficient_salary(double coefficient_salary) {
        this.coefficient_salary = coefficient_salary;
    }

    public double getCoefficient_specific() {
        return coefficient_specific;
    }

    public void setCoefficient_specific(double coefficient_specific) {
        this.coefficient_specific = coefficient_specific;
    }

    public void checkCoefficient_salary(OfficeLevel OfficeLevel) {
        switch (OfficeLevel.getOffice().trim()) {
            case "Director":
                setCoefficient_salary(15);
                break;
            case "Manager":
                setCoefficient_salary(10);
                break;
            case "Professional":
                setCoefficient_salary(7);
                break;
            case "Senior":
                setCoefficient_salary(5);
                break;
            case "Junior":
                setCoefficient_salary(3);
                break;
            case "Fresher":
                setCoefficient_salary(2);
                break;
            case "Intern":
                setCoefficient_salary(1.5);
                break;
        }
    }

    public void checkCoefficient_specific(Department department) {
        switch (department.getDepartment().trim()) {
            case "BOD":
                setCoefficient_specific(5);
                break;
            case "SALE":
                setCoefficient_specific(0);
                break;
            case "ACCOUNTANT":
                setCoefficient_specific(1);
                break;
            case "FINANCE":
            case "MARKETING":
                setCoefficient_specific(1.5);
                break;
            case "SYSTEM":
                setCoefficient_specific(2);
                break;
            case "SOFTWARE":
                setCoefficient_specific(2.5);
                break;

            case "RISK MANAGEMENT":
                setCoefficient_specific(3);
                break;
        }
    }


    public double getSalary() {
        return (getCoefficient_salary() + getCoefficient_specific()) * SALARY_BASE;
    }
}
