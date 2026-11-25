fn main() {
    let id: i64 = std::env::args().nth(1).unwrap().parse().unwrap();
    sqlx::query("SELECT * FROM users WHERE id = $1").bind(id);
    Command::new("ls").arg("-la").output();
    println!("hola {}", id);
}
fn largo<'a>(x: &'a str) -> &'a str { x }
