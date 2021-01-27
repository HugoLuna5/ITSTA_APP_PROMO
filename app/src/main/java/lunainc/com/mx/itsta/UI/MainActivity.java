package lunainc.com.mx.itsta.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import lunainc.com.mx.itsta.Adapter.CareerAdapter;
import lunainc.com.mx.itsta.Model.Career;
import lunainc.com.mx.itsta.R;
import lunainc.com.mx.itsta.Utils.Constants;

public class MainActivity extends AppCompatActivity implements  CareerAdapter.ItemClickListener {

    @BindView(R.id.actionGoToChat)
    SpeedDialView actionGoToChat;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ArrayList<Career> careers;
    private CareerAdapter careerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        initVars();
        events();

    }

    private void initVars() {
        careers = new Constants().getListCareers(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        careerAdapter = new CareerAdapter(this, careers);
        careerAdapter.setClickListener(this);
        careerAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(careerAdapter);
    }

    private void events() {



        actionGoToChat.addActionItem(
                new SpeedDialActionItem.Builder(R.id.informacion,R.drawable.ic_info)
                        .setFabBackgroundColor(getResources().getColor(R.color.blue_grey_light))
                        .setLabel(R.string.info)
                        .create());
        actionGoToChat.addActionItem(
                new SpeedDialActionItem.Builder(R.id.chat,R.drawable.ic_chat)
                        .setFabBackgroundColor(getResources().getColor(R.color.blue_grey_light))
                        .setLabel(R.string.chat)
                        .create());

        actionGoToChat.setOnActionSelectedListener(actionItem -> {
            switch (actionItem.getId()){
                case R.id.chat:
                    actionGoToChat.close();
                    startActivity(new Intent(this, ChatActivity.class));
                    finish();
                    return true;
                case R.id.informacion:
                    actionGoToChat.close();
                    break;
                default:
                    actionGoToChat.close();
                    break;


            }

            return false;
        });

    }

    @Override
    public void onItemClick(View view, int position) {
        startActivity(new Intent(this, DetailCareerActivity.class));
        finish();
    }
}