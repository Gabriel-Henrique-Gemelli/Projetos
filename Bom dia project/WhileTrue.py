import pyautogui as py 

def Find_And_click(endereco:str):
    if endereco == 'Assets/ImagemGigaChad.png':
        Tentativa = 0
        while Tentativa < 6:
            Tentativa = Tentativa + 1
            try:
                py.sleep(1)
                perfil = py.locateCenterOnScreen(endereco, confidence=0.8, grayscale=True)
                py.moveTo(perfil,duration=1)
                py.click()
                break
            except:
                print(f'tentando {Tentativa} vezes')
                if Tentativa == 6:
                    print('Steam ja aberta continuando...')
                    pass
    else:
        while True:
            try:
                Imagem = py.locateCenterOnScreen(endereco, grayscale=True, confidence=0.8)
                py.sleep(0.5)
                py.moveTo(Imagem,duration=0.5)
                py.sleep(0.5)
                py.click()
                break
            except:
                print('tentando denovo')
                py.sleep(1)

