-- MAP 업데이트 --
INSERT INTO space (id, button_image, button_name, content, icon, latitude, location, longitude, name, operation_hours, operation_type, summary, thumbnail, url, map_category_id)
VALUES
    (9,'','입주기업 리스트/공간확인','','https://waba-static.s3.ap-northeast-2.amazonaws.com/%EA%B1%B4%EA%B5%AD%EB%8C%80%ED%95%99%EA%B5%90%EC%BA%A0%ED%8D%BC%EC%8A%A4%ED%83%80%EC%9A%B4%EC%82%AC%EC%97%85%EB%8B%A8/3662170458207113.webp',37.5370182,'',127.073399,'창의관','서울시 광진구 아차산로 272','all','#기업입주공간 #회의실 #시제품 제작실','https://waba-static.s3.ap-northeast-2.amazonaws.com/%EA%B1%B4%EA%B5%AD%EB%8C%80%ED%95%99%EA%B5%90%20%EC%BA%A0%ED%8D%BC%EC%8A%A4%ED%83%80%EC%9A%B4/3276017194637094.webp','/space',3);

-- 회의실 --
INSERT INTO space (name, capacity, space_type, map_id, image_url, space_number)
VALUES
    ('회의실1', 12, 'OFFICE', 6, NULL, NULL),
    ('회의실2', 6, 'OFFICE', 8, NULL, NULL),
    ('회의실3', 10, 'OFFICE', 8, NULL, NULL),
    ('세미나실', 20, 'OFFICE', 8, NULL, NULL),
    ('회의실4(복도측)', 4, 'OFFICE', 7, NULL, NULL),
    ('회의실5(복도측)', 4, 'OFFICE', 7, NULL, NULL),
    ('회의실6', 4, 'OFFICE', 5, NULL, NULL);


-- 오픈 데스크 --
INSERT INTO space (name, capacity, space_type, map_id, image_url, space_number)
VALUES
    (NULL, NULL, 'DESK', 7, NULL, '01'),
    (NULL, NULL, 'DESK', 7, NULL, '02'),
    (NULL, NULL, 'DESK', 7, NULL, '03'),
    (NULL, NULL, 'DESK', 7, NULL, '04'),
    (NULL, NULL, 'DESK', 7, NULL, '05'),
    (NULL, NULL, 'DESK', 7, NULL, '06'),
    (NULL, NULL, 'DESK', 7, NULL, '07'),
    (NULL, NULL, 'DESK', 7, NULL, '08'),
    (NULL, NULL, 'DESK', 7, NULL, '09'),
    (NULL, NULL, 'DESK', 7, NULL, '10'),
    (NULL, NULL, 'DESK', 7, NULL, '11'),
    (NULL, NULL, 'DESK', 7, NULL, '12'),
    (NULL, NULL, 'DESK', 7, NULL, '13'),
    (NULL, NULL, 'DESK', 7, NULL, '14'),
    (NULL, NULL, 'DESK', 7, NULL, '15'),
    (NULL, NULL, 'DESK', 7, NULL, '16'),
    (NULL, NULL, 'DESK', 7, NULL, '17'),
    (NULL, NULL, 'DESK', 7, NULL, '18'),
    (NULL, NULL, 'DESK', 7, NULL, '19'),
    (NULL, NULL, 'DESK', 7, NULL, '20'),
    (NULL, NULL, 'DESK', 7, NULL, '21'),
    (NULL, NULL, 'DESK', 7, NULL, '22');

INSERT INTO space (name, capacity, space_type, map_id, image_url, space_number)
VALUES
    (NULL, NULL, 'DESK', 6, NULL, '01'),
    (NULL, NULL, 'DESK', 6, NULL, '02'),
    (NULL, NULL, 'DESK', 6, NULL, '03'),
    (NULL, NULL, 'DESK', 6, NULL, '04'),
    (NULL, NULL, 'DESK', 6, NULL, '05'),
    (NULL, NULL, 'DESK', 6, NULL, '06'),
    (NULL, NULL, 'DESK', 6, NULL, '07'),
    (NULL, NULL, 'DESK', 6, NULL, '08'),
    (NULL, NULL, 'DESK', 6, NULL, '09'),
    (NULL, NULL, 'DESK', 6, NULL, '10'),
    (NULL, NULL, 'DESK', 6, NULL, '11'),
    (NULL, NULL, 'DESK', 6, NULL, '12');

