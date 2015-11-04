package com.base.dao.city;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.dao.AbstractDao;

public class CityDaoImpl implements CityDao {

	
	private AbstractDao abstractDao; 

	public CityDaoImpl(AbstractDao abstractDao) {
		this.abstractDao=abstractDao;
	}

	@Override
	public String getNameById(String Id) {
		String query="Select name from city where ID=?";
		String name= (String)abstractDao.getJdbcTemplate().queryForObject(
				query, new Object[] { Id }, String.class);
		
		return name;
	}

}
