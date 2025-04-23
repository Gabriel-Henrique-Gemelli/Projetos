package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class torre extends ChessPiece {

	public torre(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getLinha()][getBoard().getColuna()];

		Position p = new Position(0, 0);
		p.SetValues(position.getLinha() - 1, position.getColuna());
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// esquerda
		p.SetValues(position.getLinha(), position.getColuna() - 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// direita
		p.SetValues(position.getLinha(), position.getColuna() + 1);
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		p.SetValues(position.getLinha() + 1, position.getColuna());
		while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		return mat;
	}

}
