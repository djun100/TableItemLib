package commponent.free.tableitem;

import android.content.Context;
import android.view.ViewGroup;

import commponent.free.tableitem.view.TableItemNameValueShrinkView;
import commponent.free.tableitem.view.TableItemView;

public class TableItemNameValueShrink extends TableItemNameValue {
	/**
	 * @param name
	 * @param value
	 */
	public TableItemNameValueShrink(String name, CharSequence value) {
		super(name, value);
	}

	@Override
	public int getShrinkTxtColumnLength() {
		return name == null ? 0 : name.length();
	}

	@Override
	public TableItemView newView(Context context, ViewGroup parent) {
		return new TableItemNameValueShrinkView(context,this);
	}

}
