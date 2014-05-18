package commponent.free.tableitem.view;

public abstract class ShrinkView {
	public int maxLength;

	public void setShink(int shrinkLengh) {
		maxLength = shrinkLengh;
		setShinkView(shrinkLengh);
	}

	public abstract void setShinkView(int shrinkLengh);

}
