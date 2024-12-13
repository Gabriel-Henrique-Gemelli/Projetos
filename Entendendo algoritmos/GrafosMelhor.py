from collections import deque

def pessoa_e_vendedor(nome):
    return nome[-1] == "a"

def pesquisar_vendedor(grafo):
    Fila_Pesquisa = deque()
    Fila_Pesquisa += grafo["eu"]
    verificadas = set()  # Conjunto para rastrear pessoas já verificadas
    
    while Fila_Pesquisa:
        pessoa = Fila_Pesquisa.popleft()
        if pessoa not in verificadas:  # Verifica se já foi processado
            if pessoa_e_vendedor(pessoa):
                print(f"{pessoa} é um vendedor")
                return True
            else:
                print(f"{pessoa} não é um vendedor de manga")
                verificadas.add(pessoa)  # Marca como verificado
                if pessoa in grafo:  # Adiciona os vizinhos apenas se existirem
                    Fila_Pesquisa += grafo[pessoa]
    return False

grafo = {
    "eu": ["alice", "bob", "jonas"],
    "alice": ["Augusto"],
    "bob": ["Ze"],
    "jonas": ["Senhor armandinha"]
}

pesquisar_vendedor(grafo)