package com.iupc.Mapper;

import com.iupc.pojo.NewsPic;
import com.iupc.pojo.Notes;
import com.iupc.pojo.NotesPic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NotesMapper {
    List<Notes> qurryAllNotes();
    void insertNotes(Notes note);
     int getNotesNumber();
    void insertNotesPic(NotesPic np);
}
