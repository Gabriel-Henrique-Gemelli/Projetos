from tkinter import *
from mercado import Produto
import datetime  
from random import *
import uuid
import json

data = datetime.date.today()

# data_formatada = f'{data.day}/{data.month}/{data.year}'
data_formatada = f'{randint(4,11)}/7/2024'

preco_compra = uniform(1.0,100.0)
id = str(uuid.uuid4())
produtos_mercado = ["Arroz", "Feijão", "Macarrão", "Açúcar", "Sal", "Óleo de cozinha"]
nome = choice(produtos_mercado)
quantidade_vendida = randint(0,1000)

class Application:
        def __init__(self, master=None):
                

                self.widget1 = Frame(master) #define a caixa principal
                self.widget1.pack() #condensa tudo dentro da caixa 
                self.msg = Label(self.widget1, text="O que deseja fazer hoje?") # o texto da caixa principal
                self.msg.pack()

                self.add = Button(self.widget1)
                self.add["text"] = "Add item ao banco "
                self.add["width"] = 20
                self.add["command"] = self.Nova_janela
                self.add.pack()                
                
                self.ler = Button(self.widget1) #adiciona o botao de fato
                self.ler["text"] = 'Banco de dados completo' #Adiciona o texto do botao
                self.ler["width"] = 20
                self.ler["command"] = lambda: Produto.Ler(self.widget1)
                self.ler.pack()

                self.Trinta = Button(self.widget1)
                self.Trinta["text"] = "Ultimos 30 dias"
                self.Trinta["width"] = 20
                self.Trinta["command"] = lambda: Produto.pegar_o_maior_valor(1, self.widget1)
                self.Trinta.pack()

                self.sete = Button(self.widget1)
                self.sete["text"] = "Ultimos 7 dias"
                self.sete["width"] = 20
                self.sete["command"] = lambda: Produto.pegar_o_maior_valor(2, self.widget1)
                self.sete.pack()

        def Nova_janela(self):
                self.nova_janela = Toplevel(self.widget1)
                self.nova_janela.geometry('400x250')
                self.fontePadrao = ("Arial", "10")

                self.primeiroContainer = Frame(self.nova_janela)
                self.primeiroContainer["pady"] = 10
                self.primeiroContainer.pack()

                self.segundoContainer = Frame(self.nova_janela)
                self.segundoContainer["pady"] = 10
                self.segundoContainer.pack()

                self.terceiroContainer = Frame(self.nova_janela)
                self.terceiroContainer["pady"] = 10
                self.terceiroContainer.pack()

                self.quartoContainer = Frame(self.nova_janela)
                self.quartoContainer["pady"] = 10
                self.quartoContainer.pack()

                self.quintoContainer = Frame(self.nova_janela)
                self.quintoContainer["pady"] = 10
                self.quintoContainer.pack()

                self.titulo = Label(self.primeiroContainer,text="Adicionar itens ao banco de dados")
                self.titulo["font"] = ("Arial", "10", "bold")
                self.titulo.pack()

                self.nome = Label(self.segundoContainer,text='Nome:')
                self.nome.pack(side=LEFT)

                self.nome_entry = Entry(self.segundoContainer)
                self.nome_entry.pack(side=LEFT)

                self.data_compra = Label(self.terceiroContainer,text='Data:')
                self.data_compra.pack(side=LEFT)

                self.entry_data_compra = Entry(self.terceiroContainer,)
                self.entry_data_compra.pack(side=LEFT)

                self.preco = Label(self.quartoContainer,text="preço compra")
                self.preco.pack(side=LEFT)

                self.entry_preco = Entry(self.quartoContainer)
                self.entry_preco.pack()


                self.Mandar_ao_banco = Button(self.quintoContainer)
                self.Mandar_ao_banco["text"] = "Enviar"
                self.Mandar_ao_banco["font"] = ("Calibri", "8")
                self.Mandar_ao_banco["width"] = 12
                self.Mandar_ao_banco["command"] = self.comandoDuplo
                self.Mandar_ao_banco.pack()

        def mandarAoBanco(self):
                nome = self.nome_entry.get()
                data_compra = self.entry_data_compra.get()
                preco_compra = float(self.entry_preco.get())
                dic = {
                        "uuid": id,
                        "nome": nome,
                        "data_compra": data_compra,
                        "preco_compra": round(preco_compra,2),
                        "preco_venda": round(preco_compra * 1.50,2),
                        "quantidade_vendida": 0
                }
                print(self.nome_entry.get())
                print(self.entry_data_compra.get())  
                print(self.entry_preco.get())              
                Produto.save(dic=dic)

        def comandoDuplo(self):
                self.mandarAoBanco()
                self.nova_janela.destroy()

                


root = Tk()
root.geometry('400x200')
Application(root)
root.mainloop()