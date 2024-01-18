FROM node:18-alpine AS build
WORKDIR /app
COPY . .
RUN npm install --force
RUN npm install -g @angular/cli --force
RUN npm install @capacitor/cli@latest-3 @capacitor/core@latest-3 --force
RUN ng build --configuration=production --build-optimizer=true --output-hashing=none --optimization=true
# RUN cd ./dist/josh-anderson-portfolio/ \
# cp . /var/www/html
FROM nginx:alpine
#COPY /app/dist/josh-anderson-portfolio/ /var/www/html
COPY --from=build /app/dist/josh-anderson-portfolio/ /var/www/html

# Serve Application using Nginx Server
# COPY --from=build /app/dist/josh-anderson-portfolio/ /var/www/html
# RUN ls -la
# RUN cd /usr/share/nginx/html
# RUN ls -la
# COPY ./nginx.conf /etc/nginx/conf.d/default.conf
# EXPOSE 4200

