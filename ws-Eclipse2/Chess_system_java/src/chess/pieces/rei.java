package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class rei extends ChessPiece {

	public rei(Board board, Color color) {
		super(board, color);
	}
	public String toString() {
		return "Re";
	}
}
