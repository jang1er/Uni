--Aufgabe 4 

data Choice a b = Null | First a | Second b | Both a b 
    deriving(Show, Eq, Ord)

-- a)
instance(Semigroup a, Semigroup b) =>  Semigroup (Choice a b) where
    First a <> First b = First ( a <> b)
    First a <> mempty = First a
    mempty <> First a = First a 
    Second a <> Second b = Second (a <> b)
    Second a <> mempty = Second a
    mempty <> Second a = Second a 
    First a <> Second b = Both a b
    Second a <> First b = Both b a 

-- b)
instance (Semigroup a, Semigroup b) => Monoid (Choice a b)where
    mempty = Null

-- Aufgabe 5
data Choices a b c = One' c | Both' a b [c]
    deriving (Show, Eq, Ord)

instance Functor (Choices a b) where
    fmap f (One' c) = One' (f c)
    fmap f (Both' a b c) = Both' a b (map f c) 

data Choices' a b c = One'' c | Both'' a b [c]
    deriving (Show, Eq, Ord, Functor)