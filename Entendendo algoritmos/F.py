import pyautogui
import keyboard
 
print("Segurando a tecla 'F'. Pressione a barra de espaço para parar.")

try:
    
    while not keyboard.is_pressed('space'):
        pyautogui.keyDown('f')  # Mantém a tecla 'F' pressionada
        pass  # Aguarda até que a barra de espaço seja pressionada
finally:
    pyautogui.keyUp('f')  # Libera a tecla 'F'
    print("\nTecla 'F' liberada. Programa encerrado.")