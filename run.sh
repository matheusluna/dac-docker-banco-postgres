docker build -t matheusluna/banco ./postgres
docker run -p 5433:5432 -d --name banco matheusluna/banco

mvn clean package
docker build -t matheusluna/app .
docker run -p 8081:8080 -d --name app --link banco:host-banco matheusluna/app
