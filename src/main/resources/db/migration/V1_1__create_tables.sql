CREATE TABLE `extra` (
    `id` VARCHAR(36) PRIMARY KEY,
    `name` VARCHAR(40) NOT NULL,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL
);

CREATE TABLE `brand` (
    `id` VARCHAR(36) PRIMARY KEY,
    `name` VARCHAR(40) NOT NULL,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL
);

CREATE TABLE `price` (
    `id` VARCHAR(36) PRIMARY KEY,
    `init_date` DATETIME NOT NULL,
    `end_date` DATETIME NOT NULL,
    `amount` INT NOT NULL,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL
);

CREATE TABLE `car` (
	`id` VARCHAR(36) PRIMARY KEY,
	`model` VARCHAR(40) NOT NULL,
    `brand_id` VARCHAR(36) NOT NULL,
    `color` VARCHAR(40) NOT NULL,
    `cc` INT NOT NULL,
    `hp` INT NOT NULL,
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL,
    CONSTRAINT `car_brand_fk` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
);

CREATE TABLE `car_price` (
    `car_id` VARCHAR(36),
    `price_id` VARCHAR(36),
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL,
    PRIMARY KEY (`car_id`, `price_id`),
    CONSTRAINT `car_car_price_fk` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
    CONSTRAINT `price_car_price_fk` FOREIGN KEY (`price_id`) REFERENCES `price` (`id`)
);

CREATE TABLE `car_extra` (
    `car_id` VARCHAR(36),
    `extra_id` VARCHAR(36),
    `created` DATETIME NOT NULL,
    `modified` DATETIME NOT NULL,
    PRIMARY KEY (`car_id`, `extra_id`),
    CONSTRAINT `car_car_extra_fk` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
    CONSTRAINT `extra_car_extra_fk` FOREIGN KEY (`extra_id`) REFERENCES `extra` (`id`)
)