package com.example.api_call_architechturecomponent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api_call_architechturecomponent.adapter.HolidayListAdapter;
import com.example.api_call_architechturecomponent.model.HolidayModel;
import com.example.api_call_architechturecomponent.viewmodel.HolidayViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HolidayListAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private HolidayListAdapter adapter;
    private List<HolidayModel> holidayModelList;
    private HolidayViewModel viewModel;
    private TextView TV_NoResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        TV_NoResult = findViewById(R.id.TV_NoResult);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new HolidayListAdapter(this, holidayModelList, this);
        recyclerView.setAdapter(adapter);


        viewModel = new ViewModelProvider(this).get(HolidayViewModel.class);

        viewModel.getHolidayListObserver().observe(this, holidayModels -> {

            if (holidayModels != null) {
                TV_NoResult.setVisibility(View.GONE);
                holidayModelList = holidayModels;
                adapter.setmList(holidayModels);
            } else {
                TV_NoResult.setVisibility(View.VISIBLE);
            }
        });

        viewModel.makeApiCall();

    }

    @Override
    public void onHolidayClick(HolidayModel holidayModel) {
        Toast.makeText(this, "Item Clicked " + holidayModel.getName(), Toast.LENGTH_SHORT).show();
    }
}