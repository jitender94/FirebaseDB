package in.aj.firebaserealtimedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private EditText textValue;
    private Button mSendData;
    private EditText textKey;

    private Firebase mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        mRef= new Firebase("https://realtimedb-b9ccd.firebaseio.com/");

        textValue = (EditText) findViewById(R.id.textValue);
        mSendData = (Button)findViewById(R.id.sendData);
        textKey = (EditText)findViewById(R.id.textKey);

        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = textValue.getText().toString();
                String key = textKey.getText().toString();
                Firebase childRef= mRef.child(key);

                childRef.setValue(value);
            }
        });
    }
}
