package even.learn.workout;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Locale;

public class StopwatchFragment extends Fragment implements View.OnClickListener {

  private int seconds = 0;
  private boolean isRunning = false;
  private boolean wasRunning = false;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState != null) {
      seconds = savedInstanceState.getInt("seconds");
      isRunning = savedInstanceState.getBoolean("isRunning");
      wasRunning = savedInstanceState.getBoolean("wasRunning");
    }
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
    runTimer(layout);
    Button startButton = (Button) layout.findViewById(R.id.start_button);
    startButton.setOnClickListener(this);
    Button stopButton = (Button) layout.findViewById(R.id.stop_button);
    stopButton.setOnClickListener(this);
    Button resetButton = (Button) layout.findViewById(R.id.reset_button);
    resetButton.setOnClickListener(this);
    return layout;
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.start_button:
        onClickStart();
        break;
      case R.id.stop_button:
        onClickStop();
        break;
      case R.id.reset_button:
        onClickReset();
        break;
    }
  }

  @Override
  public void onPause() {
    super.onPause();
    wasRunning = isRunning;
    isRunning = false;
  }

  @Override
  public void onResume() {
    super.onResume();
    isRunning = wasRunning;
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    outState.putInt("seconds", seconds);
    outState.putBoolean("isRunning", isRunning);
    outState.putBoolean("wasRunning", wasRunning);
  }

  public void onClickStart() {
    isRunning = true;
  }

  public void onClickStop() {
    isRunning = false;
  }

  public void onClickReset() {
    isRunning = false;
    seconds = 0;
  }

  private void runTimer(View view) {
    final TextView timeView = (TextView) view.findViewById(R.id.time_view);
    final Handler handler = new Handler();
    handler.post(new Runnable() {
      @Override
      public void run() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
        timeView.setText(time);
        if (isRunning) {
          seconds++;
        }
        handler.postDelayed(this, 1000);
      }
    });
  }
}
