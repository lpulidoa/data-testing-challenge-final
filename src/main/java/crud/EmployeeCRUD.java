package crud;

import entities.Employee;
import queries.EmployeeQuery;

import java.util.List;
import java.util.logging.Logger;

public class EmployeeCRUD {
    EmployeeQuery employeeQuery = new EmployeeQuery();
    List<Employee> employeeList;

    private static final Logger log = Logger.getLogger(EmployeeCRUD.class.getName());

    public List<Employee> getAllEmployees(){
        employeeList = employeeQuery.getAllEmployees();

        if(employeeList.size() != 0){
            for (Employee e: employeeList) {
                log.info(printEmployeeInfo(e));
            }
        }else{
            log.info("No employees were found");
        }

        return employeeList;
    }

    public List<Employee> getEmployeeByLastName(String lastName){
        log.info("Searching for employee with the given last name");
        employeeList = employeeQuery.getEmployeeByLastName(lastName);
        if (employeeList.isEmpty())
            log.info("No employee with the given last name was not found");
        return employeeList;
    }

    public Employee insertNewEmployee(Employee newEmployee){
        log.info("Inserting new employee with the given information");
        return employeeQuery.insertEmployee(newEmployee);
    }

    public Employee updateExistingEmployee(Employee newInfo){
        log.info("Updating the information of existing employee");
        return employeeQuery.updateEmployee(newInfo);
    }

    public Employee deleteEmployee(Employee employee){
        log.info("Deleting employee from database");
        return employeeQuery.deleteEmployee(employee.getId());
    }
    public String printEmployeeInfo(Employee employee){
        return "Employee Id: " + employee.getId() +"\n"
                + "Employee first name: " + employee.getFirstName() +"\n"
                + "Employee last name: " + employee.getLastName() +"\n"
                + "Employee email: " + employee.getEmail() +"\n"
                + "Employee phone: " + employee.getPhone() +"\n"
                + "Employee address: " + employee.getAddress() +"\n"
                + "Employee birth date: " + employee.getBirth() +"\n"
                + "Employee company id: " + employee.getCompany().getId() +"\n"
                + "Employee institution id: " + employee.getInstitution().getId() +"\n";
    }
}
