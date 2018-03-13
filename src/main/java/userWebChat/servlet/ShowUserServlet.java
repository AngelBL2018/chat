package userWebChat.servlet;

import userWebChat.manager.MessageManager;
import userWebChat.manager.UserManager;
import userWebChat.model.Message;
import userWebChat.model.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/showUserServlet")
public class ShowUserServlet extends HttpServlet {
UserManager userManager = new UserManager();
MessageManager messageManager = new MessageManager();



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("userEmail");
        String password = req.getParameter("userPassword");
        List<Message> allMessages = (List<Message>) req.getAttribute("allMessages");
       User user =  userManager.getUserByEmailPassword(email,password);
        if (user == null){
            resp.sendRedirect("login.jsp");
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            List<User> allUsers =  userManager.getAllUsers();
            req.setAttribute("allUsers",allUsers);
           req.getRequestDispatcher("\\WEB-INF\\mainPage.jsp").forward(req,resp);
        }


    }
}
