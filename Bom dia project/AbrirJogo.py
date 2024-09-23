import pyautogui as py
from time import sleep as s
import WhileTrue

def AbrirJogo(opçao):
    py.press('win')
    s(0.5)
    if opçao == 1:
        py.write('LEGO MARVEL Super Heroes')

    elif opçao == 2:
        py.write('Fallout 4')


    elif opçao == 3:
        py.write('League of legends')
        s(0.5)
    py.press('enter')
    
    

    if opçao == 3:
        WhileTrue.Find_And_click("Assets\JogarLol.png")    
    
    else:
        WhileTrue.Find_And_click('Assets/ImagemGigaChad.png')
        if opçao == 2:
            WhileTrue.Find_And_click("Assets\FalloutJogar.png")