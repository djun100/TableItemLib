package commponent.free.tableitem.view;

import android.content.Context;

import com.example.tableitemlib.R;
import commponent.free.tableitem.TableItem;

public class TableItemNameValueBigView extends TableItemNameValueView {

	public TableItemNameValueBigView(Context context, TableItem tableItem) {
		super(context,tableItem);
	}

	@Override
	protected int getItemLayoutID() {
		return R.layout.table_item_namevalue_big_text;
	}

}
