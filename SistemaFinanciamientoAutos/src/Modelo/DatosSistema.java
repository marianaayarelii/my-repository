package Modelo;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class DatosSistema 
{
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    
    public static void cargarClientes()
    {
    	try
    	{
    		BufferedReader lector = new BufferedReader(new FileReader("Clientess"));
    		String linea;
    		
    		while ((linea = lector.readLine()) != null)
    		{
    			String datos[] = linea.split(",");
    			
    			Cliente cliente = new Cliente(datos[0], datos[1], datos[2],Double.parseDouble(datos[3]), Integer.parseInt(datos[4]), datos[5]);
    			clientes.add(cliente);
    		}
    		lector.close();
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void guardarClientes()
    {
    	try
    	{
    		PrintWriter escritor = new PrintWriter(new FileWriter("Clientess"));
    		
    		for (Cliente c : clientes)
    		{
    			escritor.println(c.getNombre() + "," + c.getTelefono() + "," + c.getDireccion() + "," + c.getDeuda() + "," + c.getMesesRestantes() + "," + c.getFechaPago());
    		}
    		escritor.close();
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void cargarVehiculos()
    {
        try
        {
            BufferedReader lector =new BufferedReader(new FileReader("Vehiculoss"));

            String linea;

            while((linea = lector.readLine()) != null)
            {
                String datos[] = linea.split(",");

                Vehiculo vehiculo = new Vehiculo(datos[0],datos[1],Integer.parseInt(datos[2]), Double.parseDouble(datos[3]));

                vehiculos.add(vehiculo);
            }

            lector.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void guardarVehiculos()
    {
        try
        {
            PrintWriter escritor = new PrintWriter( new FileWriter("Vehiculoss"));

            for(Vehiculo v : vehiculos)
            {
                escritor.println(v.getMarca() + "," + v.getModelo() + "," + v.getanio() + "," + v.getPrecio()

                );
            }

            escritor.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
