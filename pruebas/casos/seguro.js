const { execFile } = require('child_process')
app.get('/u/:id', async (req, res) => {
  const id = Number(req.params.id)
  const fila = await db.query('SELECT * FROM users WHERE id = $1', [id])
  el.textContent = req.body.nombre
  execFile('ls', ['-la'])
  const apiKey = process.env.API_KEY
  const ejemplo = "sk-ant-EXAMPLE-xxxxxxxxxxxxxxxxxxxxxxxx"
  res.redirect('/inicio')
  process.stdout.write(JSON.stringify(fila))
  const token = crypto.randomUUID()
})
