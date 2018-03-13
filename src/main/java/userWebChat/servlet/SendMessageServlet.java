package userWebChat.servlet;


import userWebChat.manager.MessageManager;
import userWebChat.model.Message;
import userWebChat.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/sendMessage")
public class SendMessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MessageManager messageManager = new MessageManager();
        User loginUser = (User) session.getAttribute("user");
        String text = req.getParameter("text");
        int toId = Integer.parseInt(req.getParameter("toId"));
        int fromId = loginUser.getId();
        Message message = new Message();
        message.setFromId(fromId);
        message.setToId(toId);
        message.setText(text);
        messageManager.addMessage(message);
        req.setAttribute("idDiv",toId);
        req.getRequestDispatcher("/getMessage").forward(req,resp);



    }
}
