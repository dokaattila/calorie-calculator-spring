# Calorie Calculator Spring
Calorie Calculator Spring is a java backend application for retrieving common foods and their nutritional values.

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

- https://calorie-calculator-spring.herokuapp.com/getallfood
it takes a GET-request and responds with a list of all foods in the database in Json
- https://calorie-calculator-spring.herokuapp.com/getstatistic
it takes a POST-request with a Json body and responds with statistic
- Example for Json body:
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

## Project Status
Project is: _in progress_

## Room for Improvement

To do:
- more features
- Installing guide.

## Acknowledgements
- This project is a further thought version of the original application, which uses Java Swing.

