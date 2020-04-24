package model;

import java.util.LinkedList;
import java.util.List;

public class Echiquier implements BoardGames {
	
	Jeu jeu1;
	Jeu jeu2;
	Jeu jeuCourant;
	String message;
	
	public Echiquier() {
		this.jeu1 = new Jeu(Couleur.BLANC);
		this.jeu2 = new Jeu(Couleur.NOIR);
		this.jeuCourant = jeu1;
		this.message = "echec";
	}

	private void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return new String(this.message);
	}
	
	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if (this.isMoveOk(xInit, yInit, xFinal, yFinal)) {
			return jeuCourant.move(xInit, yInit, xFinal, yFinal);
		}else {
			return false;
		}
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return jeuCourant.getCouleur();
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		return jeuCourant.getPieceColor(x, y);
	}
	
	public void switchJoueur() {
		if(jeuCourant == jeu1) {
			jeuCourant = jeu2;
		}else{
			jeuCourant = jeu1;
		}
	}
	
	public List<PieceIHM> getPiecesIHM(){
		List<PieceIHM> list = new LinkedList<PieceIHM>(jeu1.getPiecesIHM());
		list.addAll(new LinkedList<PieceIHM>(jeu2.getPiecesIHM()));
		return list;	
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		if (!this.jeuCourant.isPieceHere(xInit, yInit)) {
			return false;
		}else if( xFinal < 0 || xFinal > 7 || yFinal < 0 || yFinal > 7
				  || (xFinal == xInit && yFinal == yInit)) {
			return false;
		}else if (jeu1.isMoveOk(xInit, yInit, xFinal, yFinal)
				  && jeu2.isMoveOk(xInit, yInit, xFinal, yFinal)){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		String string = jeu1.toString();
		string += ", " + jeu2.toString();
		return "Echiquier [ " + string + "]";
	}
	
	public static void main(String args[]) {
		Echiquier ech = new Echiquier();
		System.out.println(ech.toString());
		ech.switchJoueur();
		System.out.println(ech.getColorCurrentPlayer());
		System.out.println(ech.move(0, 1, 0, 2));
		ech.switchJoueur();
		System.out.println(ech.getColorCurrentPlayer());
		System.out.println(ech.move(4,6,4,5));
		System.out.println(ech.getPiecesIHM());
	}
}
