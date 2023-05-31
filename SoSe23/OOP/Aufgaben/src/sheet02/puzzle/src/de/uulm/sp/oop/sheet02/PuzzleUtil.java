package sheet02.puzzle.src.de.uulm.sp.oop.sheet02;
public class PuzzleUtil {
    public static void main(String[] args) {
        int[] arr1 = new int[]{25, 42, 69, 17};

        System.out.println("arr1: ");
        view(arr1);

        System.out.println("\narr1 shiftRight: ");
        shiftRight(arr1);
        view(arr1);

        System.out.println("\narr1 shiftLeft: ");
        shiftLeft(arr1);
        view(arr1);

        System.out.println("\narr1 shiftLeft: ");
        shiftLeft(arr1);
        view(arr1);

        System.out.println("\narr1 shiftRight: ");
        shiftRight(arr1);
        view(arr1);

        int[][] arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("\narr2t: ");
        view(arr2);

        System.out.println("\narr2 shiftRowsRight(1,3): ");
        shiftRows(arr2, 1, 3, false);
        view(arr2);

        System.out.println("\narr2 shiftRowsLeft(1,3): ");
        shiftRows(arr2, 1, 3, true);
        view(arr2);

        System.out.println("\narr2 shiftColsDown (1,3)");
        shiftCols(arr2, 1 , 3 , true);
        view(arr2);

        System.out.println("\narr2 shiftColsUp (1,3)");
        shiftCols(arr2, 1 , 3 , false);
        view(arr2);

        System.out.println("\narr2 extractSubarray(2,4,2,4): ");
        view(extractSubarray(arr2, 2, 4, 2, 4));

        int[][] delta = new int[][]{{2,2},{2,2}};
        System.out.println("\narr2 replaceInArray (2,2)(2,2,)  (1,1)");
        replaceInArray(arr2, delta, 0, 0);
        view(arr2);

        System.out.println("\narr2 rotateClockwise: ");
        rotateClockwise(arr2);
        view(arr2);

        System.out.println("\narr2 replaceInArray with zeros: ");
        replaceInArray(arr2, new int[][]{{0, 0}, {0, 0}}, 1, 1);
        view(arr2);

        System.out.println("\narr2 partialRotateClockwise(0,2,0,2): ");
        partialRotateClockwise(arr2, 0, 2, 0, 2);
        view(arr2);
    }

    //a)
    public static void shiftRight(int[] array) {
        int temp = array[array.length-1];
        for(int i = array.length-1; i > 0; i--){
            array[i] = array[i-1];
        }
        array[0] = temp;
    }

    //b)
    public static void shiftLeft(int[] array) {
        int temp = array[0];
        for (int i = 0; i < array.length-1; i++){
            array[i] = array[i+1];
        }
        array[array.length-1] = temp;
    }

    //c)
    public static void shiftRows(int[][] array, int rowStart, int rowEnd, boolean shiftLeft) {
        for (int i = rowStart; i < rowEnd; i++){
            if(shiftLeft){
                shiftLeft(array[i]);
            }else{
                shiftRight(array[i]);
            }
        }
    }

    //d)
    public static void shiftCols(int[][] array, int colStart, int colEnd, boolean shiftDown) {
        for (int i = colStart; i < colEnd; i++){
            int[] rowNew = new int [3];
            // convert column to row
            for (int j = 0; j < rowNew.length; j++){
                rowNew[j] = array[j][i];
            }
            // use shifts for rows
            if(shiftDown){shiftRight(rowNew);
            }else { shiftLeft(rowNew);}

            // convert back to column
            for( int j = 0; j < rowNew.length; j++){
                array[j][i] = rowNew[j];
            }
        }
    }

    //e)
    public static int[][] extractSubarray(int[][] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        // check against IndexOutofBounds;
        rowEnd = Math.min(rowEnd, array.length);
        colEnd = Math.min(colEnd, array.length);
        int dimX = rowEnd - rowStart;
        int dimY = colEnd - colStart;
        int[][] subarray = new int[dimY][dimX];
        for (int i = colStart; i < colEnd; i++){
            for (int j = rowStart; j < rowEnd; j++){
                subarray[i - colStart][j - rowStart] = array[i][j];
            }
        }
        return subarray;
    }

    //f)
    public static void replaceInArray(int[][] array, int[][] delta, int rowIndex, int colIndex) {
        for (int i = colIndex; (i-colIndex) < delta.length && i < array.length; i++){
            for (int j = rowIndex; (j-rowIndex) < delta[0].length && j < array[0].length; j++){
                array[i][j] = delta[i - colIndex][j - rowIndex];
            }
        }
    }

    //g)
    public static void rotateClockwise(int[][] array) {
        if(array.length != array[0].length)return;
        for (int i = 0; i < array.length; i++){
            for (int j = 1; j < array.length; j++){
                if( i != j) {
                    int temp = array[i][j];
                    array[i][j] = array[j][i];
                    array[j][i] = temp;
                }
            }
        }
        int n = array.length-1;
        for (int i = 0; i < array.length; i++){
            int temp = array[i][0];
            array[i][0] = array[i][n];
            array[i][n] = temp;
        }
    }

    //h)
    public static void partialRotateClockwise(int[][] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        //TODO
    }


    //vvvvv Blackbox vvvvv
    public static void view(int[] array) {

        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    private static void view(int[][] array) {

        System.out.println("2d-Array:");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
