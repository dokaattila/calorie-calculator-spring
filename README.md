# Calorie Calculator Spring
Calorie Calculator Spring is a java backend application, that returns common foods and their nutritional values.

## General Information
- The project uses an SQLite database to store different foods.
- The basic purpose of the project was to create the Spring-Boot version of the original standalone application.

## Technologies Used
- Java - version 17
- Spring Boot - version 2.6.3
- Project Lombok - version 1.18.22
- SQLite
- Spring Boot JDBC - version 2.6.3

## Live Demo on Heroku

https://calorie-calculator-spring.herokuapp.com/

## Usage

- https://calorie-calculator-spring.herokuapp.com/getallmeal
it takes a GET-request and returns a JSON object with all foods.
- Example:
```json
[
  {
    "id": 2,
    "name": "Alma, aszalt",
    "amount": 0
  },
  {
    "id": 3,
    "name": "Alma, befőtt",
    "amount": 0
  }
]
```
- https://calorie-calculator-spring.herokuapp.com/getmealstatistic
it takes a POST-request with a request body, which is a JSON object. It returns a JSON object with statistics.
- Example for request body:
```json
[{
		"foodID": 2,
		"foodName": "Alma, aszalt",
		"foodFat": 0.0,
		"foodCarb": 1.4,
		"foodProtein": 242.0,
		"foodCalories": 55.4
	},
	{
		"foodID": 3,
		"foodName": "Alma, befőtt",
		"foodFat": 0.0,
		"foodCarb": 0.3,
		"foodProtein": 85.0,
		"foodCalories": 20.2
	}
]
```
- Example for returned JSON object:
```json
{
    "sumCal": 327.0,
    "sumCarb": 75.6,
    "sumFat": 0.0,
    "sumProt": 1.7,
    "avgCal": 163.5,
    "avgCarb": 37.8,
    "avgFat": 0.0,
    "avgProt": 0.85
}
```

## Project Status
Project is: _in progress_

## Room for Improvement

To do:
- more features
- Installing guide.

## Acknowledgements
- This project is a further thought version of the original application, which uses Java Swing.

