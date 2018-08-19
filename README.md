# Fizz Buzz HTTP API

## Usage
Start the application using below command

```
mvn spring-boot:run
```

Example usage (input multiple numbers separated by comma)

Valid number range: 1 - 999999999

```
http://localhost:8080/api/fizzbuzz?numbers=96,40,75,91
```

Response is a comma separated string with numbers replaced with fizz buzz (according to rules) in the same order as input

```
Fizz, Buzz, FizzBuzz, 91
```

Simple UI to test the application

```
http://localhost:8080/
```
