import javax.swing.JFrame;

public class Runner {
	public static void main(String[] args) {

		JFrame jFrame = new JFrame("El Mercado");
		jFrame.add(new Screen());

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);

	}
}
