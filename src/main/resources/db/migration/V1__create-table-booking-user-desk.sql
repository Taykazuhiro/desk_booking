create table usuario(

    id bigint not null auto_increment,
    name varchar(255) not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    active tinyint,
    primary key(id)
);

create table desk(

    id bigint not null auto_increment,
    desk_number varchar(100) not null,
    available tinyint,
    primary key(id)
);

create table booking(

    id bigint not null auto_increment,
    desk_id bigint not null,
    usuario_id bigint not null,
    booking_date datetime not null,
    start_time datetime not null,
    end_time datetime not null,
    booking_type varchar(100) not null,

        primary key(id),
        constraint fk_booking_desk_id foreign key(desk_id) references desk(id),
        constraint fk_booking_usuario_id foreign key(usuario_id) references usuario(id)
);