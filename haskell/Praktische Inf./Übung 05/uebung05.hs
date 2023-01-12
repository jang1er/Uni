import Distribution.Parsec (Position)
-- Aufgabe 1

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

-- g)
zip' :: [a] -> [b] -> [(a,b)]
zip' [] _ = []
zip' _ [] = []
zip' (a:as) (b:bs) = ((a,b) : zip' as bs)

-- h) 
commonPrefix :: Eq a => [a] -> [a] -> [a]
commonPrefix (a:as) (b:bs)  | (a == b) = (a : commonPrefix as bs)
                            | otherwise = []

-- i)
replicate' :: Int -> a -> [a]
replicate' n a  | (n > 0) = (a : replicate' (n-1) a)
                | otherwise = []

-- ####################################################

-- Aufgabe 3
infixl 7 *#
(*#) :: Double -> Position -> Position
s *# (x,y) = (s*x, s*y)

infixl 6 +#, -#
(+#), (-#) :: Position -> Position -> Position 
(x,y) +# (x',y') = (x+x', y+y')
(x,y) -# (x',y') = (x-x', y-y')

magnitude :: Position -> Double
magnitude (x,y) = sqrt (x^2 + y^2)

norm :: Position -> Position 
norm p = 1/magnitude p *# p

-- a) 
type Position = (Double,Double)

-- b)
data Direction = U | D | H 

-- c)
move :: Direction -> Position -> Position
move H pos = pos +# (1,0) 
                