package Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> productos = new ArrayList<String>();

        //Agregar productos
        System.out.print("Producto 1: ");
        productos.add(sc.nextLine());

        System.out.print("Producto 2: ");
        productos.add(sc.nextLine());

        System.out.print("Producto 3: ");
        productos.add(sc.nextLine());

        //Mostrar lista
        System.out.println("\nLista de productos:");
        for (int i = 0; i < productos.size(); i++) 
        {
            System.out.println(productos.get(i));
        }

        //Eliminar producto
        System.out.print("\nProducto a eliminar: ");
        String eliminar = sc.nextLine();
        productos.remove(eliminar);

        //Ordenar lista
        Collections.sort(productos); //Collections.sort(); MUESTRA LA LISTA ORDENADA

        //Mostrar lista ordenada
        System.out.println("\nLista ordenada:");
        for (int i = 0; i < productos.size(); i++)
        {
            System.out.println(productos.get(i));
        }

        // Mostrar cantidad
        System.out.println("\nCantidad de productos: " + productos.size());

        sc.close();
    }
}