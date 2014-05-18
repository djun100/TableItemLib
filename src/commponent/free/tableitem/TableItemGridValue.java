package commponent.free.tableitem;

import java.util.List;

import android.content.Context;
import android.view.ViewGroup;

import commponent.free.tableitem.view.TableItemGridTitleView;
import commponent.free.tableitem.view.TableItemGridValueView;
import commponent.free.tableitem.view.TableItemView;

public class TableItemGridValue extends TableItemGrid {

	public TableItemGridValue(List<? extends Object> dataList) {
		super(dataList);
	}

	@Override
	public TableItemView newView(Context context, ViewGroup parent) {
		return new TableItemGridValueView(context, this);
	}
}
