FROM node:16-alpine AS build
WORKDIR /app
COPY . .
RUN npm install --force
RUN npm install -g @angular/cli --force
RUN ng build --configuration=production

FROM nginx:alpine
# Serve Application using Nginx Server
COPY --from=build /app/dist/josh-anderson-portfolio/ /usr/share/nginx/html
RUN ls -la
RUN cd /usr/share/nginx/html
RUN ls -la
COPY ./nginx.conf /etc/nginx/conf.d/default.conf 
EXPOSE 80

