# P2-Backend-ORII

## Requisitos Previos

### 1. **JDK (Java Development Kit)** - Versión 17 o superior
   - Descárgalo desde [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
   - Configura la variable de entorno `JAVA_HOME`:
     - En **Windows**, ve a **Configuración avanzada del sistema** > **Variables de entorno** y añade la ruta de instalación de JDK en `JAVA_HOME`.
   - Verifica la instalación con:
     ```bash
     java -version
     ```

### 2. **Maven** - Para la gestión de dependencias y construcción del proyecto
   - Descárgalo desde [aquí](https://maven.apache.org/download.cgi) y descomprime el archivo.
   - Añade la ruta del binario de Maven a la variable de entorno `PATH`.
   - Verifica la instalación con:
     ```bash
     mvn -version
     ```

### 3. **Oracle Database** - Base de datos relacional
   - Puedes descargar la base de datos Oracle desde [aquí](https://www.oracle.com/database/technologies/oracle-database-software-downloads.html). También puedes instalar Oracle Express Edition (XE) en Windows o Linux.
   - Asegúrate de que la base de datos esté correctamente configurada y en ejecución.

### 4. **Oracle JDBC Driver** - Necesario para la conexión a Oracle.
   - Descárgalo desde [aquí](https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html) y agrégalo al repositorio local de Maven:
     ```bash
     mvn install:install-file -Dfile=C:\ruta\del\driver\ojdbc8.jar -DgroupId=com.oracle.database.jdbc -DartifactId=ojdbc8 -Dversion=19.3.0.0 -Dpackaging=jar
     ```

### 5. **Postman** (opcional) - Para probar las APIs generadas por Spring Boot.
   - Descárgalo desde [aquí](https://www.postman.com/downloads/).

### 6. **Git** - Para clonar el repositorio y gestionar el control de versiones.
   - Descárgalo desde [Git para Windows](https://git-scm.com/download/win) y sigue las instrucciones de instalación.

### 7. **IDE** (Recomendado: IntelliJ IDEA o Eclipse) - Para facilitar el desarrollo.

## Configuración del Proyecto

### 1. Clonar el repositorio
   ```bash
   git clone https://github.com/tu-usuario/proyecto-spring-boot.git
   cd proyecto-spring-boot
   ```

### 2. Configurar la base de datos Oracle

   - Asegúrate de tener una base de datos Oracle en ejecución.
   - Edita el archivo `src/main/resources/application.properties` con la configuración de tu base de datos Oracle:
     ```properties
     spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
     spring.datasource.username=usuario
     spring.datasource.password=contraseña
     spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect
     ```

### 3. Construir el proyecto con Maven
   ```bash
   mvn clean install
   ```

### 4. Ejecutar la aplicación
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

Puedes consultar los endpoints disponibles accediendo a la documentación Swagger en:
```
http://localhost:8080/swagger-ui.html
```

## Pruebas

Las pruebas unitarias están configuradas con **JUnit** y se pueden ejecutar con Maven:
```bash
mvn test
```

## Contribución

Si deseas contribuir al proyecto:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva funcionalidad'`).
4. Sube tus cambios (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.
