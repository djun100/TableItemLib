package commponent.free.tableitem;

/**
 * @see OnTableItemClickBaseResult 里面有基本实现
 * @author Administrator
 * 
 */
public interface OnTableItemClickResult {

	/**
	 * 可以利用{@link TableItemAdapter#getTableItem(int)}获取TableItem <br>
	 * <br>
	 * 根据TableItem可以获取{@link TableItem#tableItemModel}
	 * 
	 * @see OnTableItemClickBaseResult 里面有基本实现
	 * 
	 * @param position
	 *            所处行的位置
	 * @param columnLocation
	 *            所处列的位置
	 */
	void onItemClick(int position, int columnLocation);

}
