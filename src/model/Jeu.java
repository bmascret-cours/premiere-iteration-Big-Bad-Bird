package model;

import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	List<Pieces> Liste_pieces;
	
	private Pieces findPiece(int x, int y) {
		Pieces cherchee = null;
		for(Pieces Piece:this.Liste_pieces) {
			if( Piece.getX() == x && Piece.getY() == y) {
				cherchee = Piece;
			}
		}
	return cherchee;	
	}
	
	public Jeu(Couleur couleur) {
		this.Liste_pieces = ChessPiecesFactory.newPieces(couleur);
	}
	
	public Couleur getCouleur() {
		return this.Liste_pieces.get(0).getCouleur();
	}
	
	@Override
	public String toString() {
		String string = "";
		for(Pieces Piece:Liste_pieces) {
			string += Piece.toString() + " ";
		}
		return "Jeu[" + string + "]";
	}

	public boolean isPieceHere(int x, int y) {
		if(this.findPiece(x, y) != null) {
		return true;
		}else {
			return false;
		}
	}
		
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		Pieces pieceInit = this.findPiece(xInit, yInit);
		Pieces pieceFinal = this.findPiece(xFinal, yFinal);
		if (pieceInit != null) {
			if( (xFinal >= 0 && xFinal <= 7 && yFinal >= 0 && yFinal <= 7)
				&& (pieceFinal != null)
				&& (pieceInit.isMoveOk(xFinal, yFinal))){
					//TODO verif que rien sur trajectoire
				
			}
		}else if(xFinal >= 0 && xFinal <= 7 && yFinal >= 0 && yFinal <= 7) {
			//TODO verif que rien sur trajectoire
		}else {
			return false;
		}
		
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
	
	public static void main(String args[]) {
		Jeu monjeu = new Jeu(Couleur.NOIR);
//		System.out.println(monjeu.toString());
		Pieces piece = monjeu.findPiece(4,0);
		System.out.println(piece);
		System.out.println(monjeu.isPieceHere(3, 3));
	}
	
	
}
