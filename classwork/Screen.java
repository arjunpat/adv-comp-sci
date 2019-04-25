import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends View {
  private Box box = new Box();
  Thread boxThread = new Thread(box);

  public Screen() {

    boxThread.start();

    Thread t = new Thread(new Runnable() {
      public void run() {
        try { Thread.sleep(10); } catch(Exception e) {}
        repaint();
      }
    });

    t.start();
  }

  public void draw(Graphics g) {
    box.draw(g);

  }

}
