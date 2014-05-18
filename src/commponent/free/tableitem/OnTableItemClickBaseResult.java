package commponent.free.tableitem;

public abstract class OnTableItemClickBaseResult implements OnTableItemClickResult {
	TableItemAdapter adapter;

	public OnTableItemClickBaseResult(TableItemAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public void onItemClick(int position, int columnLocation) {
		TableItem tableItem = adapter.getTableItem(position);
		TableItemModelSuper tableItemModelSuper = null;
		if (tableItem != null) {
			tableItemModelSuper = tableItem.tableItemModel;
		}
		onItemClick(position, columnLocation, tableItem, tableItemModelSuper);
	}

	public abstract void onItemClick(int position, int columnLocation,
			TableItem tableItem, TableItemModelSuper tableItemModelSuper);

}
