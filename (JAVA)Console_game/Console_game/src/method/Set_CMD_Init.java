package method;
 
import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import com.sun.jna.Function;
import com.sun.jna.platform.win32.WinDef.BOOL;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.DWORDByReference;
import com.sun.jna.platform.win32.WinNT.HANDLE;

import db.PlayersDAO;

public class Set_CMD_Init {
	
	public void run() throws InterruptedException, AWTException {
		setCMD();
		Robot robot = new Robot();
		PlayersDAO dao = new PlayersDAO();
		System.out.println("Initializing...");
		Thread.sleep(3000);
		robot.keyPress(122);
		dao.checkTable();
		Thread.sleep(2000);
		clear();
		
	}
	
	public void clear() {
		try {
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setCMD() {
		if(System.getProperty("os.name").startsWith("Windows"))
		{
		    // Set output mode to handle virtual terminal sequences
		    Function GetStdHandleFunc = Function.getFunction("kernel32", "GetStdHandle");
		    DWORD STD_OUTPUT_HANDLE = new DWORD(-11);
		    HANDLE hOut = (HANDLE)GetStdHandleFunc.invoke(HANDLE.class, new Object[]{STD_OUTPUT_HANDLE});

		    DWORDByReference p_dwMode = new DWORDByReference(new DWORD(0));
		    Function GetConsoleModeFunc = Function.getFunction("kernel32", "GetConsoleMode");
		    GetConsoleModeFunc.invoke(BOOL.class, new Object[]{hOut, p_dwMode});

		    int ENABLE_VIRTUAL_TERMINAL_PROCESSING = 4;
		    DWORD dwMode = p_dwMode.getValue();
		    dwMode.setValue(dwMode.intValue() | ENABLE_VIRTUAL_TERMINAL_PROCESSING);
		    Function SetConsoleModeFunc = Function.getFunction("kernel32", "SetConsoleMode");
		    SetConsoleModeFunc.invoke(BOOL.class, new Object[]{hOut, dwMode});
		}
	}
	
}
