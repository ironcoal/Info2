
public class ControllerWindow implements AdjustmentListener extends Frame {

	public ControllerWindow() {
		new ColorWindow(this, Color.BLACK, false).setPosition(200,200);
		new ColorWindow(this, Color.BLACK, true).setPosition(300,200);
		new StringWindow(this, Color.BLACK, false).setPosition(200,400);
		new StringWindow(this, Color.BLACK, true).setPosition(300,400);
		Frame f = new Frame;
	}
	public adjustmentValueChanged(AdjustmentEvent e) {

	}
}