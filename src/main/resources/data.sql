INSERT INTO team (id, name) VALUES
(1, 'Real Madrid'),
(2, 'FC Barcelona'),
(3, 'Athletico Madrid');

INSERT INTO player (id, age, name, team_id) VALUES
(1, 33, 'Cristiano Ronaldo', 1),
(2, 28, 'Gareth Bale', 1),
(3, 33, 'Luka Modric', 1),
(4, 33, 'Lionel Messi', 2),
(5, 33, 'Luis Suarez', 2),
(6, 33, 'Antoine Griezzman', 3),
(7, 33, 'Odrizola', 3);

INSERT INTO event (id, name, home_id, home_odds, away_id, away_odds, result) VALUES
(1, "Fixture 1: Real - Barca",1,1.51,2,1.82,1),
(2, "Fixture 1: Real - Athletico",1,1.20,3,2.12,1);

/*INSERT INTO team_players (team_id, players_id) VALUES
(1,1),
(1,2),
(1,3),
(2,4),
(2,5),
(3,6),
(3,7);
*/
INSERT INTO team_events (team_id, events_id) VALUES
(1,1),
(1,2),
(2,1),
(3,2);