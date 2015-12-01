package main;
import java.awt.EventQueue;

import javax.swing.UIManager;

import gui.EditorTXT;

public class init {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Hilo para la interfaz gr�fica. (Se crea por defecto)
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					 *  Set the Look And Feel
					 *  
					 *  Cambia el Look And Feel de Swing para que utilice el 
					 *  del sistema si es posible. Si por alg�n error no puede
					 *  cargar el estilo del sistema, carga el estilo por
					 *  defecto.
					 */
					if (UIManager.getSystemLookAndFeelClassName()
							.equals(UIManager
									.getCrossPlatformLookAndFeelClassName())) {
			            UIManager.setLookAndFeel(
			            		 "javax.swing.plaf.metal.MetalLookAndFeel");
			        } else {
			            UIManager.setLookAndFeel(UIManager
			            		.getSystemLookAndFeelClassName());
			        }
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
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
