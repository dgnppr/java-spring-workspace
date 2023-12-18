package me.dgpr;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoaderTest.class.getClassLoader();
        System.out.println(cl);
        System.out.println(cl.getParent());
        System.out.println(
                cl.getParent().getParent()); // Bootstrap 클래스 로더는 네이티브 코드로 구현되어 있어서 볼 수 없음. VM 마다 구현되어 있는 것이 다름
    }
}
