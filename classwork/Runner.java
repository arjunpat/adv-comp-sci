import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Runner extends View {
	private ArrayList<Student> studentList = new ArrayList<Student>();
  private int[] firstSem = {0, 0, 0, 0, 0, 0, 0, 0};
  private int[] secondSem = {0, 0, 0, 0, 0, 0, 0, 0};

	private HashMap<Integer, HashMap<Integer, Integer>> firstSemHash = new HashMap<Integer, HashMap<Integer, Integer>>();
  private HashMap<Integer, HashMap<Integer, Integer>> secondSemHash = new HashMap<Integer, HashMap<Integer, Integer>>();

  public Runner() {
    try {
      Scanner in = new Scanner(new File("data.txt"));

      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(",");

        try {
          int grade = Integer.parseInt(line[0]);
          Student s = new Student(grade);

          for (int i = 1; i < line.length; i++) {

            for (int j = 0; j < line[i].length(); j++) {
              char c = line[i].charAt(j);

              if (c != ',' && c != '+' && c != '-') {
                int period = Integer.parseInt(String.valueOf(c));
                if ((i-1)/2 == 0) {
									s.addFreeSem1(period);
								} else {
									s.addFreeSem2(period);
							  }
              }
            }
          }
					studentList.add(s);

        } catch (Exception e) {
          //System.out.println("Not a number line");
        }

      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < studentList.size(); i++) {
			Student s = studentList.get(i);
      ArrayList<Integer> fSem = s.getFirstSem();
      ArrayList<Integer> sSem = s.getSecondSem();


      if (!firstSemHash.containsKey(s.getGrade())) {
        firstSemHash.put(s.getGrade(), new HashMap<Integer, Integer>());
      }

      HashMap<Integer, Integer> hashForThatGrade = firstSemHash.get(s.getGrade());

      for (int j = 0; j < fSem.size(); j++) {
        int period = fSem.get(j);
        if (hashForThatGrade.containsKey(period)) {
          hashForThatGrade.put(period, hashForThatGrade.get(period) + 1);
        } else {
          hashForThatGrade.put(period, 1);
        }
      }

      if (!secondSemHash.containsKey(s.getGrade())) {
        secondSemHash.put(s.getGrade(), new HashMap<Integer, Integer>());
      }

      hashForThatGrade = secondSemHash.get(s.getGrade());

      for (int j = 0; j < sSem.size(); j++) {
        int period = sSem.get(j);
        if (hashForThatGrade.containsKey(period)) {
          hashForThatGrade.put(period, hashForThatGrade.get(period) + 1);
        } else {
          hashForThatGrade.put(period, 1);
        }
      }
		}


    System.out.println(firstSemHash);
    System.out.println(secondSemHash);

	}

  public void printArray(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println("]");
  }

	public int[] getInOrder(int[] array) {
		int[] arrayCopy = new int[8];
		for (int i = 0; i<array.length; i++) {
			arrayCopy[i] = array[i];
		}

		int[] returnArray = new int[8];
		for (int i = 0; i<arrayCopy.length; i++) {
			int greatest = 0;
			for (int j = 0; j<arrayCopy.length; j++) {
				if (arrayCopy[j] > arrayCopy[greatest]) {
					greatest = j;
				}
			}
			returnArray[0] = greatest;
			arrayCopy[greatest] = 0;
		}

		return returnArray;
	}

	public void draw(Graphics g) {
		int[] firstSemReturn = getInOrder(firstSem);
		int[] secondSemReturn = getInOrder(secondSem);

		for (int i = 0; i<=7; i++) {
			drawTitle(g, Color.RED, i + ": " + firstSemReturn[i], 20, 20+(40*i));
			drawTitle(g, Color.RED, i + ": " + secondSemReturn[i], 300, 20+(40*i));
		}


		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.PLAIN, 18));
		g.drawString("$", 20, 120);
		g.drawString("$", 20, 485);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Thing");

		frame.add(new Runner());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
