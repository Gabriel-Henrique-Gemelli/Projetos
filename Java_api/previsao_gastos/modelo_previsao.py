import pandas as pd
import numpy as np
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import LabelEncoder
from sqlalchemy import create_engine
from datetime import datetime

class ModeloPrevisao:
    def __init__(self):
        self.model = LinearRegression()
        self.le_mes = LabelEncoder()
        self.le_cat = LabelEncoder()
        self.dados_carregados = False

    def carregar_dados(self):
        # Configurações do banco MySQL
        usuario = "root"
        senha = ""
        host = "localhost"
        porta = "3306"
        banco = "financeiro"

        url_conexao = f"mysql+mysqlconnector://{usuario}:{senha}@{host}:{porta}/{banco}"
        engine = create_engine(url_conexao)

        # Lê os dados diretamente do banco
        df = pd.read_sql("SELECT categoria, valor, data FROM gastos", con=engine)

        # Converte a data
        df['data'] = pd.to_datetime(df['data'])
        df['ano_mes'] = df['data'].dt.to_period('M').astype(str)

        # Agrupa os dados
        df_grouped = df.groupby(['ano_mes', 'categoria'])['valor'].sum().reset_index()
        df_grouped['mes_num'] = self.le_mes.fit_transform(df_grouped['ano_mes'])
        df_grouped['cat_num'] = self.le_cat.fit_transform(df_grouped['categoria'])

        X = df_grouped[['mes_num', 'cat_num']]
        y = df_grouped['valor']

        self.model.fit(X, y)
        self.dados_carregados = True
        self.df_grouped = df_grouped  # salva para análise futura

    def prever(self):
        if not self.dados_carregados:
            raise ValueError("Os dados precisam ser carregados antes de prever.")

        # Descobre o próximo mês
        ultimo_mes_str = max(self.le_mes.classes_)
        ultimo_mes_dt = datetime.strptime(ultimo_mes_str, "%Y-%m")
        ano = ultimo_mes_dt.year + (ultimo_mes_dt.month // 12)
        mes = (ultimo_mes_dt.month % 12) + 1
        proximo_mes_dt = datetime(ano, mes, 1)
        proximo_mes_str = proximo_mes_dt.strftime("%Y-%m")

        # Atualiza o encoder para incluir o novo mês
        todas_as_datas = list(self.le_mes.classes_) + [proximo_mes_str]
        self.le_mes.fit(todas_as_datas)
        proximo_mes_num = self.le_mes.transform([proximo_mes_str])[0]

        categorias = self.le_cat.classes_
        previsoes = {}

        for cat in categorias:
            entrada = np.array([[proximo_mes_num, self.le_cat.transform([cat])[0]]])
            previsoes[cat] = self.model.predict(entrada)[0]

        return previsoes
