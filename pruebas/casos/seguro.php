<?php
$id = intval($_GET['id']);
$st = $pdo->prepare("SELECT * FROM users WHERE id = ?");
$st->execute([$id]);
echo htmlspecialchars($_GET['saludo']);
include __DIR__ . '/vistas/inicio.php';
$texto = "Hola $id";
