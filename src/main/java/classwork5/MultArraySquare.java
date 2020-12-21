package classwork5;

public class MultArraySquare {
    public static void main(String[] args) {
        int Size = 10;
        char[][] graph = new char[Size][Size];
        for(int i =0; i < Size; i++){
            for(int j = 0; j < Size; j++){
                if(  i == 0 || i == Size -1 || j == 0 || j == Size -1){
                    graph[i][j] = '#';
                }else {
                    graph[i][j] = ' ';
                }
            }
        }
        for(int i =0; i < Size; i++){
            for(int j = 0; j < Size; j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }

    }
}
