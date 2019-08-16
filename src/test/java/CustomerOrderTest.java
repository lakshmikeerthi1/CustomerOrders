import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.customer.orders.bean.Customer;


public class CustomerOrderTest {
	 final String baseUrl = "http://localhost:8080/customer";
	@Test
	public void testGetEmployeeListSuccess() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	     String url = baseUrl+ "/get";
	    ResponseEntity<List<Customer>> result = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>(){});
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	}
	@Test
	public void testAddEmployeeMissingHeader() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	    final String baseUrl = "http://localhost:8080/customer"+"/create/";
	    Customer employee = new Customer(1221, "Order1", 4);
	     
	    HttpHeaders headers = new HttpHeaders();
	 
	    HttpEntity<Customer> request = new HttpEntity<>(employee, headers);
	     
	    try
	    {
	    	ResponseEntity<List<Customer>> result = restTemplate.exchange(baseUrl, HttpMethod.POST, request, new ParameterizedTypeReference<List<Customer>>(){});
	 	    //Assert.fail();
	    	Assert.assertEquals(201, result.getStatusCodeValue());
	    }
	    catch(HttpClientErrorException ex)
	    {
	    	ex.printStackTrace();
	        //Verify bad request and missing header
	        Assert.assertEquals(400, ex.getRawStatusCode());
	        Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
	}}
}