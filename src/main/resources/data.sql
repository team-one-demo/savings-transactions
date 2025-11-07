INSERT INTO savings_transaction (user_id, account_number, date, description, type, amount, balance)
VALUES 
('user123', '7890', '2024-02-21', 'Rent', 'Withdrawal', -500.00, 1550.00),
('user123', '7890', '2024-02-22', 'Horeca deposit', 'Deposit', 500.00, 2550.50),
('user123', '7890', '2024-02-28', 'Dining out', 'Withdrawal', -10.00, 1550.50),
('user123', '7890', '2024-02-28', 'Grocery store', 'Withdrawal', -40.00, 1910.50),
('user123', '7890', '2024-02-28', 'Netflix', 'Withdrawal', -15.50, 1895.00),
('user123', '7890', '2024-02-28', 'Clothes', 'Withdrawal', -50.00, 1845.50),
('user123', '7890', '2024-02-28', 'Internet bill', 'Withdrawal', -35.00, 1810.00);