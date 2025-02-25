package chess;

import boardGame.Board;
import boardGame.piece;

public class ChessPiece extends piece {
	
	private Color color;
	
	public ChessPiece(Board board,Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	

	
	

}
