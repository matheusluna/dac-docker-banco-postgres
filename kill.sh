docker stop app
docker rm app
docker rmi matheusluna/app
docker stop banco
docker rm banco
docker rmi matheusluna/banco
mvn clean
