package Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;

import Modelo.Cliente;
import Modelo.DatosSistema;

public class VentanaPagos extends JFrame
{
    Font fuenteLabel = new Font("Segoe UI", Font.BOLD, 13);
    Font fuenteTxt = new Font("Segoe UI", Font.PLAIN, 14);
    Font fuenteResultado = new Font("Segoe UI", Font.BOLD, 15);

    JTextField txtDeuda;
    JTextField txtPago;

    JLabel lblRestante;

    JComboBox<String> comboClientes;

    public VentanaPagos()
    {
        setTitle("Registro de Pagos");
        setSize(1150, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout(20, 20));
        
        // PANEL SUPERIOR (TÍTULO) 
        JPanel panelContenedorSuperior = new JPanel(new BorderLayout());
        panelContenedorSuperior.setBackground(Color.WHITE);
        panelContenedorSuperior.setBorder(new EmptyBorder(15, 20, 0, 20));

        JLabel titulo = new JLabel("REGISTRO DE PAGOS", SwingConstants.LEFT);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titulo.setForeground(new Color(25, 118, 210)); // Azul Institucional
        panelContenedorSuperior.add(titulo, BorderLayout.NORTH);
        add(panelContenedorSuperior, BorderLayout.NORTH);

        // PANEL CENTRAL DIVIDIDO (IZQUIERDA: CONTROL / DERECHA: SALDO) 
        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 25, 0));
        panelCentral.setBackground(Color.WHITE);
        panelCentral.setBorder(new EmptyBorder(10, 20, 20, 20));

        // Estilo común para componentes de entrada
        javax.swing.border.Border campoBorde = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        );

        // COLUMNA IZQUIERDA (FORMULARIO DE PAGO)
        JPanel panelIzquierdo = new JPanel(new BorderLayout(0, 15));
        panelIzquierdo.setBackground(Color.WHITE);

        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 10, 20));
        panelFormulario.setBackground(new Color(245, 247, 250)); // Gris azulado claro
        panelFormulario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1),
                new EmptyBorder(25, 20, 25, 20)
        ));

        // Combo de Clientes
        panelFormulario.add(new JLabel("Seleccionar Cliente:", JLabel.LEFT) {{ setFont(fuenteLabel); }});
        comboClientes = new JComboBox<>();
        comboClientes.setFont(fuenteTxt);
        comboClientes.setBackground(Color.WHITE);
        panelFormulario.add(comboClientes);

        // Deuda Actual
        panelFormulario.add(new JLabel("Deuda Actual:", JLabel.LEFT) {{ setFont(fuenteLabel); }});
        txtDeuda = new JTextField();
        txtDeuda.setFont(fuenteTxt);
        txtDeuda.setBorder(campoBorde);
        txtDeuda.setEditable(false);
        txtDeuda.setBackground(new Color(235, 238, 242)); // Tono gris de deshabilitado elegante
        panelFormulario.add(txtDeuda);

        // Pago Realizado
        panelFormulario.add(new JLabel("Monto a Pagar ($):", JLabel.LEFT) {{ setFont(fuenteLabel); }});
        txtPago = new JTextField();
        txtPago.setFont(fuenteTxt);
        txtPago.setBorder(campoBorde);
        panelFormulario.add(txtPago);

        panelIzquierdo.add(panelFormulario, BorderLayout.CENTER);

        // Panel de Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        panelBotones.setBackground(Color.WHITE);

        JButton btnRegistrar = new JButton("Registrar Pago");
        configurarBoton(btnRegistrar, new Color(40, 167, 69)); // Verde
        panelBotones.add(btnRegistrar);

        JButton btnVolver = new JButton("Volver al Menú");
        configurarBoton(btnVolver, new Color(108, 117, 125)); // Gris
        panelBotones.add(btnVolver);

        panelIzquierdo.add(panelBotones, BorderLayout.SOUTH);
        panelCentral.add(panelIzquierdo);

        //COLUMNA DERECHA (PANELES DE ESTADO/RESULTADO) 
        JPanel panelResultados = new JPanel(new GridBagLayout());
        panelResultados.setBackground(new Color(230, 242, 255)); // Fondo Azul claro institucional
        panelResultados.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 210, 245), 1),
                new EmptyBorder(25, 25, 25, 25)
        ));

        lblRestante = new JLabel("Saldo Restante: $0.00", SwingConstants.CENTER);
        lblRestante.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblRestante.setForeground(new Color(25, 118, 210)); // Azul destacado
        panelResultados.add(lblRestante);

        panelCentral.add(panelResultados);
        add(panelCentral, BorderLayout.CENTER);

        //CARGAR CLIENTES 
        for(Cliente c : DatosSistema.clientes)
        {
            comboClientes.addItem(c.getNombre());
        }

        // MOSTRAR DEUDA DEL PRIMER CLIENTE 
        if(DatosSistema.clientes.size() > 0)
        {
            Cliente cliente = DatosSistema.clientes.get(0);
            txtDeuda.setText(String.valueOf(cliente.getDeuda()));
            lblRestante.setText("Saldo Restante: $" + String.format("%.2f", cliente.getDeuda()));
        }

        // CAMBIO DE CLIENTE 
        comboClientes.addActionListener(e ->
        {
            int indice = comboClientes.getSelectedIndex();
            if(indice >= 0)
            {
                Cliente cliente = DatosSistema.clientes.get(indice);
                txtDeuda.setText(String.valueOf(cliente.getDeuda()));
                lblRestante.setText("Saldo Restante: $" + String.format("%.2f", cliente.getDeuda()));
            }
        });

        //btn registrar
        btnRegistrar.addActionListener(e -> 
        {
            try 
            {
                int index = comboClientes.getSelectedIndex();
                Cliente c = DatosSistema.clientes.get(index); //obtiene posicion
                double pago = Double.parseDouble(txtPago.getText()); //obtieney convierte a decimal

                double nuevaDeuda = c.getDeuda() - pago;
                
                if (nuevaDeuda <= 0)
                {
                    c.setDeuda(0);
                    c.setMesesRestantes(0);
                } else 
                {
                    c.setDeuda(nuevaDeuda);
                    if (c.getMesesRestantes() > 0) 
                    {
                        c.setMesesRestantes(c.getMesesRestantes() - 1);
                    }
                }
                
                // Avanzar un mes en la fecha de pago
                LocalDate fecha = LocalDate.parse(c.getFechaPago());
                fecha = fecha.plusMonths(1);
                c.setFechaPago(fecha.toString());
                
                // Guardar los cambios
                DatosSistema.guardarClientes();

                // Actualizar la interfaz de usuario
                txtDeuda.setText(String.valueOf(c.getDeuda()));
                lblRestante.setText("Saldo Restante: $" + String.format("%.2f", c.getDeuda()));
                txtPago.setText("");

                JOptionPane.showMessageDialog(this, "Pago registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            }
        });

        // VOLVER
        btnVolver.addActionListener(e ->
        {
            dispose();
        });

        setVisible(true);
    }

    // Método auxiliar unificado para el estilo de botones
    private void configurarBoton(JButton boton, Color colorFondo) {
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createEmptyBorder(10, 22, 10, 22));
    }
}