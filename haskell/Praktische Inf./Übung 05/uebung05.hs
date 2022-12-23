-- Aufgabe 2
-- a)
take' :: Int -> [a] -> [a]
take' 0 _ = []
take' _ [] = []
take' n (x:xs) = (x: take' (n-1) xs)

-- b)
drop' :: Int -> [a] -> [a]
drop' 0 a = a
drop' n (x:xs) = drop (n-1) xs