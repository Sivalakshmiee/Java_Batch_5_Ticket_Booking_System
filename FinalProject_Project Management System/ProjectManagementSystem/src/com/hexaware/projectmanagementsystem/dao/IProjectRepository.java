package com.hexaware.projectmanagementsystem.dao;

import java.util.List;

import com.hexaware.projectmanagementsystem.entity.Employee;
import com.hexaware.projectmanagementsystem.entity.Project;
import com.hexaware.projectmanagementsystem.entity.Task;
import com.hexaware.projectmanagementsystem.myexceptions.EmployeeNotFoundException;
import com.hexaware.projectmanagementsystem.myexceptions.ProjectNotFoundException;

public interface IProjectRepository {
	
	boolean createEmployee(Employee emp);
    boolean createProject(Project pj);
    boolean createTask(Task task);
    boolean assignProjectToEmployee(int employeeId, int projectId) throws EmployeeNotFoundException, ProjectNotFoundException;
    boolean assignTaskInProjectToEmployee(int taskId, int employeeId);
    boolean deleteEmployee(int employeeId);
    boolean deleteTask(int taskId);
    List<Task> getAllTasks(int empId, int projectId);

}
