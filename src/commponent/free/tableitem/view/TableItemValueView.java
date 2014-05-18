package commponent.free.tableitem.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.tableitemlib.R;
import commponent.free.tableitem.TableItem;
import commponent.free.tableitem.TableItemValue;

public class TableItemValueView extends TableItemView {
	private TextView valueTxt;

	public TableItemValueView(Context context, TableItem tableItem) {
		super(context, tableItem);
	}

	@Override
	protected View initItemView(TableItem tableItem) {
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		itemView = layoutInflater.inflate(R.layout.table_item_value_text, null);
		valueTxt = (TextView) itemView.findViewById(R.id.table_value_txt);
		return itemView;
	}

	@Override
	protected int getBackResID() {
		return -1;
	}

	@Override
	public void setData(TableItem item) {
		TableItemValue itemTitle = (TableItemValue) item;
		valueTxt.setText(itemTitle.value);
	}
}
