<?php

    $mysql = new mysqli(
        "localhost", //Direccion de la conexion
        "root", //usuario
        "123", //Contraseña
        "coollection" //Nombre de la BD
    );

    //Verificar si la conexion fue exitosa
    if ($mysql->connect_error) {
        die("Failed to connect" . $mysql->connect_error);
    }else{
        //echo "Database is connected\n";
    }

?>
