package model;

public class Tour extends AbstractPiece {

	public Tour(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if ((xFinal == this.getX() || yFinal == this.getY())
				&& (this.getX() != xFinal || this.getY() != yFinal)) {
			return true;
		}else {
			return false;
		}
	}

}
