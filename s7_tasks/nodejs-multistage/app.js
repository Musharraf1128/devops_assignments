const http = require("http");
http.createServer((req, res) => {
  res.end("Hello World from Docker multi-stage build");
}).listen(8080, "0.0.0.0");
