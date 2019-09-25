import java.io.*;
public class Sudoku {
    public static int [][] array = new int[9][9];
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
                Sudo sudo = new Sudo();
                sudo.setArray(array);
                sudo.solve(0,m);
                array = sudo.getOutputArray();
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < m; j++) {
                        bufferedWriter.write(array[i][j] + " ");
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
