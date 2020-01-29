/**
 * 
 */
package com.hellofresh.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hellofresh.utility.ConfigDataProvider;
import com.hellofresh.utility.Utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author swajhamb
 *
 */
public class getBookings {

	static int randomNo;
	static String bookingid;
	static String resp;
	public ConfigDataProvider config = new ConfigDataProvider();;

	@Test(priority = 1)
	public void test_get_response() {

		Response r = RestAssured.given().when().get(config.getDataFromConfig("getBookings"));
		System.out.println(r.getStatusCode());
		String bookings = r.jsonPath().getString("bookings.bookingid");
		List<String> myList = new ArrayList<String>(Arrays.asList(bookings.split(",")));
		Assert.assertTrue(myList.size() >= 2);

	}

	@Test(priority = 2)
	public void test_post_response() {
		randomNo = Utility.generateRandomNo();
		Response r = RestAssured.given().contentType("application/json").body("{\"bookingid\":" + randomNo
				+ ",\"roomid\":" + randomNo
				+ ",\"firstname\":\"James\",\"lastname\":\"Dean\",\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2019-01-01\",\"checkout\":\"2019-01-05\"}}")
				.when().post(config.getDataFromConfig("getBookings"));
		System.out.println(r.getStatusCode());
		resp = r.jsonPath().getString("booking");
		bookingid = r.jsonPath().getString("booking.bookingid");
	}

	@Test(priority = 3)
	public void test_get_booking() {
		Response r = RestAssured.given().when().get(config.getDataFromConfig("getBookings") + bookingid);
		System.out.println(r.getStatusCode());
		assertEquals(resp, r.jsonPath().getString(""));
	}
	
	@Test(priority = 4)
	public void test_error_response() {
		randomNo = Utility.generateRandomNo();
		Response r = RestAssured.given().contentType("application/json").body("{\"bookingid\":" + randomNo
				+ ",\"roomid\":" + randomNo
				+ ",\"firstname\":\"James\",\"lastname\":\"Dean\",\"depositpaid\":true,\"bookingdates\":{\"checkout\":\"2019-01-01\",\"checkin\":\"2019-01-05\"}}")
				.when().post(config.getDataFromConfig("getBookings"));
		System.out.println(r.getStatusCode());
		Assert.assertTrue(r.getStatusCode() == 409);
		
	}

}
