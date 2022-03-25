# Employee CSV Project

The Employee CSV project allows uses to enter large CSV files of data into a MySQL database. 
Before the data is entered into the database each data entry is checked for any corruptions to prevent 
errors when entering into MySQL. The code for this project was made in Java and is a backend program.

## Corruption Checking
- The below picture shows that there were 57 corrupted employee entries and 9934 valid employee entries within a CSV file: 

![Corruption Checking](https://github.com/sams4566/EmployeeCSVProject/blob/main/readme_photos/CorruptionChecking.png)

## Filtering to MySQL database
- The below photo shows that the code takes 16 seconds to be filtered into a MySQL database. The time varies 
however depending on the users CPU.

![Database Filtering](https://github.com/sams4566/EmployeeCSVProject/blob/main/readme_photos/DatabaseFiltering.png)

## Requirements
- This application works with Java 8 (earlier versions may not work correctly)
- Requires MySQL: [MySQL Workbench][https://dev.mysql.com/downloads/]

## Setup
1) Copy the repository HTML link

2) Git clone the repository to a local directory of your choice

3) Open the application in an IDE of your choice

4) Start MySQL and set up a new Schema on MySQL named "employeecsv"

5) Right-click on Tables within the Schema and create a table named "employees" with the following columns (spelling exactly as seen), data types, and default expressions:

![MySQL Setup](https://github.com/sams4566/EmployeeCSVProject/blob/main/readme_photos/MySqlSetup.png)

6) Run the app from your IDE and the employeecsv table should be populated with the validated employee data from the .csv file

7) View the employeecsv data using the query:

`USE  employeecsv;`

`SELECT * FROM employeecsv;`

8) Refresh the MySQL database before running the app again by running the query:

`TRUNCATE TABLE employeecsv;`