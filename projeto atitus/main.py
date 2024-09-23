from funcoes import limparTela, aguarde, lerinteiro, lerstring

while True:
    limparTela()
    print("hackday - inscriçoes")
    print("(0) para sair ")
    print("(1) nova inscriçao")
    print("(2) lista de inscritos")
    opçao = input()
    if opçao == "0":
        break
    elif opçao == "1":
        print("informe os dados abaixo para uma nova inscriçao")
        nome = lerstring("Nome: ")
        ra = lerinteiro("RA: ")
        arquivo = open("bd.atitus","a")
        arquivo.write(nome+ "-" + str(ra)+ "\n")
        arquivo.close()
        print("dados salvos!")
        aguarde(2)


        
        
    elif opçao == "2":
        arquivo = open("bd.atitus","r")#r-read w-write sempre limpando a-append
        dados = arquivo.read()
        print(dados)
        
        arquivo.close()
        aguarde(5)
    else:
        print("opçao invalida")
        aguarde(2)