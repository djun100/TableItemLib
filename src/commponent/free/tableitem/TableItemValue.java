package commponent.free.tableitem;

import android.content.Context;
import android.view.ViewGroup;

import commponent.free.tableitem.view.TableItemValueView;
import commponent.free.tableitem.view.TableItemView;

public class TableItemValue extends TableItem {
	public CharSequence value;

	public TableItemValue(CharSequence value) {
		this.value = value;
	}

	@Override
	public TableItemView newView(Context context, ViewGroup parent) {
		return new TableItemValueView(context,this);
	}

}
