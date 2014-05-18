package commponent.free.tableitem.view.adapter;

import android.view.View;

public abstract class ViewAdapter {

	public abstract View getView();

	public abstract void setValue(Object valueData);

	// 并不是每个都View都需要此方法
	public abstract void setDefaultValue();

}
