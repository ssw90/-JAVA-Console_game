package method;

import java.io.IOException;

import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

public class Set_Position {
	
	int terminalWidth;
	int terminalHeight;

	public int getXposition() throws IOException {	
		terminalWidth = org.jline.terminal.TerminalBuilder.terminal().getWidth();
		return terminalWidth;
	}
	public int getYposition() throws IOException {
		terminalHeight = org.jline.terminal.TerminalBuilder.terminal().getHeight();
		return terminalHeight;
	}
	public void SetXYposition(int x, int y) throws IOException, InterruptedException {
		TerminalBuilder.terminal().puts(InfoCmp.Capability.cursor_address, y, x);
	}
	public void clear() {
		try {
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		} catch (InterruptedException  | IOException e) {
			e.printStackTrace();
		}
	}
	

}
