# 🛡️ Vemoris Security Review (VSR)

🇪🇸 Español · [🇬🇧 English](README.en.md)

Revisor de seguridad **propio de Vemoris Software**, escrito 100 % en **C-Forge**. Revisa código **C++, Swift, JavaScript/TypeScript y C-Forge** sin depender de ningún servicio externo: no usa APIs de IA, no envía tu código a ninguna parte y no tiene costo por revisión.

## Qué detecta

| Regla | Ejemplo |
|---|---|
| 🔴 `inyeccion-comandos` | `exec("ls " + req.query.dir)`, `system(argv[1])`, `sistema_comando("grep " + nombre)` |
| 🔴 `inyeccion-sql` | `` db.query(`SELECT … ${id}`) ``, `"SELECT … '\(nombre)'"`, `db_consulta(db, "… " + x)` |
| 🔴 `secreto-expuesto` | Claves de AWS, GitHub, Anthropic, Stripe, Slack, Google, claves privadas y valores con alta entropía |
| 🔴 `desbordamiento-memoria` | `strcpy`, `strcat`, `sprintf`, `gets`, `scanf("%s")` |
| 🟠 `xss` | `el.innerHTML = req.body.html`, `dangerouslySetInnerHTML`, `loadHTMLString(...)` |
| 🟠 `recorrido-rutas` | `readFileSync('/data/' + req.query.file)`, `leer_archivo("/datos/" + nombre)` |
| 🟠 `ssrf` | `fetch(req.query.url)`, `http_get(url_del_usuario)` |
| 🟠 `codigo-dinamico` | `eval(...)`, `new Function(...)` |
| 🟠 `cadena-formato` | `printf(argv[1])` |
| 🟠 `tls-desactivado` | `rejectUnauthorized: false`, `CURLOPT_SSL_VERIFYPEER, 0` |
| 🟡 `redireccion-abierta`, `aleatorio-inseguro`, `almacenamiento-inseguro`, `ats-desactivado` | |
| 🔵 `hash-debil`, `regex-dinamica` | |

### Cómo piensa
1. **Lee el código como un compilador:** lo divide en tokens (no busca texto suelto).
2. **Sigue los datos:** marca lo que viene de afuera (`req.body`, `argv`, `CommandLine.arguments`, `argumentos()`…) y lo sigue por las asignaciones.
3. **Avisa cuando un dato externo llega a algo peligroso** (shell, SQL, HTML, archivos, red), salvo que pase antes por un limpiador (`parseInt`, `Int(...)`, `escape…`, `texto_a_numero`…).
4. **Aprende de ti:** cuando marcas un aviso como falso positivo, lo recuerda y baja la confianza de esa regla en tu proyecto.

## Instalación

Descarga el binario de tu sistema desde [Releases](https://github.com/VemorisSoftware/vsr/releases):

| Sistema | Archivo |
|---|---|
| macOS (Apple Silicon) | `vsr-macos-arm64` |
| macOS (Intel) | `vsr-macos` |
| Linux x64 / ARM64 | `vsr-linux` / `vsr-linux-arm64` |
| Windows | `vsr-windows.exe` |

```bash
chmod +x vsr-macos-arm64 && mv vsr-macos-arm64 /usr/local/bin/vsr
xattr -d com.apple.quarantine /usr/local/bin/vsr   # macOS: el binario aún no está firmado
```

O compílalo con C-Forge: `cforge build vsr.cfv -o vsr --release`

## Uso

```bash
vsr escanear                      # revisa la carpeta actual
vsr escanear src --idioma en      # informe en inglés
vsr escanear --diff main          # solo lo que cambió respecto de main
vsr escanear --formato markdown   # texto | json | sarif | markdown
vsr escanear --umbral 0.5         # muestra también los hallazgos "posibles"
vsr escanear --fallar-en critica  # código de salida 1 solo con hallazgos críticos
```

### Enseñarle
```bash
vsr ignorar 9d6e0aa1b799 "userCode es una constante interna"   # falso positivo
vsr confirmar f93b374bc3a3                                      # problema real
vsr olvidar 9d6e0aa1b799
```
Lo aprendido se guarda en `.vsr/memoria.json`: súbelo al repo para que todo el equipo comparta el aprendizaje.

Para silenciar una línea puntual: agrega el comentario `// vsr:ignorar`.

## En GitHub (cada Pull Request)

Copia [`ejemplos/vsr.yml`](ejemplos/vsr.yml) a `.github/workflows/vsr.yml`. En cada PR, VSR:
- revisa **solo las líneas cambiadas**,
- deja un **comentario con los hallazgos** en el PR,
- sube un **SARIF** para verlos en la pestaña *Security → Code scanning*,
- y falla el check si hay hallazgos de nivel `alta` o superior (configurable).

## Desarrollo

```bash
cforge pruebas/pruebas.cfv          # pruebas
cforge vsr.cfv escanear pruebas/casos
```

Estructura: `src/lexico.cfv` (tokens) · `src/reglas.cfv` (catálogo) · `src/analisis.cfv` (motor) · `vsr.cfv` (CLI, aprendizaje y formatos).

## Licencia

MIT © Vemoris Software
