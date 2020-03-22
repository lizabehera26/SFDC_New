import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getMethod {
//using post method
	
  public static void main(String[] args) throws Exception {
	
    String sURL ="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login";
	RestAssured.baseURI = sURL;
		
	Response res =	RestAssured.given().body("{\"username\": \"swagatika@ta.com\",\"password\": \"swagatika\"}").when().contentType("application/json").post();
	//System.out.println(res.asString());		
	//System.out.println(res.statusCode());
	
	String s1 =res.jsonPath().getString("token".toString());
	s1 = s1.replace("[","").replace("]","");
	if(res.jsonPath().getString("token").contains(" ")) 
	{
		throw new Exception("contains blankspace in token");
	}
	else {
		System.out.println("No space found");
	}
	
	//using Get method

	String s1URL ="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/getdata";
	RestAssured.baseURI = s1URL ;
	
	HashMap<String,String> map = new HashMap<>();
	
	map.put("token",s1);
	System.out.println(map);
	Response resget = RestAssured.given().contentType("application/json").when().headers(map).get();
	//System.out.println(resget.asString());
	//System.out.println(resget.statusCode());
	//System.out.println(resget.jsonPath().getString("data.accountno".toString()));
	//System.out.println(resget.jsonPath().getString("data.acountno[0]".toString()));
	List<Map<String, String>> accountno = resget.jsonPath().getList("data.accountno");
	for(int i=0;i<accountno.size();i++) {
		
		System.out.println(accountno.get(i));
	}
	
    
  //Using post method adding new user//
    
  	String s3URL ="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/addData";
  	RestAssured.baseURI = s3URL ;
  	HashMap<String,String> map1 = new HashMap<>();
  	
	map1.put("token",s1);
	System.out.println(map1);
  	Response rep =RestAssured.given().headers(map1).body("{\"accountno\":\"TA-55558999\",\"departmentno\":\"1\",\"salary\":\"1\",\"pincode\":\"111111\"}").contentType("application/json").post();
  	System.out.println(rep.asString());
  	System.out.println(rep.statusCode());
  	//System.out.println(rep.jsonPath().getString("token".toString()));
  	
  	//using put method to edit data//
  	
    String s4URL = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/updateData" ;
    RestAssured.baseURI = s4URL ;
    HashMap<String,String> map2 = new HashMap<>();
  	
	map2.put("token",s1);
	map2.put("Content-Type","application/json");
	
    Response res1 = RestAssured.given().headers(map2).body("{\"accountno\":\"33333335\",\"departmentno\":8,\"salary\":400000,\"pincode\":345678,\"userid\":\"orWRlfqd8gtr3Ocu2NdD\",\"id\":\"MqMxety3HMpwHxCbeTfU\"}").put();
    System.out.println(res1.asString());
    System.out.println(res1.statusCode());
    
    //delete data using delete method
  
	
	String s2URL= "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/deleteData";
	RestAssured.baseURI = s2URL;
	HashMap<String,String> map4  = new HashMap<>();

  Response resp = RestAssured.given().headers(map4).body("{\"accountno\":\"12121212\",\"departmentno\":\"1\",\"salary\":\"121212\",\"pincode\":\"121212\",\"userid\":\"U9bzp9uxyY1qstrC6NLQ\",\"id\":\"3DkQkzMaK9ZGvpaNQlgv\"}").when().contentType("application/json").delete();
  System.out.println(resp.asString());
  System.out.println(resp.statusCode());

  
  	
  	
 // logout using post method//
  	
  	String s5URL = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/logout";
  	RestAssured.baseURI = s5URL ;
	HashMap<String,String> map3 = new HashMap<>();
  	
	map3.put("token",s1);
  	Response res4 =	RestAssured.given().body("{\"token\":\"null\"}").when().contentType("application/json").headers(map3).post();
  	System.out.println(res4.asString());		
	System.out.println(res4.statusCode());
	
	
	
  	}
	
	
	

}
