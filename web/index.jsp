<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/estilo.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="container">
    <h1>Ejemplo de Procedimiento Almaceado</h1>
  <form method="post" action="connected">
    <div class="form-group">
      <label for="ApPaterno">Apellido Paterno</label>
      <input type="text" class="form-control" id="ApPaterno" name="ApPaterno">
    </div>
    <div class="form-group">
      <label for="ApMaterno">Apellido Materno</label>
      <input type="text" class="form-control" id="ApMaterno" name="ApMaterno">
    </div>
    <div class="form-group">
      <label for="Nombre">Nombre(s)</label>
      <input type="text" class="form-control" id="Nombre" name="Nombre">
    </div>
    <div class="radio-inline">
      <label><input type="radio" name="Sexo" value="M">Masculino</label>
    </div>
    <div class="radio-inline">
      <label><input type="radio" name="Sexo" value="F">Femenino</label>
    </div>
    <div class="form-group">
      <label for="Edad">Edad</label>
      <input type="number" class="form-control" name="Edad" id="Edad" min="18" max="50">
    </div>
    <div class="form-group">
    <button type="submit" class="btn btn-default">Guardar</button>
    </div>
  </form>
<a href="Lista">Ver Lista</a>
  </div>
  </body>
</html>
