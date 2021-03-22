package com.cts.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cts.model.Department;

@Component
public class DepartmentDao {
	private static ArrayList<Department> DEPARTMENT_LIST;
	
	@SuppressWarnings("unchecked")
	public DepartmentDao() {
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST=(ArrayList<Department>) context.getBean("departmentList");
	}

	
	public static void setDEPARTMENT_LIST(ArrayList<Department> dEPARTMENT_LIST) {
		DEPARTMENT_LIST = dEPARTMENT_LIST;
	}
	
	public ArrayList<Department> getAllDepartments(){
		return DEPARTMENT_LIST;
	}
	
}
