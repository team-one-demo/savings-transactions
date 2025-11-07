# Savings Transactions

This is the microservices to get all the savings account transactions for a specific user and account number. This is a RESTful service.

Inputs:
- userID: "user123"
- accountNumber: "SAV001"

Outputs:

A list of transactions in JSON format, each made up of the following fields:
- transactionDate: date of transaction
- transactionDescription: description of transaction
- transactionType: type of transaction (DEPOSIT, ACH PAYMENT, INTEREST, FEE, WIRE, etc) - enumeration value or string
- transactionAmount - amount of transaction - float
- accountBalance - current account balance - float

## How to build it and run it locally

- Clone this repository onto your local machine
- Ensure you have: Maven and Java 17, or later, installed on your local machine
- Go to the root directory of the cloned repository on your local machine
- Execute the following command: `mvn clean package`
- After the build finishes, enter the following command: `java -jar target/savings-transactions-service-1.0.0.jar`

## How to invoke

```
curl -X POST \
  http://localhost:8080/api/v1/savings-transactions \
  -H "Content-Type: application/json" \
  -d '{
    "userId": "user123",
    "accountNumber": "SAV001"
  }'
```
Here's an example of what should be returned:

```
[{"date":"2024-02-28","description":"Dining out","type":"Withdrawal","amount":"-$10.00","balance":"$1,550.50"},{"date":"2024-02-28","description":"Grocery store","type":"Withdrawal","amount":"-$40.00","balance":"$1,910.50"},{"date":"2024-02-28","description":"Netflix","type":"Withdrawal","amount":"-$15.50","balance":"$1,895.00"},{"date":"2024-02-28","description":"Clothes","type":"Withdrawal","amount":"-$50.00","balance":"$1,845.50"},{"date":"2024-02-28","description":"Internet bill","type":"Withdrawal","amount":"-$35.00","balance":"$1,810.00"},{"date":"2024-02-22","description":"Horeca deposit","type":"Deposit","amount":"$500.00","balance":"$2,550.50"},{"date":"2024-02-21","description":"Rent","type":"Withdrawal","amount":"-$500.00","balance":"$1,550.00"}]
```