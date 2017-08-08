CREATE SCHEMA `echo`;

CREATE TABLE `echo`.`message` (
  `message_id` VARCHAR(32) NOT NULL,
  `message` VARCHAR(4096) NOT NULL,
  PRIMARY KEY (`message_id`));