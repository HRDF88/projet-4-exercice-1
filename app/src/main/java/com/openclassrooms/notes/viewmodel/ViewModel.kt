package com.openclassrooms.notes.viewmodel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.openclassrooms.notes.R
import com.openclassrooms.notes.databinding.ActivityMainBinding
import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.widget.NoteItemDecoration
import com.openclassrooms.notes.widget.NotesAdapter
import kotlinx.coroutines.launch
import com.openclassrooms.notes.databinding.ActivityMainBinding.inflate
import com.openclassrooms.notes.databinding.NoteBinding
import com.openclassrooms.notes.databinding.NoteBinding.inflate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@HiltViewModel
//ViewModel
class ViewModel : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val notesAdapter = NotesAdapter(emptyList())

    private val notesRepository = NotesRepository()
    
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initFABButton()
        collectNotes()
    }


    /**
     * Collects notes from the repository and updates the adapter.
     */
    private fun collectNotes(lifecycleScope: Any) {
        lifecycleScope.launch {
            notesRepository.notes.collect {
                notesAdapter.updateNotes(it)
            }
        }
    }

    /**
     * Initializes the FAB button.
     */
    private fun initFABButton() {
        binding.btnAdd.setOnClickListener {
            MaterialAlertDialogBuilder(this).apply {
                setTitle(R.string.coming_soon)
                setMessage(R.string.not_available_yet)
                setPositiveButton(android.R.string.ok, null)
            }.show()
        }
    }

    /**
     * Initializes the RecyclerView.
     */
    private fun initRecyclerView() {
        with(binding.recycler) {
            addItemDecoration(
                NoteItemDecoration(
                    resources.getDimensionPixelSize(com.openclassrooms.notes.R.dimen.default_margin),
                    resources.getInteger(com.openclassrooms.notes.R.integer.span_count)
                )
            )

            adapter = notesAdapter
        }


    }
    private fun CoroutineScope.launch(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit,


}


