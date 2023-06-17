package com.example.pertemuan09.view.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pertemuan09.R
import com.example.pertemuan09.databinding.FragmentUpdateBinding
import com.example.pertemuan09.viewmodel.ViewModelMahasiswa

class UpdateFragment : Fragment() {
    lateinit var binding : FragmentUpdateBinding
    lateinit var viewModel : ViewModelMahasiswa

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentUpdateBinding
                .inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nim = arguments?.getString("nim")
        val nama = arguments?.getString("nama")
        val telepon = arguments?.getString("telepon")

        viewModel =
            ViewModelProvider(this)
                .get(ViewModelMahasiswa::class.java)

        binding.inputNim.setText(nim)
        binding.inputNama.setText(nama)
        binding.inputTelepon.setText(telepon)

        binding.btnUpdate.setOnClickListener{
            val updatedNim = binding.inputNim.text.toString()
            val updatedNama = binding.inputNama.text.toString()
            val updatedTelepon = binding.inputTelepon.text.toString()
            viewModel
                .updateMahasiswa()
                .observe(viewLifecycleOwner) {
                if (it != null) {
                    Toast
                        .makeText(context,"Data berhasil diupdate",
                            Toast.LENGTH_SHORT).show()
                    findNavController()
                        .navigate(R.id.action_updateFragment_to_homeFragment)
                }else{
                    Toast
                        .makeText(context,"Data gagal diupdate",
                            Toast.LENGTH_SHORT).show()
                }
            }
            viewModel.updateDataMahasiswa(updatedNim,updatedNama,updatedTelepon)
        }

        binding.btnBack.setOnClickListener{
            findNavController().navigateUp()
        }
    }
}