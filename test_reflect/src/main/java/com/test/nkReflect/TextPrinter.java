package com.test.nkReflect;

import com.test.nkReflect.printer.Paper.Paper;
import com.test.nkReflect.printer.Paper.a4.A4Paper;
import com.test.nkReflect.printer.Printer;
import com.test.nkReflect.printer.inkbox.InkBox;
import com.test.nkReflect.printer.inkbox.color.ColorInkBox;

public class TextPrinter {
    public static void main(String[] args) {
        //使用打印机
        // 声明一个打印机实例
        Printer printer = new Printer();
        // 创建一个具体墨盒和具体的纸张
        InkBox inkBox = new ColorInkBox();
        Paper paper = new A4Paper();

        printer.setInkBox(inkBox);
        printer.setPaper(paper);

        // 实现打印机的功能
        printer.print("TestContent");
    }
}
