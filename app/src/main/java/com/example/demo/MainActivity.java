package com.example.demo;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.conn.ssl.AllowAllHostnameVerifier;

public class MainActivity extends Activity {

    private TextView txtSpeechInput;
    public TextView device, tett;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 1;

    /*Khai báo các biến cần thiết */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
        device=(TextView) findViewById(R.id.device);
        tett = (TextView) findViewById(R.id.tett);
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
     * */
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
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ArrayList<String> result1= new ArrayList<String>();
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
        result1 = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        txtSpeechInput.setText(result1.get(0).toString());
////        // Trả về một mảng chuỗi kí tự được nói vào.
        StringBuffer result = new StringBuffer();
        for (String s : result1){
            result.append(s);
            result.append(" ");
        }
        String chuoi = result.toString();
        device.setText(result.toString());
    }
    public enum RELAY{
        RELAY1_ON,
        RELAY1_OFF,
        RELAY2_ON,
        RELAY2_OFF;
    }
    public RELAY kiemtra(){

        String str;
        str = device.getText().toString();
        System.out.println(str);
        tett.setText(str.toString());
        RELAY status = null;
        if (str.equals("bật")){
            status = RELAY.RELAY1_ON;
            Toast.makeText(MainActivity.this,"Thiet bi 1 da duoc bat!",Toast.LENGTH_SHORT).show();
        }
        else if (str.equals("tắt thiết bị 1")){
            status = RELAY.RELAY1_OFF;
            Toast.makeText(MainActivity.this,"Thiet bi 1 da duoc tat!",Toast.LENGTH_SHORT).show();
        }
        if (str.equals("bật thiết bị 2")){
            status = RELAY.RELAY2_ON;
            Toast.makeText(MainActivity.this,"Thiet bi 2 da duoc bat!",Toast.LENGTH_SHORT).show();
        }
        else if (str.equals("tắt thiết bị 2")){
            status = RELAY.RELAY2_OFF;
            Toast.makeText(MainActivity.this,"Thiet bi 2 da duoc tat!",Toast.LENGTH_SHORT).show();
        }
        return status;
    }
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }