package application;


import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department obj = new Department(1,"Books");
		
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		//Seller seller = new Seller(21,"Bob","Bob@gmai.com",3000.0,new Date(),obj);
		System.out.println("=== TEST 1: sellerFindById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj2 : list) {
			System.out.println(obj2);
		}

	}

}
