package commponent.free.tableitem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import commponent.free.tableitem.view.TableItemView;

public class TableItemAdapter extends BaseAdapter {
	protected HashMap<Class<? extends TableItem>, TypeInfo> mTypes;
	protected Context context;
	private List<TableItem> dataList = new ArrayList<TableItem>();
	protected OnTableItemClickResult onClickListener;
	protected int mMaxViewTypeCount;

	protected int shrinkLengthMax = 6;
	protected int shrinkTxtLength = 0;

	public TableItemAdapter(Context context) {
		this.context = context;
	}

	public void setDataList(List<TableItem> dataList) {
		setData(dataList);
	}

	public void setDataTableItemModelList(
			List<? extends TableItemModelSuper> itemModelList) {
		setData(handleItemModel(itemModelList));
	}

	public void setDataTableItemModel(TableItemModelSuper... itemModels) {
		setDataTableItemModelList(Arrays.asList(itemModels));
	}

	public void addDataItem(List<TableItem> list) {
		addData(list.toArray(new TableItem[list.size()]));
	}

	public void addDataItem(TableItem... item) {
		addData(item);
	}

	public void addDataItemModel(List<? extends TableItemModelSuper> list) {
		addDataItem(handleItemModel(list));
	}

	public void addDataItemModel(TableItemModelSuper... item) {
		addDataItemModel(Arrays.asList(item));
	}

	private List<TableItem> handleItemModel(
			List<? extends TableItemModelSuper> list) {
		List<TableItem> itemList = new ArrayList<TableItem>();
		List<TableItem> templist;
		for (TableItemModelSuper tableItemModelSuper : list) {
			templist = tableItemModelSuper
					.getTableItemList((Application) context
							.getApplicationContext());
			for (TableItem tableItem : templist) {
				tableItem.tableItemModel = tableItemModelSuper;
			}
			itemList.addAll(templist);
		}
		return itemList;
	}

	private void setData(List<TableItem> dataList) {
		this.dataList = dataList;
		initParams(true);
	}

	private void addData(TableItem... item) {
		dataList.addAll(Arrays.asList(item));
		initParams(false);
		addItemType(item);
	}

	/**
	 * @param isReInit
	 *            是否重新初始化
	 */
	private void initParams(boolean isReInit) {
		if (isReInit || mTypes == null) {
			initItemType();
		}
		if (isReInit || shrinkTxtLength == 0) {
			initShrinkParams();
		}
	}

	private void initShrinkParams() {
		shrinkTxtLength = 0;
		for (TableItem item : dataList) {
			int columnLen = item.getShrinkTxtColumnLength();
			if (shrinkLengthMax > columnLen) {
				shrinkTxtLength = Math.max(columnLen, shrinkTxtLength);
			} else {
				shrinkTxtLength = shrinkLengthMax;
			}
		}
	}

	public TableItem getTableItem(int positon) {
		return dataList.get(positon);
	}

	public void clearData() {
		dataList.clear();
		// if (mTypes != null) {
		// mTypes.clear();
		// }
		// mMaxViewTypeCount = 0;
	}

	public List<TableItem> getDataList() {
		return dataList;
	}

	public void setOnItemClickListener(OnTableItemClickResult onClickListener) {
		this.onClickListener = onClickListener;
	}

	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		try {
			if (convertView == null) {
				convertView = getViewByLocation(position);
			}
			populate(convertView, position);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return convertView;
	}

	protected void populate(View view, int location) {
		TableItemView tableItemView = (TableItemView) view.getTag();
		// 为视图设置标记，以便前边做对应条目的操作
		tableItemView.populateItemView(dataList.get(location), location,
				getCount());
		// setUnreadNum(tableItemView, view, position);
		setShrink(tableItemView);
	}

	// protected void setUnreadNum(TableItemView tableItemView, View view,
	// int position) {
	// TableItemModel itemModel = dataList.get(position);
	// Object dataObj = itemModel.tableObj;
	// if (dataObj != null && dataObj instanceof ChoiceModelInterface) {
	// tableItemView.setUnreadNum(((CommonApplication) context
	// .getApplicationContext())
	// .getUnreadCountById(((ChoiceModelInterface) dataObj)
	// .getId()));
	// }
	//
	// }

	protected void setOnTableItemListener(TableItemView tableItemView) {
		tableItemView.setOnItemClickListener(onClickListener);
	}

	protected View getViewByLocation(int position) {
		TableItemView tableItemView = dataList.get(position).newView(context,
				null);
		View itemView = tableItemView.getItemView();
		itemView.setTag(tableItemView);

		if (onClickListener != null) {
			setOnTableItemListener(tableItemView);
		}
		return itemView;
	}

	protected void setShrink(TableItemView tableItemView) {
		if (shrinkTxtLength != tableItemView.getShrink()) {
			tableItemView.setShrink(shrinkTxtLength);
		}
	}

	@Override
	public boolean isEnabled(int position) {
		return dataList.get(position).clickable;
	}

	@Override
	public int getViewTypeCount() {
		return Math.max(mMaxViewTypeCount, 100);
	}

	@Override
	public int getItemViewType(int position) {
		return mTypes.get(getItem(position).getClass()).type;
	}

	private void initItemType() {
		mTypes = new HashMap<Class<? extends TableItem>, TypeInfo>();
		for (TableItem item : dataList) {
			addItemType(item);
		}
	}

	private void addItemType(TableItem... items) {
		for (TableItem item : items) {
			final Class<? extends TableItem> klass = item.getClass();
			TypeInfo info = mTypes.get(klass);
			if (info == null) {
				final int type = mTypes.size();
				final TypeInfo newInfo = new TypeInfo();
				newInfo.count = 1;
				newInfo.type = type;
				mTypes.put(klass, newInfo);
			} else {
				info.count++;
			}
		}
		mMaxViewTypeCount = mTypes.size();
	}

	private static class TypeInfo {
		int count;
		int type;
	}

}
