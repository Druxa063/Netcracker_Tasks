package messageDriverBean;

import jdbc.util.DBUtil;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MessageDao {

    public void save(String message, long time) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO messageBean (DATEMESSAGE, message) VALUES (?, ?)")) {
            statement.setDate(1, new Date(time));
            statement.setString(2, message);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllMessage() {
        List<String> list = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
        Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT message FROM messageBean");
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
