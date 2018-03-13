package userWebChat.servlet;

import userWebChat.manager.MessageManager;
import userWebChat.manager.UserManager;
import userWebChat.model.Message;
import userWebChat.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/getMessage")
public class GetMessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idDiv = 0;
   if(req.getParameter("idDiv")!=null){
        idDiv = Integer.parseInt(req.getParameter("idDiv"));}
        else{
       idDiv =(Integer) req.getAttribute("idDiv");
   }



        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("user");
        UserManager userManager = new UserManager();
        MessageManager messageManager = new MessageManager();
       List<Message> allMessages =  messageManager.getAllMessageById(idDiv,loginUser.getId());
        req.setAttribute("allMessages",allMessages);
        List<User> allUsers =  userManager.getAllUsers();
        req.setAttribute("allUsers",allUsers);
        req.setAttribute("idDiv",idDiv);
        req.getRequestDispatcher("\\WEB-INF\\mainPage.jsp").forward(req,resp);

    }
}
