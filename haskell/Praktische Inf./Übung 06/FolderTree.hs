import Data.List (find, deleteBy)

type Name = String
type Path = [Name]

data FolderTree content
  = Content Name content
  | Folder Name [FolderTree content]
  deriving (Show, Eq, Ord)

getName :: FolderTree c -> Name
getName (Content n _) = n
getName (Folder n _)  = n

data FileType = Binary | Text
  deriving (Show, Eq)

type Size = Int

data File = File FileType Size
  deriving (Show, Eq)


example = Folder "/"
  [ Folder "bin"
    [ Content "cp" (File Binary 140) 
    , Content "mv" (File Binary 159)
    , Content "edit" (File Binary 2293784)
    ]
  , Folder "docs"
    [ Content "letter" (File Text 105)
    , Content "notes" (File Text 5056)
    , Folder "work" 
      [ Content "todos" (File Text 198571)
      , Content "notes" (File Text 1238)
      , Content "tetris" (File Binary 8230987)
      ]
    ]
  ]


foldFolderTree :: (Name -> content -> b) -> (Name -> [b] -> b)
               -> FolderTree content -> b
foldFolderTree fContent fFolder = fold
  where
    fold (Content n c) = fContent n c
    fold (Folder n fs) = fFolder n (map fold fs)


sizeOfType :: FileType -> FolderTree File -> Size
sizeOfType t = foldFolderTree (\ _ (File ft s) -> if t == ft then s else 0) (\ _ ss -> sum ss)


filesOfType :: FileType -> FolderTree File -> [Path]
--filesOfType t = foldFolderTree (\ name (File ft _) -> if t == ft then name else []) (\ n ns -> [n : ns])
filesOfType = undefined


data FolderTreeZip content
  = FolderZip String [FolderTree content]
  deriving (Show, Eq)

type Zipper content = (FolderTree content, [FolderTreeZip content])
zipper :: FolderTree content -> Zipper content
zipper f = (f, [])

descend :: String -> Zipper content -> Maybe (Zipper content)
descend _ (Content _ _, _)   = Nothing
descend n (Folder n' fs, zs) = case find (\x -> getName x == n) fs of
    Nothing -> Nothing
    Just f  -> Just (f, FolderZip n' (deleteBy (\a b -> getName a == getName b) f fs) : zs)


descendTo :: Path -> Zipper c -> Maybe (Zipper c)
descendTo [] z     = Just z
descendTo (n:ns) z = maybe Nothing (descendTo ns) (descend n z)


ascend :: Zipper content -> Zipper content
ascend (t, FolderZip n ts : zs) = (Folder n (t:ts), zs)


unwind :: Zipper content -> FolderTree content
unwind (t, []) = t
unwind z       = unwind (ascend z)


modify :: (c -> c) -> Zipper c -> Maybe (Zipper c)
modify f (Content n x, zs) = Just (Content n (f x), zs)
modify f _                 = Nothing


get :: (c -> a) -> Zipper c -> Maybe a
get f (Content _ x, _) = Just( f x)
get _ _                = Nothing


getAt :: Path -> (c -> a) -> FolderTree c -> Maybe a
getAt p f c = fs f ( descendTo p (zipper c) ) 
  where
    fs f ( Just (Content _ x, _)) = Just (f x)
    fs _ _ = Nothing


modifyAt :: Path -> (c -> c) -> FolderTree c -> Maybe (FolderTree c)
modifyAt p f c = fs f (descendTo p (zipper c))
  where
    fs f (Just (Content n x, xs)) = Just (unwind ( ascend(Content n (f x), xs)))
    fs _ _ = Nothing

isFileOfType :: Path -> FileType -> FolderTree File -> Maybe Bool
isFileOfType p t f = fs (descendTo p (zipper f))
  where 
    fs (Just (Content n (File ft _), xs)) = Just (ft == t)
    fs _ = Nothing


setTypeOfFile :: Path -> FileType -> FolderTree File -> Maybe (FolderTree File)
setTypeOfFile p t f = fs ( descendTo p (zipper f))
  where
    fs (Just (Content n (File _ b ), xs)) = Just (unwind(ascend(Content n (File t b), xs)))
    fs Nothing = Nothing
