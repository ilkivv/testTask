create table cars (
    id bigint not null auto_increment,
    brand_car varchar(255),
    model_car varchar(255),
    state_number varchar(255),
    user_id bigint not null,
primary key (id)
);

create table penalties (
    id bigint not null auto_increment,
    tarrif float,
    type_penalty varchar(255),
    primary key (id)
);

create table users (
id bigint not null auto_increment,
    full_name varchar(255),
    primary key (id)
);

create table car_penalties
(
    car_id bigint not null,
    penalty_id bigint not null
);

alter table car_penalties
    add constraint car_penalties_penalty_fk
    foreign key (penalty_id) references penalties (id);
alter table car_penalties
    add constraint car_penalties_car_fk
    foreign key (car_id) references cars (id);
alter table cars
    add constraint FKqw4c8e6nqrvy3ti1xj8w8wyc9
    foreign key (user_id) references users (id);