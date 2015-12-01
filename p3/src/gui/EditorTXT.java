package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class EditorTXT extends JFrame {
	private boolean boldSelected=false;
	private boolean italicSelected=false;
	private boolean underlineSelected=false;

	/**
	 * Create the frame.
	 */
	public EditorTXT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 515);
		getContentPane().setLayout(new BorderLayout(0, 0));

		//Redimensionar las im�genes de los iconos si es necesario�
		//		Image img = icon.getImage() ;  
		//		Image newimg = img.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH ) ;  
		//		icon = new ImageIcon( newimg );

		JPanel herramientas = new JPanel();
		getContentPane().add(herramientas, BorderLayout.NORTH);
		FlowLayout fl_herramientas = new FlowLayout(FlowLayout.LEFT, 2, 2);
		fl_herramientas.setAlignOnBaseline(true);
		herramientas.setLayout(fl_herramientas);

		JToolBar toolbar = new JToolBar();
		herramientas.add(toolbar);
		toolbar.setRollover(true);

		JButton btnNuevoArchivo = new JButton("");
		btnNuevoArchivo.setBorderPainted(false);
		btnNuevoArchivo.setToolTipText("Nuevo archivo");
		btnNuevoArchivo.setOpaque(false);
		btnNuevoArchivo.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/newfile16.png")));
		toolbar.add(btnNuevoArchivo);

		JButton btnAbrirArchivo = new JButton("");
		btnAbrirArchivo.setBorderPainted(false);
		btnAbrirArchivo.setToolTipText("Abrir archivo...");
		btnAbrirArchivo.setOpaque(false);
		btnAbrirArchivo.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/openfile16.png")));
		toolbar.add(btnAbrirArchivo);

		JButton btnGuardarArchivo = new JButton("");
		btnGuardarArchivo.setBorderPainted(false);
		toolbar.add(btnGuardarArchivo);
		btnGuardarArchivo.setOpaque(false);
		btnGuardarArchivo.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/save16.png")));
		btnGuardarArchivo.setToolTipText("Guardar archivo");

		JButton btnImprimir = new JButton("");
		btnImprimir.setBorderPainted(false);
		btnImprimir.setToolTipText("Imprimir...");
		btnImprimir.setOpaque(false);
		btnImprimir.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/printer16.png")));
		toolbar.add(btnImprimir);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator);

		JButton btnCortar = new JButton("");
		btnCortar.setBorderPainted(false);
		btnCortar.setToolTipText("Cortar");
		btnCortar.setOpaque(false);
		btnCortar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/cut16.png")));
		toolbar.add(btnCortar);

		JButton btnCopiar = new JButton("");
		btnCopiar.setBorderPainted(false);
		btnCopiar.setOpaque(false);
		btnCopiar.setToolTipText("Copiar");
		btnCopiar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/copy16.png")));
		toolbar.add(btnCopiar);

		JButton btnPegar = new JButton("");
		btnPegar.setOpaque(false);
		btnPegar.setBorderPainted(false);
		btnPegar.setToolTipText("Pegar");
		btnPegar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/paste16.png")));
		toolbar.add(btnPegar);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator_1);

		JButton btnDeshacer = new JButton("");
		btnDeshacer.setOpaque(false);
		btnDeshacer.setBorderPainted(false);
		btnDeshacer.setToolTipText("Deshacer");
		btnDeshacer.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/undone16.png")));
		toolbar.add(btnDeshacer);

		JButton btnRehacer = new JButton("");
		btnRehacer.setOpaque(false);
		btnRehacer.setBorderPainted(false);
		btnRehacer.setToolTipText("Rehacer");
		btnRehacer.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/redone16.png")));
		toolbar.add(btnRehacer);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator_2);

		JButton btnBuscar = new JButton("");
		btnBuscar.setOpaque(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setToolTipText("Buscar...");
		btnBuscar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/buscar16.png")));
		toolbar.add(btnBuscar);

		JButton btnReemplazar = new JButton("");
		btnReemplazar.setOpaque(false);
		btnReemplazar.setBorderPainted(false);
		btnReemplazar.setToolTipText("Reemplazar...");
		btnReemplazar.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/Text_replace16.png")));
		toolbar.add(btnReemplazar);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		toolbar.add(separator_4);

		JPanel Fomato = new JPanel();
		Fomato.setOpaque(false);
		toolbar.add(Fomato);
		FlowLayout fl_Fomato = new FlowLayout(FlowLayout.LEFT, 4, 1);
		Fomato.setLayout(fl_Fomato);

		JComboBox cmbFuente = new JComboBox();
		Fomato.add(cmbFuente);
		cmbFuente.setModel(new DefaultComboBoxModel(new String[] {"Arial", "Tahoma", "Times New Roman"}));
		cmbFuente.setToolTipText("Fuente");

		JComboBox cmbSize = new JComboBox();
		Fomato.add(cmbSize);
		cmbSize.setModel(new DefaultComboBoxModel(new String[] {"8", "9", "10", "11", "12", "13", "14", "inf"}));
		cmbSize.setToolTipText("Tama\u00F1o de fuente");

		JButton btnLessSize = new JButton("");
		btnLessSize.setOpaque(false);
		btnLessSize.setBorderPainted(false);
		toolbar.add(btnLessSize);
		btnLessSize.setToolTipText("Disminuir tama\u00F1o de fuente");
		btnLessSize.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/smlA16.png")));

		JButton btnMoreSize = new JButton("");
		btnMoreSize.setOpaque(false);
		btnMoreSize.setBorderPainted(false);
		toolbar.add(btnMoreSize);
		btnMoreSize.setToolTipText("Aumentar tama\u00F1o de fuente");
		btnMoreSize.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/bigA16.png")));

		JButton btnTextColor = new JButton("");
		btnTextColor.setOpaque(false);
		btnTextColor.setBorderPainted(false);
		toolbar.add(btnTextColor);
		btnTextColor.setToolTipText("Color de texto");
		btnTextColor.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/textcolor16.png")));

		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator_5);

		JToggleButton btnBold = new JToggleButton("");
		btnBold.setOpaque(false);
		btnBold.setBorderPainted(false);
		btnBold.setToolTipText("Negrita");
		btnBold.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/b16.png")));
		toolbar.add(btnBold);

		JToggleButton btnCursive = new JToggleButton("");
		btnCursive.setOpaque(false);
		btnCursive.setBorderPainted(false);
		btnCursive.setToolTipText("Cursiva");
		btnCursive.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/i16.png")));
		toolbar.add(btnCursive);

		JToggleButton btnUnderline = new JToggleButton("");
		btnUnderline.setOpaque(false);
		btnUnderline.setBorderPainted(false);
		btnUnderline.setToolTipText("Subrayado");
		btnUnderline.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/u16.png")));
		toolbar.add(btnUnderline);

		/*
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		toolbar.add(separator_6);

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

		JPanel editor = new JPanel();
		editor.setBorder(new MatteBorder(1, 0, 1, 0, (Color) SystemColor.controlShadow));
		getContentPane().add(editor, BorderLayout.CENTER);
		editor.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		editor.add(scrollPane, BorderLayout.CENTER);

		JEditorPane editorPane = new JEditorPane();
		editor.add(editorPane);

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
		fl_codificacion.setAlignment(FlowLayout.RIGHT);
		estado.add(codificacion);

		JLabel lblUtf = new JLabel("UTF-8");
		lblUtf.setEnabled(false);
		lblUtf.setFocusable(false);
		codificacion.add(lblUtf);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAlchivo = new JMenu("Archivo");
		menuBar.add(mnAlchivo);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.setIcon(new ImageIcon(EditorTXT.class.getResource("/res/newfile16.png")));
		mnAlchivo.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
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

				if(!italicSelected){
					Font actual=editorPane.getFont(); 
					Font cursiva=new Font("cursiva", actual.getStyle()+Font.ITALIC, actual.getSize());
					editorPane.setFont(cursiva);
					italicSelected=true;
				}else{
					Font actual=editorPane.getFont(); 
					Font cursiva=new Font("cursiva",actual.getStyle()-Font.ITALIC, actual.getSize());
					editorPane.setFont(cursiva);
					italicSelected=false;
				}
			}
		});
		
		//Cusando clickamos en Formato, Cursiva...
		
		mntmCursiva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!italicSelected){
					Font actual=editorPane.getFont(); 
					Font cursiva=new Font("cursiva", Font.ITALIC, actual.getSize());
					editorPane.setFont(cursiva);
					italicSelected=true;
				}else{
					Font actual=editorPane.getFont(); 
					Font cursiva=new Font("cursiva",0, actual.getSize());
					editorPane.setFont(cursiva);
					italicSelected=false;
				}
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
				if(!boldSelected){
					Font actual=editorPane.getFont(); 
					Font negrita=new Font("negrita", Font.BOLD+actual.getStyle(), actual.getSize());
					editorPane.setFont(negrita);
					boldSelected=true;
				}else{
					Font actual=editorPane.getFont(); 
					Font negrita=new Font("negrita",actual.getStyle()-Font.BOLD, actual.getSize());
					editorPane.setFont(negrita);
					boldSelected=false;
				}
			}
			
		});
		
		/** En desarrollo
		btnUderline.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!underlineSelected){
					Font actual=editorPane.getFont(); 
					Font negrita=new Font("negrita",Font.PLAIN, actual.getSize());
					editorPane.setFont(negrita);
					underlineSelected=true;
				}else{
					Font actual=editorPane.getFont(); 
					Font negrita=new Font("negrita",actual.getStyle()-Font.PLAIN, actual.getSize());
					editorPane.setFont(negrita);
					underlineSelected=false;
				}
			}
			
		});
		**/
	}
}


