package com.example.Mockito.demo;

import org.junit.jupiter.api.Test;

import com.example.Mockito.demo.bussines.DataService;
import com.example.Mockito.demo.bussines.SomeBussinesImpl;
import static org.junit.jupiter.api.Assertions.*;

public class SomeBussinesImplStubTest {

	@Test
	void test() {
		DataServiceStub data = new DataServiceStub();
		SomeBussinesImpl bussines = new SomeBussinesImpl(data);
		int result = bussines.findTheGreathestFromAllData();
		assertEquals(25,result);
	}
}

class DataServiceStub implements DataService{

	@Override
	public int[] RetrievallData() {
		
		return new int [] {25,15,5};
	}
	
}