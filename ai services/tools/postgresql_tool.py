from db.postgresql import postgres_engines
from security.validators import validate_postgres
from sqlalchemy import text


def query_postgres(database, table, filters=None, limit=100):

    validate_postgres(database, table)

    engine = postgres_engines.get(database)
    if not engine:
        raise Exception("Invalid database")

    sql = f"SELECT * FROM {table}"
    values = {}

    if filters:
        conditions = []
        for i, f in enumerate(filters):
            key = f"value{i}"
            conditions.append(f"{f['column']} {f['operator']} :{key}")
            values[key] = f["value"]
        sql += " WHERE " + " AND ".join(conditions)

    sql += f" LIMIT {min(limit, 500)}"

    with engine.connect() as conn:
        result = conn.execute(text(sql), values)
        return [dict(row._mapping) for row in result]