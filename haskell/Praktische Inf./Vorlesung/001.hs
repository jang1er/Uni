neg :: Num a => a -> a
neg a = -a

dec :: Num a => a -> a
dec a = a-1

twice :: (a -> a) -> a -> a
twice f a = f (f a)



fst :: (a,b) -> a
fst (x,_) = x

snd :: (a,b) -> b
snd (_,y) = y

swap :: (a,b) -> (b,a)
swap (x,y) = (y,x)

s :: (a -> b -> c) -> (a -> b) -> a -> c
s f g x = f x (g x)

math :: (a -> b -> c) -> a -> b -> c
math f x y = f x y



-- Typdefinition und Datenkonstruktoren

data Foobar
    = Foo
    | Bar Bool
    | Foobar Int Float

data Fizzbuzz f b
    = Fizz Int b 
    | Buzz Int f 
    | FizzBuzz Int b f 

data Maybe a    --- Permanenter Fehler
    = Nothing 
    | Just a
