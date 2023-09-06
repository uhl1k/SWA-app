FROM node:16-alpine AS build
WORKDIR /app
COPY frontend/swa-app/package*.json ./
RUN npm install
COPY frontend/swa-app .
RUN npm run build
EXPOSE 4200
CMD ["npm", "start"]