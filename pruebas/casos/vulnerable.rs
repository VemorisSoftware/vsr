use std::process::Command;
fn main() {
    let args: Vec<String> = std::env::args().collect();
    let nombre = &args[1];
    Command::new("sh").arg("-c").arg(nombre).output();
    let q = format!("SELECT * FROM users WHERE name = '{}'", nombre);
    sqlx::query(&format!("DELETE FROM t WHERE id = {}", nombre));
    std::fs::read_to_string(nombre);
    let cliente = reqwest::Client::builder().danger_accept_invalid_certs(true).build();
}
fn largo<'a>(x: &'a str) -> &'a str { x }
