package commponent.free.tableitem.view;

import android.widget.TextView;

public class ShrinkTextView extends ShrinkView {
	public TextView textView;

	public ShrinkTextView(TextView textView) {
		this.textView = textView;
	}

	@Override
	public void setShinkView(int shrinkLengh) {
		textView.setMaxEms(shrinkLengh + 1);
		textView.setMinEms(shrinkLengh + 1);
	}

}
