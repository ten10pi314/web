<?php
	session_start();
?>
<?php	
	$servername = "localhost";
	$db_name = "cs";
	$username = "root";
	$password = "mysql";
	$conn = new mysqli($servername,$username , $password , $db_name);
	if($conn->connect_error)
	{
		die("DB Connection Error");
	}
	$name = $_POST["txt1"];
	$sql = "delete from contact where name  = '"  . $name . "'";
	$result = $conn->query($sql);
	header("Location: option.php");
?>