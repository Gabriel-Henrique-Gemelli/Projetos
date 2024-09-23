from AbrirWhatsEMensagem import Mensagem
from AbrirOpera import opera 
from AbrirVS import vs
from AbrirSpotify import spotify
from AbrirJogo import AbrirJogo
from AbrirDS4 import AbrirDS4
from time import sleep as s
from AbrirZoom import AbrirZoom


def executar_acoes(acao:int, opcao:int, controle:bool,jogo:int,musica:int):
    # se ela for 1 vai ser jogar 
    if acao == 1:
        if controle == True:
            AbrirDS4()
            s(5)
        AbrirJogo(jogo)
        s(0.5)
        
    
    elif acao == 2:
        Mensagem(opcao)
        s(1)
        opera(False,False)
        s(1)
        spotify(musica)
        s(1)
        vs()
        s(1)
        
    elif acao == 3:
        spotify(musica)
        s(1)
        Mensagem(4)
        s(1)
        opera(True,False)

    elif acao == 4:
        Mensagem(opcao)
        opera(False,True)

    elif acao == 5:
        Mensagem(4)
    
    elif acao == 6:
        AbrirZoom(aula=opcao)

      



    # if opcao == 0:
    #     Mensagem(0)
    # elif opcao == 1:
    #     Mensagem(1)
    # elif opcao == 2:
    #     Mensagem(2)
    # elif opcao == 3:
    #     Mensagem(3)
    # elif opcao == 4:
    #     Mensagem(4)
    # s(2)
    # opera()
    # s(2)
    # vs() 
    # s(2)
    # spotify()
    # s(2)