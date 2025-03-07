package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.rei;
import chess.pieces.torre;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
		
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getLinha()][board.getColuna()];
		for(int i=0; i<board.getLinha();i++) {
			for(int j=0; j<board.getColuna();j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
		
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	private void initialSetup() {
		placeNewPiece('c', 1, new torre(board, Color.WHITE));
        placeNewPiece('c', 2, new torre(board, Color.WHITE));
        placeNewPiece('d', 2, new torre(board, Color.WHITE));
        placeNewPiece('e', 2, new torre(board, Color.WHITE));
        placeNewPiece('e', 1, new torre(board, Color.WHITE));
        placeNewPiece('d', 1, new rei(board, Color.WHITE));

        placeNewPiece('c', 7, new torre(board, Color.BLACK));
        placeNewPiece('c', 8, new torre(board, Color.BLACK));
        placeNewPiece('d', 7, new torre(board, Color.BLACK));
        placeNewPiece('e', 7, new torre(board, Color.BLACK));
        placeNewPiece('e', 8, new torre(board, Color.BLACK));
        placeNewPiece('d', 8, new rei(board, Color.BLACK));
	}
}
