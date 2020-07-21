package com.always.learning.UserManagementClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.List;

@Component
public class ForObjectMethodOfRestTemplateDemo
{
    Logger logger=LoggerFactory.getLogger(ForObjectMethodOfRestTemplateDemo.class);
    static String baseUrl= "http://localhost:8083/springDataDemo/";
    RestTemplate restTemplate=new RestTemplate();

    public void driverMethod()
    {
        System.out.println("*****************forObject Methods demo*********************");
        getSingleObject();
        getListObject();
        addUser();
        updateUser();
        deleteUser();
    }
    private void getSingleObject()
    {
        String url=baseUrl+"userdata/2";
        String user=restTemplate.getForObject(url,String.class);
        logger.info("User - {}",user);
    }

    private void getListObject()
    {
        String url=baseUrl+"users_data";
        List listOfUser=restTemplate.getForObject(url, List.class);
        logger.info("List of User - {}",listOfUser);
    }

    private void addUser()
    {
        String url=baseUrl+"user_data";
        Users users=new Users();
        users.setName("temp1");
        users.setAddress("Canada");
        String response=restTemplate.postForObject(url,users,String.class);
        logger.info("response - {}",response);
    }
    public void updateUser()
    {
        String url=baseUrl+"user_data/2/temp";
        restTemplate.put(url,String.class);
        System.out.println("User Updated !!!");
    }
    public void deleteUser()
    {
        String url=baseUrl+"user_remove_data/5";
        restTemplate.delete(url,String.class);
        System.out.println("User Deleted !!!");
    }
}
