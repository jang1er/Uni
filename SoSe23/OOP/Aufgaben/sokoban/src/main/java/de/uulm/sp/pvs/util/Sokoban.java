package de.uulm.sp.pvs.util;

public class Sokoban {

    public Pair<Integer, Integer> findPlayer(char[][] board){
        for(int i = 0; i < board.length; i++){
            for( int j = 0; j < board[0].length; j++){
                if(board[i][j] == '@')return new Pair<>(i,j);
            }
        }
        return new Pair<>(-1,-1);
    }


    public boolean moveNorth(char[][] board){ return move(board, new Pair<>(-1,0));}
    public boolean moveSouth(char[][] board){ return move(board, new Pair<>(1,0));}
    public boolean moveWest(char[][] board){ return move(board, new Pair<>(0,-1));}
    public boolean moveEast(char[][] board){ return move(board, new Pair<>(0,1));}


    public String sokobanToString(char[][] board){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++){
            for(char c : board[i]){
                sb.append(c);
            }
            if(i < board.length-1)sb.append("\n");
        }
        return sb.toString();
    }

    private boolean move(char[][] board, Pair<Integer,Integer> offset){
        int offsetX = offset.getFirst();
        int offsetY = offset.getSecond();
        Pair<Integer,Integer> playerPos = findPlayer(board);
        if(playerPos.getFirst() == -1)return false;

        if(board[playerPos.getFirst() + offsetX][playerPos.getSecond() + offsetY] == '.'){
            board[playerPos.getFirst() + offsetX][playerPos.getSecond() + offsetY] = '@';
            board[playerPos.getFirst()][playerPos.getSecond()] = '.';
            return true;
        }else if(board[playerPos.getFirst() + offsetX][playerPos.getSecond() + offsetY] == '$' && board[playerPos.getFirst() + 2*offsetX][playerPos.getSecond() + 2*offsetY]== '.'){
            board[playerPos.getFirst() + offsetX][playerPos.getSecond() + offsetY] = '@';
            board[playerPos.getFirst() + 2*offsetX][playerPos.getSecond() + 2*offsetY] = '$';
            board[playerPos.getFirst()][playerPos.getSecond()] = '.';
            return true;
        }
        return false;
    }

}
