Project structure:
1.We use jave SDK 16.0.2.
2.We have module named LabsRepo
3.We got jline-2.14.6 and mysql-connector-java-8.0.16 in Libraries.


You should run CheckBox.java to test.
1.CheckBox.java:(path:LabsRepo\L1\src\CheckBox.java)
Select checkbox for query desired.

2.DOMParserDemo.java:(path:LabsRepo\L1\src\DOMParserDemo.java)
Parse all data in dblp-soc-papers.xml and store them into MySQL database.

3.Paper.java:(path:LabsRepo\L1\src\Paper.java)
Define a list of attributes and act as a transit point for data from XML to database.


To import our SQL dump file:
	1.To import our SQL table, you need to create a Database named lab1.
	2.The username is root.And the password is 201269.
	3.Above all, please open cmd.
	4.Enter mysql -u root -p
	5.The password is 201269
	6.Enter mysql> CREATE DATABASE lab1
	7.Enter -u root -p lab1 < "Enter the full path of lab1_lab1tbl.sql(without these double quotes of course)"
	8.Open MySQL Workbench.
	9.Connect to database.
	10.Our table should be shown in the Schemas lab1.