package model;

import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	List<Pieces> Liste_pieces;
	
	public Jeu(Couleur couleur) {
		this.Liste_pieces = ChessPiecesFactory.newPieces(couleur);
	}
	
	public Couleur getCouleur() {
		//TODO
	}
	
	@Override
	public String toString() {
		
		return "Jeu []";
	}

	public boolean isPieceHere(int x, int y) {
		//TODO
		return false;
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		//TODO
		
	}
	
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		//TODO
		
	}
	
	public void setPossibleCapture() {
		//TODO
	}
	
	public Couleur getPieceColor(int x, int y) {
		//TODO
		
	}
	
	public Couleur getCouleur() {
		//TODO
	}
	
	public java.util.List<PieceIHM> getPiecesIHM(){
		//TODO
	}
	
	public void setCastling() {
		//TODO
	}
	
	public void undoMove() {
		//TODO
	}
	
	public void undoCapture() {
		//TODO
	}
	
	public boolean isPawnPromotion(int xFinal, int yfinal) {
		//TODO
	}
	
	public boolean pawnPromotion(int xFinal, int yfinal, java.lang.String type) {
		//TODO
	}
	
	public Coord getKingCoord() {
		//TODO
	}
	
	
}
