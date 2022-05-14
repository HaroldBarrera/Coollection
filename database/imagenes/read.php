<?php

	if($_SERVER['REQUEST_METHOD'] == 'GET'){

		require_once("../db.php");

		$id = $_GET['id'];

		$query = "SELECT * FROM imagenes WHERE idimagen = '$id'";
		$result = $mysql->query($query);

		if($mysql->affected_rows > 0){

			while ($row = $result->fetch_assoc()) {
				$array = $row;
			}

			echo json_encode($array);

		}else{

			echo "Not found any rows";

		}

		$result->close();
		$mysql->close();
	}

?>