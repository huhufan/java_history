package Sort.SelectedSorted;

public class SortData {
    private int N;
    private int[] data;

    public SortData(int n, int[] data) {
        N = n;
        this.data = data;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }
    public int length(){
        return data.length;
    }
    public int get(int i){
        return data[i];
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }
    public void swap(int a,int b){
        int remain = data[a];
        data[a] = data[b];
        data[b] = remain;
    }

}
