package com.qsp.jdbc_prepared_statement_eve.service;

import java.sql.Connection;
import java.util.List;

import com.qsp.jdbc_prepared_statement_eve.dao.MobileDao;
import com.qsp.jdbc_prepared_statement_eve.dto.Mobile;
import com.qsp.jdbc_prepared_statement_eve.exception.IdNotFoundException;

public class MobileService {

	MobileDao dao = new MobileDao();

	// insertMethod
	public void insertMobile(Mobile mobile) {
		if(mobile.getMobileBrand().equalsIgnoreCase("MI")||mobile.getMobileBrand().equals("SAMSUNG")) {
			dao.insertMobile(mobile);
		}else {
			System.out.println("hey please provide only mi or samsung for brand");
		}
		
		
	}

	// update methodMobile
	public void updateMobile(int id, String color, double price, String camera) {
		dao.updateMobile(id, color, price, camera);
	}

	// delete Method
	public void deleteMobile(int id) {
		int id1 = dao.getById(id);
		if(id==id1) {
			dao.deleteMobile(id);
		}else {
			try {
				throw new IdNotFoundException("Id not Found");
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		}
	}
	
	//displaymethodMobile
	public List<Mobile> displayMobiles(){
		
		List<Mobile> list= dao.displayMobiles();
		
		return list;
	}
	//insertMethodsAddBatch
	public void insertAddBatch(List<Mobile> mobile) {
		dao.insertAddBatch(mobile);
	}
}
