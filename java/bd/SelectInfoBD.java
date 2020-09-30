package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*Класс для запросов - получить данные из БД*/
public class SelectInfoBD {

    /*Получить список заметок*/
    public ArrayList getNotes(Connection connection) throws ClassNotFoundException, SQLException {
        ArrayList<Note> notes = new ArrayList<Note>();
        String SQL = "SELECT * FROM listNotes";
        PreparedStatement preparedStatementWA = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatementWA.executeQuery();
        while (resultSet.next()) {
            notes.add(new Note(resultSet.getInt("id"),
                    resultSet.getString("HeaderNote"),
                    resultSet.getString("Note")));
        }
        return notes;
    }
}
