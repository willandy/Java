package ExceptionSelf;

public class ExceptionSelfTestTwo extends Exception{

	public ExceptionSelfTestTwo(){ super(); }
	
	public ExceptionSelfTestTwo(String message){
		super(message);
	}
	
	public ExceptionSelfTestTwo(String message,Throwable cause){
		super(message,cause);
	}
	
	public ExceptionSelfTestTwo(Throwable cause){
		super(cause);
	}
	
	public static void main(String[] args) throws ExceptionSelfTestTwo{
		try{
			throw new Exception("我的异常信息");
		}catch(Exception e){
			throw new ExceptionSelfTestTwo("新的异常信息",e);
		}
	}
	
}
