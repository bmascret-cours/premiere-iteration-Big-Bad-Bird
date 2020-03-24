package model;

public class Pion extends AbstractPiece implements Pions {

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

}
