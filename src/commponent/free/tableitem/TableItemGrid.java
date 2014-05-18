package commponent.free.tableitem;

import java.util.List;

import android.content.Context;
import android.view.ViewGroup;

import commponent.free.tableitem.view.TableItemValueView;
import commponent.free.tableitem.view.TableItemView;

public abstract class TableItemGrid extends TableItem {
	public List<? extends Object> dataList;
	public boolean isListenGridItemClick = false;
	public boolean isAddInnerLine = true;

	public TableItemGrid(List<? extends Object> dataList) {
		this.dataList = dataList;
	}

	public int getRowSize() {
		return dataList.size();
	}
}
