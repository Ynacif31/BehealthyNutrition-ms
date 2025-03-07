CREATE TABLE IF NOT EXISTS tb_role (
                                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       authority VARCHAR(50) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS tb_user (
                                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    password VARCHAR(255) NOT NULL
    );


CREATE TABLE IF NOT EXISTS tb_user_role (
                                            user_id BIGINT NOT NULL,
                                            role_id BIGINT NOT NULL,
                                            PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES tb_role(id) ON DELETE CASCADE
    );

INSERT INTO tb_role (id, authority) VALUES (1,'ROLE_NUTRITIONIST');
INSERT INTO tb_role (id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO tb_role (id, authority) VALUES (3,'ROLE_PATIENT');