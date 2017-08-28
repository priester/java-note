package jvm.stackOverflowError;

/**
 * VM Args: -Xss128k
 *
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak(){
		stackLength ++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackSOF omm = new JavaVMStackSOF();
		try {
		omm.stackLeak();
		}catch(Exception e) {
			System.out.println(omm.stackLength);
			System.out.println(e);
		}
	}
}
