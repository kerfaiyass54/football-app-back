import json
from openai import OpenAI
from config.settings import OPENAI_API_KEY
from dotenv import load_dotenv
import os
from openai import OpenAI

load_dotenv()

client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))

tools = [
    {
        "type": "function",
        "function": {
            "name": "query_postgres",
            "description": "Query a PostgreSQL database",
            "parameters": {
                "type": "object",
                "properties": {
                    "database": {
                        "type": "string",
                        "enum": ["builder", "organizer", "referee"]
                    },
                    "table": {"type": "string"},
                    "filters": {
                        "type": "array",
                        "items": {
                            "type": "object",
                            "properties": {
                                "column": {"type": "string"},
                                "operator": {"type": "string"},
                                "value": {"type": "string"}
                            }
                        }
                    },
                    "limit": {"type": "integer"}
                },
                "required": ["database", "table"]
            }
        }
    },
    {
        "type": "function",
        "function": {
            "name": "query_mongo",
            "description": "Query a MongoDB database",
            "parameters": {
                "type": "object",
                "properties": {
                    "database": {
                        "type": "string",
                        "enum": ["manager", "player", "supporter", "team"]
                    },
                    "collection": {"type": "string"},
                    "filters": {
                        "type": "array",
                        "items": {
                            "type": "object",
                            "properties": {
                                "field": {"type": "string"},
                                "value": {"type": "string"}
                            }
                        }
                    },
                    "limit": {"type": "integer"}
                },
                "required": ["database", "collection"]
            }
        }
    }
]


def run_agent(user_text):

    response = client.chat.completions.create(
        model="gpt-4o-mini",
        messages=[{"role": "user", "content": user_text}],
        tools=tools,
        tool_choice="auto"
    )

    message = response.choices[0].message

    if message.tool_calls:
        tool_call = message.tool_calls[0]
        tool_name = tool_call.function.name
        arguments = json.loads(tool_call.function.arguments)
        return tool_name, arguments

    return None, None