package assignment4;

public class MatrixMultiple {

    public int[][] multiple(int[][] m1, int[][] m2){
        if(m1 == null || m1.length == 0 || m2 == null || m2.length == 0)
            return new int[][]{};

        if(m1[0].length != m2.length)
            return new int[][]{};



        int rowM1 = m1.length, colM1 = m1[0].length, rowM2 = m2.length, colM2 = m2[0].length;
        int[][] res = new int[rowM1][colM2];

        int r = 0, c = 0;
        while(r < rowM1){
            c = 0;
            while(c < colM2){
                for(int i = 0; i < colM1; i++){
                    res[r][c] += m1[r][i] * m2[i][c];
                }
                c++;
            }
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] m1 = {{1,0,0}, {-1,0,3}};
        int[][] m2 = {{7,0,0}, {0,0,0}, {0,0,1}};

        MatrixMultiple matrixMultiple = new MatrixMultiple();
        int[][] res = matrixMultiple.multiple(m1, m2);

        for(int[] l : res ){
            for(int i : l)
                System.out.print(i + " ");
        }
    }

}
