package com.example.max.mainwindow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.max.mainwindow.R;
import com.example.max.mainwindow.museumpackage.Museum;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;


    public MapFragment() {
        // Required empty public constructor

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

        return view;
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(11.0f);
        //mMap.setMaxZoomPreference(20.0f);


        // Создание маркера и определение на карте
        LatLng Ural= new LatLng(56.841039, 60.622288);
        mMap.addMarker(new MarkerOptions().position(Ural).title("Музей плодового садоводства Среднего Урала \n"));

        // LatLng Ural= new LatLng(56.841039, 60.622288);
        //  mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)).position(Ural).title("Музей плодового садоводства Среднего Урала \n"));
        LatLng ekaterinburg= new LatLng(56.837319, 60.605603);
        mMap.addMarker(new MarkerOptions().position(ekaterinburg).title("Музей природы Среднего Урала \n"));

//        LatLng ekaterinburg1= new LatLng(56.837319, 60.605603);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg1).title("Уральский геологический музей \n"));
//
//        LatLng ekaterinburg9= new LatLng(56.830218, 60.600843);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg9).title("Уральский минералогический музей \n"));
//
//        LatLng ekaterinburg10= new LatLng(56.830218, 60.600843);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg10).title("Виртуальный музей А.П.Гайдара \n"));
//
//        LatLng ekaterinburg3= new LatLng(56.841329, 60.607199);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg3).title("Литературно-мемориальный дом-музей Д. Н. Мамина-Сибиряка \n"));
//
//        LatLng ekaterinburg4= new LatLng(56.826522, 60.595894);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg4).title("Литературно-мемориальный дом-музей Ф. М. Решетникова \n"));
//
//        LatLng ekaterinburg5= new LatLng(56.842449, 60.606999);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg5).title("Мемориальный дом-музей П. П. Бажова \n"));
//
//        LatLng ekaterinburg6= new LatLng(56.843447, 60.607367);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg6).title("Музей «Литературная жизнь Урала XIX века»\n"));
//
//        LatLng ekaterinburg7= new LatLng(56.843452, 60.607582);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg7).title("Музей «Литературная жизнь Урала XX века» \n"));
//
//        LatLng ekaterinburg8= new LatLng(56.830218, 60.600843);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg8).title("Музей гражданина Чехова — знакомого незнакомца \n"));
//
//        LatLng ekaterinburg11= new LatLng(56.830218, 60.600843);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg11).title("Музей живой книги \n")); //добавить координаты и проверить на различие
//
//        LatLng ekaterinburg12= new LatLng(56.843390, 60.606460);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg12).title("Музей кукол и детской книги Страна чудес \n"));
//
//        LatLng ekaterinburg13= new LatLng(56.843476, 60.607448);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg13).title("Объединенный музей писателей Урала \n"));
//
//        LatLng ekaterinburg14= new LatLng(56.842958, 60.584912);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg14).title("Музей маленьких историй \n"));
//
//        LatLng ekaterinburg15= new LatLng(56.844122, 60.619839);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg15).title("Военно-исторический музей ПУрВО\n"));
//
//        LatLng ekaterinburg16= new LatLng(56.844416, 60.608802);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg16).title("Галерея Храма-на-Крови \n"));
//
//        LatLng ekaterinburg17= new LatLng(56.901737, 60.593874);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg17).title("Музей военно-морского флота «Морской пехотинец» \n"));
//
//        LatLng ekaterinburg18= new LatLng(56.841489, 60.570245);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg18).title("Музей воздушно-десантных войск Крылатая гвардия) \n"));
//
//        LatLng ekaterinburg19= new LatLng(56.840659, 60.611495);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg19).title("Музей истории Екатеринбурга \n"));
//
//        LatLng ekaterinburg20= new LatLng(56.840863, 60.622506);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg20).title("Музей истории и археологии Среднего Урала \n"));
//
//        LatLng ekaterinburg21= new LatLng(56.839020, 60.586884);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg21).title("Музей купеческого быта\n"));
//
//        LatLng ekaterinburg22= new LatLng(56.880372, 60.614732);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg22).title("Музей памяти воинов-интернационалистов «Шурави» \n"));
//
//        LatLng ekaterinburg23= new LatLng(56.837273, 60.587515);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg23).title("Музей советского быта «Сделано в СССР» \n"));
//
//        LatLng ekaterinburg24= new LatLng(56.834112, 60.602280);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg24).title("Музейно-выставочный центр «Дом на Покровском» \n"));
//
//        LatLng ekaterinburg25= new LatLng(56.834083, 60.602194);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg25).title("Свердловский областной краеведческий музей \n"));
//
//        LatLng ekaterinburg26= new LatLng(56.836642, 60.654801);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg26).title("Уральский центр Б. Н. Ельцина\n"));
//
//        LatLng ekaterinburg27= new LatLng(56.837887, 60.605404);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg27).title("Музей архитектуры и дизайна УрГАХУ \n"));
//
//        LatLng ekaterinburg28= new LatLng(56.815370, 60.610935);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg28).title("Музей истории развития ЕМУП «ЕТТУ» \n"));
//
//        LatLng ekaterinburg29= new LatLng(56.886969, 60.587081);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg29).title("Музей истории Уралмашзавода \n"));
//
//        LatLng ekaterinburg30= new LatLng(56.858752, 60.600707);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg30).title("Музей истории, науки и техники Свердловской железной дороги \n"));
//
//        LatLng ekaterinburg31= new LatLng(56.833451, 60.61310);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg31).title("Музей радио им. А. С. Попова \n"));
//
//        LatLng ekaterinburg32= new LatLng(56.844122, 60.653689);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg32).title("Музей УГТУ-УПИ \n"));
//
//        LatLng ekaterinburg33= new LatLng(56.874786, 60.610163);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg33).title("Музей энергетики Урала \n"));
//
//        LatLng ekaterinburg34= new LatLng(56.840313, 60.610157);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg34).title("Музейно-выставочный комплекс УрГАХУ \n"));
//
//        LatLng ekaterinburg35= new LatLng(56.836709, 60.612941);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg35).title("Свердловская областная пожарно-техническая выставка \n"));
//
//        LatLng ekaterinburg36= new LatLng(56.836967, 60.612768);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg36).title("Свердловский областной музей истории медицины \n"));
//
//        LatLng ekaterinburg37= new LatLng(56.836135, 60.614515);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg37).title("Екатеринбургский Музей В.С.Высоцкого \n"));
//
//        LatLng ekaterinburg38= new LatLng(56.820933, 60.605188);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg38).title("Музей-театр Барабанный дом \n"));
//
//        LatLng ekaterinburg39= new LatLng(56.823872, 60.569294);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg39).title("Выставка-ярмарка «Минерал-Шоу» \n"));
//
//        LatLng ekaterinburg40= new LatLng(56.832332, 60.630909);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg40).title("«Екатеринбургский творческий союз деятелей культуры» \n"));
//
//        LatLng ekaterinburg41= new LatLng(56.822908, 60.603395);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg41).title("Галерея «Белая галерея»\n"));
//
//        LatLng ekaterinburg42= new LatLng(56.836446, 60.599068);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg42).title("Галерея «ДА» \n"));
//
//        LatLng ekaterinburg43= new LatLng(56.842827, 60.610684);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg43).title("Галерея «Эгида» \n"));
//
//        LatLng ekaterinburg44= new LatLng(56.833672, 60.615619);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg44).title("Галерея декоративно-прикладного искусства «АРТ-птица» \n"));
//
//        LatLng ekaterinburg45= new LatLng(56.830783, 60.590837);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg45).title("Галерея Одоевского \n"));
//
//        LatLng ekaterinburg46= new LatLng(56.839838, 60.606391);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg46).title("Галерея резиденции губернатора Свердловской области \n"));
//
//        LatLng ekaterinburg47= new LatLng(56.844271, 60.625987);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg47).title("Галерея-салон «Золотой скорпион» \n"));
//
//        LatLng ekaterinburg48= new LatLng(56.834603, 60.616512);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg48).title("Екатеринбургская галерея современного искусства \n"));
//
//        LatLng ekaterinburg49= new LatLng(56.833018, 60.595903);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg49).title("Екатеринбургский музей изобразительных искусств \n"));
//
//        LatLng ekaterinburg50= new LatLng(556.835171, 60.603268);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg50).title("Екатеринбургский музей изобразительных искусств \n"));
//
//        LatLng ekaterinburg51= new LatLng(56.832891, 60.609717);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg51).title("Екатеринбургский музейный центр народного творчества «Гамаюн» \n"));
//
//        LatLng ekaterinburg52= new LatLng(56.827745, 60.615833);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg52).title("Международная галерея графики «Шлем» \n"));
//
//        LatLng ekaterinburg53= new LatLng(56.837899, 60.605382);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg53).title("Музей «Метальная лавка»\n"));
//
//        LatLng ekaterinburg54= new LatLng(56.833672, 60.615608);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg54).title("Музей «Невьянская икона»\n"));
//
//        LatLng ekaterinburg55= new LatLng(56.839130, 60.606941);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg55).title("Музей истории камнерезного и ювелирного искусства\n"));
//
//        LatLng ekaterinburg56= new LatLng(56.840448, 60.615910);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg56).title("Музей старика Б. У. Кашкина\n"));
//
//        LatLng ekaterinburg57= new LatLng(56.829232, 60.590482);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg57).title("Сабина-Арт художественная галерея \n"));
//
//        LatLng ekaterinburg58= new LatLng(56.830989, 60.604631);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg58).title("Уральский филиал Государственного центра современного искусства\n"));
//
//        LatLng ekaterinburg59= new LatLng(56.841929, 60.610965);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg59).title("Фотографический музей «Дом Метенкова» \n"));
//
//        LatLng ekaterinburg60= new LatLng(56.839399, 60.583537);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg60).title("Художественная галерея «Арт-Словарь»\n"));
//
//        LatLng ekaterinburg61= new LatLng(56.838148, 60.623743);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg61).title("Художественная галерея «ПоЛе» \n"));
//
//        LatLng ekaterinburg62= new LatLng(56.831698, 60.603744);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg62).title("Художественный музей Эрнста Неизвестного \n"));
//
//        LatLng ekaterinburg63= new LatLng(56.841397, 60.681143);
//        mMap.addMarker(new MarkerOptions().position(ekaterinburg63).title("Художественный салон «Ноев ковчег»\n"));
        ArrayList<Museum> museums = MainActivity.getMuseums();
        for (Museum m: museums){
            LatLng name= new LatLng(m.getV(), m.getV1());
            mMap.addMarker(new MarkerOptions().position(name).title(m.getMname()));
        }









        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ekaterinburg));
    }

    // ((ImageView) convertView.findViewById(R.id.map_view)).setImageResource(R.drawable.tutor_ekb);


//    public View getView(int position, View convertView, ViewGroup parent) {
//        ((ImageView) convertView.findViewById(R.id.map_view)).setImageResource(R.drawable.tutor_ekb);
//        return convertView;
//    }




}