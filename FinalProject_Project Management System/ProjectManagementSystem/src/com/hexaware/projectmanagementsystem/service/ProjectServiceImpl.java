package com.hexaware.projectmanagementsystem.service;

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
		return projectRepository.createEmployee(emp);
		
	}

	@Override
	public boolean createProject(Project project) {
		return projectRepository.createProject(project);
	}

	@Override
	public boolean createTask(Task task) {
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

}
