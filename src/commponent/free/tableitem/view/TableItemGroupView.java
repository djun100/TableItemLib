package commponent.free.tableitem.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.tableitemlib.R;
import commponent.free.tableitem.TableItem;
import commponent.free.tableitem.TableItemGroup;

public class TableItemGroupView extends TableItemView {
	private TextView groupTxt;

	public TableItemGroupView(Context context,TableItem tableItem) {
		super(context,tableItem);
	}

	@Override
	protected View initItemView(TableItem tableItem) {
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		itemView = layoutInflater.inflate(R.layout.table_item_group_text, null);
		groupTxt = (TextView) itemView.findViewById(R.id.table_group_txt);
		return itemView;
	}

	@Override
	public void setData(TableItem item) {
		TableItemGroup itemTitle = (TableItemGroup) item;
		groupTxt.setText(itemTitle.group);
	}

}
