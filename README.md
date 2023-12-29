# 🙋 USERS-PRODUCTS-APP 📦

![image.jpg](image.jpg)

### ⚡️ Project description
RESTful web app that allows to add and authenticate user, to view and add products. Does not have UI, interaction happens through Postman.

### 🎯 Endpoints
The web app provides the following endpoints:

<b> User Endpoints: </b>

- <b>POST: /users/add</b> - This endpoint will allow to add a user. This endpoint can only be accessed by authenticated users.
- <b>POST: /users/authenticate</b> - This endpoint will allow the user to authenticate using their username and
  password. On successful login, the API return the JWT access-token.

<b> Product Endpoints: </b>

- <b>POST: /products/add</b> - Add a product.
- <b>GET: /products/all</b> - This endpoint will return all the stored products. This endpoint can only be accessed by authenticated users.

### 🔥 Getting Started
To get started with the project, follow these steps:
1. Clone the repository: git clone https://github.com/roman-java-dev/UsersProductsApp.git
2. Set up the MySQL database.
3. Configure field values to your specific properties in [application.properties](src/main/resources/application.properties) in the project. It should contain the database connection settings.
4. Install Postman for sending requests.
5. Run the application.
6. Use this URL in Postman to test the app: http://localhost:8080/ 
7. JSON payload example for user authentication. After successful authentication, you will receive a JWT token. Don't forget to copy it and add it to the Authorization - Bearer Token field.<br>
   {<br>
   "username": "any username",<br>
   "password" : "any password"<br>
   }
8. To add new user, you can use the previous JSON payload example.
9. To add a product, you need to enter data according to the following example:<br>
   {<br>
   "records" : [<br>
   {<br>
   "entryDate": "03-01-2023",<br>
   "itemCode": "11111",<br>
   "itemName": "Test Inventory 1",<br>
   "itemQuantity": "20",<br>
   "status": "Paid"<br>
   },<br>
   {<br>
   "entryDate": "03-01-2023",<br>
   "itemCode": "11111",<br>
   "itemName": "Test Inventory 2",<br>
   "itemQuantity": "20",<br>
   "status": "Paid"<br>
   }] } 
10. To test the project with end-to-end integration tests, you need to start both the server and the tests.
11. For testing in Postman, a default user will be created in the database with <b>username: "Alice" and password: "12345678".</b> You can use it for authentication.
