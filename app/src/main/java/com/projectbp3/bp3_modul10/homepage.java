package com.projectbp3.bp3_modul10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homepage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homepage extends Fragment {

    ArrayList<manga> list;
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homepage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homepage.
     */
    // TODO: Rename and change types and number of parameters
    public static homepage newInstance(String param1, String param2) {
        homepage fragment = new homepage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));

        list = new ArrayList<>();
        list.add(new manga(
                "2018",
                "Jujutsu Kaisen",
                "Gege Akutami",
                "Action, Fantasy",
                "Completed",
                "Di dunia di mana roh-roh terkutuk menghancurkan umat manusia, Yuji Itadori menemukan artefak kuno dan berbahaya—sebuah jari terkutuk dari iblis kuat. Ketika ia menelan jari tersebut untuk menyelamatkan teman-temannya, ia menjadi inang Sukuna, Raja Kutukan. Sekarang, Yuji harus menghadapi bahaya eksorsisme, penyihir terkutuk, dan tubuhnya sendiri saat Sukuna mencoba mengambil alih, sambil berusaha melindungi orang-orang yang ia cintai.",
                "20.9k",
                R.drawable.jujutsu_kaisen
        ));

        list.add(new manga(
                "2014",
                "Attack on Titan",
                "Hajime Isayama",
                "Action, Drama",
                "Completed",
                "Umat manusia berada di ambang kepunahan, terpaksa hidup di balik tembok besar karena serangan makhluk humanoid raksasa yang disebut Titan. Ketika Titan Kolosal menjebol tembok, kehidupan Eren Yeager berubah selamanya. Bersumpah untuk membalas dendam kepada Titan dan membebaskan umat manusia, Eren bergabung dengan Pasukan Penyelidik, hanya untuk menemukan kebenaran mengejutkan tentang asal-usul Titan dan sejarah kelam umat manusia.",
                "45.7k",
                R.drawable.attack_on_titan
        ));

        list.add(new manga(
                "2001",
                "Naruto",
                "Masashi Kishimoto",
                "Action, Adventure",
                "Completed",
                "Naruto Uzumaki adalah seorang ninja muda dengan impian besar: menjadi Hokage, ninja terkuat di desanya. Dengan rubah berekor sembilan yang kuat disegel di dalam dirinya, Naruto menghadapi prasangka dan kesepian. Bersama rekan-rekannya, Sasuke dan Sakura, serta di bawah bimbingan guru mereka, Kakashi, Naruto menjalani misi berbahaya, menghadapi musuh legendaris, dan menemukan arti sebenarnya dari persahabatan, kekuatan, dan pengorbanan.",
                "35.2k",
                R.drawable.naruto
        ));

        list.add(new manga(
                "2016",
                "My Hero Academia",
                "Kohei Horikoshi",
                "Action, Superhero",
                "Ongoing",
                "Dalam masyarakat di mana hampir semua orang memiliki kekuatan super yang disebut Quirk, Izuku Midoriya lahir tanpa kekuatan. Meski begitu, ia bermimpi menjadi pahlawan hebat seperti idolanya, All Might. Ketika Izuku bertemu All Might dan membuktikan keberaniannya, ia dipilih untuk mewarisi Quirk legendaris, One For All. Ikuti perjalanan Izuku saat ia berlatih di U.A. High School yang bergengsi dan menghadapi para penjahat yang menantang dasar-dasar masyarakat pahlawan.",
                "28.3k",
                R.drawable.my_hero_academia
        ));

        list.add(new manga(
                "2009",
                "One Punch Man",
                "ONE, Yusuke Murata",
                "Action, Comedy",
                "Ongoing",
                "Saitama adalah pria biasa yang melatih dirinya untuk menjadi pahlawan. Setelah tiga tahun pelatihan keras, ia mencapai kekuatan luar biasa—sehingga ia dapat mengalahkan musuh apa pun dengan satu pukulan. Namun, kekuatan ini membuat Saitama bosan dan mempertanyakan tujuannya. Di tengah pertarungan melawan monster dan penjahat super, ia mencari tantangan yang layak, pengakuan, dan arti sebenarnya dari menjadi pahlawan.",
                "22.1k",
                R.drawable.one_punch_man
        ));

        list.add(new manga(
                "1999",
                "One Piece",
                "Eiichiro Oda",
                "Adventure, Fantasy",
                "Ongoing",
                "Monkey D. Luffy memulai perjalanan untuk menjadi Raja Bajak Laut dengan menemukan harta karun legendaris yang dikenal sebagai One Piece. Bersama kru bajak lautnya yang unik, termasuk pendekar pedang, navigator, koki, dan penembak jitu, Luffy menjelajahi lautan berbahaya, melawan musuh yang menakutkan, dan mengungkap kebenaran tersembunyi tentang dunia dan sejarahnya. One Piece bukan hanya harta karun—itu adalah impian yang menggerakkan hati para petualang.",
                "50.8k",
                R.drawable.one_piece
        ));

        list.add(new manga(
                "2013",
                "Tokyo Ghoul",
                "Sui Ishida",
                "Dark Fantasy, Horror",
                "Completed",
                "Di Tokyo modern, seorang mahasiswa pemalu bernama Kaneki Ken mendapati dirinya terjerumus ke dalam dunia kekerasan ghoul—makhluk pemakan manusia. Setelah pertemuan tak terduga dengan seorang ghoul, Kaneki menjalani operasi berbahaya yang membuatnya menjadi setengah manusia, setengah ghoul. Berjuang dengan identitas dan kelaparannya yang baru, ia harus menavigasi konflik antara manusia dan ghoul sambil melindungi orang-orang yang ia cintai.",
                "25.5k",
                R.drawable.tokyo_ghoul
        ));

        list.add(new manga(
                "2012",
                "Orb: The Movement of the Earth",
                "Reki Kawahara",
                "Sci-Fi, Adventure",
                "Completed",
                "Ketika Bumi mengalami serangkaian perubahan gravitasi yang memengaruhi kehidupan sehari-hari, seorang ilmuwan muda bernama Aria menemukan sebuah bola misterius yang dapat mengontrol medan gravitasi. Bola ini menjadi kunci untuk menyelamatkan umat manusia dari kehancuran. Bersama timnya, Aria menghadapi tantangan ilmiah, politik, dan ancaman tak terduga yang mencoba merebut bola tersebut. Petualangan ini membawa mereka menjelajahi rahasia alam semesta dan masa depan Bumi.",
                "18.7k",
                R.drawable.orb
        ));

        list.add(new manga(
                "2011",
                "Blue Exorcist",
                "Kazue Kato",
                "Action, Supernatural",
                "Ongoing",
                "Rin Okumura adalah seorang remaja yang tampak biasa hingga ia menemukan bahwa dirinya adalah putra Satan. Dengan kekuatan iblisnya yang bangkit, Rin bersumpah untuk mengalahkan ayahnya dan melindungi umat manusia. Ia mendaftar di Akademi True Cross untuk dilatih sebagai eksorsis, di mana ia menjalin ikatan dengan sekutu dan menghadapi tantangan menjadi manusia sekaligus iblis.",
                "17.4k",
                R.drawable.blue_exorcist
        ));

        list.add(new manga(
                "2003",
                "Fullmetal Alchemist",
                "Hiromu Arakawa",
                "Adventure, Fantasy",
                "Completed",
                "Kakak beradik Edward dan Alphonse Elric melakukan transmutasi manusia yang dilarang dalam upaya menghidupkan kembali ibu mereka, yang berujung pada konsekuensi tragis. Edward kehilangan lengan dan kakinya, sementara Alphonse kehilangan seluruh tubuhnya, dengan jiwanya terikat pada baju zirah. Bersama-sama, mereka mencari Batu Bertuah, artefak kuat yang dapat mengembalikan tubuh mereka. Sepanjang perjalanan, mereka mengungkap konspirasi kelam yang mengancam dunia.",
                "30.6k",
                R.drawable.fullmetal_alchemist
        ));




        ListMangaAdapter listMangaAdapter = new ListMangaAdapter(list);
        recyclerView.setAdapter(listMangaAdapter);

        listMangaAdapter.setOnItemClickCallback(manga -> {
            detail_manga fragment = detail_manga.newInstance(
                    manga.getTitle(),
                    manga.getAuthor(),
                    manga.getTahun(),
                    manga.getGenre(),
                    manga.getStatus(),
                    manga.getPremis(),
                    manga.getPhoto() // Tambahkan parameter photo
            );
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .addToBackStack(null)
                    .commit();
        });




        return view;
    }


}