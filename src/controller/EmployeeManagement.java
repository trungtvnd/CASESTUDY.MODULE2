package controller;

import model.*;
import IO.IOFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeManagement implements Crud {
    public static final String PATH_FILE_EMPLOYEE = "C:\\TRUNGTV\\HOC TAP\\CODEGYM\\MODULE2\\CASE STUDY\\CASE-VER2\\src\\IO\\saveFileEmployee.txt";
    private static final Scanner sc = new Scanner(System.in);
    private static final IOFile<Employee> ioFile_EMP = new IOFile<>();
    private final HumanManagement humanManagement;
    private final Department department;
    private final OfficeLevel officialLevel;
    private  final Salary salary;
    private final ArrayList<Employee> employees;

    public EmployeeManagement() {
        this.humanManagement = new HumanManagement();
        this.department = new Department();
        this.officialLevel = new OfficeLevel();
        this.salary = new Salary();
        this.employees = readEmployeeFromFile(PATH_FILE_EMPLOYEE);

    }

    public OfficeLevel getOfficialLevel() {
        return officialLevel;
    }

    public Salary getSalary() {
        return salary;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void writeEmployeeToFile(String path) {
        ioFile_EMP.writeObjectToFile(employees, path);
    }

    public ArrayList<Employee> readEmployeeFromFile(String path) {
        return ioFile_EMP.readObjectFromFile(path);
    }

    public void changeStatus() {
        Employee employeeChangeStatus;
        System.out.println("Input ID you want to change Status: ");
        int id = sc.nextInt();
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                employeeChangeStatus = employee;
                employeeChangeStatus.setStatus(false);
                System.out.println(employeeChangeStatus);
            }
        }
    }


    public String chooseDepartment() {
        sc.nextLine();
        System.out.println(
                "1. SALE\n" +
                "2. ACCOUNTANT\n" +
                "3. FINANCE\n" +
                "4. SYSTEM\n" +
                "5. SOFTWARE\n" +
                "6. MARKETING\n" +
                "7. RISK MANAGEMENT\n" +
                "");
        System.out.println("Choose Department: ");
        try {
            int choice = Integer.parseInt(sc.nextLine());
            while (choice < 0 || choice > 5) {
                System.out.println("you can choose from 0 to 5, please choose again");
                choice = sc.nextInt();
            }
            department.setDepartment(choice);
        } catch (Exception e) {
            System.err.println("please input number");
            chooseDepartment();
        }
        return department.getDepartment();
    }

    public String chooseOffice() {
        System.out.println("1. Director\n" +
                "2. Manager\n" +
                "3. Professional\n" +
                "4. Senior\n" +
                "5. Junior\n" +
                "6. Fresher\n" +
                "7. Intern\n" +
                "");
        System.out.println("Input office of Staff");
        try {
            int choice = Integer.parseInt(sc.nextLine());
            while (choice < 1 || choice > 7) {
                System.out.println("you can choose from 1 to 7, please choose again");
                choice = sc.nextInt();
                sc.nextLine();
            }
            officialLevel.setOffice(choice);
        } catch (Exception e) {
            System.err.println("please input number");
            chooseOffice();
        }

        return officialLevel.getOffice();
    }

    public boolean chooseStatus() {
        System.out.println("Input your choice");

        System.out.println("" +
                "1. Working\n" +
                "2. Off work\n");

        int choice = sc.nextInt();
        return choice == 1;
    }

    @Override
    public void create() {
        Employee.IDC = checkIdNext();
        Human human = humanManagement.createHuman();
        String department1 = chooseDepartment();
        String officialLevel1 = chooseOffice();
        salary.checkCoefficient_specific(department);
        salary.checkCoefficient_salary(officialLevel);
        double getSalary = salary.getSalary();
        boolean status = true;
        Employee employee = new Employee(human, department1, officialLevel1, getSalary, status);
        employees.add(employee);
        writeEmployeeToFile(PATH_FILE_EMPLOYEE);
        if (checkOfficialLevel(department1)) {
            System.out.println();
        } else {
            System.out.println("The number of Manager is not over 1");
            deleteEmployeeByDoubleOfficial(checkIdNext());
        }

    }

    @Override
    public void edit() {
        Employee employeeEdit;
        System.out.println("Input id you want to Edit: ");
        int id = sc.nextInt();
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                employeeEdit = employee;
                Human human = humanManagement.createHuman();
                employeeEdit.setHuman(human);
                String dp = chooseDepartment();
                employeeEdit.setDepartment(dp);
                String officialLevelEmp;
                while (!checkOfficialLevel(dp)){
                    officialLevelEmp = chooseOffice();
                    System.out.println("The number of Manager is not over 1");
                    employeeEdit.setofficeLevel(officialLevelEmp);
                }
                employeeEdit.setofficeLevel(chooseOffice());
                salary.checkCoefficient_salary(officialLevel);
                salary.checkCoefficient_specific(department);
                employeeEdit.setSalary(salary.getSalary());
                employeeEdit.setStatus(chooseStatus());
                writeEmployeeToFile(PATH_FILE_EMPLOYEE);
            }
        }
    }

    @Override
    public void delete() {
        Employee employeeDelete;
        System.out.println("Input id you want to Delete: ");
        int id = sc.nextInt();
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                employeeDelete = employee;
                employees.remove(employeeDelete);
            }
        }

        writeEmployeeToFile(PATH_FILE_EMPLOYEE);
    }

    @Override
    public void search() {
        Employee employeeSearch = null;
        System.out.println("Input ID you want to find: ");
        int id = sc.nextInt();
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                employeeSearch = employee;
            }
        }
        displayTitle();
        assert employeeSearch != null;
        System.out.println(employeeSearch.displayInformation());
    }

    @Override
    public void display() {
        displayTitle();
        for (Employee employee : employees) {
            System.out.println(employee.displayInformation());
        }
    }

    public void displayTitle() {
        System.out.printf("%-5S%-20S%-15S%-15S%-15S%-20S%-20S%-20S%-20S%-25S%-10S\n", "ID", "Name", "Birth",
                "Gender", "Address", "Department", "Office-Level", "Salary", "Phone.No", "Email", "Status\n");
    }

    public int checkIdNext() {
        if (employees.size() == 0) {
            return 0;
        } else {
            int max = employees.get(0).getId();
            for (Employee employee : employees) {
                if (max < employee.getId()) {
                    max = employee.getId();
                }
            }
            return max;
        }
    }

    public boolean checkOfficialLevel(String dp) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment().trim().equals(dp) && employee.getofficeLevel().trim().equals("Manager")) {
                count++;
            }
        }
        return count <= 1;
    }

    public void deleteEmployeeByDoubleOfficial(int id) {
        employees.removeIf(employee -> id == employee.getId());
        writeEmployeeToFile(PATH_FILE_EMPLOYEE);
    }
    public void sortBySalary(){
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        display();
    }
    public void displayByGender(){
        System.out.println("Do you want to display by Male or Female");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("Entry your choice: ");
        int choice = Integer.parseInt(sc.nextLine());
        if(choice == 1){
            for (Employee employee:employees) {
                if(employee.getHuman().getGender().trim().equalsIgnoreCase("Male")){
                    System.out.println(employee.displayInformation());
                }
            }
        }else if(choice ==2){
            for (Employee employee:employees) {
                if(employee.getHuman().getGender().trim().equalsIgnoreCase("Female")){
                    System.out.println(employee.displayInformation());
                }
            }
        }
    }
}


