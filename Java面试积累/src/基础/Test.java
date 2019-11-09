package 基础;

interface Inter{
    public String show();
}

class Cla implements Inter{

    @Override
    public String show() {
        return null;
    }
}

class Test{
    public void testMethod(Cla cla){
        System.out.println(cla.show());
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.testMethod(new Cla(){
            @Override
            public String show() {
                return "what are you doing?";     //程序输出结果为what are you doing?
            }
        });
    }
}
