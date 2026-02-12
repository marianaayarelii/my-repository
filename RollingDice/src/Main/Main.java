package Main;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		int dice1, dice2;
		int numdeseado, suma;
		int count = 0;
		
		System.out.println("Coloca el número deseado (entero) en un rango de [2,12]: ");
		Scanner input = new Scanner(System.in);
		numdeseado = input.nextInt();
		
		if(numdeseado>=2 && numdeseado<=12)
		{
			do
			{
				dice1 = (int)(Math.random()*100%6+1);
				dice2 = (int)(Math.random()*100%6+1);
				suma = dice1 + dice2;
				count++;
				System.out.println("El número en la iteración: "+count+" fue "+suma);
				
				if (suma == numdeseado)
					break;
				else 
					continue;
				
			}while (suma != numdeseado);
			System.out.println("El número de veces que se tiró el dado para obtener el número fue: "+count);
		}
		else 
			System.out.println("El número debe estar en un rango de [2,12]");
	}
}
