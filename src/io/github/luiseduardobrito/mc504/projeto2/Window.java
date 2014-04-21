package io.github.luiseduardobrito.mc504.projeto2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// Classe para controle e gerenciamento da tela
// Ref: http://java.about.com/od/creatinguserinterfaces/ss/simplewindow.htm
public class Window {

	private static JFrame frame;
	private static JScrollPane scroll;
	private static JTextArea textArea;

	public static void createAndShow() {

		// Cria a tela e centraliza
		frame = new JFrame("Filósofos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		// Prepara scroll view
		textArea = new JTextArea(5, 30);
		scroll = new JScrollPane(textArea);
		frame.getContentPane().add(scroll, BorderLayout.CENTER);

		// Inicia a tela
		frame.pack();
		frame.setVisible(true);
	}

	public static void addText(String content) {

		// Adiciona texto
		textArea.append(content + "\n");

		// Scroll no fim da tela
		//int height = (int) textArea.getPreferredSize().getHeight();
		//scroll.getVerticalScrollBar().setValue(height);
	}
}
