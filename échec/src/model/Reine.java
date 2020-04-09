package model;

public class Reine extends AbstractPiece {

	public Reine(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if( ((xFinal == this.getX() || yFinal == this.getY())
				|| (Math.abs(this.getX()-xFinal) == Math.abs(this.getY()-yFinal)))
				&& (this.getX() != xFinal || this.getY() != yFinal)) {
			return true;
		}else {
		return false;
		}
	}

}
