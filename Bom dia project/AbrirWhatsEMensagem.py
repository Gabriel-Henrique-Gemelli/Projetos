import pyautogui as py
from time import sleep as s
from datetime import date as data
from ParOuImpar import Par_impar
from EnviarOuNao import EnviarOuNao
from EscolherMensagem import MensagemAleatoria

dia = data.today().day
resultado = Par_impar(dia)

def Mensagem(opçao:int):
    if opçao == 0:
        EnviarOuNao(True)
        py.write(MensagemAleatoria())
    
    elif opçao == 1:
        EnviarOuNao(True)
        if resultado == "impar":
            py.write('bom dia meu amorrrrr')
        else:
            py.write('bom dia minha vidaaaaa')
        py.press('enter')
        s(0.5)
        py.write('tudo bem')
        py.hotkey('Alt','ctrl','w')
        py.press('enter')
        s(0.5)
        if resultado == "impar":
            py.write('Como foi a noite sem o meu amor')
            py.hotkey('Alt','ctrl','w')
        else:
            py.write('Sonhou com o que hoje')
            py.hotkey('Alt','ctrl','w')
        s(0.5)
        py.press('enter')
    elif opçao == 2:
        EnviarOuNao(True)
        py.write('bom dia meu amor')
        py.press('enter')
        py.write('tudo bem')
        py.hotkey('Alt','ctrl','w')
        py.press('enter')
    elif opçao == 3:
        EnviarOuNao(True)
        py.write('Bom dia')
        py.press('enter')
    elif opçao == 4:
        EnviarOuNao(False)
