CREATE TABLE `extra` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(40) NOT NULL,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL
);

CREATE TABLE `brand` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(40) NOT NULL,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL
);

CREATE TABLE `price` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `init_date` DATETIME NOT NULL,
    `end_date` DATETIME NOT NULL,
    `price` INT NOT NULL,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL
);

CREATE TABLE `car` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`model` VARCHAR(40) NOT NULL,
    `brand_id` INT NOT NULL,
    `color` VARCHAR(40) NOT NULL,
    `cc` INT NOT NULL,
    `hp` INT NOT NULL,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL,
    CONSTRAINT `car_brand_fk` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
);

CREATE TABLE `car_price` (
    `car_id` INT,
    `price_id` INT,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL,
    PRIMARY KEY (`car_id`, `price_id`),
    CONSTRAINT `car_car_price_fk` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
    CONSTRAINT `price_car_price_fk` FOREIGN KEY (`price_id`) REFERENCES `price` (`id`)
);

CREATE TABLE `car_extra` (
    `car_id` INT,
    `extra_id` INT,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL,
    PRIMARY KEY (`car_id`, `extra_id`),
    CONSTRAINT `car_car_extra_fk` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
    CONSTRAINT `extra_car_extra_fk` FOREIGN KEY (`extra_id`) REFERENCES `extra` (`id`)
)