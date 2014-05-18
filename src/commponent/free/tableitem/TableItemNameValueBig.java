package commponent.free.tableitem;

import android.content.Context;
import android.view.ViewGroup;

import commponent.free.tableitem.view.TableItemNameValueBigView;
import commponent.free.tableitem.view.TableItemView;

public class TableItemNameValueBig extends TableItemNameValue {

	/**
	 * @param name
	 * @param value
	 */
	public TableItemNameValueBig(String name, CharSequence value) {
		super(name, value);
	}

	@Override
	public TableItemView newView(Context context, ViewGroup parent) {
		return new TableItemNameValueBigView(context,this);
	}

}
