package Mine_Sweeper;

public class MineSweeperData {
    public static final String  blockUrl = "resource/mine/block.png";
    public static final String  flagUrl = "resource/mine/flag.png";
    public static final String  mineUrl = "resource/mine/mine.png";
    public static final int[][] pe = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    private boolean[][] isMine;
    public boolean[][] open;
    public boolean[][] flags;
    public int[][] numbers;

    private int N,M;

    public static String numberUrl(int num){
        if(num < 0 || num > 8)
            throw new IllegalArgumentException("No such a number image!");
        return "resource/mine/" + num + ".png";
    }

    public int N() {
        return N;
    }

    public int M() {
        return M;
    }

    public MineSweeperData(int n, int m, int mineNumber) {
        N = n;
        M = m;
        isMine = new boolean[N][M];
        numbers = new int[N][M];
        open = new boolean[N][M];
        flags = new boolean[N][M];

        generateMines(mineNumber);
        calculatedNumbers();


    }
    private void generateMines(int mineNumber){
        for (int i = 0 ;i<mineNumber;i++){
            int x = i/M;
            int y = i%M;
            isMine[x][y] = true;
        }
        for (int i = N*M-1 ; i >=0 ;i--){
            int ix = i/M;
            int iy = i%M;

            int randNum = (int) (Math.random()*(i+1));
            int randx = randNum/M;
            int randy = randNum%M;

            swap(ix,iy,randx,randy);
        }
    }
    private void swap(int x1,int y1,int x2,int y2){
        boolean b = isMine[x1][y1];
        isMine[x1][y1] = isMine[x2][y2];
        isMine[x2][y2] = b;
    }
    public void openAll(){
        for (int i = 0 ;i<N;i++){
            for (int j =0; j <M ; j++){
                    open(i,j);
            }
        }
    }
    public boolean isMine(int x, int y){
        if (!inArea(x,y))
            throw new IllegalArgumentException("out of index in isMine");
        return isMine[x][y];
    }
    public boolean inArea(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    public int getNumber(int x,int y){
        if (!inArea(x,y))
            throw new IllegalArgumentException("out of index in isMine");
        return numbers[x][y];
    }
    public void open(int x,int y){
       open[x][y] = true;
       if (numbers[x][y] > 0)
           return;
       for (int i = x-1 ;i<=x+1;i++){
           for (int j = y-1; j <= y+1 ; j++){
               if (inArea(i,j) && !open[i][j] && !isMine(i,j))
                   open(i,j);
           }
       }
    }
    private void calculatedNumbers(){
        for (int i = 0; i < N ; i ++ ){
            for (int j = 0 ; j < M ; j ++ ){
                if (isMine(i,j)){
                    numbers[i][j]= -1;
                    continue;
                }
                numbers[i][j] = 0;
                for (int ii = i-1 ; ii <= i+1 ; ii ++ ){
                    for (int jj = j-1 ; jj <= j+1 ; jj ++ ){
                         if (inArea(ii,jj) && isMine(ii,jj)){
                             numbers[i][j] ++;
                         }
                    }
                }
            }
        }
    }

}
