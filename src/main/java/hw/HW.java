package hw;

import java.util.ArrayList;

public class HW {
    public static void main(String[] args) {
        EmployeeRepo employeeRepo = new EmployeeRepo();
        employeeRepo.addEmployee(new Employee("ivan", 10, 12,123));
        employeeRepo.addEmployee(new Employee("stas", 32, 56,90));
        employeeRepo.addEmployee(new Employee("anton", 78, 1,0));
        System.out.println("findByNumber");
        System.out.println(( employeeRepo.findByNumber(12)));
        System.out.println(( employeeRepo.findByNumber(32)));
        System.out.println();

        System.out.println("findByName");
        employeeRepo.findByName("zxc").stream().forEach(System.out::println);
        employeeRepo.findByName("ivan").stream().forEach(System.out::println);

        System.out.println();

        System.out.println("findPhoneNumberByName");
        employeeRepo.findPhoneNumberByName("ivan").stream().forEach(System.out::println);
        employeeRepo.findByName("zxc").stream().forEach(System.out::println);
        System.out.println();

        System.out.println("findByExperience");
        employeeRepo.findByExperience(3).stream().forEach(System.out::println);
        employeeRepo.findByExperience(0).stream().forEach(System.out::println);



    }
}
