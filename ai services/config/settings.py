import os
from dotenv import load_dotenv

load_dotenv()

OPENAI_API_KEY = os.getenv("OPENAI_API_KEY")

POSTGRES_DBS = {
    "builder": "postgresql+psycopg2://admin:admin@localhost:5433/builder",
    "organizer": "postgresql+psycopg2://admin:admin@localhost:5433/organizer",
    "referee": "postgresql+psycopg2://admin:admin@localhost:5433/referee",
}

MONGO_DBS = {
    "manager": "mongodb://manager_user:manager_pass@localhost:27018/manager?authSource=manager",
    "player": "mongodb://player_user:player_pass@localhost:27018/player?authSource=player",
    "supporter": "mongodb://supporter_user:supporter_pass@localhost:27018/supporter?authSource=supporter",
    "team": "mongodb://team_user:team_pass@localhost:27018/team?authSource=team",
}