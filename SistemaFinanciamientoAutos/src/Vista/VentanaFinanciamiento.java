package Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaFinanciamiento extends JFrame
{
    Font fuenteLabel = new Font("Segoe UI", Font.BOLD, 13);
    Font fuenteTxt = new Font("Segoe UI", Font.PLAIN, 14);
    Font fuenteResultado = new Font("Segoe UI", Font.BOLD, 14);

    JTextField txtPrecio;
    JTextField txtEnganche;
    JTextField txtMeses;

    JLabel lblSubtotal;
    JLabel lblImpuestos;
    JLabel lblInteres;
    JLabel lblTotal;
    JLabel lblFinanciado;
    JLabel lblMensualidad;

    JCheckBox chkSeguro;
    JCheckBox chkServicios;

    public VentanaFinanciamiento()
    {
        setTitle("Cálculo de Financiamiento");
        setSize(1150, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout(20, 20));

        // --- PANEL SUPERIOR (TÍTULO) ---
        JPanel panelContenedorSuperior = new JPanel(new BorderLayout());
        panelContenedorSuperior.setBackground(Color.WHITE);
        panelContenedorSuperior.setBorder(new EmptyBorder(15, 20, 0, 20));

        JLabel titulo = new JLabel("CÁLCULO DE FINANCIAMIENTO", SwingConstants.LEFT);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titulo.setForeground(new Color(25, 118, 210)); // Azul Institucional
        panelContenedorSuperior.add(titulo, BorderLayout.NORTH);
        add(panelContenedorSuperior, BorderLayout.NORTH);

        // PANEL CENTRAL DIVIDIDO (IZQUIERDA: DATOS | DERECHA: RESULTADOS) 
        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 25, 0));
        panelCentral.setBackground(Color.WHITE);
        panelCentral.setBorder(new EmptyBorder(10, 20, 20, 20));

        // Estilo común para los JTextFields
        javax.swing.border.Border campoBorde = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        );

        //BIENVENIDA / COLUMNA IZQUIERDA (FORMULARIO)
        JPanel panelIzquierdo = new JPanel(new BorderLayout(0, 15));
        panelIzquierdo.setBackground(Color.WHITE);

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 15));
        panelFormulario.setBackground(new Color(245, 247, 250));
        panelFormulario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1),
                new EmptyBorder(20, 20, 20, 20)
        ));

        panelFormulario.add(new JLabel("Precio del Vehículo:", JLabel.LEFT) {{ setFont(fuenteLabel); }});
        txtPrecio = new JTextField();
        txtPrecio.setFont(fuenteTxt);
        txtPrecio.setBorder(campoBorde);
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel("Enganche:", JLabel.LEFT) {{ setFont(fuenteLabel); }});
        txtEnganche = new JTextField();
        txtEnganche.setFont(fuenteTxt);
        txtEnganche.setBorder(campoBorde);
        panelFormulario.add(txtEnganche);

        panelFormulario.add(new JLabel("Número de meses:", JLabel.LEFT) {{ setFont(fuenteLabel); }});
        txtMeses = new JTextField();
        txtMeses.setFont(fuenteTxt);
        txtMeses.setBorder(campoBorde);
        panelFormulario.add(txtMeses);

        // Checkboxes integrados estéticamente
        chkSeguro = new JCheckBox("Seguro Básico ($8,000)");
        chkSeguro.setFont(fuenteLabel);
        chkSeguro.setBackground(new Color(245, 247, 250));
        panelFormulario.add(chkSeguro);

        chkServicios = new JCheckBox("Plan de Servicios ($5,000)");
        chkServicios.setFont(fuenteLabel);
        chkServicios.setBackground(new Color(245, 247, 250));
        panelFormulario.add(chkServicios);

        panelIzquierdo.add(panelFormulario, BorderLayout.CENTER);

        // Panel de Botones abajo del Formulario
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        panelBotones.setBackground(Color.WHITE);

        JButton btnCalcular = new JButton("Calcular Financiamiento");
        configurarBoton(btnCalcular, new Color(40, 167, 69)); // Verde
        panelBotones.add(btnCalcular);

        JButton btnVolver = new JButton("Volver al Menú");
        configurarBoton(btnVolver, new Color(108, 117, 125)); // Gris
        panelBotones.add(btnVolver);

        panelIzquierdo.add(panelBotones, BorderLayout.SOUTH);
        panelCentral.add(panelIzquierdo);

        //COLUMNA DERECHA (TARJETA DE RESULTADOS) 
        JPanel panelResultados = new JPanel(new GridLayout(6, 1, 10, 10));
        panelResultados.setBackground(new Color(230, 242, 255)); // Fondo Azul claro distintivo
        panelResultados.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 210, 245), 1),
                new EmptyBorder(25, 25, 25, 25)
        ));

        lblSubtotal = new JLabel("Subtotal: $0.00");
        lblSubtotal.setFont(fuenteResultado);
        panelResultados.add(lblSubtotal);

        lblImpuestos = new JLabel("Impuestos (5%): $0.00");
        lblImpuestos.setFont(fuenteResultado);
        panelResultados.add(lblImpuestos);

        lblInteres = new JLabel("Interés aplicado: $0.00");
        lblInteres.setFont(fuenteResultado);
        panelResultados.add(lblInteres);

        lblTotal = new JLabel("Total: $0.00");
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTotal.setForeground(new Color(25, 118, 210));
        panelResultados.add(lblTotal);

        lblFinanciado = new JLabel("Monto financiado: $0.00");
        lblFinanciado.setFont(fuenteResultado);
        panelResultados.add(lblFinanciado);

        // Destacar la mensualidad que es el dato más importante
        lblMensualidad = new JLabel("Mensualidad: $0.00");
        lblMensualidad.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblMensualidad.setForeground(new Color(220, 53, 69)); // Rojo para llamar la atención
        panelResultados.add(lblMensualidad);

        panelCentral.add(panelResultados);
        add(panelCentral, BorderLayout.CENTER);

        // LISTENERS 
        btnCalcular.addActionListener(e ->
        {
            try {
                double precio = Double.parseDouble(txtPrecio.getText());
                double enganche = Double.parseDouble(txtEnganche.getText());
                int meses = Integer.parseInt(txtMeses.getText());
                double subtotal = precio;

                if(chkSeguro.isSelected())
                {
                    subtotal += 8000;
                }

                if(chkServicios.isSelected())
                {
                    subtotal += 5000;
                }

                double impuestos = precio * 0.05;
                double total = subtotal + impuestos;
                double porcentajeInteres;

                if(meses <= 12)
                {
                    porcentajeInteres = 0.05;
                }
                else if(meses <= 24 && meses > 12) 
                {
                    porcentajeInteres = 0.10;
                }
                else if(meses <= 36 && meses > 24)
                {
                    porcentajeInteres = 0.15;
                }
                else if(meses <= 48 && meses > 36)
                {
                    porcentajeInteres = 0.20;
                }
                else
                {
                    porcentajeInteres = 0.25;
                }

                double interes = total * porcentajeInteres;
                total += interes;

                double financiado = total - enganche;
                double mensualidad =  financiado / meses;

                lblSubtotal.setText("Subtotal: $" + String.format("%.2f", subtotal));
                lblImpuestos.setText("Impuestos: $" + String.format("%.2f", impuestos));
                lblInteres.setText("Interés: $" + String.format("%.2f", interes));
                lblTotal.setText("Total: $" + String.format("%.2f", total));
                lblFinanciado.setText("Monto financiado: $" + String.format("%.2f", financiado));
                lblMensualidad.setText("Mensualidad: $" + String.format("%.2f", mensualidad));

            } catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(this, "Por favor verifique que los campos numéricos sean correctos", "Error de Datos", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnVolver.addActionListener(e -> 
        {
            dispose();
        });

        setVisible(true);
    }

    // Método auxiliar unificado para el estilo de botones
    private void configurarBoton(JButton boton, Color colorFondo) 
    {
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createEmptyBorder(10, 22, 10, 22));
    }
}