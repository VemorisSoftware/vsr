# Cambios

## 0.2.0 — 2026-11-25
- **7 lenguajes nuevos:** Python, Go, Rust, C#, PHP, Java y Kotlin (11 en total).
- Reglas nuevas: `deserializacion-insegura` e `inclusion-archivos`.
- Interpolación por lenguaje: f-strings de Python, `$"…"` de C#, `$x`/`${x}` de Kotlin y PHP.
- SQL armado con `fmt.Sprintf`, `format!`, `String.format`, `.format()` y `%`.
- TLS desactivado en Python (`verify=False`), Go (`InsecureSkipVerify`), Rust, C# y Java.
- Go `:=`, declaraciones tipadas (`let x: T =`) y llamadas encadenadas (`new X().metodo()`).
- Menos falsos positivos en secretos y en `rand` (métodos y `crypto/rand`).
- 97 pruebas.

## 0.1.0 — 2026-11-25
- Primera versión, escrita 100 % en C-Forge.
- Analiza C++, Swift, JavaScript/TypeScript y C-Forge (y Info.plist).
- 16 reglas: inyección de comandos y SQL, XSS, secretos, desbordamientos, recorrido de rutas, SSRF, código dinámico, cadenas de formato, TLS, aleatorio inseguro, almacenamiento inseguro, ATS, hash débil, regex dinámica y redirección abierta.
- Seguimiento de datos externos a través de asignaciones, con limpiadores.
- Aprendizaje por proyecto: `vsr ignorar`, `vsr confirmar`, `vsr olvidar`.
- Salidas: texto, JSON, SARIF y Markdown; modo `--diff` para PRs.
- GitHub Action con comentario en el PR y SARIF.
- Binarios para macOS (Intel y Apple Silicon), Linux (x64 y ARM64) y Windows.
