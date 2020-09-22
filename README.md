docker-compose up
docker-compose  scale hazelcast=1
SERVER_PORT=8089 mvn spring-boot:run

localhost:8088/swagger-ui.html