DROP TABLE IF EXISTS t_image_data;
CREATE TABLE t_image_data (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(256) DEFAULT NULL,
  path varchar(128) DEFAULT NULL,
  create_date datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;