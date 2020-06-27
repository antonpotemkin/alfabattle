 && java -jar build/libs/task1.jar

docker build -t task1 .  
docker run -p 8080:8080 task1 
docker exec -ti task1 /bin/sh 

docker-compose down
docker-compose up
docker-compose up --build
