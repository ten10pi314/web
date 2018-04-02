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
