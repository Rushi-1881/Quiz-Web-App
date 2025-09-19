INSERT INTO quiz (title, description) VALUES ('General Knowledge', 'Test your general knowledge');
INSERT INTO quiz (title, description) VALUES ('Science Quiz', 'Basic science questions');

INSERT INTO question (quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option)
VALUES (1, 'What is the capital of France?', 'Berlin', 'Madrid', 'Paris', 'Rome', 'C');
INSERT INTO question (quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option)
VALUES (1, '2 + 2 equals?', '3', '4', '5', '22', 'B');
INSERT INTO question (quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option)
VALUES (2, 'Water chemical formula?', 'H2O', 'CO2', 'O2', 'He', 'A');
