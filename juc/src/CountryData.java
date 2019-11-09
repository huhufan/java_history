public enum CountryData {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏");

    private int num;
    private String  couName;

    CountryData(int num, String couName) {
        this.num = num;
        this.couName = couName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public static String getName(int index){
        for (CountryData data: values()){
            if (data.getNum() == index){
                return data.getCouName();
            }
        }
        return null;
    }
}
