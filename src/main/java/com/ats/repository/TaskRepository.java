package com.ats.repository;

import com.ats.entity.Employee;
import com.ats.entity.Task;
import com.ats.enums.TaskStatus;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class TaskRepository implements PanacheRepository<Task>  {

    @Inject
    EmployeeRepository employeeRepository;

    public List<Task> listOfTasks() { // get all
        return findAll().list();
    }
    @Transactional
    public void addTask(Long empId , Task newTask){
        Employee employee = employeeRepository.findById(empId);
        if(employee != null){
            newTask.setEmployeeId(empId);
            newTask.setStatus(TaskStatus.IN_PROGRESS);
            employee.tasks.add(newTask);
            persist(newTask);
        }
    }

    @Transactional
    public void deleteTask( Long empId , Long taskId){
        Employee employee = employeeRepository.findById(empId);
        Task task = findById(taskId);
        if(employee != null && task != null){
            employee.tasks.remove(task);
            deleteById(taskId);
        }
    }

    public List<Task> getTask(String username  , TaskStatus status ){
        Employee employee = employeeRepository.find("username" , username).firstResult();
        return employee.tasks.stream().filter(task -> task.getStatus() == status).collect(Collectors.toList());
    }

}
