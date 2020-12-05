package com.example.demo;

public class TestMang {
    private String [] array1;

    public TestMang(String[] array1) {
        this.array1 = array1;
    }

    public TestMang() {

    }

    public String[] getArray() {
        return array1;
    }

    public void setArray(String[] array1) {
        this.array1 = array1;
    }
    public String kiemtramang (String [] array1){
        String done=null;
        for (int i=0;i<array1.length;i++){
            if (array1[i].equals("bật")) {
                done = array1[i];
                break;
            }
          else if(array1[i].equals("tắt")) {
                done = array1[i];
                break;
            }
          else
              done = "KHONG";
        }
        return done;
    }
}
