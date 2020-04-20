package even.learn.bitsandpizzas;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

  private ShareActionProvider shareActionProvider;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
    ViewPager pager = (ViewPager) findViewById(R.id.pager);
    pager.setAdapter(pagerAdapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    MenuItem menuItem = menu.findItem(R.id.action_share);
    shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
    setShareActionIntent("Want to join me for pizza?");
    return super.onCreateOptionsMenu(menu);
  }

  private void setShareActionIntent(String text) {
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("text/plain");
    intent.putExtra(Intent.EXTRA_TEXT, text);
    shareActionProvider.setShareIntent(intent);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_create_order:
        startActivity(new Intent(this, OrderActivity.class));
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  private class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(@NonNull FragmentManager fm) {
      super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          return new TopFragment();
        case 1:
          return new PizzaFragment();
        case 2:
          return new PastaFragment();
        case 3:
          return new StoresFragment();
      }
      return null;
    }

    @Override
    public int getCount() {
      return 4;
    }
  }
}
