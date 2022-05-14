<?php

	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		require_once("../db.php"); //Llamar la base de datos

		//Los datos de la tabla
		$texto = $_POST['texto'];
		$idpublicacion = $_POST['idpublicacion'];
		$idusuario = $_POST['idusuario'];

		$query = "INSERT INTO comentarios (texto, idpublicacion, idusuario) VALUES ('$texto', '$idpublicacion', '$idusuario')"; //Peticion SQL

		$result = $mysql->query($query);

		//Se comprueba si se añadio el usuario o no
		if($result === TRUE){
			echo "The comment was created succesfully";
		}else{
			echo "Error";
		}

		$mysql->close();
	}

?>
