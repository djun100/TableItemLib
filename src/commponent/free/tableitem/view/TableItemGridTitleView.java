package commponent.free.tableitem.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.tableitemlib.R;
import commponent.free.tableitem.TableItem;
import commponent.free.tableitem.view.adapter.TextViewAdapter;
import commponent.free.tableitem.view.adapter.ViewAdapter;

/**
 * 
 * 普通文本展示的视图
 * 
 * @author Free
 * 
 */
public class TableItemGridTitleView extends TableItemGridView {

	public TableItemGridTitleView(Context context, TableItem tableItem) {
		super(context, tableItem);
	}

	@Override
	protected int getBackResID() {
		return R.drawable.green_tableitem_title_selector;
	}

	@Override
	protected ViewAdapter getItemView(LayoutInflater layoutInflater,
			int location) {
		TextView view = (TextView) layoutInflater.inflate(
				R.layout.table_item_grid_title, null);
		return new TextViewAdapter(view);
	}

}
