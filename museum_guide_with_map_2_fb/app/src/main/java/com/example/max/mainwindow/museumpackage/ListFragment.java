package com.example.max.mainwindow.museumpackage;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.max.mainwindow.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.TreeMap;

public class ListFragment extends Fragment {
    //Фрагмент, отвечающий за вывод списка музеев
    ArrayList<Museum> museums = new ArrayList<>();
    MuseumAdapter museumAdapter = new MuseumAdapter(museums);
    TreeMap<String, Museum> musemsTree  = new TreeMap<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.museum_recycler_view);
        //museums.add(new Museum("Мемориальный дом-музей П. П. Бажова", "Чапаева, 11", "2570692", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Екатеринбург_0021_Дом_Бажова.jpg/200px-Екатеринбург_0021_Дом_Бажова.jpg", "ompural.ru/muzei-i-otdely-obedinenija/memorialnyj-dom-muzej-p-p-bazhova/", "Дом-музей в городе Екатеринбурге. Дом, в котором жил уральский писатель Павел Петрович Бажов", 56.8873436, 60.6148887));


//        DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fireapp-12b506.firebaseio.com/museums");
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
//                    //Log.d("BD",userSnapshot.getKey()+": "+userSnapshot.getValue(Museum.class).getMname());
//
//                    Museum m = userSnapshot.getValue(Museum.class);
//                    museums.add(m);
//                    Log.d("Museum: ", m.getMname());
//                    museumAdapter.notifyDataSetChanged();
//
//                }
//            }
//
//
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
        DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fireapp-12b506.firebaseio.com/museums");
        ref.addChildEventListener(new ChildEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Museum m = dataSnapshot.getValue(Museum.class);
                 museums.add(m);
                 musemsTree.put(m.getUi(), m);
                //museums.sort(new Comparator<Museum>() {
                //    @Override
                //    public int compare(Museum o1, Museum o2) {
                //        return o1.getMname().compareTo(o2.getMname());
                //    }
                //});
                 museumAdapter.notifyDataSetChanged();
                 //Log.d("Museumilos", m.getUi());

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Museum changedMuseum = dataSnapshot.getValue(Museum.class);
                String key = changedMuseum.getUi();
                Museum sourceMuseum = musemsTree.get(key);
                musemsTree.put(key, changedMuseum);
                changedMuseum.setUi(key);
                int index = museums.indexOf(sourceMuseum);
                museums.set(index, changedMuseum);
                museumAdapter.notifyDataSetChanged();
//                Museum m = dataSnapshot.getValue(Museum.class);
//                String digitalKey = m.getUi();
//                Museum surcM = musemsTree.get(digitalKey);
//                Log.d("surcM", surcM.getMname());
//                m.setUi(digitalKey);
//
//                museums.remove(surcM);
//                museumAdapter.notifyDataSetChanged();
//                museums.add(m);
//                museums.sort(new Comparator<Museum>() {
//                    @Override
//                    public int compare(Museum o1, Museum o2) {
//                        return o1.getMname().compareTo(o2.getMname());
//                    }
//                });
//                museumAdapter.notifyDataSetChanged();




            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Museum removedMuseum = dataSnapshot.getValue(Museum.class);
                museums.remove(removedMuseum);
                museumAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), "Не удаётся получить доступ к базе данных. Пожалуйста, проверьте подключение к интернету.", Toast.LENGTH_LONG).show();
            }
        });

