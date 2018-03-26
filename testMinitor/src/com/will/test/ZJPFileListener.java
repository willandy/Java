package com.will.test;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class ZJPFileListener implements FileAlterationListener{

	ZJPFileMonitor monitor =null;
	@Override
	public void onDirectoryChange(File directory) {
		// TODO Auto-generated method stub
		System.out.println("onDirectoryChange"+directory.getName());
	}

	@Override
	public void onDirectoryCreate(File directory) {
		// TODO Auto-generated method stub
		System.out.println("onDirectoryCreate"+directory.getName());
	}

	@Override
	public void onDirectoryDelete(File directory) {
		// TODO Auto-generated method stub
		System.out.println("onDirectoryDelete"+directory.getName());
	}

	@Override
	public void onFileChange(File file) {
		// TODO Auto-generated method stub
		System.out.println("onFileChang"+file.getName());
	}

	@Override
	public void onFileCreate(File file) {
		// TODO Auto-generated method stub
		System.out.println("onFileCreate"+file.getName());
	}

	@Override
	public void onFileDelete(File file) {
		// TODO Auto-generated method stub
		System.out.println("onFileDelete"+file.getName());
	}

	@Override
	public void onStart(FileAlterationObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop(FileAlterationObserver observer) {
		// TODO Auto-generated method stub
		
	}

	
	
}
