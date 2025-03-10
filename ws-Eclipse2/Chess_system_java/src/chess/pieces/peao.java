package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class peao extends ChessPiece {

	public peao(Board board, Color color) {
		super(board, color);

	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinha()][getBoard().getColuna()];

		Position p = new Position(0, 0);
		if (getColor() == Color.WHITE) {
			p.SetValues(position.getLinha() - 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}

			p.SetValues(position.getLinha() - 2, position.getColuna());
			Position p2 = new Position(position.getLinha() - 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().ThereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.SetValues(position.getLinha() - 1, position.getColuna() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.SetValues(position.getLinha() - 1, position.getColuna() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
		} else {
			p.SetValues(position.getLinha() + 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}

			p.SetValues(position.getLinha() + 2, position.getColuna());
			Position p2 = new Position(position.getLinha() - 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().ThereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.SetValues(position.getLinha() + 1, position.getColuna() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.SetValues(position.getLinha() + 1, position.getColuna() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;

			}

		}

		return mat;

	}

	@Override
	public String toString() {
		return "p";
	}
	
}
