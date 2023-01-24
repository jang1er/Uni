
-- Aufgabe 1
data BinTree a
    = Nil 
    | Node a (BinTree a) (BinTree a)
    deriving(Show, Read, Eq, Ord)

foldBinTree :: b -> (a -> b -> b -> b) -> BinTree a -> b
foldBinTree fNil fNode = fold 
    where
        fold Nil = fNil
        fold (Node x tl tr) = fNode x (fold tl) (fold tr) 

example = Node 6
    (Node 4
        Nil
        (Node 5 Nil Nil))
    (Node 8
        (Node 7 Nil Nil)
        (Node 9 Nil Nil))

-- a)
minimum' :: Ord a => BinTree a -> Maybe a
minimum' Nil = Nothing
minimum' tree = foldBinTree Nothing f tree
    where
        f x Nothing Nothing =  Just x 
        f x (Just y) Nothing =  Just (min x y)
        f x Nothing (Just z) = Just (min x z )
        f x (Just y) (Just z) = Just (min x (min y z))

-- b)
find :: Eq a => a -> BinTree a -> Maybe [a]
find _ Nil = Nothing 
find n tree = foldBinTree Nothing f tree 
    where 
        f a Nothing Nothing = if a == n then Just [a] else Nothing
        f a Nothing (Just as) = Just (a:as)
        f a (Just as) Nothing = Just (a:as)

-- Aufgabe 2
