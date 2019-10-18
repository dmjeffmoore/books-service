# books-service
This microservice performs CRUD operations on a repository of books.

## How to Run
This service is backed by a MySQL database. One could stand one up quickly using docker:
```text
docker pull mysql
docker run --name <CONTAINER_NAME> -e MYSQL_ROOT_PASSWORD=<PASSWORD> -e MYSQL_DATABASE=<DB_NAME> -p 3306:3306 -d mysql:latest
``` 
Then, you can run `initial-data.sh` to populate the database with dummy data.

#### Environment Variables
DB_USERNAME, DB_PASSWORD