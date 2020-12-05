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
    public TextView  device1, device2;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 1;
    String[] array;
    ArrayList<String> result1 = new ArrayList<String>();
    TestMang tm = new TestMang(array);
    TestRelay tr = new TestRelay(array);
    XuLiMang xlm = new XuLiMang(result1);
    String done, dv1, dv2;
    /*Khai báo các biến cần thiết */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
        device1 = (TextView) findViewById(R.id.device1);
        device2 = (TextView) findViewById(R.id.device2);
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


    array = xlm.XuLi(result1);
    done = tm.kiemtramang(array);
    dv1 = device1.getText().toString();
    dv2 = device2.getText().toString();
    RELAY d2 = tr.kiemtrathietbi2(array,dv2);
    RELAY d1 = tr.kiemtrathietbi1(array,dv1);

    if (d1 == RELAY.RELAY_ON)
        System.out.println("BINH");
    if (d2 == RELAY.RELAY_ON)
        System.out.println("LEBINH");
    for (int i=0;i<array.length;i++)
        System.out.println(array[i]);
}

}
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }