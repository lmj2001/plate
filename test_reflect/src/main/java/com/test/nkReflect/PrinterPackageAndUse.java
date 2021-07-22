package com.test.nkReflect;

import com.test.nkReflect.printer.Paper.Paper;
import com.test.nkReflect.printer.Printer;
import com.test.nkReflect.printer.inkbox.InkBox;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

// 借助 属性配置相关文件 读取打印机 墨盒和纸张 具体类
// 使用反射机制
public class PrinterPackageAndUse {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String printerConfigFileName = "printer.properties";
        InputStream resourceAsStream = PrinterPackageAndUse.class.getClassLoader().getResourceAsStream(printerConfigFileName);

        Properties prop = new Properties();
        prop.load(resourceAsStream);

        String inboxname = prop.getProperty("inkbox");
        String papername = prop.getProperty("paper");

        Class<InkBox> inboxClazz = (Class<InkBox>) Class.forName(inboxname);
        Class<Paper> paperClazz = (Class<Paper>) Class.forName(papername);
        Class<Printer> printerClazz = Printer.class;

        Field inboxField = printerClazz.getDeclaredField("inkBox");
        Field paperField = printerClazz.getDeclaredField("paper");

        inboxField.setAccessible(true);
        paperField.setAccessible(true);

        Constructor<InkBox> Inboxconstructor = inboxClazz.getConstructor();
        Constructor<Paper> Papercnstructor = paperClazz.getConstructor();

        InkBox inkBox = Inboxconstructor.newInstance();
        Paper paper = Papercnstructor.newInstance();

        Printer printer = new Printer();
        printer.setInkBox(inkBox);
        printer.setPaper(paper);
        printer.print("ascsacs");
    }
}
/*public class PrinterPackageAndUse {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // 0. 读入打印机配置文件
        String printerConfigFilename = "printer.properties";
        InputStream printerConfigIS = PrinterPackageAndUse.class.getClassLoader().getResourceAsStream(printerConfigFilename);

        // 1. 创建 Properties 实例对象, 读入配置文件 再读入 key 对应的 value(墨盒和纸张的具体类的全限定名称 - String)
        Properties prop = new Properties();
        prop.load(printerConfigIS);

        String inkBoxClassName = prop.getProperty("inkbox");
        String paperClassName = prop.getProperty("paper");

        // 2. 获取 inkbox 和 paper 类 类型 实例 == (获取准确的 墨盒和纸张 的类 的 实例)
        Class<InkBox> inkBoxClazz = (Class<InkBox>) Class.forName(inkBoxClassName);
        Class<Paper> paperClazz = (Class<Paper>) Class.forName(paperClassName);
        // 2. 获取 Printer 的类 类型 实例 == (获取 Printer 的类 的 实例)
        Class<Printer> printerClazz = Printer.class;

        // 3. 获取 Printer 类中的属性(inkBox, paper), 方法(print)
        Field inkBoxField = printerClazz.getDeclaredField("inkBox");
        Field paperField = printerClazz.getDeclaredField("paper");
        inkBoxField.setAccessible(true);     // 让私有属性可以直接读写
        paperField.setAccessible(true);

        Method printMethod = printerClazz.getMethod("print", String.class);

        // 4. 对象实例化 == 基于类 类型 的 实例 进行 类的实例化
        Printer printer = printerClazz.newInstance();     // 调用默认无参构造方法, 完成类的实例化
        // 获取构造方法, 调用构造方法 -- 一般适合与有参的构造方法,也可用于无参构造方法的调用
        Constructor<InkBox> inkBoxClazzConstructor = inkBoxClazz.getConstructor();
        Constructor<Paper> paperClazzConstructor = paperClazz.getConstructor();
        InkBox inkBox = inkBoxClazzConstructor.newInstance();
        Paper paper = paperClazzConstructor.newInstance();

        // 5. 组装 (将实际配置文件中指明的具体类的实例设置到 Printer 中)
        inkBoxField.set(printer, inkBox);            //printer.setInkBox(inkBox);
        paperField.set(printer, paper);              //printer.setPaper(paper);

        // 6. 答应(调用 printer 中的 print 方法)
        String content = "Besed Reflect.";
        printMethod.invoke(printer, content);       //printer.print(content);
    }

}*/
