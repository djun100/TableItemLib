package commponent.free.tableitem.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.tableitemlib.R;
import commponent.free.tableitem.TableItem;
import commponent.free.tableitem.TableItemTitle;

public class TableItemTitleView extends TableItemView {
	private TextView titleTxt;

	public TableItemTitleView(Context context, TableItem tableItem) {
		super(context, tableItem);
	}

	@Override
	protected View initItemView(TableItem tableItem) {
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		itemView = layoutInflater.inflate(R.layout.table_item_title_text, null);
		titleTxt = (TextView) itemView.findViewById(R.id.table_title_left);
		return itemView;
	}

	@Override
	protected boolean isNeedSetUnreadNum() {
		return true;
	}

	@Override
	public void setData(TableItem item) {
		TableItemTitle itemTitle = (TableItemTitle) item;
		titleTxt.setText(itemTitle.title);
	}

}
