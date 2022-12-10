package com.qsp.jdbc_prepared_statement_eve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.qsp.jdbc_prepared_statement_eve.connection.MobileConnection;
import com.qsp.jdbc_prepared_statement_eve.dto.Mobile;

public class MobileDao {

	Connection connection = null;

	public void insertMobile(Mobile mobile) {
		connection = MobileConnection.getConnection();

		String insert = "insert into mobile values(?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insert);

			preparedStatement.setInt(1, mobile.getMobileId());
			preparedStatement.setString(2, mobile.getMobileBrand());
			preparedStatement.setDouble(3, mobile.getMobilePrice());
			preparedStatement.setString(4, mobile.getMobileColor());
			preparedStatement.setString(5, mobile.getMobileCamera());

			preparedStatement.execute();
			System.out.println("Data inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// update methodMobile
	public void updateMobile(int id, String color, double price, String camera) {

		connection = MobileConnection.getConnection();

		String update = "update mobile set color=?,price=?,camera=? Where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setInt(4, id);
			preparedStatement.setString(1, color);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, camera);

			preparedStatement.executeUpdate();

			System.out.println("Data updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// delete Method
	public void deleteMobile(int id) {

		connection = MobileConnection.getConnection();

		String delete = "delete from mobile where id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(delete);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("Deleted....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// getByIdmethod
	public int getById(int id) {

		connection = MobileConnection.getConnection();

		String select = "Select * from mobile where id = ?";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(select);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				if (resultSet != null) {
					return resultSet.getInt(id);
				} else {
					return 0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	// displaymethodMobile
	public List<Mobile> displayMobiles() {

		connection = MobileConnection.getConnection();
		
		String select = "Select * from mobile";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			List<Mobile> list  = new ArrayList<Mobile>();
			
			
			while(resultSet.next()) {
				
				Mobile mobile = new Mobile();
				mobile.setMobileId(resultSet.getInt("id"));
				mobile.setMobilePrice(resultSet.getDouble("price"));
				mobile.setMobileBrand(resultSet.getString("brand"));
				mobile.setMobileColor(resultSet.getString("color"));
				mobile.setMobileCamera(resultSet.getString("camera"));
				
				list.add(mobile);
				
				
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//insertMethodsAddBatch
	public void insertAddBatch(List<Mobile> mobile) {
		
		connection = MobileConnection.getConnection();
		
		String insert = "insert into mobile values(?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			
			for (Mobile mobile2 : mobile) {
			
				preparedStatement.setInt(1, mobile2.getMobileId());
				preparedStatement.setString(2, mobile2.getMobileBrand());
				preparedStatement.setDouble(3, mobile2.getMobilePrice());
				preparedStatement.setString(4, mobile2.getMobileColor());
				preparedStatement.setString(5, mobile2.getMobileCamera());
				
				preparedStatement.execute();
				//preparedStatement.addBatch();
			}
			//preparedStatement.executeBatch();
			
			System.out.println("Data Stored..........");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
