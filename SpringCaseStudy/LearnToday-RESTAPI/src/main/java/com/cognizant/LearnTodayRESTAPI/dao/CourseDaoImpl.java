package com.cognizant.LearnTodayRESTAPI.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cognizant.LearnTodayRESTAPI.model.Course;

@Repository
public class CourseDaoImpl implements CourseDao {

	
	JdbcTemplate template;
	

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Course> getAllCourses() {

		return template.query("select * from Course", new ResultSetExtractor<List<Course>>() {
			@Override
			public List<Course> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Course> courses = new ArrayList<Course>();
				while (rs.next()) {
					Course course= new Course();
					course.setCourseId(rs.getInt(1));
					course.setTitle(rs.getString(2));
					course.setFees(rs.getFloat(3));
					course.setDescription(rs.getString(4));
					course.setTrainer(rs.getString(5));
					course.setStartDate(rs.getDate(6));
					courses.add(course);
				}
				return courses;
			}
		});
	}

	@Override
	public Course getCourseById(int id) {
		List<Course> courses = getAllCourses();
		for (Course course : courses) {
			if(course.getCourseId()== id) {
				return course;
			}
		}
		return null;
	}

}
