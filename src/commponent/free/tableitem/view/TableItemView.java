package commponent.free.tableitem.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;

import com.example.tableitemlib.R;
import commponent.free.tableitem.OnTableItemClickResult;
import commponent.free.tableitem.TableItem;

public abstract class TableItemView {
	/**
	 * 标示当前TableItemView所在位置
	 */
	public int location;

	protected View itemView;
	protected Context context;
	protected TextView unreadTxt;
	OnTableItemClickResult clickResult;
	protected ShrinkView shrinkView;

	public TableItemView(Context context, TableItem tableItem) {
		this.context = context;
		itemView = initItemView(tableItem);
	}

	/**
	 * 设置位置标示 {@link TableItemView#location} <br>
	 * 为TableItem设置内容{@link TableItemView#setData(TableItem)}; <br>
	 * 为TableItem设置未读数 {@link TableItemView#setUnreadNum(TableItem)}; <br>
	 * 设置背景根据 {@link #getBackResID()}返回值做逻辑处理并给tableItem赋值
	 * 
	 * @param item
	 * @param location
	 */
	public void populateItemView(TableItem item, int location, int itemCount) {
		this.location = location;
		setData(item);
		if (isNeedSetUnreadNum()) {
			setUnreadNum(item);
		}
		setBackGroundCustom(item, location);
	}

	/**
	 * 1.首先判断tableItem中是否含有背景ID 2.根据 {@link #getBackResID()}
	 * 返回值做逻辑处理并给tableItem赋值
	 * 
	 * @param tableItem
	 * @param loation
	 */
	private void setBackGroundCustom(TableItem tableItem, int location) {
		if (tableItem.backResId == 0) {
			int bacResId = getBackResID();
			if (bacResId == -1) {
				tableItem.backResId = getBackResCustom(location);
			} else if (bacResId > 0) {
				tableItem.backResId = bacResId;
			} else {
				return;
			}
		}
		setBackGround(tableItem.backResId);

	}

	/**
	 * -1:自动化变颜色背景；0：不设置背景；大于0为需要设置的背景色<br>
	 * 需注意若{@link TableItem#backResId}中含有值以此值为准,
	 * 
	 * @return
	 */
	protected int getBackResID() {
		return 0;
	}

	/**
	 * 获取自动化变颜色背景
	 * 
	 * @param location
	 * @return
	 */
	private int getBackResCustom(int location) {
		int backId = 0;
		if ((location & 1) == 0) {
			backId = R.drawable.green_tableitem_center_tint_selector;
		} else {
			backId = R.drawable.green_tableitem_center_color_selector;
		}
		return backId;
	}

	/**
	 * 是否需要设置未读数目,默认false
	 * 
	 * @return
	 */
	protected boolean isNeedSetUnreadNum() {
		return false;
	}

	/**
	 * 注册一个回调函数，当点击时调用
	 * 
	 * @param listener
	 */
	public void setOnItemClickListener(OnTableItemClickResult listener) {
		this.clickResult = listener;
		setOnItemClickListener();
	}

	protected void setOnItemClickListener() {
		itemView.setOnClickListener(new TableItemClickListener());
	}

	/**
	 * 设置背景
	 * 
	 * 建议使用 {@link TableItemView#populateItemView(TableItem, int)}
	 * 
	 * @param resid
	 */
	public void setBackGround(int resid) {
		itemView.setBackgroundResource(resid);
	}

	/**
	 * 获取需要展示的ItemView
	 * 
	 * @return
	 */
	public View getItemView() {
		return itemView;
	}

	/**
	 * 设置未读数量
	 * 
	 * 建议使用 {@link TableItemView#populateItemView(TableItem, int)}
	 * 
	 * @param item
	 */
	public void setUnreadNum(TableItem item) {
		int unreadNum = item.getUnreadNum();
		if (unreadNum > 0) {
			if (unreadTxt != null) {
				unreadTxt.setVisibility(View.VISIBLE);
			} else {
				ViewStub stub = (ViewStub) itemView
						.findViewById(R.id.table_item_unread_num);
				if (stub == null) {
					throw new RuntimeException(
							this.getClass()
									+ "中必须含有table_item_unread_num的ViewStub,不然无法使用setUnreadNum的功能");
				}
				unreadTxt = (TextView) stub.inflate();
			}
			unreadTxt.setText(unreadNum + "");
		} else {
			if (unreadTxt != null) {
				unreadTxt.setVisibility(View.GONE);
			}
		}
	}

	public void setShrink(int shrinkLengh) {
		if (shrinkView != null) {
			shrinkView.setShink(shrinkLengh);
		}
	}

	public int getShrink() {
		if (shrinkView != null) {
			return shrinkView.maxLength;
		}
		return 0;
	}

	/**
	 * @return itemView
	 * @see #getItemView()
	 */
	protected abstract View initItemView(TableItem tableItem);

	/**
	 * 为TableItem设置内容;
	 * 
	 * 建议使用 {@link TableItemView#populateItemView(TableItem, int)}
	 * 
	 * @param item
	 *            继承TableItem的相应子类
	 */
	public abstract void setData(TableItem item);

	public class TableItemClickListener implements OnClickListener {
		public int columnLocation;

		public TableItemClickListener() {
			this(0);
		}

		public TableItemClickListener(int columnLocation) {
			this.columnLocation = columnLocation;
		}

		@Override
		public void onClick(View v) {
			clickResult.onItemClick(location, columnLocation);
		}

	}

}
