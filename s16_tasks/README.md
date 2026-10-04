# Session 16: CI/CD & GitHub Actions

App is calculator in app/ folder, tests in tests/ folder. Workflow file
is .github/workflows/ci.yml at repo root so GitHub runs it, same copy
is kept here in s16_tasks/.github/workflows/ci.yml as proof.

## 1. CI vs CD and Pipeline

```
CI means every push runs build and test automatically. CD means tested
code also deploys or pushes image automatically. My pipeline is
push -> test -> build -> security check -> docker push.
```

### Commands (local check)

```bash
cd s16_tasks
pytest -v
./build.sh
docker build -t razor1128/calculator-app:latest .
```

```
All 5 tests passed locally. build.sh made build/ folder with
build-info.txt. Docker image built with same tag as CD pushes.
```

## 2. Workflow, Jobs, Steps, Runners

```
Workflow ci.yml runs on push to main, pull request and manual button.
It has 4 jobs: test, build, security-check, docker-push. build needs
test, docker-push needs build. Each job has steps like checkout code,
setup python, run tests. Runner is ubuntu-latest given by GitHub.
```

### Screenshot

![Pipeline green run](../images/s16-pipeline.png)

## 3. Secrets and Artifacts

### Commands

```bash
cat .github/workflows/ci.yml | grep -A 2 DOCKERHUB
```

```
Docker Hub token is not in code, it comes from secrets.DOCKERHUB_TOKEN
which I added in GitHub repo settings. Logs hide it. Build job uploads
build/ folder as calculator-build artifact which can be downloaded
from the run page.
```

### Screenshot

![Build artifact](../images/s16-artifact.png)

## 4. Build, Test and Docker Push

```
Test job installs requirements and runs pytest -v. Build job runs
build.sh and shows build-info.txt. docker-push job logins with token,
builds razor1128/calculator-app:latest and pushes to Docker Hub.
Image is visible on hub page with latest tag.
```

### Screenshot

![Docker Hub image](../images/s16-dockerhub.png)
