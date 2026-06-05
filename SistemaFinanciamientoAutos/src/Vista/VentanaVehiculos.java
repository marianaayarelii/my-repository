package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Modelo.Cliente;
import Modelo.Vehiculo;
import java.awt.*;
import java.util.ArrayList;
import Modelo.DatosSistema;

public class VentanaVehiculos extends JFrame {

    Font fuenteLabel = new Font("Segoe UI", Font.BOLD, 13);
    Font fuenteTxt = new Font("Segoe UI", Font.PLAIN, 14);

    JTextField txtMarca;
    JTextField txtModelo;
    JTextField txtAnio;
    JTextField txtPrecio;

    DefaultTableModel modeloTabla;

    public VentanaVehiculos() {

        setTitle("Gestión de Vehículos");
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
        JLabel titulo = new JLabel("GESTIÓN DE VEHÍCULOS", SwingConstants.LEFT);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titulo.setForeground(new Color(25, 118, 210)); // Azul Institucional
        panelContenedorSuperior.add(titulo, BorderLayout.NORTH);

        // Formulario de Datos (Grid de 2 columnas de datos funcionales adaptadas)
        JPanel panelFormulario = new JPanel(new GridLayout(2, 4, 15, 12));
        panelFormulario.setBackground(new Color(245, 247, 250)); // Gris azulado claro
        panelFormulario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1),
                new EmptyBorder(15, 15, 15, 15)
        ));

        // Estilo para JTextFields
        javax.swing.border.Border campoBorde = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        );

        // Campo: Marca
        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setFont(fuenteLabel);
        panelFormulario.add(lblMarca);
        txtMarca = new JTextField();
        txtMarca.setFont(fuenteTxt);
        txtMarca.setBorder(campoBorde);
        panelFormulario.add(txtMarca);

        // Campo: Modelo
        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setFont(fuenteLabel);
        panelFormulario.add(lblModelo);
        txtModelo = new JTextField();
        txtModelo.setFont(fuenteTxt);
        txtModelo.setBorder(campoBorde);
        panelFormulario.add(txtModelo);

        // Campo: Año
        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setFont(fuenteLabel);
        panelFormulario.add(lblAnio);
        txtAnio = new JTextField();
        txtAnio.setFont(fuenteTxt);
        txtAnio.setBorder(campoBorde);
        panelFormulario.add(txtAnio);

        // Campo: Precio
        JLabel lblPrecio = new JLabel("Precio ($):");
        lblPrecio.setFont(fuenteLabel);
        panelFormulario.add(lblPrecio);
        txtPrecio = new JTextField();
        txtPrecio.setFont(fuenteTxt);
        txtPrecio.setBorder(campoBorde);
        panelFormulario.add(txtPrecio);

        panelContenedorSuperior.add(panelFormulario, BorderLayout.CENTER);

        //PANEL BOTONES
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        panelBotones.setBackground(Color.WHITE);

        JButton btnAgregar = new JButton("Agregar Vehículo");
        configurarBoton(btnAgregar, new Color(40, 167, 69)); // Verde
        panelBotones.add(btnAgregar);

        JButton btnEliminar = new JButton("Eliminar Vehículo");
        configurarBoton(btnEliminar, new Color(220, 53, 69)); // Rojo
        panelBotones.add(btnEliminar);

        JButton btnVolver = new JButton("Volver al Menú");
        configurarBoton(btnVolver, new Color(108, 117, 125)); // Gris
        panelBotones.add(btnVolver);

        panelContenedorSuperior.add(panelBotones, BorderLayout.SOUTH);
        add(panelContenedorSuperior, BorderLayout.NORTH);

        //CONFIGURACIÓN DE LA TABLA
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("Año");
        modeloTabla.addColumn("Precio");

        JTable tabla = new JTable(modeloTabla);
        tabla.setRowHeight(32); // Altura de celda cómoda
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabla.setSelectionBackground(new Color(230, 242, 255));
        tabla.setSelectionForeground(Color.BLACK);

        // Encabezado
        tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tabla.getTableHeader().setBackground(new Color(25, 118, 210));
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.getTableHeader().setPreferredSize(new Dimension(0, 35));
        tabla.setShowGrid(true);
        tabla.setGridColor(new Color(230, 230, 230));

        // Centrar las celdas de la tabla
        DefaultTableCellRenderer t = new DefaultTableCellRenderer();
        t.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(t);
        }
        
        // Centrar los titulos de arriba
        DefaultTableCellRenderer h = (DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer();
        h.setHorizontalAlignment(SwingConstants.CENTER);

        // Carga de datos inicial
        for(Vehiculo v : DatosSistema.vehiculos)
        {
            modeloTabla.addRow(new Object[] 
            {
                v.getMarca(), v.getModelo(), v.getanio(), v.getPrecio() 
            });
        }
        
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        scrollPane.getViewport().setBackground(Color.WHITE);
        add(scrollPane, BorderLayout.CENTER);

        //LISTENERS
        btnAgregar.addActionListener(e -> 
        {
            try {
                modeloTabla.addRow(new Object[]
                {
                     txtMarca.getText(),
                     txtModelo.getText(),
                     txtAnio.getText(),
                     txtPrecio.getText()
                });
                
                Vehiculo nuevoVehiculo = new Vehiculo(txtMarca.getText(), txtModelo.getText(), Integer.parseInt(txtAnio.getText()), Double.parseDouble(txtPrecio.getText()));
                DatosSistema.vehiculos.add(nuevoVehiculo);
                DatosSistema.guardarVehiculos();
                
                JOptionPane.showMessageDialog(this, "Vehículo agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                txtMarca.setText("");
                txtModelo.setText("");
                txtAnio.setText("");
                txtPrecio.setText("");
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Año y precio deben ser numéricos", "Error de formato", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnEliminar.addActionListener(e -> 
        {
            int fila = tabla.getSelectedRow();
            if(fila >= 0) 
            {
                int opcion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este vehículo?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if(opcion == JOptionPane.YES_OPTION) 
                {
                    DatosSistema.vehiculos.remove(fila);
                    modeloTabla.removeRow(fila);
                    DatosSistema.guardarVehiculos();
                    JOptionPane.showMessageDialog(this, "Vehículo eliminado");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Seleccione un vehículo de la tabla", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        btnVolver.addActionListener(e -> 
        {
            dispose();
        });

        setVisible(true);
    }

    // Método auxiliar para estandarizar el diseño moderno de botones
    private void configurarBoton(JButton boton, Color colorFondo) 
    {
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }
}