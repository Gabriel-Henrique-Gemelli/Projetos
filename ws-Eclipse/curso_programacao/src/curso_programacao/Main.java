package curso_programacao;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(Soma(20,20));
		System.out.printf("%.2f%n",Divisao(14, 7.8));
		//Essa anotaçao diz o limite do numero de casas decimais
		System.out.println(Multiplicacao(50, 50));

	}
	
	
	public static int Soma(int num1,int num2) {
		
		return num1 + num2;
	}
	public static double Divisao(double num1, double num2) {
		
		return num1/num2;
	}
	public static int Multiplicacao(int num1,int num2) {
		return num1 * num2;
	}

}
