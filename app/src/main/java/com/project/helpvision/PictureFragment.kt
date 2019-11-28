package com.project.helpvision


import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.project.helpvision.databinding.FragmentPictureBinding


/**
 * A simple [Fragment] subclass.
 */
class PictureFragment : Fragment() {
    val REQUEST_IMAGE_CAPTURE = 1

    lateinit var binding: FragmentPictureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_picture, container, false)

        //take a photo with camera
        binding.takePhoto.setOnClickListener{
            takePhoto()
        }

        //upload image from gallery
        binding.uploadPhoto.setOnClickListener {
            uploadPhoto()
        }
        return  binding.root
    }

    private fun uploadPhoto() {
        val photoIntent = Intent(Intent.ACTION_PICK)
        photoIntent.setType("image/*")
        startActivityForResult(photoIntent, 1)

    }

    private fun takePhoto() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(activity!!.packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }

        }
    }


}
