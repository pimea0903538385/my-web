package shop.portal.Vo;

import lombok.Data;
import lombok.experimental.Accessors;
import shop.portal.service.ServiceException;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class R<T> implements Serializable {
    public  static  final  int OK=200 ;
    public  static  final  int CREATED=201;
    public  static  final  int ACCEPTED=202;
    public  static  final  int NO_CONTENT=204;
    public  static  final  int INVALID_REQUEST=400;
    public  static  final  int UNAUTHORIED=401;
    public  static  final  int FORBIDDEN=403;
    public  static  final  int NOT_FOUND=404;
    public  static  final  int GONE=410;
    public  static  final  int UNPROCESABLE_ENTITY=422;
    public  static  final  int INTERNAL_SERVER_ERROR=500;


    private int code;
    private  String message;
    private  T data;
    public static R ok(String message){
        return  new R().setCode(OK).setMessage(message);
    }
    public static R ok(Object data){
        return  new R().setCode(OK).setData(data);

    }
    public static  R created(String message){
        return  new R().setCode(CREATED).setMessage(message);
    }


    public static  R created(Object object){
        return  new R().setCode(CREATED).setMessage("創建成功!").setData(object);
    }
    public static  R accept(String message){
        return  new R().setCode(ACCEPTED).setMessage(message);
    }
    public static  R no_content(String message){
        return  new R().setCode(NO_CONTENT).setMessage(message);
    }
    public static  R invalidRequest(String message){
        return  new R().setCode(INVALID_REQUEST).setMessage(message);
    }
    public static  R unauthorized(String message){
        return  new R().setCode(UNAUTHORIED).setMessage(message);
    }

    public static  R forbidden(String message){
        return  new R().setCode(FORBIDDEN).setMessage("權限不足");
    }

    public static  R no_found(String message){
        return  new R().setCode(NOT_FOUND).setMessage(message);
    }

    public static  R gone(String message){
        return  new R().setCode(GONE).setMessage(message);
    }

    public static  R Unprocesable_Entity(String message){
        return  new R().setCode(UNPROCESABLE_ENTITY).setMessage(message);
    }
    public static  R Failed(Throwable e){
        return  new R().setCode(INTERNAL_SERVER_ERROR).setMessage(e.getMessage());
    }
    public static  R Failed(ServiceException serviceException){
        return new R().setCode(serviceException.getcode()).setMessage(serviceException.getMessage());
    }
}
