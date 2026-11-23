# DAO de estudiantes con MySQL

El proyecto guarda y consulta estudiantes en MySQL Server 8.0. Usa MySQL Workbench para preparar la base y ver los registros, y Java con Connector/J para ejecutar el programa.

## Preparar la base en Workbench

1. Abre tu conexión local a MySQL Server en Workbench.
2. Abre `schema.sql` con **File → Open SQL Script** y ejecuta todo el script con el botón del rayo. Se crearán la base `universidad_db` y la tabla `estudiantes` si aún no existen.
3. Para consultar los registros desde Workbench, ejecuta `SELECT id, nombre FROM universidad_db.estudiantes ORDER BY id;`.

## Ejecutar con Run en VS Code

Abre la carpeta `DAO` en VS Code con las extensiones de Java habilitadas. Abre `Main.java` y pulsa **Run** sobre `main`. También puedes elegir **DAO - Menú de estudiantes** en **Run and Debug** y pulsar el botón ▶.

En la terminal integrada, escribe el usuario y la contraseña de tu conexión a MySQL. Pulsa Enter para aceptar el usuario que se muestra entre corchetes. Si `MYSQL_PASSWORD` ya está definida en el entorno de VS Code, el programa usa esas credenciales directamente.

- **1** agrega un estudiante. Escribe su ID y su nombre cuando el programa los solicite.
- **2** lista los registros guardados en MySQL.
- **0** cierra el programa.

## Ejecutar el proyecto en PowerShell

Usa Java 17 o superior y abre PowerShell en la carpeta `DAO`. Maven Wrapper descarga Maven y el controlador en la primera ejecución.

Ingresa el mismo usuario y la misma contraseña que utilizas para conectarte a MySQL desde Workbench. El comando solicita la contraseña sin mostrarla en pantalla.

```powershell
$credencial = Get-Credential -UserName 'root' -Message 'Ingresa las credenciales de tu conexión a MySQL'
$env:MYSQL_USER = $credencial.UserName
$env:MYSQL_PASSWORD = $credencial.GetNetworkCredential().Password
```

Si tu conexión en Workbench usa otro host o puerto, configura `MYSQL_HOST` y `MYSQL_PORT` con esos valores. El programa usa `localhost` y `3306` por defecto.

Para listar los estudiantes, ejecuta:

```powershell
.\mvnw.cmd -q compile exec:java
```

Para guardar un estudiante y listar los registros, indica su ID y su nombre. Cada ID debe ser único.

```powershell
.\mvnw.cmd -q compile exec:java@guardar '-Destudiante.id=2324495' '-Destudiante.nombre=Emanuel García'
```

Cuando termines, puedes retirar la contraseña de la sesión con `Remove-Item Env:MYSQL_PASSWORD -ErrorAction SilentlyContinue`.

Los datos del archivo `estudiantes_uaemex.dat` se conservan en ese archivo. La tabla de MySQL comienza vacía si acabas de crearla.
