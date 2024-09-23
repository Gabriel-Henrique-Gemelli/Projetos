import pyautogui as py
from time import sleep as s

def EnviarOuNao(Enviar:bool):
    py.press('win')
    s(0.5)
    py.write('whatsapp')
    s(0.5)
    py.press('enter')
    s(3)
    if Enviar == True:
        try:
            Imagem_ana = py.locateCenterOnScreen('Assets\FotoAna.png', grayscale=True, confidence=0.8)
            s(0.5)
            py.moveTo(Imagem_ana,duration=0.5)
            s(0.5)
            py.click()
            s(0.5)
        except:
            py.alert(title="Erro!", text="Nao foi possivel achar a foto",button='Show' )
    else:
        return