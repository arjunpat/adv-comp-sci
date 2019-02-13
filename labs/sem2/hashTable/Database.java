import articles.*;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Database {
	private HashTable<Article> hashTable = new HashTable<Article>();
	private BufferedImage boulder, dirt, grass, tree, water, bear;

	public Database() {
		init();
	}

	public DLList<Article>[] getArr() {
		return hashTable.getTable();
	}

	public boolean canMove(Article a) {
		DLList<Article> list = hashTable.get(a);

		return list.size() == 1 && (list.get(0) instanceof Dirt || list.get(0) instanceof Grass);
	}

	private void init() {

		try {
			boulder = ImageIO.read(getClass().getResource("articles/images/boulder.png"));
			dirt = ImageIO.read(getClass().getResource("articles/images/dirt.jpeg"));
			grass = ImageIO.read(getClass().getResource("articles/images/grass.jpg"));
			tree = ImageIO.read(getClass().getResource("articles/images/tree.png"));
			water = ImageIO.read(getClass().getResource("articles/images/water.jpg"));
			bear = ImageIO.read(getClass().getResource("articles/images/bear.png"));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		for (int i = 0; i < 20; i ++) {
			for (int j = 0; j < 20; j++) {
				int which = (int)(Math.random() * 3);
				if (which == 0) {
					hashTable.add(new Grass(i * 40, j * 40, grass));
				} else if (which == 1) {
					hashTable.add(new Dirt(i * 40, j * 40, dirt));
				} else {
					hashTable.add(new Water(i * 40, j * 40, water));
				}
			}
		}

		hashTable.get(new Water(400, 480, water)).remove(0);
		hashTable.add(new Grass(400, 480, grass));

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (Math.random() > .5) {
					Article toAdd;

					int which = (int)(Math.random() * 3);
					if (which == 0) {
						toAdd = new Tree(i * 40, j * 40, tree);
					} else if (which == 1) {
						toAdd = new Boulder(i * 40, j * 40, boulder);
					} else {
						toAdd = new Bear(i * 40, j * 40, bear);
					}

					if (!hashTable.get(toAdd).get(0).toString().equals("water")) {
						hashTable.add(toAdd);
					}
				}
			}
		}
	}
}