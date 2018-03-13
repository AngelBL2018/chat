<%@ page import="userWebChat.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="userWebChat.model.Message" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List<User> allUsers = (List<User>) request.getAttribute("allUsers");
    List<Message> allMessages = (List<Message>) request.getAttribute("allMessages");
    User loginUser = (User) session.getAttribute("user");
    int size = 200 * allUsers.size();
%>

<div style="width:100%; height: <%=size%>px;; background-color:red;">
    <div style="float: left; width: 30%;height: 700px;">
        <%for (User user : allUsers) {%>
        <a href="/getMessage?idDiv=<%=user.getId()%>">

            <div id="<%=user.getId()%>" style="width: 100%;height: 200px; background-color: darkgray; border:1px solid black;">
                <img src="/getPicture?fileName=<%=user.getPicUrl()%>" width="100px;">
                <%=user.getName()%> <%=user.getSurname()%>

            </div>
        </a>
        <%}%>
    </div>

    <div id="messagePart" style="float:left;background-color: black; width: 70%;height: <%=size%>px;">
        <form action="/logOut">
            <input type="submit" value="Logout">
        </form>


        <%
            if (allMessages != null) {
                for (Message message : allMessages) {
                    if (message.getFromId() == loginUser.getId()) {
        %>
        <div style="width: 70%;height: auto; background-color: blue;margin-left: 265px;"><%=message.getText()%><br>
        <div><%=message.getTimesTamp()%>
        </div>
        </div><br>
        <%
            }
            if (message.getFromId() != loginUser.getId()) {
        %>
        <div style="width: 70%;height: auto; background-color: green;margin-left: 0px"><%=message.getText()%><br>
            <div><%=message.getTimesTamp()%>
            </div>
        </div><br>


        <%
                    }
                }
            }
        %>


        <% int idDiv = 0;
            if (request.getAttribute("idDiv") != null) {
                idDiv = (int) request.getAttribute("idDiv");
            }
            ;%>
        <form action="/sendMessage">
            <textarea style="max-width: 70%; max-height: 100px;min-width: 70%;min-height: 100px;"
                      name="text"></textarea>
            <input type="hidden" name="toId" value="<%=idDiv%>">
            <input type="submit" value="Send">
        </form>
    </div>


</div>

</body>
</html>