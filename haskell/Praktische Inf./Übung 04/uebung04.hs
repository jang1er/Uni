-- Aufgabe 1 
-- a)
{-
 ############### Ich entschuldige mich im Voraus für meine Variablenbenennung #################
-}
data Rank =   VII
            | VIII
            | IX
            | X
            | Jack
            | Queen
            | King
            | Ace
            deriving(Show, Eq, Ord)

--b)
data Suit =   Clubs
            | Hearts
            | Spades
            | Diamonds
            deriving(Show, Eq)

--c)
data Card = Of Rank Suit

--d)
instance Show Card where
    show (Of rank suit) = show (rank) ++ " of " ++ show(suit) 

--e)
instance Ord Card where
    (<=) :: Card -> Card -> Bool
    (<=) (Of rank1 _ ) (Of rank2 _ ) = rank1 <= rank2

instance Eq Card where
    (==) :: Card -> Card -> Bool
    (==) (Of r1 s1) (Of r2 s2) = r1 == r2

-- f)

trick :: Suit -> Card -> Card -> Card 
trick t (Of r1 s1) (Of r2 s2)   | s1 == t && s2 /= t = (Of r1 s1)
                                | s1 /= t && s2 == t = (Of r2 s2)
                                | otherwise = if (r1 <= r2)
                                            then (Of r2 s2)
                                            else (Of r1 s1)

-- g)
-- Vielleicht geht das besser, aber ist mir egal
turn :: (Card, Card) -> (Int , Int) -> (Int, Int)
turn (a, b) (sc1, sc2) | sc1 > sc2 = if ((trick (getSuit b ) a b) == a)
                                    then (sc1 + 1, sc2 )
                                    else (sc1 ,sc2 + 1 )
                    | otherwise = if ((trick (getSuit a ) a b ) == a)
                                    then (sc1 + 1, sc2)
                                    else (sc1 , sc2 + 1)
-- Hilffunktionen:
getSuit :: Card -> Suit
getSuit (Of _ suit ) = suit

-- f)
game :: [(Card, Card)] -> (Int, Int)
game [] = (0,0)
game a = turn (last a) (game (init a))

gameStart :: [(Card, Card)] -> (Int, Int) -> (Int, Int)
gameStart ((a , b) : cards) (sc1 , sc2) | cards == [] = turn (a, b) (sc1, sc2)
                                        | otherwise = gameStart cards (turn (a, b) (sc1,sc2))


{- ###########################################

    Aufgabe 2

a)
    odds stellt eine unendliche Liste mit allen ungeraden natürlichen Zahlen dar. -}
odds :: [Integer]
odds = [1,3..]
{-
b)
    divs stellt eine begrenzte Liste mit allen Teilern (welche Element der natürlichen Zahlen sind)
    von n, wobei n und 1 ausgeschlossen werden, dar. -}
divs :: Integer -> [Integer]
divs n = [ x | x <- [2..(n-1)], n `mod` x == 0 ]

{-
c) 
    Die Liste pyths ist eine unendliche Integer-Tripel-Liste, in der alle pythagoräischen Zahlentripel
    mit a < b enthalten sind.
-}
pyths :: [(Integer,Integer,Integer)]
pyths = [(x,y,z) | z <- [1..], x <- [1..z], y <- [1..z], (x*x) + (y*y) == (z*z), x < y]

-- #####################################################
-- Aufgabe 3

--scanl :: (b -> a -> b) -> b -> [a] -> [b]
--scanl _ q []        = [q]
--scanl f q (x:xs)    = q : (scanl f (f q x) xs)

fibs :: [Integer]
fibs = scanl (+) 1 (0:fibs)