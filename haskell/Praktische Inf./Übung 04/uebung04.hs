-- Aufgabe 1 
-- a)

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
trick t (Of r1 s1) (Of r2 s2)  | s1 == t && s2 /= t = (Of r1 s1)
                                    | s1 /= t && s2 == t = (Of r2 s2)
                                    | otherwise = if (r1 <= r2)
                                                    then (Of r2 s2)
                                                    else (Of r1 s1)

-- g)

turn :: Card -> Card -> (Int , Int) -> (Int, Int)
turn a b (sc1, sc2) | sc1 > sc2 = if ((trick (getSuit b ) a b) == a)
                                    then (sc1 + 1, sc2 )
                                    else (sc1 ,sc2 + 1 )
                    |sc1 < sc2 = if ((trick (getSuit a ) a b ) == a)
                                    then (sc1 + 1, sc2)
                                    else (sc1 , sc2 + 1)
                    | otherwise = if ((trick (getSuit a ) a b) == a)
                                    then (sc1 + 1, sc2 )
                                    else (sc1 ,sc2 + 1 )

-- Hilffunktionen:
getSuit :: Card -> Suit
getSuit (Of _ suit ) = suit

-- f)
game :: [(Card, Card)] -> (Int, Int)
game a = gameStart a (0,0)

gameStart :: [(Card, Card)] -> (Int, Int) -> (Int, Int)
gameStart ((a , b) : cards) (sc1 , sc2) | cards == [] = turn a b (sc1, sc2)
                                        | otherwise = gameStart cards (turn a b (sc1,sc2))