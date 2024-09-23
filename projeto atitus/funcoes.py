import os
import time 

def limparTela():
    os.system("cls")

def aguarde(segundos=1):
    time.sleep(segundos)

def lerinteiro(mensagem):
    while True:
        try:
            variavel = int(input(mensagem))
            return variavel
        except:
            print("valor informado incorretamente")



def lerstring(mensagem):
    while True:
        variavel = input(mensagem)
        if len(variavel)>1:
            return variavel
        else:
            print("valor informado invalido")
