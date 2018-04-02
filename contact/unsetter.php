<?php
	session_start();
	if(isset($_SESSION["user"]))
	{
		unset($_SESSION["user"]);
		header("Location: home.php");
	}
	else
	{
		header("Location: home.php");	
	}

?>