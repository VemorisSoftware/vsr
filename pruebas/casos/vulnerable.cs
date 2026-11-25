public class C : Controller {
    public IActionResult Buscar() {
        var nombre = Request.Query["nombre"];
        var cmd = new SqlCommand("SELECT * FROM users WHERE name = '" + nombre + "'", conn);
        db.Database.ExecuteSqlRaw($"DELETE FROM t WHERE name = '{nombre}'");
        Process.Start("cmd.exe", "/c " + nombre);
        var html = Html.Raw(Request.Form["bio"]);
        System.IO.File.ReadAllText("/datos/" + nombre);
        handler.ServerCertificateCustomValidationCallback = (m, c, ch, e) => true;
        var obj = new BinaryFormatter().Deserialize(stream);
        return Redirect(Request.Query["next"]);
    }
}
