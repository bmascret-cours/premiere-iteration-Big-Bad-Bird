package vue;

import java.awt.MenuContainer;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.accessibility.Accessible;
import javax.swing.JFrame;
import javax.swing.RootPaneContainer;
import javax.swing.WindowConstants;

public class ChessGameGUI extends JFrame implements Serializable, MouseListener, MouseMotionListener, ImageObserver,
		MenuContainer, EventListener, Observer, Accessible, RootPaneContainer, WindowConstants {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
