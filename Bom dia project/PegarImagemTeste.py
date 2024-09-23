import pyautogui as py 
import time
import keyboard

# Essas sao funçoes do pyautogui que vai ser mt util Que eu nao tinha nem ideia que existia
time.sleep(2)
while keyboard.is_pressed('q') == False:
    try:
        py.locateOnScreen('Assets\image.png',confidence=0.8, grayscale=True)
        time.sleep(0.5)
        print('Consigo ver')
            
    except:
        time.sleep(0.5)
        print('Nao consigo ver')