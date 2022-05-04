<?php

error_reporting(0);

$db_name = "id18420043_sharepixel";
$mysql_user = "id18420043_sharepixel_be";
$mysql_pass = "8JP\3Z24ucKK{Kq3";
$server_name = "localhost";

$con = mysqli_connect($server_name, $mysql_user, $mysql_pass, $db_name);

if(!$con){
	echo '{"message":"Unable to connect to the database."}';
}

?>