package chess;

import boardGame.Board;
import boardGame.Position;
import boardGame.piece;
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
	
	public ChessPiece performChessMove(ChessPosition sourcePosition,ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		piece capturedPiece = makeMove(source,target);
		return (ChessPiece)capturedPiece;
		
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.ThereIsAPiece(position)) {
			throw new ChessException("Nao tem peça na posiçao selecionada");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("Nao existem movimentos possiveis para a peça selecionada");
		}
	}
	
	private piece makeMove(Position source, Position target) {
		piece p = board.removePiece(source);
		piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
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
