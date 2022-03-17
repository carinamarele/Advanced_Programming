Nume :    Marele 
Prenume:  Carina-Ioana
Grupa:    2A4
Laborator: 8

Am adaugat si un video pentru a arata cum arata interfata

Compulsory 

Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
Write an SQL script that will create the following tables:
movies: id, title, release_date, duration, score
genres: id, name (for example: Action, Drama)
an associative (junction) table in order to store each movie genres
Update pom.xml, in order to add the database driver to the project libraries.
Create a singleton class in order to manage a connection to the database.
Create DAO classes that offer methods for creating movies and genres, and finding them by their ids and names;
Implement a simple test using your classes.


Optional 

Create the necessary table(s) in order to store movie actors and directors in the database.
Create an object-oriented model of the data managed by the Java application.
Create a tool to import data from a real dataset: IMDb movies extensive dataset or The Movies Dataset or other.
For additional points, you may consider extending your model or generating suggestive HTML reports, based on the imported data.

Bonus

Use a connection pool in order to manage database connections, such as C3PO, HikariCP or Apache Commons DBCP.
Using a ThreadPoolExecutor, create a (large?) number of concurrent tasks, each requiring a database connection in order to perform various SQL operations on the database.
Analyze the behavior of the application when using the singleton connection versus the coonection pool approach.
Create a scenario in order to highlight the advantages of using a connection pool.
Use Visual VM in order to monitor the execution of your application (attach screenshots).
For additional points, you may consider creating a graphical user interface.