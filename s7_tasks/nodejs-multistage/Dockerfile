FROM node:22-alpine AS build
WORKDIR /app
COPY package.json app.js ./
RUN npm install --omit=dev

FROM node:22-alpine
WORKDIR /app
COPY --from=build /app /app
EXPOSE 8080
CMD ["npm", "start"]
