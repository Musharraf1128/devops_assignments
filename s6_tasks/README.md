# Session 6: Docker

## Running nginx

![Command: ](./image1.png)
![Output](./image2.png)

## Basic Docker Commands

![Docker command output](../images/docker_basic_commands.png)


---

## Other Hello World Applications

I first practiced nginx above. For this homework I also made the other folders.

```text
nodejs-app
python-app
java-app
Apache-app
React-app
nginx-app
```

```bash
docker build -t nodejs-app ./nodejs-app
docker run -d --name nodejs-app -p 3000:3000 nodejs-app

docker build -t python-app ./python-app
docker run -d --name python-app -p 5000:5000 python-app

docker build -t java-app ./java-app
docker run -d --name java-app -p 8081:8080 java-app

docker build -t apache-app ./Apache-app
docker run -d --name apache-app -p 8082:80 apache-app

docker build -t react-app ./React-app
docker run -d --name react-app -p 8083:80 react-app

docker build -t nginx-app ./nginx-app
docker run -d --name nginx-app -p 8084:80 nginx-app

docker ps
```

### Node.js Screenshot

![Node.js Docker command output](../images/nodejs_output.png)

![Node.js application](../images/nodejs.png)

### Python Screenshot

![Python application](../images/python.png)

### Java Screenshot

![Java Docker command output](../images/java_output.png)

![Java application](../images/java.png)

### Apache Screenshot

![Apache Docker command output](../images/apache_output.png)

![Apache application](../images/apache.png)

### React Screenshot

![React Docker command output](../images/react_output.png)

![React application](../images/react.png)

### Running Containers

![Docker ps showing the application containers](../images/docker_ps.png)








