import pyautogui
from time import sleep as s

# Obtém a posição atual do cursor do mouse
s(5)
x, y = pyautogui.position()

print(f"A posição atual do mouse é: X={x}, Y={y}")
