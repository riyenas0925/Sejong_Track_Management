create table tbl_rule(
	ruleNo INT NOT NULL AUTO_INCREMENT,
    univ VARCHAR(200) NOT NULL,
    track VARCHAR(200) NOT NULL,
    basic INT NULL,
    applied INT NULL,
    industry INT NULL,
    PRIMARY KEY (ruleNo)
)