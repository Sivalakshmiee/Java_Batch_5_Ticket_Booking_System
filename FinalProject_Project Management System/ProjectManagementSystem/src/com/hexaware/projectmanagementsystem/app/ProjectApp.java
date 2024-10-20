package com.hexaware.projectmanagementsystem.app;

import com.hexaware.projectmanagementsystem.service.*;

import java.util.List;
import java.util.Scanner;

//import com.hexaware.projectmanagementsystem.dao.*;
import com.hexaware.projectmanagementsystem.entity.Employee;
import com.hexaware.projectmanagementsystem.entity.Project;
import com.hexaware.projectmanagementsystem.entity.Task;
import com.hexaware.projectmanagementsystem.myexceptions.EmployeeNotFoundException;
import com.hexaware.projectmanagementsystem.myexceptions.ProjectNotFoundException;

public class ProjectApp {

	public static void main(String[] args) {
		
//		 IProjectRepository projectRepo = new ProjectRepositoryImpl();
		 IProjectService service = new ProjectServiceImpl(); 

	     Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("1. Add Employee");
	            System.out.println("2. Add Project");
	            System.out.println("3. Add Task");
	            System.out.println("4. Assign Project to Employee");
	            System.out.println("5. Assign Task in Project to Employee");
	            System.out.println("6. Delete Employee");
	            System.out.println("7. Delete Task");
	            System.out.println("8. List all Tasks in a Project assigned to Employee");
	            System.out.println("9. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                	addEmployee(service, scanner);
	                    break;
	                case 2:
	                	createProject(service, scanner);
	                    break;
	                case 3:
	                	createTask(service, scanner);
	                    break;
	                case 4:
	                	assignProjectToEmployee(service, scanner);
	                    break;
	                case 5:
	                	assignTaskInProjectToEmployee(service, scanner);
	                    break;
	                case 6:
	                	deleteEmployee(service, scanner);
	                    break;
	                case 7:
	                    deleteTask(service, scanner);
	                    break;
	                case 8:
	                	listTasksAssignedToEmployee(service, scanner);
	                    break;
	                case 9:
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
	        
		
	}

	private static void addEmployee(IProjectService service, Scanner scanner) {
		
		Employee emp = new Employee();
//		System.out.print("Enter Employee ID: ");
//		int employeeId = scanner.nextInt();  
        System.out.print("Enter Employee Name: ");
        String name = scanner.next();
        emp.setName(name); // Set name
        
        System.out.print("Enter Designation: ");
        String designation = scanner.next();
        emp.setDesignation(designation); // Set name
        
        System.out.print("Enter Gender: ");
        String gender = scanner.next();
        emp.setGender(gender); // Set gender
        
        System.out.print("Enter Salary: ");
        int salary = scanner.nextInt();
        emp.setSalary(salary); // Set salary
        
        System.out.print("Enter Project ID: ");
        int projectId = scanner.nextInt();
        emp.setProjectId(projectId);
        

        
        if (service.createEmployee(emp)) {
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Failed to add employee.");
        }
    
		
	}
	
	private static void createProject(IProjectService service, Scanner scanner) {
		Project project = new Project();
		
		System.out.println("Enter project id: ");
		int id = scanner.nextInt();
		project.setId(id);
		
		scanner.nextLine();
		
	    System.out.print("Enter Project Name: ");
	    String projectName = scanner.nextLine();
	    project.setProjectName(projectName);

	    System.out.print("Enter Project Description: ");
	    String description = scanner.nextLine();
	    project.setDescription(description);
	    
//	    scanner.nextLine();

	    System.out.print("Enter Project Start Date (YYYY-MM-DD): ");
	    String startDate = scanner.nextLine();
	    project.setStartDate(startDate);
	    
//	    scanner.nextLine();

	    System.out.print("Enter Project Status: ");
	    String status = scanner.nextLine();
	    project.setStatus(status);


	    // Call the service to create the project
	    if (service.createProject(project)) {
	        System.out.println("Project added successfully.");
	    } else {
	        System.out.println("Failed to add project.");
	    }
		
	}
	
	private static void createTask(IProjectService service, Scanner scanner) {
		Task task = new Task();
		
		System.out.println("Enter Task id: ");
		int taskId = scanner.nextInt();
		task.setTaskId(taskId);
		
		System.out.println("Enter Task name: ");
		String taskName = scanner.next();
		task.setTaskName(taskName);
		
		System.out.println("Enter project id: ");
		int projectId = scanner.nextInt();
		task.setProjectId(projectId);
		
		System.out.println("Enter employee id: ");
		int employeeId = scanner.nextInt();
		task.setEmployeeId(employeeId);
		
		System.out.print("Enter Project Status: ");
	    String status = scanner.next();
	    task.setStatus(status);
	    
	 // Call the service to create the project
	    if (service.createTask(task)) {
	        System.out.println("Task added successfully.");
	    } else {
	        System.out.println("Failed to add project.");
	    }
	}
	
	private static void assignProjectToEmployee(IProjectService service, Scanner scanner) {
		
		System.out.print("Enter Employee ID: ");
	    int employeeId = scanner.nextInt();
	    
		System.out.print("Enter Project ID: ");
	    int projectId = scanner.nextInt();
	    
	    try {
	        boolean success = service.assignProjectToEmployee(employeeId, projectId);
	        if (success) {
	            System.out.println("Project assigned successfully.");
	        } else {
	            System.out.println("Failed to assign project.");
	        }
	    } catch (EmployeeNotFoundException | ProjectNotFoundException e) {
	        System.out.println(e.getMessage());
	    }	
	    
	    
	    
//	    if (service.assignProjectToEmployee(projectId, employeeId)) {
//	        System.out.println("Project assigned to employee successfully.");
//	    } else {
//	        System.out.println("Failed to assign project to employee.");
//	    }
		
	}
	
	private static void assignTaskInProjectToEmployee(IProjectService service, Scanner scanner) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter Task ID: ");
	    int taskId = scanner.nextInt();

	    System.out.print("Enter Employee ID: ");
	    int employeeId = scanner.nextInt();

	    // Call the service method to assign the task to the employee
	    if (service.assignTaskInProjectToEmployee(taskId, employeeId)) {
	        System.out.println("Task assigned to employee successfully.");
	    } else {
	        System.out.println("Failed to assign task to employee.");
	    }
		
	}
	
