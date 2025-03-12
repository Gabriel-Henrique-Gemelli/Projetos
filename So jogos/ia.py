import cv2
import numpy as np
import pyautogui
import time
import mss

# Defina a região onde o jogo está rodando na tela (ajuste esses valores conforme necessário)
GAME_REGION = {"top": 250, "left": 500, "width": 400, "height": 300}

# Função para capturar a tela
def capture_screen():
    with mss.mss() as sct:
        screenshot = np.array(sct.grab(GAME_REGION))
        return cv2.cvtColor(screenshot, cv2.COLOR_BGRA2BGR)

# Função para detectar a inclinação do pêndulo
def get_pole_angle(image):
    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    edges = cv2.Canny(gray, 50, 150)
    
    lines = cv2.HoughLinesP(edges, 1, np.pi / 180, 50, minLineLength=50, maxLineGap=10)
    
    if lines is not None:
        for line in lines:
            x1, y1, x2, y2 = line[0]
            angle = np.arctan2(y2 - y1, x2 - x1) * 180 / np.pi
            return angle
    
    return 0  # Se não encontrar linha, assume-se que está reto

# Função para enviar comandos de controle
def control_cart(angle):
    threshold = 5  # Define um limite para evitar ações desnecessárias

    if angle > threshold:  
        pyautogui.press("left")  # Pressiona a seta esquerda se o pêndulo estiver caindo para a direita
    elif angle < -threshold:  
        pyautogui.press("right")  # Pressiona a seta direita se o pêndulo estiver caindo para a esquerda

# Loop principal do jogo
time.sleep(3)  # Tempo para você abrir o jogo

while True:
    frame = capture_screen()
    angle = get_pole_angle(frame)

    print(f"Inclinação detectada: {angle:.2f}")
    control_cart(angle)

    cv2.imshow("Jogo", frame)  # Mostrar o jogo para depuração
    if cv2.waitKey(1) & 0xFF == ord("q"):  # Pressione 'q' para sair
        break

cv2.destroyAllWindows()
