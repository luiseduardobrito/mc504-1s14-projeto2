package io.github.luiseduardobrito.mc504.projeto2;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Window {

	private static JFrame frame;

	public static void createAndShow(int number) {

		// Cria a tela e centraliza
		frame = new JFrame("Filósofos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		// Label teste
		JLabel textLabel = new JLabel("I'm a label in the window",
				SwingConstants.CENTER);
		textLabel.setPreferredSize(new Dimension(300, 100));
		frame.getContentPane().add(textLabel, BorderLayout.CENTER);
		
		// Inicia a tela
		frame.pack();
		frame.setVisible(true);
	}
}
