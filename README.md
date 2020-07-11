# Jump Game API

API, which tells whether the end of provided numbers sequence can be reached according to the game’s rules. Application will return already processed results from database, if provided sequence was requested before. 

Run with Docker:
`docker run -p {your port}:8080 gvabal/jump-game-api`

Run with Maven:
`./mvnw package && java -jar target/*.jar`

Endpoints (assuming the application is running locally on port 80):

`curl -X GET http://localhost/jump-game`

- returns all sequences from database

`curl -X GET http://localhost/jump-game/{id}` 

- returns sequence by id

`curl -X POST -H "Content-Type: application/json" -d '{"list":[1,2,3,4,5]}' http://localhost/jump-game` 

- takes list of digits in json body, processes it and returns json object of the sequence. If sequence has been requested to calculate before, returns that sequence instead.

`curl -X DELETE http://localhost/jump-game` 

- deletes all sequences from database. For convenience
