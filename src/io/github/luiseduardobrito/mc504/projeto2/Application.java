package io.github.luiseduardobrito.mc504.projeto2;

public class Application {

	private static final int total = 9; 
	
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				// Cria a janela e inicia o frame
				Window.createAndShow(total);
			}
		});
	}
}
