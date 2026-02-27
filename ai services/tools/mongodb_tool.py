from db.mongo import mongo_databases
from security.validators import validate_mongo


def query_mongo(database, collection, filters=None, limit=100):

    validate_mongo(database, collection)

    db = mongo_databases.get(database)
    if not db:
        raise Exception("Invalid database")

    query = {}

    if filters:
        for f in filters:
            query[f["field"]] = f["value"]

    cursor = db[collection].find(query, {"_id": 0}).limit(min(limit, 500))
    return list(cursor)