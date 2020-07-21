package com.always.learning.UserManagementClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserManagementClientApplication {
	static RestTemplate restTemplate=new RestTemplate();
	static String baseUrl= "http://localhost:8083/springDataDemo/";

	public static void main(String[] args)
	{
		SpringApplication.run(UserManagementClientApplication.class, args);
		//useExchangeMethodOfRestTemplate();
		//ForEntityMethodOfRestTemplateDemo forEntityMethodOfRestTemplateDemo=new ForEntityMethodOfRestTemplateDemo();
		//forEntityMethodOfRestTemplateDemo.driverMethod();
		ForObjectMethodOfRestTemplateDemo forObjectMethodOfRestTemplateDemo=new ForObjectMethodOfRestTemplateDemo();
		forObjectMethodOfRestTemplateDemo.driverMethod();

	}

	private static void useExchangeMethodOfRestTemplate()
	{
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> httpEntity=new HttpEntity<Object>(httpHeaders);
		System.out.println("=============Retrieve a single user based on id===========");
		getSingleUserByExchangeMethod(httpEntity);
		System.out.println("============Retrieve a List of Users ============");
		getListUserByExchangeMethod(httpEntity);
		System.out.println("============Adding the User ============");
		Users sysUser=new Users();
		sysUser.setName("kalpana");
		sysUser.setAddress("us");
		HttpEntity<Object> httpEnt=new HttpEntity<Object>(sysUser,httpHeaders);
		addUserByExchangeMethod(httpEnt);
		System.out.println("============update address based on Id of a User ============");
		updateUserByExchangeMethod(httpEntity);
		System.out.println("============delete specific based on Id of a User ============");
		deleteUserByExchangeMethod(httpEntity);
	}
	private static void getSingleUserByExchangeMethod(HttpEntity<Object> httpEntity)
	{
		ResponseEntity<String> responseEntity=restTemplate.exchange(baseUrl+"userdata/2",
				HttpMethod.GET,
				httpEntity,
				String.class);
		HttpStatus statusCode=responseEntity.getStatusCode();
		System.out.println("status code="+statusCode);
		String users=responseEntity.getBody();
		System.out.println("response body="+users);
		HttpHeaders headers=responseEntity.getHeaders();
		System.out.println("response header="+headers);

//		ResponseEntity<Users> responseEntity1=restTemplate.exchange(baseUrl,
//				HttpMethod.GET,
//				httpEntity,
//				Users.class);
//		Users users1=responseEntity1.getBody();
//		System.out.println("response body="+users1);
	}

	private static void getListUserByExchangeMethod(HttpEntity<Object> httpEntity)
	{
		ResponseEntity<String> responseEntity=restTemplate.exchange(baseUrl+"users_data",
				HttpMethod.GET,
				httpEntity,
				String.class);
		HttpStatus statusCode=responseEntity.getStatusCode();
		System.out.println("status code="+statusCode);

		String users=responseEntity.getBody();
		System.out.println("response body="+users);

		HttpHeaders headers=responseEntity.getHeaders();
		System.out.println("response header="+headers);

	}

	private static void addUserByExchangeMethod(HttpEntity<Object> httpEntity)
	{
		ResponseEntity<String> responseEntity=restTemplate.exchange(baseUrl+"user_data",
				HttpMethod.POST,
				httpEntity,
				String.class);
		HttpStatus statusCode=responseEntity.getStatusCode();
		System.out.println("status code="+statusCode);

		String users=responseEntity.getBody();
		System.out.println("response body="+users);

		HttpHeaders headers=responseEntity.getHeaders();
		System.out.println("response header="+headers);
	}

	private static void updateUserByExchangeMethod(HttpEntity<Object> httpEntity)
	{
		ResponseEntity<String> responseEntity=restTemplate.exchange(baseUrl+"user_data/12/delhi",
				HttpMethod.PUT,
				httpEntity,
				String.class);
		HttpStatus statusCode=responseEntity.getStatusCode();
		System.out.println("status code="+statusCode);

		String users=responseEntity.getBody();
		System.out.println("response body="+users);

		HttpHeaders headers=responseEntity.getHeaders();
		System.out.println("response header="+headers);

	}

	private static void deleteUserByExchangeMethod(HttpEntity<Object> httpEntity)
	{
		ResponseEntity<String> responseEntity=restTemplate.exchange(baseUrl+"user_data/12",
				HttpMethod.DELETE,
				httpEntity,
				String.class);
		HttpStatus statusCode=responseEntity.getStatusCode();
		System.out.println("status code="+statusCode);

		String users=responseEntity.getBody();
		System.out.println("response body="+users);

		HttpHeaders headers=responseEntity.getHeaders();
		System.out.println("response header="+headers);

	}

}
