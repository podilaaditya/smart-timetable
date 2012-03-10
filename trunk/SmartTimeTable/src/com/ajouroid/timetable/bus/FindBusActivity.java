package com.ajouroid.timetable.bus;

import java.util.ArrayList;

import com.ajouroid.timetable.R;
import com.ajouroid.timetable.R.id;
import com.ajouroid.timetable.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class FindBusActivity extends Activity implements OnClickListener, OnItemClickListener {
	EditText et_busNumber;
	Button btn_search_bus;
	ListView search_bus_List;
	ArrayList<BusInfo> busList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.findbus);
		
		et_busNumber = (EditText)findViewById(R.id.roh_input_search_bus);
		btn_search_bus = (Button)findViewById(R.id.roh_btn_search_bus);
		search_bus_List = (ListView)findViewById(R.id.roh_search_bus_list);
	}
	@Override
	protected void onResume() {
		super.onResume();
		btn_search_bus.setOnClickListener(this);
		search_bus_List.setOnItemClickListener(this);
	}

	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		DBAdapterBus dbA = new DBAdapterBus(this);
		dbA.open();
		busList = dbA.getBusInfoByNumber(et_busNumber.getText().toString());
		search_bus_List.setAdapter(new FindBusAdapter());
		dbA.close();
	}
	
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		BusInfo bus = busList.get(position);
		
		Intent i = new Intent(this, RouteViewer.class);
		i.putExtra("number", bus.getBus_number());
		i.putExtra("id", bus.getBus_id());
		
		startActivity(i);
	}
	
	class FindBusAdapter extends ArrayAdapter<BusInfo>{
		
		FindBusAdapter(){
			super(FindBusActivity.this, R.layout.bus_row ,R.id.row_busnumber, busList);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent){

			LayoutInflater inflater = getLayoutInflater();
			
			View row = inflater.inflate(R.layout.bus_row, parent, false);
			

			TextView number = (TextView)row.findViewById(R.id.row_busnumber);
			number.setText(busList.get(position).getBus_number());
			
			TextView region = (TextView)row.findViewById(R.id.row_region);
			region.setText(busList.get(position).getRegion());
			
			return row;

		}
	}
}