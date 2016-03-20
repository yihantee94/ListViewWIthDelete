package ucl.listviewwithdelete;

import java.util.ArrayList;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private AtomPayListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupListViewAdapter();

        setupAddPaymentButton();
    }

    public void removeAtomPayOnClickHandler(View v) {
        AtomPayment itemToRemove = (AtomPayment)v.getTag();
        adapter.remove(itemToRemove);
    }

    private void setupListViewAdapter() {
        adapter = new AtomPayListAdapter(MainActivity.this, R.layout.atom_pay_list_item, new ArrayList<AtomPayment>());
        ListView atomPaysListView = (ListView)findViewById(R.id.EnterPays_atomPaysList);
        atomPaysListView.setAdapter(adapter);
    }

    private void setupAddPaymentButton() {
        findViewById(R.id.EnterPays_addAtomPayment).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.insert(new AtomPayment("", 0), 0);
            }
        });
    }
}