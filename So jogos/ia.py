import pyautogui as py
import time

a = int(input("Digite o numero de vezes que vai ser digitado"))
b = str(input("Digite a fase a ser digitada"))
c = 0
time.sleep(5)
for i in range(a):
    py.write(b)
    py.press("enter")
