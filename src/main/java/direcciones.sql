DROP TABLE IF EXISTS direcciones;
CREATE TABLE direcciones(
	direccion_id SERIAL,
	d_codigo varchar(20),
	d_asenta varchar(250),
	d_tipo_asenta varchar(250),
	D_mnpio varchar(250),
	d_estado varchar(250),
	d_ciudad varchar(250),
	d_CP int,
	c_estado int,
	c_oficina int,
	c_CP int,
	c_tipo_asenta int,
	c_mnpio int,
	id_asenta_cpcons int,
	d_zona varchar(250),
	c_cve_ciudad int,
	CONSTRAINT pk_direccion PRIMARY KEY(direccion_id)
);

COPY direcciones(d_codigo,d_asenta,d_tipo_asenta,D_mnpio,d_estado,d_ciudad,d_CP,c_estado,c_oficina,c_CP,c_tipo_asenta,c_mnpio,id_asenta_cpcons,d_zona,c_cve_ciudad) FROM '/home/aarongmx/Descargas/cpdescarga.csv' DELIMITER '|' CSV HEADER;


alter table direcciones rename column d_tipo_asenta to asentamiento;
alter table direcciones rename column d_codigo to cp;
alter table direcciones rename column d_asenta to colonia;
alter table direcciones rename column D_mnpio to municipio;
alter table direcciones rename column d_estado to estado;
alter table direcciones rename column d_ciudad to ciudad;


alter table direcciones drop column c_estado;
alter table direcciones drop column c_oficina;
alter table direcciones drop column c_cp;
alter table direcciones drop column d_CP;
alter table direcciones drop column c_tipo_asenta;
alter table direcciones drop column c_mnpio;
alter table direcciones drop column id_asenta_cpcons;
alter table direcciones drop column d_zona;
alter table direcciones drop column c_cve_ciudad;
