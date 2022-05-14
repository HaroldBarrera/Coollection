<?php

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		
		require_once("../db.php");

		$id = $_POST['id'];
		$tipo = $_POST['tipo'];
		$codigo = $_POST['codigo'];
		$idusuario = $_POST['idusuario'];

		$query = "UPDATE perfiles SET tipo = '$tipo', codigo = '$codigo', idusuario = '$idusuario' WHERE idperfil = '$id'";
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
