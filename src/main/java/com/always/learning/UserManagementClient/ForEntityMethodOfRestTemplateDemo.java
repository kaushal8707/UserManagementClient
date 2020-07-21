package com.always.learning.UserManagementClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.List;

@Component
public class ForEntityMethodOfRestTemplateDemo
{
    static String baseUrl= "http://localhost:8083/springDataDemo/";
    RestTemplate restTemplate=new RestTemplate();

    public void driverMethod()
    {
         System.out.println("*****************forEntity Methods demo*********************");
         getSingleObject();
         getListObject();
         //addUser();
         updateUser();
         deleteUser();
    }
    private void getSingleObject()
    {
        String url=baseUrl+"userdata/2";
        ResponseEntity<String> user=restTemplate.getForEntity(url,String.class);
        HttpStatus statusCode=user.getStatusCode();
        System.out.println("status code="+statusCode);
        String userDetails=user.getBody();
        System.out.println("response body="+userDetails);
        HttpHeaders headers=user.getHeaders();
        System.out.println("response header="+headers);
    }

    private void getListObject()
    {
        String url=baseUrl+"users_data";
        ResponseEntity<List> user=restTemplate.getForEntity(url, List.class);
        HttpStatus statusCode=user.getStatusCode();
        System.out.println("status code="+statusCode);
        List<Object> userDetails=user.getBody();
        System.out.println("response body="+userDetails);
        HttpHeaders headers=user.getHeaders();
        System.out.println("response header="+headers);
    }

    private void addUser()
    {
        String url=baseUrl+"user_data";
        Users users=new Users();
        users.setName("guggupuggu");
        users.setAddress("Canada");
        ResponseEntity<String> responseEntity=restTemplate.postForEntity(url,users,String.class);
        HttpStatus statusCode=responseEntity.getStatusCode();
        System.out.println("status code="+statusCode);
        String body=responseEntity.getBody();
        System.out.println("response body="+body);
        HttpHeaders headers=responseEntity.getHeaders();
        System.out.println("response header="+headers);
//        URI uri=restTemplate.postForLocation(url,String.class);
//        System.out.println("Location URI="+uri);

    }
    public void updateUser()
    {
        String url=baseUrl+"user_data/2/chicago";
        restTemplate.put(url,String.class);
        System.out.println("User Updated !!!");
    }
    public void deleteUser()
    {
        String url=baseUrl+"user_remove_data/3";
        restTemplate.delete(url,String.class);
        System.out.println("User Deleted !!!");
    }


}
