package Principal;
import java.util.Scanner;

public class Principal
{

	public static void main(String[] args) 
	{
		int randomnumber = 0;
		int usernumber = 0;
		
		randomnumber = (int) (Math.random()*100); 
		
		do
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Adivina el numero! ");
			usernumber = input.nextInt();
			
			if (usernumber == randomnumber)
			{
				System.out.println("¡Felicidades, Adivinaste el numero!");
			}
			else if (usernumber < randomnumber)
			{
				System.out.println("Your guess is lower than the number, try again... ");
			}
			else if (usernumber > randomnumber)
			{
				System.out.println("Your guess is higher than the number, try again... ");
			}
		} while(usernumber != randomnumber);
	}
}
