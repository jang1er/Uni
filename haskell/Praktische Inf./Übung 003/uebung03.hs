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


