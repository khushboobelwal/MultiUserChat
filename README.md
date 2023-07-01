# **Prerequisites**
### Proficiency in Java
### Eclipse IDE

#  LOGIN/REGISTRATION LOGIC
* The LOGIN/REGISTRATION for the UI is built with the help of SWING and AWT components along with the feature of DRAG-AND-DROP in the window builder
* The logic is created to take input from the users their credentials and store them in the MySQL database in order to validate the user in future

#  USER REGISTRATION/LOGIN
* Users are able to register themselves by providing their userid along with a password which is stored in MySQL in order to validate it for future Logins.
* Users who have registered themselves can login using their Userid and  password,the provided credentials are verified against the data stored in the MySQL database,if the credentials are valid the users can successfully login but in case of invalid credentials the user is denied access.

#  Dashboard and ClientChatScreen Logic
* The dashboard  and ClientChatScreen are also built with the help of SWING and AWT components along with the feature of window builder.
* The dashboard is a UI from which user can access to chats and start a chat
* The ClientChatScreen provides the users with a textfield,a textarea.
* Users from the ClientChatScreen can enter text messages in the textfield and send the message through the send message Jbutton.
* The sent messages are visible to the users  on the textarea .

# Database Setup and Connection building 
* The database used for this application is MySQL database.
* In order to use MySQL we need to install and configure it.
* The database is used to store the user credentials and other relevant data.
* To build a connection between the application and the database we use the concept of JDBC and MySQL jar connectors .
* We can implement queries on the database to perform necessary actions.

# Socket Programming
* Server Programming is used here in order to effectively communicate.
* Server socket class is created that accepts incoming client connections.
* A new thread for each client is made.
* The necessary logics and protocol is implemented to enable effective communication between clients and server.

# Handshaking Process and Multithreading implementation
* The handshaking process is done between the client and the server to ensure secure communication.
* The password on the client side is encrypted before sending it to the server.
* The hashed code generated as a result of encryption is used for the validation of credentials on the server side.
* The concept of Multithreading is used to handle connections of multiple clients concurrently.
* Each client is assigned with a separeate thread for independent communication.

# Broadcasting Messages over the network and Read/Write data on the Stream
* Since this is a multiuser chat application,so when a client sends a message it is the responsibility of the server to broadcast it to all other clients over the network
* For broadcasting output stream of clients thread is used.
* Input and output streams are used to read/write data at both client and server site.

# Password Hashing
* In order to create a secured application we will be using password hashing.
* We will be using any of the cryptographic algorithm to hash the passwords beforing storing them into the database.
* In this application MD5 algorithm is used to perform password hashing.
* To authenticate users the hashed password is used.

# Exception Handling
* Proper Exception handling methods are implemented throughout the application.
* In case of connection failures,or any other exception informative error will be displayed to the users. 
