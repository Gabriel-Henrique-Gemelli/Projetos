package HashCodes_Equals;

public class Program {

	public static void main(String[] args) {
		
		// hashCode e equals, sao operaçoes da classe object utilizadas para comparar se um objeto e igual o outro
		
		// Equals: lento, porem a resposta e 100%
		// hashCode: rapido porem a resposta nao e 100%
		
		
		String a = "Maria";
		String b = "Lanche";
		//System.out.println(a.equals(b));
		// essa equaçao compara o valor de a com o valor de b
		String c = "Maria";
		String d = "Lanche";
		// fazendo assim o compilador usa um tratamento especial e retorna True se for comparado.
		String s1 = "teste";
		String s2 = "teste";
		//System.out.println(c.hashCode());
		//System.out.println(d.hashCode());
		// esse metodo pode dar errado pois existe uma mera coincidencia de os numeros gerados forem os mesmo para valores diferentes.
		// se os hashcode de dois objetos for diferente entao os dois objetos sao diferentes, e o contrtario tambem e verdadeiro
		
		Client c1 = new Client(a, b);
		Client c2 = new Client(c, d);
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1.equals(c2));
		// se fizer assim ekle vai se basear na classe e nao no conteudo, pois a refeerencia de memoria deles e diferente.
		System.out.println(c1 == c2);
		

	}

}
