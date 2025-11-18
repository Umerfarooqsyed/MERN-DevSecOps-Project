# ------------------- Stage 1: Build Stage ------------------------------

FROM node:21 AS Buildstage

WORKDIR /app

# Copying dependencies files in /app work directory
COPY package*.json .

# Installing dependencies defined in package*.json files, here ci means cleam install
RUN npm ci

# Copying source code
COPY . . 

# Creating bundle for prod, it will bundle all the stuff in /app/dist file
RUN npm run build


# ------------------- Stage 2: Final Stage ------------------------------

FROM nginx:stable-alpine

RUN rm -rf /usr/share/nginx/html/*

COPY --from=Buildstage /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx","-g","daemon off"]

