package com.hexaware.projectmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.projectmanagementsystem.entity.Employee;
import com.hexaware.projectmanagementsystem.entity.Project;
import com.hexaware.projectmanagementsystem.entity.Task;
import com.hexaware.projectmanagementsystem.myexceptions.EmployeeNotFoundException;
import com.hexaware.projectmanagementsystem.myexceptions.ProjectNotFoundException;
import com.hexaware.projectmanagementsystem.util.DBConnection;

public class ProjectRepositoryImpl implements IProjectRepository{
	
	private Connection conn;
	   public ProjectRepositoryImpl() {
	       conn = DBConnection.getConnection();
	   }


	@Override
	public boolean createEmployee(Employee emp) {
		 try {
	           String query = "INSERT INTO Employee (name, designation, gender, salary, project_id) VALUES (?, ?, ?, ?,?)";
	           PreparedStatement stmt = conn.prepareStatement(query);
	           stmt.setString(1, emp.getName());
	           stmt.setString(2, emp.getDesignation());
	           stmt.setString(3, emp.getGender());
	           stmt.setInt(4, emp.getSalary());
	           stmt.setInt(5, emp.getProjectId());
	           
	           
	           return stmt.executeUpdate() > 0;
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return false;

	}

	@Override
	public boolean createProject(Project pj) {
		 try {
	           String query = "INSERT INTO Project (id, projectName, description, startDate, status) VALUES (?, ?, ?, ?, ?)";
	           PreparedStatement stmt = conn.prepareStatement(query);
	           stmt.setInt(1, pj.getId());	           
	           stmt.setString(2, pj.getProjectName());
	           stmt.setString(3, pj.getDescription());
	           stmt.setString(4, pj.getStartDate());
	           stmt.setString(5, pj.getStatus());
	           return stmt.executeUpdate() > 0;
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return false;
	}

	@Override
	public boolean createTask(Task task) {
		try {
			String query = "INSERT INTO Task (task_id, task_name, project_id, employee_id, Status) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, task.getTaskId());
			stmt.setString(2, task.getTaskName());
			stmt.setInt(3, task.getProjectId());
			stmt.setInt(4, task.getEmployeeId());
			stmt.setString(5, task.getStatus());
			return stmt.executeUpdate() > 0;
			
		} catch (Exception e) {
	           e.printStackTrace();
	       }
		return false;
	}

	@Override
	public boolean assignProjectToEmployee(int employeeId, int projectId) throws EmployeeNotFoundException, ProjectNotFoundException{
		 // Check if employee exists
	    String employeeCheckQuery = "SELECT id FROM Employee WHERE id = ?";
	    try (PreparedStatement checkStmt = conn.prepareStatement(employeeCheckQuery)) {
	        checkStmt.setInt(1, employeeId);
	        ResultSet empRs = checkStmt.executeQuery();
	        if (!empRs.next()) {
	            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " does not exist.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    String projectCheckQuery = "SELECT id FROM Project WHERE id = ?";
	    try (PreparedStatement checkStmt = conn.prepareStatement(projectCheckQuery)) {
	        checkStmt.setInt(1, projectId);
	        ResultSet projRs = checkStmt.executeQuery();
	        if (!projRs.next()) {
	            throw new ProjectNotFoundException("Project with ID " + projectId + " does not exist.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
		try {
			System.out.println("Assigning Project ID: " + projectId + " to Employee ID: " + employeeId);
            String query = "UPDATE employee SET project_id = ? WHERE id = ?";
//            System.out.println("Executing query: " + query);
//            System.out.println("Setting project_id to: " + projectId);
//            System.out.println("Where employee id is: " + employeeId);
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, projectId);
            stmt.setInt(2, employeeId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Project assigned to employee successfully.");
                return true;
            } else {
                System.out.println("No matching employee found for the given ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean assignTaskInProjectToEmployee(int taskId, int employeeId) {
		try {
	        // check if the task exists
	        String taskCheckQuery = "SELECT task_id FROM Task WHERE task_id = ?";
	        PreparedStatement checkStmt = conn.prepareStatement(taskCheckQuery);
	        checkStmt.setInt(1, taskId);
	        ResultSet rs = checkStmt.executeQuery();

	        if (!rs.next()) {
	            System.out.println("No matching task found for the given ID.");
	            return false; // Task does not exist
	        }

	        // Check if the employee exists
	        String employeeCheckQuery = "SELECT id FROM Employee WHERE id = ?";
	        PreparedStatement empCheckStmt = conn.prepareStatement(employeeCheckQuery);
	        empCheckStmt.setInt(1, employeeId);
	        ResultSet empRs = empCheckStmt.executeQuery();

	        if (!empRs.next()) {
	            System.out.println("No matching employee found for the given ID.");
	            return false; // Employee does not exist
	        }

	        
	        String updateTaskQuery = "UPDATE Task SET employee_id = ? WHERE task_id = ?";
	        PreparedStatement updateStmt = conn.prepareStatement(updateTaskQuery);
	        updateStmt.setInt(1, employeeId);
	        updateStmt.setInt(2, taskId);

	        return updateStmt.executeUpdate() > 0; 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		try {
            String query = "DELETE FROM Employee WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, employeeId);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}


	public List<Task> getAllTasks(int empId, int projectId) {
	    List<Task> tasks = new ArrayList<>();
	    try {
	       
	        String query = "SELECT t.task_id, t.task_name, t.status FROM Task t JOIN Employee e ON t.employee_id = e.id WHERE e.id = ? AND t.project_id = ?";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setInt(1, empId);
	        stmt.setInt(2, projectId);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Task task = new Task();
	            task.setTaskId(rs.getInt("task_id")); 
	            task.setTaskName(rs.getString("task_name")); 
	            task.setStatus(rs.getString("status")); 
	            tasks.add(task);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return tasks;
	}

	@Override
	public boolean deleteTask(int taskId) {
		try {
            String query = "DELETE FROM Task WHERE task_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, taskId);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;	}
	

}
