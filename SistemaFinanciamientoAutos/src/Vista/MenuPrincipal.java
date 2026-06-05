package Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Modelo.DatosSistema;
import java.awt.*;
import Vista.VentanaClientes;
import Vista.VentanaVehiculos;
import Vista.VentanaFinanciamiento;
import Vista.VentanaPagos;

public class MenuPrincipal extends JFrame 
{
    public MenuPrincipal() 
    {
        // Cargar datos primero para reflejar números reales en los indicadores
        DatosSistema.cargarClientes();
        DatosSistema.cargarVehiculos();

        setTitle("Sistema de Gestión y Financiamiento - Espinoza Motors");
        setSize(1150, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);	//centra la ventana
        getContentPane().setBackground(Color.WHITE); //fondo
        setLayout(new BorderLayout(0, 20)); //norte,sur,este,oest,centro
        
        
        
        

        //1. PANEL SUPERIOR (ENCABEZADO)
        JPanel panelHeader = new JPanel(new BorderLayout());	//crea el contenedor del encabezado
        panelHeader.setBackground(new Color(25, 118, 210)); // Azul Corporativo Principal
        panelHeader.setBorder(new EmptyBorder(25, 30, 25, 30)); //margen interno

        JLabel titulo = new JLabel("ESPINOZA MOTORS", SwingConstants.LEFT);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28)); //grande y negritas
        titulo.setForeground(Color.WHITE); 

        JLabel subtitulo = new JLabel("Sistema Integral de Financiamiento Automotriz", SwingConstants.LEFT);
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitulo.setForeground(new Color(220, 235, 255));

        JPanel panelTextoHeader = new JPanel(new GridLayout(2, 1, 0, 5)); //DISTRIBUYE EN 2 FILAS TITULO Y SUB
        panelTextoHeader.setOpaque(false);	//el fondo se ve a traves del panel 
        panelTextoHeader.add(titulo);
        panelTextoHeader.add(subtitulo);

        panelHeader.add(panelTextoHeader, BorderLayout.WEST); //izquirda
        add(panelHeader, BorderLayout.NORTH); //finalmente metemos todo el encabezado en la zona superior
        
        
        
        

        //2. PANEL CENTRAL (INDICADORES + MENÚ DE ACCIONES)
        JPanel panelCentral = new JPanel(new BorderLayout(0, 30)); //contenedor del centro de la ventana
        panelCentral.setBackground(Color.WHITE);
        panelCentral.setBorder(new EmptyBorder(10, 40, 40, 40));

        //TARJETAS DE ESTADÍSTICAS 
        JPanel panelDashboard = new JPanel(new GridLayout(1, 3, 20, 0)); //3 tarjetas de estadisticas
        panelDashboard.setBackground(Color.WHITE);

        int numClientes = DatosSistema.clientes.size();		//extrae tamaño
        int numVehiculos = DatosSistema.vehiculos.size();
        
        // Tarjeta Clientes
        JPanel cardClientes = crearTarjetaIndicador("Clientes Activos", String.valueOf(numClientes), new Color(230, 242, 255), new Color(25, 118, 210));
        // Tarjeta Vehículos
        JPanel cardVehiculos = crearTarjetaIndicador("Catálogo de Vehículos", String.valueOf(numVehiculos), new Color(232, 245, 233), new Color(40, 167, 69));
        // Tarjeta Financiamientos/FILTRO PARA LOS QUE TIENEN UNA DEUDA MAYOR A CERO
        long numFinanciamientos = DatosSistema.clientes.stream().filter(c -> c.getDeuda() > 0).count();
        
        JPanel cardFinanzas = crearTarjetaIndicador("Financiamientos Vigentes", String.valueOf(numFinanciamientos), new Color(255, 243, 224), new Color(245, 124, 0));

        panelDashboard.add(cardClientes); //AÑADE LAS 3 TARJETAS 
        panelDashboard.add(cardVehiculos);
        panelDashboard.add(cardFinanzas);

        panelCentral.add(panelDashboard, BorderLayout.NORTH); //posiciona todo en el norte

        //SECCIÓN DE BOTONES DE ACCIÓN
        JPanel panelAcciones = new JPanel(new BorderLayout(0, 10)); //creacion del panel
        panelAcciones.setBackground(Color.WHITE);

        JLabel lblSeccion = new JLabel("MÓDULOS DEL SISTEMA"); 
        lblSeccion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblSeccion.setForeground(new Color(100, 110, 120));
        panelAcciones.add(lblSeccion, BorderLayout.NORTH);

        // Grid de botones (2 filas, 2 columnas)
        JPanel gridBotones = new JPanel(new GridLayout(2, 2, 20, 20));
        gridBotones.setBackground(Color.WHITE);

        JButton btnClientes = new JButton("Gestión de Clientes");
        configurarBotonMenu(btnClientes, new Color(25, 118, 210)); // Azul
        btnClientes.addActionListener(e -> new VentanaClientes()); //accion

        JButton btnVehiculos = new JButton("Control de Inventario");
        configurarBotonMenu(btnVehiculos, new Color(25, 118, 210)); // Azul
        btnVehiculos.addActionListener(e -> new VentanaVehiculos());//accion

        JButton btnFinanciamientos = new JButton("Cotizador de Financiamientos");
        configurarBotonMenu(btnFinanciamientos, new Color(25, 118, 210)); // Azul
        btnFinanciamientos.addActionListener(e -> new VentanaFinanciamiento());//accion

        JButton btnPagos = new JButton("Módulo de Caja y Pagos");
        configurarBotonMenu(btnPagos, new Color(40, 167, 69)); // Verde para destacar caja
        btnPagos.addActionListener(e -> new VentanaPagos());//accion

        gridBotones.add(btnClientes); //agrega todos los botones
        gridBotones.add(btnVehiculos);
        gridBotones.add(btnFinanciamientos);
        gridBotones.add(btnPagos);

        panelAcciones.add(gridBotones, BorderLayout.CENTER);
        panelCentral.add(panelAcciones, BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);

        setVisible(true);
    }
    
    
    
    
    
    

    // Método asistente para fabricar tarjetas de estadísticas visuales elegantes 
    private JPanel crearTarjetaIndicador(String titulo, String valor, Color fondo, Color colorTexto) 
    {
        JPanel tarjeta = new JPanel(new BorderLayout(0, 5));
        tarjeta.setBackground(fondo);
        tarjeta.setBorder(BorderFactory.createCompoundBorder
        (
                BorderFactory.createLineBorder(colorTexto.brighter(), 1),
                new EmptyBorder(15, 20, 15, 20)
        ));

        JLabel lblTitulo = new JLabel(titulo.toUpperCase());
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblTitulo.setForeground(colorTexto.darker());

        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblValor.setForeground(colorTexto);

        tarjeta.add(lblTitulo, BorderLayout.NORTH);
        tarjeta.add(lblValor, BorderLayout.CENTER);

        return tarjeta;
    }

    // Método asistente CORREGIDO para evitar la transparencia forzada del sistema 
    private void configurarBotonMenu(JButton boton, Color colorBase) {
        boton.setBackground(colorBase);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        
        //Forzar el pintado del fondo
        boton.setContentAreaFilled(true);
        boton.setOpaque(true);
        
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(colorBase.darker(), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        // Efecto sutil integrado al pasar el mouse
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(colorBase.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(colorBase);
            }
        });
    }

    public static void main(String[] args) 
    {
        
        new MenuPrincipal();
    }
}