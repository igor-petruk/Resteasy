package org.jboss.resteasy.client.exception;

/**
 * @author <a href="ron.sigal@jboss.com">Ron Sigal</a>
 * @version $Revision: 1.1 $
 *
 * Copyright Jul 28, 2012
 */
public class ResteasyUnsupportedHttpVersionException extends ResteasyProtocolException
{
	private static final long serialVersionUID = -5711578608757689465L;
	
	public ResteasyUnsupportedHttpVersionException()
	{
	}

	public ResteasyUnsupportedHttpVersionException(String message)
	{
		super(message);
    }
	
    public ResteasyUnsupportedHttpVersionException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public ResteasyUnsupportedHttpVersionException(Throwable cause)
    {
        super(cause);
    }
}
