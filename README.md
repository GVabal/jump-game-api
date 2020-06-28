# danske-bank-coding-task
Homework assignment – Task #3: Back end dev

API that accepts an array of digits, determines if the goal specified in given task is reachable. Provides the most efficient path as well.

How to use (assuming the application would be run locally):

`curl -X GET http://localhost/sequences` - returns all sequences from database

`curl -X GET http://localhost/sequences/{id}` - returns sequence by id

`curl -X POST -H "Content-Type: application/json" -d '{"list":[1,2,3,4,5]}' http://localhost/sequences` - takes list of digits in json body, processes it and returns json object of the sequence. If sequence was requested to calculate before, returns that sequence instead.

`curl -X DELETE http://localhost/sequences` - deletes all sequences from database. For convenience
