package com.example.Mockito.demo.bussines;

public class SomeBussinesImpl {

	private DataService dataService;

	public SomeBussinesImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findTheGreathestFromAllData() {
		int[] data = dataService.RetrievallData();
		int greatestValue = Integer.MIN_VALUE;
		for (int value : data) {
			if (value > greatestValue) {
				greatestValue = value;
			}
		}
		return greatestValue;
	}

}