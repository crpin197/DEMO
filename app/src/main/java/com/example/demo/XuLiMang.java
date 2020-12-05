package com.example.demo;

import java.util.ArrayList;

public class XuLiMang {
    private ArrayList <String> result;

    public XuLiMang(ArrayList<String> result) {
        this.result = result;
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public void setResult(ArrayList<String> result) {
        this.result = result;
    }
    public String [] XuLi(ArrayList <String> result){
        String [] array;
        String str = result.toString();                                            // Chuyển arraylist thành một mảng chuỗi thuần
        str = str.replace("[", "");                                // Xóa 2 kí tự []
        str = str.replace("]", "");
        array = str.split(" ");
        for (int i=0;i<array.length;i++)
            array[i]=array[i].toLowerCase();
        return array;
    }
}
