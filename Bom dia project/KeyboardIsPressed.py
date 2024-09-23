import keyboard

while keyboard.is_pressed('q') == False:
    print('Nao esta sendo precionado')
    if keyboard.is_pressed('q') == True:
        print('pressionado')