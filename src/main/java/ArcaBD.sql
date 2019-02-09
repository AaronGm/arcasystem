-- CREATE DATABASE arca;

-- CARGAR MODULO DE ENCRIPTACION
-- CREATE EXTENSION pgcrypto;

-- Enumerado para los grados de estudio
DROP TYPE grado_estudios CASCADE;
CREATE TYPE grado_estudios AS ENUM ('Licenciatura', 'Ingeniería', 'Maestría', 'Doctorado');

--Enumerado para el estatus del proyecto
-- DROP TYPE estado_proyecto CASCADE;
-- CREATE TYPE estado_proyecto AS ENUM('----', 'Aceptado', 'Rechazado');

DROP TYPE estado_profesor CASCADE;
CREATE TYPE estado_profesor AS ENUM('Tiempo Completo', 'Clave 10', 'Clave 20', 'Clave 95', 'Por Horario', 'Por Asignatura');


DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
    usuario_id SERIAL,
    usuario VARCHAR(60) NOT NULL,
    passwd TEXT NOT NULL,
    is_admin BOOLEAN NOT NULL DEFAULT '0',
    CONSTRAINT pk_usuario PRIMARY KEY(usuario_id)
);

-- Tabla para heredar propiedades de personas
DROP TABLE IF EXISTS personas CASCADE;
CREATE TABLE personas (
    nombres VARCHAR(60) NOT NULL,
    apellido_paterno VARCHAR(30) NOT NULL,
    apellido_materno VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS carreras;
CREATE TABLE carreras (
    clave_carrera VARCHAR(3) NOT NULL,
    nombre VARCHAR(190) NOT NULL,
    plan_estudios VARCHAR NOT NULL
);

DROP TABLE IF EXISTS alumnos;
CREATE TABLE alumnos (
    no_control VARCHAR(10) NOT NULL,
    semestre SMALLINT NOT NULL,
    clave_carrera VARCHAR(3) NOT NULL,
    periodo VARCHAR(120) NOT NULL
) INHERITS(personas);


DROP TABLE IF EXISTS profesores;
CREATE TABLE profesores (
    profesor_id SERIAL,
    no_trabajador VARCHAR(5) NOT NULL,
    fecha_ingreso DATE NOT NULL DEFAULT CURRENT_DATE,
    grado_estudios grado_estudios,
    estatus_profesor estado_profesor,
    area_especialidad VARCHAR(200) NOT NULL
) INHERITS(personas);

DROP TABLE IF EXISTS expedientes;
CREATE TABLE expedientes (
    expediente_id SERIAL,
    carta_inicio BOOLEAN NOT NULL DEFAULT '0',
    cronograma BOOLEAN NOT NULL DEFAULT '0',
    asesorias BOOLEAN NOT NULL DEFAULT '0',
    evaluacion_seguimiento BOOLEAN NOT NULL DEFAULT '0',
    formato_evaluacion BOOLEAN NOT NULL DEFAULT '0',
    discos BOOLEAN NOT NULL DEFAULT '0',
    carta_termino BOOLEAN NOT NULL DEFAULT '0',
    carta_liberacion BOOLEAN NOT NULL DEFAULT '0',
    observaciones TEXT DEFAULT 'Ninguna',
    estatus VARCHAR(20) NOT NULL DEFAULT 'VACIO',
    no_control VARCHAR(10) NOT NULL
);

DROP TABLE IF EXISTS proyectos cascade;
CREATE TABLE proyectos (
    proyecto_id SERIAL,
    nombre VARCHAR(250) NOT NULL,
    semanas_proyecto INT NOT NULL,
    periodo VARCHAR(160) NOT NULL,
    fecha_inicio DATE NOT NULL DEFAULT CURRENT_DATE,
    fecha_termino DATE NOT NULL DEFAULT CAST(CURRENT_DATE + interval '4  month' AS DATE),
    estatus BOOLEAN NOT NULL DEFAULT '0'
);

DROP TABLE IF EXISTS empresas CASCADE;
CREATE TABLE empresas (
    empresa_id SERIAL,
    rfc VARCHAR(15) NOT NULL UNIQUE,
    nombre VARCHAR(200) NOT NULL,
    encargado VARCHAR(255) NOT NULL,
    domicilio VARCHAR(255) NOT NULL,
    colonia VARCHAR(200) NOT NULL,
    codigo_postal CHAR(5) NOT NULL,
    alcaldia_municipio VARCHAR(200) NOT NULL,
    ciudad VARCHAR(255) NOT NULL,
    pagina_web VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS asesores_externos;
CREATE TABLE asesores_externos (
    asesor_externo_id SERIAL,
    cargo VARCHAR(180) NOT NULL,
    empresa_id INT NOT NULL
) INHERITS(personas);

DROP TABLE IF EXISTS asesores_internos CASCADE;
CREATE TABLE asesores_internos (
    asesor_interno_id SERIAL,
    profesor_id INT NOT NULL
);

DROP TABLE IF EXISTS alumnos_asesores_internos CASCADE;
CREATE TABLE alumnos_asesores_internos (
    asignacion_alumno_asesor_id SERIAL,
    no_control VARCHAR(10) NOT NULL,
    asesor_interno_id INT NOT NULL
);

DROP TABLE IF EXISTS revisores;
CREATE TABLE revisores (
    revisor_id SERIAL,
    profesor_id INT NOT NULL,
    no_control VARCHAR(10) NOT NULL
);


-- Tablas para correos y telefonos

DROP TABLE IF EXISTS correos_alumno CASCADE;
CREATE TABLE correos_alumno(
    correo_id SERIAL,
    correo VARCHAR(180) NOT NULL,
    no_control VARCHAR(10) NOT NULL,
    CONSTRAINT pk_correo_alumno PRIMARY KEY(correo_id)
);


DROP TABLE IF EXISTS correos_empresa CASCADE;
CREATE TABLE correos_empresa (
    correo_id SERIAL,
    correo VARCHAR(180) NOT NULL,
    empresa_id INT NOT NULL,
    CONSTRAINT pk_correo_empresa PRIMARY KEY(correo_id)
);

DROP TABLE IF EXISTS telefonos_empresa CASCADE;
CREATE TABLE telefonos_empresa (
    telefono_id SERIAL,
    telefono VARCHAR(15) NOT NULL,
    empresa_id INT NOT NULL,
    CONSTRAINT pk_telefono_empresa PRIMARY KEY(telefono_id)
);

DROP TABLE IF EXISTS correos_asesor_externo CASCADE;
CREATE TABLE correos_asesor_externo (
    correo_id SERIAL,
    correo VARCHAR(180) NOT NULL,
    asesor_externo_id INT NOT NULL,
    CONSTRAINT pk_correo_asesor_externo PRIMARY KEY(correo_id)
);

DROP TABLE IF EXISTS telefonos_asesor_externo CASCADE;
CREATE TABLE telefonos_asesor_externo (
    telefono_id SERIAL,
    telefono VARCHAR(15) NOT NULL,
    asesor_externo_id INT NOT NULL,
    CONSTRAINT pk_telefono_asesor_extenro PRIMARY KEY(telefono_id)
);

DROP TABLE IF EXISTS correos_profesor CASCADE;
CREATE TABLE correos_profesor (
    correo_id SERIAL,
    correo VARCHAR(180) NOT NULL,
    profesor_id INT NOT NULL,
    CONSTRAINT pk_correo_profesor PRIMARY KEY(correo_id)
);

 DROP TABLE IF EXISTS telefonos_profesor CASCADE;
CREATE TABLE telefonos_profesor (
    telefono_id SERIAL,
    telefono VARCHAR(15) NOT NULL,
    profesor_id INT NOT NULL,
    CONSTRAINT pk_telefono_profesor PRIMARY KEY(telefono_id)
);


DROP TABLE IF EXISTS historial_residentes cascade;
CREATE TABLE historial_residentes (
    historial_id SERIAL,
    no_control VARCHAR(10) NOT NULL,
    empresa_id INT NOT NULL,
    proyecto_id INT NOT NULL,
    asesor_externo_id INT NOT NULL,
    asignacion_alumno_asesor_id INT NOT NULL
);


DROP TABLE IF EXISTS direcciones;
COMMENT ON TABLE direcciones IS 'Tabla para facilitar la escritura de direcciones';
CREATE TABLE direcciones(
	direccion_id SERIAL,
	cp varchar(20) NOT NULL,
	colonia varchar(250) NOT NULL,
	asentamiento varchar(250) NOT NULL,
	municipio varchar(250) NOT NULL,
	estado varchar(250) NOT NULL,
	ciudad varchar(250) NOT NULL,
	CONSTRAINT pk_direccion PRIMARY KEY(direccion_id)
);

-- Agregando llaves primarias
ALTER TABLE carreras ADD CONSTRAINT pk_carrera PRIMARY KEY(clave_carrera);
ALTER TABLE alumnos ADD CONSTRAINT pk_alumno PRIMARY KEY(no_control);
ALTER TABLE profesores ADD CONSTRAINT pk_profesor PRIMARY KEY(profesor_id);
ALTER TABLE expedientes ADD CONSTRAINT pk_expediente PRIMARY KEY(expediente_id);
ALTER TABLE proyectos ADD CONSTRAINT pk_proyecto PRIMARY KEY(proyecto_id);
ALTER TABLE empresas ADD CONSTRAINT pk_empresa PRIMARY KEY(empresa_id);
ALTER TABLE asesores_externos ADD CONSTRAINT pk_asesor_externo PRIMARY KEY(asesor_externo_id);
ALTER TABLE asesores_internos ADD CONSTRAINT pk_asesor_interno PRIMARY KEY(asesor_interno_id);
ALTER TABLE revisores ADD CONSTRAINT pk_revisor PRIMARY KEY(revisor_id);
ALTER TABLE historial_residentes ADD CONSTRAINT pk_historial_residente PRIMARY KEY(historial_id);
ALTER TABLE alumnos_asesores_internos ADD CONSTRAINT pk_alumno_asesor_interno PRIMARY KEY
(asignacion_alumno_asesor_id);

-- Relaciones entre tablas
ALTER TABLE alumnos
    ADD CONSTRAINT fk_alumno_carrera FOREIGN KEY(clave_carrera) REFERENCES carreras(clave_carrera) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE expedientes
    ADD CONSTRAINT fk_expediente_alumno FOREIGN KEY(no_control) REFERENCES alumnos(no_control) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE asesores_externos
    ADD CONSTRAINT fk_asesor_externo_empresa FOREIGN KEY(empresa_id) REFERENCES empresas(empresa_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE asesores_internos
    ADD CONSTRAINT fk_asesor_interno_profesor FOREIGN KEY(profesor_id) REFERENCES profesores(profesor_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE alumnos_asesores_internos
    ADD CONSTRAINT fk_alumno_asesor_interno_asesor FOREIGN KEY(asesor_interno_id) REFERENCES asesores_internos(asesor_interno_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
    ADD CONSTRAINT fk_alumno_asesor_interno_alumno FOREIGN KEY(no_control) REFERENCES alumnos(no_control) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE revisores
    ADD CONSTRAINT fk_revisor_profesor FOREIGN KEY(profesor_id) REFERENCES profesores(profesor_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
    ADD CONSTRAINT fk_revisor_alumno FOREIGN KEY(no_control) REFERENCES alumnos(no_control) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE historial_residentes
    ADD CONSTRAINT fk_historial_alumno FOREIGN KEY(no_control) REFERENCES alumnos(no_control) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
   	add constraint fk_historial_empresa foreign key(empresa_id) references empresas(empresa_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
  	add constraint fk_historial_proyecto foreign key(proyecto_id) references proyectos(proyecto_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
  	add constraint fk_historial_asesor_externo foreign key(asesor_externo_id) references asesores_externos(asesor_externo_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE correos_profesor
    ADD CONSTRAINT fk_correo_profesor FOREIGN KEY(profesor_id) REFERENCES profesores(profesor_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE telefonos_profesor
    ADD CONSTRAINT fk_telefono_profesor FOREIGN KEY(profesor_id) REFERENCES profesores(profesor_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE correos_empresa
    ADD CONSTRAINT fk_correo_empresa FOREIGN KEY(empresa_id) REFERENCES empresas(empresa_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE telefonos_empresa
    ADD CONSTRAINT fk_telefono_empresa FOREIGN KEY(empresa_id) REFERENCES empresas(empresa_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE correos_asesor_externo
    ADD CONSTRAINT fk_correo_asesor_externo FOREIGN KEY(asesor_externo_id) REFERENCES asesores_externos(asesor_externo_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE telefonos_asesor_externo
    ADD CONSTRAINT fk_telefono_asesor_extenro FOREIGN KEY(asesor_externo_id) REFERENCES asesores_externos(asesor_externo_id) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE;

-- Crear un usuario
INSERT INTO usuarios(usuario, passwd) VALUES ('aarongm', crypt('aagmx', gen_salt('xdes')));

-- Insertar datos de las carreras
INSERT INTO carreras(clave_carrera, nombre, plan_estudios)
VALUES
('ISC', 'Ingeniería en Sistemas Computacionales', 'ISIC-2010-224'),
('IME', 'Ingeniería Mecatrónica', 'IMCT-2010-229'),
('IND', 'Ingeniería Industrial', 'IIND-2010-227'),
('IGE', 'Ingenireía en Gestión Empresarial', 'IGEM-2009-201');

-- SELECT * FROM usuarios;
-- SELECT usuario_id, usuario, passwd, is_admin FROM usuarios;

/*
    Secuencia de pasos para usar la BD
    1. Tener registradas las carreras
    2. Registrar a los profesores de cada carrera
    3. Registrar proyecto
    4. Registrar empresa
    5. Registrar Asesor externo
    6. Registrar Alumno
    7. (Si el proyecto fue aceptado) Registrar asesor interno
    8. 
*/

-- SELECT unnest(enum_range(NULL::estado_profesor)) AS estados;
-- SELECT * FROM carreras;

-- SELECT usuario, passwd, is_admin FROM usuarios WHERE usuario = 'aarongm' AND passwd = crypt('aagmx', gen_salt('xdes'))

/** Copyright Aarón Gómez Méndez 2019© **/
