package Principal;
import java.util.Scanner;

public class Principal 
{
	public static void main(String[] args) 
	{
		double x1, y1, ancho1, altura1;
		double x2, y2, ancho2, altura2;
		
		double left1, right1, top1, bottom1;
		double left2, right2, top2, bottom2;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Escribe x1: ");
		x1 = input.nextDouble();
		
		System.out.println("Escribe y1: ");
		y1 = input.nextDouble();
		
		System.out.println("Escribe ancho1: ");
		ancho1 = input.nextDouble();
		
		System.out.println("Escribe altura1: ");
		altura1 = input.nextDouble();
		
		System.out.println("Escribe x2: ");
		x2 = input.nextDouble();
		
		System.out.println("Escribe y2: ");
		y2 = input.nextDouble();
		
		System.out.println("Escribe ancho2: ");
		ancho2 = input.nextDouble();
		
		System.out.println("Escribe altura2: ");
		altura2 = input.nextDouble();
		
		//HAREMOS UN BARRIDO DESDE EL CENTRO DE LOS RECTÁNGULOS PARA VER SI HAY INTERSECCIONES
		// Rectangulo 1
		left1   = x1 - (ancho1  / 2);
		right1  = x1 + (ancho1  / 2);
		bottom1 = y1 - (altura1 / 2);
		top1    = y1 + (altura1 / 2);
		
		// Rectangulo 2
		left2   = x2 - (ancho2  / 2);
		right2  = x2 + (ancho2  / 2);
		bottom2 = y2 - (altura2 / 2);
		top2    = y2 + (altura2 / 2);
		
		if (left2 >= left1 && right2 <= right1 && bottom2 >= bottom1 && top2 <= top1)
		{
			System.out.println("El segundo rectangulo esta dentro del primero");
		}
		
		else if (right2 > left1 && left2 < right1 && top2 > bottom1 && bottom2 < top1)
		{
			System.out.println("El segundo rectangulo se traslapa con el primero");
		}
		
		else
		{
			System.out.println("El segundo rectangulo NO se traslapa con el primero :)");
		}
	}
}
