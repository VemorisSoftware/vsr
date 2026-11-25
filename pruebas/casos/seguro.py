from flask import request
def usuario():
    uid = int(request.args.get("id"))
    cursor.execute("SELECT * FROM users WHERE id = %s", (uid,))
    subprocess.run(["ls", "-la"])
    cfg = yaml.load(texto, Loader=yaml.SafeLoader)
    datos = {"a": 1}.get("a")
    nombre = request.args.get("nombre")
    print(f"Hola {nombre}")
