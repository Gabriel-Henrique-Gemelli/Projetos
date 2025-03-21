package Aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		List<ChessPiece> captured = new ArrayList<>();

		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Origem: ");
				ChessPosition source = UI.readChessPosition(sc);

				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
				if (chessMatch.getPromoted() != null) {
					String type = sc.nextLine().toUpperCase();
					while (!type.equals("B") && !type.equals("C") && !type.equals("R") && !type.equals("T")) {
						System.out.print("Entre a peça para ser promovida(B,C,B,R): ");
						type = sc.nextLine().toUpperCase();
					}

					chessMatch.replacePromotedPiece(type);
				}
			} catch (ChessException e) {
				System.err.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.err.println(e.getMessage());
				sc.nextLine();
			}

		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}

}
