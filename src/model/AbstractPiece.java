package model;

public abstract class AbstractPiece implements Pieces {
	
	Couleur couleur;
	Coord coord;
	
	public AbstractPiece(Couleur couleur, Coord coord) {
		super();
		this.couleur = couleur;
		this.coord = coord;
	}

	@Override
	public int getX() {
		return coord.getX();
	}

	@Override
	public int getY() {
		return coord.getY();
	}

	@Override
	public Couleur getCouleur() {
		return couleur;
	}

	@Override
	public abstract boolean isMoveOk(int xFinal, int yFinal);

	@Override
	public boolean move(int xFinal, int yFinal) {
		if (isMoveOk(xFinal, yFinal)) {
			coord.setX(xFinal);
			coord.setY(yFinal);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean capture() {
		// TODO Auto-generated method stub
		int compteur = 0;
		for(Coord l:liste_coord) {
			if (l.equals(coord)) {
				compteur++;
			}
		}
		if (compteur>1) {
			coord.setX(-1);
			coord.setY(-1);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "AbstractPiece [couleur=" + couleur + ", coord=" + coord + "]";
	}

}