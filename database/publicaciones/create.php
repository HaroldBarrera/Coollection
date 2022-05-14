<?php

	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		require_once("../db.php"); //Llamar la base de datos

		//Los datos de la tabla
		$idusuario = $_POST['idusuario'];
		$idimagen = $_POST['idimagen'];

		$query = "INSERT INTO publicaciones (idusuario, idimagen) VALUES ('$idusuario', '$idimagen')"; //Peticion SQL

		$result = $mysql->query($query);

		//Se comprueba si se añadio el usuario o no
		if($result === TRUE){
			echo "The publication was created succesfully";
		}else{
			echo "Error";
		}

		$mysql->close();
	}

?>
