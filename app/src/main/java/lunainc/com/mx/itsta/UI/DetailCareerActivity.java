package lunainc.com.mx.itsta.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import lunainc.com.mx.itsta.R;

public class DetailCareerActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_career);
        ButterKnife.bind(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        initVars();
    }

    private void initVars() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Carrera");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}