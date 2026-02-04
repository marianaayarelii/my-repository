package Principal;
import java.util.Scanner;

public class Principal
{

	public static void main(String[] args) 
	{
		int a, b, c;
		double discriminant;
		double resultado, resultado1, resultado2;
		double raiz;
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Escribe el valor (entero) de A: ");
		a = input.nextInt();
		
		System.out.println("Escribe el valor (entero) de B: ");
		b = input.nextInt();
		
		System.out.println("Escribe el valor (entero) de C: ");
		c = input.nextInt();
		
		discriminant = (b*b) - (4*a*c); //positivo = dos raices, cero = una raíz, negativo = no tiene raices reales
		
		if (discriminant == 0) //UNA RAÍZ
		{
			resultado = (-b) / (2*a);
			System.out.println("Esta ecuacion solo tiene una raíz, y es: "+resultado);
		}
		
		else if (discriminant >=1) //DOS RAICES
		{
			raiz = Math.sqrt(discriminant);
			resultado1 = (-b + raiz) / (2*a);
			resultado2 = (-b - raiz) / (2*a);
			System.out.println("Esta ecuacion tiene 2 raices, y son: "+resultado1+" y "+resultado2);
		}
		
		else if (discriminant < 0) //SIN SOLUCION
		{
			System.out.println("La ecuacion NO tiene raices reales.");
		}	
		
		else 
			System.out.println("Error");
	}
}
