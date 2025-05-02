DROP DATABASE IF EXISTS melopido;
CREATE DATABASE IF NOT EXISTS melopido;
USE melopido;

-- Table for storing user profiles
CREATE TABLE users (
    id_user varchar(50) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname1 VARCHAR(50) NOT NULL,
    surname2 VARCHAR(50) NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    birth_date DATE NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Table for storing groups
CREATE TABLE groups_detail (
    id_group varchar(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    icon VARCHAR(255) NULL,
    theme ENUM('3_wise_men', 'birthday', 'secret_santa', 'general') NOT NULL,
    description TEXT
);

-- Relationship table for users and groups (many-to-many)
CREATE TABLE user_group (
    id_user varchar(50) REFERENCES users(id_user) ON DELETE CASCADE,
    id_group varchar(50) REFERENCES groups_detail(id_group) ON DELETE CASCADE,
    PRIMARY KEY (id_user, id_group)
);

-- Table for storing letters
CREATE TABLE letters (
    id_letter varchar(50) PRIMARY KEY,
    description TEXT NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    send_date TIMESTAMP NULL,
    expiration_date TIMESTAMP NULL,
    id_user varchar(50) REFERENCES users(id_user) ON DELETE CASCADE,
    id_group varchar(50) NULL REFERENCES groups_detail(id_group) ON DELETE CASCADE
);

-- Table for storing products in letters
CREATE TABLE products (
    id_product varchar(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    detail TEXT NOT NULL,
    url VARCHAR(255) NULL,
    state ENUM('available', 'reserved', 'delivered') DEFAULT 'available',
    assigned_to varchar(50) NULL REFERENCES users(id_user) ON DELETE SET NULL,
    id_letter varchar(50) REFERENCES letters(id_letter) ON DELETE CASCADE
);

-- Table for storing chats related to products
CREATE TABLE chats (
    id_chat varchar(50) PRIMARY KEY,
    id_product varchar(50) UNIQUE REFERENCES products(id_product) ON DELETE CASCADE,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for storing chat messages
CREATE TABLE messages (
    id_message varchar(50) PRIMARY KEY,
    send_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    content TEXT NOT NULL,
    id_chat varchar(50) REFERENCES chats(id_chat) ON DELETE CASCADE,
    sender varchar(50) REFERENCES users(id_user) ON DELETE CASCADE
);