<?php

	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		require_once("../db.php"); //Llamar la base de datos

		//Los datos de la tabla
		$imagen = $_POST['imagen'];
		$descripcion = $_POST['descripcion'];

		$query = "INSERT INTO imagenes (imagen, descripcion) VALUES ('$imagen', '$descripcion')"; //Peticion SQL

		$result = $mysql->query($query);

		//Se comprueba si se añadio el usuario o no
		if($result === TRUE){
			echo "The image was created succesfully";
		}else{
			echo "Error";
		}

		$mysql->close();
	}

?>