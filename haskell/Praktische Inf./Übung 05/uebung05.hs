import GHC.Float (int2Double)
-- Aufgabe 1
{-  Die Funktion (:.) verknüpft zwei Funktionen mit zwei Eingabeparametern zu einem Ausgabeparameter.
    Zuerst bildet die Funktion o von den Parametern x und y auf einen neuen ( z ) ab. --> (a1 -> a2 -> b)
    Danch wird dieser neue Parameter ( z ) benutzt um mithilfe der Funktion f auf den Ausgangsparameter abzubilden.
    --> (b -> c)

    Der Aufruf der Funktion (:.) => f . ( o x y ) = f ( o x y )
-}

-- Aufgabe 2
-- a)
take' :: Int -> [a] -> [a]
take' 0 _ = []
take' _ [] = []
take' n (x:xs) = x: take' (n-1) xs

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
type Position = (Double, Double)

-- b)
data Direction = U | D | H 

-- c)
move :: Direction -> Position -> Position
move H pos = pos +# (1,0) 
move U pos = pos +# norm (1,1)
move D pos = pos +# norm (1,-1)

-- Hilfsfunktion um Parameter für move wieder korrekt benutzen (Position -> Direction in scanl zu Direction -> Position)
move' :: Position -> Direction -> Position
move' pos dir = move dir pos
                
-- d)
rudolf :: [Direction] -> [Position]
rudolf dir = scanl (move') (0,0) dir

-- e)
follow :: Position -> Position -> Position
follow pos1 pos2    | magnitude(pos2 -# pos1) > 1 = norm (pos2 -# pos1) +# pos1
                    | otherwise = pos1

-- f)
sled :: Int -> [Position] -> [Position]
sled _ [] = []
sled n pos = sled' (int2Double n) (int2Double n) pos

sled' :: Double -> Double -> [Position] -> [Position]
sled' _ _ [] = []
sled' n m pos   | n > 0 = sled' (n-1) m (scanl follow (-(m-n),0) pos)
                | otherwise = scanl (follow) (-(m+1),0) pos