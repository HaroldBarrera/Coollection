<?php

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		
		require_once("../db.php");

		$id = $_POST['id'];
		$texto = $_POST['texto'];
		$idpublicacion = $_POST['idpublicacion'];
		$idusuario = $_POST['idusuario'];

		$query = "UPDATE comentarios SET texto = '$texto', idpublicacion = '$idpublicacion', idusuario = '$idusuario' WHERE idimagen = '$id'";
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
