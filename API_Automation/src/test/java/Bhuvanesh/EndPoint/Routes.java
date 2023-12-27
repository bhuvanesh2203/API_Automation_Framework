package Bhuvanesh.EndPoint;
/*
Swagger URI --> https://petstore.swagger.io

Create user(Post): https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user[username} 
Update user (Put): https://petstore.swagger.io/vz/user/(username) 
 Delete user (Delete): https://petstore.swagger.io/v2/user/(username)
*/
public class Routes {
 public static String BaseURL="https://petstore.swagger.io/v2";
 
//User module
 public static String post_url=BaseURL+"/user";
 public static String get_url=BaseURL+"/user/{username}";
 public static String update_url=BaseURL+"/user/{username}";
 public static String delete_url=BaseURL+"/user/{username}";
 public static String post_url_list=BaseURL+"/user/createWithList";
 
 
 //Pet module
 public static String create_Pet=BaseURL+"/pet";
 public static String create_Pet_Image=BaseURL+"/{petId}/uploadImage";

 
}