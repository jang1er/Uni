-- teilaufgabe a
fak_rec n = if n == 0 
            then 1
            else n * fak_rec (n-1)
-- Typsignatur: Num t => t -> t

-- teilaufgabe b
fak_end n m = if n == 0 
                then m 
                else  fak_end (n-1) (n * m)
-- Typsignatur: Num t => t -> t -> t

-- teilaufgabe c 
