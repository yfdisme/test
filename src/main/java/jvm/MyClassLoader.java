package jvm;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.*;

/**
 * @Auther yfd
 * @Date 2020-07-29 9:45
 */
@Data
@AllArgsConstructor
public class MyClassLoader extends ClassLoader{
    private String path;
    private String classLoaderName;

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte [] b= loadClassData(name);
        return defineClass(name,b,0,b.length);
    }

    @SneakyThrows
    private byte[] loadClassData(String name){
        name = path+name+".class";
        InputStream in = null;
        ByteArrayOutputStream out= null;

        try {
            in = new FileInputStream(new File(name));
            out =  new ByteArrayOutputStream();
            int i = 0;
            while((i = in.read()) != -1){
                out.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            in.close();
            out.close();
        }
        return out.toByteArray();
    }
}
