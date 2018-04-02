<?php
	session_start();
	if(!isset($_SESSION["user"]))
	{
		header("Location: home.php");
	}
?>
<!DOCTYPE html>
<html>
<head>
	<title>Contact</title>
</head>
<body>
	<div style="text-align: center;">
	<form method="POST" action = "insert.php" style="margin-bottom: 10px;">
		<input type="submit" name="btn1" value="insert">
	</form>
	<form method="POST" action = "modify.php" style="margin-bottom: 10px;">
		<input type="submit" name="btn2" value="modify">
	</form>
	<form method="POST" action = "delete.php" style="margin-bottom: 10px;">
		<input type="submit" name="btn3" value="delete">
	</form>
	<form method="POST" action = "shownumber.php" style="margin-bottom: 10px;">
		<input type="submit" name="btn4" value="shownumber">
	</form>
	<form method="POST" action = "unsetter.php" style="margin-bottom: 10px;">
		<input type="submit" name="btn5" value="logout">
	</form>	
	</div>
</body>
</html>