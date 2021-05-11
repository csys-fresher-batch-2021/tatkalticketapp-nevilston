package in.nevil.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import org.junit.Test;

import in.nevil.model.Train;

public class TrainServicesValidation {
	//It will display the Number of trains displayed in list is correct 
	@Test
	public void displayTrainNames() {
		List<Train>trainNames=TrainService.getAllTrains();
		assertEquals(4,trainNames.size());
	}
	public void displayTrainNames2() {
		List<Train>trainNames=TrainService.getAllTrains();	
		assertNotEquals(5,trainNames.size());
	}
}
