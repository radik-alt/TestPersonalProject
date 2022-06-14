package com.example.testpersonalproject.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testpersonalproject.R
import com.example.testpersonalproject.adapter.AdapterItem.AdapterItem
import com.example.testpersonalproject.UiAccount.ModelItem
import com.example.testpersonalproject.UiAccount.ModelQuestion
import com.example.testpersonalproject.UiAccount.ModelSubItem
import com.example.testpersonalproject.UiAccount.ModelTest
import com.example.testpersonalproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        adapter()

        binding.allResult.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_testFragment)
        }

        return binding.root
    }

    private fun adapter(){
        val adapter = AdapterItem()
        val list: ArrayList<ModelItem> = ArrayList()

        val modelQuestion: ArrayList<ModelQuestion> = ArrayList()

        val list_question :ArrayList<String> = ArrayList()
//        for (i in 0 until 20){
        list_question.add("Да, можно ")
        list_question.add("Нужно спросить разрешение в письменном виде у главного заведующего хозяйством производства, после чего посетить его лично и убедиться в правильности его ответа. После этого следовать приказу")
        list_question.add("Нет, нельзя ")
        list_question.add("Не знаю ")
//            val listAnswer: Model_Item_Quest = Model_Item_Quest(i.toLong(), list_question)
//            val temp = ModelQuestion(i.toLong(), )
//            modelQuestion.add(temp)
//        }

        val listTest: Array<ModelTest> = Array(20){ ModelTest(1, "", "", list_question, 1,  null, false) }
        for (i in 0 until 20){
            val list_question2 :ArrayList<String> = ArrayList()
            list_question2.add("Да, можно $i")
            list_question2.add("Нужно спросить разрешение в письменном виде у главного заведующего хозяйством производства, после чего посетить его лично и убедиться в правильности его ответа. После этого следовать приказу")
            list_question2.add("Нет, нельзя $i")
            list_question2.add("Не знаю $i")
            val test = ModelTest(i.toLong(), "Задча ${i+1}",
                "Можно ли снимать таблички с красным текстом «Не включать! Работают люди», если работы ещё не закончены, но люди уже не в помещении?",
                list_question2,
                1,
                null,
                false
            )
            listTest[i] = test
        }

        val listLesson : ArrayList<String> = ArrayList()
        listLesson.add("https://avatars.mds.yandex.net/get-zen_doc/1581245/pub_5ff74f3ef906b16872346899_5ff74f67f906b1687234a757/scale_1200")


        val subList: ArrayList<ModelSubItem> = ArrayList()
        for (i in 0 until 10){
            val subModel = ModelSubItem(1, "Тест ${i+1}", false, listLesson)
            subList.add(subModel)
        }


        for (i in 0 until 10){
            val model = ModelItem(1, "Text", subList, listTest)
            list.add(model)
        }

        adapter.itemList = list
        binding.recyclerTest.adapter = adapter
    }
}