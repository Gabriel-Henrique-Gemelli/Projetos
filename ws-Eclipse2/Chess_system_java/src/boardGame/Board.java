package boardGame;

public class Board {
	private int linha;
	private int coluna;
	private piece [][] peças;
	
	public Board(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		peças = new piece[linha] [coluna];
	}
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	


}
