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
    public RELAY kiemtrathietbi(String [] array, String dv1, String dv2){
        RELAY status = null;
        TestMang tm = new TestMang(array);
        String done = tm.kiemtramang(array);
        for (int i=0;i<array.length;i++){
            if (done.equals("bật")){
                if (array[i].equals(dv1))
                    status = RELAY.RELAY1_ON;
                if (array[i].equals(dv2))
                    status = RELAY.RELAY2_ON;
            }
            else if (done.equals("tắt"))
            {
                if (array[i].equals(dv1))
                    status = RELAY.RELAY1_OFF;
                if (array[i].equals(dv2))
                    status = RELAY.RELAY2_OFF;
            }
            else
            {
                  status = RELAY.RELAY_PULL;
            }
        }
        return status;
    }
}
