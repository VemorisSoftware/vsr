# 🛡️ Vemoris Security Review (VSR)

[🇪🇸 Español](README.md) · 🇬🇧 English

**Vemoris Software's own** security reviewer, written 100% in **C-Forge**. It reviews code in **11 languages** without depending on any external service: no AI APIs, your code never leaves your machine, and there's no per-review cost.

## Languages

| Language | Files |
|---|---|
| C-Forge | `.cfv` |
| JavaScript / TypeScript | `.js` `.mjs` `.cjs` `.jsx` `.ts` `.tsx` `.vue` `.svelte` |
| Swift | `.swift` (+ `Info.plist`) |
| C / C++ / Objective-C | `.c` `.cpp` `.cc` `.h` `.hpp` `.m` `.mm` |
| Python | `.py` |
| Go | `.go` |
| Rust | `.rs` |
| C# | `.cs` |
| PHP | `.php` `.phtml` |
| Java | `.java` |
| Kotlin | `.kt` `.kts` |

## What it detects

| Rule | Example |
|---|---|
| 🔴 `inyeccion-comandos` (command injection) | `exec("ls " + req.query.dir)`, `system(argv[1])` |
| 🔴 `inyeccion-sql` (SQL injection) | `` db.query(`SELECT … ${id}`) ``, `"SELECT … '\(name)'"` |
| 🔴 `secreto-expuesto` (exposed secret) | AWS, GitHub, Anthropic, Stripe, Slack, Google keys, private keys and high-entropy values |
| 🔴 `desbordamiento-memoria` (buffer overflow) | `strcpy`, `strcat`, `sprintf`, `gets`, `scanf("%s")` |
| 🟠 `xss` | `el.innerHTML = req.body.html`, `dangerouslySetInnerHTML`, `loadHTMLString(...)` |
| 🟠 `recorrido-rutas` (path traversal) | `readFileSync('/data/' + req.query.file)` |
| 🟠 `ssrf` | `fetch(req.query.url)` |
| 🟠 `codigo-dinamico` (dynamic code) | `eval(...)`, `new Function(...)` |
| 🟠 `cadena-formato` (format string) | `printf(argv[1])` |
| 🟠 `deserializacion-insegura` (insecure deserialization) | `pickle.loads(...)`, `unserialize(...)`, `BinaryFormatter`, `ObjectInputStream` |
| 🔴 `inclusion-archivos` (file inclusion) | `include $_GET['page']` (PHP) |
| 🟠 `tls-desactivado` (TLS disabled) | `rejectUnauthorized: false`, `CURLOPT_SSL_VERIFYPEER, 0` |
| 🟡 open redirect, insecure random, insecure storage, ATS disabled | |
| 🔵 weak hash, dynamic regex | |

### How it thinks
1. **Reads code like a compiler:** tokenizes it instead of grepping text.
2. **Follows the data:** tracks what comes from outside (`req.body`, `argv`, `CommandLine.arguments`, `argumentos()`…) through assignments.
3. **Flags external data reaching something dangerous** (shell, SQL, HTML, files, network) unless it first passes through a sanitizer.
4. **Learns from you:** mark a finding as a false positive and it remembers, lowering that rule's confidence in your project.

## Install

Download your platform's binary from [Releases](https://github.com/VemorisSoftware/vsr/releases) (`vsr-macos-arm64`, `vsr-macos`, `vsr-linux`, `vsr-linux-arm64`, `vsr-windows.exe`), or build it with C-Forge: `cforge build vsr.cfv -o vsr --release`.

On macOS the binary isn't signed yet: `xattr -d com.apple.quarantine /usr/local/bin/vsr`.

## Usage

```bash
vsr scan                          # scan the current folder (also: vsr escanear)
vsr scan src --idioma en          # English report
vsr scan --diff main              # only lines changed vs main
vsr scan --formato sarif          # texto | json | sarif | markdown
vsr ignore <fingerprint> [reason] # false positive: VSR learns
vsr confirm <fingerprint>         # real issue
```

Silence a single line with `// vsr:ignorar`. Learning is stored in `.vsr/memoria.json`; commit it to share it with your team.

## On GitHub (every Pull Request)

Copy [`ejemplos/vsr.yml`](ejemplos/vsr.yml) to `.github/workflows/vsr.yml`. On each PR, VSR scans only changed lines, comments the findings, uploads SARIF to *Security → Code scanning*, and fails the check on `alta` (high) or above (configurable).

## License

MIT © Vemoris Software
