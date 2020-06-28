CREATE TABLE sequences(
    id INT AUTO_INCREMENT PRIMARY KEY,
    list TEXT NOT NULL,
    winnable TINYINT(1) NOT NULL,
    most_efficient_path TEXT
);