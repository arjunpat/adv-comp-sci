import articles.*;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Database {
	private HashTable<Article> hashTable = new HashTable<Article>();

	public Database() {
		init();
	}

	public DLList<Article>[] getArr() {
		return hashTable.getTable();
	}

	private void init() {
		BufferedImage boulder, dirt, grass, tree, water;

		try {
			boulder = ImageIO.read(getClass().getResource("articles/images/boulder.png"));
			dirt = ImageIO.read(getClass().getResource("articles/images/dirt.jpeg"));
			grass = ImageIO.read(getClass().getResource("articles/images/grass.jpg"));
			tree = ImageIO.read(getClass().getResource("articles/images/tree.png"));
			water = ImageIO.read(getClass().getResource("articles/images/water.jpg"));

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		/*for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				hashTable.add(new Grass(i * 40, j * 40, grass));
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 10; j < 20; j++) {
				hashTable.add(new Dirt(i * 40, j * 40, dirt));
			}
		}

		for (int i = 10; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				hashTable.add(new Water(i * 40, j * 40, water));

			}
		}*/

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
						toAdd = new Tree(i * 40, j * 40, tree);
					}

					if (!hashTable.get(toAdd).get(0).toString().equals("water")) {
						System.out.println(hashTable.get(toAdd));
						hashTable.add(toAdd);
					}
				}
			}
		}
	}
}