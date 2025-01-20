-- Crear la tabla perfiles si no existe
CREATE TABLE IF NOT EXISTS perfiles (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) UNIQUE NOT NULL,

    PRIMARY KEY(id)
);

-- Crear la tabla usuarios si no existe
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    perfil BIGINT NOT NULL, -- id de perfil

    PRIMARY KEY(id),
    FOREIGN KEY (perfil) REFERENCES perfiles(id)
);

-- Crear la tabla cursos si no existe
CREATE TABLE IF NOT EXISTS cursos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    categoria VARCHAR(50) NOT NULL,

    PRIMARY KEY(id)
);

-- Crear la tabla topicos si no existe
CREATE TABLE IF NOT EXISTS topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    mensaje TEXT NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor BIGINT NOT NULL, -- id de autor
    curso BIGINT NOT NULL, -- id de curso

    PRIMARY KEY(id),
    FOREIGN KEY (autor) REFERENCES usuarios(id),
    FOREIGN KEY (curso) REFERENCES cursos(id),
    UNIQUE KEY (mensaje(255)) -- Índice único para la columna mensaje
);

-- Crear la tabla respuestas si no existe
CREATE TABLE IF NOT EXISTS respuestas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensaje TEXT NOT NULL,
    topico BIGINT NOT NULL, -- id de topico
    fechaCreacion DATETIME NOT NULL,
    autor BIGINT NOT NULL, -- id de autor
    solucion BOOLEAN DEFAULT FALSE, -- campo booleano para marcar la solución

    PRIMARY KEY(id),
    FOREIGN KEY (topico) REFERENCES topicos(id),
    FOREIGN KEY (autor) REFERENCES usuarios(id)
);
