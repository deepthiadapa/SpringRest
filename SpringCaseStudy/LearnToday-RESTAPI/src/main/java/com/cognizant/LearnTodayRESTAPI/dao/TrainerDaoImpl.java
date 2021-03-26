package com.cognizant.LearnTodayRESTAPI.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cognizant.LearnTodayRESTAPI.model.Trainer;

@Repository
public class TrainerDaoImpl implements TrainerDao {

	
	JdbcTemplate template;
	
	
	public TrainerDaoImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public boolean trainerSignUp(Trainer trainer) {
		int update = 0;
		update = template.update("INSERT INTO Trainer VALUES (?,?)", trainer.getTrainerId(),trainer.getPassword());
		if (update == 0)
			return false;
		return true;
	}

	@Override
	public String updatePassword(int id, Trainer t) {
		
		int update = 0;
		update = template.update("UPDATE Trainer SET password=? WHERE trainerId=?",t.getPassword(), id);
		if (update == 0) {
			return "error";
		}
		else {
		return "updated";
		}
	}

}
