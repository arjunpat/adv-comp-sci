import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends View {
  private Box box = new Box();
  Thread boxThread = new Thread(box);

  public Screen() {
  }

  public void draw(Graphics g) {

  }

  boxThread.start();
}
