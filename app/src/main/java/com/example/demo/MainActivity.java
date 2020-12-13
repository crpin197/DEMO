package com.example.demo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView txtSpeechInput;
    public TextView  device_1, device_2;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 1;
    String[] array;
    ArrayList<String> result1 = new ArrayList<String>();
    String done, dv1, dv2;

    device_and_state device1 = new device_and_state();
    device_and_state device2 = new device_and_state();
    /*Khai báo các biến cần thiết */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
        device_1 = (TextView) findViewById(R.id.device1);
        device_2 = (TextView) findViewById(R.id.device2);
        // ánh xạ các biến qua id của button và text
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            // Phương thức lấy tác động khi nhấn vào button
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });
        // lấy tác động của button
    }

    /**
     * Showing google speech input dialog
     */
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //-	Bắt đầu một hoạt động sẽ nhắc người dùng về giọng nói và gửi nó qua quá trình nhận dạng,
        // sau đó hiển thị kết quả trên web hoặc kích hoạt một loại hoạt động dựa trên giọng nói của người dùng.
        // Xác nhận ứng dụng muốn gửi yêu cầu.
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // Gợi ý nhận dạng những gì người dùng nói
        /**intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());**/
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        // Hiển thị yêu cầu cho người dùng chuẩn bị nói vào
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "vi-VN");
        // Chọn ngôn ngữ nói vào: ở đây chọn tiếng Việt
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
        // Nếu không tìm thấy hoạt động của intent, hiển thị ra màn hình 3s dòng chữ "Sorry...
    }

    /**
     * Receiving speech input
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Khai báo một arraylist result1 để chứa chuỗi được nói vào.
//        switch (requestCode) {
//            case REQ_CODE_SPEECH_INPUT: {   /* kiểm tra requestCode có trùng với REQ_*/
//                if (resultCode == RESULT_OK && null != data) { /*RESULT_OK chỉ ra rằng kết quả này đã thành công*/
//                   result1 = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//                    // Trả về một mảng chuỗi kí tự được nói vào.
//                        txtSpeechInput.setText(result1.get(0).toString());
//                    // Trả về text kí tự để hiển thị ra
//                    ;
//                }
//                break;
//            }
//        }
        result1 = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);     // reusult1 được lấy giá trị mảng chuỗi kí tự nói vào
        txtSpeechInput.setText(result1.get(0).toString());                          // Hiển thị text ra màn hình
        dv1 = device_1.getText().toString();
        dv2 = device_2.getText().toString();
        array = ProcessMicro(result1);
        //done = inspect_activity(array);
        inspect_device(array);



        System.out.println(device1.getName_bedroom());
        System.out.println(device1.getState_bedroom());
        System.out.println("\n\n");
        System.out.println(device2.getName_bedroom());
        System.out.println(device2.getState_bedroom());


    }
    public String [] ProcessMicro(ArrayList <String> result){
        String str = result.toString();                                            // Chuyển arraylist thành một mảng chuỗi thuần
        str = str.replace("[", "");                                // Xóa 2 kí tự []
        str = str.replace("]", "");
        array = str.split(" ");
        for (int i=0;i<array.length;i++)
            array[i]=array[i].toLowerCase();
        return array;
    }
    public String inspect_activity (String [] array){
        String done=null;
        for (int i=0;i<array.length;i++){
            if (array[i].equals("turn")&&array[i+1].equals("on")) {
                done = "turn on";
                break;
            }
            else if (array[i].equals("turn")&&array[i+1].equals("off")) {
                done = "turn off";
                break;
            }
            else
                done = "NULL";
        }
        return done;
    }
    public void inspect_device(String [] array){
         done = inspect_activity(array);

        for (int i=0;i<array.length;i++){
            if (done.equals("turn on")){
                if (array[i].equals(dv1))
                {
                    device1.setName_bedroom(name_device.THE_LIGHT);
                    device1.setState_bedroom(state_device.RELAY_ON);
                }
                if (array[i].equals(dv2))
                {
                    device2.setName_bedroom(name_device.THE_FAN);
                    device2.setState_bedroom(state_device.RELAY_ON);
                }
            }
            if (done.equals("turn off"))
            {
                if (array[i].equals(dv1))
                {
                    device1.setName_bedroom(name_device.THE_LIGHT);
                    device1.setState_bedroom(state_device.RELAY_OFF);
                }
                if (array[i].equals(dv2))
                {
                    device2.setName_bedroom(name_device.THE_FAN);
                    device2.setState_bedroom(state_device.RELAY_OFF);
                }
            }
//            else
//            {
//                device1.setName_bedroom(name_device.NO_NAME);
//                device1.setState_bedroom(state_device.RELAY_NOPULL);
//                device2.setName_bedroom(name_device.NO_NAME);
//                device2.setState_bedroom(state_device.RELAY_NOPULL);
//            }
        }
    }

}
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }