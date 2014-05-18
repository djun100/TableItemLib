package commponent.free.tableitem;

public abstract class TableItemNameValue extends TableItem {

	public String name;
	public CharSequence value;

	/**
	 * @param name
	 * @param value
	 */
	public TableItemNameValue(String name, CharSequence value) {
		this.name = name;
		this.value = value;
	}

}
