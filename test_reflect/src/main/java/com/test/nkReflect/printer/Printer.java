package com.test.nkReflect.printer;

import com.test.nkReflect.printer.Paper.Paper;
import com.test.nkReflect.printer.inkbox.InkBox;

// 完成组装，需要具体的墨盒和具体的值
public class Printer {
    private InkBox inkBox;
    private Paper paper;

    public void print(String content) {
        System.out.println(inkBox.getColor() + " " + paper.size() + " " + content);
    }

    public InkBox getInkBox() {
        return inkBox;
    }

    public void setInkBox(InkBox inkBox) {
        this.inkBox = inkBox;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
