package classwork5;

public class MultiArray {
    public static void main(String[] args) {
        int Size = 10;
        char[][] graph = new char[Size][Size];
        for(int i = 0; i < Size; i++){
            for(int j = 0; j < Size; j++){
                graph[i][j] = '#';
            }
        }
        for (int i = 0; i < Size; i++){
            for (int j = 0; j < Size; j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }
}
