package in.nevil.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Map;

import org.junit.Test;

public class TrainServicesValidation {
	//It will display the Number of trains displayed in list is correct 
	@Test
	public void displayTrainNames() {
		Map<String,String>trainNames=TrainService.getDisplayTrainName();
		assertEquals(3,trainNames.size());
	}
	public void displayTrainNames2() {
		Map<String,String>trainNames=TrainService.getDisplayTrainName();
		assertNotEquals(5,trainNames.size());
	}
}
