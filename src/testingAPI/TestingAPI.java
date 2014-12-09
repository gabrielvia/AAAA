/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testingAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import model.Customer;
import model.Person;

/**
 *
 * @author Yu
 */
public class TestingAPI {
    
    private static String userName = "root";
    private static final String CONN_USERNAME = "hibernate.connection.username";
    
    
    
    private static char[] password = {'r','o','o','t'};
    private static final String CONN_PASSWORD = "hibernate.connection.password";
    
    
    private static String url = "jdbc:mysql://localhost:3306/itransportconfigtool";
    private static final String CONN_URL = "hibernate.connection.url";
    
//    private String 
    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        TestingAPI.userName = userName;
    }

    public static char[] getPassword() {
        return password;
    }

    public static void setPassword(char[] password) {
        TestingAPI.password = password;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        TestingAPI.url = url;
    }
    
    
    
    public static Person generatePerson(){
        
        Map<String,String> properties = new HashMap();
        properties.put(CONN_USERNAME, userName);
        properties.put(CONN_PASSWORD, new String(password));
        properties.put(CONN_URL, url);
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("itransportconfigtool",properties);
        
        
        
        Person p = null;
        
        p = new Customer();
        
        return p;
    }
    
    
    public static Person generatePerson(Map properties){
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("itransportconfigtool", properties);
        
        Person p = null;
        
        p = new Customer();
        
        return p;
    }
    
    public static String getResource(String url) throws IOException, Exception{
        
        String result = null;
        
        String innerUrl = "/resources/persistence.xml";
        if (url != null){
            innerUrl = url;
        }
        
        Class clazz = Class.forName("testingAPI.TestingAPI");
        
//        ClassLoader clazzLoader = clazz.getClassLoader();
        
        InputStream is = clazz.getResourceAsStream(innerUrl);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        String tempResult = "";
        String line = null;
        
        while((line = br.readLine())!=null){
            System.out.println(tempResult);
            tempResult = tempResult + line;
        }
        
        System.out.println(tempResult);
        
        return result;
    }
    
    
    
}
