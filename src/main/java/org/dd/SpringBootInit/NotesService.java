package org.dd.SpringBootInit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesService {
	
	@Autowired
	private NotesRepository noteRepo;
	
	public List<Note> getNotes(){
		List<Note> notes = new ArrayList<>();
		noteRepo.findAll().forEach(notes::add);
		return notes;
	}
	
	public Note getNote(String id){
		return noteRepo.findById(id).get();
	}

	public void addNote(Note note) {
		noteRepo.save(note);
	}

	public void updateNote(String id, Note note) {
		noteRepo.save(note);
	}

	public void deleteNote(String id) {
		noteRepo.deleteById(id);
	}

}
