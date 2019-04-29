import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Box implements Runnable {
  private int x;
  private int y;
  private boolean right = true;
  private Screen s;
  public Box(Screen s) {
    x = 0;
    y = 40;
    this.s = s;
  }

  public void run() {
    while (true) {
      if (x>700)
        right = false;

      if (x<0) {
        right = true;
      }

      if (right) {
        x+=10;
      } else {
        x-=10;
      }

      try {
        Thread.sleep(10);
      } catch(InterruptedException e) {}

        s.repaint();
    }
  }

  public void draw(Graphics g) {
    g.setColor(Color.RED);
    g.fillRect(x, y, 100, 100);
  }


}
