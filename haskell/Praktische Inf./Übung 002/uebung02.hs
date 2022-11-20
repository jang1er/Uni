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

