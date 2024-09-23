import pyautogui as py
import keyboard

py.sleep(5)
start = py.locateCenterOnScreen('Assets\start.png', confidence=0.8)
py.click(start)    
while keyboard.is_pressed('q') == False:
    tecla = py.locateCenterOnScreen('Assets\PianoTiles.png', confidence=0.8)
    py.click(tecla)