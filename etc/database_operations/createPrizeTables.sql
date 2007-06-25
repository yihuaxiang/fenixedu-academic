CREATE TABLE RESEARCH_PRIZE(
  `ID_INTERNAL` INT(11) NOT NULL,
  `NAME` VARCHAR(255),
  `DESCRIPTION` LONGTEXT,
  `YEAR` INTEGER,
  `KEY_ROOT_DOMAIN_OBJECT` INT(11) NOT NULL DEFAULT '1',
  `KEY_RESEARCH_RESULT` INT(11),	  
   PRIMARY KEY(`ID_INTERNAL`),
   KEY KEY_RESEARCH_RESULT (`KEY_RESEARCH_RESULT`)
) type=InnoDB;

CREATE TABLE PRIZE_WINNERS (
 `KEY_PARTY` INT(11),
 `KEY_PRIZE` INT(11),
  PRIMARY KEY(`KEY_PARTY`, `KEY_PRIZE`),
  KEY KEY_PARTY(`KEY_PARTY`),
  KEY KEY_PRIZE(`KEY_PRIZE`)
) type=InnoDB;
