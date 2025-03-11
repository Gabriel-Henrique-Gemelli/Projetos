package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardGame.Board;
import boardGame.Position;
import boardGame.piece;
import chess.pieces.Cavalo;
import chess.pieces.Rainha;
import chess.pieces.bispo;
import chess.pieces.peao;
import chess.pieces.rei;
import chess.pieces.torre;

public class ChessMatch {

	private int turn;
	private Color currentPlayer;
	private Board board;
	private boolean check;
	private boolean checkMate;
	private ChessPiece EnPassantVulnerable;

	private List<piece> piecesOnTheBoard = new ArrayList<piece>();
	private List<piece> capturedPieces = new ArrayList<piece>();

	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();

	}

	public boolean getCheckMate() {
		return checkMate;
	}

	public boolean getCheck() {
		return check;
	}

	public int getTurn() {
		return turn;
	}

	public Color getcurrentPlayer() {
		return currentPlayer;
	}

	public ChessPiece getEnPassantVulnerable() {
		return EnPassantVulnerable;
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getLinha()][board.getColuna()];
		for (int i = 0; i < board.getLinha(); i++) {
			for (int j = 0; j < board.getColuna(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;

	}

	public boolean[][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}

	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		piece capturedPiece = makeMove(source, target);

		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("Voce nao pode se colocar em check");
		}

		ChessPiece movedPiece = (ChessPiece) board.piece(target);

		if (testCheck(opponent(currentPlayer))) {
			check = true;
		} else {
			check = false;
		}
		if (testCheckMate(opponent(currentPlayer))) {
			checkMate = true;
		} else {
			nextTurn();
		}

		// specialMove en passant
		if (movedPiece instanceof peao && (target.getLinha() == source.getLinha() - 2 || target.getLinha() == source.getLinha() + 2 )) {
			EnPassantVulnerable = movedPiece;
			
		}
		else {
			EnPassantVulnerable = null;
		}
		return (ChessPiece) capturedPiece;

	}

	private void validateSourcePosition(Position position) {
		if (!board.ThereIsAPiece(position)) {
			throw new ChessException("Nao tem peça na posiçao selecionada");
		}
		if (currentPlayer != ((ChessPiece) board.piece(position)).getColor()) {
			throw new ChessException("A peça escolhida nao e sua");

		}

		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("Nao existem movimentos possiveis para a peça selecionada");
		}
	}

	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("A peça escolhida nao pode ser mechida");
		}
	}

	private void nextTurn() {
		turn++;
		if (currentPlayer == Color.WHITE) {
			currentPlayer = Color.BLACK;
		} else {
			currentPlayer = Color.WHITE;
		}

	}

	private piece makeMove(Position source, Position target) {
		ChessPiece p = (ChessPiece) board.removePiece(source);
		p.increaseMoveCount();
		piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		if (capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}

		// special move castling kingside rook
		if (p instanceof rei && target.getColuna() == source.getColuna() + 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() + 3);
			Position TargetT = new Position(source.getLinha(), source.getColuna() + 1);
			ChessPiece torre = (ChessPiece) board.removePiece(sourceT);
			board.placePiece(torre, TargetT);
			torre.increaseMoveCount();
		}
		// special move castling queen side rook
		if (p instanceof rei && target.getColuna() == source.getColuna() - 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() - 4);
			Position TargetT = new Position(source.getLinha(), source.getColuna() - 1);
			ChessPiece torre = (ChessPiece) board.removePiece(sourceT);
			board.placePiece(torre, TargetT);
			torre.increaseMoveCount();
		}

		return capturedPiece;
	}

	private void undoMove(Position source, Position target, piece captured) {
		ChessPiece p = (ChessPiece) board.removePiece(target);
		p.decreaseMoveCount();
		board.placePiece(p, source);
		if (captured != null) {
			board.placePiece(captured, target);
			capturedPieces.remove(captured);
			piecesOnTheBoard.add(captured);
		}
		// special move castling kingside rook
		if (p instanceof rei && target.getColuna() == source.getColuna() + 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() + 3);
			Position TargetT = new Position(source.getLinha(), source.getColuna() + 1);
			ChessPiece torre = (ChessPiece) board.removePiece(TargetT);
			board.placePiece(torre, sourceT);
			torre.decreaseMoveCount();
		}
		// special move castling queen side rook
		if (p instanceof rei && target.getColuna() == source.getColuna() - 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() - 4);
			Position TargetT = new Position(source.getLinha(), source.getColuna() - 1);
			ChessPiece torre = (ChessPiece) board.removePiece(TargetT);
			board.placePiece(torre, sourceT);
			torre.decreaseMoveCount();
		}
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}

	private Color opponent(Color color) {
		if (color == Color.WHITE) {
			return Color.BLACK;
		} else {
			return Color.WHITE;
		}

	}

	private ChessPiece rei(Color color) {
		List<piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color)
				.collect(Collectors.toList());
		for (piece p : list) {
			if (p instanceof rei) {
				return (ChessPiece) p;
			}
		}
		throw new IllegalStateException("Nao existe nenhuk rei da cor" + color);
	}

	private boolean testCheck(Color color) {
		Position PosicaoDoRei = rei(color).getChessPosition().toPosition();
		List<piece> opponentPieces = piecesOnTheBoard.stream()
				.filter(x -> ((ChessPiece) x).getColor() == opponent(color)).collect(Collectors.toList());
		for (piece p : opponentPieces) {
			boolean[][] mat = p.possibleMoves();
			if (mat[PosicaoDoRei.getLinha()][PosicaoDoRei.getColuna()]) {
				return true;
			}
		}
		return false;
	}

	private boolean testCheckMate(Color color) {
		if (!testCheck(color)) {
			return false;
		}
		List<piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color)
				.collect(Collectors.toList());
		for (piece p : list) {
			boolean[][] mat = p.possibleMoves();
			for (int i = 0; i < board.getLinha(); i++) {
				for (int j = 0; j < board.getColuna(); j++) {
					if (mat[i][j]) {
						Position source = ((ChessPiece) p).getChessPosition().toPosition();
						Position target = new Position(i, j);
						piece capturedPiece = makeMove(source, target);
						boolean testCheck = testCheck(color);
						undoMove(source, target, capturedPiece);
						if (!testCheck) {
							return false;
						}
					}

				}
			}
		}
		return true;
	}

	private void initialSetup() {
		placeNewPiece('a', 1, new torre(board, Color.WHITE));
		placeNewPiece('h', 1, new torre(board, Color.WHITE));
		placeNewPiece('b', 1, new Cavalo(board, Color.WHITE));
		placeNewPiece('c', 1, new bispo(board, Color.WHITE));
		placeNewPiece('d', 1, new Rainha(board, Color.WHITE));
		placeNewPiece('e', 1, new rei(board, Color.WHITE, this));
		placeNewPiece('f', 1, new bispo(board, Color.WHITE));
		placeNewPiece('g', 1, new Cavalo(board, Color.WHITE));
		placeNewPiece('a', 2, new peao(board, Color.WHITE,this));
		placeNewPiece('b', 2, new peao(board, Color.WHITE,this));
		placeNewPiece('c', 2, new peao(board, Color.WHITE,this));
		placeNewPiece('d', 2, new peao(board, Color.WHITE,this));
		placeNewPiece('e', 2, new peao(board, Color.WHITE,this));
		placeNewPiece('f', 2, new peao(board, Color.WHITE,this));
		placeNewPiece('g', 2, new peao(board, Color.WHITE,this));
		placeNewPiece('h', 2, new peao(board, Color.WHITE,this));

		placeNewPiece('a', 8, new torre(board, Color.BLACK));
		placeNewPiece('h', 8, new torre(board, Color.BLACK));
		placeNewPiece('b', 8, new Cavalo(board, Color.BLACK));
		placeNewPiece('c', 8, new bispo(board, Color.BLACK));
		placeNewPiece('d', 8, new Rainha(board, Color.BLACK));
		placeNewPiece('e', 8, new rei(board, Color.BLACK, this));
		placeNewPiece('f', 8, new bispo(board, Color.BLACK));
		placeNewPiece('g', 8, new Cavalo(board, Color.BLACK));
		placeNewPiece('a', 7, new peao(board, Color.BLACK,this));
		placeNewPiece('b', 7, new peao(board, Color.BLACK,this));
		placeNewPiece('c', 7, new peao(board, Color.BLACK,this));
		placeNewPiece('d', 7, new peao(board, Color.BLACK,this));
		placeNewPiece('e', 7, new peao(board, Color.BLACK,this));
		placeNewPiece('f', 7, new peao(board, Color.BLACK,this));
		placeNewPiece('g', 7, new peao(board, Color.BLACK,this));
		placeNewPiece('h', 7, new peao(board, Color.BLACK,this));
	}
}
