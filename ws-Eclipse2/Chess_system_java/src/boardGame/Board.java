package boardGame;

public class Board {
	private int linhas;
	private int colunas;
	private piece[][] peças;

	public Board(int linha, int coluna) {
		if (linha < 1 || coluna < 1) {
			throw new boardException("Erro criando tabuleiro e necessario que esteja pelo menos 1 linha e 1 coluna");
		}
		this.linhas = linha;
		this.colunas = coluna;
		peças = new piece[linha][coluna];
	}

	public int getLinha() {
		return linhas;
	}

	public int getColuna() {
		return colunas;
	}

	public piece piece(int linha, int coluna) {
		if (!positionExists(linha, coluna)) {
			throw new boardException("Posiçao nao e valida");
		}
		return peças[linha][coluna];
	}

	public piece piece(Position position) {
		if (!positionExists(position)) {
			throw new boardException("Posiçao nao e valida");
		}
		return peças[position.getLinha()][position.getColuna()];
	}

	public void placePiece(piece piece, Position position) {
		if (ThereIsAPiece(position)) {
			throw new boardException("Ja tem uma peça nessa posiçao");
		}
		peças[position.getLinha()][position.getColuna()] = piece;
		piece.position = position;
	}

	public piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new boardException("Posiçao nao existe no tabuleiro");
		}

		if (piece(position) == null) {
			return null;
		}

		piece aux = piece(position);
		aux.position = null;
		peças[position.getLinha()][position.getColuna()] = null;
		return aux;
	}

	public boolean positionExists(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getLinha(), position.getColuna());
	}

	public boolean ThereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new boardException("Posiçao nao e valida");
		}
		return piece(position) != null;

	}

}
