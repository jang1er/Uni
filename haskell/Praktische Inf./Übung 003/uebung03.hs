-- Aufgabe 1 c)
fib :: Integer -> Integer
fib 0 = 1
fib 1 = 1
fib n = fib (n-1) + fib (n-2)

-- Aufgabe 2
type Vector = (Double, Double)
-- a)
magnitude :: Vector -> Double
magnitude (x,y) = sqrt (x**2 + y**2)

-- b)
inner :: Vector -> Vector -> Double
inner (x1,y1) (x2, y2) = x1 * x2 + y1 * y2

-- c)
add :: Vector -> Vector -> Vector
add (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)

-- d)
scale :: Double -> Vector -> Vector
scale a (x,y) = (a * x, a *y)

-- e) 
normalize :: Vector -> Vector
normalize (x ,y) =scale  ( 1 / magnitude (x,y) ) (x,y)

-- Aufgabe 3
type Matrix = (Vector, Vector)

-- a)
transpose :: Matrix -> Matrix 
transpose ((a11, a12), (a21 , a22)) = ((a11, a21), (a12, a22))

-- b)
mult :: Matrix -> Matrix -> Matrix
mult ((a11,a12), (a21, a22)) ((b11,b12),(b21,b22)) = 
    (   (   ( (a11 * b11) + (a12 * b21) ), ( (a11 * b12) + (a12 * b22))),
        (   ( (a21 * b11) + (a22 * b21) ), ( (a21 * b12) + (a22 * b22)))    )

-- c) 
transform :: Matrix -> Vector -> Vector
transform ( (a11,a12), (a21, a22)) (x,y) = 
    (  ( (x * a11) + (y * a12)), ( (x * a21) + (y * a22)))

-- d)
rotation :: Double -> Matrix
rotation b = 
    (   (   (cos b), (- sin b)  ),
        (   (sin b), (cos b)  ))


-- Aufgabe 4
_f = transform (rotation(pi/2)) . transform(rotation(pi/4))

_f' = transform (rotation(pi/2) `mult` rotation(pi/4))

-- a) Typ _f::  Vector -> Vector
--    Typ _f':: Vector -> Vector

-- b) 
{-  Beide Funktionen multiplizieren einen Vektor mit einer Drehmatrix, also die Funktion 
    dreht einen Vektor um 135 Grad gegen den Uhrzeiger Sinn (pi/2 = 90 Grad + pi/4 = 45 Grad => 135 Grad).
    Das wird durch zwei verschiedene Weisen erzielt in _f wird zuerst der Vektor mit der ersten Rotations-
    matrix (pi/2) transformiert und dann wird dieser Output-Vektor über den '.'-Operator an die zweite
    Transformatiom (pi/4) übergeben. 
    In _f' werden zuerst die beiden Drehmatrizen mit der mult-Funktion zu einer zusammengefasst, welche
    die gesamte Rotation enthält und dann mit dem Eingangsvektor transformiert. 
-}
-- c)
g b a = transform b . transform a 
g' b a = transform (a `mult` b)

-- Aufgabe 5

-- a) Typ monotonic::(Integer -> Integer) -> Integer -> Integer -> Bool

-- b)
monotonic ::(Integer -> Integer) -> Integer -> Integer -> Bool
monotonic f a b | a == b            = True
                | f a >= f (a+1)    = False
                | otherwise         = monotonic f (a+1) b