DROP TABLE IF EXISTS PRODUCT_DETAILS;

CREATE TABLE PRODUCT_DETAILS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(250) NOT NULL,
  brand VARCHAR(250) NOT NULL,
  color VARCHAR(250) NOT NULL,
  price DOUBLE NOT NULL,
  size INT NOT NULL,
  no_of_product INT NOT NULL,
  seller VARCHAR(250) NOT NULL,
  region VARCHAR(250) DEFAULT NULL,
  description VARCHAR(250) DEFAULT NULL
);

INSERT INTO PRODUCT_DETAILS (category, brand, color, price, size, no_of_product, seller, region, description) VALUES
  ('Shirts', 'Puma', 'Red', 110, 40, 11, 'Abc', 'Asia', null),
  ('Shirts', 'Puma', 'Red', 110, 40, 11, 'Abc', 'Asia', null),

  ('Shirts', 'Nike', 'Black', 110, 40, 11, 'Abc', 'Asia', null),

  ('Pants', 'Puma', 'Red', 110, 40, 11, 'Abc', 'Asia', null),
  ('Caps', 'Puma', 'Black', 110, 40, 11, 'Abc', 'Asia', null),

  ('Shirts', 'Adidas', 'Blue', 100, 42, 99, 'Abc', 'Asia', null),
  ('Shirts', 'Adidas', 'Blue', 100, 42, 23, 'Abc', 'Asia', null),
  ('Pants', 'Adidas', 'Blue', 100, 42, 44, 'Abc', 'Asia', null),
  ('Caps', 'Adidas', 'Blue', 100, 42, 24, 'Abc', 'Asia', null),

  ('Shirts', 'Reebok', 'Pink', 120, 44, 56, 'Abc', 'Asia', null),
  ('Shirts', 'Reebok', 'Pink', 120, 44, 78, 'Abc', 'Asia', null),

  ('Shirts', 'Test', 'Red', 110, 40, 11, 'Abc', 'Asia', null),
  ('Shirts', 'Nike', 'Red', 110, 40, 11, 'Abc', 'Asia', null),

  ('Pants', 'Reebok', 'Pink', 120, 44, 121, 'Abc', 'Asia', null),
  ('Caps', 'Reebok', 'Pink', 120, 44, 45, 'Abc', 'Asia', null),
  ('Shirts', 'Test', 'Pink', 110, 40, 11, 'Abc', 'Asia', null);
