import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends View {
  private Box box = new Box(this);
  Thread boxThread = new Thread(box);

  public Screen() {
    boxThread.start();
  }

  public void draw(Graphics g) {
    box.draw(g);
  }

}
