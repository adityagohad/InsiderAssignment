package in.adzlab.insiderassignment.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import in.adzlab.insiderassignment.R;
import in.adzlab.insiderassignment.model.InsiderEvent;
import in.adzlab.insiderassignment.network.ResponseModel.HomePage;
import in.adzlab.insiderassignment.ui.fragment.InsiderEventListFragment;

public class MainActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    HomePage homePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homePage = getIntent().getExtras().getParcelable("data");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("INSIDER.IN");

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            List<InsiderEvent> insiderEvents = new ArrayList<>();
            for (String slug : homePage.getList().getGroupwiseList().get(homePage.getGroups().get(position))) {
//                if(System.currentTimeMillis() < homePage.getList().getMasterList().get(slug).getMin_show_start_time()*1000){
//                    insiderEvents.add(homePage.getList().getMasterList().get(slug));
//                }
                insiderEvents.add(homePage.getList().getMasterList().get(slug));
            }

            return InsiderEventListFragment.newInstance(insiderEvents);
        }

        @Override
        public int getCount() {
            return homePage.getGroups().size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return homePage.getGroups().get(position);
        }
    }
}
