-- 회의실 --
INSERT INTO space (name, capacity, space_type, map_id, description, image_url, space_number)
VALUES
    ('회의실1', 12, 'OFFICE', 6, NULL, NULL, NULL),
    ('회의실2', 6, 'OFFICE', 8, NULL, NULL, NULL),
    ('회의실3', 10, 'OFFICE', 8, NULL, NULL, NULL),
    ('세미나실', 20, 'OFFICE', 8, NULL, NULL, NULL),
    ('회의실4(복도측)', 4, 'OFFICE', 7, NULL, NULL, NULL),
    ('회의실5(복도측)', 4, 'OFFICE', 7, NULL, NULL, NULL),
    ('회의실6', 4, 'OFFICE', 5, NULL, NULL, NULL);


-- 오픈 데스크 --
INSERT INTO space (name, capacity, space_type, map_id, description, image_url, space_number)
VALUES
    (NULL, NULL, 'DESK', 7, NULL, NULL, '01'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '02'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '03'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '04'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '05'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '06'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '07'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '08'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '09'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '10'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '11'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '12'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '13'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '14'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '15'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '16'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '17'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '18'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '19'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '20'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '21'),
    (NULL, NULL, 'DESK', 7, NULL, NULL, '22');

INSERT INTO space (name, capacity, space_type, map_id, description, image_url, space_number)
VALUES
    (NULL, NULL, 'DESK', 6, NULL, NULL, '01'),
    (NULL, NULL, 'DESK', 6, NULL, NULL, '02'),
    (NULL, NULL, 'DESK', 6, NULL, NULL, '03'),
    (NULL, NULL, 'DESK', 6, NULL, NULL, '04'),
    (NULL, NULL, 'DESK', 6, NULL, NULL, '05'),
    (NULL, NULL, 'DESK', 6, NULL, NULL, '06'),
    (NULL, NULL, 'DESK', 6, NULL, NULL, '07'),
    (NULL, NULL, 'DESK', 6, NULL, NULL, '08'),
    (NULL, NULL, 'DESK', 6, NULL, NULL, '09'),
    (NULL, NULL, 'DESK', 6, NULL, NULL, '10'),
    (NULL, NULL, 'DESK', 6, NULL, NULL, '11'),
    (NULL, NULL, 'DESK', 6, NULL, NULL, '12');

INSERT INTO space (name, capacity, space_type, map_id, description, image_url, space_number)
VALUES
    (NULL, NULL, 'DESK', 5, NULL, NULL, '01'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '02'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '03'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '04'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '05'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '06'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '07'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '08'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '09'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '10'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '11'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '12'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '13'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '14'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '15'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '16'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '17'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '18'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '19'),
    (NULL, NULL, 'DESK', 5, NULL, NULL, '20');

INSERT INTO space (name, capacity, space_type, map_id, description, image_url, space_number)
VALUES
    (NULL, NULL, 'DESK', 8, NULL, NULL, '01'),
    (NULL, NULL, 'DESK', 8, NULL, NULL, '02'),
    (NULL, NULL, 'DESK', 8, NULL, NULL, '03'),
    (NULL, NULL, 'DESK', 8, NULL, NULL, '04'),
    (NULL, NULL, 'DESK', 8, NULL, NULL, '05'),
    (NULL, NULL, 'DESK', 8, NULL, NULL, '06'),
    (NULL, NULL, 'DESK', 8, NULL, NULL, '07'),
    (NULL, NULL, 'DESK', 8, NULL, NULL, '08'),
    (NULL, NULL, 'DESK', 8, NULL, NULL, '09'),
    (NULL, NULL, 'DESK', 8, NULL, NULL, '10'),
    (NULL, NULL, 'DESK', 8, NULL, NULL, '11');

-- 오픈데스크 > 창의관 --

-- 공유 주방 --
INSERT INTO space (name, capacity, space_type, map_id, description, image_url, space_number)
VALUES
    (NULL, NULL, 'KITCHEN', 5, NULL, NULL, '양식1'),
    (NULL, NULL, 'KITCHEN', 5, NULL, NULL, '양식2'),
    (NULL, NULL, 'KITCHEN', 5, NULL, NULL, '한식1'),
    (NULL, NULL, 'KITCHEN', 5, NULL, NULL, '한식2'),
    (NULL, NULL, 'KITCHEN', 5, NULL, NULL, '베이커리'),
    (NULL, NULL, 'KITCHEN', 5, NULL, NULL, '디저트');

-- 촬영실 --
INSERT INTO space (name, capacity, space_type, map_id, description, image_url, space_number)
VALUES ("촬영실", 1, 'STUDIO', 6, NULL, NULL, NULL);