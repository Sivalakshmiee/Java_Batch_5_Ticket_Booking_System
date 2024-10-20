package com.hexaware.projectmanagementsystem.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.hexaware.projectmanagementsystem.entity.Employee;
import com.hexaware.projectmanagementsystem.entity.Task;
import com.hexaware.projectmanagementsystem.myexceptions.EmployeeNotFoundException;
import com.hexaware.projectmanagementsystem.myexceptions.ProjectNotFoundException;
import com.hexaware.projectmanagementsystem.service.IProjectService;
import com.hexaware.projectmanagementsystem.service.ProjectServiceImpl;

class ProjectSystemTest {
	
	static IProjectService service;
	
	@BeforeAll  
	public static void beforeAll() {
		
		service = new ProjectServiceImpl();
		
	}
	
	@Test
	@Disabled
	void testCreateEmployee() {
		Employee emp = new Employee("divya", "tester", "male", 40000, 107);
		boolean result = service.createEmployee(emp);
		assertTrue(result, "Employee creation successful");
	}
	
	@Test
	@Disabled
	void testCreateTask() {
		Task task = new Task(206, "testing", 109, 15, "Completed");
		boolean result = service.createTask(task);
		assertTrue(result, "Task creation successful");
	}
	
	@Test
	@Disabled
	void testGetAllTasksForEmployeeAndProject() {
	    List<Task> result = service.getAllTasks(14, 109);
	    assertNotNull(result);
	}
	
	@Test
	void testExceptionThrown() {
		int employeeId = 121;
        int projectId = 121;
        
        try {
            service.assignProjectToEmployee(employeeId, projectId);
            fail("Expected EmployeeNotFoundException");

        } catch (EmployeeNotFoundException e) {
            assertTrue(e.getClass() == EmployeeNotFoundException.class, 
                       "Expected EmployeeNotFoundException to be thrown");

        } catch (ProjectNotFoundException e) {
            assertTrue(e.getClass() == ProjectNotFoundException.class, 
                       "Expected ProjectNotFoundException to be thrown");
        }
        
        try {
            service.assignProjectToEmployee(employeeId, projectId);
            fail("Expected ProjectNotFoundException to be thrown");
        } catch (ProjectNotFoundException e) {
            assertTrue(e.getClass() == ProjectNotFoundException.class, 
                       "Expected ProjectNotFoundException to be thrown");
        } catch (EmployeeNotFoundException e) {
        	assertTrue(e.getClass() == EmployeeNotFoundException.class, 
                    "Expected EmployeeNotFoundException to be thrown");
        }
	}
	



}
