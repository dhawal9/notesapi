package org.dd.SpringBootInit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {
	
	@Autowired
	private NotesService notesService;
	
	@RequestMapping("/notes")
	public List<Note> getNotes(){		
		return notesService.getNotes();
	}
	
	@RequestMapping("/notes/{id}")
	public Note getNote(@PathVariable String id){
		return notesService.getNote(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/notes")
	public void addNote(@RequestBody Note note){
		notesService.addNote(note);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/notes/{id}")
	public void updateNote(@RequestBody Note note, @PathVariable String id){
		notesService.updateNote(id, note);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/notes/{id}")
	public void deleteNote(@PathVariable String id){
		notesService.deleteNote(id);
	}

}
