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
	$username = $_POST["username"];
	$password = $_POST["password"];	
	$sql = "select * from signup";
	$result = $conn->query($sql);
	if($result->num_rows > 0)
	{
		while($row = $result->fetch_assoc())
		{
			if($row["name"] == $username)
			{
				if($row["password"] == $password)
				{
					$_SESSION['user'] = $username;
					header("Location: option.php");
				}
				else
				{
					$_SESSION['Error'] = 'invalid password';
					header("Location: home.php");
				}
			}
		}
		$_SESSION['Error'] = 'invalid username';
		//header("Location: home.php");
	}
?>