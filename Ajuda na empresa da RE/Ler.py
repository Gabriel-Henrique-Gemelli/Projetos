import re
from pdf2image import convert_from_path
import pytesseract
import csv
import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders
import tkinter as tk
from tkinter import filedialog
from pathlib import Path

def extract_fields(pdf_path):
    # Converte PDF para imagem
    Datalista = []
    for i in pdf_path:
        pages = convert_from_path(i)
        text = ""
        for page in pages:
            text += pytesseract.image_to_string(page, lang="eng")

        placa_match = re.search(r"[A-Z]{3}[-\s]?\d[A-Z0-9]{2}\d\s*/\s*[A-Z]{2}", text)
        condutor_match = re.search(
        r"\d{3}\.\d{3}\.\d{3}-\d{2}\s+([A-Z\s]+?)(?=\s+VALE|\s+RESPONSAVEL|\n)", 
        text
        )
        numero_match = re.search(r"\d{3}\.\d{3}\.\d{3}", text)  # Captura tipo 000.001.114
        data_hora_match = re.search(r"\d{2}/\d{2}/\d{4}\s+\d{2}:\d{2}:\d{2}", text)

        Data =  {
            "Condutor": condutor_match.group(1).strip() if condutor_match else None,
            "Placa": placa_match.group(0).strip() if placa_match else None,
            "Data e Hora": data_hora_match.group(0) if data_hora_match else None,
            "Número": numero_match.group(0) if numero_match else None
            
        }
        
        Datalista.append(Data)

    return Datalista

def writer(header, data, filename):
    with open(filename, "w", newline="", encoding="utf-8") as csvfile:
        csv_writer = csv.writer(csvfile)
        csv_writer.writerow(header)  # Escreve cabeçalho
        csv_writer.writerows(data)   # Escreve todas as linhas

def enviar_email(LocalArquivo):
    try:
        remetente = 'pasqualottorejane@gmail.com'
        senha = 'tbme arxr gxup tlzp'  # Senha de aplicativo do Gmail
        destinatarios = ['gabrielhenriquegemelli@gmail.com']
        
        # Criar a mensagem como multipart (corpo + anexo)
        mensagem = MIMEMultipart()
        mensagem["From"] = remetente
        mensagem["To"] = ", ".join(destinatarios)
        mensagem["Subject"] = "Email em anexo"
        
        # Corpo do email
        conteudo = "Segue em anexo os arquivos."
        mensagem.attach(MIMEText(conteudo, "plain", "utf-8"))
        
        # Nome do arquivo CSV (que você gerou no writer)
        arquivo_csv = "Dados.csv"  # <- usando a variável que você já criou
        arquivo_pdf = LocalArquivo

        
            
        # Abrir e anexar o CSV
        with open(arquivo_csv, "rb") as arquivo:
            parte = MIMEBase("application", "octet-stream")
            parte.set_payload(arquivo.read())
        
        for i in arquivo_pdf:
            caminho = Path(i)
            with open(caminho, "rb") as arquivo2:
                parte2 = MIMEBase("application", "octet-stream")
                parte2.set_payload(arquivo2.read())

                encoders.encode_base64(parte2)
            
            parte2.add_header(
            "Content-Disposition",
            f"attachment; filename={caminho.name}",
            )

            mensagem.attach(parte2)

        # Codificar em base64
        encoders.encode_base64(parte)
        
        
        # Definir nome do anexo
        parte.add_header(
            "Content-Disposition",
            f"attachment; filename={arquivo_csv}",
        )
       
        
        # Anexar o arquivo à mensagem
        mensagem.attach(parte)
       
        
        # Enviar email
        with smtplib.SMTP('smtp.gmail.com', 587) as servidor:
            servidor.starttls()
            servidor.login(remetente, senha)
            servidor.send_message(mensagem)
            print("E-mail enviado com sucesso!")
    
    except Exception as e:
        print(f"Erro ao enviar o email: {e}")

def pegar_arquivo():
    root = tk.Tk()
    root.withdraw()  # Esconde a janela principal do Tkinter

    file_path = filedialog.askopenfilenames()

    if file_path:
        print(f"Arquivo selecionado: {file_path}")
        return file_path
    else:
        print("Nenhum arquivo selecionado.")

def main():
    LocalArquivo = pegar_arquivo()
    dados = extract_fields(LocalArquivo)
    filename = "Dados.csv"
    header = ("Condutor", "Placa", "Data e Hora", "Número")
    
    linhas_csv = [
        (i["Condutor"], i["Placa"], i["Data e Hora"], i["Número"])
        for i in dados
    ]
    
    for linha in linhas_csv:
        print(linha)
        
    decisao = int(input("\nOs dados estão corretos? 1 - Sim, 2 - Não: "))
    
    if decisao == 1:
        try:
            writer(header, linhas_csv, filename)
            enviar_email(LocalArquivo)    
            print("Dados salvos com sucesso!")
        except Exception as e:
            print(f"Erro ao salvar os dados: {e}")
    else:
        print("Por favor chamar o Gabriel para corrigir os dados.")

main()

