package com.example.demo;

public class Test extends MainActivity {
       public Enum<com.example.demo.RELAY> []kiemtra(){
        RELAY[] status = new RELAY[4];
        for (int i=0;i<array.length;i++){
            if (array[i].equals("bật")){
                for (int j=0;j<array.length;j++){
                    if (array[j].equals("đèn")){
                        status[0] = RELAY.RELAY1_ON;
                    }
                    if (array[j].equals("quạt")){
                        status[1] = RELAY.RELAY2_ON;
                    }
                }
            }
        }
        for (int i=0;i<array.length;i++){
            if (array[i].equals("tắt")){
                for (int j=0;j<array.length;j++){
                    if (array[j].equals("đèn")){
                        status[2] = RELAY.RELAY1_OFF;
                    }
                    if (array[j].equals("quạt")){
                        status[3] = RELAY.RELAY2_OFF;
                    }
                }
            }
        }
        return status;
    }
}
