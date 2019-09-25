import java.io.*;
public class Sudoku {

    public static int [][] array = new int[10][10];

    private static boolean judge(int n,int x,int y,int m){
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

    public static int [][] outputArray = new int[10][10];

    public static void solve(int num,int m)
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
    public static void main(String [] args) throws IOException{
        char[] ch = args[1].toCharArray();
        int m = ch[0]-48;
        char[] chars = args[3].toCharArray();
        int n = chars[0] - 48;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(args[5])));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(args[7])));
            for (int l = 0; l < n; l++) {
                for (int i = 0; i < m; i++) {
                    String s = bufferedReader.readLine();
                    String str = s.replaceAll(" ", "");
                    for (int j = 0; j < m; j++) {
                        char[] c = str.toCharArray();
                        array[i][j] = c[j] - 48;
                    }
                }
                solve(0, m);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < m; j++) {
                        bufferedWriter.write(outputArray[i][j] + " ");
                    }
                    bufferedWriter.write("\n");
                }
                bufferedWriter.write("\n");
                String s = bufferedReader.readLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            return;
        }
    }
}
