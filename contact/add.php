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
	$number = $_POST["txt2"];	
	$sql = "insert into contact values ('" . $name .  "' , '" . $number. "')";
	$result = $conn->query($sql);
	header("Location: option.php");
?>