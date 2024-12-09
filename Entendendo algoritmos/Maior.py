# assim e de uma maneira normal

def encontrarMaior(lista:list):
    ValorMaior = 0
    if lista == []:
        return 0
    else:
        for x in lista:
            if x > ValorMaior:
                ValorMaior = x

    return ValorMaior

# print(encontrarMaior([45, 78, 23, 56, 12, 89, 34, 67, 90, 54, 32, 88, 76, 43, 21, 19, 72, 80, 66, 100])) 

# Agora utilizando uma funçao repercursiva
def maximo(lista):
    if len(lista) == 2:
        if lista[0] > lista[1]:
            return lista[0]
        else:
            return lista[1]
    else:
        subMax = maximo(lista[1:])
        if lista[0] > subMax:
            return lista[0]
        else:
            return subMax 

        
print(maximo([45, 78, 23, 56, 12, 89, 34, 67, 90, 54, 32, 88, 76, 43, 21, 19, 72, 80, 66, 100]))