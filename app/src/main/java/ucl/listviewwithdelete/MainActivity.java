package ucl.listviewwithdelete;

import java.util.ArrayList;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private FoodChoiceListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupListViewAdapter();

        setupAddFoodChoiceButton();
    }

    public void removeFoodChoiceOnClickHandler(View v) {
        FoodChoice itemToRemove = (FoodChoice)v.getTag();
        adapter.remove(itemToRemove);
    }

    private void setupListViewAdapter() {
        adapter = new FoodChoiceListAdapter(MainActivity.this, R.layout.food_list_view, new ArrayList<FoodChoice>());
        ListView foodChoiceListView = (ListView)findViewById(R.id.foodChoiceList);
        foodChoiceListView.setAdapter(adapter);
    }

    private void setupAddFoodChoiceButton() {
        findViewById(R.id.addFoodChoiceButton).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.insert(new FoodChoice("", 0), 0);
            }
        });
    }
}