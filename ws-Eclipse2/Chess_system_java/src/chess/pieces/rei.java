package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class rei extends ChessPiece {

	public rei(Board board, Color color) {
		super(board, color);
	}
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinha()][getBoard().getColuna()];
		
		Position p = new Position(0,0);
		// Acima 
		p.SetValues(position.getLinha() - 1, position.getColuna());
		if (getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//para baixo
		p.SetValues(position.getLinha() + 1, position.getColuna());
		if (getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		//Esquerda
		p.SetValues(position.getLinha(), position.getColuna() - 1);
		if (getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		//direita
		p.SetValues(position.getLinha(), position.getColuna() + 1);
		if (getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//noroeste
		p.SetValues(position.getLinha() - 1, position.getColuna() - 1);
		if (getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//nordeste
		p.SetValues(position.getLinha() - 1, position.getColuna() + 1);
		if (getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		//sudoeste
		p.SetValues(position.getLinha() + 1, position.getColuna() - 1);
		if (getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//sudeste
		p.SetValues(position.getLinha() + 1, position.getColuna() + 1);
		if (getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		return mat;
		
	}
}
