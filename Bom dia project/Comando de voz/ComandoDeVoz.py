
import speech_recognition as sr
import os 
import pyttsx3

engine = pyttsx3.init()


def açoes(text:str):
    if 'abrir' in text.lower():
        if 'opera' in text.lower():
            os.startfile('C:/Users/gabif/AppData/Local/Programs/Opera GX/launcher.exe')
        elif 'github' or 'kit' or 'rubi' in text.lower():
            os.startfile('C:/Users/gabif/AppData/Local/GitHubDesktop/GitHubDesktop.exe')        
    elif 'assitir' in text.lower():
        if 'hbo' or 'max' in text.lower():
            os.startfile('https://play.max.com')
        elif 'netflix' in text.lower():
            os.startfile('https://www.netflix.com/browse')

def reconhecer_fala():
    recognizer = sr.Recognizer()
    with sr.Microphone() as source:
        falar('Olá')

        try:
            recognizer.adjust_for_ambient_noise(source)
            audio = recognizer.listen(source)
            text = recognizer.recognize_google(audio, language='pt-BR')
            print(f'Voce disse {text}')
            açoes(text)
        except sr.UnknownValueError:
            falar("Não entendi o que você disse. Tente novamente.")
        except sr.RequestError as e:
            falar(f"Erro na solicitação do serviço de reconhecimento; {e}")
        except KeyboardInterrupt:
            falar("Interrupção manual pelo usuário.")
        


def falar(texto):
    engine.say(texto)
    engine.runAndWait()

def apresentaçao():
    print('Iniciando o Sistema. Sistema 100% carregado e operando. Olá Me chamo Jarvis.')
    # falar('Iniciando o Sistema. Sistema 100% carregado e operando. Olá Me chamo Jarvis.')


apresentaçao()
reconhecer_fala()




# import speech_recognition as sr
# import os
# import pyautogui as py

# rec = sr.Recognizer()

# def process_command(text):
#     if 'caminhar' in text.lower():
#         py.keyDown('w')
#         py.sleep(2)
#         py.keyUp('w')
#     if 'pular' in text.lower():
#         py.keyDown('space')
#         py.sleep(2)
#         py.keyUp('space')
#     if 'saltar' in text.lower():
#         py.keyDown('w')
#         py.keyDown('space')
#         py.keyUp('space')
#         py.sleep(2)
#         py.keyUp('w')

# def main():
#     with sr.Microphone(1) as mic:
#         rec.adjust_for_ambient_noise(mic)
#         print("Comece a falar que o python vai gravar")
        
#         while True:
#             try:
#                 print("Escutando...")
#                 audio = rec.listen(mic)
#                 text = rec.recognize_google(audio, language='pt-BR')
#                 print(f'Você disse: {text}')
                
#                 process_command(text)
                
#                 if 'sair' in text.lower():
#                     print("Encerrando o programa.")
#                     break
#                 return
#             except sr.UnknownValueError:
#                 print("Não entendi o que você disse. Tente novamente.")
#             except sr.RequestError as e:
#                 print(f"Erro na solicitação do serviço de reconhecimento; {e}")
#             except KeyboardInterrupt:
#                 print("Interrupção manual pelo usuário.")
#                 break
# main()















# import speech_recognition as sr
# import os
# import pyautogui as py

# rec = sr.Recognizer()
# text = ''
# with sr.Microphone(2) as mic:
#     rec.adjust_for_ambient_noise(mic)
#     print("Comece a falar que o python gravar")
#     audio = rec.listen(mic)
#     text = rec.recognize_google(audio,language='pt-BR')

#     # if 'Opera' or 'Ópera' or 'ópera' or 'opera' in text:
#     #     os.system('start opera')
        
#     if 'caminhar' in text:
#         py.keyDown('w')
#         py.sleep(2)
#         py.keyUp('w')
#     if 'pular' in text:
#         py.keyDown('space')
#         py.sleep(2)
#         py.keyUp('space')

#     if 'saltar' in text:
#         py.keyDown('w')
#         py.keyDown('space')
#         py.keyUp('space')
#         py.sleep(2)
#         py.keyUp('w')

# print(f'Voce disse isso:{text}')