package com.iupc.Mapper;

import com.iupc.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NotesMapper {
    List<Notes> qurryAllNotes();
    List<Notes> qurryNotesBysearch(String value);
    void insertNotes(Notes note);
    int getNotesNumber();
    void insertNotesPic(NotesPic np);
    Notes qurryNoteById(String id);
    String[] qurryNotePicbyId(String id);

    void deletNotesByid(String id);

    List<Notes> qurryAllNotesByShow(String show);
    void updataNotesByShow(String id ,String show);
    List<News> qurryAllNotesByFavor(String username,String v);

    void insertNewsNote(NewsNotes newsNotes);
    List<News> qurryNewsByNote(String note_id);
    List<Notes> qurryNotesByNews(String news_id);
}
