package main;

import java.awt.EventQueue;

import javax.swing.UIManager;

import gui.EditorTXT;

public class init {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Hilo para la interfaz gráfica. (Se crea por defecto)
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					 *  Set the Look And Feel
					 *  
					 *  Cambia el Look And Feel de Swing para que utilice el 
					 *  del sistema si es posible. Si por algún error no puede
					 *  cargar el estilo del sistema, carga el estilo por
					 *  defecto.
					 */
					if (UIManager.getSystemLookAndFeelClassName()
							.equals(UIManager
									.getCrossPlatformLookAndFeelClassName())) {
			            UIManager.setLookAndFeel("javax."
			            		+ "swing.plaf.nimbus.NimbusLookAndFeel");
			        } else {
			            UIManager.setLookAndFeel(UIManager
			            		.getSystemLookAndFeelClassName());
			        }
					// Crear la vista principal y mostrarla
					EditorTXT frame = new EditorTXT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
