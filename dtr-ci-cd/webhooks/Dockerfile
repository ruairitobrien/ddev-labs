FROM node:8-alpine

# for edit-and-continue only
RUN npm install nodemon -g

RUN mkdir /app
WORKDIR /app
COPY package.json ./
RUN npm install
COPY ./src ./src
EXPOSE 3000
CMD ["npm","start"]