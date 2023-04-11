
import crud.EmployeeCRUD;
import entities.Employee;
import org.testng.annotations.Test;
import utils.JSONHelper;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Runner{

    private EmployeeCRUD employeeCRUD = new EmployeeCRUD();

    @Test
    public void getAllEmployees() {
        List<Integer> existingEmployees = JSONHelper.fromJsonToList("existing_employee_id.json");

        List<Employee> results = employeeCRUD.getAllEmployees();

        List<Integer> resultsIds = new ArrayList<>();
        for (Employee result : results) {
            resultsIds.add(result.getId());
        }

        assertThat("The information of all employees was not retrieved", resultsIds.size(), equalTo(existingEmployees.size()));
        assertThat("The information retrieved is not correct", resultsIds, equalTo(existingEmployees));
    }

    @Test
    public void getEmployeeByLastName() {
        String lastName = "Vegito";
        List<Employee> results = employeeCRUD.getEmployeeByLastName(lastName);
        for (Employee result : results) {
            assertThat("The last name of the employee is not correct", result.getLastName(), equalTo(lastName));
        }
    }

    @Test
    public void insertNewEmployee() {
        Employee newEmployee = JSONHelper.fromJsonToObject("new_employee.json",Employee.class);
        assert newEmployee != null;

        employeeCRUD.insertNewEmployee(newEmployee);

        List<Employee> savedEmployees = employeeCRUD.getEmployeeByLastName(newEmployee.getLastName());
        for (Employee savedEmployee : savedEmployees) {
            assertThat("The information saved in the database is not correct", newEmployee, equalTo(savedEmployee));
        }
    }

    @Test
    public void updateExistingEmployee() {
        Employee employeeToUpdate = JSONHelper.fromJsonToObject("update_existing_employee.json",Employee.class);
        assert employeeToUpdate != null;

        Employee savedEmployee = employeeCRUD.updateExistingEmployee(employeeToUpdate);

        assertThat("The information saved is not correct",
                savedEmployee, equalTo(employeeToUpdate)); //invoca Object.equals(java.lang.Object)
    }

    @Test
    public void deleteEmployee() {
        Employee deletedEmployee = JSONHelper.fromJsonToObject("new_employee.json",Employee.class);
        assert deletedEmployee != null;

        employeeCRUD.deleteEmployee(deletedEmployee);

        List<Employee> employeeList = employeeCRUD.getAllEmployees();
        List<Integer> employeeListInfo = new ArrayList<>();

        for (Employee employee : employeeList) {
            employeeListInfo.add(employee.getId());
        }

        assertThat("The deleted employee information is still in the database",
                employeeListInfo, not(hasItem( deletedEmployee.getId() )) );
    }

}
