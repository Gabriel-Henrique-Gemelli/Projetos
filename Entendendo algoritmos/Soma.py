# e dessa maneira que faz uma funçao recursiva
def soma(Lista):
    if Lista == []:
        return 0
    else:
        return Lista[0] + soma(Lista[1:])

print(soma([1,2,4,5,6]))