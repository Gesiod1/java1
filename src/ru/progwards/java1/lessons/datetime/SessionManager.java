package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SessionManager {
    private List<UserSession> sessions = new ArrayList<>();
    private int sessionValid;

    //создает экземпляр SessionManager и сохраняет sessionValid - период валидности сессии в секундах
    public SessionManager(int sessionValid){
        this.sessionValid = sessionValid;
    }

    //добавляет новую сессию пользователя
    public void add(UserSession userSession){
        sessions.add(userSession);
    }
    //проверяет наличие существующей сессии по userName. Если срок валидности истек,
    // или такой  сессии нет, возвращает null. В противном случае возвращает сессию, обновив ее дату доступа
    public UserSession find(String userName){
        UserSession userSession = null;
        for (int i = 0; i < sessions.size(); i++ ) {
            if (sessions.get(i).getUserName().equals(userName)){
                userSession = sessions.get(i);
                break;
            }
        }
        if (userSession != null && (LocalDateTime.now().getSecond() - sessionValid) < userSession.getSessionHandle()){
            userSession.updateLastAccess();
            return userSession;
        }
        return null;
    }
    //проверяет наличие существующей сессии по хендлу. Если срок валидности истек,
    // или такой  сессии нет, возвращает null. В противном случае возвращает сессию, обновив ее дату доступа.
    public UserSession get(int sessionHandle){
        UserSession userSession = null;
        for (int i = 0; i < sessions.size(); i++ ) {
            if (sessions.get(i).getSessionHandle() == sessionHandle){
                userSession = sessions.get(i);
                break;
            }
        }
        if (userSession != null && (LocalDateTime.now().getSecond() - sessionValid) < userSession.getSessionHandle()){
            userSession.updateLastAccess();
            return userSession;
        }
        return null;
    }
    //удаляет указанную сессию пользователя
    public void delete(int sessionHandle){
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).getSessionHandle() == sessionHandle){
                sessions.remove(i);
            }
        }
    }
    //удаляет все сессии с истекшим сроком годности
    public void deleteExpired(){
        for (int i = 0; i < sessions.size(); i++) {
            if ((LocalDateTime.now().getSecond() - sessionValid) < sessions.get(i).getSessionHandle()){
                sessions.remove(i--);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UserSession userSession = new UserSession("Вадик");
        SessionManager sessionManager = new SessionManager(1000);
        sessionManager.find("Вадик");
        sessionManager.add(userSession);
        userSession.getSessionHandle();
        System.out.println(sessionManager.get( userSession.getSessionHandle()));
        System.out.println(sessionManager.get( userSession.getSessionHandle()));
        System.out.println(sessionManager.get( userSession.getSessionHandle()));
        Thread.sleep(2000);
        System.out.println(sessionManager.get( userSession.getSessionHandle()));
        UserSession userSession1 = new UserSession("Петя");
        Thread.sleep(500);
        sessionManager.deleteExpired();
        for (int i = 0; i < sessionManager.sessions.size(); i++) {
            System.out.println(sessionManager.sessions.get(i));
        }
        sessionManager.delete(userSession1.getSessionHandle());
        for (int i = 0; i < sessionManager.sessions.size(); i++) {
            System.out.println(sessionManager.sessions.get(i));
        }

    }
}

class UserSession{
    private int sessionHandle;
    private String userName;
    private LocalDateTime lastAccess;

    public int getSessionHandle() {
        return sessionHandle;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    //обновляет время доступа к сессии
    void updateLastAccess(){
        lastAccess = LocalDateTime.now();
    }

    //сессия пользователя. Внутри автоматически сгенерировать sessionHanle,
    // для примера использовать просто случайное число через класс Random, а так же установить текущее время доступа.
    public UserSession(String userName){
        this.userName = userName;
        this.sessionHandle = (int) (Math.random() * 100000);
        updateLastAccess();
    }


}
