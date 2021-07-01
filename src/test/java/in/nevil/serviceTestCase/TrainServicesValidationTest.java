package in.nevil.serviceTestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import in.nevil.dao.TrainDAO;
import in.nevil.model.Train;

public class TrainServicesValidationTest {
	//It will display the Number of trains displayed in list is correct
	@Test
	public void displayTrainNamesTest() throws ClassNotFoundException, SQLException {
		TrainDAO trainDAO = new TrainDAO();
		List<Train>trainNames=trainDAO.getTrainDetails();
		assertEquals(4, trainNames.size());
	}
	@Test
	public void displayTrainNames2Test() throws ClassNotFoundException, SQLException {
		TrainDAO trainDAO = new TrainDAO();
		List<Train>trainNames=trainDAO.getTrainDetails();
		assertNotEquals(7,trainNames.size());
	}
}
