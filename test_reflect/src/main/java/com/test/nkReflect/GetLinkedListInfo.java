package com.test.nkReflect;

import java.lang.reflect.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GetLinkedListInfo {
    public static void main(String[] args) throws ClassNotFoundException {
        // 使用一个变量必须直知道变量所属的类型
        // 使用一个类就必须知道类的类型
        // 准备操作一个类,获取了待解析的类，本质上是类类型的实例
        // 获取类的类型,声明一个类类型，java中的类类型为class
        Class<?> clazz;
        // 1。获取类 类型的一个具体实例 ，类<LinkedList>
        // 借助类型获取类类型的实例，不推荐
//        clazz = LinkedList.class;

        // 借助该类的实例对象来获取该类类型的实例,不推荐
//        LinkedList list = null;
//        clazz = list.getClass();

        // 借助类的全名字符串来获取某个类的类型，推荐。因为在当前代码中不会体验出要解析的类的任何信息
        clazz = Class.forName("java.util.LinkedList");

        // 解析类内容
        //1. package
        String packageName = clazz.getPackageName();
        System.out.println("package " + packageName);

        // import ，无法通过反射直接获取
        /*
            所涉及到的类型：
                父类 & 接口
                属性的类型
                方法的返回值、参数类型、抛出异常
             构造方法，方法中局部的类型

         */
        Set<String> importSet = new HashSet<>();
        importSet.add(clazz.getSuperclass().getName());
//        importSet.add(clazz.getInterfaces());
        for (String s : importSet) {
            System.out.println("import " + s);
        }
        // 类的声明，modifier
        int clazzModifiers = clazz.getModifiers();
        String classModifierStr = Modifier.toString(clazzModifiers);
        System.out.print(classModifierStr);

        // 判断是否为interfaces
        if (Modifier.isInterface(clazzModifiers)) {
            System.out.print(' ');
        } else System.out.print(" class ");

        // 获取类名
        String simpleClassName = clazz.getSimpleName();
        System.out.print(simpleClassName);

        // 获取泛型generictype
        TypeVariable<? extends Class<?>>[] tys = clazz.getTypeParameters();
        if (tys != null && tys.length != 0) {//有泛型，输出
            for (int i = 0; i < tys.length; i++) {
                String typeName = tys[i].getName();
                if (i == 0) {
                    System.out.print("<" + typeName);
                } else System.out.print(", " + typeName);
                if (i == tys.length - 1)
                    System.out.print(">");
            }
        }

        //获取父类，superclass
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null) {
            System.out.print(" extends " + superClazz.toGenericString());// 获取带有泛型信息的父类
        }

        // interface(s)
        Class<?>[] ifs = clazz.getInterfaces();
        if (ifs != null && ifs.length != 0) {
            System.out.print(" implements ");
            for (int i = 0; i < ifs.length; i++) {
                if (i == 0) {
                    System.out.print(ifs[i].getSimpleName());
                } else System.out.print(", " + ifs[i].getSimpleName());
            }
        }
        System.out.println(" {");
        // 获取内部类或者外部类
        Class<?>[] declaredClasses = clazz.getDeclaredClasses();
        if (declaredClasses != null && declaredClasses.length != 0) {
            System.out.println("All inner class :");
            for (Class<?> declaredClass : declaredClasses) {
                System.out.println("\t" + declaredClass.getName());
            }
        }

        Class<?> declaringClass = clazz.getDeclaringClass();
        if (declaringClass != null) {
            System.out.println("Out Class: " + declaringClass.getName());
        }

        // 获取所有的属性包括私有属性
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null && fields.length != 0) {
            System.out.println("All Fields :");
            for (Field field : fields) {
                System.out.print("\t");
                int modifiers = field.getModifiers();
                String s = Modifier.toString(modifiers);
                Class<?> type = field.getType();
                String simpleName = type.getSimpleName();
                String name = field.getName();
                System.out.println(s + " " + simpleName + " " + name);
            }
        }
        // 构造方法
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors != null && constructors.length != 0) {
            System.out.println("All Constructor :");
            for (Constructor<?> constructor : constructors) {
                System.out.print("\t");
                int modifiers = constructor.getModifiers();
                String s = Modifier.toString(modifiers);
                String name = constructor.getName();
                System.out.print(s + " " + name + " (");
                Class<?>[] types = constructor.getParameterTypes();
                if (types != null && types.length != 0) {
                    for (int i = 0; i < types.length; i++) {
                        if (i == 0) {
                            System.out.print(types[i].getSimpleName());
                        } else
                            System.out.print(", " + types[i].getSimpleName());
                    }
                }
                System.out.print(");\n");//省略异常抛出的声明
            }
        }

        // methods
        Method[] methods = clazz.getDeclaredMethods();
        if (methods != null && methods.length != 0) {
            System.out.println("All Methods : ");
            for (Method method : methods) {
                System.out.println("\t" + method.toGenericString());
            }
        }

        System.out.println(" }");
    }
}
