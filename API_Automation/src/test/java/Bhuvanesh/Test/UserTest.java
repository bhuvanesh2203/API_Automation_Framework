package Bhuvanesh.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Bhuvanesh.EndPoint.UserEndPoints;
import Bhuvanesh.Payload.User;
import io.restassured.response.Response;



public class UserTest {

	Faker faker;
	User userPayload;
	public Logger logger;

	@BeforeClass
	public void setup() {
		faker=new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname (faker.name().firstName());
		userPayload.setLastname (faker.name().lastName());
		userPayload.setEmail (faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password (5, 10));
		userPayload.setPhonenumber (faker.phoneNumber().cellPhone());
		logger=LogManager.getLogger(this.getClass());
		
	}
	@Test(priority=1)
	public void testPostUser() {
		logger.info("create the test user");
		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void testgetUser() {
		logger.error("Get the test user");
		System.out.print("gett the username:"+this.userPayload.getUsername());
		Response response=UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=3)
	public void testPutUser() {
		logger.info("Update the test user");
		userPayload.setFirstname (faker.name().firstName());
	userPayload.setLastname (faker.name().lastName());
	userPayload.setEmail (faker.internet().safeEmailAddress());
		Response response=UserEndPoints.updateUser(userPayload.getUsername(),userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		Response response_1=UserEndPoints.readUser(userPayload.getUsername());
		System.out.print("modiffied data:");
		response_1.then().log().all();
		Assert.assertEquals(response_1.getStatusCode(), 200);
		
	}
	@Test(priority=4)
	public void testdeleteUser() {
		logger.info("delete the test user");
		System.out.print("gett the username:"+this.userPayload.getUsername());
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
