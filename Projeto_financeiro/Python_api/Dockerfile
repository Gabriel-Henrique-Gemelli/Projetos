# Usa uma imagem oficial do Python como base
FROM python:3.13.3

# Define o diretório de trabalho no container
WORKDIR /app

# Copia os arquivos da sua API para o container
COPY . .

# Instala as dependências
RUN pip install --no-cache-dir -r requisitos.txt

# Expõe a porta que o FastAPI usará
EXPOSE 8000

# Comando para iniciar a aplicação
CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000"]
# CMD ["uvicorn", "main:app", "--host", "
