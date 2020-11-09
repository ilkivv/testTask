insert into users (id, full_name) values (1, 'Илькив Алексей Витальевич');
insert into users (id, full_name) values (2, 'Иванов Иван Иванович');

insert into cars (id, brand_car, user_id, model_car, state_number) values (1, 'Toyota', 1, 'Spacio', 'С317НН70');
insert into cars (id, brand_car, user_id, model_car, state_number) values (2, 'Toyota', 1, 'Corolla', 'С214ММ70');
insert into cars (id, brand_car, user_id, model_car, state_number) values (3, 'Kia', 2, 'Rio', 'Н500ММ70');

insert into penalties (id, tarrif, type_penalty) values (1, 500, 'превышение скорости');
insert into penalties (id, tarrif, type_penalty) values (2, 400, 'сбил человека');
insert into penalties (id, tarrif, type_penalty) values (3, 1000, 'сбил человека на зебре');
insert into penalties (id, tarrif, type_penalty) values (4, 50, 'сбил хрустика');
insert into penalties (id, tarrif, type_penalty) values (5, 5000, 'проезд на красный');
insert into penalties (id, tarrif, type_penalty) values (6, 2500, 'Проезд на желтый');
insert into penalties (id, tarrif, type_penalty) values (7, 200, 'Пьяный за рулем');
insert into penalties (id, tarrif, type_penalty) values (8, 100, 'Трезвый за рулем');

insert into car_penalties (car_id, penalty_id) values (1, 1);
insert into car_penalties (car_id, penalty_id) values (1, 2);
insert into car_penalties (car_id, penalty_id) values (2, 1);
insert into car_penalties (car_id, penalty_id) values (2, 4);
insert into car_penalties (car_id, penalty_id) values (2, 5);
insert into car_penalties (car_id, penalty_id) values (3, 1);
insert into car_penalties (car_id, penalty_id) values (3, 5);
