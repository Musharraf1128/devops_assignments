# Session 21: Final DevOps Project

Ran the class taskboard app from devops-heros/session21-python on my
own machine. Full stack is postgres plus FastAPI backend plus nginx
frontend, all from docker-compose.yml file.

## 1. Backend Tests

### Commands

```bash
cd backend
pytest -v
```

### What I understood:

```
Tests use sqlite file so no database needed. First run failed with
no such table tasks because migrations never ran. Ran alembic upgrade
head once, then all 3 tests passed, health root and create task.
```

### Screenshot

![Backend tests passing](../images/s21-pytest.png)

## 2. Full Stack with Compose

### Commands

```bash
docker compose up -d --build
docker compose ps
curl -s http://localhost:8000/health
curl -s http://localhost:8000/docs | head -3
curl -s -o /dev/null -w "%{http_code}\n" http://localhost:3000
```

### What I understood:

```
Compose made 3 containers, postgres plus backend plus frontend.
Backend runs alembic upgrade on boot so tables exist. Health returned
UP status. Frontend on 3000 gave 200 with taskboard page. Docs page
at 8000/docs lists all api routes.
```

### Screenshots

![Compose containers](../images/s21-compose.png)

![Taskboard in browser](../images/s21-frontend.png)

## 3. API Check

### Commands

```bash
curl -s http://localhost:8000/api/tasks
curl -s -X POST http://localhost:8000/api/tasks -H "Content-Type: application/json" -d '{"title":"Deploy application","priority":"HIGH","assignee":"Student"}'
docker compose down
```

### What I understood:

```
Empty list came first, then post made one task and get showed it.
So frontend plus backend plus database all talk to each other.
Brought stack down after screenshots to free ports.
```

### Screenshot

![API create and list](../images/s21-api.png)
