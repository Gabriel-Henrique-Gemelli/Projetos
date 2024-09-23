import json
from datetime import datetime,timedelta
import os
from tkinter import *

def add_mouse_scroll(widget):
    def on_mouse_wheel(event):
        widget.yview_scroll(int(-1*(event.delta/120)), "units")

    widget.bind_all("<MouseWheel>", on_mouse_wheel)
    widget.bind_all("<Button-4>", on_mouse_wheel)
    widget.bind_all("<Button-5>", on_mouse_wheel)

class Produto:
    filename = "Produtos.json"

    @staticmethod
    def save(dic):
        filename = Produto.filename
        
        if os.path.exists(filename) and os.path.getsize(filename) > 0:

            with open(filename,'r',encoding='utf8') as arquivo:
                try:
                    data = json.load(arquivo)
                except json.JSONDecodeError:
                    data = []

        else:
            data = []

        data.append(dic)
      

        with open(filename,'w',encoding='utf8') as arquivo:
            json.dump(data,arquivo,indent=4,ensure_ascii=False)
                
                    

    @staticmethod
    def Ler(janela_principal):
        filename = Produto.filename
 
        if os.path.exists(filename) and os.path.getsize(filename) > 0:

            with open(filename,'r',encoding='utf8') as arquivo:
                try:
                    dic = json.load(arquivo)
                except json.JSONDecodeError:
                    dic = []

        else:
            dic = []
    

        nova_janela = Toplevel(janela_principal)
        nova_janela.title("Banco de dados completo")
        canvas = Canvas(nova_janela)
        scrollbar_y = Scrollbar(nova_janela,orient="vertical",command=canvas.yview)
        frame = Frame(canvas)

        frame.bind(
            "<Configure>",
            lambda e: canvas.configure(
                scrollregion=canvas.bbox("all")
            )
        )

        canvas.create_window((0,0),window=frame,anchor="nw")
        canvas.configure(yscrollcommand=scrollbar_y.set)

        canvas.pack(side="left",fill="both",expand=True)
        scrollbar_y.pack(side="right",fill="y")

        
        if len(dic) == 0:
            label = Label(frame,text="Nao tem nenhum item cadastrado no banco de dados atualmente")
            label.pack(expand=YES,fill=BOTH)
        else:
            for item in dic:
                label = Label(frame,text=(f'{item['nome']}: \n Data compra-{item['data_compra']}\n preço compra-{item['preco_compra']}\n preço venda-{item['preco_venda']}\n quantidade venda-{item['quantidade_vendida']}'))
                label.pack(expand=YES,fill=BOTH)
        
        add_mouse_scroll(canvas)

    


    def pegar_o_maior_valor(opçao,janela_principal):
        filename = Produto.filename

       
        if os.path.exists(filename) and os.path.getsize(filename) > 0:

            with open(filename,'r',encoding='utf8') as arquivo:
                try:
                    dic = json.load(arquivo)
                except json.JSONDecodeError:
                    dic = []

        else:
            dic = []
        
        for venda in dic:
            venda['data_compra'] = datetime.strptime(venda['data_compra'],"%d/%m/%Y")

        def filtrar_vendas_por_data(dic,inicio,fim):
            return [venda for venda in dic if inicio <= venda['data_compra'].date() <= fim]
        
        hoje = datetime.now().date()
        inicio = hoje - timedelta(days=30)

        
        if opçao == 1:
            vendas_filtradas = filtrar_vendas_por_data(dic, inicio, hoje)
        elif opçao == 2:
            vendas_filtradas = filtrar_vendas_por_data(dic, hoje - timedelta(days=7), hoje)

        dic_ordenado = sorted(vendas_filtradas,key=lambda x: x['quantidade_vendida'],reverse=True)
        
            
        nova_janela = Toplevel(janela_principal)
        nova_janela.title('Lista de itens filtrados')
        canvas = Canvas(nova_janela)
        scrollbar_y = Scrollbar(nova_janela,orient="vertical",command=canvas.yview)
        frame = Frame(canvas)

        frame.bind(
            "<Configure>",
            lambda e: canvas.configure(
                scrollregion=canvas.bbox("all")
            )
        )

        canvas.create_window((0,0),window=frame,anchor="nw")
        canvas.configure(yscrollcommand=scrollbar_y.set)

        canvas.pack(side="left",fill="both",expand=True)
        scrollbar_y.pack(side="right",fill="y") 

        if len(dic_ordenado) == 0:
                label = Label(frame,text="Nao tem nenhum item dentro desse periodo de tempo")
                label.pack(expand=YES,fill=BOTH)
        else:
            for item in dic_ordenado:
                label = Label(frame,text=(f'{item['nome']}: \n Data compra-{item['data_compra'].strftime('%d/%m/%Y')}\n preço compra-{item['preco_compra']}\n preço venda-{item['preco_venda']}\n quantidade venda-{item['quantidade_vendida']}'))
                label.pack(expand=YES,fill=BOTH)
                print(f'{item['nome']}: \n {item['data_compra'].strftime('%d/%m/%Y')}\n {item['preco_compra']}\n {item['preco_venda']}\n {item['quantidade_vendida']}')
                
                
            
        
        add_mouse_scroll(canvas)