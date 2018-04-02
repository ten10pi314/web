# web


Set / change / reset the MySQL root password on Ubuntu Linux. Enter the following lines in your terminal.

    Stop the MySQL Server: sudo /etc/init.d/mysql stop
    Start the mysqld configuration: sudo mysqld --skip-grant-tables &
    Login to MySQL as root: mysql -u root mysql

    Replace YOURNEWPASSWORD with your new password:

    UPDATE
      mysql.user
    SET
      Password = PASSWORD('YOURNEWPASSWORD')
    WHERE
      User = 'root';
    FLUSH PRIVILEGES;
    exit;

    Note: on some versions, if password column doesn't exist, you may want to try:
    UPDATE user SET authentication_string=password('YOURNEWPASSWORD') WHERE user='root';

Note: This method is not regarded as the most secure way of resetting the password, however, it works.






Step 1: Stop MySQL Service.

sudo stop mysql

Step 2: Kill all running mysqld.

sudo killall -9 mysqld

Step 3: Starting mysqld in Safe mode.

sudo mysqld_safe --skip-grant-tables --skip-networking &

Step 4: Start mysql client

mysql -u root

Step 5: After successful login, please execute this command to change any password.

FLUSH PRIVILEGES;

Step 6: You can update mysql root password .

UPDATE mysql.user SET Password=PASSWORD('newpwd') WHERE User='root';

Note: On MySQL 5.7, column Password is called authentication_string.

Step 7: Please execute this command.

FLUSH PRIVILEGES;











 Sudoserviceapache2start
 /lampp/lamppstart
