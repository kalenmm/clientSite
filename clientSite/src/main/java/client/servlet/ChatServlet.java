package client.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet(name = "ChatServlet")
public class ChatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        Connection connection = Connection.Build();
        connection.sendMessage(text);
        response.sendRedirect(request.getContextPath()+"/chat.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = Connection.Build();
        Storage storage = Storage.Build();
        MessageListener messageListener = new MessageListener(connection.getSocket(),storage,connection.getUsername());
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(messageListener);
        response.sendRedirect(request.getContextPath()+"/chat.jsp");
    }
}
