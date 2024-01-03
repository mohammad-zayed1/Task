package com.ats.resources;

import com.ats.entity.Employee;
import com.ats.entity.Task;
import com.ats.enums.TaskStatus;
import com.ats.repository.EmployeeRepository;
import com.ats.repository.TaskRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Path("task/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResources {


    @Inject
    TaskRepository taskRepository;

    @GET
    @Path("/")

    public List<Task> getAllTask(){
        return taskRepository.listOfTasks();
    }

    @POST
    @Path("/{empId}/addTask")
    public void addNewTask( @PathParam("empId") Long empId,Task task) {
        taskRepository.addTask(empId , task);
    }

    @DELETE
    @Path("/delete/{empId}/{taskId}")
    public void deleteTask(@PathParam("empId") Long empId , @PathParam("taskId") Long taskId){

        taskRepository.deleteTask(empId , taskId);
    }

    @GET
    @Path("/getTaskByUsername/{username}/{status}")
    public List<Task> getTaskByUsername(@PathParam("username") String username , @PathParam("status") TaskStatus status){
        return taskRepository.getTask(username ,status );
    }

}
