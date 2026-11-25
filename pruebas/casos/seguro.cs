public class C : Controller {
    public IActionResult Buscar(int id) {
        var cmd = new SqlCommand("SELECT * FROM users WHERE id = @id", conn);
        cmd.Parameters.AddWithValue("@id", id);
        var n = int.Parse(Request.Query["n"]);
        return Redirect("/inicio");
    }
}
