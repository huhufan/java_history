package ThreeGateExperiment;

public class ThreeGateExperiment {
    private int N;
    private boolean isChange;

    public ThreeGateExperiment(int n, boolean isChange) {
        N = n;
        this.isChange = isChange;
    }

    public void run(){
        int sum=0;
        for (int i= 0;i<N;i++){
            if (choose(isChange))
                sum++;
        }
        System.out.println("isChange:"+isChange);
        System.out.println((double)sum/N);

    }
    public boolean choose(boolean isChange){
        int prize = (int) (Math.random()*3);
        int choose = (int) (Math.random()*3);
        if (prize==choose)
            return isChange?false:true;
        else
            return isChange?true:false;
    }

    public static void main(String[] args) {
        ThreeGateExperiment a = new ThreeGateExperiment(10000,false);
        a.run();
        ThreeGateExperiment b = new ThreeGateExperiment(10000,true);
        b.run();

    }

}


