import java.util.Scanner;

public class Two_D_Arrays {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        
        // int rows = sc.nextInt();
        // int cols = sc.nextInt();

        // int[][] numbers = new int[rows][cols];
        // System.out.println("Length: " + numbers.length);
        // for(int i=0; i<rows; i++){
        //     for(int j=0; j<cols; j++){
        //         numbers[i][j] = sc.nextInt();        
        //     }
        // }

        // sum of all elements
        // int sum = 0;
        // for(int i=1; i<rows; i++){
        //     for(int j=1; j<cols; j++){
        //         sum += numbers[i][j];
        //     }
        // }
        // System.out.println("The summation of all elements is: " + sum);

        
        // search element
        // int x = sc.nextInt();
        // for(int i=0; i<rows; i++){
        //     for(int j=0; j<cols; j++){
        //         if(numbers[i][j] == x){
        //             System.out.println("Number is found at location: (" + i + ", " + j + ")");
        //         }
        //     }
        // }

        // max-min finding
        // int max = numbers[0][0];
        // int min = numbers[0][0];

        // for(int i=1; i<rows; i++){
        //     for(int j=1; j<cols; j++){
        //         if(max < numbers[i][j]){
        //             max = numbers[i][j];
        //         } else if(min > numbers[i][j]){
        //             min = numbers[i][j];
        //         }
        //     }
        // }
        // System.out.println("Maximum element is: " + max);
        // System.out.println("Minimum element is: " + min);

        // Row-wise sum
        // for(int i=0; i<rows; i++){
        //     int sum = 0;
        //     for(int j=0; j<cols; j++){
        //         sum += numbers[i][j];
        //     }
        //     System.out.println("Row " + i + " sum is = " + sum);
        // }

        // Transpose of a matrix
        // int[][] transpose = new int[cols][rows];
        // for(int i=0; i<rows; i++){
        //     for(int j=0; j<cols; j++){
        //         transpose[j][i] = numbers[i][j];
        //     }
        // }
        // for(int i=0; i<cols; i++){
        //     for(int j=0; j<rows; j++){
        //         System.out.print(transpose[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // Diagonal sum (Square matrix)
        // diagonalSum(numbers);

        // Reverse each row
        // reverseRow(numbers);

        // Check if matrix is symmetric
        // checkSymmetric(numbers);

        // Spiral traversal
        int[][] matrix = { { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 },
                      };
                      
        // sprialTraversal(matrix);

        // rotate matrix 90° Clockwise
        // rotate90Clockwise(matrix);

        // search in sorted matrix
        // searchInSortedMatrix(matrix, 12);

        // Print matrix in Wave Form
        // waveMatrix(matrix);

