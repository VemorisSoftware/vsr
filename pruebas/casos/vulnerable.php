<?php
$nombre = $_GET['nombre'];
system("grep " . $nombre . " datos.txt");
$r = mysqli_query($conn, "SELECT * FROM users WHERE name = '" . $nombre . "'");
$r2 = $pdo->query("SELECT * FROM t WHERE id = $nombre");
echo $_GET['saludo'];
include $_GET['pagina'];
$datos = file_get_contents("/datos/" . $_POST['f']);
$obj = unserialize($_COOKIE['sesion']);
header("Location: " . $_GET['next']);
eval($_POST['code']);
$users = DB::select("SELECT * FROM users WHERE email = '" . $request->input('email') . "'");
$token = md5(rand());
