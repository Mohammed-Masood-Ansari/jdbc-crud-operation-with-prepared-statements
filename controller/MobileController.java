package com.qsp.jdbc_prepared_statement_eve.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.qsp.jdbc_prepared_statement_eve.dto.Mobile;
import com.qsp.jdbc_prepared_statement_eve.service.MobileService;

public class MobileController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MobileService mobileService = new MobileService();
		Mobile mobile = new Mobile();
		while (true) {
			System.out.println("1.Insert\n2.Update\n3.DeleteMobile\n4.Display\n5.InsertBatch\n6.Exit");
			System.out.println("give your own option");
			int ch = scanner.nextInt();

			switch (ch) {

			case 1: {
					System.out.println("insert the mobileId");
					mobile.setMobileId(scanner.nextInt());
					System.out.println("insert the mobileBrand");
					mobile.setMobileBrand(scanner.next());
					System.out.println("insert the mobilePrice");
					mobile.setMobilePrice(scanner.nextDouble());
					System.out.println("insert the mobileColor");
					mobile.setMobileColor(scanner.next());
					System.out.println("insert the mobileCamera");
					mobile.setMobileCamera(scanner.next());
					
					mobileService.insertMobile(mobile);
					
					System.out.println("Case1 completed");
			}
				break;
			case 2:{
				System.out.println("insert the mobileId");
				int id = scanner.nextInt();
				System.out.println("insert the mobileColor");
				String color = scanner.next();
				System.out.println("insert the mobilePrice");
				double price = scanner.nextDouble();
				System.out.println("insert the mobileCamera");
				String camera = scanner.next();
				
				mobileService.updateMobile(id, color, price, camera);
			}break;
			
			case 3:{
				System.out.println("provide your id to delete");
				int id = scanner.nextInt();
				
				mobileService.deleteMobile(id);
			}break;
			
			case 4:{
				
				List<Mobile> list=mobileService.displayMobiles();
				
				for (Mobile mobile2 : list) {
					
					System.out.println("mobileId = "+mobile2.getMobileId());
					System.out.println("mobilePrice = "+mobile2.getMobilePrice());
					System.out.println("mobileBrand = "+mobile2.getMobileBrand());
					System.out.println("mobileColor = "+mobile2.getMobileColor());
					System.out.println("mobileCamera = "+mobile2.getMobileCamera());
					
					System.out.println("............................................................");
				}
			}break;
			
			case 5:{
				      System.out.println("how many mobiles you want to insert");
				      
				      int size = scanner.nextInt();
				      
				      List<Mobile> mobiles = new ArrayList<Mobile>();
				      
				      for(int i = 0;i<size;i++) {
				    	  
				    	  Mobile mobile2 = new Mobile();
				    	  
				    	  System.out.println("enter the mobileID");
				    	  mobile2.setMobileId(scanner.nextInt());
				    	  
				    	  System.out.println("enter the mobileBrand");
				    	  mobile2.setMobileBrand(scanner.next());
				    	  
				    	  System.out.println("enter the mobilePrice");
				    	  mobile2.setMobilePrice(scanner.nextDouble());
				    	  
				    	  System.out.println("enter the mobileColor");
				    	  mobile2.setMobileColor(scanner.next());
				    	  
				    	  System.out.println("enter the mobileCamera");
				    	  mobile2.setMobileCamera(scanner.next());
				    	  
				    	  mobiles.add(mobile2);
				      }
				      
				      mobileService.insertAddBatch(mobiles);
			}break;
			case 6:{
				System.exit(0);
			}break;
			}
		}
	}
}