        // Print matrix in Zig-Zag row-wise
        // zigZagMatrix(matrix);
        // sc.close();
    }

    // Diagonal sum (Square matrix)
    public static void diagonalSum(int[][] matrix) {
        int n = matrix.length;

        int primarySum = 0;
        int secondarySum = 0;

        for(int i=0; i<n; i++){
            primarySum += matrix[i][i];
            secondarySum += matrix[i][n-1-i];
        }

        System.out.println("Primary diagonal sum = " + primarySum);
        System.out.println("Secondary diagonal sum = " + secondarySum);
    }

    // Reverse each row
    public static void reverseRow(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=0; i<rows; i++){
            int left = 0;
            int right = cols - 1;
            
            while(right > left){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }

        for(int i=0; i<cols; i++){
            for(int j=0; j<rows; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // { 1, 3, 5 },
    // { 3, 2, 4 },
    // { 5, 4, 1 }

    // Check if matrix is symmetric
    public static void checkSymmetric(int[][] matrix){
        int n = matrix.length;

        // Check if square
        for(int[] row: matrix){
            if(row.length != n){
                System.out.println("Matrix is not square, since it isn't symmetric");
                return;
            }
        }

        // Check symmetry
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(matrix[i][j] != matrix[j][i]){
                    System.out.print("Matrix is not Symmetric");
                    return;
                }
            }
        }
        System.out.print("Matrix is Symmetric");
    }

    // Spiral traversal
    public static void sprialTraversal(int[][] matrix){
        if(matrix == null || matrix.length == 0) return;
        int m = matrix.length;    // rows
        int n = matrix[0].length; // columns

        int srow = 0;
        int scol = 0;
        int erow = m - 1;
        int ecol = n - 1;

        while(srow <= erow && scol <= ecol){
            // top
            for(int j=scol; j<=ecol; j++){
                System.out.print(matrix[srow][j] + " ");
            }
            // right
            for(int i=srow+1; i<=erow; i++){
                System.out.print(matrix[i][ecol] + " ");
            }
            // bottom
            for(int j=ecol-1; j>=scol; j--){
                if(srow == erow){
                    break;
                }
                System.out.print(matrix[erow][j] + " ");
            }
            // left
            for(int i=erow-1; i>=srow+1; i--){
                if(scol == ecol){
                    break;
                }
                System.out.print(matrix[i][scol] + " ");
            }

            srow++;
            scol++;
            ecol--;
            erow--;
        }
    }

    // Matrix rotation (90°)
    public static void rotate90Clockwise(int[][] matrix){
        // Main matric -> Transpose -> Reverse = Matrix rotation to 90°
        int n = matrix.length;

        // Transpose
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse rows
        for(int i=0; i<n; i++){
            int start = 0, end = n-1;
            while(end >= start){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        } // for anti-clockwise reverse the columns instead of rows

        // print
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate180Clockwise(int[][] matrix){
        // Main matric -> Reverse 2 times = Matrix rotation to 90°
        int n = matrix.length;

        // Reverse rows
        for(int i=0; i<n; i++){
            int start = 0, end = n-1;
            while(end >= start){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

        // Reverse columns
        for(int i=0; i<n; i++){
            int start = 0, end = n-1;
            while(end >= start){
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
                start++;
                end--;
            }
        }

        // print
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Search in sorted matrix
    // Time complexity -> O(rows + cols)
    public static void searchInSortedMatrix(int[][] matrix, int x){
        if(matrix == null || matrix.length == 0) return;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i=0, j=cols-1;

        while(i<rows && j>=0){
            if(matrix[i][j] == x){
                System.out.println("Found at: (" + i + ", " + j + ")");
                return;
            } else if(matrix[i][j] > x){
                j--;
            } else{
                i++;
            }
        }
        System.out.println("x Not found");

        // Brute force method
        // Time complexity -> O(rows * cols)
        // for(int i=0; i<rows; i++){
        //     for(int j=0; j<cols; j++){
        //         if(matrix[i][j] == x){
        //             System.out.print("Number found at: (" + i + ", " + j + ")");
        //         }
        //     }
        // }
    }

    // Set matrix zeroes
    public static void setMatrixZeros(int[][] matrix){

    }

    // Pascal’s triangle
    public static void pascalTriangle(int[][] matrix){

    }

    // Print matrix in Wave Form
    // Input:
    // 1 2 3
    // 4 5 6
    // 7 8 9

    // Output:
    // 1 4 7 8 5 2 3 6 9
    public static void waveMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int j=0; j<cols; j++){
            if(j%2==0){
                // top to bottom for even number of columns
                for(int i=0; i<rows; i++){
                    System.out.print(matrix[i][j] + " ");
                }
            } else{
                // bottom to top
                for(int i=rows-1; i>=0; i--){
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

    // Print matrix in Zig-Zag row-wise
    public static void zigZagMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=0; i<rows; i++){
            if(i%2==0){
                for(int j=0; j<cols; j++){
                    System.out.print(matrix[i][j] + " ");
                }
            } else{
                for(int j=cols-1; j>=0; j--){
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
}
