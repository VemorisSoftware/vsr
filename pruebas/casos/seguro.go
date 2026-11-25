package main
func handler(w http.ResponseWriter, r *http.Request) {
	id, _ := strconv.Atoi(r.URL.Query().Get("id"))
	db.Query("SELECT * FROM users WHERE id = $1", id)
	exec.Command("ls", "-la").Run()
	fmt.Println("hola")
}
