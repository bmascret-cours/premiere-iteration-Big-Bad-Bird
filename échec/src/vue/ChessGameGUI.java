package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.MenuContainer;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.util.EventListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.accessibility.Accessible;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;
import javax.swing.WindowConstants;

import controler.controlerLocal.ChessGameControler;

import model.Coord;
import model.Couleur;
import model.PieceIHM;
import model.Pieces;
import model.observable.ChessGame;
import tools.ChessImageProvider;
import tools.ChessPiecesFactory;
import controler.ChessGameControlers;


public class ChessGameGUI extends JFrame implements Serializable, MouseListener, MouseMotionListener, ImageObserver,
		MenuContainer, EventListener, Observer, Accessible, RootPaneContainer, WindowConstants {
	
	String title;
	JLayeredPane layeredPane;
	JPanel vueChessBoard;
	JLabel vueChessPiece;
	ChessGameControlers chessGameControler;
	Dimension boardSize;
	int xAdjustment;
	int yAdjustment;
	int xInit;
	int yInit;
	

	public ChessGameGUI(String title, ChessGameControlers chessGameControler, Dimension dim){
		
		this.chessGameControler = chessGameControler;
		this.boardSize = dim;
		 
		//  Use a Layered Pane for this this application
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);
			 
		//Add a chess board to the Layered Pane 
		 
		vueChessBoard = new JPanel();
		layeredPane.add(vueChessBoard, JLayeredPane.DEFAULT_LAYER);
		vueChessBoard.setLayout( new GridLayout(8, 8) );
		vueChessBoard.setPreferredSize( boardSize );
		vueChessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		 
		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel( new BorderLayout() );
			vueChessBoard.add( square );
		
			int row = (i / 8) % 2;
			if (row == 0)
				square.setBackground( i % 2 == 0 ? Color.black : Color.white );
			else
				square.setBackground( i % 2 == 0 ? Color.white : Color.black );
		}
	/*
		//Add pieces to the board
		
	
		List<Pieces> piecesBlanc = ChessPiecesFactory.newPieces(Couleur.BLANC);
		List<Pieces> piecesNoir = ChessPiecesFactory.newPieces(Couleur.NOIR);
		JPanel panel;
		JLabel vuePiece;
		for(Pieces piece :piecesBlanc) {
			vuePiece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile(piece.getClass().getSimpleName(), Couleur.BLANC) ));
			panel = (JPanel)vueChessBoard.getComponent(piece.getX() + piece.getY()*8);
			panel.add(vuePiece);
		}
		for(Pieces piece :piecesNoir) {
			vuePiece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile(piece.getClass().getSimpleName(), Couleur.NOIR) ));
			panel = (JPanel)vueChessBoard.getComponent(piece.getX() + piece.getY()*8);
			panel.add(vuePiece);
		}
	*/
		
	}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		
		JPanel panel;
		for (int i = 0; i < 64; i++) {
			panel = (JPanel)vueChessBoard.getComponent(i);
			panel.removeAll();
		}
		for( PieceIHM piece:(List<PieceIHM>)arg) {
			for(Coord coord : piece.getList()) {
				JLabel vuePiece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile(piece.getTypePiece(), piece.getCouleur()) ));
				panel = (JPanel)vueChessBoard.getComponent(coord.getX() + coord.getY()*8);
				panel.add(vuePiece);
			}
		}
		//vueChessBoard.revalidate();
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		if (vueChessPiece == null) return;
		vueChessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		vueChessPiece = null;
		Component c =  vueChessBoard.findComponentAt(e.getX(), e.getY());
		 
		if (c instanceof JPanel) 
		return;
		
		Point parentLocation = c.getParent().getLocation();
		xAdjustment = parentLocation.x - e.getX();
		yAdjustment = parentLocation.y - e.getY();
		xInit = parentLocation.x/(700/8);
		yInit = parentLocation.y/(700/8);
		vueChessPiece = (JLabel)c;
		vueChessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		vueChessPiece.setSize(vueChessPiece.getWidth(), vueChessPiece.getHeight());
		layeredPane.add(vueChessPiece, JLayeredPane.DRAG_LAYER);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(vueChessPiece == null) return;
		 
		  vueChessPiece.setVisible(false);
		  Coord coordInit = new Coord(xInit, yInit);
		  Coord coordFinal = new Coord(e.getX()/(boardSize.height/8), e.getY()/(boardSize.height/8));
		  chessGameControler.move(coordInit, coordFinal);

		  /*
		  Component c =  vueChessBoard.findComponentAt(e.getX(), e.getY());
		  
		  
		  if (c instanceof JLabel){
		  Container parent = c.getParent();
		  parent.remove(0);
		  parent.add( vueChessPiece );
		  }
		  else {
		  Container parent = (Container)c;
		  parent.add( vueChessPiece );
		  }
		 
		  vueChessPiece.setVisible(true);
		*/
	}
	
	/*
	public static void main(String[] args) {
		  JFrame frame = new ChessGameGUI("Jeu d'échec", new ChessGameControlers(), new Dimension(600, 600));
		  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
		  frame.pack();
		  frame.setResizable(true);
		  frame.setLocationRelativeTo( null );
		  frame.setVisible(true);
	}
	*/

}
