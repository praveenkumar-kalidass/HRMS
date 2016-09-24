
    alter table allowance_variant 
        drop 
        foreign key FK_m83glvf3yjsvynbmgx63dsvr7;

    alter table app_user 
        drop 
        foreign key FK_1mck9a7x78aoytkb3my91fbcv;

    alter table attendance 
        drop 
        foreign key FK_5gisgrvq90fxbmp9xdygfdugl;

    alter table certification 
        drop 
        foreign key FK_25e310un0rlky4bwm9k552kbd;

    alter table designation 
        drop 
        foreign key FK_7cxvjsh80973d9m32kwar60s;

    alter table education 
        drop 
        foreign key FK_9f4iojhis1eml9hi90aowdpyp;

    alter table leaverequest 
        drop 
        foreign key FK_8g3aj3agnh0bigvfiyw3ofdmf;

    alter table project 
        drop 
        foreign key FK_pd0f41nfpvncngygkesu8mk9n;

    alter table projectrelease 
        drop 
        foreign key FK_k06k5qaakkihl3htx8woesdst;

    alter table salary 
        drop 
        foreign key FK_qrfuqlo1a5flxjufhrewyoj3i;

    alter table team 
        drop 
        foreign key FK_bsgqgukhojgbhthllr7mvkect;

    alter table team 
        drop 
        foreign key FK_kisr7bcgtyyed1c9on0a593w2;

    alter table user_address 
        drop 
        foreign key FK_m3t1qb7j0fluav2a0kphxyoue;

    alter table user_address 
        drop 
        foreign key FK_kfu0161nvirkey6fwd6orucv7;

    alter table user_role 
        drop 
        foreign key FK_it77eq964jhfqtu54081ebtio;

    alter table user_role 
        drop 
        foreign key FK_apcc8lxk2xnug8377fatvbn04;

    drop table if exists address;

    drop table if exists allowance_variant;

    drop table if exists app_user;

    drop table if exists attendance;

    drop table if exists certification;

    drop table if exists client;

    drop table if exists department;

    drop table if exists designation;

    drop table if exists education;

    drop table if exists leaverequest;

    drop table if exists project;

    drop table if exists projectrelease;

    drop table if exists role;

    drop table if exists salary;

    drop table if exists team;

    drop table if exists user_address;

    drop table if exists user_role;

    create table address (
        id integer not null auto_increment,
        type varchar(255),
        city varchar(255),
        country varchar(255),
        e_mail varchar(255),
        phonenumber varchar(255),
        pincode integer,
        state varchar(255),
        street varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table allowance_variant (
        id integer not null auto_increment,
        dearness_allowance float,
        houserent_allowance float,
        medical_allowance float,
        provident_fund float,
        designation_id integer,
        primary key (id)
    ) ENGINE=InnoDB;

    create table app_user (
        id bigint not null auto_increment,
        account_expired bit not null,
        account_locked bit not null,
        bank_account_number varchar(50),
        basicPay varchar(255),
        credentials_expired bit not null,
        date_of_birth DATE,
        date_of_joining DATE,
        email varchar(255),
        account_enabled bit,
        father_name varchar(50),
        first_name varchar(50) not null,
        gender varchar(50),
        last_name varchar(50) not null,
        marital_status varchar(50),
        password varchar(255) not null,
        password_hint varchar(255),
        phone_number varchar(255),
        picture varchar(50),
        username varchar(50) not null,
        version integer,
        website varchar(255),
        designation_id integer,
        primary key (id)
    ) ENGINE=InnoDB;

    create table attendance (
        id integer not null auto_increment,
        date varchar(255),
        time_in varchar(255),
        time_out varchar(255),
        user_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;

    create table certification (
        id integer not null auto_increment,
        course_name varchar(255),
        from_date varchar(255),
        institution varchar(255),
        to_date varchar(255),
        user_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;

    create table client (
        id integer not null auto_increment,
        city varchar(255),
        name varchar(255),
        country varchar(255),
        e_mail varchar(255),
        phone_number varchar(255),
        state varchar(255),
        street varchar(255),
        website varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table department (
        id integer not null auto_increment,
        name varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table designation (
        id integer not null auto_increment,
        name varchar(255),
        department_id integer not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table education (
        id integer not null auto_increment,
        board varchar(255),
        from_date varchar(255),
        institution varchar(255),
        percentage varchar(255),
        qualification varchar(255),
        to_date varchar(255),
        type varchar(255),
        user_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;

    create table leaverequest (
        id integer not null auto_increment,
        from_date varchar(255),
        reason varchar(255),
        status varchar(255),
        to_date varchar(255),
        no_days integer,
        user_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;

    create table project (
        id integer not null auto_increment,
        description varchar(255),
        from_date varchar(255),
        name varchar(255),
        status varchar(255),
        client_id integer not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table projectrelease (
        id integer not null auto_increment,
        description varchar(255),
        project_version varchar(255),
        date varchar(255),
        project_id integer not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table role (
        id bigint not null auto_increment,
        description varchar(64),
        name varchar(20),
        primary key (id)
    ) ENGINE=InnoDB;

    create table salary (
        id integer not null auto_increment,
        basic_pay float,
        dearness_allowance float,
        houserent_allowance float,
        loss_of_pay float,
        medical_allowance float,
        no_days integer,
        provident_fund float,
        total_amount float,
        user_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;

    create table team (
        id integer not null auto_increment,
        role varchar(255),
        project_id integer not null,
        user_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table user_address (
        user_id bigint not null,
        address_id integer not null
    ) ENGINE=InnoDB;

    create table user_role (
        user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) ENGINE=InnoDB;

    alter table app_user 
        add constraint UK_1j9d9a06i600gd43uu3km82jw  unique (email);

    alter table app_user 
        add constraint UK_3k4cplvh82srueuttfkwnylq0  unique (username);

    alter table allowance_variant 
        add constraint FK_m83glvf3yjsvynbmgx63dsvr7 
        foreign key (designation_id) 
        references designation (id);

    alter table app_user 
        add constraint FK_1mck9a7x78aoytkb3my91fbcv 
        foreign key (designation_id) 
        references designation (id);

    alter table attendance 
        add constraint FK_5gisgrvq90fxbmp9xdygfdugl 
        foreign key (user_id) 
        references app_user (id);

    alter table certification 
        add constraint FK_25e310un0rlky4bwm9k552kbd 
        foreign key (user_id) 
        references app_user (id);

    alter table designation 
        add constraint FK_7cxvjsh80973d9m32kwar60s 
        foreign key (department_id) 
        references department (id);

    alter table education 
        add constraint FK_9f4iojhis1eml9hi90aowdpyp 
        foreign key (user_id) 
        references app_user (id);

    alter table leaverequest 
        add constraint FK_8g3aj3agnh0bigvfiyw3ofdmf 
        foreign key (user_id) 
        references app_user (id);

    alter table project 
        add constraint FK_pd0f41nfpvncngygkesu8mk9n 
        foreign key (client_id) 
        references client (id);

    alter table projectrelease 
        add constraint FK_k06k5qaakkihl3htx8woesdst 
        foreign key (project_id) 
        references project (id);

    alter table salary 
        add constraint FK_qrfuqlo1a5flxjufhrewyoj3i 
        foreign key (user_id) 
        references app_user (id);

    alter table team 
        add constraint FK_bsgqgukhojgbhthllr7mvkect 
        foreign key (project_id) 
        references project (id);

    alter table team 
        add constraint FK_kisr7bcgtyyed1c9on0a593w2 
        foreign key (user_id) 
        references app_user (id);

    alter table user_address 
        add constraint FK_m3t1qb7j0fluav2a0kphxyoue 
        foreign key (address_id) 
        references address (id);

    alter table user_address 
        add constraint FK_kfu0161nvirkey6fwd6orucv7 
        foreign key (user_id) 
        references app_user (id);

    alter table user_role 
        add constraint FK_it77eq964jhfqtu54081ebtio 
        foreign key (role_id) 
        references role (id);

    alter table user_role 
        add constraint FK_apcc8lxk2xnug8377fatvbn04 
        foreign key (user_id) 
        references app_user (id);
