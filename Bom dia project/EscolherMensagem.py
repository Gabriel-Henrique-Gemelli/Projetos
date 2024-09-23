import random
def MensagemAleatoria():        
    caminho_arquivo = 'Mensagens.txt'
    with open(caminho_arquivo, 'r') as arquivo:
        linhas = arquivo.readlines()
    mensagem_aleatoria = random.choice(linhas)
    return mensagem_aleatoria
