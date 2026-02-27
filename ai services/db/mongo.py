from pymongo import MongoClient
from config.settings import MONGO_DBS

mongo_databases = {}

for name, uri in MONGO_DBS.items():
    client = MongoClient(uri)
    mongo_databases[name] = client.get_default_database()