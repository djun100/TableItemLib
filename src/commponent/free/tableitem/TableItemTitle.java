package commponent.free.tableitem;

import android.content.Context;
import android.view.ViewGroup;

import commponent.free.tableitem.view.TableItemTitleView;
import commponent.free.tableitem.view.TableItemView;

public class TableItemTitle extends TableItem {
	public String title;

	public TableItemTitle(String title) {
		this.title = title;
		// clickable = false;
	}

	@Override
	public TableItemView newView(Context context, ViewGroup parent) {
		return new TableItemTitleView(context,this);
	}

	
	
}
