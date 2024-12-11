
def verificarVotaçao(nome):

    voted = {}
    if voted.get(nome):
        print('Mande embora')
    else:
        voted[nome] = True
        print('deixe votar')

