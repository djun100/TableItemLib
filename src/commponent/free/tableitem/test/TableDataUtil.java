package commponent.free.tableitem.test;

import java.util.ArrayList;
import java.util.List;

import commponent.free.tableitem.TableItem;
import commponent.free.tableitem.TableItemGridTitle;
import commponent.free.tableitem.TableItemGridTitleSmall;
import commponent.free.tableitem.TableItemGridValue;
import commponent.free.tableitem.TableItemGroup;
import commponent.free.tableitem.TableItemNameValueBig;
import commponent.free.tableitem.TableItemNameValueShrink;
import commponent.free.tableitem.TableItemTitle;

public class TableDataUtil {

	public static List<TableItem> getTableDataList(String flag) {
		List<TableItem> list = new ArrayList<TableItem>();

		for (int i = 0; i < 2; i++) {
			// 创建标题视图Item
			TableItemTitle title = new TableItemTitle("标题" + i + "===" + i);
			// 为标题设置未读数
			title.setUnreadNum(3);
			list.add(title);

			for (int j = 0; j < 3; j++) {
				// 创建组视图Item
				list.add(new TableItemGroup("组(标题" + i + ")" + j + "===" + j));
				for (int j2 = 0; j2 < j; j2++) {
					// 创建Name-value视图Item
					list.add(new TableItemNameValueShrink(getStr("名字", j * 2),
							getStr("值", j + 2) + "我来自" + flag + +i + "===" + j
									+ "===" + j2));
					// 创建Big Name-value视图Item
					list.add(new TableItemNameValueBig(getStr("大名字", j + 2),
							getStr("大值", j + 2) + "我来自" + flag + i + "===" + j
									+ "===" + j2));
				}
			}

		}

		return list;
	}

	private static String getStr(String baseStr, int size) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(baseStr);
		}
		return sb.toString();
	}

	public static List<TableItem> getGridDataList(String flag) {
		List<TableItem> list = new ArrayList<TableItem>();
		List<String> datalist = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			datalist.add(getStr(i + "", 3));
		}
		list.add(new TableItemGridTitle(datalist));
		TableItemGridValue valueItem;
		for (int i = 0; i < 3; i++) {
			valueItem = new TableItemGridValue(datalist);
			valueItem.setUnreadNum(i * 2);
			list.add(valueItem);
		}
		list.add(new TableItemGridTitleSmall(datalist));
		for (int i = 0; i < 3; i++) {
			valueItem = new TableItemGridValue(datalist);
			valueItem.setUnreadNum(i * 2);
			list.add(valueItem);
		}
		return list;
	}
}
