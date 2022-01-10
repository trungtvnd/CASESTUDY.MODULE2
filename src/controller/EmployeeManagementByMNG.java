package controller;

import model.*;

import java.util.Comparator;
import java.util.Scanner;

public class EmployeeManagementByMNG implements Crud {
    private static final Scanner sc = new Scanner(System.in);
    private static final EmployeeManagement employeeManagement = new EmployeeManagement();
    private final HumanManagement humanManagement = new HumanManagement();

    public EmployeeManagementByMNG() {

    }

    public String checkDepartment() {
        String dp = "";
        for (Employee employee : employeeManagement.getEmployees()) {
            if (employee.getId() == Login.ID_EMP_MNG) {
                dp = employee.getDepartment();
            }
        }
        return dp;
    }

    @Override
    public void create() {
        employeeManagement.create();
        int index = employeeManagement.getEmployees().size() - 1;
        if (!employeeManagement.getEmployees().get(index).getDepartment().equals(checkDepartment())
                || countOfficialLevel() > 1) {
            deleteByID(checkIdNext());
            employeeManagement.writeEmployeeToFile(EmployeeManagement.PATH_FILE_EMPLOYEE);
            System.out.println("You are allowed to create in your Department or Number of Manager is not over 1");
        }
    }

    @Override
    public void edit() {
        Employee employeeEdit;
        System.out.println("Input ID you want to edit");
        int id = sc.nextInt();
        boolean flag = false;
        for (Employee employee : employeeManagement.getEmployees()) {
            if (id == Login.ID_EMP_MNG) {
                flag = false;
            } else if (id == employee.getId() && employee.getDepartment().trim().equalsIgnoreCase(checkDepartment())) {
                flag = true;
                employeeEdit = employee;
                Human human = humanManagement.createHuman();
                employeeEdit.setHuman(human);
                employeeEdit.setofficeLevel(employeeManagement.chooseOffice());
                while (countOfficialLevel() > 1) {
                    System.out.println("The number of Manager is not over 1");
                    employeeEdit.setofficeLevel(employeeManagement.chooseOffice());
                }
                employeeManagement.getSalary().checkCoefficient_salary(employeeManagement.getOfficialLevel());
                employeeEdit.setSalary(employeeManagement.getSalary().getSalary());
                employeeManagement.writeEmployeeToFile(EmployeeManagement.PATH_FILE_EMPLOYEE);
            } else {
                flag = false;
            }

        }
        if (flag) {
            System.out.println("Edit successfully");
        } else {
            System.out.println("You can not edit yourself or edit employee at another department");
        }
    }

    @Override
    public void delete() {
        System.out.println("You are not allowed do this");
    }

    @Override
    public void search() {
        boolean flag = false;
        Employee employeeSearch = null;
        System.out.println("Input ID you want to search");
        int id = sc.nextInt();
        for (Employee employee : employeeManagement.getEmployees()) {
            if (id == employee.getId() && employee.getDepartment().trim().equalsIgnoreCase(checkDepartment())) {
                flag = true;
                employeeSearch = employee;

            } else {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Search successfully");
            displayTitle();
            System.out.println(employeeSearch.displayInformation());
        } else {
            System.out.println("Not found ID you entry");
        }
    }

    @Override
    public void display() {
        for (Employee employee : employeeManagement.getEmployees()) {
            if (employee.getDepartment().trim().equalsIgnoreCase(checkDepartment())) {
                System.out.println(employee.displayInformation());
            }
        }
    }

    public void displayTitle() {
        System.out.printf("%-5S%-20S%-15S%-15S%-15S%-20S%-20S%-20S%-20S%-25S%-10S\n", "ID", "Name", "Birth",
                "Gender", "Address", "Department", "Office-Level", "Salary", "Phone.No", "Email", "Status\n");
    }

    public int checkIdNext() {
        if (employeeManagement.getEmployees().size() == 0) {
            return 0;
        } else {
            int max = employeeManagement.getEmployees().get(0).getId();
            for (Employee employee : employeeManagement.getEmployees()) {
                if (max < employee.getId()) {
                    max = employee.getId();
                }
            }
            return max;
        }
    }

    public void deleteByID(int id) {
        Employee employeeDelete = null;
        for (Employee employee : employeeManagement.getEmployees()) {
            if (id == employee.getId()) {
                employeeDelete = employee;
            }
        }
        employeeManagement.getEmployees().remove(employeeDelete);
    }

    public void changeStatus() {
        System.out.println("You are not allowed do this");
    }

    public int countOfficialLevel() {
        int count = 0;
        for (Employee employee : employeeManagement.getEmployees()) {
            if (employee.getDepartment().trim().equals(checkDepartment()) && employee.getofficeLevel().trim().equalsIgnoreCase("Manager")) {
                count++;
            }
        }
        return count;
    }
    public void sortBySalary(){
        employeeManagement.getEmployees().sort(Comparator.comparingDouble(Employee::getSalary));
        display();
    }

}
