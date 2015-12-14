package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EditorTXT extends JFrame {

	/**
	 * Create the frame
	 */
	public EditorTXT() {
		
		// Ventana principal	
		setMinimumSize(new Dimension(640, 110));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 515);
		getContentPane().setLayout(new BorderLayout(0, 0));

		//Redimensionar las imágenes de los iconos si es necesario
		//		Image img = icon.getImage() ;  
		//		Image newimg = img.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH ) ;  
		//		icon = new ImageIcon( newimg );

		// Contenedor norte - Panel de herramientas
		JPanel herramientas = new JPanel();
		herramientas.setMinimumSize(new Dimension(640, 32));
		herramientas.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(herramientas, BorderLayout.NORTH);
		GridLayout gl_herramientas = new GridLayout(1,0);
		herramientas.setLayout(gl_herramientas);

		// Barra de herramientas
		
		JToolBar toolbar = new JToolBar();
		toolbar.setMinimumSize(new Dimension(640, 32));
		toolbar.setFloatable(false);
		toolbar.setBorder(new EmptyBorder(2, 2, 2, 2));
		toolbar.setMargin(new Insets(2, 2, 2, 2));
		herramientas.add(toolbar);

		JButton btnNuevoArchivo = new JButton("");
		btnNuevoArchivo.setPreferredSize(new Dimension(26, 26));
		btnNuevoArchivo.setMinimumSize(new Dimension(16, 16));
		btnNuevoArchivo.setMaximumSize(new Dimension(32, 32));
		btnNuevoArchivo.setBorderPainted(false);
		btnNuevoArchivo.setToolTipText("Nuevo archivo");
		btnNuevoArchivo.setOpaque(false);
		btnNuevoArchivo.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/newfile16.png")));
		toolbar.add(btnNuevoArchivo);

		JButton btnAbrirArchivo = new JButton("");
		btnAbrirArchivo.setPreferredSize(new Dimension(26, 26));
		btnAbrirArchivo.setMinimumSize(new Dimension(16, 16));
		btnAbrirArchivo.setMaximumSize(new Dimension(32, 32));
		btnAbrirArchivo.setBorderPainted(false);
		btnAbrirArchivo.setToolTipText("Abrir archivo...");
		btnAbrirArchivo.setOpaque(false);
		btnAbrirArchivo.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/openfile16.png")));
		toolbar.add(btnAbrirArchivo);

		JButton btnGuardarArchivo = new JButton("");
		btnGuardarArchivo.setPreferredSize(new Dimension(26, 26));
		btnGuardarArchivo.setMinimumSize(new Dimension(16, 16));
		btnGuardarArchivo.setMaximumSize(new Dimension(32, 32));
		btnGuardarArchivo.setBorderPainted(false);
		toolbar.add(btnGuardarArchivo);
		btnGuardarArchivo.setOpaque(false);
		btnGuardarArchivo.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/save16.png")));
		btnGuardarArchivo.setToolTipText("Guardar archivo");

		JButton btnImprimir = new JButton("");
		btnImprimir.setPreferredSize(new Dimension(24, 24));
		btnImprimir.setMinimumSize(new Dimension(16, 16));
		btnImprimir.setMaximumSize(new Dimension(32, 32));
		btnImprimir.setBorderPainted(false);
		btnImprimir.setToolTipText("Imprimir...");
		btnImprimir.setOpaque(false);
		btnImprimir.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/printer16.png")));
		toolbar.add(btnImprimir);

		JSeparator separator = new JSeparator();
		// Evita que el separador se extienda en la ventana (tamaño fijo)
		separator.setMinimumSize(new Dimension(3, 15));
		separator.setPreferredSize(new Dimension(3, 15));
		separator.setMaximumSize(new Dimension(3, 15));
		separator.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator);

		JButton btnCortar = new JButton("");
		btnCortar.setPreferredSize(new Dimension(26, 26));
		btnCortar.setMinimumSize(new Dimension(16, 16));
		btnCortar.setMaximumSize(new Dimension(32, 32));
		btnCortar.setBorderPainted(false);
		btnCortar.setToolTipText("Cortar");
		btnCortar.setOpaque(false);
		btnCortar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/cut16.png")));
		toolbar.add(btnCortar);

		JButton btnCopiar = new JButton("");
		btnCopiar.setPreferredSize(new Dimension(26, 26));
		btnCopiar.setMinimumSize(new Dimension(16, 16));
		btnCopiar.setMaximumSize(new Dimension(32, 32));
		btnCopiar.setBorderPainted(false);
		btnCopiar.setOpaque(false);
		btnCopiar.setToolTipText("Copiar");
		btnCopiar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/copy16.png")));
		toolbar.add(btnCopiar);

		JButton btnPegar = new JButton("");
		btnPegar.setPreferredSize(new Dimension(26, 26));
		btnPegar.setMinimumSize(new Dimension(16, 16));
		btnPegar.setMaximumSize(new Dimension(32, 32));
		btnPegar.setOpaque(false);
		btnPegar.setBorderPainted(false);
		btnPegar.setToolTipText("Pegar");
		btnPegar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/paste16.png")));
		toolbar.add(btnPegar);

		JSeparator separator_1 = new JSeparator();
		// Evita que el separador se extienda en la ventana (tamaño fijo)
		separator_1.setMinimumSize(new Dimension(3, 15));
		separator_1.setPreferredSize(new Dimension(3, 15));
		separator_1.setMaximumSize(new Dimension(3, 15));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator_1);

		JButton btnDeshacer = new JButton("");
		btnDeshacer.setPreferredSize(new Dimension(26, 26));
		btnDeshacer.setMinimumSize(new Dimension(16, 16));
		btnDeshacer.setMaximumSize(new Dimension(32, 32));
		btnDeshacer.setOpaque(false);
		btnDeshacer.setBorderPainted(false);
		btnDeshacer.setToolTipText("Deshacer");
		btnDeshacer.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/undone16.png")));
		toolbar.add(btnDeshacer);

		JButton btnRehacer = new JButton("");
		btnRehacer.setPreferredSize(new Dimension(26, 26));
		btnRehacer.setMinimumSize(new Dimension(16, 16));
		btnRehacer.setMaximumSize(new Dimension(32, 32));
		btnRehacer.setOpaque(false);
		btnRehacer.setBorderPainted(false);
		btnRehacer.setToolTipText("Rehacer");
		btnRehacer.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/redone16.png")));
		toolbar.add(btnRehacer);

		JSeparator separator_2 = new JSeparator();
		// Evita que el separador se extienda en la ventana (tamaño fijo)
		separator_2.setMinimumSize(new Dimension(3, 15));
		separator_2.setPreferredSize(new Dimension(3, 15));
		separator_2.setMaximumSize(new Dimension(3, 15));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator_2);

		JButton btnBuscar = new JButton("");
		btnBuscar.setPreferredSize(new Dimension(26, 26));
		btnBuscar.setMinimumSize(new Dimension(16, 16));
		btnBuscar.setMaximumSize(new Dimension(32, 32));
		btnBuscar.setOpaque(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setToolTipText("Buscar...");
		btnBuscar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/buscar16.png")));
		toolbar.add(btnBuscar);

		JButton btnReemplazar = new JButton("");
		btnReemplazar.setPreferredSize(new Dimension(26, 26));
		btnReemplazar.setMinimumSize(new Dimension(16, 16));
		btnReemplazar.setMaximumSize(new Dimension(32, 32));
		btnReemplazar.setOpaque(false);
		btnReemplazar.setBorderPainted(false);
		btnReemplazar.setToolTipText("Reemplazar...");
		btnReemplazar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/Text_replace16.png")));
		toolbar.add(btnReemplazar);

		JSeparator separator_3 = new JSeparator();
		// Evita que el separador se extienda en la ventana (tamaño fijo)
		separator_3.setPreferredSize(new Dimension(3, 15));
		separator_3.setMinimumSize(new Dimension(3, 15));
		separator_3.setMaximumSize(new Dimension(3, 15));
		separator_3.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator_3);

		JSeparator spacer = new JSeparator();
		spacer.setPreferredSize(new Dimension(2, 0));
		spacer.setMinimumSize(new Dimension(2, 0));
		spacer.setMaximumSize(new Dimension(2, 0));
		toolbar.add(spacer);

		JComboBox<String> cmbFuente = new JComboBox<String>();
		cmbFuente.setMinimumSize(new Dimension(32, 22));
		cmbFuente.setMaximumSize(new Dimension(50, 30));
		toolbar.add(cmbFuente);
		cmbFuente.setModel(new DefaultComboBoxModel<String>(new String[] { "Arial", "Tahoma", "Times New Roman" }));
		cmbFuente.setToolTipText("Fuente");

		JSeparator spacer_1 = new JSeparator();
		spacer_1.setMinimumSize(new Dimension(3, 0));
		spacer_1.setMaximumSize(new Dimension(3, 0));
		spacer_1.setPreferredSize(new Dimension(3, 0));
		toolbar.add(spacer_1);

		JComboBox<String> cmbSize = new JComboBox<String>();
		cmbSize.setMinimumSize(new Dimension(30, 22));
		cmbSize.setMaximumSize(new Dimension(38, 30));
		toolbar.add(cmbSize);
		cmbSize.setModel(
				new DefaultComboBoxModel<String>(new String[] { "8", "9", "10", "11", "12", "13", "14", "inf" }));
		cmbSize.setToolTipText("Tama\u00F1o de fuente");

		JSeparator spacer_2 = new JSeparator();
		// Evita que el separador se extienda en la ventana (tamaño fijo)
		spacer_2.setMinimumSize(new Dimension(2, 0));
		spacer_2.setMaximumSize(new Dimension(2, 0));
		spacer_2.setPreferredSize(new Dimension(2, 0));
		toolbar.add(spacer_2);

		JButton btnLessSize = new JButton("");
		btnLessSize.setPreferredSize(new Dimension(26, 26));
		btnLessSize.setMinimumSize(new Dimension(16, 16));
		btnLessSize.setMaximumSize(new Dimension(32, 32));
		btnLessSize.setOpaque(false);
		btnLessSize.setBorderPainted(false);
		toolbar.add(btnLessSize);
		btnLessSize.setToolTipText("Disminuir tama\u00F1o de fuente");
		btnLessSize.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/smlA16.png")));

		JButton btnMoreSize = new JButton("");
		btnMoreSize.setPreferredSize(new Dimension(26, 26));
		btnMoreSize.setMinimumSize(new Dimension(16, 16));
		btnMoreSize.setMaximumSize(new Dimension(32, 32));
		btnMoreSize.setOpaque(false);
		btnMoreSize.setBorderPainted(false);
		toolbar.add(btnMoreSize);
		btnMoreSize.setToolTipText("Aumentar tama\u00F1o de fuente");
		btnMoreSize.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/bigA16.png")));

		JButton btnTextColor = new JButton("");
		btnTextColor.setPreferredSize(new Dimension(26, 26));
		btnTextColor.setMinimumSize(new Dimension(16, 16));
		btnTextColor.setMaximumSize(new Dimension(32, 32));
		btnTextColor.setOpaque(false);
		btnTextColor.setBorderPainted(false);
		toolbar.add(btnTextColor);
		btnTextColor.setToolTipText("Color de texto");
		btnTextColor.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/textcolor16.png")));

		JSeparator separator_4 = new JSeparator();
		// Evita que el separador se extienda en la ventana (tamaño fijo)
		separator_4.setMinimumSize(new Dimension(3, 15));
		separator_4.setPreferredSize(new Dimension(3, 15));
		separator_4.setMaximumSize(new Dimension(3, 15));
		separator_4.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator_4);

		JToggleButton btnBold = new JToggleButton("");
		btnBold.setPreferredSize(new Dimension(26, 26));
		btnBold.setMinimumSize(new Dimension(16, 16));
		btnBold.setMaximumSize(new Dimension(32, 32));
		btnBold.setOpaque(false);
		btnBold.setBorderPainted(false);
		btnBold.setToolTipText("Negrita");
		btnBold.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/b16.png")));
		toolbar.add(btnBold);

		JToggleButton btnCursive = new JToggleButton("");
		btnCursive.setPreferredSize(new Dimension(26, 26));
		btnCursive.setMinimumSize(new Dimension(16, 16));
		btnCursive.setMaximumSize(new Dimension(32, 32));
		btnCursive.setOpaque(false);
		btnCursive.setBorderPainted(false);
		btnCursive.setToolTipText("Cursiva");
		btnCursive.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/i16.png")));
		toolbar.add(btnCursive);

		JToggleButton btnUnderline = new JToggleButton("");
		btnUnderline.setPreferredSize(new Dimension(26, 26));
		btnUnderline.setMinimumSize(new Dimension(16, 16));
		btnUnderline.setMaximumSize(new Dimension(32, 32));
		btnUnderline.setOpaque(false);
		btnUnderline.setBorderPainted(false);
		btnUnderline.setToolTipText("Subrayado");
		btnUnderline.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/u16.png")));
		toolbar.add(btnUnderline);
		
		JSeparator spacer_3 = new JSeparator();
		spacer_3.setMinimumSize(new Dimension(0, 0));
		spacer_3.setMaximumSize(new Dimension(32767, 0));
		toolbar.add(spacer_3);

		// FUNCIONES NO IMPLEMENTADAS EN ESTA VERSIÓN
		
		/*
		JSeparator separator_5 = new JSeparator();
		// Evita que el separador se extienda en la ventana (tamaño fijo)
		separator_5.setMaximumSize(new Dimension(10, 15));
		separator_5.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator_5);

		JButton btnLeftAlign = new JButton("");
		btnLeftAlign.setOpaque(false);
		btnLeftAlign.setBorderPainted(false);
		btnLeftAlign.setToolTipText("Alinear a la izquierda");
		btnLeftAlign.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/left16.png")));
		toolbar.add(btnLeftAlign);

		JButton btnRightAlign = new JButton("");
		btnRightAlign.setOpaque(false);
		btnRightAlign.setBorderPainted(false);
		btnRightAlign.setToolTipText("Alinear al centro");
		btnRightAlign.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/center16.png")));
		toolbar.add(btnRightAlign);

		JButton btnCenterAlign = new JButton("");
		btnCenterAlign.setOpaque(false);
		btnCenterAlign.setBorderPainted(false);
		btnCenterAlign.setToolTipText("Alinear a la derecha");
		btnCenterAlign.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/right16.png")));
		toolbar.add(btnCenterAlign);

		JButton btnJustify = new JButton("");
		btnJustify.setOpaque(false);
		btnJustify.setBorderPainted(false);
		toolbar.add(btnJustify);
		btnJustify.setVerticalAlignment(SwingConstants.BOTTOM);
		btnJustify.setToolTipText("Justificar");
		btnJustify.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/just16.png")));
		 */

		// Contenedor central - Editor
		
		JPanel editor = new JPanel();
		editor.setBorder(new MatteBorder(1, 0, 1, 0, (Color) SystemColor.controlShadow));
		getContentPane().add(editor, BorderLayout.CENTER);
		editor.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		editor.add(scrollPane, BorderLayout.CENTER);
		
		/**
		 * Anhadimos los estilos al crear el textPane
		 */
		JTextPane editorPane = new JTextPane();
		editor.add(editorPane);
	    editorPane.addStyle("Default", null);
	    editorPane.addStyle("Italic", null);
	    editorPane.addStyle("Bold", null);
	    editorPane.addStyle("Underline",null);
	    editorPane.addStyle("Font",null);
	    
	 // Contenedor sur - Barra de estado
	    
		Panel estado = new Panel();
		getContentPane().add(estado, BorderLayout.SOUTH);
		estado.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel totales = new JPanel();
		totales.setFocusable(false);
		FlowLayout fl_totales = (FlowLayout) totales.getLayout();
		fl_totales.setAlignment(FlowLayout.LEFT);
		estado.add(totales);

		JLabel lblLength = new JLabel("N\u00BA de letras : 0");
		lblLength.setEnabled(false);
		lblLength.setFocusable(false);
		totales.add(lblLength);
		lblLength.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel = new JLabel("L\u00EDneas : 0");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFocusable(false);
		totales.add(lblNewLabel);

		JPanel posicion = new JPanel();
		posicion.getLayout();
		posicion.setFocusable(false);
		posicion.setBorder(new MatteBorder(0, 1, 0, 1, (Color) SystemColor.controlShadow));
		estado.add(posicion);

		JLabel lblLnea = new JLabel("L\u00EDnea : 0");
		lblLnea.setEnabled(false);
		lblLnea.setFocusable(false);
		posicion.add(lblLnea);

		JLabel lblColumna = new JLabel("Columna : 0");
		lblColumna.setEnabled(false);
		lblColumna.setFocusable(false);
		posicion.add(lblColumna);

		JPanel codificacion = new JPanel();
		codificacion.setFocusable(false);
		FlowLayout fl_codificacion = (FlowLayout) codificacion.getLayout();
		fl_codificacion.setHgap(3);
		fl_codificacion.setVgap(3);
		fl_codificacion.setAlignment(FlowLayout.RIGHT);
		estado.add(codificacion);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 10));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"UTF-8"}));
		codificacion.add(comboBox);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAlchivo = new JMenu("Archivo");
		menuBar.add(mnAlchivo);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/newfile16.png")));
		mnAlchivo.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		
		mntmAbrir.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent ae) {
				 String aux="";   
				  String texto="";
				  try
				  {
				   /**llamamos el metodo que permite cargar la ventana*/
				   JFileChooser file=new JFileChooser();
				   file.showOpenDialog(null);
				   
				   /**abrimos el archivo seleccionado*/
				   File abre=file.getSelectedFile();
				 
				   /**recorremos el archivo, lo leemos para plasmarlo
				   *en el area de texto*/
				   if(abre!=null)
				   {     
				      FileReader archivos=new FileReader(abre);
				      BufferedReader lee=new BufferedReader(archivos);
				      while((aux=lee.readLine())!=null)
				      {
				         texto+= aux+ "\n";
				      }
				         lee.close();
				         editorPane.setText(texto);
				         
				    }    
				   }
				   catch(IOException ex)
				   {
				     JOptionPane.showMessageDialog(null,ex+"" +
				           "\nNo se ha encontrado el archivo",
				                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
				    }
		    }
		
		});
		
		
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAbrir.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/openfile16.png")));
		mnAlchivo.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmGuardar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/save16.png")));
		mnAlchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mnAlchivo.add(mntmGuardarComo);

		JSeparator separator_7 = new JSeparator();
		mnAlchivo.add(separator_7);

		JMenuItem mntmImprimir = new JMenuItem("Imprimir...");
		mntmImprimir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmImprimir.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/printer16.png")));
		mnAlchivo.add(mntmImprimir);

		JSeparator separator_8 = new JSeparator();
		mnAlchivo.add(separator_8);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnAlchivo.add(mntmSalir);

		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);

		JMenuItem mntmDeshacer = new JMenuItem("Deshacer");
		mntmDeshacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mntmDeshacer.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/undone16.png")));
		mnEditar.add(mntmDeshacer);

		JMenuItem mntmRehacer = new JMenuItem("Rehacer");
		mntmRehacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		mntmRehacer.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/redone16.png")));
		mnEditar.add(mntmRehacer);

		JSeparator separator_9 = new JSeparator();
		mnEditar.add(separator_9);

		JMenuItem mntmCortar = new JMenuItem("Cortar");
		mntmCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mntmCortar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/cut16.png")));
		mnEditar.add(mntmCortar);

		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mntmCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmCopiar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/copy16.png")));
		mnEditar.add(mntmCopiar);

		JMenuItem mntmPegar = new JMenuItem("Pegar");
		mntmPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mntmPegar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/paste16.png")));
		mnEditar.add(mntmPegar);

		JSeparator separator_10 = new JSeparator();
		mnEditar.add(separator_10);

		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mntmBuscar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/buscar16.png")));
		mnEditar.add(mntmBuscar);

		JMenuItem mntmReemplazar = new JMenuItem("Reemplazar");
		mntmReemplazar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mntmReemplazar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/Text_replace16.png")));
		mnEditar.add(mntmReemplazar);

		JSeparator separator_11 = new JSeparator();
		mnEditar.add(separator_11);

		JMenuItem mntmSeleccionarTodo = new JMenuItem("Seleccionar todo");
		mntmSeleccionarTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnEditar.add(mntmSeleccionarTodo);

		JMenu mnFormato = new JMenu("Formato");
		menuBar.add(mnFormato);

		JMenuItem mntmFuente = new JMenuItem("Fuente...");
		mnFormato.add(mntmFuente);

		JSeparator separator_13 = new JSeparator();
		mnFormato.add(separator_13);

		/*
		JMenuItem mntmAlinearALa = new JMenuItem("Alinear a la izquierda");
		mntmAlinearALa.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/left16.png")));
		mnFormato.add(mntmAlinearALa);

		JMenuItem mntmAlinearAlCentro = new JMenuItem("Alinear al centro");
		mntmAlinearAlCentro.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/center16.png")));
		mnFormato.add(mntmAlinearAlCentro);

		JMenuItem mntmAlinearALa_1 = new JMenuItem("Alinear a la derecha");
		mntmAlinearALa_1.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/right16.png")));
		mnFormato.add(mntmAlinearALa_1);

		JMenuItem mntmJustificar = new JMenuItem("Justificar");
		mntmJustificar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/just16.png")));
		mnFormato.add(mntmJustificar);

		JSeparator separator_14 = new JSeparator();
		mnFormato.add(separator_14);
		 */

		//jajue

		JMenuItem mntmNegrita = new JMenuItem("Negrita");
		mntmNegrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mntmNegrita.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/b16.png")));
		mnFormato.add(mntmNegrita);

		JMenuItem mntmCursiva = new JMenuItem("Cursiva");
		mntmCursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mntmCursiva.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/i16.png")));
		mnFormato.add(mntmCursiva);

		JMenuItem mntmSubrayado = new JMenuItem("Subrayado");
		mntmSubrayado.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
		mntmSubrayado.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/u16.png")));
		mnFormato.add(mntmSubrayado);

		JMenu mnVer = new JMenu("Ver");
		menuBar.add(mnVer);

		JCheckBoxMenuItem chckbxmntmVerBarraDe = new JCheckBoxMenuItem("Ver Barra de herramientas");
		chckbxmntmVerBarraDe.setSelected(true);
		mnVer.add(chckbxmntmVerBarraDe);

		JCheckBoxMenuItem chckbxmntmVerBarraDe_1 = new JCheckBoxMenuItem("Ver barra de estado");
		chckbxmntmVerBarraDe_1.setSelected(true);
		mnVer.add(chckbxmntmVerBarraDe_1);

		JSeparator separator_12 = new JSeparator();
		mnVer.add(separator_12);

		JCheckBoxMenuItem chckbxmntmAjusteDeLnea = new JCheckBoxMenuItem("Ajuste de l\u00EDnea");
		mnVer.add(chckbxmntmAjusteDeLnea);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenuItem mntmContenidos = new JMenuItem("Contenidos");
		mntmContenidos.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/help16.png")));
		mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAyuda.add(mntmContenidos);

		JSeparator separator_15 = new JSeparator();
		mnAyuda.add(separator_15);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);

		/**
		 * Damos funcionalidad a la cursiva
		 * 
		 * */

		//Cuando clicas en la foto de cursiva...

		btnCursive.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				int[] indices = indicesSeleccion(editorPane.getSelectionStart(),editorPane.getSelectionEnd());			    
				StyledDocument doc = editorPane.getStyledDocument();
				Element element = doc.getCharacterElement(indices[0]);
				AttributeSet as = element.getAttributes();    
				Style style = editorPane.getStyle("Italic");
				if(!StyleConstants.isItalic(as)){
				    StyleConstants.setItalic(style, true);
				}
				else
				{
				    StyleConstants.setItalic(style, false);
				   
				}
				 doc.setCharacterAttributes(indices[0], indices[1] - indices[0], style, false);
				

			}
		});

		
		/**
		 * Damos funcionalidad a la negrita
		 * 
		 * */

		//Cuando clicas en la foto de negrita...

		btnBold.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int[] indices = indicesSeleccion(editorPane.getSelectionStart(),editorPane.getSelectionEnd());			    
				StyledDocument doc = editorPane.getStyledDocument();
				//cogemos un elemento del texto seleccionado para saber si esta en cursiva
				Element element = doc.getCharacterElement(indices[0]);
				AttributeSet as = element.getAttributes();				
				Style style = editorPane.getStyle("Bold");
				if(!StyleConstants.isBold(as)){
				    StyleConstants.setBold(style, true);
				}
				else
				{
				    StyleConstants.setBold(style, false);
				   
				}
				 doc.setCharacterAttributes(indices[0], indices[1] - indices[0], style, false);			    

			}
			
		});

		//Cuando clicas en la foto de negrita...

				btnUnderline.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int[] indices = indicesSeleccion(editorPane.getSelectionStart(),editorPane.getSelectionEnd());			    
						StyledDocument doc = editorPane.getStyledDocument();
						//cogemos un elemento del texto seleccionado para saber si esta en cursiva
						Element element = doc.getCharacterElement(indices[0]);
						AttributeSet as = element.getAttributes();				
						Style style = editorPane.getStyle("Underline");
						if(!StyleConstants.isUnderline(as)){
						    StyleConstants.setUnderline(style, true);
						}
						else
						{
						    StyleConstants.setUnderline(style, false);
						   
						}
						//aplicamos el estilo a la seleccion
						 doc.setCharacterAttributes(indices[0], indices[1] - indices[0], style, false);
					}
				});
				//Aumentar el tamanio de la fuente
				btnMoreSize.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int[] indices = indicesSeleccion(editorPane.getSelectionStart(),editorPane.getSelectionEnd());			    
						StyledDocument doc = editorPane.getStyledDocument();						
						Style style = editorPane.getStyle("Font");
						Element element = doc.getCharacterElement(indices[0]);
						AttributeSet as = element.getAttributes();
						StyleConstants.setFontSize(style, StyleConstants.getFontSize(as)+2);
						doc.setCharacterAttributes(indices[0], indices[1] - indices[0], style, false);						
					}
					
				});
				
				
				//Cambiamos el tipo de fuente 
				 cmbFuente.addItemListener(new ItemListener() {
				        @Override
				        public void itemStateChanged(ItemEvent e) {
				            if (e.getStateChange() == ItemEvent.SELECTED) {
				            	
				                editorPane.setFont(new Font((String) cmbFuente.getSelectedItem(), Font.ITALIC, 16));
				            }
				        }
					
				    });
	}

/**
 * Metodo que devuelve el inicio y el fin de la seleccion  
 */
private int[] indicesSeleccion(int start, int end){
	int resultado[] = new int[2];
    if (start == end) { // No selection, cursor position.
        return null;
    }
    if (start > end) { // Backwards selection? 
        resultado[0] = end;
        resultado[1] = start;
    }else{
    	resultado[0] = start;
    	resultado[1] = end;
    }
    return resultado;
}
}