//        museums.add(new Museum("Музей природы Среднего Урала", "Горького, 4а", "3712113", "https://cdn00.mir.afisha.ru/imgs/2016/04/13/14/4907/40333dfdee4e8341d826560793d26c54a9f8650b.jpg", "www.uole-museum.ru/museums/muzej-prirody-urala/", "Музей природы – старейшая среди площадок Свердловского областного краеведческого музея. За 146 лет его сотрудники собрали богатую естественнонаучную коллекцию – свыше 60 тысяч предметов. ", 56.837319,60.605603));
//        museums.add(new Museum("Уральский минералогический музей", "Красноармейская, 1", "3506019", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Гостиница_%22Большой_Урал%22.JPG/280px-Гостиница_%22Большой_Урал%22.JPG", "www.pelepenko-va.ru/", "Частный минералогический музей, располагавшийся в Екатеринбурге с 2000 до 2015 года в здании гостиницы \"Большой Урал\". С 2017 года находится в Первоуральске в Инновационном культурном центре (известен как \"шайба\")", 56.830218,60.600843));
//        museums.add(new Museum("Музей «Литературная жизнь Урала XIX века»", "Толмачева, 41", "3712281", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Музей_«Литературная_жизнь_Урала_XIX_века»_01.JPG/1280px-Музей_«Литературная_жизнь_Урала_XIX_века»_01.JPG", "ompural.ru/muzei-i-otdely-obedinenija/muzej-literaturnaja-zhizn-urala-xix-veka-/", "Литературный музей в городе Екатеринбурге. Входит в состав Объединённого музея писателей Урала.", 56.843447,60.607367));
//        museums.add(new Museum("Музей «Литературная жизнь Урала XX века»", "Пролетарская, 10", "3710591", "https://upload.wikimedia.org/wikipedia/commons/e/e7/Art_Nouveau_wooden_house_in_Yekaterinburg.jpg", "vk.com/muzxx", "Дом-терем в стиле русского провинциального модерна на улице Толмачева (Колобовской) под номером 40 был построен по заказу присяжного поверенного В. И. Иванова при участии архитектора И. К. Янковского в 1910–1912 годах.", 56.843452,60.607582));
//        museums.add(new Museum("Музей маленьких историй", "Октябрьской революции, 35", "2904713, 2069639", "https://avatars.mds.yandex.net/get-ugc/741758/2a0000015fb1f3c2167b117ff6ddb0cfb270/X5L", "", "Музей находится в здании старинной усадьбы Жолобова по улице Октябрьской революции, дом 35. Музей был основан 30 марта 2013 года организацией «Культурное событие». ", 56.842958,60.584912));
//        museums.add(new Museum("Военно-исторический музей ПУрВО", "Первомайская, 27", "3501742", "https://avatars.mds.yandex.net/get-altay/216588/2a0000015b2ebca025301a8c095059b554bd/XXL", "www.odo-ural.ru", "В феврале 1941 был октрыт Военно-исторический музей ПУрВО, ранее имевший название Свердловский окружной Дом офицеров. Здание, построенное по проекту архитектора В.В. Емельянова, отличается строгой монументальностью, лаконичностью фасадов.", 56.844122,60.619839));
//        museums.add(new Museum("Галерея Храма-на-Крови", "Толмачева, 34а", "3716168", "https://www.smileplanet.ru/upload/hl-photo/92e/63b/hram_na_krovi_9.jpg", "", "К сожалению, мы не нашли подробной информации о данном музее, но это никак не делает его хуже. Посетите его и узнайте все подробности сами :)", 56.844416,60.608802));
//        museums.add(new Museum("Музей военно-морского флота «Морской пехотинец»", "Победы, 70б", "3319132", "https://kudago.com/media/thumbs/xl/images/place/8f/1e/8f1e3a550c9fb38b5b766b7a1644c845.jpg", "", "Музей «Морской пехотинец», основан по инициативе бывших служащих в рядах Военно-Морского Флота. История музея начиналась со сбора экспонатов, среди которых были — макеты кораблей, предметы быта моряков, фотографии, документы, медали и значки, хранившиеся в домашних архивах со времен ВОВ.", 56.901737,60.593874));
//        museums.add(new Museum("Музей истории Екатеринбурга", "Карла Либкнехта, 26", "3712111", "https://www.tourprom.ru/site_media/images/poiphoto/original_57.jpg", "www.m-i-e.ru", "Музей истории Екатеринбурга ведет свою историю с 1940 года. После глобальной трансформации в 1995 году бывший Мемориальный музей Я.М. Свердлова обрел своё настоящее название", 56.840659,60.611495));
//        museums.add(new Museum("Музей истории и археологии Среднего Урала", "Ленина, 69/10", "3507550", "https://avatars.mds.yandex.net/get-altay/216588/2a0000015b1f8e9e01700dfd3619e75fd873/XXL", "www.uole-museum.ru/museums/muzej-istorii-i-arheologii-urala/", "Свердловский областной краеведческий музей (СОКМ) имени О.Е. Клера — крупнейшее музейное объединение Урала. Датой рождения музея считается 29 декабря 1870 (10 января 1871) года.«Родителями» стала группа екатеринбургской интеллигенции — члены Уральского общества любителей естествознания (УОЛЕ). В январе 2018 года музей получил имя своего основателя, инициатора создания УОЛе Онисима Егоровича Клера.", 56.840863,60.622506));
//        museums.add(new Museum("Свердловский областной краеведческий музей", "Малышева, 46", "3764719", "http://its.ekburg.ru/store/u/images/Музеи/дом_поклевских_козелjpg.jpg", "www.uole-museum.ru", "Крупнейшее на Урале музейное объединение, филиалы которого расположены в 10 городах Свердловской области. ", 56.834083,60.602194));
//        museums.add(new Museum("Музей архитектуры и дизайна УрГАХУ", "Горького, 4а", "3547819", "https://static.tonkosti.ru/images/c/cc/Музей_архитектуры_и_дизайна_УрГАХУ_в_Екатеринбурге.jpg", "www.museumarch.com", " В начале 1970-х гг. в преддверии 250-летия Екатеринбурга в историческом центре города, было решено создать историко-мемориальные комплекс и разместить на его территории музей старой заводской техники и истории архитектуры уральских городов. ", 56.837887,60.605404));
//        museums.add(new Museum("Музей истории развития ЕМУП «ЕТТУ»", "Степана Разина, 51", "2572341", "http://pravdaurfo.ru/sites/default/files/dscf5598_novyy_razmer_1.jpg", "www.e-tram.narod.ru", "Музей истории трамвая и троллейбуса (или другое название – Музей развития ЕМУП «ТТУ») – один из самых молодых в Екатеринбурге, несмотря на уже довольно-таки долгую историю этого вида транспорта. ", 56.81537,60.610935));
//        museums.add(new Museum("Музей истории Уралмашзавода", "Культуры, 3", "3274400", "https://avatars.mds.yandex.net/get-altay/200322/2a0000015b2e9a88bf3d014ef72685f929ac/XXL", "www.uralmash.ru", " Оказывается, музей истории Уралмашзавода закрыт для посетителей с 2010 года из-за несоответствия части здания пожарным, санитарным и иным техническим характеристикам. И вывеска у входа, указывающая время работы музея — всего лишь номинальный объект, уже сам ставший достоянием истории. И стоят, будто немые, залы...", 56.886969,60.587081));
//        museums.add(new Museum("Музей истории, науки и техники Свердловской железной дороги", "Вокзальная, 14", "3584222", "https://upload.wikimedia.org/wikipedia/commons/a/a2/Old_train_station_of_Yekaterinburg.jpg", "www.svzd.rzd.ru", "Дорожный музей открылся в Свердловске в 70-х годах XX века и в то время представлял из себя центр научно-технической информации для работников железнодорожного транспорта. ", 56.858752,60.600707));
//        museums.add(new Museum("Музей УГТУ-УПИ", "Мира, 19", "3754860", "http://letopisi.org/images/9/9b/Екатеринбург_УГТУ-УПИ.jpg", "www.ustu.ru", "Данный музей был основан на базе Уральского Федерального Университета и рассказывает историю развития данного учебного заведения. Здесь представлены фотографии, документы, личные вещи несущие историческую ценность.", 56.844122,60.653689));
//        museums.add(new Museum("Музей энергетики Урала", "Космонавтов, 17а", "3890564", "https://avatars.mds.yandex.net/get-ugc/217759/2a0000015faee6dfb808c6850c2ef3bf3f55/X5L", "http://musen.ru/", "Музей энергетики Урала (МЭУ) — екатеринбургский музей, посвящённый истории и становлению энергетики на Урале.", 56.874786,60.610163));
//        museums.add(new Museum("Музейно-выставочный комплекс УрГАХУ", "Карла Либкнехта, 23", "3713369", "https://lh3.googleusercontent.com/p/AF1QipPS8mN5C5vqQdUDj42yQ5aB6QDds6PMEyyzLOEI=w600-k", "", "В начале 1970-х гг. в преддверии 250-летия Екатеринбурга в историческом центре города, было решено создать историко-мемориальные комплекс и разместить на его территории музей старой заводской техники и истории архитектуры уральских городов. ", 56.840313,60.610157));
//        museums.add(new Museum("Свердловский областной музей истории медицины", "Карла Либкнехта, 8б", "3716063", "https://avatars.mds.yandex.net/get-altay/235931/2a0000015e4d04cecfaa8d6abf946ce433f2/XXL", "", "В 1982 году на базе Свердловской областной клинической больницы № 1 была открыта первая экспозиция музея истории медицины. Этому событию суждено было стать важной вехой в истории развития музейного дела и в истории...", 56.836967,60.612768));
//        museums.add(new Museum("Выставка-ярмарка «Минерал-Шоу»", "Посадская, 23", "3565282", "http://druza.web.ru/m-mineral-show_7_Ek_170414_DSC02688.JPG", "www.mineral-show.ru", "К сожалению, мы не нашли подробной информации о данном музее, но это никак не делает его хуже. Посетите его и узнайте все подробности сами :)", 56.823872,60.569294));
//        museums.add(new Museum("Галерея «Белая галерея»", "8 Марта, 66", "2517896", "http://static.ngs.ru/news/54/preview/e32e98866785c7f88c68252549411aa30daf7267_1500.jpg", "www.belayagallery.com", "Галерея «Белая галерея» (УрАГС), открытая в 1992 году, является одной из первых негосударственных галерей Екатеринбурга. В настоящее время галерея активно сотрудничает с художниками различных городов страны", 56.822908,60.603395));
//        museums.add(new Museum("Галерея «ДА»", "8 марта, 8", "3718966", "http://www.domaktera.ru/user/tuz/ДОМИК%20В%20АКВАРЕЛИ.jpg", "www.domaktera.ru", "Дом Актера – официальная резиденция Свердловского отделения – памятник истории и культуры, камерный особняк XIX века, построенный в 1890 году по проекту главного архитектора Екатеринбурга Юлия Дютеля.", 56.836446,60.599068));
//        museums.add(new Museum("Галерея «Эгида»", "Карла Либкнехта, 38а", "3715839", "https://regions.kidsreview.ru/sites/default/files/styles/card_600_400/public/08/30/2012_-_0116/filarmoniya_ekb.jpg", "www.filarmonia.e-burg.ru/gallery", "Галерея «Эгида» – все выставочные пространства в стенах Свердловской филармонии. Около 20 художественных проектов каждый год. Сотрудничество с известными художниками, открытие новых имен. Синтез искусств. ", 56.842827,60.610684));
//        museums.add(new Museum("Галерея декоративно-прикладного искусства «АРТ-птица»", "Энгельса, 15", "2206651", "https://i1.photo.2gis.com/images/branch/9/1266637408397561_979e.jpg", "www.artbird.ru", "Это самобытное местечко в самом центре города, где можно увидеть множество интересных вещей, сделанных настоящими мастерами своего дела и купить то, что больше понравилось. Здесь есть и сувениры для иностранцев, и подарки для близких людей на любой кошелек.", 56.833672,60.615619));
//        museums.add(new Museum("Галерея резиденции губернатора Свердловской области", "Горького, 21", "3705468", "https://i.uralweb.ru/albums/fotos/f/a80/a806f5f17fa5f59e7d5ad393d2d93d1f.jpg", "", "Галерея резиденции губернатора Свердловской области открылась не так давно — в 1997 году, по инициативе губернатора Э. Росселя. Галерея состоит из трёх залов, в первом посетители смогут познакомиться с произведениями живописи и графики, во втором — с изделиями уральских ювелиров, а в третьем — с красотой древнерусских икон. ", 56.839838,60.606391));
//        museums.add(new Museum("Галерея-салон «Золотой скорпион»", "Бажова, 75а", "3505705", "https://avatars.mds.yandex.net/get-pdb/33827/8c8039ea-f79f-4768-9705-e3ec5980babd/s1200?webp=false", "www.r-gold.ru", "Открытие галереи состоялось в августе 2003 года, и сразу же после открытия начала сотрудничать с видными художниками мирового уровня.", 56.844271,60.625987));
//        museums.add(new Museum("Екатеринбургская галерея современного искусства", "Красноармейская, 32", "3502200", "http://static.esosedi.org/fiber/186152/fit/1400x1000/ekaterinburgskaya_galereya_sovremennogo_iskusstva.png", "www.uralgallery.ru", "Екатеринбургская галерея современного искусства – частный музейно-выставочный комплекс в Екатеринбурге. Галерея специализируется на профессиональном изобразительном искусстве Урала. Дата основания галереи - 30 августа 2004 года. Коллекция галереи насчитывает около 1300 произведений живописи, графики, скульптуры и демонстрирует эволюцию художественной школы Урала, начиная с XIX века. ", 56.834603,60.616512));
//        museums.add(new Museum("Екатеринбургский музей изобразительных искусств", "Вайнера, 11", "3763045", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/Yekaterinburg_Museum_of_Fine_Arts.jpg/300px-Yekaterinburg_Museum_of_Fine_Arts.jpg", "www.emii.ru", "Крупнейший художественный музей Урала, имеет два здания — главное расположено на берегу реки Исети в Екатеринбурге, в Историческом сквере города, второе на Вайнера, 11 ", 56.833018,60.595903));
//        museums.add(new Museum("Екатеринбургский музей изобразительных искусств", "Вайнера, 11", "3763045", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/Yekaterinburg_Museum_of_Fine_Arts.jpg/300px-Yekaterinburg_Museum_of_Fine_Arts.jpg", "www.emii.ru", "Крупнейший художественный музей Урала, имеет два здания — главное расположено на берегу реки Исети в Екатеринбурге, в Историческом сквере города, второе на Вайнера, 11 ", 556.835171,60.603268));
//        museums.add(new Museum("Екатеринбургский музей изобразительных искусств", "Воеводина, 5", "3710626", "https://avatars.mds.yandex.net/get-pdb/33827/64d33144-7e3c-40c9-829a-14eddf8b72eb/s1200?webp=false", "www.emii.ru", "Крупнейший художественный музей Урала, имеет два здания — главное расположено на берегу реки Исети в Екатеринбурге, в Историческом сквере города, второе на Вайнера, 11 ", 56.833018,60.595903));
//        museums.add(new Museum("Екатеринбургский музей изобразительных искусств", "Воеводина, 5", "3710626", "https://avatars.mds.yandex.net/get-pdb/33827/64d33144-7e3c-40c9-829a-14eddf8b72eb/s1200?webp=false", "www.emii.ru", "Крупнейший художественный музей Урала, имеет два здания — главное расположено на берегу реки Исети в Екатеринбурге, в Историческом сквере города, второе на Вайнера, 11 ", 556.835171,60.603268));
//        museums.add(new Museum("Екатеринбургский музейный центр народного творчества «Гамаюн»", "Гоголя, 20/5", "3712041", "http://its.ekburg.ru/store/u/images/Гамаюн.jpg", "www.centrgamaun.ru", "Екатеринбургский музейный центр народного творчества «Гамаюн» был создан 25 марта 1994 года. Учредителем новой организации выступило Управление культуры Администрации г. Екатеринбурга. Музей стал наследником существующей более 10 лет Ассоциации мастеров народного творчества и художественных ремёсел «Гамаюн». ", 56.832891,60.609717));
//        museums.add(new Museum("Международная галерея графики «Шлем»", "Куйбышева, 44", "3596189", "https://avatars.mds.yandex.net/get-pdb/25978/fad60e68-9207-4b12-8265-1e0acf2a59f1/s1200?webp=false", "", "Международная галерея графики «Шлем» с каждым годом набирает всю большую и большую популярность. Расположенный в центре города Екатеринбург — является одним из лучших культурных мест Свердловской области. Основная миссия галереи, характерная для культурных учреждений данного типа — поддержка и развитие искусства, прививание эстетического вкуса местным жителям. ", 56.827745,60.615833));
//        museums.add(new Museum("Музей «Метальная лавка»", "Горького, 4", "3712113", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Музей_истории.JPG/250px-Музей_истории.JPG", "", "Музей «Метальная лавка», который также имеет название Музей истории Екатеринбурга, был основан в 1992 году. Музей берёт начало с 1940 года, когда был открыт Дома-музея. М. Свердлова, впоследствии реорганизованный. Здание музея имеет богатую историю: в прошлом оно было доходным домом, гостиницей, жилым домом и дворянской усадьбой. Основная миссия музея, характерная для культурных учреждений данного типа — сохранение и развитие краеведческой информации, прививание интереса к истории родного города местным жителям.", 56.837899,60.605382));
//        museums.add(new Museum("Музей «Невьянская икона»", "Энгельса, 15", "2206650", "http://its.ekburg.ru/store/u/images/Музеи/1.jpg", "www.iconmuseum.ru", "В Екатеринбурге является частным музеем икон в России. Здесь представлено более 300 невьянских икон XVIII-XX веков. Музей был открыт в 1999 году Евгением Ройзманом.", 56.833672,60.615608));
//        museums.add(new Museum("Музей истории камнерезного и ювелирного искусства", "Ленина, 37", "2712462", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Аптека_горного_ведомства.jpg/300px-Аптека_горного_ведомства.jpg", "www.stone-cutting.e-burg.ru", "Музей истории камнерезного и ювелирного искусства в Екатеринбурге — первый в России музей подобного профиля, созданный в 1992 г. Музей находится в центре исторической застройки Екатеринбурга в здании бывшей Аптеки горного ведомства (архитектор М. П. Малахов, 1821—1822 гг.).", 56.83913,60.606941));
//        museums.add(new Museum("Сабина-Арт художественная галерея", "Радищева 33", "3797696", "https://media-cdn.tripadvisor.com/media/photo-s/0e/4f/c0/06/2016.jpg", "www.sabinaartgallery.com", "Миссией художественной галереи «Сабина – арт» является популяризация искусства и предоставление возможности приобретения творений современных уральских художников.", 56.829232,60.590482));
//        museums.add(new Museum("Уральский филиал Государственного центра современного искусства", "Добролюбова, 19а", "3858635", "https://avatars.mds.yandex.net/get-altay/216588/2a0000015b1fc2e0ed282ab4fbedb98a8952/XXL", "http://ncca.ru/ekaterinburg", "Уральский филиал Государственного центра современного искусства (Уф ГЦСИ) — государственная музейно-выставочная и научно-исследовательская организация. Входит в состав Государственного центра современного искусства. Филиал начал работу в 1999 году, выбрав основой своей деятельности внедрение современного искусства в общественные пространства Екатеринбурга.", 56.830989,60.604631));
//        museums.add(new Museum("Художественная галерея «Арт-Словарь»", "Шейнкмана, 10", "3777750", "http://art-slovar.ru/gallery/IMG_7148.JPG", "www.art-slovar.ru", "Художественная галерея «АРТ-СЛОВАРЬ» представляет выставку Дмитрия Васильева, художника, чьё творчество объединяет в себе лучшие традиции академической живописи. Его картины рассказываю свою историю языком цвета и формы, ясным и понятным каждому внимательному зрителю.", 56.839399,60.583537));
//        museums.add(new Museum("Художественная галерея «ПоЛе»", "Ленина, 50ж", "3501149", "https://avatars.mds.yandex.net/get-altay/216588/2a0000015b2eb4607562cff864696c73aa09/XXL", "www.pole-gallery.ru", "Галерея «ПоЛе» это: Новая выставка каждые три недели, часто — экспериментальная выставочная площадка", 56.838148,60.623743));
//        museums.add(new Museum("Художественный музей Эрнста Неизвестного", "Добролюбова, 14", "3891482, 3891483", "https://avatars.mds.yandex.net/get-pdb/25978/23c40868-7d38-462a-9031-6d8ffea24834/s1200", "www.en-artmuseum.ru", "Художественный музей Эрнста Неизвестного — государственный музей в Екатеринбурге, посвященный творчеству скульптора и художника ЭрнстаНеизвестного, уроженца города. Это первый в России музей Э. Неизвестного, открытый в его 88-ый день рождения, 9 апреля 2013 года, по инициативе ряда общественных деятелей Екатеринбурга и при поддержке Губернатора Свердловскойобласти.", 56.831698,60.603744));
//        museums.add(new Museum("Художественный салон «Ноев ковчег»", "Высоцкого, 14", "3474515", "https://gl.weburg.net/00/places/1/138/original/380494.jpg", "kudago.com/ekb/place/hud-salon-noev-kovcheg/", "В экспозиции салона хранится богатая коллекция произведений изобразительного искусства: гобелены, батик, скульптуры, керамика, художественное литье, ковка, изделия из стекла и дерева.", 56.841397,60.681143));


        recyclerView.setAdapter(museumAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }



}
