package webservice;

import java.util.Scanner;

import webservice.gen.alexws.AlexWebServices;
import webservice.gen.alexws.MyWebServiceService;



public class MyClient {

	public static void main(String[] args){
		System.out.println("Java mit eigenem Server und useWSImport.bat:\n-------------------");
		System.out.println("Wie heißt du?");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		AlexWebServices service = new MyWebServiceService().getAlexWebServicesPort();
		System.out.println(service.hello(input));
		
		System.out.println("Gib deine Größe in cm ein:");
		String height = scanner.nextLine();
		
		System.out.println("Gib dein Gewicht in kg ein:");
		String weight = scanner.nextLine();
		
		
		System.out.println("Dein BMI ist: " + service.bmi(Double.parseDouble(height), Double.parseDouble(weight)));
		scanner.close();
	}
}
