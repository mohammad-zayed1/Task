package com.ats.repository;

import com.ats.entity.Employee;
import com.ats.entity.Task;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {


    @Transactional
    public void addEmployee(Employee newEmployee) { // add
        persist(newEmployee);
    }

    public List<Employee> listOfEmp() { // get all
        return findAll().list();
    }

    public Employee getEmployeeById(Long id) { // get one
        return findById(id);
    }

    @Transactional
    public void updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = findById(id);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setUsername(updatedEmployee.getUsername());
            existingEmployee.setSalary(updatedEmployee.getSalary());
        } else {
            throw new NotFoundException("the employee with id : " + id + " not exist");
        }
    } // update one

    @Transactional
    public Response deleteEmployee(Long id) {
        Employee isExistEmployee = findById(id);
        if (isExistEmployee != null) {
            deleteById(id);
            return Response.ok("the employee deleted success").build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("employee with id : " + id + " not exist").build();
    }
//    @Transactional
//    public void deleteTaskByEmpId(Long taskId , Long empId){
//         delete("id=:empId and tasks.id=:taskId",
//                Parameters.with("empId",empId).and("taskId",taskId));
//
//    }

//    @Transactional
//    public void addTask(Long employeeId, Task task) {
//        Employee employee = findById(employeeId);
//        if (employee != null) {
//         employee.tasks.add(task);
//        }
//    }
}
