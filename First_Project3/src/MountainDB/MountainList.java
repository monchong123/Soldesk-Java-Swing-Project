package MountainDB;

import java.util.ArrayList;
import java.util.List;

/*private String MountainName; //산 이름
private String level;       //난이도
private String place;         //산 위치
private String placeUrl;    //지도 Url
private String imageUrl;    //이미지 Url
private String explanation;    //산 설명          순서
*/


public class MountainList {
   private static ArrayList<MountainInfo> arr;
   
   public MountainList() {
      if(arr == null) {
         Info();
      }
   }
   
   public List<MountainInfo> Info(){
      ArrayList<MountainInfo> arr = new ArrayList<MountainInfo>();
      //충청
      arr.add(new MountainInfo("소백산", "★★★☆☆", "충북 단양군 가곡면 어의곡리",
            "https://map.naver.com/p/entry/place/11623614?lng=128.48450840000234&lat=36.957565199998804&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh",
            "높이 1439.67m로 태백산에서 남서쪽으로 뻗은 소백산맥 중의 산으로서 비로봉(1439.67m)·국망봉(1,421m)·제2연화봉(1,357m)·도솔봉(1,314m)·신선봉(1,389m)·형제봉(1,177m)·묘적봉(1,148m) 등의 많은 봉우리들이 이어져 있다.",
            "./mountainImage/충청/소백산.png",
            "충청도"));
      arr.add(new MountainInfo("계룡산", "★★★☆☆", "충남 공주시 반포면 동학사1로 327-6",
            "https://map.naver.com/p/entry/place/11491299?lng=127.20604033049204&lat=36.342359106832006&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh",
            "계룡산은 차령산맥 중의 연봉으로, 충청남도 공주시·계룡시·논산시와 대전광역시에 걸쳐 있는 산이다. 산의 이름은 주봉인 천황봉(846.5m)에서 연천봉(739m)·삼불봉(775m)으로 이어지는 능선이 마치 닭 볏을 쓴 용의 모양과 닮았다고 하여 붙여졌다고 한다.",
            "./mountainImage/충청/계룡산.png",
            "충청도"));
      arr.add(new MountainInfo("칠갑산", "★☆☆☆☆", "충남 청양군 대치면",
            "https://map.naver.com/p/entry/place/13491154?lng=126.8849799&lat=36.413014600000004&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh",
            "높이 559.8m로, 청양군의 중심부에 있다. 계곡은 깊고 급하며 지천과 잉화달천이 계곡을 싸고 돌아 7곳에 명당이 생겼다 하여 칠갑산이라는 이름이 붙었다. 산세가 험해 ‘충남의 알프스’라는 별명이 생겼으며 교통이 불편하여 울창한 숲이 그대로 남아 있다.",
            "./mountainImage/충청/칠갑산.png",
            "충청도"));
      arr.add(new MountainInfo("용봉산", "★★☆☆☆", "홍성군 홍북읍",
               "https://map.naver.com/p/entry/place/13491072?lng=126.6491971999999&lat=36.643651499999976&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh", 
               "높이는 457.6m이고, 주봉은 시루봉이다. 시 중심부 남쪽에 솟은 산으로, 보물이 묻혀 있다 하여 보물산이라고 불리다가 보문산이 되었다거나, 나무꾼이 죽어가는 물고기를 살려줘서 얻은 '은혜를 갚는 보물주머니'에서 이름이 유래되었다는 전설도 전해진다.",
               "./mountainImage/충청/용봉산.png",
               "충청도"));
      arr.add(new MountainInfo("속리산", "★★☆☆☆", "충북 보은군 속리산면 법주사로 84",
            "https://map.naver.com/p/entry/place/11491446?lng=127.87086090000004&lat=36.5432356000003&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh",
            "대한민국 충청북도 보은군과 괴산군, 경상북도 상주시와 문경시에 걸쳐 있는 높이 1,058m의 산이다. 화강암을 기반으로 변성퇴적암이 섞여 있고 화강암 부분은 날카롭게 솟아오르고 변성퇴적암 부분은 깊게 패여 높고 깊은 봉우리와 계곡이 절경을 이루고 있어 광명산(光明山), 미지산(彌智山), 소금강산(小金剛山)으로 불리기도 한다.\r\n",
            "./mountainImage/충청/속리산.png",
            "충청도"));
      
      //경기
      arr.add(new MountainInfo("천마산", "★★★☆☆", "경기 남양주시 호평동 350",
            "https://map.naver.com/p/entry/place/13491738?lng=127.27331370000005&lat=37.68023710000002&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh",
            "높이 810.2m이다. 북서쪽의 철마산(711m)과 함께 광주산맥에 속한다. 46번 경춘국도의 마치굴에서 북쪽으로 3㎞ 떨어져 있다. 산세가 험하고 복잡하다 하여 예로부터 소박맞은 산이라 불려왔다. 주봉을 중심으로 하여 북동쪽은 비교적 비탈이 급하고, 서쪽은 완만하다.",
            "./mountainImage/경기/천마산.png",
            "경기도"));
      arr.add(new MountainInfo("북한산", "★★★★☆", "경기 고양시 덕양구 대서문길 375",
            "https://map.naver.com/p/entry/place/11491416?lng=126.97795869999972&lat=37.65870660456428&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh",
            "백두대간에서 뻗어 나온 한북정맥은 추가령(586m)에서 남서 방향으로 굽이쳐 내려오다 경기도 양주군 서남쪽에 이르러 도봉산을 만든다. 이곳에서 우이령을 넘어 남서 방향으로 한강에 이르러 다시 솟구쳐 일어난 산이 북한산이다. 서울의 진산인 북한산은 서울시 은평구, 성북구, 강북구, 도봉구와 경기도 의정부시, 양주시, 고양시에 걸쳐 있다. 북한산은 예로부터 한산(漢山), 삼각산(三角山) 등으로 불려 왔으며, 북한산이라는 명칭은 북한산성을 축조한 뒤부터 사용된 것으로 추정된다. 최고봉인 백운대(白雲臺; 835.6m)와 그 동쪽의 인수봉(仁壽蜂; 810m), 남쪽의 만경대(萬景臺; 779m) 등 세 봉우리로 이루어졌기 때문에 삼각산(三角山)이라고도 부른다.", 
            "./mountainImage/경기/북한산.png",
            "경기도"));
      arr.add(new MountainInfo("아차산", "★☆☆☆☆", "경기 구리시 아천동",
            "https://map.naver.com/p/entry/place/11491459?lng=127.1027414&lat=37.56684539999999&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh",
            "높이는 295.7m이다. 예전에는 남쪽을 향해 불뚝 솟아오른 산이라 하여 남행산이라고도 하였고, 마을사람들은 아끼산·아키산·에께산·엑끼산 등으로 부르기도 한다. 《경기지(京畿誌)》 '양주조'에 보면 화양사(지금의 영화사)가 악계산(嶽溪山)에 있다고 되어 있다.",
            "./mountainImage/경기/아차산.png",
            "경기도"));
      arr.add(new MountainInfo("소요산", "★★☆☆☆", "경기 동두천시 평화로2910번길 406-33", 
            "https://map.naver.com/p/entry/place/11491445?lng=127.08794109999998&lat=37.9385116&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh", 
            "높이는 587.5m이고, 주봉(主峰)은 의상대(義湘臺)이다. 서울특별시에서 북쪽으로 44km, 동두천 시청에서 동북쪽으로 약 5km 지점에 있다. 규모가 크지는 않지만 산세가 수려하고 아름다워서 경기의 소금강(小金剛)이라고도 한다. 645년 신라의 원효대사(元曉大師)가 개산(開山)하여 자재암(自在庵)을 세운 이후, 974년(고려 광종 25) 소요산이라 부르게 되었고, 중대암(中臺庵)·소운암(小雲庵)·소요암(逍遙岩)·영원사(靈源寺) 등의 사찰과 암자가 있었다고 한다. 1981년 국민관광지로 지정되었다. 자재암은 봉선사(奉先寺)의 말사(末寺)로서, 원효대사가 수행 도중 관세음보살과 친견하고 자재무애의 수행을 쌓았다고 하는 데서 그 이름이 유래하였다", 
            "./mountainImage/경기/소요산.png",
            "경기도"));
      arr.add(new MountainInfo("용문산", "★★★★☆", "경기 양평군 용문면 용문산로 782 용문사",
            "https://map.naver.com/p/entry/place/11491479?lng=127.54859710000001&lat=37.562149600000005&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh",
            "높이 1,157m. 양평(楊平) 북동쪽 8km, 서울 동쪽 42km 지점에 위치한다. 광주(廣州)산맥계에 속하나 독립된 한 산괴로서 산체(山體)가 웅대하여 동서 8km, 남북 5km에 걸치고, 용문산을 주봉으로 하여 동북동 5.5km의 도일봉(道一峰:864m), 동쪽 4.5km의 중원산(中元山:800m), 남서 3.5km의 백운봉(白雲峰:940m) 등 지봉(支峰)이 용립(聳立)하여 연봉을 이루고 있다.",
            "./mountainImage/경기/용문산.png",
            "경기도"));
      
      //강원
      arr.add(new MountainInfo("설악산", "★★★★★", "강원 인제군 북면 한계리",
            "https://map.naver.com/p/search/%EC%84%A4%EC%95%85%EC%82%B0/place/13491004?c=5.00,0,0,0,dh&placePath=%3Fentry%253Dbmp",
            "대한민국에서는 한라산과 지리산 다음으로 높은 산이다. 추석 무렵부터 눈이 내리기 시작하며 여름이 되어야 녹는 까닭으로 이렇게 이름 지었다. 해방 및 분단 이후 한국 전쟁 때까지는 이 산이 조선민주주의인민공화국 영토에 속했으나 한국 전쟁 이후에는 대한민국 영토가 되었다.", 
            "./mountainImage/강원/설악산.png",
            "강원도"));
      arr.add(new MountainInfo("태백산", "★★★★☆", "강원 태백시 혈동",
            "https://map.naver.com/p/search/%ED%83%9C%EB%B0%B1%EC%82%B0/place/13491090?c=5.00,0,0,0,dh&placePath=%3Fentry%253Dbmp",
            "1989년 5월 13일에 강원도 도립공원으로 지정되었으며, 2016년 4월 15일 국립공원으로 승격이 결정, 2016년 8월 22일부터 대한민국의 22번째 국립공원이 되었다.\r\n"
            + "일찍이 민족의 영산으로 일컬어 오며 신라 때부터 여기서 관리와 백성들이 천제를 지내왔다.고려 시대까지는 산꼭대기에 제사를 지내는 전각이 있었으나 조선 초기에 파괴되어 현재는 제단이 있다.",
            "./mountainImage/강원/태백산.png",
            "강원도"));
      arr.add(new MountainInfo("계방산", "★★★☆☆", "강원 홍천군 내면 대한동길 363-8",
            "https://map.naver.com/p/search/%EA%B3%84%EB%B0%A9%EC%82%B0/place/13491767?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp",
            "계방산(桂芳山)은 강원특별자치도 평창군과 홍천군 사이에 있는 높이 1,577m의 산이다. 주목, 철쭉 등이 군락을 이루고 있어 일대가 생태계 보호지역으로 지정되었다. 정상의 동남쪽 아래 방아다리약수터 일대의 수만 평에 조성한 낙엽송 전나무 숲과 주목 군락은 일찍이 여느 산에서 찾아볼 수 없는 장관이기도 하다. 약수터와 이승복기념관이 있고 접근로도 좋은 편이어서 찾는 이가 많다.",
            "./mountainImage/강원/계방산.png",
            "강원도"));
      arr.add(new MountainInfo("매봉산", "★☆☆☆☆", "강원 영월군 상동읍",
            "https://map.naver.com/p/search/%EB%A7%A4%EB%B4%89%EC%82%B0/place/13491963?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp",
            "매봉산(鷹峰山)은 강원특별자치도 태백시 삼수동에 있는 산으로 높이는 1,303m이다. 태백시 함백산 자락의 천의봉(天儀峯)으로 알려져 있지만 흔히 매봉산으로 부르고 있다. 영남의 낙동정맥을 따라 산을 거슬러 올라와 황지로 접어들면 북쪽에 가장 높이 솟은 산이 바로 매봉산으로 알려져 있고 삼척시 하장면 쪽에서 물줄기를 거슬러 올라오면 제일 높은 산도 매봉산으로 알려져 있다.",
            "./mountainImage/강원/매봉산.png",
            "강원도"));
      arr.add(new MountainInfo("가리왕산", "★★☆☆☆", "강원 정선군 정선읍",
            "https://map.naver.com/p/search/%EA%B0%80%EB%9D%BC%EC%99%95%EC%82%B0%20/place/13491128?c=15.00,0,0,0,dh&isCorrectAnswer=true",
            "가리왕산(加里王山)은 강원특별자치도 정선군과 평창군에 걸쳐 있는 산이다.오대산의 남쪽에 있으면서 높이도 비슷하여 오대산과 더불어 태백산맥의 지붕노릇을 하고 있다. 전형적인 육산이며 능선에는 고산식물인 주목, 잣나무, 단풍나무등 각종 수목이 울창하다. 갈왕(葛王)이 난을 피하여 숨어든 곳이라 하여 갈왕산(葛王山)이라 불리다가 일제 강점기를 거치면서 가리왕산(加里王山)으로 불리고 있다.",
            "./mountainImage/강원/가리왕산.png",
            "강원도"));
      
      //전라
      arr.add(new MountainInfo("청암산", "★★★☆☆", "전북 군산시 회현면 세장리 산143",
            "https://map.naver.com/p/entry/place/17506373?c=9.45,0,0,0,dh",
            "청암산은 해발 117m로 구릉성 산지이다. 옥산면 남쪽에 위치하여 옥산면과 회현면의 경계가 된다. 북쪽으로 이어진 금성산과 함께 청암산은 군산 저수지, 또는 옥산 저수지로 불리는 제2 수원지를 품고 있다. 옥산 저수지 입구에서 청암산 정상까지는 약 2.5㎞이며, 등산로가 잘 마련되어 있다. 정상에는 전망대와 삼각점이 있다. 전망대에 서면 옥구읍 수산리·상평리·이곡리와 회현면의 금광리까지 펼쳐진 수산 이곡 평야, 그리고 만경강 하류를 조망할 수 있다.",
            "./mountainImage/전라/청암산.png",
            "전라도"));
      arr.add(new MountainInfo("나래산", "★★☆☆☆", "전북 임실군 운암면 운종리",
            "https://map.naver.com/p/entry/place/17653409?c=9.45,0,0,0,dh",
            "임실군의 운암대교 바로 동쪽에 위치하며 동서남북 어디에서 바라보아도 나래산의 정상부가 똑같은 삼각추 모양으로 바라다 보이는 산이다. 해발 543.9m로 옥정호의 푸른 물결에 산의 3면이 둘러싸여 비록 높이는 높지 않지만 주변 경치가 아름다워 등산객들에게는 매력을 주는 산으로 알려져 있다.",
            "./mountainImage/전라/나래산.png",
            "전라도"));
      arr.add(new MountainInfo("팔공산", "★★★★☆", "전북 장수군 장수읍 대성리",
            "https://map.naver.com/p/entry/place/17626079?c=9.35,0,0,0,dh",
            "팔공산(叭公山)은 전라북도 장수군과 진안군 사이에 있는 1,151m의 산이다. 장수읍 서남향 20리에 위치한 곳으로 높이 1,151m의 고산이며 소백산맥에서 노령산맥이 시작되는 산이다.장수는 거의 전 지역이 소백과 노령의 분지적 협곡지대다. 금강의 최상류이자 섬진강의 최상류가 되며 수분치에서 분수하여 남쪽으로 가는데, 한편 물은 금강이 되고, 다른 한편 물은 섬진강이 되는 데서 비롯된 것으로 해석된다. 이 산에는 기원 6세기경에 팔성사라는 고찰이 창건되었고 팔성사에 예속된 암자 8개소가 있었는데 암자마다 성인이 한 분씩 거처하고 있었으므로 팔성사로 이름을 지었다고 한다.",
            "./mountainImage/전라/팔공산.png",
            "전라도"));
      arr.add(new MountainInfo("백운산", "★★★★☆", "전남 광양시 옥룡면",
            "https://map.naver.com/p/entry/place/13491547?c=10.10,0,0,0,dh",
            "높이는 1,222m이다. 반야봉(般若峰)·노고단(老姑壇)·왕증봉(王甑峰)·도솔봉(兜率峰:1,053m)·만복대(萬福臺)등과 함께 소백산맥(小白山脈)의 고봉(高峰)으로 꼽히며, 전라남도에서 지리산 노고단 다음으로 높다. 서쪽으로 도솔봉·형제봉(1,125m), 동쪽으로 매봉(867m)을 중심으로, 남쪽으로 뻗치는 4개의 지맥을 가지고 있다. 섬진강(蟾津江) 하류를 사이에 두고 지리산(智異山)과 남북으로 마주보고 있다. 남쪽 산기슭에는 고려 초에 도선국사(道詵國師)가 창건했다는 백운사(白雲寺)가 있다. 백운산 자연휴양림으로 관리되고 있다.",
            "./mountainImage/전라/백운산.png",
            "전라도"));
      arr.add(new MountainInfo("천관산", "★★★★☆", "전남 장흥군 관산읍",
            "https://map.naver.com/p/entry/place/11491532?c=10.10,0,0,0,dh",
            "전라남도 장흥군 관산읍과 대덕읍 경계에 있는 산으로, 지리산·월출산·내장산·내변산과 함께 호남지방의 5대 명산 가운데 하나이다. 수십 개의 봉우리가 하늘을 찌를듯이 솟아있는 것이 마치 천자(天子)의 면류관과 같아 천관산이라는 이름이 생겼으며, 신라 김유신(金庾信)과 사랑한 천관녀(天官女)가 숨어 살았다는 전설이 전해온다. 봄에는 진달래와 동백꽃이 붉게 물들고, 가을에는 산의 능선이 억새로 뒤덮혀 관광객이 많이 찾는다. 천관산 연대봉에는 고려 의종 때 세워진 봉수대가 있는데 이는 조선시대 때까지 주요한 통신수단으로 이용되었다.",
            "./mountainImage/전라/천관산.png",
            "전라도"));
      
      //경상
      arr.add(new MountainInfo("금오산", "★★☆☆☆", "경상북도 구미시 남통동 288-2",
            "https://map.naver.com/p/search/%EA%B8%88%EC%98%A4%EC%82%B0/place/11491326?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp",
            "경상북도 구미시, 칠곡군, 김천시에 걸쳐 있는 높이 976m의 산으로 구미시의 비중이 가장 크다. 금오산의 원래 이름은 대본산이었는데, 중국의 오악 중 중악 숭산과 비교해도 손색이 없다 하여 남숭산이라고도 하였다. 지금의 금오산이라는 명칭은 이곳을 지나던 삼국시대의 승려 아도가 저녁 노을 속으로 황금빛 까마귀가 나는 모습을 보고 금오산이라 이름 지은 것에 유래한다. ",
            "./mountainImage/경상/금오산.png",
            "경상도"));
      arr.add(new MountainInfo("신불산", "★★☆☆☆", "울산 울주군 상북면",
            "https://map.naver.com/p/search/%EC%8B%A0%EB%B6%88%EC%82%B0/place/13491381?c=7.00,0,0,0,dh&placePath=%3Fentry%253Dbmp",
            "울산광역시 울주군 삼남읍과 상북면에 걸쳐있는 높이 1,159m의 산이다. 이름의 유래는 '신령이 불도를 닦는 산'. 남쪽에는 영축산이 능선을 통해 서로 연결되어 있다. 경부고속도로 언양 부근을 지날 때 보이는 높은 산들이 신불산, 영축산 능선이다. 태백산맥 여맥에 있으며 영남알프스를 이루는 산들 중 하나다. 영남 알프스의 최고봉인 가지산 다음으로 높으며 울산광역시에서 2번째로 높은 산이다. 산의 정상부에는 고위평탄면이 존재하며 억새로 유명하다.",
            "./mountainImage/경상/신불산.png",
            "경상도"));
      arr.add(new MountainInfo("가야산", "★★★☆☆", "경남 합천군 가야면",
            "https://map.naver.com/p/search/%EA%B0%80%EC%95%BC%EC%82%B0/place/13491201?c=7.00,0,0,0,dh&placePath=%3Fentry%253Dbmp",
            "경상북도 성주군과 경상남도 합천군, 거창군에 걸쳐 있는 산으로 1972년 국립공원으로 지정되었다. 높이는 1,433m이다. 삼국시대 부터 신성한 산으로 여겨져서 우두산(牛頭山)이라 불렸고 가야의 산신제 때는 소를 제물로 바쳤다는 기록이 전한다. 2007년까지만 해도 접근성이 극히 불량할 정도로 말 그대로 오지였지만, 옆으로 중부내륙고속도로가 개통되고, '죽음의 도로'로 악명이 높았던 옛 88올림픽 고속도로가 확장되면서 광주대구고속도로가 된 지금은 접근성이 매우 좋은 편이다. ",
            "./mountainImage/경상/가야산.png",
            "경상도"));
      arr.add(new MountainInfo("주왕산", "★★★★☆", "경북 청송군 주왕산면 공원길 169-7",
            "https://map.naver.com/p/search/%EC%A3%BC%EC%99%95%EC%82%B0/place/11491524?c=7.00,0,0,0,dh&placePath=%3Fentry%253Dbmp",
            "주왕산(720.6m)은 한반도 산맥의 중심 뼈대를 이루는 백두대간의 등줄기인 태백산맥이 국토 동남부로 뻗어 나온 지맥에 위치한다. 수많은 암봉과 깊고 수려한 계곡이 빚어내는 절경으로 이루어진 우리나라 3대 암산의 하나이다. 수백 미터 돌덩이가 병풍처럼 솟아있어 신라 때는 석병산이라 부르다가 통일신라 말엽부터 주왕산이라 불리게 되었다. 주왕산은 4군데의 폭포 외에 동굴, 대전사 및 부속 암자들이 있어 천혜의 관광자원이 많은 곳이라고 할 수 있다.",
            "./mountainImage/경상/주왕산.png",
            "경상도"));
      arr.add(new MountainInfo("내연산", "★★★★☆", "경북 포항시 북구 송라면",
            "https://map.naver.com/p/entry/place/13491248?lng=129.2898602000122&lat=36.2786439999929&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh",
            "내연산은 경상북도 포항시와 영덕군에 걸쳐있는 산이다. 12개의 폭포를 보유하고 있다. 내연산의 최고봉인 향로봉은 높이가 930m이다.경상북도 영덕군 남정면과 포항시 송라면, 죽장면에 걸쳐있는 산이다. 경북 내륙의 산들이 동해안으로 이어지는 산으로 풍화에 강한 화산암 기반이라 깎아지른 절벽과 깊게 패인 계곡이 많다. 이 계곡에는 자연스럽게 형성된 침식지형의 폭포와 용소들이 다양한 경관을 만들어낸다.",
            "./mountainImage/경상/내연산.png",
            "경상도"));
      
   
      return arr;
   }
}