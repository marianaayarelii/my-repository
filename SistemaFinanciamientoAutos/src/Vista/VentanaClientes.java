package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Modelo.Cliente;
import Modelo.DatosSistema;

import java.awt.*;
import java.time.LocalDate;

public class VentanaClientes extends JFrame 
{
	Font fuenteLabel = new Font("Segoe UI", Font.BOLD, 13);
	Font fuenteTxt = new Font("Segoe UI", Font.PLAIN, 14);
	
	JTextField txtNombre;
	JTextField txtTelefono;
	JTextField txtDireccion;
	JTextField txtDeuda;
	JTextField txtMesesRestantes;
	JTextField txtFechaPago;
	
	DefaultTableModel modelo;
	
	public VentanaClientes() 
	{
		setTitle("Gestión de Clientes");
		setSize(1150, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout(15, 15));
		
		//PANEL SUPERIOR (TÍTULO Y FORMULARIO)
		JPanel panelContenedorSuperior = new JPanel(new BorderLayout(10, 15));
		panelContenedorSuperior.setBackground(Color.WHITE);
		panelContenedorSuperior.setBorder(new EmptyBorder(15, 20, 10, 20));
		
		// Título Principal
		JLabel titulo = new JLabel("GESTIÓN DE CLIENTES", SwingConstants.LEFT);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
		titulo.setForeground(new Color(25, 118, 210)); // Azul Institucional
		panelContenedorSuperior.add(titulo, BorderLayout.NORTH);
		
		// Formulario de Datos (Grid de 2 columnas)
		JPanel panelFormulario = new JPanel(new GridLayout(3, 4, 15, 12));
		panelFormulario.setBackground(new Color(245, 247, 250)); // Gris azulado muy claro
		panelFormulario.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(220, 225, 230), 1),
				new EmptyBorder(15, 15, 15, 15)
		));
		
		// Estilo genérico para JTextFields
		javax.swing.border.Border campoBorde = BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
				BorderFactory.createEmptyBorder(5, 8, 5, 8)
		);

		// Campo: Nombre
		JLabel lblNombre = new JLabel("Nombre Completo:");
		lblNombre.setFont(fuenteLabel);
		panelFormulario.add(lblNombre);
		txtNombre = new JTextField();
		txtNombre.setFont(fuenteTxt);
		txtNombre.setBorder(campoBorde);
		panelFormulario.add(txtNombre);
		
		// Campo: Teléfono
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(fuenteLabel);
		panelFormulario.add(lblTelefono);
		txtTelefono = new JTextField();
		txtTelefono.setFont(fuenteTxt);
		txtTelefono.setBorder(campoBorde);
		panelFormulario.add(txtTelefono);
		
		// Campo: Dirección
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(fuenteLabel);
		panelFormulario.add(lblDireccion);
		txtDireccion = new JTextField();
		txtDireccion.setFont(fuenteTxt);
		txtDireccion.setBorder(campoBorde);
		panelFormulario.add(txtDireccion);
		
		// Campo: Deuda
		JLabel lblDeuda = new JLabel("Deuda ($):");
		lblDeuda.setFont(fuenteLabel);
		panelFormulario.add(lblDeuda);
		txtDeuda = new JTextField();
		txtDeuda.setFont(fuenteTxt);
		txtDeuda.setBorder(campoBorde);
		panelFormulario.add(txtDeuda);
		
		// Campo: Meses Restantes
		JLabel lblMeses = new JLabel("Meses Restantes:");
		lblMeses.setFont(fuenteLabel);
		panelFormulario.add(lblMeses);
		txtMesesRestantes = new JTextField();
		txtMesesRestantes.setFont(fuenteTxt);
		txtMesesRestantes.setBorder(campoBorde);
		panelFormulario.add(txtMesesRestantes);
		
		// Campo: Fecha de Pago
		JLabel lblFecha = new JLabel("Próxima Fecha Pago:");
		lblFecha.setFont(fuenteLabel);
		panelFormulario.add(lblFecha);
		txtFechaPago = new JTextField();
		txtFechaPago.setFont(fuenteTxt);
		txtFechaPago.setBorder(campoBorde);
		txtFechaPago.setText(LocalDate.now().plusMonths(1).toString());
		panelFormulario.add(txtFechaPago);
		
		panelContenedorSuperior.add(panelFormulario, BorderLayout.CENTER); //todo arriba
		
		// PANEL BOTONES (Abajo del formulario)
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
		panelBotones.setBackground(Color.WHITE);
		
		JButton btnAgregar = new JButton("Agregar Cliente");
		configurarBoton(btnAgregar, new Color(40, 167, 69)); // Verde
		panelBotones.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar Cliente");
		configurarBoton(btnEliminar, new Color(220, 53, 69)); // Rojo
		panelBotones.add(btnEliminar);
		
		JButton btnVolver = new JButton("Volver al Menú");
		configurarBoton(btnVolver, new Color(108, 117, 125)); // Gris
		panelBotones.add(btnVolver);
		
		panelContenedorSuperior.add(panelBotones, BorderLayout.SOUTH);
		add(panelContenedorSuperior, BorderLayout.NORTH);
		
		//CONFIGURACIÓN DE LA TABLA
		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Teléfono");
		modelo.addColumn("Dirección");     
		modelo.addColumn("Deuda");
		modelo.addColumn("Meses Restantes");
		modelo.addColumn("Fecha de Pago");
		modelo.addColumn("Estatus");
		
		JTable tabla = new JTable(modelo);
		tabla.setRowHeight(32); // Más alta para mejor lectura
		tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		tabla.setSelectionBackground(new Color(230, 242, 255));
		tabla.setSelectionForeground(Color.BLACK);
		
		// Encabezado de la Tabla
		tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
		tabla.getTableHeader().setBackground(new Color(25, 118, 210));
		tabla.getTableHeader().setForeground(Color.WHITE);
		tabla.getTableHeader().setPreferredSize(new Dimension(0, 35));
		tabla.setShowGrid(true);
		tabla.setGridColor(new Color(230, 230, 230));
		

		// Alinear texto de la tabla al centro
        DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(alinearCentro);
        }
        
        DefaultTableCellRenderer renderHeader = (DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer();
        renderHeader.setHorizontalAlignment(SwingConstants.CENTER);

		// Cargar Datos
		for(Cliente c : DatosSistema.clientes)
		{
		    modelo.addRow(new Object[] 
		    {
		    	c.getNombre(),
		        c.getTelefono(),
		        c.getDireccion(),
		        c.getDeuda(),
		        c.getMesesRestantes(),
		        c.getFechaPago(),
		        c.getEstatus()
		    });
		}
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		scrollPane.getViewport().setBackground(Color.WHITE);
		add(scrollPane, BorderLayout.CENTER);
		
		//LISTENERS -
		btnAgregar.addActionListener(e -> 
		{
			try 
			{
				Cliente nuevoCliente = new Cliente(	//para agregarlo al archivo
						txtNombre.getText(),
						txtTelefono.getText(),
						txtDireccion.getText(),
						Double.parseDouble(txtDeuda.getText()),
						Integer.parseInt(txtMesesRestantes.getText()),
						txtFechaPago.getText());
				
				DatosSistema.clientes.add(nuevoCliente);
				DatosSistema.guardarClientes();
				
				modelo.addRow(new Object[] {		//para agregarlo a la tabla
					nuevoCliente.getNombre(), 
					nuevoCliente.getTelefono(),
					nuevoCliente.getDireccion(),
					nuevoCliente.getDeuda(),
					nuevoCliente.getMesesRestantes(),
					nuevoCliente.getFechaPago(),
					nuevoCliente.getEstatus()
				});
													//limpia todo
	            txtNombre.setText("");
	            txtTelefono.setText("");
	            txtDireccion.setText("");
	            txtDeuda.setText("");
	            txtMesesRestantes.setText("");
	            txtFechaPago.setText(LocalDate.now().plusMonths(1).toString());
	            
	            JOptionPane.showMessageDialog(this, "Cliente agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Verifique los datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnEliminar.addActionListener(e -> {
			int fila = tabla.getSelectedRow();
			if(fila >= 0) {
            	int opcion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este Cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
            	if(opcion == JOptionPane.YES_OPTION) {
					DatosSistema.clientes.remove(fila);
					modelo.removeRow(fila);
					DatosSistema.guardarClientes();
					JOptionPane.showMessageDialog(this, "Cliente eliminado con éxito");
            	}
			} else {
				JOptionPane.showMessageDialog(this, "Por favor, seleccione un cliente de la tabla");
			}
		});
		
		btnVolver.addActionListener(e -> dispose());
		
		setVisible(true);
	}
	
	// Método auxiliar para estandarizar el diseño moderno de botones
	private void configurarBoton(JButton boton, Color colorFondo) {
		boton.setBackground(colorFondo);
		boton.setForeground(Color.WHITE);
		boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		boton.setFocusPainted(false);
		boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	}
}