Simple payment app
==================

To start the application run `grails run-app` from the application folder.

Transaction page: [http://localhost:8080/simple_payment/payment/transactions](Transactions)

Pay page: [http://localhost:8080/simple_payment/payment/pay](Pay)

Emails: [http://localhost:8080/simple_payment/greenmail/list](Emails)

Todo
----

* Debug java.lang.NoSuchFieldException
* Write tests
* Refactoring
  * Create a notification service for emails
  * Separate payment logic from Controller
  * Externalize texts