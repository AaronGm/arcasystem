/**TRUNCATE TABLE empresas RESTART IDENTITY CASCADE;
DELETE FROM empresas;
INSERT INTO empresas(rfc, nombre, encargado, domicilio, colonia, codigo_postal, alcaldia_municipio, ciudad, pagina_web) VALUES('AR231232MX', 'AR Music', 'Aarón Gómez Méndez', 'Calle Antonio Plaza No.12 Edif.4 Depto. 205', 'Citlalli', '09660', 'Iztapalapa', 'CDMX', 'www.armusic.com.mx'),
('CALENT21023EDMX', 'Calentadores Delta', 'Israel Enrique Rocha de la Peña', 'Los Reyes 61', 'San Lucas', '09000', 'Iztapalapa', 'CDMX', 'www.calentadoresdelta.com.mx'),
('DAL870401MGA', 'Delta Air Lines', 'Carlos Martinez Wong', 'Jaime Balmes Nº Ext: 8 Nº Int: 802', 'Los Morales Polanco', '11510', 'Miguel Hidalgo', 'CDMX', 'www.deltaairlines.com.mx'),
('BIM011108', 'Bimbo', 'Juan Rafael Ortiz Martinez', 'MIMOSAS 117', 'SANTA MARIA', '06430', 'CUAUHTEMOC', 'CDMX', 'www.grupobimbo.com.mx');
**/

--insert into alumnos(no_control, nombres, apellido_paterno, apellido_materno, periodo, clave_carrera, semestre) values ('151080126', 'Aarón', 'Gómez', 'Méndez', 'Ago - Dic 2020', 'ISC', 9);
-- Consulta para semanas
select count(proyecto_id) as "proyectos", sum(case when semanas_proyecto=24 then 1 else 0 end) as "semanas16" from proyectos where periodo = 'Ene - Jun 19';

select * from proyectos;



select * from alumnos;

select grado_estudios from profesores;

select * from direcciones;

-- COPY direcciones(d_codigo,d_asenta,d_tipo_asenta,D_mnpio,d_estado,d_ciudad,d_CP,c_estado,c_oficina,c_CP,c_tipo_asenta,c_mnpio,id_asenta_cpcons,d_zona,c_cve_ciudad) FROM '/home/aarongmx/Descargas/cpdescarga.csv' DELIMITER '|' CSV HEADER;
