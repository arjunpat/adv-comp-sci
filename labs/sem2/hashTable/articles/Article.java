package articles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public abstract class Article {

	public abstract void draw(Graphics g);

	public abstract int hashCode();

	public abstract int getOverlayNumber();
}