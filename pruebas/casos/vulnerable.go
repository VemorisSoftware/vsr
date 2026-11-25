package main
import ("fmt"; "net/http"; "os/exec"; "database/sql")
func handler(w http.ResponseWriter, r *http.Request) {
	nombre := r.URL.Query().Get("nombre")
	exec.Command("sh", "-c", "echo "+nombre).Run()
	db.Query(fmt.Sprintf("SELECT * FROM users WHERE name = '%s'", nombre))
	db.Query("SELECT * FROM t WHERE name = '" + nombre + "'")
	http.ServeFile(w, r, "/datos/"+r.FormValue("f"))
	http.Get(r.FormValue("url"))
	http.Redirect(w, r, r.FormValue("next"), 302)
	tls := &tls.Config{InsecureSkipVerify: true}
}
