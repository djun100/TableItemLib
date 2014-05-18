package commponent.free.tableitem;

import java.util.List;

import android.app.Application;

/**
 * 实现此接口在listview中进行多行展示
 * 
 * <br>
 * 设置方法：{@link TableItemAdapter#setDataTableItemModelList(List)}
 * 
 * @author Administrator
 * 
 */
public interface TableItemModelSuper {

	public List<TableItem> getTableItemList(Application application);

}
