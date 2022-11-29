package lu.bnl.browsertrix.client.exceptions;


public class HttpRequestFailedException extends Exception 
{ 
    public HttpRequestFailedException(String errorMessage) 
    {
        super(errorMessage);
    }
}
