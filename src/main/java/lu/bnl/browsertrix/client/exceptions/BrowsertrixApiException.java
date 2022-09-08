package lu.bnl.browsertrix.client.exceptions;


public class BrowsertrixApiException extends Exception 
{ 
    public BrowsertrixApiException(String errorMessage) 
    {
        super(errorMessage);
    }
}
