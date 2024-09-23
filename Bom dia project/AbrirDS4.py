import pyautogui as py
from time import sleep as s 

def AbrirDS4():
    py.press('win')
    s(0.5)
    py.write('aplicativos: DS4Windows.exe')
    s(0.5)
    py.press('enter')
    