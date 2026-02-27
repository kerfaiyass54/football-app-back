ALLOWED_POSTGRES_TABLES = {
    "builder": ["users", "projects"],
    "organizer": ["events"],
    "referee": ["matches"]
}

ALLOWED_MONGO_COLLECTIONS = {
    "manager": ["managers"],
    "player": ["players"],
    "supporter": ["supporters"],
    "team": ["teams"]
}


def validate_postgres(database, table):
    if table not in ALLOWED_POSTGRES_TABLES.get(database, []):
        raise Exception("Table not allowed")


def validate_mongo(database, collection):
    if collection not in ALLOWED_MONGO_COLLECTIONS.get(database, []):
        raise Exception("Collection not allowed")