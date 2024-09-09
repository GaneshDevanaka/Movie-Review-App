FROM node:20.17-alpine3.19

COPY package.json package-lock.json ./


RUN npm install

COPY . .

RUN npm run build

EXPOSE 3000

CMD ["npm", "start"]
