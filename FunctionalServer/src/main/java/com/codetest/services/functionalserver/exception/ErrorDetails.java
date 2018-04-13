/**
 * 
 */
package com.codetest.services.functionalserver.exception;

import java.io.Serializable;

/**
 * @author jagdish
 *
 */
public class ErrorDetails implements Serializable{

	/**
	 * This class it is used as return type when a validation error is found
	 */
	private static final long serialVersionUID = 1L;
		private long timestamp;
	    private int status;
	    private String message;

	    //needed for serialization
	    private ErrorDetails()
	    {
	    }

	    public ErrorDetails(long timestamp, int status, String message)
	    {
	        this.timestamp = timestamp;
	        this.status = status;
	        this.message = message;
	    }

	    public long getTimestamp()
	    {
	        return timestamp;
	    }

	    public int getStatus()
	    {
	        return status;
	    }

	    public String getMessage()
	    {
	        return message;
	    }

	    public static class ErrorDetailsBuilder
	    {
	        private long timestamp;
	        private int status;
	        private String message;

	        public ErrorDetailsBuilder timestamp(long timestamp)
	        {
	            this.timestamp = timestamp;
	            return this;
	        }

	        public ErrorDetailsBuilder status(int status)
	        {
	            this.status = status;
	            return this;
	        }

	        public ErrorDetailsBuilder message(String message)
	        {
	            this.message = message;
	            return this;
	        }

	        public ErrorDetails build()
	        {
	            return new ErrorDetails(timestamp, status, message);
	        }
	    }
	}

