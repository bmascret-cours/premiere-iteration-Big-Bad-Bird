package model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tools.ChessPiecesFactory;
import tools.ChessSinglePieceFactory;

public class Jeu {
	
	List<Pieces> pieces;
	boolean castling = false;
	Deque<Integer> moves;
	
	
	public Jeu(Couleur couleur) {
		this.pieces = ChessPiecesFactory.newPieces(couleur);
		this.moves = new ArrayDeque<Integer>();
		this.castling = false;
	}
	
	private Pieces findPiece(int x, int y) {
		Pieces cherchee = null;
		for(Pieces Piece:this.pieces) {
			if( Piece.getX() == x && Piece.getY() == y) {
				cherchee = Piece;
			}
		}
	return cherchee;	
	}
	
	public Couleur getCouleur() {
		return this.pieces.get(0).getCouleur();
	}
	
	@Override
	public String toString() {
		String string = "";
		for(Pieces Piece:pieces) {
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
			if((pieceInit.getClass().getSimpleName() != "Cavalier")
				&& (pieceInit.isMoveOk(xFinal, yFinal))){
					// verif que rien sur trajectoire (cas m�mes couleurs)
					//diag
					if(xFinal > xInit && yFinal > yInit) {
						for(int i = 1; i < xFinal - xInit; i++) {
							if(this.findPiece(xInit + i, yInit + i) != null) {
								return false;
							}
						}
					}else if(xFinal > xInit && yFinal > yInit) {
						for(int i = 1; i < xFinal - xInit; i++) {
							if(this.findPiece(xInit + i, yInit - i) != null) {
								return false;
							}
						}
					}else if(xFinal < xInit && yFinal > yInit) {
						for(int i = 1; i < yFinal - yInit; i++) {
							if(this.findPiece(xInit - i, yInit + i) != null) {
								return false;
							}
						}
					}else if(xFinal < xInit && yFinal < yInit) {
						for(int i = 1; i < xInit - xFinal; i++) {
							if(this.findPiece(xInit - i, yInit - i) != null) {
								return false;
							}
						}//ligne
					}else if(xFinal > xInit && yFinal == yInit) {
						for(int i = 1; i < xFinal - xInit; i++) {
							if(this.findPiece(xInit + i, yInit) != null) {
								return false;
							}
						}
					}else if(xFinal < xInit && yFinal == yInit) {
						for(int i = 1; i < xInit - xFinal; i++) {
							if(this.findPiece(xInit - i, yInit) != null) {
								return false;
							}
						}//colonne
					}else if(xFinal == xInit && yFinal > yInit) {
						for(int i = 1; i < yFinal - yInit; i++) {
							if(this.findPiece(xInit, yInit + i) != null) {
								return false;
							}
						}
					}else if(xFinal == xInit && yFinal < yInit) {
						for(int i = 1; i < yInit - yFinal; i++) {
							if(this.findPiece(xInit, yInit - i) != null) {
								return false;
							}
						}
					}
					if(findPiece(xFinal, yFinal) == null) {
						return true;
					}else if(pieceInit.getClass().getSimpleName() == "Roi"){
						return this.castling;
					}else {
						return false;
					}
				}else if((pieceFinal == null )
					&& (pieceInit.getClass().getSimpleName() == "Cavalier")
					&& (pieceInit.isMoveOk(xFinal, yFinal))) {
						return true;
				}else {
					return false;
				}
		}else if( Math.abs(xFinal - xInit) == Math.abs(yFinal - yInit)){
			//test trajectoire pour autre couleur si pas cavalier
			if(xFinal > xInit && yFinal > yInit) {
				for(int i = 1; i < xFinal - xInit; i++) {
					if(this.findPiece(xInit + i, yInit + i) != null) {
						return false;
					}
				}
			}else if(xFinal > xInit && yFinal > yInit) {
				for(int i = 1; i < xFinal - xInit; i++) {
					if(this.findPiece(xInit + i, yInit - i) != null) {
						return false;
					}
				}
			}else if(xFinal < xInit && yFinal > yInit) {
				for(int i = 1; i < yFinal - yInit; i++) {
					if(this.findPiece(xInit - i, yInit + i) != null) {
						return false;
					}
				}
			}else if(xFinal < xInit && yFinal < yInit) {
				for(int i = 1; i < xInit - xFinal; i++) {
					if(this.findPiece(xInit - i, yInit - i) != null) {
						return false;
					}
				}//ligne
			}else if(xFinal > xInit && yFinal == yInit) {
				for(int i = 1; i < xFinal - xInit; i++) {
					if(this.findPiece(xInit + i, yInit) != null) {
						return false;
					}
				}
			}else if(xFinal < xInit && yFinal == yInit) {
				for(int i = 1; i < xInit - xFinal; i++) {
					if(this.findPiece(xInit - i, yInit) != null) {
						return false;
					}
				}//colonne
			}else if(xFinal == xInit && yFinal > yInit) {
				for(int i = 1; i < yFinal - yInit; i++) {
					if(this.findPiece(xInit, yInit + i) != null) {
						return false;
					}
				}
			}
			if(xFinal == xInit && yFinal < yInit) {
				for(int i = 1; i < yInit - yFinal; i++) {
					if(this.findPiece(xInit, yInit - i) != null) {
						return false;
					}
				}
			}else {
				return true;
			}
		}else {
			return true;
		}
		return false;
	}
	
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		Pieces pieceInit = this.findPiece(xInit, yInit);
		Pieces pieceFinal = this.findPiece(xFinal, yFinal);
		pieceInit.move(xFinal, yFinal);
		if(pieceFinal != null) {
			pieceFinal.capture();
		}
		moves.push(yFinal);
		moves.push(xFinal);
		moves.push(yInit);
		moves.push(xInit);
		return true;
	}
	
	public void setPossibleCapture() {
		//TODO
	}
	
	public Couleur getPieceColor(int x, int y) {
		Pieces piece = findPiece(x, y);
		if(piece != null) {
			return piece.getCouleur();
		}else {
			return Couleur.NOIRBLANC;
		}
	}
	
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		
		for (Pieces piece : pieces){
			boolean existe = false;
			// si le type de piece existe d�j� dans la liste de PieceIHM
			// ajout des coordonn�es de la pi�ce dans la liste de Coord de ce type
			// si elle est toujours en jeu (x et y != -1)
			for ( PieceIHM pieceIHM : list){
				if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
					existe = true;
					if (piece.getX() != -1){
						pieceIHM.add(new Coord(piece.getX(), piece.getY()));
					}
				}
			}
			// sinon, cr�ation d'une nouvelle PieceIHM si la pi�ce est toujours en jeu
			if (! existe) {
				if (piece.getX() != -1){
					newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
					piece.getCouleur());
					newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					list.add(newPieceIHM);
				}
			}
		}
		return list;
	}
	
	
	/*TODO quand plus de temps
	public void setCastling() {
		if
	}
	
	
	public void undoMove() {
		int xInit = moves.pop();
		int yInit = moves.pop();
		int xFinal = moves.pop();
		int yFinal = moves.pop();
		Pieces piece = findPiece(xFinal, yFinal);
		piece.coord = setX(xInit);
		
		}
	*/
	
	public void undoCapture() {
		//TODO
	}
	
	public boolean isPawnPromotion(int xFinal, int yfinal) {
		if(yfinal == 7 || yfinal ==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean pawnPromotion(int xFinal, int yFinal, java.lang.String type) {
		if (isPawnPromotion(xFinal, yFinal)) {
			if (yFinal == 7) {
				Pieces piece = ChessSinglePieceFactory.newPiece(Couleur.NOIR, "Reine", xFinal, yFinal);
				pieces.add(piece);
				return true;
			}else {
				Pieces piece = ChessSinglePieceFactory.newPiece(Couleur.NOIR, "Reine", xFinal, yFinal);
				pieces.add(piece);
				return true;
			}
		}else {
			return false;
		}
	}
	
	public Coord getKingCoord() {
		for(Pieces Piece:this.pieces) {
			if(Piece.getClass().getSimpleName() == "Roi") {
				return new Coord(Piece.getX(), Piece.getY());
			}
		}
		return new Coord(-1,-1);
	}
	
	public static void main(String args[]) {
		Jeu monjeu = new Jeu(Couleur.NOIR);
//		System.out.println(monjeu.toString());
		Pieces piece = monjeu.findPiece(4,0);
		System.out.println(piece);
		System.out.println(monjeu.isPieceHere(3, 3));
		System.out.println(monjeu.getPiecesIHM().get(0));
	}
	
	
}
