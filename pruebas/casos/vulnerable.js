const express = require('express')
const { exec } = require('child_process')
const app = express()
app.get('/run', (req, res) => {
  const cmd = req.query.cmd
  exec('ls ' + cmd)
  const id = req.params.id
  db.query(`SELECT * FROM users WHERE id = ${id}`)
  const seguro = parseInt(req.query.n)
  db.query('SELECT * FROM t WHERE n = ?', [seguro])
  document.getElementById('x').innerHTML = req.body.html
  res.redirect(req.query.next)
  fs.readFileSync('/data/' + req.query.file)
  eval(userCode)
  const q = "SELECT * FROM t WHERE name = '" + req.body.name + "'"
  const apiKey = "sk-ant-api03-abcdefghijklmnopqrstuvwxyz0123456789"
  const token = Math.random().toString(36)
  https.request({ rejectUnauthorized: false })
  el.innerHTML = '<b>hola</b>'
  exec('ls -la')
})
