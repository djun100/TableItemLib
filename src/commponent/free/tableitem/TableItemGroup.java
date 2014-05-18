package commponent.free.tableitem;

import android.content.Context;
import android.view.ViewGroup;

import commponent.free.tableitem.view.TableItemGroupView;
import commponent.free.tableitem.view.TableItemView;

public class TableItemGroup extends TableItem {
	public String group;

	public TableItemGroup(String group) {
		this.group = group;
	}

	@Override
	public TableItemView newView(Context context, ViewGroup parent) {
		return new TableItemGroupView(context, this);
	}

}
