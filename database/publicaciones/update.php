<?php

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		
		require_once("../db.php");

		$id = $_POST['id'];
		$idusuario = $_POST['idusuario'];
		$idimagen = $_POST['idimagen'];

		$query = "UPDATE publicaciones SET idusuario = '$idusuario', idimagen = '$idimagen' WHERE idpublicacion = '$id'";
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
