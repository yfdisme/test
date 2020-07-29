package jvm;

/**
 * @Auther yfd
 * @Date 2020-07-29 9:59
 */
public class ClassLoderCheck {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyClassLoader myclassLoder = new MyClassLoader("H:/workspaces/testDemo/", "myclassLoder");
        Class<?> wali = myclassLoder.loadClass("wali");
        System.out.println(wali.getClassLoader());
        Object o = wali.newInstance();

    }
}
