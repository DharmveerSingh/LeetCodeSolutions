
class NumberOfIslands {
	int size;
	int size1;

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		size = grid.length - 1;
		int size1 = grid[0].length - 1;
		int count = 0;
		System.out.println("size: " + size + ", size1: " + size1 + "last value: " + grid[size][size1]);
		for (int i = 0; i <= size; i++) {
			for (int j = 0; j <= size1; j++) {
				if (grid[i][j] == '1') {

					System.out.println("value: i-" + i + ", j-" + j + " :" + grid[i][j]);
					++count;
					visit(grid, i, j);
					visitAllAdj(grid, i, j);
				}
			}
		}

		return count;
	}

	public void visitAllAdj(char[][] mod, int i, int j) {

		System.out.println("visitAllAdj: i: " + i + ", j: " + j);

		// check top if available
		if (i != 0) {
			if (mod[i - 1][j] == '1') {
				visit(mod, i - 1, j);
				visitAllAdj(mod, i - 1, j);
			}
		}
		// check left if available
		if (j != 0) {
			if (mod[i][j - 1] == '1') {
				visit(mod, i, j - 1);
				visitAllAdj(mod, i, j - 1);
			}
		}

		// check right if available
		if (i < size - 1) {
			System.out.println("1: visitAllAdj: i: " + i + ", j: " + j);
			if (mod[i + 1][j] == '1') {
				visit(mod, i + 1, j);
				visitAllAdj(mod, i + 1, j);
			}
		}

		// check bottom if available
		if (j < size1 - 1) {
			System.out.println("2: visitAllAdj: i: " + i + ", j: " + j);
			if (mod[i][j + 1] == '1') {
				visit(mod, i, j + 1);
				visitAllAdj(mod, i, j + 1);
			}
		}

	}

	public void visit(char[][] grid, int i, int j) {
		grid[i][j] = '0';
	}
}
