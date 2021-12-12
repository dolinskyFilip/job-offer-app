DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    login         VARCHAR(100) NOT NULL UNIQUE,
    password      VARCHAR(100),
    name          VARCHAR(100),
    creation_date TIMESTAMP,
    PRIMARY KEY (login)

);

drop table if exists job_offer;
CREATE TABLE job_offer
(
    id         BIGINT NOT NULL AUTO_INCREMENT,
    category   VARCHAR(100),
    start_date TIMESTAMP,
    end_date   TIMESTAMP,
    user_name  VARCHAR(100),
        PRIMARY KEY (id)
);