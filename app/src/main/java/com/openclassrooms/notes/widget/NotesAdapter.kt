package com.openclassrooms.notes.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.notes.databinding.NoteBinding
import com.openclassrooms.notes.model.Note

/**
 * An adapter for displaying a list of notes in a RecyclerView.
 * @param notes The list of notes to display.
 */
class NotesAdapter(private var notes: List<Note>) : RecyclerView.Adapter<NoteViewHolder>() {

    /**
     * Updates the list of notes displayed by the adapter.
     * @param newNotes The new list of notes to display.
     */
    fun updateNotes(newNotes: List<Note>) {
        notes = newNotes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int =
        notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }
}