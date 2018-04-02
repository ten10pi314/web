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
	$sql = "select * from contact";
	$result = $conn->query($sql);
	if($result->num_rows > 0)
	{
		while($row = $result->fetch_assoc())
		{
			echo "name : " . $row["name"] . " number : "  .  $row["number"] . "<br>";
		}

		//header("Location: home.php");
	}
?>