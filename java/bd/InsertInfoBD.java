package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*Класс для запросов - добавить в БД*/
public class InsertInfoBD {

    /*Вставить запись в listNotes*/
    public int setNote(Connection connection, Note note) throws ClassNotFoundException, SQLException {

        String SQL = "INSERT INTO listNotes (HeaderNote, Note ) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, note.getHeader());
        preparedStatement.setString(2, note.getNote());
        int error = preparedStatement.executeUpdate();
        return error;
    }
}
