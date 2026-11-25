import Foundation
let args = CommandLine.arguments
let nombre = args[1]
let p = Process()
p.launchPath = "/bin/sh"
p.arguments = ["-c", "echo " + nombre]
let sql = "SELECT * FROM users WHERE name = '\(nombre)'"
sqlite3_exec(db, sql, nil, nil, nil)
UserDefaults.standard.set(token, forKey: "authToken")
webView.loadHTMLString(nombre, baseURL: nil)
let ok = Int(args[2])
let seguro = "SELECT * FROM t WHERE id = ?"
