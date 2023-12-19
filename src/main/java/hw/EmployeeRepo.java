package hw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRepo {
    private List<Employee> employeeList = new ArrayList<>();
    public List<Employee> findByName(String name){
        return employeeList.stream()
                .filter(x->x.getName().equals(name))
                .collect(Collectors.toList());
    }
    public List<Employee> findByExperience (int experience ){
        return employeeList.stream().filter(x->x.getExperience()==experience).collect(Collectors.toList());
    }
    public List<Integer> findPhoneNumberByName(String name){
        return findByName(name).stream()
                .map(x->x.getPhoneNumber())
                .collect(Collectors.toList());

    }
    public Employee findByNumber(int number){
        for (Employee employee : employeeList) {
            if (employee.getNumber()==number){
                return employee;
            }
        }
        return null;
    }
    public void addEmployee(Employee employee){
        if(findByNumber(employee.getNumber())!=null){
            throw new RuntimeException("струдник с таким номером уже существует");
        }
        employeeList.add(employee);
    }


}
