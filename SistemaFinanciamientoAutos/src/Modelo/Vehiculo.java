package Modelo;

public class Vehiculo
{
	private String marca;
	private String modelo;
	private int anio;
	private double precio;
	
	public Vehiculo(String marca, String modelo, int anio, double precio)
	{
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.precio = precio;
	}
	
	public String getMarca()
	{
		return marca;
	}
	public String getModelo()
	{
		return modelo;
	}
	public int getanio()
	{
		return anio;
	}
	public double getPrecio()
	{
		return precio;
	}
}
