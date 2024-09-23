import pyautogui as py
from time import sleep as s

def spotify(musica:int):
    Devil = 'Feeding the devil'
    Foda = 'So as f'
    zeldinha = 'zeldinha pra jogar tryhard'
    py.press('win')
    s(0.5)
    py.write('spotify')
    s(0.5)
    py.press('enter')
    # py.press('enter')
    # 1 == Feeding the devil \n'
    #'2 == So as foda\n'
    #'3 == Zeldinha para estudos\n',
    while True:
        s(5)
        try:
            if musica == 1:
                FeedingTheDevil = py.locateCenterOnScreen('Assets\FeedingTheDevil.png', grayscale=True, confidence=0.8)
                s(0.5)
                py.moveTo(FeedingTheDevil,duration=0.5)
                s(0.5)
                py.click()
            elif musica == 2:
                SoAsFoda = py.locateCenterOnScreen('Assets\FeedingTheDevil.png', grayscale=True, confidence=0.8)
                s(0.5)
                py.moveTo(SoAsFoda,duration=0.5)
                s(0.5)
                py.click()
            elif musica == 3:
                ZeldinhaFoto = py.locateCenterOnScreen('Assets\Zeldinha.png', grayscale=True, confidence=0.8)
                s(0.5)
                py.moveTo(ZeldinhaFoto,duration=0.5)
                s(0.5)
                py.click()
            break
        except:
            print('Nao achei a imagem, buscando a playlist')   
            #TODO Se der erro quer dizer que ele nao acho ewntao vai procurar na lupa
            loopa = py.locateCenterOnScreen('Assets\LoopaSpotify.png', grayscale=True, confidence=0.8)
            s(0.5)
            py.moveTo(loopa,duration=0.5)
            s(0.5)
            py.click() 
            s(1)
            if musica == 1:
                py.write(Devil)
            elif musica == 2:
                py.write(Foda)
            elif musica == 3:
                py.write(zeldinha)
            s(3)
            py.click(436,405, duration=0.5)
            break

    while True:
        try:
            py.locateCenterOnScreen('Assets\MusicaAleatoria.png',confidence=0.9)
            break  
        except:
            s(0.5)
            py.click(277,538, duration=0.5)
    
    # Play = py.locateCenterOnScreen('Assets\PlaySpotify.png', grayscale=True, confidence=0.8)
    # s(0.5)
    # py.moveTo(Play,duration=0.5)
    # s(0.5)
    # py.click() 