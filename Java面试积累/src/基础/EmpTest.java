package 基础;

public class EmpTest {
    private Integer id;
    private String  name;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //外部类私有的构造方法
    private EmpTest(Builder builder) {
        setId(builder.id);
        setName(builder.name);
    }

    //对外提供初始化EmpTest类的唯一接口，通过这个方法，获得内部类的实例
    public static Builder newBuilder() {
        return new Builder();
    }

    //静态内部类：Builder
    public static class Builder {
        private Integer id;
        private String name;

        public Builder() {
        }

        public Builder setId(Integer val) {
            id = val;
            return this;
        }

        public Builder setName(String val) {
            name = val;
            return this;
        }

        //通过内部类的build方法，实例化外部类，并给其实例各个字段赋值
        public EmpTest build() {
            return new EmpTest(this);
        }

    }

    public static void main(String[] args) {
        EmpTest empTest = EmpTest.newBuilder().setId(1).setName("first").build();
        System.out.println(empTest.id+"  "+empTest.name);
    }



}