INSERT INTO space (name, capacity, space_type, map_id, image_url, space_number)
VALUES
    (NULL, NULL, 'DESK', 5, NULL, '01'),
    (NULL, NULL, 'DESK', 5, NULL, '02'),
    (NULL, NULL, 'DESK', 5, NULL, '03'),
    (NULL, NULL, 'DESK', 5, NULL, '04'),
    (NULL, NULL, 'DESK', 5, NULL, '05'),
    (NULL, NULL, 'DESK', 5, NULL, '06'),
    (NULL, NULL, 'DESK', 5, NULL, '07'),
    (NULL, NULL, 'DESK', 5, NULL, '08'),
    (NULL, NULL, 'DESK', 5, NULL, '09'),
    (NULL, NULL, 'DESK', 5, NULL, '10'),
    (NULL, NULL, 'DESK', 5, NULL, '11'),
    (NULL, NULL, 'DESK', 5, NULL, '12'),
    (NULL, NULL, 'DESK', 5, NULL, '13'),
    (NULL, NULL, 'DESK', 5, NULL, '14'),
    (NULL, NULL, 'DESK', 5, NULL, '15'),
    (NULL, NULL, 'DESK', 5, NULL, '16'),
    (NULL, NULL, 'DESK', 5, NULL, '17'),
    (NULL, NULL, 'DESK', 5, NULL, '18'),
    (NULL, NULL, 'DESK', 5, NULL, '19'),
    (NULL, NULL, 'DESK', 5, NULL, '20');

INSERT INTO space (name, capacity, space_type, map_id, image_url, space_number)
VALUES
    (NULL, NULL, 'DESK', 8, NULL, '01'),
    (NULL, NULL, 'DESK', 8, NULL, '02'),
    (NULL, NULL, 'DESK', 8, NULL, '03'),
    (NULL, NULL, 'DESK', 8, NULL, '04'),
    (NULL, NULL, 'DESK', 8, NULL, '05'),
    (NULL, NULL, 'DESK', 8, NULL, '06'),
    (NULL, NULL, 'DESK', 8, NULL, '07'),
    (NULL, NULL, 'DESK', 8, NULL, '08'),
    (NULL, NULL, 'DESK', 8, NULL, '09'),
    (NULL, NULL, 'DESK', 8, NULL, '10'),
    (NULL, NULL, 'DESK', 8, NULL, '11');

-- 오픈데스크 > 창의관 --
INSERT INTO space (name, capacity, space_type, map_id, image_url, space_number)
VALUES
    (NULL, NULL, 'DESK', 9, NULL, '01'),
    (NULL, NULL, 'DESK', 9, NULL, '02'),
    (NULL, NULL, 'DESK', 9, NULL, '03'),
    (NULL, NULL, 'DESK', 9, NULL, '04'),
    (NULL, NULL, 'DESK', 9, NULL, '05'),
    (NULL, NULL, 'DESK', 9, NULL, '06'),
    (NULL, NULL, 'DESK', 9, NULL, '07'),
    (NULL, NULL, 'DESK', 9, NULL, '08'),
    (NULL, NULL, 'DESK', 9, NULL, '09'),
    (NULL, NULL, 'DESK', 9, NULL, '10'),
    (NULL, NULL, 'DESK', 9, NULL, '11'),
    (NULL, NULL, 'DESK', 9, NULL, '12'),
    (NULL, NULL, 'DESK', 9, NULL, '13'),
    (NULL, NULL, 'DESK', 9, NULL, '14'),
    (NULL, NULL, 'DESK', 9, NULL, '15'),
    (NULL, NULL, 'DESK', 9, NULL, '16'),
    (NULL, NULL, 'DESK', 9, NULL, '17'),
    (NULL, NULL, 'DESK', 9, NULL, '18'),
    (NULL, NULL, 'DESK', 9, NULL, '19'),
    (NULL, NULL, 'DESK', 9, NULL, '20');


-- 공유 주방 --
INSERT INTO space (name, capacity, space_type, map_id, image_url, space_number)
VALUES
    (NULL, NULL, 'KITCHEN', 5, NULL, '양식1'),
    (NULL, NULL, 'KITCHEN', 5, NULL, '양식2'),
    (NULL, NULL, 'KITCHEN', 5, NULL, '한식1'),
    (NULL, NULL, 'KITCHEN', 5, NULL, '한식2'),
    (NULL, NULL, 'KITCHEN', 5, NULL, '베이커리'),
    (NULL, NULL, 'KITCHEN', 5, NULL, '디저트');

-- 촬영실 --
INSERT INTO space (name, capacity, space_type, map_id, image_url, space_number)
VALUES ("촬영실", 1, 'STUDIO', 6, NULL, NULL);