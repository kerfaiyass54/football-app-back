from fastapi import FastAPI
from agent import run_agent
from tools.postgresql_tool import query_postgres
from tools.mongodb_tool import query_mongo

app = FastAPI()


@app.post("/query")
def query(text: str):

    tool_name, args = run_agent(text)

    if tool_name == "query_postgres":
        result = query_postgres(**args)
        return {"source": "postgres", "data": result}

    elif tool_name == "query_mongo":
        result = query_mongo(**args)
        return {"source": "mongo", "data": result}

    return {"message": "No tool selected"}