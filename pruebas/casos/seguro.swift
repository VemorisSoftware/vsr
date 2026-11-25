let id = Int(CommandLine.arguments[1]) ?? 0
let sql = "SELECT * FROM t WHERE id = ?"
sqlite3_prepare_v2(db, sql, -1, &stmt, nil)
KeychainHelper.save(token, forKey: "authToken")
let p = Process()
p.arguments = ["-la"]
