package model;

public class Echequier implements BoardGames {

	public Echequier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void switchJoueur() {
		
	}
	
	public java.util.List<PieceIHM> getPiecesIHM(){
		//TODO
		
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO
		return false;
	}

	@Override
	public String toString() {
		return "Echequier []";
	}
	
}
