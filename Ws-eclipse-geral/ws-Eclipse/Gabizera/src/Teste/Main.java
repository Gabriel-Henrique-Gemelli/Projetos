package Teste;
import java.util.*;
import java.util.stream.Collectors;

// Interface para definir o comportamento de um aluguel de veículo
interface Alugavel {
    double calcularPreco(int dias);
}

// Classe abstrata que implementa a interface Alugavel
abstract class Veiculo implements Alugavel {
    protected String modelo;
    protected double precoPorDia;

    public Veiculo(String modelo, double precoPorDia) {
        this.modelo = modelo;
        this.precoPorDia = precoPorDia;
    }

    @Override
    public double calcularPreco(int dias) {
        return dias * precoPorDia;
    }

    public String getModelo() {
        return modelo;
    }
}

// Carro econômico
class CarroEconomico extends Veiculo {
    public CarroEconomico(String modelo) {
        super(modelo, 50.0);
    }
}

// Carro de luxo
class CarroLuxo extends Veiculo {
    public CarroLuxo(String modelo) {
        super(modelo, 200.0);
    }
}

// Classe genérica para armazenar veículos
class Locadora<T extends Veiculo> {
    private Set<T> veiculosDisponiveis = new HashSet<>();
    private Map<String, Double> historicoAlugueis = new HashMap<>();

    public void adicionarVeiculo(T veiculo) {
        veiculosDisponiveis.add(veiculo);
    }

    public void alugarVeiculo(String cliente, T veiculo, int dias) {
        if (veiculosDisponiveis.contains(veiculo)) {
            double preco = veiculo.calcularPreco(dias);
            historicoAlugueis.put(cliente, preco);
            veiculosDisponiveis.remove(veiculo);
            System.out.println(cliente + " alugou " + veiculo.getModelo() + " por " + dias + " dias. Total: R$" + preco);
        } else {
            System.out.println("Veículo não disponível.");
        }
    }

    public void listarVeiculosDisponiveis() {
        veiculosDisponiveis.forEach(v -> System.out.println("Disponível: " + v.getModelo()));
    }

    public void mostrarHistorico() {
        historicoAlugueis.forEach((cliente, preco) ->
                System.out.println(cliente + " gastou R$" + preco));
    }
}

public class Main {
    public static void main(String[] args) {
        Locadora<Veiculo> locadora = new Locadora<>();

        CarroEconomico carro1 = new CarroEconomico("Fiat Uno");
        CarroLuxo carro2 = new CarroLuxo("BMW X6");

        locadora.adicionarVeiculo(carro1);
        locadora.adicionarVeiculo(carro2);

        locadora.listarVeiculosDisponiveis();

        locadora.alugarVeiculo("João", carro1, 3);
        locadora.alugarVeiculo("Maria", carro2, 2);

        System.out.println("\nHistórico de aluguéis:");
        locadora.mostrarHistorico();
    }
}
