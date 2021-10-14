Project structure:
1.We use java SDK 1.8.0_301.
2.We have modules named client and ebean-backend.
3.We got sbt and scala in plugins.


Project set-up:
+ From the IntelliJ main menu, select File | Open. Also can click open on the welcome screen.
+ And select the projects \Lab-2-Ebean\ebean-backend\build.sbt file, next click OK.
+ Then select the projects \Lab-2-Ebean\Frontend\build.sbt file, next click OK.
+ In following dialogue click Open as Project, so that IntelliJ syncs.


You should run "Front Test" and "backend" to test:
Select the queries desired in Frontend website(http://localhost:9001).


To import our SQL dump file:
	1.To import our SQL table, you need to create two schemas named lab1 and ebeantest.
	2.The username is root.And the password is 201269.
	3.Above all, please open cmd.
	4.Enter mysql -u root -p
	5.The password is 201269
	6.Enter mysql> CREATE DATABASE lab1
	7.Enter -u root -p lab1 < "Enter the full path of lab1_lab1tbl.sql(without these double quotes of course)"
	6.Enter mysql> CREATE DATABASE ebeantest
	7.Enter -u root -p ebeantest < "Enter the full path of ebeantest_lab2tbl.sql(without these double quotes of course)"
	8.Open MySQL Workbench.
	9.Connect to database.
	10.Our table should be shown in the Schemas lab1 and ebeantest.