fun rutas() {
    val id = call.parameters["id"]?.toIntOrNull()
    db.rawQuery("SELECT * FROM users WHERE id = ?", arrayOf(id.toString()))
    val saludo = "Hola $id"
    println(saludo)
}
