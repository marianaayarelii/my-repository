package Principal;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<String> estudiantes = new ArrayList<String>();
		
		//Agregar 3 nombres 
		System.out.print("Nombre 1: ");
		estudiantes.add(sc.nextLine());  //LEE LO QUE ESCRIBES EN EL TECLADO EN FORMA STRING
		
		System.out.print("Nombre 2: ");
		estudiantes.add(sc.nextLine());  //LEE LO QUE ESCRIBES EN EL TECLADO EN FORMA STRING
		
		System.out.print("Nombre 3: ");
		estudiantes.add(sc.nextLine());  //LEE LO QUE ESCRIBES EN EL TECLADO EN FORMA STRING
		
		//Mostrar lista
		System.out.println("\n Lista de estudiantes: ");
		for (int i = 0; i < estudiantes.size(); i++)
		{
			System.out.println(estudiantes.get(i));
		}
		
		//Eliminar un estudiante
		System.out.println("\n Nombre del estudiante a eliminar;");
		String eliminar = sc.nextLine();
		estudiantes.remove(eliminar);
		
		//Verificar si existe
		System.out.println("\n Nombre a buscar: ");
		String buscar = sc.nextLine();
		
		if (estudiantes.contains(buscar))
		{
			System.out.println("Sí existe!");
		}
		else 
		{
			System.out.println("No existe :(");
		}
		
		sc.close();
	}
}
