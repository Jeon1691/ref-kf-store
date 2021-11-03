import * as common from '../common/ko'

export default {
  ...common,
  stores: {
    message: {
      tel: '전화번호',
      hours: '영업시간',
      address: '주소',
      map: '지도영역',
      view_map: '지도 자세히보기',
    },
    flagship: {
      title: '매장안내',
      items: [
        {
          id: '0',
          imgs: [
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_W.jpg',
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_M.jpg',
          ],
          title: '강남 플래그십 스토어',
          tel: '02-6494-1100 (매장), 02-596-9009 (3F 콰르텟 카페)',
          hours: '매일 10:30 - 22:00',
          address: '서울 서초구 서초동 1305-7 유창빌딩 1~3층',
        },
        {
          id: '1',
          imgs: [
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_W.jpg',
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_M.jpg',
          ],
          title: '홍대 플래그십 스토어',
          tel: '02-6010-0104',
          hours: '매일 10:30 - 22:00',
          address: '서울 마포구 양화로 162 (동교동, 동교동대아빌딩) 좋은사람들빌딩 1~3층',
        },
        {
          id: '2',
          imgs: [
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_W.jpg',
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_M.jpg',
          ],
          title: '부산 플래그십 스토어',
          tel: '051-256-0815',
          hours: '매일 10:30 - 22:00',
          address: '부산 중구 광복로 62 (광복동2가)',
        },
      ],
    },
    areas: ['전지역', '서울', '경기', '인천', '대구', '부산', '제주'],
    select: {
      title: '지역별 매장',
      select_area: '지역 선택',
      select_option: '선택옵션',
      selected: '선택됨',
    },
    all: [
      {
        id: '0',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W001_incheon_T2.jpg',
        title: '인천공항 T2 면세점',
        tel: '032-743-4759',
        hours: '매일 6:50 - 21:30',
        address: '인천 중구 공항로 272 (운서동, 인천공항) T2 3층 서편 248게이트 부근',
        area: 'incheon',
      },
      {
        id: '1',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W002_lotte.jpg',
        title: '롯데 영플라자 명동점',
        tel: '02-2118-5150',
        hours: '매일 11:30 - 21:30',
        address: '서울 중구 남대문로 67 (남대문로2가, 롯데영플라자) 1층',
        area: 'seoul',
      },
      {
        id: '2',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W003_Timesquare.jpg',
        title: '타임스퀘어점',
        tel: '02-2638-2750',
        hours: '매일 10:30 - 22:00',
        address: '서울 영등포구 영중로 15 (영등포동4가, 타임스퀘어) 1층',
        area: 'seoul',
      },
      {
        id: '3',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W004_goyang.jpg',
        title: '스타필드 고양점',
        tel: '031-5173-1007',
        hours: '매일 10:00 - 22:30',
        address: '경기 고양시 덕양구 고양대로 1955 (동산동, 스타필드 고양) 1층 1113호',
        area: 'gyeonggi',
      },
      {
        id: '4',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W005_busan.jpg',
        title: '부산 플래그십 스토어',
        tel: '051-256-0815',
        hours: '매일 10:30 - 22:00',
        address: '부산 중구 광복로 62 (광복동2가)',
        area: 'busan',
      },
      {
        id: '5',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W006_lotteworldtower.jpg',
        title: '롯데월드타워 면세점',
        tel: '02-3213-6743~4',
        hours: '매일 9:30 - 21:00',
        address: '서울 송파구 올림픽로 300 (신천동) 월드타워점 8층',
        area: 'seoul',
      },
      {
        id: '6',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W007_ddp.jpg',
        title: 'DDP 동대문점',
        tel: '02-2231-3552',
        hours: '매일 10:30 - 22:00 <br>(매월 셋째주 월요일 휴무)',
        address: '서울 중구 을지로 281 (을지로7가) DDP 지하2층 어울림광장 앞',
        area: 'seoul',
      },
      {
        id: '7',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W008_dongdaegu.jpg',
        title: '신세계백화점 동대구점',
        tel: '053-661-6942',
        hours: '매일 11:00 - 21:30 <br>(쇼핑몰 전체 정기휴무일 휴점)',
        address: '대구 동구 동부로 149 (신천동) 신세계백화점 8층',
        area: 'daegu',
      },
      {
        id: '8',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W009_hongdae.jpg',
        title: '홍대 플래그십 스토어',
        tel: '02-6010-0104',
        hours: '매일 10:30 - 22:00',
        address: '서울 마포구 양화로 162 (동교동, 동교동대아빌딩) 좋은사람들빌딩 1~3층',
        area: 'seoul',
      },
      {
        id: '9',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W010_hanam.jpg',
        title: '스타필드 하남점',
        tel: '031-8072-8231',
        hours: '매일 10:00 - 22:00',
        address: '경기 하남시 미사대로 750 (신장동 스타필드 하남) 스타필드 하남 1층',
        area: 'gyeonggi',
      },
      {
        id: '10',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W011_silla.jpg',
        title: '신라아이파크 면세 용산점',
        tel: '02-490-3927',
        hours: '매일 9:00 - 21:00',
        address: '서울 용산구 한강대로23길 55 (한강로3가, 용산민자역사) 아이파크몰 6층',
        area: 'seoul',
      },
      {
        id: '11',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W012_gangnam.jpg',
        title: '강남 플래그십 스토어',
        tel: '02-6494-1100',
        hours: '매일 10:30 - 22:00',
        address: '서울 서초구 서초동 1305-7 유창빌딩 1~3층',
        area: 'seoul',
      },
      {
        id: '12',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W013_ssg.jpg',
        title: '신세계면세 명동점',
        tel: '02-6370-4278',
        hours: '매일 9:00 - 20:30',
        address: '서울 중구 소공로 63 (충무로1가, 신세계백화점건물) 신세계면세점 11층',
        area: 'seoul',
      },
      {
        id: '13',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W014_lotte.jpg',
        title: '롯데월드몰 잠실점',
        tel: '02-3213-4514',
        hours: '매일 10:30 - 22:00',
        address: '서울 송파구 올림픽로 300(신천동) 잠실 롯데월드몰 5층',
        area: 'seoul',
      },
      {
        id: '14',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W015_gangnam.jpg',
        title: '신세계백화점 강남점',
        tel: '02-3479-1328',
        hours: '매일 10:30 - 22:00',
        address: '서울 서초구 신반포로 176 (반포동, 센트럴시티빌딩) 신세계백화점 강남점 지하1층',
        area: 'seoul',
      },
      {
        id: '15',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W016_pangyo.jpg',
        title: '현대백화점 판교점',
        tel: '031-5170-2451',
        hours: '매일 10:30 - 20:00 <br>(쇼핑몰 전체 정기휴무일 휴점)',
        address: '경기 성남시 분당구 판교역로 146번길 8 (백현동) 현대백화점 판교점 유플렉스 4층',
        area: 'gyeonggi',
      },
      {
        id: '16',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W017_yeouido.jpg',
        title: 'CGV 여의도점',
        tel: '02-6137-5550',
        hours: '매일 10:00 - 22:00',
        address: '서울 영등포구 여의도동 23 IFC몰 지하3층',
        area: 'seoul',
      },
      {
        id: '17',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W018_busan_re.jpg',
        title: '롯데백화점 부산점',
        tel: '051-810-4757',
        hours: '매일 10:30 - 20:00',
        address: '부산 부산진구 가야대로 772 (부전동) 롯데백화점 부산본점 7층',
        area: 'busan',
      },
      {
        id: '18',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W019_coex_renewal.jpg',
        title: '스타필드 코엑스몰점',
        tel: '02-6002-1880',
        hours: '매일 10:30 - 22:00',
        address: '서울 강남구 영동대로 513 (삼성동, 코엑스) 코엑스몰. B1층 C108호',
        area: 'seoul',
      },
      {
        id: '19',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W020_daegu.jpg',
        title: '현대백화점 대구점',
        tel: '053-245-3039',
        hours: '매일 10:30 - 21:00 <br>(쇼핑몰 전체 정기휴무일 휴점)',
        address: '대구 중구 달구벌대로 2077 (계산동2가, 현대백화점) 유플렉스 지하2층 아트리움 광장',
        area: 'daegu',
      },
      {
        id: '20',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W021_sinchon.jpg',
        title: '현대백화점 신촌점',
        tel: '02-3145-1722',
        hours: '매일 10:30 - 22:00 <br>(쇼핑몰 전체 정기휴무일 휴점)',
        address: '서울 서대문구 신촌로 83 (창천동, 현대백화점신촌점) 본관 지하2층',
        area: 'seoul',
      },
      {
        id: '21',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W022_suwon_ak.jpg',
        title: '수원 AK점',
        tel: '031-240-1293',
        hours: '매일 10:30 ~ 22:00',
        address: '경기도 수원시 팔달구 덕영대로 924 AK플라자수원점',
        area: 'gyeonggi',
      },
      {
        id: '22',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W025_jeju_jdc.jpg',
        title: '제주공항 JDC 면세점',
        tel: '',
        hours: '매일 06:20 ~ 21:20',
        address: '제주특별자치도 제주시 공항로 2 제주국제공항합동청사 2층',
        area: 'jeju',
      },
    ],
  },
}
