package com.openclassrooms.notes.widget

import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.notes.databinding.NoteBinding
import com.openclassrooms.notes.model.Note

/**
 * A view holder for displaying a note in a RecyclerView.
 * @param binding The binding for the note layout.
 */
class NoteViewHolder(private val binding: NoteBinding): RecyclerView.ViewHolder(binding.root) {

    /**
     * Binds the view holder to a note.
     * @param note The note to bind to the view holder.
     */
    fun bind(note: Note) {
        binding.title.text = note.title
        binding.body.text = note.body
    }

}