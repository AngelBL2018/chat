package userWebChat.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import userWebChat.manager.UserManager;
import userWebChat.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isMultiPart = ServletFileUpload.isMultipartContent(req);
        if (isMultiPart) {
            String folder = "/home/expert/Desktop";
            String name = "";
            String surname = "";
            String email = "";
            String password = "";
            String picUrl = "";
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            servletFileUpload.setSizeMax(500000);
            try {
                List<FileItem> items = servletFileUpload.parseRequest(req);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        if (item.getFieldName().equals("name")) {
                            name = item.getString();
                        } else if (item.getFieldName().equals("surname")) {
                            surname = item.getString();
                        } else if (item.getFieldName().equals("email")) {
                            email = item.getString();
                        } else if (item.getFieldName().equals("password")) {
                            password = item.getString();
                        }
                    } else {
                        String picPath = System.currentTimeMillis() + "_" + item.getName();
                        File file = new File(folder + picPath);
                        item.write(file);
                        picUrl = picPath;

                    }
                }
                UserManager userManager = new UserManager();
                User user = new User();
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
                user.setPassword(password);
                user.setPicUrl(picUrl);
                userManager.addUser(user);

                resp.sendRedirect("login.jsp");

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }
}
