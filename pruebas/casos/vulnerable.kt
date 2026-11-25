fun Application.rutas() {
    routing {
        get("/u") {
            val nombre = call.parameters["nombre"]
            Runtime.getRuntime().exec("sh -c echo $nombre")
            db.rawQuery("SELECT * FROM users WHERE name = '$nombre'", null)
            db.execSQL("DELETE FROM t WHERE name = '${nombre}'")
            webView.loadData(call.parameters["html"]!!, "text/html", "UTF-8")
            File("/datos/" + nombre).readText()
            prefs.edit().putString("authToken", token).apply()
            call.respondRedirect(call.parameters["next"]!!)
        }
    }
}
