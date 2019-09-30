class SpiralTraverse{
	
	public int[] spiralOrder(int[][] matrix){
		if(matrix == null || matrix.length <= 0)
			return new int[]{};
		
		int m = matrix.length, n = matrix[0].length;
		int[] res = new int[m * n];
		int ind = 0;
		int rowBeg = 0, colBeg = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
		while(rowBeg <= rowEnd && colBeg <= colEnd){
			for(int r = rowBeg, c = colBeg; c <= colEnd; c++){
				res[ind++] = matrix[r][c];
			}
			rowBeg++;

			for(int r = rowBeg, c = colEnd; r <= rowEnd; r++){
				res[ind++] = matrix[r][c];
			}
			colEnd--;

			if(rowBeg <= rowEnd){
				for(int r = rowEnd, c = colEnd; c >= colBeg; c--){
					res[ind++] = matrix[r][c];
				}
				rowEnd--;
			}

			if(colBeg <= colEnd){
				for(int r = rowEnd, c = colBeg; r >= rowBeg; r--){
					res[ind++] = matrix[r][c];
				}
				colBeg++;
			}
		}

		return res;
	}

	public static void main(String[] args){
		SpiralTraverse spiralTraverse = new SpiralTraverse();

		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

		int[] res = spiralTraverse.spiralOrder(matrix);
		for(int e : res)
			System.out.print(e + " ");

		System.out.println();
	}

}