	private static void deleteEmployee(IProjectService service, Scanner scanner) {
		System.out.print("Enter Employee ID to delete: ");
	    int employeeId = scanner.nextInt();

	    if (service.deleteEmployee(employeeId)) {
	        System.out.println("Employee deleted successfully.");
	    } else {
	        System.out.println("Failed to delete employee. Ensure the ID is correct.");
	    }
		
	}
	
	private static void deleteTask(IProjectService service, Scanner scanner) {
		System.out.print("Enter Task ID to delete: ");
	    int taskId = scanner.nextInt();

	    if (service.deleteTask(taskId)) {
	        System.out.println("Task deleted successfully.");
	    } else {
	        System.out.println("Failed to delete task. Ensure the ID is correct.");
	    }
		
	}
	
	private static void listTasksAssignedToEmployee(IProjectService service, Scanner scanner) {
		System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();

        System.out.print("Enter Project ID: ");
        int projectId = scanner.nextInt();

        List<Task> tasks = service.getAllTasks(empId, projectId);
        if (tasks.isEmpty()) {
            System.out.println("No tasks found for the given employee in this project.");
        } else {
            System.out.println("Tasks assigned to employee " + empId + " in project " + projectId + ":");
            for (Task task : tasks) {
                System.out.println("Task ID: " + task.getTaskId() + ", Task Name: " + task.getTaskName() + ", Status: " + task.getStatus());
            }
        }
		
	}
	


}
