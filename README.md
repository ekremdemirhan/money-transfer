# money-transfer
Money Transfer is a simple project that demonstrates money transactions between users.

###HOW TO RUN
Creating a jar of the project and run it on terminal should be enough. The rest service will
be run on **localhost:4567**. Alternatively, with an IDE, application is easily built and run 
when running **MoneyTransfer** class.

###ENDPOINTS
`(GET) /users` returns all registered users.

`(GET) /users/:id` returns the user with the given ID.

`(POST) /addUser` register a user with cash amount provided in request body. 
Returns the registered user.

`(POST) /users/:id/sendMoney/:receiverId` helps the user with ID to send money to the user with receiverID. 
It requires the amount of money in request body. Returns new balance of lender user.





