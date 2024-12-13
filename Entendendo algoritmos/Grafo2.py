from collections import deque

def pessoa_e_vendedor(nome):
    return nome[-1] == "a"

def pesquisa(grafo):
    fila_de_pesquisa = deque()
    fila_de_pesquisa += grafo["eu"]
    verficadas = []
    while fila_de_pesquisa:
        pessoa = fila_de_pesquisa.popleft()
        if not pessoa in verficadas:
            if pessoa_e_vendedor(pessoa):
                print(f"{pessoa} e um vendedor")
                return True
            else:
                if pessoa in grafo:
                    fila_de_pesquisa += grafo[pessoa]
                verficadas.append(pessoa)
    return False

grafo = {
    "eu": ["alice", "bob", "jonas"],
    "alice": ["Augusto"],
    "bob": ["Ze"],
    "jonas": ["Senhor armandinho"],
    "Senhor armandinho": ["juliana"]
}

pesquisa(grafo)