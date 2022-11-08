
{ 
    "name": "Core java",
    "sku": "tbk",
    "description": "the java text book",
    "image": "https://m.media-amazon.com/images/I/51dBjBGQFXS._SX218_BO1,204,203,200_QL40_FMwebp_.jpg",
    "price": 25.00,
    "stock": 200,
    "category_id": 2
}


{
"name": "textbook"
}

http://localhost:8080/category
http://localhost:8080/books
http://localhost:8080/books/1/books
http://localhost:8080/books?bookId=1


Spring and JPA


-Spring was concieved to reduce or replace some complex enterprise edition
-Spring can be used with or without EJB's
-Spring enbables you to switch to a light weight container like Tomcat to develop applications easier and faster
-Spring is pojo based
-Spring uses Aspect oriented programming
-JPA stands for Java Persistance API
-JPA is for hibernate
-Pojo based

-You should use hibernate or jpa, because you can swap out implementations if need be
-Jpa can help remove alot of boiler plate code
-helps build objects
-Spring handles all configuration and transactions behind the scene 
-You can use Annotatios
-MVC stands for model view controller
-Applications are usually built in tiers
-A presentation layer
-A business Logic layer
-And A Data layer

-A controller, Service and repository are the 3 components of spring applications
-A Controller route where youre going and return the users request
-A service is where the business logic goes and where transactions will likely start
-repositorys are for mapping with the database table
-business logic should not be handled in the controller
-the controller class needs some kind of controller annotation
-the service tier needs the service annotation
-service tier describes the actions of the application and where the business logic should be
-often has the same methods as the repository
-repository needs the repository annotation
-describes the data of the system 
-interacts with crud functions

-The Entity annotation is for tieing a class to a database
-You will also need the id annotation and generated value

-@Onetomany=  one object to a list of objects
-@ManytoOne= list of objects to one object

-There are 2 different fetch types
-Lazy= querys the database when object is called
-Eager= querys the database when object was created 

-Projection is a great way to select a fill and build and object based off the request
-projection is also good for presenting objects to the UI
-A constructor for projection is needed



