
import pyautogui as py
import random
import time
import keyboard

time.sleep(2)
foto = py.locateCenterOnScreen('Banana.png',confidence=0.7,grayscale=True)


while not keyboard.is_pressed('q'):
    time.sleep(random.uniform(0.01, 0.06))

    if foto:
        # Destructure the coordinates of the center of the image
        x, y = foto

        # Generate random offsets for x and y within a range
        x_offset = random.uniform(-20, 20)
        y_offset = random.uniform(-5, 30)

        # Perform a triple click at the randomized position
        py.tripleClick(x + x_offset, y + y_offset)