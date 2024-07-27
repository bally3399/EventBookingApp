truncate table organizers cascade;
truncate table events cascade;
truncate table guests cascade;
truncate table tickets cascade;
truncate table attendees cascade;

insert into organizers(id, first_name, last_name, email, password, time_created) values
(200, 'john', 'smith', 'johnsmith@gmail.com', '1234', '2024-06-04T15:03:03.792009700'),
(201, 'jane', 'bim', 'janebim@gmail.com', '1224', '2024-06-04T15:03:03.792009700'),
(202, 'bimbim', 'doe', 'bimbimdoe@gmail.com', '2222', '2024-06-04T15:03:03.792009700'),
(203, 'mary', 'dee', 'marydee@gmail.com', '4444', '2024-06-04T15:03:03.792009700');

insert into events(event_id, event_name, description, location, date,
organizer_id) values
(100, 'Conference', 'Annual tech conference', 'Convention Center',  '2024-06-04T15:03:03.792009700', 200),
(101, 'Web Development', 'Hands-on web development workshop', 'Tech Hub Co-working Space', '2024-06-04T15:03:03.792009700', 200),
(103, 'Networking Mixer', 'Connect with industry professionals', 'City View Rooftop Lounge', '2024-06-04T15:03:03.792009700', 200);

insert into guests(id, first_name, last_name, email) values
(50, 'bally', 'sulaiman', 'sulaimabally@gmail.com'),
(51, 'bimbim', 'suleiman', 'suleimabimbim@gmail.com'),
(52, 'baliqis', 'sulaiman', 'sulaimabaliqis@gmail.com');

insert into tickets(ticket_id, ticket_type, price, discount) values
(303, 'REGULAR', 6000.00, 100.00);

insert into attendees(id, first_name, last_name, email) values
(150, 'bally', 'sulaiman', 'sulaimabally@gmail.com'),
(151, 'bimbim', 'suleiman', 'suleimabimbim@gmail.com'),
(152, 'baliqis', 'sulaiman', 'sulaimabaliqis@gmail.com');
