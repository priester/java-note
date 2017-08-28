package jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 *	VM args -Xmx20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError 
 *	内存映像分析工具（Eclipse Memory Analyzer） 
 */
public class HeapOOM {
	
	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	} 
}

