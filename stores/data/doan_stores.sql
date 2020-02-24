/*
 Navicat Premium Data Transfer

 Source Server         : PostgresSQL
 Source Server Type    : PostgreSQL
 Source Server Version : 110005
 Source Host           : localhost:5432
 Source Catalog        : doan_stores
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 110005
 File Encoding         : 65001

 Date: 24/02/2020 17:52:35
*/


-- ----------------------------
-- Sequence structure for advertises_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."advertises_id_seq";
CREATE SEQUENCE "public"."advertises_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for categories_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."categories_id_seq";
CREATE SEQUENCE "public"."categories_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for images_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."images_id_seq";
CREATE SEQUENCE "public"."images_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for order_details_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."order_details_id_seq";
CREATE SEQUENCE "public"."order_details_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for orders_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."orders_id_seq";
CREATE SEQUENCE "public"."orders_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for products_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."products_id_seq";
CREATE SEQUENCE "public"."products_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for provides_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."provides_id_seq";
CREATE SEQUENCE "public"."provides_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for users_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."users_id_seq";
CREATE SEQUENCE "public"."users_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for warehouse_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."warehouse_id_seq";
CREATE SEQUENCE "public"."warehouse_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for advertises
-- ----------------------------
DROP TABLE IF EXISTS "public"."advertises";
CREATE TABLE "public"."advertises" (
  "id" int8 NOT NULL DEFAULT nextval('advertises_id_seq'::regclass),
  "content" varchar(255) COLLATE "pg_catalog"."default",
  "image_id" int8,
  "link" varchar(255) COLLATE "pg_catalog"."default",
  "status" int4
)
;

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS "public"."categories";
CREATE TABLE "public"."categories" (
  "id" int8 NOT NULL DEFAULT nextval('categories_id_seq'::regclass),
  "content" varchar(255) COLLATE "pg_catalog"."default",
  "deleted" int4,
  "image_id" int8,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "status" int4
)
;

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS "public"."images";
CREATE TABLE "public"."images" (
  "id" int8 NOT NULL DEFAULT nextval('images_id_seq'::regclass),
  "context" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "url" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO "public"."images" VALUES (1, 'admin', '1582517807-1.jpg', '/upload/1582517807-1.jpg');
INSERT INTO "public"."images" VALUES (2, 'admin', '1582532864-1.jpg', '/upload/1582532864-1.jpg');

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS "public"."order_details";
CREATE TABLE "public"."order_details" (
  "id" int8 NOT NULL DEFAULT nextval('order_details_id_seq'::regclass),
  "order_id" int8,
  "product_id" int8,
  "quantity" int4
)
;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS "public"."orders";
CREATE TABLE "public"."orders" (
  "id" int8 NOT NULL DEFAULT nextval('orders_id_seq'::regclass),
  "date" timestamp(6),
  "status" int4,
  "total_money" float8,
  "user_id" int8
)
;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS "public"."products";
CREATE TABLE "public"."products" (
  "id" int8 NOT NULL DEFAULT nextval('products_id_seq'::regclass),
  "category_id" int8,
  "code" varchar(255) COLLATE "pg_catalog"."default",
  "deleted" int4,
  "detail" varchar(255) COLLATE "pg_catalog"."default",
  "image_id" int8,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "price" float8,
  "provide_id" int8,
  "status" int4
)
;

-- ----------------------------
-- Table structure for provides
-- ----------------------------
DROP TABLE IF EXISTS "public"."provides";
CREATE TABLE "public"."provides" (
  "id" int8 NOT NULL DEFAULT nextval('provides_id_seq'::regclass),
  "address" varchar(255) COLLATE "pg_catalog"."default",
  "email" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "phone" varchar(255) COLLATE "pg_catalog"."default",
  "status" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
  "id" int8 NOT NULL DEFAULT nextval('users_id_seq'::regclass),
  "address" varchar(255) COLLATE "pg_catalog"."default",
  "birth_day" timestamp(6),
  "deleted" int4,
  "gender" bool,
  "image_id" int8,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default",
  "phone" varchar(255) COLLATE "pg_catalog"."default",
  "role" varchar(255) COLLATE "pg_catalog"."default",
  "status" int4,
  "username" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO "public"."users" VALUES (1, 'Bac Ninh', '2020-02-06 00:00:00', 2, 'f', 1, 'Dương Văn Đoàn', 'admin', '0975155726', 'ROLE_EMP', 0, 'dichthuyhan188@gmail.com');
INSERT INTO "public"."users" VALUES (2, 'Bac Ninh', '2020-02-13 00:00:00', 2, 'f', 2, 'Admin', 'admin', '0975155726', 'ROLE_EMP', 0, 'admin@ominext.com');

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS "public"."warehouse";
CREATE TABLE "public"."warehouse" (
  "id" int8 NOT NULL DEFAULT nextval('warehouse_id_seq'::regclass),
  "product_id" int8,
  "quantity" int8
)
;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."advertises_id_seq"
OWNED BY "public"."advertises"."id";
SELECT setval('"public"."advertises_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."categories_id_seq"
OWNED BY "public"."categories"."id";
SELECT setval('"public"."categories_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."images_id_seq"
OWNED BY "public"."images"."id";
SELECT setval('"public"."images_id_seq"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."order_details_id_seq"
OWNED BY "public"."order_details"."id";
SELECT setval('"public"."order_details_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."orders_id_seq"
OWNED BY "public"."orders"."id";
SELECT setval('"public"."orders_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."products_id_seq"
OWNED BY "public"."products"."id";
SELECT setval('"public"."products_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."provides_id_seq"
OWNED BY "public"."provides"."id";
SELECT setval('"public"."provides_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."users_id_seq"
OWNED BY "public"."users"."id";
SELECT setval('"public"."users_id_seq"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."warehouse_id_seq"
OWNED BY "public"."warehouse"."id";
SELECT setval('"public"."warehouse_id_seq"', 2, false);

-- ----------------------------
-- Primary Key structure for table advertises
-- ----------------------------
ALTER TABLE "public"."advertises" ADD CONSTRAINT "advertises_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table categories
-- ----------------------------
ALTER TABLE "public"."categories" ADD CONSTRAINT "categories_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table categories
-- ----------------------------
ALTER TABLE "public"."categories" ADD CONSTRAINT "fkqhmw54g2p4xu0k71mblvlqfvi" FOREIGN KEY ("image_id") REFERENCES "public"."images" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Primary Key structure for table images
-- ----------------------------
ALTER TABLE "public"."images" ADD CONSTRAINT "images_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table order_details
-- ----------------------------
ALTER TABLE "public"."order_details" ADD CONSTRAINT "order_details_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table orders
-- ----------------------------
ALTER TABLE "public"."orders" ADD CONSTRAINT "orders_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table orders
-- ----------------------------
ALTER TABLE "public"."orders" ADD CONSTRAINT "fk32ql8ubntj5uh44ph9659tiih" FOREIGN KEY ("user_id") REFERENCES "public"."users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Primary Key structure for table products
-- ----------------------------
ALTER TABLE "public"."products" ADD CONSTRAINT "products_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table products
-- ----------------------------
ALTER TABLE "public"."products" ADD CONSTRAINT "fklmiymnsxvy78xom0eurwg4b7n" FOREIGN KEY ("provide_id") REFERENCES "public"."provides" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."products" ADD CONSTRAINT "fkn18ti2byyc5pbjr9cpjj7qkl9" FOREIGN KEY ("image_id") REFERENCES "public"."images" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."products" ADD CONSTRAINT "fkog2rp4qthbtt2lfyhfo32lsw9" FOREIGN KEY ("category_id") REFERENCES "public"."categories" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Primary Key structure for table provides
-- ----------------------------
ALTER TABLE "public"."provides" ADD CONSTRAINT "provides_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD CONSTRAINT "users_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD CONSTRAINT "fk17herqt2to4hyl5q5r5ogbxk9" FOREIGN KEY ("image_id") REFERENCES "public"."images" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Primary Key structure for table warehouse
-- ----------------------------
ALTER TABLE "public"."warehouse" ADD CONSTRAINT "warehouse_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table warehouse
-- ----------------------------
ALTER TABLE "public"."warehouse" ADD CONSTRAINT "fkow13o6v2o8btmca0nw5pblpss" FOREIGN KEY ("product_id") REFERENCES "public"."products" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
