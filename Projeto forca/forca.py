# Nome: Gabriel Henrique Gemelli 
# RA: 1134947
from funçoes import limpartela, aguarde

tentativas = 0

chances = 0

letra_escolhida = []

while True:
    limpartela()
    print("seja bem vindo ao jogo da forca")
    print("precione (0) para sair ")
    print("precione (1) para jogar")
    print("precione (2) para ver o historico de jogos")
    opçao = input()
    if opçao == "0":
        break
    
    
    
    elif opçao == "1":
        
        limpartela()
        print("introduçao.\nprimeiro voce deve escolher uma dificuldade.")
        print("facil: (0)")
        print("medio: (1)")
        print('dificil: (2)')
        dificuldade = input()
        if dificuldade == "0":
            chances = 8
        elif dificuldade == "1":
            chances = 6
        elif dificuldade == "2":
            chances = 4
        
        limpartela()
        print("agora voce devera me dizer o nome do desafiante e o nome do competidor.")
        nome_desafiante = str(input("nome do desafiante: "))
        nome_competidor = str ( input("nome do competidor: "))
        
        limpartela()
        print("agora digame qual e a palavra chave desejada:")
        palavra_escolhida = str(input("digite a palavra chave: "))
        
        limpartela()
        print('agora digame 3 dicas para ajuda o jogador a descobrir a palavra')
        dica_1 = str(input('dica 1: '))
        dica_2 = str(input('dica 2: '))
        dica_3 = str(input('dica 3: '))
        mostra_dica = ['', dica_1,dica_2,dica_3]
        numero_dica = 0
        letra_anterior = ''
        limpartela()
       


        estado_atual = ["*"] * len(palavra_escolhida)
        
        

        while tentativas < chances and "".join (estado_atual) != palavra_escolhida:
            
            print(f'Palavra: {"".join(estado_atual)}')
            print(f"dicas:{mostra_dica[numero_dica]} ")
            print(f"qual letra voce ja tentou:{', '.join(letra_escolhida)} ")
            print(f"voce ja fez {tentativas} tentativas erradas voce ainda tem {chances - tentativas} chances.")
            letra = input("digite uma letra: ")
            limpartela()
            
            if letra == letra_anterior:
                if letra == '1':
                    print('voce deve jogar antes de solicitar outra dica')
                    continue
                else:
                    print('voce ja jogou essa letra')
                    continue
            else:
                letra_anterior = letra
                


            if letra == '1'and numero_dica < 3:
                numero_dica = numero_dica + 1
                continue
        
            if letra == '1':
                continue
            letra_escolhida.append(letra)

            if letra in palavra_escolhida:
                print("parabens voce acertou a letra\n")
                for i in range(len(palavra_escolhida)):
                    if letra == palavra_escolhida[i]:
                        estado_atual[i] = letra
                        
            else:
                print("infelizmente voce errou\n ")
                    
                if letra == "1" and "2" and "3":
                    tentativas = tentativas
                else:
                    tentativas = tentativas + 1
                    
        if tentativas == chances:
            limpartela()
            jogador_vence = (f"o(a) competidor(a) {nome_competidor} perdeu na dificuldade {dificuldade} e o(a) desafiante {nome_desafiante} venceu, e a palavra chave era {palavra_escolhida} \n")
            print(jogador_vence)
            arquivo = open("historico.txt",'a')
            arquivo.write(jogador_vence)

            arquivo.close()
            aguarde(5)
            
            break
            
        else:
            limpartela()
            jogador_perde = (f"o(a) competidor(a) {nome_competidor} venceu na dificuldade {dificuldade} e o(a) desafiante  {nome_desafiante} perdeu, e a palavra chave era {palavra_escolhida}\n")
            print(jogador_perde)
            arquivo = open("historico.txt",'a')
            arquivo.write(jogador_perde)  
            
            arquivo.close()
            aguarde(5)
            break    
                
            
        
    elif opçao == "2":
        limpartela()
        arquivo = open("historico.txt",'r')
        dados = arquivo.read()
        print("o historico de partidas e \n", dados)

        arquivo.close()
     
        break
    else:
        print('opçao invalida')       



