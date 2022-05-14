<?php

	if($_SERVER['REQUEST_METHOD'] == 'GET'){

		require_once("../db.php");

		$query = "SELECT * FROM perfiles";
		$array = Array();
		$result = $mysql->query($query);

		if($mysql->affected_rows > 0){

			while ($row = $result->fetch_assoc()) {
				$array[] = $row;
			}

			echo json_encode($array);

		}else{

			echo "Not found any rows";

		}

		$result->close();
		$mysql->close();
	}

?>