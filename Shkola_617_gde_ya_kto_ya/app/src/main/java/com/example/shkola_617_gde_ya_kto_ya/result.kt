package com.example.shkola_617_gde_ya_kto_ya

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.io.IOException

class result : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    lateinit var textView2: TextView

    companion object {
        val TOTAL1 = "tx"
        val TOTAL2 = "t"
    }

    var storage = FirebaseStorage.getInstance()
    val fMap = mapOf(
        104 to "ой сало сало сало украiнське сало",
        105 to "Главный вход в школу (Вход №1). Слева с улицы расположен Вход №2",
        107 to "107 - кабинет информатики. Ответственный за ПБ: Левшенкова Е.В.",
        108 to "108 - кабинет математики. Бывший малый зал. Ответственный за ПБ: Майконецкая Т.В.",
        110 to "110 - выход во внутреннй двор школы",
        114 to "114 - кабинет (коворкинг). Ответственный за ПБ: Скатова Е.П.",
        115 to "115 - кабинет (ИТ-куб - медиатека). Ответственный за ПБ: неизвестно.",
        116 to "116 - кабинет литературы и математики (ИТ-куб - мобильная разработка). Ответственный за ПБ: Богданова Н.В.",
        117 to "117 - кабинет английского языка (шахматная гостиная). Ответственный за ПБ: Салогубова А.Е.",
        120 to "120 - кабинет (лекторий). Ответственный за ПБ: Скатова Е.П.",
        114 to "114 - кабинет технологии. Ответственный за ПБ: Серюгина И.С.",
        122 to "122 - медицинский кабинет. Главный врач: О.В., Медсестра: неизвестно",
        126 to "126 - (учительский) гардероб.",
        127 to "127 - лестница, соединяющая 1-й и 2-й этажи в крыле средней и старшей школы.",
        130 to "130 - вход и выход во двор школы. Расположен слева от основного входа",
        136 to "136 - школьная столовая",
        157 to "157 - лестница, соединяющая 1-й и 2-й этажи в крыле начальной школы.",
        158 to "158 - кабинет музыки. Ответственный за ПБ: Прокопенко Л.Б.",
        162 to "162 - кабинет . Ответственный за ПБ: неизвестно.",
        163 to "163 - кабинет . Ответственный за ПБ: неизвестно.",
        167 to "167 - мужской туалет.",
        168 to "168 - кабинет . Ответственный за ПБ: неизвестно.",
        170 to "170 - кабинет . Ответственный за ПБ: неизвестно.",
        204  to "204 - кабинет начальных классов. Ответственный за ПБ: Кузенкова А.С.",
        216 to "216 - спортивный зал. Ответственный за ПБ: неизвестно.",
        218 to "218 - кабинет . Ответственный за ПБ: неизвестно.",
        223 to "223 - кабинет информатики (ИТ-куб - Кибергигиена/Системное администрирование). Ответственный за ПБ: неизвестно.",
        227  to "227 - кабинет математики. Ответственный за ПБ: .",
        228 to "228 - кабинет географии. Ответственный за ПБ: Лучкина О.В.",
        232  to "232 - кабинет истории. Ответственный за ПБ: Рогачёв А.М.",
        233  to "233 - кабинет русского языка, литературы и ИЗО. Ответственный за ПБ: неизвестно.",
        23  to "23 - кабинет . Ответственный за ПБ: .",
        2  to "2 - кабинет . Ответственный за ПБ: .",
        2  to "2 - кабинет . Ответственный за ПБ: .",
        308  to "308 - кабинет русского языка и литературы. Ответственный за ПБ: неизвестно.",
        307 to "307 - кабинет химии. Ответственный за ПБ: неизвестно.",
        310 to "310 - кабинет истории и ОБЖ. Ответственный за ПБ: Никулина С.В.",
        318 to "318 - кабинет истории и обществознания. Ответственный за ПБ: Савченко О.А.",
        324 to "324 - школьная библиотека. Ответственный за ПБ: Курбанова Я.Ф.",
        331 to "331 - кабинет . Ответственный за ПБ: Федорчук Л.В.",
        333 to "333 - кабинет . Ответственный за ПБ: неизвестно.",
        335 to "335 - кабинет русского языка и литературы. Ответственный за ПБ: Лидер И.И."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView6)
        textView2 = findViewById(R.id.textView7)
        val nump = intent.getStringExtra(TOTAL1)
        val numt = intent.extras?.getString("t")
        textView.text = numt.toString()
        if (numt != null && numt.toInt() in fMap ) {
                textView2.text = fMap[numt.toInt()].toString()

        }
        else { textView2.text = "Пока что об этом кабинете нет информации. Скорее всего, вы найдёте её на сайте школы: http://school617.spb.ru/ ."}

        val storageRef =
            storage.getReferenceFromUrl("gs://capybara-76b0c.appspot.com").child("$numt.jpeg")
        val storageRef2 =
            storage.getReferenceFromUrl("gs://capybara-76b0c.appspot.com").child("$numt .jpeg")
        val storageRef3 =
            storage.getReferenceFromUrl("gs://capybara-76b0c.appspot.com").child("$numt.jfif")
        val storageRef4 =
            storage.getReferenceFromUrl("gs://capybara-76b0c.appspot.com").child("$numt .jfif")
        val storageRef5 =
            storage.getReferenceFromUrl("gs://capybara-76b0c.appspot.com").child("$numt.jpg")
        val storageRef6 =
            storage.getReferenceFromUrl("gs://capybara-76b0c.appspot.com").child("$numt .jpg")
        try {
            val localFile: File = File.createTempFile("images", "jpeg")
            storageRef.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())
                    imageView.setImageBitmap(bitmap)
                }).addOnFailureListener(OnFailureListener {
                    imageView.setImageResource(R.drawable.img_2)
                })
        } catch (e: IOException) {
            try {
                val localFile2: File = File.createTempFile("images", "jpeg")
                storageRef2.getFile(localFile2)
                    .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                        val bitmap = BitmapFactory.decodeFile(localFile2.getAbsolutePath())
                        imageView.setImageBitmap(bitmap)
                    }).addOnFailureListener(OnFailureListener {
                        imageView.setImageResource(R.drawable.img_2)
                    })
            } catch (e: IOException) {
                try {
                    val localFile2: File = File.createTempFile("images", "jfif")
                    storageRef3.getFile(localFile2)
                        .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                            val bitmap = BitmapFactory.decodeFile(localFile2.getAbsolutePath())
                            imageView.setImageBitmap(bitmap)
                        }).addOnFailureListener(OnFailureListener {
                            imageView.setImageResource(R.drawable.img_2)
                        })
                } catch (e: IOException) {
                    try {
                        val localFile2: File = File.createTempFile("images", "jfif")
                        storageRef4.getFile(localFile2)
                            .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                                val bitmap = BitmapFactory.decodeFile(localFile2.getAbsolutePath())
                                imageView.setImageBitmap(bitmap)
                            }).addOnFailureListener(OnFailureListener {
                                imageView.setImageResource(R.drawable.img_2)
                            })
                    } catch (e: IOException) {
                        try {
                            val localFile2: File = File.createTempFile("images", "jfif")
                            storageRef5.getFile(localFile2)
                                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                                    val bitmap =
                                        BitmapFactory.decodeFile(localFile2.getAbsolutePath())
                                    imageView.setImageBitmap(bitmap)
                                }).addOnFailureListener(OnFailureListener {
                                    imageView.setImageResource(R.drawable.img_2)
                                })
                        } catch (e: IOException) {
                            val localFile2: File = File.createTempFile("images", "jfif")
                            storageRef6.getFile(localFile2)
                                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                                    val bitmap =
                                        BitmapFactory.decodeFile(localFile2.getAbsolutePath())
                                    imageView.setImageBitmap(bitmap)
                                }).addOnFailureListener(OnFailureListener {
                                    imageView.setImageResource(R.drawable.img_2)
                                })
                        }
                    }
                }
            }
        }
    }
}