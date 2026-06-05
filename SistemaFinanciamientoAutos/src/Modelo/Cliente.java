package Modelo;
import java.time.LocalDate;

public class Cliente 
{
	private String nombre;  //Solo la clase cliente puede acceder a estas variables
	private String telefono;
	private String direccion;
	private Double deuda;
	private int mesesRestantes;
	private String fechapago;
	
	public Cliente (String nombre, String telefono, String direccion, double deuda, int mesesRestantes, String fechapago)  //CONSTRUCTOR
	{
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.deuda = deuda;
		this.mesesRestantes = mesesRestantes;
		this.fechapago = fechapago;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	public String getTelefono()
	{
		return telefono;
	}
	public String getDireccion()
	{
		return direccion;
	}
	public Double getDeuda()
	{
		return deuda;
	}
	public int getMesesRestantes()
	{
		return mesesRestantes;
	}
	public String getFechaPago()
	{
		return fechapago;
	}
	
	public void setDeuda(double deuda)
	{
	    this.deuda = deuda;
	}
	
	public String getEstatus()
	{
		if(deuda <= 0)
		{
			return "Liquidado";
		}
		LocalDate hoy = LocalDate.now();
		LocalDate pago = LocalDate.parse(fechapago);
		
		if (hoy.isAfter(pago))
		{
			return "Atrasado";
		}
		
		else 
			return "Al corriente";
	}
	
	public void setFechaPago(String fechapago)
	{
		this.fechapago = fechapago;
	}
	
	public void setMesesRestantes(int mesesRestantes)
	{
		this.mesesRestantes = mesesRestantes;
	}
}
