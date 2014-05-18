package commponent.free.tableitem.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.tableitemlib.R;
import commponent.free.tableitem.OnTableItemClickResult;
import commponent.free.tableitem.TableItem;
import commponent.free.tableitem.TableItemAdapter;
import commponent.free.tableitem.TableItemGridValue;
import commponent.free.tableitem.TableItemNameValueShrink;
import commponent.free.tableitem.TableItemTitle;
import commponent.free.tableitem.TableItemValue;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabletest);
		final TableItemAdapter adapter = new TableItemAdapter(this);
		List<TableItem> itemList = new ArrayList<TableItem>();
		TableItemTitle title = new TableItemTitle("不同方式创建列表");
		itemList.add(title);
		itemList.add(new TableItemValue("创建方式一：直接利用TableItem"));
		itemList.add(new TableItemValue("创建方式二：利用TableItemModelSuper"));
		itemList.add(new TableItemNameValueShrink("短名字", "含有短名字也会对齐列"));
		itemList.add(new TableItemNameValueShrink("名字超过一定长度会换行", "选择创建方式查看更多类型"));
		ListView listView = (ListView) findViewById(R.id.listview);
		adapter.setDataList(itemList);
		listView.setAdapter(adapter);
		adapter.setOnItemClickListener(new OnTableItemClickResult() {

			@Override
			public void onItemClick(int position, int columnLocation) {
				int pos = position - 1;
				if (pos > -1 && pos < 2) {
					Intent i = new Intent(MainActivity.this,
							TableItemTestActivity.class);
					i.putExtra("mode", position - 1);
					startActivity(i);
				}
			}
		});
	}
}
