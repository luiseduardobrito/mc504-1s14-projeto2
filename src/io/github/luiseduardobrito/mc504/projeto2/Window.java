package io.github.luiseduardobrito.mc504.projeto2;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Classe para controle e gerenciamento da tela
// Ref: http://java.about.com/od/creatinguserinterfaces/ss/simplewindow.htm
public class Window {

	private static JFrame frame;
	private static List<JLabel> labels;
	private static List<JLabel> states;

	public static void createAndShow(int num) {

		// Cria a tela e o grid layout
		frame = new JFrame("Filósofos");
		GridLayout grid = new GridLayout(num, 2);
		frame.setLayout(grid);

		// Prepara label list
		labels = new ArrayList<JLabel>();
		states = new ArrayList<JLabel>();

		for (int i = 0; i < num; i++) {

			// Inicializa label
			JLabel label = new JLabel("Filósofo " + i);
			label.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
			labels.add(label);

			// Adiciona no frame
			frame.add(labels.get(i));

			// Inicializa state
			JLabel state = new JLabel("Label for philosopher " + i);
			state.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
			states.add(state);

			// Adiciona no frame
			frame.add(states.get(i));
		}

		// Inicia a tela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	public static void setText(int pos, String content) {
		states.get(pos).setText(content);
	}
}