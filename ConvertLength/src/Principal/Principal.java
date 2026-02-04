package Principal;

import java.util.Scanner;

public class Principal 
{

	public static void main(String[] args) 
	{
		  int feet; 		//variable to store feet
		  int inches; 		//variable to store inches
		  int totalInches;  //variable to store total inches

		  double centimeters; //variable to store length in centimeters
		  
		  Scanner input = new Scanner(System.in);
			
		  System.out.println("Escribe el valor de pies: ");
		  feet = input.nextInt();
		  System.out.println("Escribe el valor de pulgadas: ");
		  inches = input.nextInt();
		  
		  totalInches = ((12 * feet) + inches);
		  centimeters = (totalInches * 2.54);
		  
		  System.out.println("El valor total en pulgadas es: "+totalInches);
		  System.out.println("El valor total en centimetros es: "+centimeters);
			
	}

}
