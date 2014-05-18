package commponent.free.tableitem;

import java.util.List;

import android.content.Context;
import android.view.ViewGroup;

import commponent.free.tableitem.view.TableItemGridTitleView;
import commponent.free.tableitem.view.TableItemView;

public class TableItemGridTitle extends TableItemGrid {

	public TableItemGridTitle(List<? extends Object> dataList) {
		super(dataList);
		isAddInnerLine = false;
	}

	@Override
	public TableItemView newView(Context context, ViewGroup parent) {
		return new TableItemGridTitleView(context, this);
	}
}
