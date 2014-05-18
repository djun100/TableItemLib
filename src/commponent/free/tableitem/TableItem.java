package commponent.free.tableitem;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;

import commponent.free.tableitem.view.TableItemView;

public abstract class TableItem {
	private SparseArray<Object> mTags;
	private Object mTag;
	private int unreadNum;
	public TableItemModelSuper tableItemModel;
	

	/**
	 * 设置此Item是否可以被点击，默认：true
	 */
	public boolean clickable = true;

	/**
	 * 背景资源ID 建议不要设置此项，{@link TableItemView}会根据主题位置等设定不同背景
	 */
	public int backResId;

	public TableItem() {
		this(null);
	}

	public TableItem(TableItemModelSuper tableItemModel) {
		this.tableItemModel = tableItemModel;
		// By default, an item is enabled
		clickable = true;
	}

	public int getShrinkTxtColumnLength() {
		return 0;
	}

	/**
	 * Return a view that is associated to the current item. The returned view
	 * is normally capable of being a good recipient for all item's information.
	 * 
	 * @param context
	 *            The Context in which the {@link TableItemView} will be used
	 * @param parent
	 *            The parent View of that new View. The parent is usually the
	 *            parent ListView and may be used to retrieve the correct
	 *            LayoutParams type.
	 * @return A new allocated view for the current Item
	 */
	public abstract TableItemView newView(Context context, ViewGroup parent);
	
	public void setUnreadNum(int num) {
		unreadNum = num;
	}
	
	//利用headfirst中策略模式实现获取未读数，因为未读数应该有好几种获取方式，初始方式获取0（最好模仿例子在初始化时就new一个实现）
	public int getUnreadNum() {
		return unreadNum;
	}

	/**
	 * @return 设置的tag或者null
	 */
	public Object getTag() {
		return mTag;
	}

	public void setTag(Object tag) {
		mTag = tag;
	}

	/**
	 * @param key
	 *            查找的key
	 * @return 和key关联的tag；如果没有返回null
	 */
	public Object getTag(int key) {
		return (mTags == null) ? null : mTags.get(key);
	}

	/**
	 * 设置一个特殊的tag
	 * 
	 * @param key
	 *            key
	 * @param tag
	 * 
	 */
	public void setTag(int key, Object tag) {
		if (mTags == null) {
			mTags = new SparseArray<Object>();
		}
		mTags.put(key, tag);
	}
}
