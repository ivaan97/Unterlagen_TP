package webservice;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;

@WebService(name="AlexWebServices")
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class MyWebService {

	@WebMethod
	public String hello (String name){
		return "Hallo " + name + "!";
	}
	
	@WebMethod(operationName="bmi")
	public double bmi(	@WebParam(name="height") double height, 
						@WebParam(name="weight") double weight){
		
		return weight / ((height * height)/10000);
	}
	
}
