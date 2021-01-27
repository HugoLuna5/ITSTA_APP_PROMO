package lunainc.com.mx.itsta.Utils;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lunainc.com.mx.itsta.Model.Career;
import lunainc.com.mx.itsta.R;

public class Constants {



    public ArrayList<Career> getListCareers(Context context){
        List<String> name = Arrays.asList(context.getResources().getStringArray(R.array.careers_name));
        List<String> about = Arrays.asList(context.getResources().getStringArray(R.array.careers_name));
        List<String> activity = Arrays.asList(context.getResources().getStringArray(R.array.careers_activity));
        List<String> field = Arrays.asList(context.getResources().getStringArray(R.array.careers_field));
        List<String> why = Arrays.asList(context.getResources().getStringArray(R.array.careers_why));

        ArrayList<Career> careers =  new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            careers.add(new Career(name.get(i), R.drawable.img_test, about.get(i), activity.get(i), field.get(i), why.get(i)));
        }


        return careers;
    }

}
