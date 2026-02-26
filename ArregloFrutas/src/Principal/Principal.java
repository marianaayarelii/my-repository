package Principal;
import java.util.ArrayList;
public class Principal
{
    public static void main (String[] args)
    {
        ArrayList<String> frutas = new ArrayList<String>();

        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Platano");
        frutas.add("Uva");
        frutas.add("Fresa");

        // Imprimir tamaño
        System.out.println("Cantidad de frutas: " + frutas.size());

        // For tradicional
        for(int i = 0; i < frutas.size(); i++)
        {
            System.out.println(frutas.get(i));
        }
    }
}