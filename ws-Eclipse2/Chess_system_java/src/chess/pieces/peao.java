package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class peao extends ChessPiece {

	private ChessMatch chessMatch;

	public peao(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;

	}

	@Override
	public String toString() {
		return "P";
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
			
			//special move en passant white
			if (position.getLinha() == 3) {
				Position left = new Position(position.getLinha(), position.getColuna() -1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()); {
					mat[left.getLinha() -1][left.getColuna()] = true;
				}
				Position right = new Position(position.getLinha(), position.getColuna() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()); {
					mat[right.getLinha() -1][right.getColuna()] = true;
				}
			}
			
		} else {
			p.SetValues(position.getLinha() + 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}

			p.SetValues(position.getLinha() + 2, position.getColuna());
			Position p2 = new Position(position.getLinha() + 1, position.getColuna());
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
			//special move en passant black
			if (position.getLinha() == 4) {
				Position left = new Position(position.getLinha(), position.getColuna() -1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()); {
					mat[left.getLinha() + 1][left.getColuna()] = true;
				}
				Position right = new Position(position.getLinha(), position.getColuna() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()); {
					mat[right.getLinha() + 1][right.getColuna()] = true;
				}
			}

		}

		return mat;

	}

}
