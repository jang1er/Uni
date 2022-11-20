-- Aufgabe 1 Übungsblatt 2
lehmann = True
mueller = False
schulze = True

-- Aussage: Lehmann lügt oder nicht 
solveL = not schulze

-- Aussage: Müller lügt oder nicht
solveM = not lehmann || not schulze

-- Aussage 3
solveS = not mueller

--------------------------------------------------
-- Aufgabe 2 

-- teilaufgabe a
fak 0 = 1
fak n = n * fak (n - 1)
-- Typsignatur: fak :: Int -> Int

-- teilaufgabe b
fakEnd 0 m = m
fakEnd n m = fakEnd (n-1) (n * m)
-- Typsignatur: fakEnd :: Int -> Int -> Int


-- teilaufgabe c 
isEven :: Int -> Bool
isEven n = mod n 2 == 0
-- alt. : isEven n = even n
-- Typsignatur: isEven :: Int -> Bool


-- teilaufgabe d
isOdd :: Int -> Bool
isOdd n = mod n 2 == 1
-- alt.: isOdd n = not even n
-- Typsignatur: isOdd :: Int -> Bool

-- teilaufgabe e
isEvenR 0 = True
isEvenR n = isOddR (n-1)
-- Typsignatur : isEvenR :: Int -> Bool

isOddR 0 = False 
isOddR n = isEvenR (n-1)
-- Typsignatur : isOddR :: Int -> Bool
