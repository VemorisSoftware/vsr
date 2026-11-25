import os, subprocess, pickle, yaml, requests
from flask import request, render_template_string
@app.route("/u")
def usuario():
    nombre = request.args.get("nombre")
    os.system("grep " + nombre + " datos.txt")
    cursor.execute(f"SELECT * FROM users WHERE name = '{nombre}'")
    cursor.execute("SELECT * FROM t WHERE id = %s" % nombre)
    subprocess.run(nombre, shell=True)
    open("/datos/" + nombre).read()
    requests.get(request.args["url"])
    eval(request.form["code"])
    obj = pickle.loads(request.data)
    cfg = yaml.load(texto)
    requests.get("https://api.ejemplo.cl", verify=False)
    return render_template_string(nombre)
API_KEY = "AKIAQWERTYUIOPASDFGHJ"
db_password = "Xk92mPq7Lw3nZr8T"
