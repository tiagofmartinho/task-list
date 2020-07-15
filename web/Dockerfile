FROM node:14.5.0-alpine as builder

WORKDIR /usr/src/app

COPY package.json package-lock.json ./

RUN npm install

COPY . .

RUN npm run build --prod

CMD ["ng", "serve", "--host", "0.0.0.0"]

FROM nginx:1.19-alpine

COPY --from=builder /usr/src/app/dist/consumer/ /usr/share/nginx/html
