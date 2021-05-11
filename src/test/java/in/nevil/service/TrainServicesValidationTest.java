package in.nevil.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import org.junit.Test;

import in.nevil.model.Train;

public class TrainServicesValidationTest {
	//It will display the Number of trains displayed in list is correct 
	@Test
	public void displayTrainNamesTest() {
		List<Train>trainNames=TrainService.getAllTrains();
		assertEquals(4,trainNames.size());
	}
	public void displayTrainNames2Test() {
		List<Train>trainNames=TrainService.getAllTrains();	
		assertNotEquals(5,trainNames.size());
	}
}
