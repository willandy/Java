package com.will.test;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class ZJPFileMonitor {
    //文件修改监听
	FileAlterationMonitor monitor = null;
	
	public ZJPFileMonitor(long interval){
		//类加载时，初始化文件监听的事件间隔
		monitor = new FileAlterationMonitor(interval);
	}
	
	public void monitor(String path,FileAlterationListener listener){
		//构造观察类主要提供要观察的文件或目录，当然还有详细信息的filter
		FileAlterationObserver observer = new FileAlterationObserver(new File(path));
		//监听增加观察类
		monitor.addObserver(observer);
		//观察类增加监听
		observer.addListener(listener);
	}
	
	public void stop() throws Exception{
		monitor.stop();
	}
	
	public void start() throws Exception{
		monitor.start();
	}
	
	public static void main(String[] args) throws Exception {
		//配置monitor,监听的间隔
		ZJPFileMonitor m = new ZJPFileMonitor(5000);
		//配置文件监听地址，然后对该地址的文件夹变动进行监听
		m.monitor("E:\\filepath", new ZJPFileListener());
		//监听开始
		m.start();
	}
	
}
