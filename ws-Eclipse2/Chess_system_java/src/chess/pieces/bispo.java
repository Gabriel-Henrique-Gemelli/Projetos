package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class bispo extends ChessPiece {

	public bispo(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinha()][getBoard().getColuna()];
		// noroeste
		Position p = new Position(0, 0);
		p.SetValues(position.getLinha() - 1, position.getColuna() - 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.SetValues(p.getLinha() - 1, p.getColuna() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// nordeste
		p.SetValues(position.getLinha() - 1, position.getColuna() + 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.SetValues(p.getLinha() - 1, p.getColuna() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// sudeste
		p.SetValues(position.getLinha() + 1, position.getColuna() + 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.SetValues(p.getLinha() + 1, p.getColuna() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//sudoeste

		p.SetValues(position.getLinha() + 1, position.getColuna() - 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.SetValues(p.getLinha() + 1, p.getColuna() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		return mat;
	}

}
