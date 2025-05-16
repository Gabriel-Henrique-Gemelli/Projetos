from fastapi import FastAPI
from modelo_previsao import ModeloPrevisao
from contextlib import asynccontextmanager
import os

modelo = ModeloPrevisao()

@asynccontextmanager
async def lifespan(app: FastAPI):
    print("Conectando ao banco ou inicializando modelos...")
    modelo.carregar_dados()
    yield
    print("Finalizando conexão ou limpando recursos...")

app = FastAPI(lifespan=lifespan)

@app.get("/")
def home():
    return {"mensagem": "API de Previsão de Gastos"}

@app.get("/previsao")
def previsao():
    try:
        previsoes = modelo.prever()
        return {"previsoes": previsoes}
    except ValueError as e:
        return {"erro": str(e)}
