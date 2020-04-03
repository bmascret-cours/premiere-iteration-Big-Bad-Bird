package model;

public class Pion extends AbstractPiece implements Pions {

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	@Override
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		// if isMoveDiagOk(int xFinal, int yFinal)
		int sens;
		if(this.getCouleur() == Couleur.NOIR) {
			sens = 1;
		}else {
			sens = -1;
		}
		if( (this.getX() == xFinal && (this.getY() + sens) == yFinal)
				&& (this.getX() != xFinal || this.getY() != yFinal)) {
			return true;
		}else {
			return false;
		}
	}

}
