package even.learn.bitsandpizzas;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.ListFragment;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoresFragment extends ListFragment {

  public StoresFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    ArrayAdapter<String> adapter = new ArrayAdapter<>(
        inflater.getContext(),
        android.R.layout.simple_list_item_1,
        getResources().getStringArray(R.array.stores)
    );
    setListAdapter(adapter);
    return super.onCreateView(inflater, container, savedInstanceState);
  }
}
