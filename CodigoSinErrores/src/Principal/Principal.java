package Principal;
import java.util.ArrayList;

public class Principal
{
    public static void main(String[] args)
    {
        // ArrayList lista = new ArrayList<String>();
        ArrayList<String> lista = new ArrayList<String>();
        //Error: se está usando ArrayList sin tipo (raw type)
        //Corrección: se debe especificar el tipo <String> en ambos lados

        lista.add("Uno");
        lista.add("Dos");
        lista.add("Tres");

        // System.out.println("Elemento en posición 3: " + lista.get(3));
        System.out.println("Elemento en posición 2: " + lista.get(2));
        // Error: el índice 3 no existe (solo hay posiciones 0,1,2)
        // Corrección: usar índice 2 para el tercer elemento

        // for (int i = 0; i <= lista.size(); i++) 
        for (int i = 0; i < lista.size(); i++) 
        {
            System.out.println(lista.get(i));
        }
        //  Error: <= provoca que i llegue a un índice inválido
        //  Corrección: usar < para no salir del rango

        lista.remove("Tres");
        // "Cuatro" no existe, entonces no elimina nada

        // System.out.println("Tamaño final: " + lista.length());
        System.out.println("Tamaño final: " + lista.size());
        // Error: ArrayList no usa length()
        // Corrección: usar size() para obtener el tamaño
    }
}