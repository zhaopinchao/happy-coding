package creation.prototype;

import java.io.*;

/**
 * @author zhaopc
 * @date 2021/4/18 21:13
 */
public class PrototypeExample {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Student student = new Student();
        student.setName("小明");
        student.setAge(10);
        student.setSex("男");
        Book b = new Book();
        b.setName("语文书");
        b.setMoney(10);
        student.setBook(b);

        // 浅拷贝, 当修改引用类型对象的数据时， 原型和副本会同时改变
        Student clone = student.clone();
        // 设置书本的money为20，原型会改变
        clone.getBook().setMoney(20);

        // 深拷贝一：new 对象
        Student deepCopy = new Student();
        deepCopy.setName(student.getName());
        deepCopy.setAge(student.getAge());
        deepCopy.setSex(student.getSex());
        Book book = new Book();
        book.setName(student.getBook().getName());
        book.setMoney(student.getBook().getMoney());
        deepCopy.setBook(book);

        // 设置书本的money为30，原型不会改变
        deepCopy.getBook().setMoney(30);

        // 深拷贝二： 序列化，反序列话
        Student deepCopy2 = student.deepCopy();
        // 设置书本的money为40，原型不会改变
        deepCopy2.getBook().setMoney(40);

    }
}

class Student implements Cloneable, Serializable {
    private String name;
    private int age;
    private String sex;
    private Book book;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    public Student deepCopy() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (Student) ois.readObject();
    }
}

class Book implements Serializable {

    private String name;
    private int money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
