package com.example.demo;

public class TestRelay extends  TestMang{
    private String [] array;

    public TestRelay(String[] array) {
        super();
        this.array = array;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }
    public RELAY kiemtrathietbi1(String [] array, String dv1){
        RELAY device1 = null;
        TestMang tm = new TestMang(array);
        String done = tm.kiemtramang(array);
        for (int i=0;i<array.length;i++){
            if (done.equals("bật")){
                if (array[i].equals(dv1))
                    device1 = RELAY.RELAY_ON;
            }
            else if (done.equals("tắt"))
            {
                if (array[i].equals(dv1))
                    device1 = RELAY.RELAY_OFF;
            }
            else
            {
                device1 = RELAY.RELAY_NOPULL;
            }
        }
        return device1;
    }
    public RELAY kiemtrathietbi2(String [] array, String dv2){
        RELAY device2 = null;
        TestMang tm = new TestMang(array);
        String done = tm.kiemtramang(array);
        for (int i=0;i<array.length;i++){
            if (done.equals("bật")){
                if (array[i].equals(dv2))
                    device2 = RELAY.RELAY_ON;
            }
            else if (done.equals("tắt"))
            {
                if (array[i].equals(dv2))
                    device2 = RELAY.RELAY_OFF;
            }
            else
            {
                device2 = RELAY.RELAY_NOPULL;
            }
        }
        return device2;
    }
}
