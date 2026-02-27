from sqlalchemy import create_engine
from config.settings import POSTGRES_DBS

postgres_engines = {}

for name, url in POSTGRES_DBS.items():
    postgres_engines[name] = create_engine(url, pool_pre_ping=True)