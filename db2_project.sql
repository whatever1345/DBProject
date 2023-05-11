set serveroutput on

drop table game_history;
drop table contracts;
drop table players;
drop table managers;
drop table teams;
drop table regions;


create table regions (
    id_region int primary key,
    abbr varchar(3),
    region_name varchar(20),
    region_location varchar(15)
);

create table teams (
    id_team int primary key,
    team_name varchar(3),
    id_region int,
    established_on date,
    
    foreign key (id_region) references regions(id_region)
);

create table managers (
    id_manager int primary key,
    id_team int,
    first_name varchar(50),
    last_name varchar(50),
    email varchar(40),
    phone varchar(12),
    budget int,
    
    foreign key (id_team) references teams(id_team)
);

create table players (
    id_player int primary key,
    ingame_name varchar(10),
    first_name varchar(50),
    last_name varchar(50),
    id_team int null,
    player_position int,
    status int,
    salary int,
    contract_expired date,
    
    foreign key (id_team) references teams(id_team)
);

create table contracts (
    id_contract int primary key,
    id_manager int,
    id_player int,
    start_at date,
    price int,
    
    foreign key (id_manager) references managers(id_manager),
    foreign key (id_player) references players(id_player)
);

create table game_history (
    id_game int primary key,
    id_blue_team int,
    id_red_team int,
    id_spectator int,
    game_result int,
    start_at date,
    end_at date,
    status int,
    
    foreign key (id_blue_team) references teams(id_team),
    foreign key (id_red_team) references teams(id_team)
);

insert into regions (id_region, abbr, region_name, region_location) values (1, 'LCK', 'LOL Champions Korea', 'South Korea');
insert into regions (id_region, abbr, region_name, region_location) values (2, 'LPL', 'LOL Pro League', 'China Mainland');

insert into teams (id_team, team_name, id_region, established_on) values (1, 'SKT', 1, TO_DATE('2013/05/06', 'yyyy/mm/dd'));
insert into teams (id_team, team_name, id_region, established_on) values (2, 'WBG', 2, TO_DATE('2019/03/09', 'yyyy/mm/dd'));

insert into managers (id_manager, id_team, first_name, last_name, email, phone, budget)
    values (1, 1, 'AAA', 'BBB', 'aaa.bbb@skt.com', '999999999999', 15000);
    
insert into managers (id_manager, id_team, first_name, last_name, email, phone, budget)
    values (2, 2, 'CCC', 'DDD', 'ccc.ddd@wbg.com', '000000000000', 15000);
    
insert into players (id_player, ingame_name, first_name, last_name, id_team, player_position, status, salary, contract_expired)
    values (1, 'Faker', 'Sang-hyeok', 'Lee',  1, 3, 1, 5000, TO_DATE('2033/05/06', 'yyyy/mm/dd'));
    
insert into players (id_player, ingame_name, first_name, last_name, id_team, player_position, status, salary, contract_expired)
    values (2, 'Zeus', 'Woo-je', 'Choi', 1, 1, 1, 3000, TO_DATE('2033/01/01', 'yyyy/mm/dd'));
    
insert into players (id_player, ingame_name, first_name, last_name, id_team, player_position, status, salary, contract_expired)
    values (3, 'Oner', 'Hyeon-jun', 'Mun', 1, 2, 1, 3000, TO_DATE('2033/01/01', 'yyyy/mm/dd'));
    
insert into players (id_player, ingame_name, first_name, last_name, id_team, player_position, status, salary, contract_expired)
    values (4, 'Sofm', 'Duy', 'Le Quang', 2, 2, 1, 4000, TO_DATE('2024/01/01', 'yyyy/mm/dd'));
    
insert into players (id_player, ingame_name, first_name, last_name, id_team, player_position, status, salary, contract_expired)
    values (5, 'TheShy', 'Seung-lok', 'Kang', 2, 1, 1, 4000, TO_DATE('2025/01/01', 'yyyy/mm/dd'));
    
insert into players (id_player, ingame_name, first_name, last_name, id_team, player_position, status, salary, contract_expired)
    values (6, 'Xiaohu', 'Yuan-Hao', 'Li', 2, 3, 1, 2000, TO_DATE('2025/01/01', 'yyyy/mm/dd'));
    
insert into game_history (id_game, id_blue_team, id_red_team, id_spectator, game_result, start_at, end_at, status)
    values 