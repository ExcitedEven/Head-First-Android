package even.learn.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSedMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        /**
         * Intent intent = new Intent (this, Target.class);
         * 第一个参数告诉Android这个意图来自哪个对象
         * 第二个参数是需要接收这个意图的活动的类名
         */
//        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        /**
         * intent.putExtra("message", value);
         * message : 传入值的String名
         * value : 值, 可以是一个基本类型,也可以是基本类型的数组
         *
         * 可以重复使用putExtra为intent添加大量额外数据,但是要注意"message"唯一
         */
//        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chosenTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chosenTitle);
//        startActivity(intent);
        startActivity(chosenIntent);
    }
}
