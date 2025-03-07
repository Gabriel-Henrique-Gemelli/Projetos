package chess;

import boardGame.Board;
import boardGame.Position;
import boardGame.piece;

public abstract class ChessPiece extends piece {
	
	private Color color;
	
	public ChessPiece(Board board,Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	

	
	

}
