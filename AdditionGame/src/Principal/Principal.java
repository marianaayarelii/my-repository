package Principal;
import java.util.Scanner;
public class Principal
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int number1, number2;
		int numberStudent;

		number1 = (int) (Math.random()*100);  //Es un numero de 0 a 1, por eso se multiplica por 10
		number2 = (int) (Math.random()*100);  //También necesita casting porque es un double 
		
		System.out.println("¿Cuánto es " + number1 + " + " + number2 + "?");
		
		Scanner input = new Scanner(System.in);
		numberStudent = input.nextInt();
		
		if (numberStudent == number1 + number2)
		{
			System.out.println("Correcto");
		}
		else
		{
			System.out.println("Incorrecto");
		}
	}
}