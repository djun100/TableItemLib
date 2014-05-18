package commponent.free.tableitem.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.tableitemlib.R;
import commponent.free.tableitem.TableItem;
import commponent.free.tableitem.TableItemNameValue;

public abstract class TableItemNameValueView extends TableItemView {
	protected TextView nameTxt;
	protected TextView valueTxt;

	public TableItemNameValueView(Context context, TableItem tableItem) {
		super(context, tableItem);
	}

	@Override
	protected View initItemView(TableItem tableItem) {
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		int itemLayId;
		itemLayId = getItemLayoutID();
		itemView = layoutInflater.inflate(itemLayId, null);
		nameTxt = (TextView) itemView.findViewById(R.id.table_name_txt);
		valueTxt = (TextView) itemView.findViewById(R.id.table_value_txt);
		return itemView;
	}

	protected abstract int getItemLayoutID();

	@Override
	protected int getBackResID() {
		return -1;
	}

	@Override
	public void setData(TableItem item) {
		TableItemNameValue tableitem = (TableItemNameValue) item;
		nameTxt.setText(tableitem.name);
		valueTxt.setText(tableitem.value);
	}

}
