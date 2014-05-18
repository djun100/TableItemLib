package commponent.free.tableitem.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.example.tableitemlib.R;
import commponent.free.tableitem.TableItem;
import commponent.free.tableitem.TableItemGrid;
import commponent.free.tableitem.view.adapter.ViewAdapter;

/**
 * 
 * 普通文本展示的视图
 * 
 * @author Free
 * 
 */
public abstract class TableItemGridView extends TableItemView {
	protected List<ViewAdapter> viewAdapterList;

	public TableItemGridView(Context context, TableItem tableItem) {
		super(context, tableItem);
	}

	@Override
	protected View initItemView(TableItem tableItem) {
		viewAdapterList = new ArrayList<ViewAdapter>();
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		itemView = (View) layoutInflater.inflate(
				R.layout.table_item_grid_layout, null);
		LinearLayout layout = (LinearLayout) itemView
				.findViewById(R.id.table_grid_layout);

		ViewAdapter valueView = null;
		TableItemGrid itemGrid = (TableItemGrid) tableItem;
		int size = itemGrid.getRowSize();
		for (int i = 0; i < size; i++) {
			int weight = 1;

			valueView = addValueView(layoutInflater, layout, i, weight);
			viewAdapterList.add(valueView);
			if (i != size - 1 ) {
				if (itemGrid.isAddInnerLine) {
					addLineView(layoutInflater, layout);
				}
			}
		}
		return itemView;
	}

	@Override
	public void setData(TableItem item) {
		TableItemGrid itemGrid = (TableItemGrid) item;
		for (int i = 0; i < viewAdapterList.size(); i++) {
			Object data = itemGrid.dataList.get(i);
			if (data == null) {
				continue;
			}
			viewAdapterList.get(i).setValue(data);
		}

	}


	@Override
	protected boolean isNeedSetUnreadNum() {
		return true;
	}

	public ViewAdapter addValueView(LayoutInflater layoutInflater,
			LinearLayout layout, int location, int weight) {
		ViewAdapter viewAdapter = getItemView(layoutInflater, location);
		View view = viewAdapter.getView();
		layout.addView(view);
		LayoutParams params = ((LayoutParams) view.getLayoutParams());
		params.weight = weight;
		params.width = 0;
		return viewAdapter;

	}

	protected abstract ViewAdapter getItemView(LayoutInflater layoutInflater,
			int location);

	public void addLineView(LayoutInflater layoutInflater, LinearLayout layout) {
		View lineView = layoutInflater.inflate(R.layout.table_item_grid_line,
				null);
		layout.addView(lineView);
		((LayoutParams) lineView.getLayoutParams()).height = LayoutParams.MATCH_PARENT;
		((LayoutParams) lineView.getLayoutParams()).width = layoutInflater
				.getContext().getResources()
				.getDimensionPixelSize(R.dimen.table_grid_line_dimen_ver);
	}

}
