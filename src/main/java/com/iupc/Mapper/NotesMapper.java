package com.iupc.Mapper;

import com.iupc.pojo.Notes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NotesMapper {
    List<Notes> qurryAllNotes();
}
