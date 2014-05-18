package commponent.free.tableitem.view.adapter;

import android.view.View;
import android.widget.TextView;

public class TextViewAdapter extends ViewAdapter {
	private TextView textView;

	public TextViewAdapter(TextView view) {
		textView = view;
	}

	@Override
	public View getView() {
		return textView;
	}

	@Override
	public void setValue(Object valueData) {
		if (textView != null) {
			textView.setText((CharSequence) valueData);
		}
	}

	@Override
	public void setDefaultValue() {
	}

}
