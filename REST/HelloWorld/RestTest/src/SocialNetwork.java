/**
 * Created by Tobias on 28.05.2017.
 */

import javax.ws.rs.*;

// Find site under http://localhost/SocialNetwork
@Path("SocialNetwork")
public class SocialNetwork {
	
    @GET
    @Produces("text/plain")
    public String welcome(){
       String welcomeText =  "This is a simple application to demonstrate the power of REST \n\n";
       welcomeText += "GET USERS: http://localhost/SocialNetwork/getUser/ \n";
       welcomeText += "GET Messages FROM User: http://localhost/SocialNetwork/messages/{username} \n";
       welcomeText += "POST TEXT: http://localhost/SocialNetwork/postText/{text} \n";

       return welcomeText;
    }
    
    @GET
    @Path("getUser")
    @Produces("text/plain")
    public String getUser(){
        String user = "";
        for(int i = 0; i < SampleData.users.size(); i++){
        	user += SampleData.users.get(i).username;
        	user += "\n";
        }
        return user;
    }
    
    
   @GET
    @Path("messages/{username}")
    @Produces("text/plain")
    public String Post(@PathParam("username") String username){
        String message = "Messages from " + username +":\n\n";
        for(int i = 0; i < SampleData.messages.size(); i++){
        	if(SampleData.messages.get(i).getUser().username == username){
        		System.out.println(SampleData.messages.get(i).getMessage());
            	message += SampleData.messages.get(i).getMessage();
            	message += "\n";
        	}
        }
		return message;
    }

   /*
    @GET
    @Path("friends/{username}")
    @Produces("text/plain")
    public String Freunde(@PathParam("username") String username)
    {
        return "Markus, Mirco, Rafael, Tobias ";
    }

    @Path("postText/{text}")
    @GET
    @Produces("text/plain")
    public String postText(@PathParam("text") String text){
        return text + "\n\n POSTED!";
    }*/
}
