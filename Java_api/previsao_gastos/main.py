from fastapi import FastAPI
from modelo_previsao import ModeloPrevisao
import os

app = FastAPI()
modelo = ModeloPrevisao()

# Carregar os dados ao iniciar
@app.on_event("startup")
async def startup_event():
     modelo.carregar_dados()

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
