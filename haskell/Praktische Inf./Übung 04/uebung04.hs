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

data Suit =   Clubs
            | Hearts
            | Spades
            | Diamonds
            deriving(Show, Eq)

data Card = Of Rank Suit

instance Show Card where
    show (Of rank suit) = show (rank) ++ " of " ++ show(suit) 