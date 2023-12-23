package com.ats.resources;

import com.ats.entity.Task;
import com.ats.repository.TaskRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("task/api")
public class TaskResources {


    @Inject
    TaskRepository taskRepository;

    @POST
    @Path("addTask")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addNewTask(Task task) {
        taskRepository.addTask(task);
    }
}
