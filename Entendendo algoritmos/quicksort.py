import time
def quicksort(lista):
    if len(lista) < 2:
        return lista
    else:
        pivo = lista[len(lista)//2] #len(lista)//2

        menor= [i for i in lista[1:] if i <= pivo]
        maior = [i for i in lista[1:] if i > pivo]

    return quicksort(menor) + [pivo] + quicksort(maior)

import random

# Gerar uma lista com 996 números únicos entre 1 e 1000
lista = random.sample(range(1, 1001), 996)

inicio = time.time()

funçao = quicksort(lista)

final = time.time()
print(f"resultado{funçao}\n tempo:{final - inicio:.5f}") 