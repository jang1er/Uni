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

-- c)
split' :: Integer -> [a] -> ([a],[a])
split' _ [] = ([], [])
split' 1 (x:xs) = ([x],xs)
split' n (x:xs) = (x:xs', xs'')
    where (xs' , xs'') = split' (n-1) xs

-- d)
reverse' :: [a] -> [a]
reverse' [] = []
reverse' (x:xs) = reverse' xs ++ [x] 

-- e)
takeWhile' :: (a -> Bool) -> [a] -> [a]
takeWhile' f (x:xs) | (f x) = ( x : takeWhile' f xs)
                    | otherwise = []

-- f)
dropWhile' :: (a -> Bool) -> [a] -> [a]
dropWhile' f (x:xs) | (f x) = dropWhile' f xs
                    | otherwise = (x:xs)