package even.learn.bitsandpizzas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastaFragment extends ListFragment {

  public PastaFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    ArrayAdapter<String> adapter = new ArrayAdapter<>(
        inflater.getContext(),
        android.R.layout.simple_list_item_1,
        getResources().getStringArray(R.array.pasta)
    );
    setListAdapter(adapter);
    return super.onCreateView(inflater, container, savedInstanceState);
  }
}
