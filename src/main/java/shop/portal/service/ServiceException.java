package shop.portal.service;

import shop.portal.Vo.R;

public class ServiceException extends  RuntimeException{
private  int code= R.INTERNAL_SERVER_ERROR;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServiceException(int code) {
        this.code = code;
    }

    public ServiceException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public ServiceException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
    public  static  ServiceException Notfound(String message){
        return  new ServiceException(message, R.NOT_FOUND);

    }
    public  static  ServiceException GONE(String message){
        return  new ServiceException(message, R.GONE);

    } public  static  ServiceException UnprocesableEntity(String message){
        return  new ServiceException(message, R.UNPROCESABLE_ENTITY);

    }

    public static ServiceException BUSY() {
        return  new ServiceException("數據庫繁忙!",R.INTERNAL_SERVER_ERROR);
    }

    public int getcode() {
        return code;
    }
}
