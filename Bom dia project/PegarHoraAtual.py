from datetime import datetime
import pyautogui as py 

def PegarHoraAtual():
    hora = datetime.now()
    hora_atualC = hora.strftime("%H")
    hora_atual = hora.strftime("%H:%M")
    hora_atualC = int(hora_atualC)
    
    
    if hora_atualC < 18 and hora_atualC >=13:
        print(f'Hora atual:{hora_atual}\n'
            'Boa tarde mestre')
        
    elif hora_atualC < 12 and hora_atualC >= 6 :
        print(f'Hora atual:{hora_atual}\n'
            'Bom dia mestre')
    elif hora_atualC == 12:
        print(f'Hora atual:{hora_atual}\n'
            'Meio dia mestre, vai comer porra.')        
    elif hora_atualC >= 19:
        print(f'Hora atual:{hora_atual}\n'
            'Boa noite mestre')
    else:
        print(f'Hora atual:{hora_atual}\n'
            'Boa madrugada mestre, mas uma duvida o que voce sta fazendo aqui essas horas da noite?.')