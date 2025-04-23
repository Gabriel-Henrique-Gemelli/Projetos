package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		/*
		 * representa um conjunto de elementos(Similar ao da algebr) Nao admite
		 * repetiçoes Elementos nao possuem posiçao Acesso inserçao e remoçao de
		 * elementos sao rapidos Oferece operaçoes eficientes de conjuntos: interseçao,
		 * uniao, diferença pricipais implementaçoes: hashSet: mais rapido(OperaçoesO(1)
		 * em tabela hash) e nao ordenados TreeSet: mais lento(operaçoes O(log(n)) em
		 * arvore rubro-negra) e ordenado pelo compareTo do object(Ou comparator) ele
		 * ordena a lista tambem LinkedHashSet:velocidade intermediaria e elementos na
		 * ordem em que sao adicionados
		 */

		Set<String> set = new HashSet<>();
		Set<String> set2 = new TreeSet<>();
		Set<String> set3 = new LinkedHashSet<>();

		set2.add("TV");
		set2.add("Notebook");
		set2.add("Tablet");
		
		

		System.out.println(set2.contains("Notebook"));

		set2.removeIf(x -> x.charAt(0) == 'T');
		for (String p : set2) {
			System.out.println(p);
		}

	}

}
