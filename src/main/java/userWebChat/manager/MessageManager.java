package userWebChat.manager;


import userWebChat.db.DBConnector;
import userWebChat.model.Message;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class MessageManager {
    private Connection connection = DBConnector.getDBConnector().getConnection();

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public List<Message> getAllMessageById(int id1, int id2) {
        List<Message> allMessages = new LinkedList<Message>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM message WHERE ((`to_id` = ? AND `from_id` = ?)OR (`to_id` = ? AND `from_id` = ?)) ORDER  BY `times_temp` ASC ");
            preparedStatement.setInt(1, id1);
            preparedStatement.setInt(2, id2);
            preparedStatement.setInt(3, id2);
            preparedStatement.setInt(4, id1);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Message message = new Message();
                message.setId(resultSet.getInt("id"));
                message.setFromId(resultSet.getInt("from_id"));
                message.setToId(resultSet.getInt("to_id"));
                message.setText(resultSet.getString("text"));
                message.setTimesTamp(resultSet.getTimestamp("times_temp").toString());
                allMessages.add(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMessages;
    }

    public void addMessage(Message message) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO message(`from_id`,`to_id`,`text`) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, message.getFromId());
            preparedStatement.setInt(2, message.getToId());
            preparedStatement.setString(3, message.getText());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                message.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
