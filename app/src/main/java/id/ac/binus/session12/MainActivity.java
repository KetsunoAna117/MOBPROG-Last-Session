package id.ac.binus.session12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FragmentView fragmentView;
    private FragmentInsert fragmentInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentView = new FragmentView();
        fragmentInsert = new FragmentInsert(fragmentView);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerInsert, fragmentInsert)
                .replace(R.id.containerView, fragmentView)
                .commit();
    }
}