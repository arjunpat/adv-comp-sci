import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends JPanel implements ActionListener {
	TreeMap<String, String> map = new TreeMap<String, String>();
	private JTextArea textArea = new JTextArea(400, 400);
	private JTextArea resultTextArea = new JTextArea(300, 300);
	private JTextArea thewords = new JTextArea(200, 200);


	public Screen() {
		this.setLayout(null);

		textArea.setEditable(true);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 50, 400, 400);
        this.add(scrollPane);



		resultTextArea.setEditable(false);
		resultTextArea.setLineWrap(true);
		JScrollPane resils = new JScrollPane(resultTextArea);
		resils.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        resils.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        resils.setBounds(500, 50, 300, 300);
        this.add(resils);

        thewords.setEditable(false);
		JScrollPane asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf = new JScrollPane(thewords);
		asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf.setBounds(500, 600, 300, 300);
        this.add(asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf);


        JButton clickMe = new JButton("Click me");
        clickMe.setBounds(250, 700, 200, 30);
        clickMe.addActionListener(e -> {
        	resultTextArea.setText(translate(textArea.getText()));
        });
        this.add(clickMe);


		this.setFocusable(true);
		this.init();

		String allItems = "";

		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String i = it.next();
			String price = map.get(i);

			allItems += i + " -> " + price + "\n";
		}


		thewords.setText(allItems);
	}

	public Dimension getPreferredSize() {
		return new Dimension(800, 800);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

	public void actionPerformed(ActionEvent e) {

		this.repaint();

	}

	public String translate(String spanish) {
		String[] words = spanish.split("\\s+");

		for (int i = 0; i < words.length; i++) {
			words[i] = map.get(words[i]);
		}

		String hi = "";
		for (int i = 0; i < words.length; i++) {
			hi += words[i] + " ";
		}

		return hi;
	}

	private void init() {
		map.put("a", "to");
	    map.put("antes", "before");
	    map.put("barco", "ship");
	    map.put("borrar", "delete");
	    map.put("cafe", "brown");
	    map.put("casa", "house");
	    map.put("comprar", "buy");
	    map.put("con", "with");
	    map.put("contaminado", "corrupt");
	    map.put("de", "of");
	    map.put("despues", "after");
	    map.put("dos", "two");
	    map.put("el", "the");
	    map.put("en", "in");
	    map.put("energia", "power");
	    map.put("es", "is");
	    map.put("fallo", "bug");
	    map.put("hambre", "hunger");
	    map.put("interno", "internal");
	    map.put("la", "the");
	    map.put("los", "the");
	    map.put("memoria", "memory");
	    map.put("mi", "my");
	    map.put("mitad", "half");
	    map.put("muchachos", "boys");
	    map.put("necesita", "necessary");
	    map.put("nosotros", "we");
	    map.put("ordenador", "computer");
	    map.put("pantalla", "screen");
	    map.put("papel", "paper");
	    map.put("pelo", "hair");
	    map.put("quieres", "want");
	    map.put("quiero", "want");
	    map.put("rearrancar", "reboot");
	    map.put("su", "your");
	    map.put("tarde", "afternoon");
	    map.put("texto", "text");
	    map.put("tienen", "have");
	    map.put("tinta", "ink");
	    map.put("todas", "all");
	    map.put("tu", "you");
	    map.put("una", "a");
	    map.put("vacio", "empty");
	    map.put("vamos", "go");
	    map.put("virus", "virus");
	    map.put("yo", "i");
	}

}