package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class torre extends ChessPiece{

	public torre(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString() {
		return "T";
	}
	

}
