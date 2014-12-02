package com.example.valueres;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {

	static int textIDS[] = {
		R.string.c1, R.string.c2,
		R.string.c3, R.string.c4,
		R.string.c5, R.string.c6,
		R.string.c7, R.string.c8,
		R.string.c9
	};
	
	static int colorIDS[] = {
		R.color.c1, R.color.c2,
		R.color.c3, R.color.c4,
		R.color.c5, R.color.c6,
		R.color.c7, R.color.c8,
		R.color.c9
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BaseAdapter baseAdapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View view, ViewGroup parentView) {
				// TODO Auto-generated method stub
				
				TextView textView = new TextView(MainActivity.this);
				Resources resources = MainActivity.this.getResources();
				textView.setWidth((int) resources.getDimension(R.dimen.cell_width));
				textView.setHeight((int) resources.getDimension(R.dimen.cell_height));
				textView.setText(textIDS[position]);
				textView.setBackgroundResource(colorIDS[position]);
				textView.setTextSize((int) resources.getDimension(R.dimen.title_font_size));
				//这里就是用来设置文本居中显示
				//如果使用Layout_gravity这是对控件本身的设置，很明显带了布局关键字Layout了
				textView.setGravity(Gravity.CENTER);
				return textView;
			}
			
			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}
			
			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return getResources().getText(textIDS[arg0]);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return textIDS.length;
			}
		};
		
		GridView gridView = (GridView)findViewById(R.id.gridView1);
		gridView.setAdapter(baseAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				EditText showView = (EditText)findViewById(R.id.EditText1);
				showView.setGravity(Gravity.CENTER);
				//TMD java里面强转不支持(Type)(XXX), 而是((Type)XXX)
				showView.setText("当前点击的是： "+ ((TextView)arg1).getText().toString());
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
