package Principal;
import java.util.Scanner;
import java.util.ArrayList;
public class Principal 
{
	public static void main(String[] args)
	{
		ArrayList<Integer> numeros = new ArrayList<>();
		for(int i = 1; i<=10; i++)
		{
			numeros.add(i);
		}
		numeros.set(4, 100); //cambia el valor del índice 4 por 100
		numeros.remove(2);   //elimina el número de la posición 2 
		
		for (int j = 0; j<numeros.size(); j++)
		{
			System.out.println(numeros.get(j));
		}
	}

}
