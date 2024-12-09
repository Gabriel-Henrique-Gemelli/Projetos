#isso se chama a pilha de chamada com repercurçao 

def fac(x):
    if x == 1:
        return 1
    else:
        return x * fac(x -1)

print(fac(996))