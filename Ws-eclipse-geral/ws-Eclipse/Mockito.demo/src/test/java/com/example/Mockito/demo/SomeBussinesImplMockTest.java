package com.example.Mockito.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Mockito.demo.bussines.DataService;
import com.example.Mockito.demo.bussines.SomeBussinesImpl;

@ExtendWith(MockitoExtension.class)
public class SomeBussinesImplMockTest {

	@Mock
	private DataService service;

	@InjectMocks
	private SomeBussinesImpl bussines;

	@Test
	void findTheGreatestFromAllData_basicScenario() {

		when(service.RetrievallData()).thenReturn(new int[] { 25, 15, 5 });
		int result = bussines.findTheGreathestFromAllData();
		assertEquals(25, result);
	}

	@Test
	void findTheGreatestFromAllData_OneValue() {

		when(service.RetrievallData()).thenReturn(new int[] { 30 });
		int result = bussines.findTheGreathestFromAllData();
		assertEquals(30, result);
	}
}