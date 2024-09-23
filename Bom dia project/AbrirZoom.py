import pyautogui as py
from pyautogui import sleep as s
import keyboard
import pyperclip
import WhileTrue


def AbrirZoom(aula:int):
    # 1 == segundo 2 == terca 3 == quarta == 4 sexta
    if aula == 1:
        url = "https://us06web.zoom.us/j/9738995268?omn=81978505089"
    elif aula == 2:
        url = "https://us06web.zoom.us/j/7902299377"
    elif aula == 3:
        url = "https://us06web.zoom.us/j/85727170594?pwd=OzbHHLO1kweTnma9E2gLEYPQa3ZXAL.1"
    elif aula == 4:
        url = "https://us06web.zoom.us/j/82862809890?pwd=m1ZaHRVb7LbOe4IHsQhnjSXOzsQxkf.1"
    s(0.5)
    py.press('win')
    s(1)
    py.write('Zoom Workplace')
    s(0.5)
    py.press('enter')

    WhileTrue.Find_And_click('Assets/Join_Button.png')
    WhileTrue.Find_And_click('Assets\TurnOff_Button.png')
    WhileTrue.Find_And_click('Assets\Meeting.png')
    # TurnOff_button =py.locateCenterOnScreen('Assets\TurnOff_Button.png', grayscale=True, confidence=0.8)
    # py.moveTo(TurnOff_button,duration=0.5)
    # py.click()
    # s(1)
    # Meeting =py.locateCenterOnScreen('Assets\Meeting.png', grayscale=True, confidence=0.8)
    # py.moveTo(Meeting,duration=0.5)
    # py.click()
    pyperclip.copy(url)
    py.hotkey('ctrl', 'v')
    s(0.5)
    WhileTrue.Find_And_click('Assets\EntrarChamada.png')
    # EntrarNaChamada =py.locateCenterOnScreen('Assets\EntrarChamada.png', grayscale=True, confidence=0.8)
    # py.moveTo(EntrarNaChamada,duration=0.5)
    # py.click()
    while True:
            try:
                JoinWithAudio =py.locateCenterOnScreen('Assets\JoinWithAudio.png', grayscale=True, confidence=0.8)
                py.moveTo(JoinWithAudio,duration=0.5)
                py.click()
                s(0.5)
                Audio =py.locateCenterOnScreen('Assets\Audio.png', grayscale=True, confidence=0.8)
                py.moveTo(Audio,duration=0.5)
                py.click()
                break
            except:
                print('Nao achei a foto, tentando denovo...')
                s(1)
        #TODO Feito 