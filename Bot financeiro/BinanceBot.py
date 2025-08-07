import os
import time 
from datetime import datetime
import logging

import pandas as pd
from binance.client import Client
from binance.enums import *

from logger import *

api_key = os.getenv('Binance_api_key')
api_secret = os.getenv('Binance_api_secret')

#---------------------------------------------
#Config

STOCK_CODE = 'SOL'
OPERATION_CODE = 'SOLBRL'
CANDLE_PERIOD = Client.KLINE_INTERVAL_15MINUTE
TRADED_AMOUNT = 0.01

#---------------------------------------------

#Define the logger
logging.basicConfig(
    filename='logs/binance_bot.log',
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s'
)

#Classe principal do bot

class BinanceTraderBot():
    last_trade_decision = bool
    