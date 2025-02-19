-- init.sql para MySQL

-- Definir variables (en MySQL no se definen de la misma manera que en Oracle, se deben pasar directamente o usar variables de sesión si es necesario)
SET @usuario = 'admin'; -- Reemplazar con el valor deseado
SET @password = 'admin'; -- Reemplazar con el valor deseado

-- Verificar si el usuario existe
SELECT COUNT(*) INTO @v_exists FROM mysql.user WHERE user = @usuario;

-- Crear el usuario si no existe
SET @query = '';
IF @v_exists = 0 THEN
    SET @query = CONCAT('CREATE USER ', @usuario, ' IDENTIFIED BY "', @password, '"');
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    
    SET @query = CONCAT('GRANT CONNECT, RESOURCE, CREATE SESSION, CREATE TABLE, DROP, CREATE SEQUENCE ON *.* TO ', @usuario);
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    
    SELECT 'Usuario creado exitosamente' AS mensaje;
ELSE
    SELECT 'El usuario ya existe' AS mensaje;
END IF;
