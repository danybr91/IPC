package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Panel;
import java.awt.Label;
import java.awt.GridLayout;
import javax.swing.JEditorPane;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class EditorTXT extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorTXT frame = new EditorTXT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditorTXT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 497);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		toolBar.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 10, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Abrir");
		btnNewButton_1.setToolTipText("Abrir");
		panel_1.add(btnNewButton_1);
		
		Panel panel = new Panel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar_1 = new JToolBar();
		panel.add(toolBar_1, BorderLayout.NORTH);
		
		Label label = new Label("");
		label.setAlignment(Label.RIGHT);
		label.setEnabled(false);
		toolBar_1.add(label);
		
		JEditorPane editorPane = new JEditorPane();
		getContentPane().add(editorPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAlchivo = new JMenu("Archivo");
		menuBar.add(mnAlchivo);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		JMenu mnFormato = new JMenu("Formato");
		menuBar.add(mnFormato);
		
		JMenu mnVer = new JMenu("Ver");
		menuBar.add(mnVer);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
	}

}
