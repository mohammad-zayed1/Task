package com.ats.resources;

import com.ats.entity.Employee;
import com.ats.entity.Task;
import com.ats.repository.EmployeeRepository;
import com.ats.repository.TaskRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.function.Predicate;

@Path("/employee/api")
public class EmployeeResources {

    @Inject
    EmployeeRepository employeeRepository;



    @POST
    @Path("addEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public void saveEmployee(Employee newEmployee) {
        employeeRepository.addEmployee(newEmployee);
    }

    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAllEmp() {
        return employeeRepository.listOfEmp();
    }

    @GET
    @Path("getOne/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getOneEmployee(@PathParam("id") Long id) {
        return employeeRepository.getEmployeeById(id);
    }

    @PUT
    @Path("updateEmployee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateOneEmployee(@PathParam("id") Long id, Employee updatedEmp) {
        employeeRepository.updateEmployee(id, updatedEmp);
    }

    @DELETE
    @Path("deleteEmployee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEmp(@PathParam("id") Long id) {
        return employeeRepository.deleteEmployee(id);
    }
//    @DELETE
//    @Path("/delete/{empId}/{taskId}")
//    public void deleteTask(@PathParam("empId") Long empId , @PathParam("taskId") Long taskId){
//        employeeRepository.deleteTaskByEmpId(empId , taskId);
//    }
}
