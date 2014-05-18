package commponent.free.tableitem.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tableitemlib.R;
import commponent.free.tableitem.OnTableItemClickResult;
import commponent.free.tableitem.TableItem;
import commponent.free.tableitem.TableItemAdapter;
import commponent.free.tableitem.TableItemModelSuper;

public class TableItemTestActivity extends Activity {
	private int mode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabletest);
		final TableItemAdapter adapter = new TableItemAdapter(this);
		int mode = getIntent().getIntExtra("mode", 0);
		if (mode == 0) {
			adapter.setDataList(TableDataUtil.getGridDataList("Item"));
			adapter.addDataItem(TableDataUtil.getTableDataList("Item"));
		} else {
			adapter.setDataTableItemModelList(getListModel());
		}
		ListView listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(adapter);
		adapter.setOnItemClickListener(new OnTableItemClickResult() {

			@Override
			public void onItemClick(int position, int columnLocation) {
				Toast.makeText(TableItemTestActivity.this,
						"点击的第几项：" + position, Toast.LENGTH_SHORT).show();

			}
		});
	}

	private List<? extends TableItemModelSuper> getListModel() {
		List<TableItemModelSuper> list = new ArrayList<TableItemModelSuper>();
		for (int i = 0; i < 5; i++) {
			list.add(new TestModel(i + "==" + i));
		}
		return list;
	}

	class TestModel implements TableItemModelSuper {
		public String tag;

		public TestModel(String tag) {
			super();
			this.tag = tag;
		}

		@Override
		public List<TableItem> getTableItemList(Application application) {
			List<TableItem> list = new ArrayList<TableItem>();
			list.addAll(TableDataUtil.getGridDataList("TestModel"));
			list.addAll(TableDataUtil.getTableDataList("TestModel"));
			return list;
		}
	}

}
