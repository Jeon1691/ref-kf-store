import * as common from '../common/en'

export default {
  ...common,
  stores: {
    message: {
      tel: 'telephone number',
      hours: 'business hours',
      address: 'address',
      map: 'Map area',
      view_map: 'View Map',
    },
    flagship: {
      title: 'Store Info',
      items: [
        {
          id: '0',
          imgs: [
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_W.jpg',
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_M.jpg',
          ],
          title: 'Gangnam Flagship Store',
          tel: '02-6494-1100 (Store), 02-596-9009 (3F Quartet Cafe)',
          hours: 'Daily 10:30 - 22:00',
          address: '1-3rd Fl., Yuchang Bldg., 1305-7, Seocho-dong, Seocho-gu, Seoul',
        },
        {
          id: '1',
          imgs: [
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_W.jpg',
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_M.jpg',
          ],
          title: 'Hongdae Flagship Store',
          tel: '02-6010-0104',
          hours: 'Daily 10:30 - 22:00',
          address:
            '1-3rd Fl., Joeun Saramdeul Bldg., 162, Yanghwa-ro, Mapo-gu, Seoul (Donggyo Daea Bldg., Donggyo-dong)',
        },
        {
          id: '2',
          imgs: [
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_W.jpg',
            'https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_M.jpg',
          ],
          title: 'Busan Flagship Store',
          tel: '051-256-0815',
          hours: 'Daily 10:30 - 22:00',
          address: '62, Gwangbok-ro, Jung-gu, Busan (Gwangbok-dong 2-ga)',
        },
      ],
    },
    areas: ['All Regions', 'Seoul', 'Gyeonggi', 'Incheon', 'Daegu', 'Busan'],
    select: {
      title: 'Stores by Region',
      select_area: 'select area',
      select_option: 'select option',
      selected: 'selected',
    },
    all: [
      {
        id: '0',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W001_incheon_T2.jpg',
        title: 'Incheon International Airport T2 Shinsegae Duty Free',
        tel: 'Daily 6:50 - 21:30',
        hours: '032-743-4759',
        address:
          'Near West Wing Gate 248, 3rd Fl., T2, 272, Gonghang-ro, Jung-gu, Incheon (Incheon International Airport, Unseo-dong)',
        area: 'incheon',
      },
      {
        id: '1',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W002_lotte.jpg',
        title: 'Myeongdong Lotte Young Plaza',
        tel: '02-2118-5150',
        hours: 'Daily 11:30 - 21:30',
        address: '1st Fl., 67, Namdaemun-ro, Jung-gu, Seoul (Lotte Young Plaza, Namdaemun-ro 2-ga)',
        area: 'seoul',
      },
      {
        id: '2',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W003_Timesquare.jpg',
        title: 'Times Square Yeongdeungpo',
        tel: '02-2638-2750',
        hours: 'Every day 10:30 - 22:00',
        address:
          'Kakao Friends, 1st Fl., 15, Yeongjung-ro, Yeongdeungpo-gu, Seoul (Times Square, Yeongdeungpo-dong 4(sa)-ga)',
        area: 'seoul',
      },
      {
        id: '3',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W004_goyang.jpg',
        title: 'Starfield Goyang Branch',
        tel: '031-5173-1007',
        hours: 'Daily 10:00 - 22:30',
        address:
          '#1113, 1st Fl., 1955, Goyang-daero, Deogyang-gu, Goyang-si, Gyeonggi-do (Starfield Goyang, Dongsan-dong)',
        area: 'gyeonggi',
      },
      {
        id: '4',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W005_busan.jpg',
        title: 'Busan Flagship Store',
        tel: '051-256-0815',
        hours: 'Daily 10:30 - 22:00',
        address: '62, Gwangbok-ro, Jung-gu, Busan (Gwangbok-dong 2-ga)',
        area: 'busan',
      },
      {
        id: '5',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W006_lotteworldtower.jpg',
        title: 'Lotte World Tower Duty Free',
        tel: '02-3213-6743~4',
        hours: 'Daily 9:30 - 21:00',
        address: '8th Fl., Lotte World Tower, 300, Olympic-ro, Songpa-gu, Seoul (Sincheon-dong)',
        area: 'seoul',
      },
      {
        id: '6',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W007_ddp.jpg',
        title: 'DDP',
        tel: '02-2231-3552',
        hours: 'Daily 10:30 - 22:00<br>(Closed on third Monday of each month)',
        address:
          'In front of Eoullim Square, B2 Fl., DDP, 281, Eulji-ro, Jung-gu, Seoul (Euljiro 7-ga)',
        area: 'seoul',
      },
      {
        id: '7',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W008_dongdaegu.jpg',
        title: 'Shinsegae Department Store Dongdaegu Branch',
        tel: '053-661-6942',
        hours: 'Daily 11:00 - 21:30<br>(Closed on regular mall holidays)',
        address:
          'Kakao Friends, 8th Fl., Shinsegae Department Store, 149, Dongbu-ro, Dong-gu, Daegu (Sincheon-dong)',
        area: 'daegu',
      },
      {
        id: '8',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W009_hongdae.jpg',
        title: 'Hongdae Flagship Store',
        tel: '02-6010-0104',
        hours: 'Daily 10:30 - 22:00',
        address:
          '1-3rd Fl., Joeun Saramdeul Bldg., 162, Yanghwa-ro, Mapo-gu, Seoul (Donggyo Daea Bldg., Donggyo-dong)',
        area: 'seoul',
      },
      {
        id: '9',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W010_hanam.jpg',
        title: 'Starfield Hanam Branch',
        tel: '031-8072-8231',
        hours: 'Daily 10:00 - 22:00',
        address:
          '1st Fl., Starfield Hanam, 750, Misa-daero, Hanam-si, Gyeonggi-do (Starfield Hanam, Sinjang-dong)',
        area: 'gyeonggi',
      },
      {
        id: '10',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W011_silla.jpg',
        title: "Yongsan Shilla I'PARK Duty Free",
        tel: '02-490-3927',
        hours: 'Daily 9:00 - 21:00',
        address:
          "6th Fl., I'PARK Mall, 55, Hangang-daero 23-gil, Yongsan-gu, Seoul (Yongsan Station, Hangang-ro 3-ga)",
        area: 'seoul',
      },
      {
        id: '11',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W012_gangnam.jpg',
        title: 'Gangnam Flagship Store',
        tel: '02-6494-1100',
        hours: 'Daily 10:30 - 22:00',
        address: '1-3rd Fl., Yuchang Bldg., 1305-7, Seocho-dong, Seocho-gu, Seoul',
        area: 'seoul',
      },
      {
        id: '12',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W013_ssg.jpg',
        title: 'Myeongdong Shinsegae Duty Free',
        tel: '02-6370-4278',
        hours: 'Daily 9:00 -  20:30',
        address:
          '11th Fl., Shinsegae Duty Free, 63, Sogong-ro, Jung-gu, Seoul (Shinsegae Department Store Bldg., Chungmuro 1-ga)',
        area: 'seoul',
      },
      {
        id: '13',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W014_lotte.jpg',
        title: 'Jamsil Lotte World Mall',
        tel: '02-3213-4514',
        hours: 'Daily 10:30 - 22:00',
        address:
          '5th Fl., Jamsil Lotte World Mall, 300, Olympic-ro, Songpa-gu, Seoul (Sincheon-dong)',
        area: 'seoul',
      },
      {
        id: '14',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W015_gangnam.jpg',
        title: 'Shinsegae Department Store Gangnam Branch',
        tel: '02-3479-1328',
        hours: 'Daily 10:30 - 22:00',
        address:
          'B1 Fl., Shinsegae Department Store Gangnam Branch, 176, Sinbanpo-ro, Seocho-gu, Seoul (Central City Bldg., Banpo-dong)',
        area: 'seoul',
      },
      {
        id: '15',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W016_pangyo.jpg',
        title: 'Hyundai Department Store Pangyo Branch',
        tel: '031-5170-2451',
        hours: 'Daily 10:30 - 20:00<br>(Closed on regular mall holidays)',
        address:
          '4th Fl., Uplex, Hyundai Department Store Pangyo Branch, 8, Pangyoyeok-ro 146beon-gil, Bundang-gu, Seongnam-si, Gyeonggi-do (Baekhyeon-dong)',
        area: 'gyeonggi',
      },
      {
        id: '16',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W017_yeouido.jpg',
        title: 'CGV Yeouido Branch',
        tel: '02-6137-5550',
        hours: 'Daily 10:00 - 22:00',
        address: 'B3 Fl., IFC Mall, 23, Yeouido-dong, Yeongdeungpo-gu, Seoul',
        area: 'seoul',
      },
      {
        id: '17',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W018_busan_re.jpg',
        title: 'Lotte Department Store Busan Main Branch',
        tel: '051-810-4757',
        hours: 'Daily 10:30 - 20:00',
        address:
          '7th Fl., Lotte Department Store Busan Main Branch, 772, Gaya-daero, Busanjin-gu, Busan (Bujeon-dong)',
        area: 'busan',
      },
      {
        id: '18',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W019_coex_renewal.jpg',
        title: 'COEX Mall',
        tel: '02-6002-1880',
        hours: 'Daily 10:30 - 22:00',
        address:
          '#C108, B1 Fl., COEX Mall, 513, Yeongdong-daero, Gangnam-gu, Seoul (COEX, Samseong-dong)',
        area: 'seoul',
      },
      {
        id: '19',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W020_daegu.jpg',
        title: 'Hyundai Department Store Daegu Branch',
        tel: '053-245-3039',
        hours: 'Daily 10:30 - 21:00<br>(Closed on regular mall holidays)',
        address:
          'Atrium Square, B2 Fl., Uplex, 2077, Dalgubeol-daero, Jung-gu, Daegu (Hyundai Department Store, Gyesan-dong 2-ga)',
        area: 'daegu',
      },
      {
        id: '20',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W021_sinchon.jpg',
        title: 'Hyundai Department Store Sinchon Branch',
        tel: '02-3145-1722',
        hours: 'Daily 10:30 - 22:00<br>(Closed on regular mall holidays)',
        address:
          'B2 Fl., Main Bldg., 83, Sinchon-ro, Seodaemun-gu, Seoul (Hyundai Department Store Sinchon Branch, Changcheon-dong)',
        area: 'seoul',
      },
      {
        id: '21',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W022_suwon_ak.jpg',
        title: 'AK Plaza Suwon Branch',
        tel: '031-240-1293',
        hours: 'Daily 10:30 - 22:00',
        address: 'AK Plaza Suwon Branch, 924, Deogyeong-daero, Paldal-gu, Suwon-si, Gyeonggi-do',
        area: 'gyeonggi',
      },
      {
        id: '22',
        img: 'https://t1.kakaocdn.net/friends/prod/info/W025_jeju_jdc.jpg',
        title: 'Jeju Airport JDC Duty Free',
        tel: '',
        hours: 'Daily 06:20 ~ 21:20',
        address: '2F, 2, Gonghang-ro, Jeju-si, Jeju-do',
        area: 'jeju',
      },
    ],
  },
}
