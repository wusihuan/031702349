public class Sudo {
    public int [][] array = new int[9][9];

    public void setArray(int [][] array){
        this.array = array;
    }

    public void Sudo(int [][] array){
        this.array = array;
    }

    private boolean judge(int n,int x,int y,int m){
        for(int i=0;i<m;i++){
            if(array[x][i]==n)
                return false;
            if(array[i][y]==n)
                return false;
        }

        if (m==4){
            for (int i = (x / 2) * 2; i < (x / 2 + 1) * 2; i++) {
                for (int j = (y / 2) * 2; j < (y / 2 + 1) * 2; j++) {
                    if (array[i][j] == n)
                        return false;
                }
            }
        }

        if(m==6) {
            for (int i = (x / 2) * 2; i < (x / 2 + 1) * 2; i++) {
                for (int j = (y / 3) * 3; j < (y / 3 + 1) * 3; j++) {
                    if (array[i][j] == n)
                        return false;
                }
            }
        }

        if(m==8) {
            for (int i = (x / 4) * 4; i < (x / 4 + 1) * 4; i++) {
                for (int j = (y / 2) * 2; j < (y / 2 + 1) * 2; j++) {
                    if (array[i][j] == n)
                        return false;
                }
            }
        }

        if(m==9) {
            for (int i = (x / 3) * 3; i < (x / 3 + 1) * 3; i++) {
                for (int j = (y / 3) * 3; j < (y / 3 + 1) * 3; j++) {
                    if (array[i][j] == n)
                        return false;
                }
            }
        }

        return true;
    }

    public int [][] outputArray = new int[9][9];

    public int [][] getOutputArray(){
        return outputArray;
    }

    public void solve(int num,int m)
    {
        if(num==m*m){
            for(int i=0; i<m; i++){
                for(int j=0; j<m; j++)
                    outputArray[i][j]=array[i][j];
            }
            return ;
        }
        int i=num/m,j=num%m;
        if(array[i][j]!=0) solve(num+1,m);
        else{
            for(int k=1; k<=m; k++) {
                if(judge(k,i,j,m)) {
                    array[i][j]=k;
                    solve(num+1,m);
                }
            }
            array[i][j]=0;
        }
        return ;
    }
}
