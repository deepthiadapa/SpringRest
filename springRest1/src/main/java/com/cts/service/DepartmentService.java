package com.cts.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.DepartmentDao;
import com.cts.model.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	
	public DepartmentService(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}


	public ArrayList<Department> getAllDepartments(){
		return departmentDao.getAllDepartments();
	}
		
}
