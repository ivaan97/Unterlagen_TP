package webservice;

import javax.swing.JOptionPane;
import javax.xml.ws.Endpoint;

public class PublishWsOnServer {

	public static void main (String[]args){
		Endpoint endpoint = Endpoint.publish("http://127.0.0.1:8080/services", new MyWebService());
		JOptionPane.showMessageDialog(null, "Server beenden");
		endpoint.stop();
	}
}
