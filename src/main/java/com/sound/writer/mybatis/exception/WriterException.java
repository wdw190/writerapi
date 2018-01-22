package com.sound.writer.mybatis.exception;

public class WriterException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5290701529187940799L;

	public WriterException(String message) {
        super(message);
    }

    public WriterException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
