package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*Класс для запросов - удаления информации*/
public class DeleteInfoBD {

    /*Метод для удаления заметки*/
    public int delNote(Connection connection, int id) throws ClassNotFoundException, SQLException {
        String SQL = "DELETE FROM listNotes WHERE id =? ";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, id);
        int error = preparedStatement.executeUpdate();
        return error;
    }
}
