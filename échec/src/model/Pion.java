package model;

public class Pion extends AbstractPiece implements Pions {

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	@Override
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		//je triche un peu
		int sens;
		if(this.getCouleur() == Couleur.NOIR) {
			sens = 1;
		}else {
			sens = -1;
		}
		if( (this.getX() == xFinal + 1 || this.getX() == xFinal - 1 ) && (this.getY() + sens) == yFinal){
			return true;
		}else  {
			return false;
		}
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		int sens;
		if(this.getCouleur() == Couleur.NOIR) {
			sens = 1;
		}else {
			sens = -1;
		}
		if( this.getX() == xFinal && (this.getY() + sens) == yFinal){
			return true;
		}else if( (this.getX() == xFinal && (this.getY() + 2*sens) == yFinal)
				&& (this.getY() == 1 || this.getY() == 6) ){
			return true;
		}else  {
			return isMoveDiagOk(xFinal, yFinal);
		}
	}

}
