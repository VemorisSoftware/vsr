# Cambios

## 0.1.0 — 2026-11-25
- Primera versión, escrita 100 % en C-Forge.
- Analiza C++, Swift, JavaScript/TypeScript y C-Forge (y Info.plist).
- 16 reglas: inyección de comandos y SQL, XSS, secretos, desbordamientos, recorrido de rutas, SSRF, código dinámico, cadenas de formato, TLS, aleatorio inseguro, almacenamiento inseguro, ATS, hash débil, regex dinámica y redirección abierta.
- Seguimiento de datos externos a través de asignaciones, con limpiadores.
- Aprendizaje por proyecto: `vsr ignorar`, `vsr confirmar`, `vsr olvidar`.
- Salidas: texto, JSON, SARIF y Markdown; modo `--diff` para PRs.
- GitHub Action con comentario en el PR y SARIF.
- Binarios para macOS (Intel y Apple Silicon), Linux (x64 y ARM64) y Windows.
