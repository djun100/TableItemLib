package commponent.free.tableitem.view;

import android.content.Context;

import com.example.tableitemlib.R;
import commponent.free.tableitem.TableItem;

public class TableItemNameValueShrinkView extends TableItemNameValueView {

	public TableItemNameValueShrinkView(Context context, TableItem tableItem) {
		super(context, tableItem);
		shrinkView = new ShrinkTextView(nameTxt);
	}

	protected int getItemLayoutID() {
		return R.layout.table_item_namevalue_text;

	}

}
