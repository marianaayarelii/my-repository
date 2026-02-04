package Principal;
import java.util.Scanner;

public class Principal 
{

	public static void main(String[] args) 
	{
		int a,b,c,d,e,f;
		double numerador1, numerador2, denominador, x, y;
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Escribe el valor (entero) de A: ");
		a = input.nextInt();

		System.out.println("Escribe el valor (entero) de B: ");
		b = input.nextInt();
		
		System.out.println("Escribe el valor (entero) de C: ");
		c = input.nextInt();
		
		System.out.println("Escribe el valor (entero) de D: ");
		d = input.nextInt();
		
		System.out.println("Escribe el valor (entero) de E: ");
		e = input.nextInt();
		
		System.out.println("Escribe el valor (entero) de F: ");
		f = input.nextInt();
		
		denominador = (a*d) - (b*c);
		
		if(denominador == 0)
			System.out.println("La ecuacion NO tiene solucion.");
		else
		{
			numerador1 = (e*d) - (b*f);
			numerador2 = (a*f) - (e*c);
			
			x = numerador1 / denominador;
			y = numerador2 / denominador;
			System.out.println("La solucion es: "+x+" y "+y);
		}
			
	}

}