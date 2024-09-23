import pyautogui as py
from time import sleep as s
import pyperclip

def opera(facul:bool, entreterimento:bool):
    py.press('win')
    s(0.5)
    py.write('opera')
    py.press('enter')
    s(2)
    if facul == True:
        py.hotkey('ctrl','t')
        s(0.5)
        pyperclip.copy('Atitus.edu.br/acesso-do-aluno')
        py.hotkey('ctrl','v')
        py.press('enter')
        s(3)
        ava = py.locateCenterOnScreen('Assets\Ava.png', grayscale=True, confidence=0.8)
        s(0.5)
        py.moveTo(ava,duration=0.5)
        s(0.5)
        py.click()
        s(1)
        EntrarAtitus = py.locateCenterOnScreen('Assets\EntrarAtitus.png', grayscale=True, confidence=0.8)
        s(0.5)
        py.moveTo(EntrarAtitus,duration=0.5)
        s(0.5)
        py.click()
        s(2)
        Disciplinas = py.locateCenterOnScreen('Assets\Disciplinas.png', grayscale=True, confidence=0.8)
        s(0.5)
        py.moveTo(Disciplinas,duration=0.5)
        s(0.5)
        py.click()
        s(0.5)

    if entreterimento == True:
        py.hotkey('ctrl','t')
        s(0.5)
        pyperclip.copy('https://play.max.com')
        py.hotkey('ctrl', 'v')
        py.press('enter')

    if facul == False and entreterimento == False:
        py.hotkey('ctrl','t')
        s(0.5)
        pyperclip.copy('https://chatgpt.com')
        py.hotkey('ctrl', 'v')
        py.press('enter')