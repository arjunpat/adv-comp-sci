import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Box implements Runnable {
  private int x;
  private int y;
  private boolean right = true;
  public Box() {
    x = 0;
    y = 40;
  }

  public void run() {
    if (x>700) {
      right = false;
    }

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
  }

  public void draw(Graphics g) {
    g.setColor(Color.YELLOW);
    g.fillRect(x, y, 100, 100);
  }


}
