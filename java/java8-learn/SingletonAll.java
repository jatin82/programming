package com.Interview;

import java.io.Serializable;

public class SingletonAll implements Serializable {
	private static final long serialVersionUID = 3119105548371608200L;
	private static SingletonAll singleton = null;

	private SingletonAll() {
		if( SingletonAll.singleton != null ) {
	        throw new InstantiationError( "Creating of this object is not allowed." );
	    }
	}

	public static SingletonAll getInstance() {
		if(singleton==null){
			synchronized(SingletonAll.class){
				if(singleton==null){
					singleton = new SingletonAll();
				}
			}
		}
		return singleton;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cloning of this class is not allowed");
	}

	protected Object readResolve() {
		return singleton;
	}
	
}
