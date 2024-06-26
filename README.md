This is Sample CRUD project for Digital Library 

Admin Controller Endpoints:
POST: localhost:8080/admin/addBook
  Payload for Creating Book:
    {
        "name": "Harry Potter 2",
        "title": "The Soccer stone",
        "author": "JK Rowling",
        "genre": "FICTION",
        "cost": 100.0,
        "year": "1960-01-01",
        "authorEmail": "rowling@hp.com"
    }

PUT: localhost:8080/admin/update?id=1
DELETE: localhost:8080/admin/delete?id=1

Review Controller Endpoints:
POST: localhost:8080/review/addReview
  Payload for Adding Review
    {
    "comment":"good",
    "rating":4,
    "bookId":1
    }

User Controller
GET: localhost:8080/user/books
GET By Id: localhost:8080/user/books/byId?bookId=1
GET By Author: localhost:8080/user/books/byAuthor?author=JK Rowlingg
