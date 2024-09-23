from ExecutarAcoes import executar_acoes 
from os import system
import pyautogui as py 

system('cls')
opcao, controle, acao,jogo,musica = int,bool,int,int,int


acao = int(py.prompt(text='O que voce deseja fazer hoje?\n'
                    '1 == Jogar\n'
                    '2 == trabalhar no vscode\n'
                    '3 == Trabalho da faculdade\n'
                    '4 == fazer as joias/entreterimento\n'
                    '5 == Nao tenho certeza\n'
                    '6 == Aula do zoom\n',
                    title='Ação!'))
if acao == 1:
    system('cls')
    jogo =int(py.prompt(text='Qual jogo deseja jogar no momento?\n'
                '1 == LEGO® MARVEL Super Heroes\n'
                '2 == Fallout 4\n'
                '3 == League of Legends\n',
                title='Jogo!' ))
    if jogo == 1 or jogo == 2:
        system('cls')
        controle = bool(py.confirm(text='Deseja jogar com o controle?', title='Controle!', buttons=['Sim', 'Não']))
  
    
if acao == 2 or acao == 3 or acao == 4:
    system('cls')
    opcao = int(py.prompt(text='como está se sentindo atualmente?\n'
                    '0 == Mensagem aleatoria\n'
                    '1 == Super feliz\n'
                    '2 == médio\n'
                    '3 == seco\n'
                    '4 == nenhuma mensagem\n',
                    title='Mensagem!'))
    
if acao == 2 or acao == 3: 
    musica = int(py.prompt(text='Que musica gostaria de escutar hoje\n'
                    '1 == Feeding the devil \n'
                    '2 == So as foda\n'
                    '3 == Zeldinha para estudos\n',
                    title='Musica!'))
if acao == 6:
    system('cls')
    opcao = int(py.prompt(text='Qual aula ira fazer hoje?\n'
                      '1 == segunda-feira\n'
                      '2 == terca-feira\n'
                      '3 == quarta-feira\n'
                      '4 == sexta-feira\n',
                      title='Aula!'))

executar_acoes(acao,opcao, controle,jogo,musica)
# o que deseja fazer hoje, jogar?, abrir o riva turner e o msi after burn Logo apos abrir o jogo , entreterimento? abrir o opera e digitar hbo ou qualquer outra coisa
# TODO açao de escolher qual musica quer escutar hoje 