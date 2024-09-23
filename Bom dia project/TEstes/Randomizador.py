import pyautogui as py
from pyautogui import sleep as s
import keyboard
from random import randint

while keyboard.is_pressed('q') == False:
    s(0.5)
    # py.press('win')
    py.moveTo(randint(0,py.size().width), randint(0,py.size().height),duration=1)