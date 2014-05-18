package commponent.free.tableitem;

import java.util.List;

import android.content.Context;
import android.view.ViewGroup;

import commponent.free.tableitem.view.TableItemGridTitleSmallView;
import commponent.free.tableitem.view.TableItemGridTitleView;
import commponent.free.tableitem.view.TableItemView;

public class TableItemGridTitleSmall extends TableItemGrid {

	public TableItemGridTitleSmall(List<? extends Object> dataList) {
		super(dataList);
		isAddInnerLine = false;
	}

	@Override
	public TableItemView newView(Context context, ViewGroup parent) {
		return new TableItemGridTitleSmallView(context, this);
	}
}
