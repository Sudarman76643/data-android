package com.example.mynavcompt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.mynavcompt.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private  val  binding get() = _binding!!

    companion object{
        val EXTRA_NAME = "extra_name"
        val EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDetailCategory.setOnClickListener { view ->
            /*menggunakan Bundle
            val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "Lifestyle")
            mBundle.putLong(EXTRA_DESCRIPTION, 7)
            view.findNavController().navigate(R.id.action_categoryFragment_to_detailCategoryFragment, mBundle)
             */

            // menggunakan sageargs

            val toDetailCategoryFragment = CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
            toDetailCategoryFragment.name = "Lifestyle"
            toDetailCategoryFragment.description = 7
            view.findNavController().navigate(toDetailCategoryFragment)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
