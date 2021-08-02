INSERT INTO flashcard VALUES (default, '2+2', '4');
INSERT INTO flashcard VALUES (default, '5+1', '6');

INSERT INTO flashcard_keyword VALUES (1, 'Math');
INSERT INTO flashcard_keyword VALUES (1, 'Addition');

INSERT INTO flashcard_keyword VALUES (2, 'Math');
INSERT INTO flashcard_keyword VALUES (2, 'Addition');

INSERT INTO deck VALUES (default, 'Addition Problems');



INSERT INTO flashcard_deck VALUES (1, 1);
INSERT INTO flashcard_deck VALUES (1, 2);

INSERT INTO deck_user VALUES (1, 1);

INSERT INTO flashcard_user VALUES (1, 1);
INSERT INTO flashcard_user VALUES (1, 2);




SELECT * FROM deck;