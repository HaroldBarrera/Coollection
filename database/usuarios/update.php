<?php

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		
		require_once("../db.php");

		$id = $_POST['id'];
		$nombre = $_POST['nombre'];
		$apellido = $_POST['apellido'];
		$correo = $_POST['correo'];
		$username = $_POST['username'];
		$password = $_POST['password'];

		$query = "UPDATE usuario SET nombre = '$nombre', apellido = '$apellido', correo = '$correo', username = '$username', password = '$password' WHERE id = '$id'";
		$result = $mysql->query($query);

		if ($mysql->affected_rows > 0) {
			if ($result === TRUE) {
				echo "Update succesfully";
			}else{
				echo "Error";
			}
		}else{
			echo "Not found any rows";
		}

		$mysql->close();
	}

?>