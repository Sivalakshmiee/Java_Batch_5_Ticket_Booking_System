package com.hexaware.projectmanagementsystem.service;

/**
 * Author: Sivalakshmi
 * Date: 21-Oct-2024
 * Description: This class implements the IProjectService interface and 
 *              provides business logic for managing Employee, Project, 
 *              and Task entities. It validates input data and interacts 
 *              with the ProjectRepository to perform various operations, 
 *              ensuring data integrity and proper handling of exceptions.
 */


import java.util.List;

import com.hexaware.projectmanagementsystem.dao.IProjectRepository;
import com.hexaware.projectmanagementsystem.dao.ProjectRepositoryImpl;
import com.hexaware.projectmanagementsystem.entity.Employee;
import com.hexaware.projectmanagementsystem.entity.Project;
import com.hexaware.projectmanagementsystem.entity.Task;
import com.hexaware.projectmanagementsystem.myexceptions.EmployeeNotFoundException;
import com.hexaware.projectmanagementsystem.myexceptions.ProjectNotFoundException;

public class ProjectServiceImpl implements IProjectService{
	
	private IProjectRepository projectRepository;
	
	 // Constructor to initialize the DAO layer
    public ProjectServiceImpl() {
        this.projectRepository = new ProjectRepositoryImpl();
    }

	@Override
	public boolean createEmployee(Employee emp) {
		validateEmployee(emp);
		return projectRepository.createEmployee(emp);
		
	}

	@Override
	public boolean createProject(Project project) {
		validateProject(project); 
		return projectRepository.createProject(project);
	}

	@Override
	public boolean createTask(Task task) {
		validateTask(task);
		return projectRepository.createTask(task);
	}

	@Override
	public boolean assignProjectToEmployee(int employeeId, int projectId) throws EmployeeNotFoundException, ProjectNotFoundException{
	    return projectRepository.assignProjectToEmployee(employeeId, projectId);
		
	}

	@Override
	public boolean assignTaskInProjectToEmployee(int taskId, int employeeId) {
		return projectRepository.assignTaskInProjectToEmployee(taskId, employeeId);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		return projectRepository.deleteEmployee(employeeId);
	}

	@Override
	public boolean deleteTask(int taskId) {
		return projectRepository.deleteTask(taskId);
	}

	@Override
	public List<Task> getAllTasks(int empId, int projectId) {
		 return projectRepository.getAllTasks(empId, projectId);
	}
	
	private void validateEmployee(Employee emp) {
        if (emp.getName() == null || emp.getName().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty.");
        }
        if (emp.getDesignation() == null || emp.getDesignation().isEmpty()) {
            throw new IllegalArgumentException("Employee designation cannot be empty.");
        }
        if (!emp.getGender().equalsIgnoreCase("Male") && !emp.getGender().equalsIgnoreCase("Female")) {
            throw new IllegalArgumentException("Invalid gender. Must be 'Male' or 'Female'.");
        }
        if (emp.getSalary() <= 0) {
            throw new IllegalArgumentException("Salary must be a positive number.");
        }
    }
	
	private void validateProject(Project project) {
        if (project.getProjectName() == null || project.getProjectName().isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be empty.");
        }
        if (project.getDescription() == null || project.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Project description cannot be empty.");
        }
        if (project.getStartDate() == null || project.getStartDate().isEmpty()) {
            throw new IllegalArgumentException("Start date cannot be empty.");
        }
        if (project.getStatus() == null || project.getStatus().isEmpty()) {
            throw new IllegalArgumentException("Project status cannot be empty.");
        }
    }
	
	private void validateTask(Task task) {
		if (task.getTaskName() == null || task.getTaskName().isEmpty()) {
	        throw new IllegalArgumentException("Task name cannot be empty.");
	    }
	    if (task.getProjectId() <= 0) {
	        throw new IllegalArgumentException("Invalid project ID. It must be greater than 0.");
	    }
	    if (task.getEmployeeId() <= 0) {
	        throw new IllegalArgumentException("Invalid employee ID. It must be greater than 0.");
	    }
	    if (task.getStatus() == null || task.getStatus().isEmpty()) {
	        throw new IllegalArgumentException("Task status cannot be empty.");
	    }
	}

}
