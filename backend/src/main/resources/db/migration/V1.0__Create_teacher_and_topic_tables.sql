CREATE TABLE teacher (
    id INT NOT NULL AUTO_INCREMENT,
    name NVARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE topic (
    id INT NOT NULL AUTO_INCREMENT,
    name NVARCHAR(64) NOT NULL,
    teacher_id INT NOT NULL REFERENCES teacher(id) ON DELETE CASCADE,
    minimum_final_score DECIMAL(5, 2),
    minimum_attendances INT,
    final_score_formula NVARCHAR(256),
    PRIMARY KEY (id)
);