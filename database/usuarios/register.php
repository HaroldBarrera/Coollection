<?php

	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		require_once("../db.php"); //Llamar la base de datos

		//Los datos de la tabla
		$nombre = $_POST['nombre'];
		$apellido = $_POST['apellido'];
		$correo = $_POST['correo'];
		$username = $_POST['username'];
		$password = $_POST['password'];

		$query = "INSERT INTO usuario(nombre, apellido, correo, username, password) VALUES ('$nombre','$apellido', '$correo', '$username','$password')"; //Peticion SQL

		$result = $mysql->query($query);

		//Se comprueba si se añadio el usuario o no
		if($result === TRUE){
			echo "The user was created succesfully";
		}else{
			echo "Error";
		}

		$mysql->close();
	}

?>