package shop;

public class ExceptionCloseApp extends Exception{
    public ExceptionCloseApp() {
    }
    public String getMessage() {
        return "Пользователь вышел из приложения";
    }
}
