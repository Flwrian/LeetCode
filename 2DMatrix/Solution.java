class Solution {

    // Explication:
    // Au lieu de chercher bêtement a travers toute la matrix, on peut utiliser le fait que:
    // Les nombres sont dans l'ordre et que le premier nombre du row n+1 sera plus grand que le dernier du row n.
    // On commence donc à chercher à partir de la derniere colonne et du row 0.
    // Si le dernier nombre du row n est inférieur a notre target, alors on sais qu'il ne se trouve pas dedans. Dans ce cas là, on passe au row suivant.
    // Si le dernier nombre du row n est supérieur a notre target, alors on sais qu'il se trouve dans le row actuel. Dans ce cas là, c--;
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[r].length - 1;
        while (r < matrix.length && c >= 0){
            if (matrix[r][c]==target)
                return true;
            if (matrix[r][c] < target)
                r++;
            else
                c--;
        }
        return false;
    }


}