package bd;

public class Note {

    private int idNote;
    private String header;
    private String note;

    public Note() {

    }

    public Note(int idNote, String header, String note) {
        this.idNote = idNote;
        this.header = header;
        this.note = note;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return idNote + " " + header + " " + note;
    }
}
