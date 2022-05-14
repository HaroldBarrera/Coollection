<?php

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		
		require_once("../db.php");

		$id = $_POST['id'];
		$imagen = $_POST['imagen'];
		$descripcion = $_POST['descripcion'];

		$query = "UPDATE imagenes SET imagen = '$imagen', descripcion = '$descripcion' WHERE idimagen = '$id'";
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