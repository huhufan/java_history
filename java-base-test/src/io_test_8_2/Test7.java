package io_test_8_2;

import java.io.*;

//定义一个实现序列化接口的类
class Person implements Serializable {
    String name;
    int age;

    //如果没有此属性，将对象序列化后 改变类的某些信息 会导致反序列化失败
    static final long serialVersionUID = 123123L;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Test7  {
    //将一个对象序列化到指定文件中
    public static void serialize(Object object,String fileName)  {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //从指定文件中将对象反序列出来
    public static Object deSerialize(String fileName)  {
       ObjectInputStream ois = null;
       Object object = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File(fileName)));
            object = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                }
            }
        }
        return object;
    }

    public static void main(String[] args) {
        Person person = new Person("张三",13);
        String desFileName = "src\\io_test_8_2\\object.txt";
        //将person对象序列化到目标文件中
        serialize(person,desFileName);
        //从目标文件中反序列化出对象
        Person outPerson = (Person) deSerialize(desFileName);
        System.out.println(outPerson);
    }
}
