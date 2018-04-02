<!DOCTYPE html>
<html>

<head>
	<style type="text/css">
		.login
		{
			margin-left: 32%;
			margin-top: 20%;
			background-color: blue;
    		color: white;
    		padding: 10px;
    		width: 30%;
    		padding: 2%;
		}
	</style>
	<title>Welcome</title>
</head>

<body>	
	<form  class = "login" action = "check.php" method = "POST" required>
		<pre>Username : <input type="text" name="username" placeholder="username" required> </pre>
		<br>
		<pre>Password : <input type="password" name="password" placeholder="password" required></pre>
		<br>
		<input type="submit" name="submit" value = "login">

	</form>
</body>
</html>	