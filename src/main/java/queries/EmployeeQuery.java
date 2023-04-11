package queries;

import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.JpaManager;

import java.util.List;
import java.util.logging.Logger;

public class EmployeeQuery {

    private JpaManager jpaManager = new JpaManager();
    private EntityManager manager;
    private Employee employee;
    private List listEmployee;
    private EntityTransaction transaction;
    private static final Logger log = Logger.getLogger(EmployeeQuery.class.getName());


    public EmployeeQuery(){
        manager = jpaManager.getManager();
        transaction = manager.getTransaction();
    }

    public List<Employee> getAllEmployees() {
        listEmployee =  manager.createQuery("FROM employee").getResultList();
        return listEmployee;
    }

    public Employee getEmployeeById(int id) {
        employee = manager.find(Employee.class,id);
        return employee;
    }

    public List<Employee> getEmployeeByLastName(String lastName) {
        listEmployee = manager.createQuery(
                "SELECT e FROM employee e WHERE e.lastName = :lastName").setParameter("lastName",lastName).getResultList();
        return listEmployee;
    }

    public Employee insertEmployee(Employee employee){
        transaction.begin();
        manager.persist(employee);
        try{
            transaction.commit();
            log.info("The new employee was inserted");
            return employee;
        }catch(Exception e){
            transaction.rollback();
            log.info("The database was not updated");
            return null;
        }
    }

    public Employee updateEmployee(Employee employee){

        if(employee != null){
            transaction.begin();
            manager.merge(employee);
            try{
                transaction.commit();
                log.info("The employee's information was updated");
                return employee;
            }catch(Exception e) {
                transaction.rollback();
                log.info("Database wasn't updated");
                return null;
            }
        } else {
            return null;
        }
    }

    public Employee deleteEmployee(int id){
        employee = getEmployeeById(id);
        if(employee != null){
            transaction.begin();
            manager.remove(employee);
            try{
                transaction.commit();
                log.info("Employee with id " + employee.getId() + " was removed");
                return employee;
            }catch(Exception e) {
                transaction.rollback();
                log.info("Database wasn't updated");
                return null;
            }
        }else{
            log.info("Employee with given id was not found");
            return null;
        }
    }
}
