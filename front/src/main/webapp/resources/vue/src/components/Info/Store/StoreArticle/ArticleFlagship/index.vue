<template>
  <div class="inner_storeinfo">
    <div v-for="(store, index) in $t('stores.flagship.items')"
         :key="store.id"
         class="section_store">
      <div class="area_img">
        <img :src="store.imgs[0]"
             alt=""
             class="thumb_g rw_show">
        <img :src="store.imgs[1]"
             alt=""
             class="thumb_g rw_hide">
      </div>

      <div class="area_cont">
        <strong class="tit_store">{{ store.title }}</strong>

        <dl class="store_info">
          <dt>
            <span class="ico_newfriends_v1 ico_tel">{{ $t('stores.message.tel') }} :</span>
          </dt>
          <dd>{{ store.tel }}</dd>
          <dt>
            <span class="ico_newfriends_v1 ico_time">{{ $t('stores.message.hours') }} :</span>
          </dt>
          <dd>{{ store.hours }}</dd>
          <dt>
            <span class="ico_newfriends_v1 ico_address">{{ $t('stores.message.address') }} :</span>
          </dt>
          <dd>{{ store.address }}</dd>
        </dl>

        <flagship-map :index="index"
                      :info="maps[index]"></flagship-map>
      </div>
    </div>
  </div>
</template>

<script>
import FlagshipMap from './FlagshipMap'

export default {
  name: 'article-flagship',
  components: {
    FlagshipMap,
  },
  data() {
    return {
      maps: [
        {
          lat: 37.5008429,
          lng: 127.0256816,
          url:
            '%EC%B9%B4%EC%B9%B4%EC%98%A4%ED%94%84%EB%A0%8C%EC%A6%88+%EA%B0%95%EB%82%A8%ED%94%8C%EB%9E%98%EA%B7%B8%EC%8B%AD%EC%8A%A4%ED%86%A0%EC%96%B4/@37.5008429,127.0234929,17z/data=!3m1!4b1!4m5!3m4!1s0x357ca158e3eb7817:0x9477be46958f3844!8m2!3d37.5008429!4d127.0256816',
        },
        {
          lat: 37.5563962,
          lng: 126.923864,
          url:
            '%EC%B9%B4%EC%B9%B4%EC%98%A4%ED%94%84%EB%A0%8C%EC%A6%88+%ED%99%8D%EB%8C%80%ED%94%8C%EB%9E%98%EA%B7%B8%EC%8B%AD%EC%8A%A4%ED%86%A0%EC%96%B4/@37.5524713,126.9199606,16z/data=!4m8!1m2!2m1!1z7ZmN64yAIO2UjOuemOq3uOyLrSDsiqTthqDslrQ!3m4!1s0x357c98c2e4a3edc7:0x140dd20564986561!8m2!3d37.5564418!4d126.9238083',
        },
        {
          lat: 35.0990376,
          lng: 129.0316073,
          url:
            '%EC%B9%B4%EC%B9%B4%EC%98%A4%ED%94%84%EB%A0%8C%EC%A6%88+%EB%B6%80%EC%82%B0%ED%94%8C%EB%9E%98%EA%B7%B8%EC%8B%AD%EC%8A%A4%ED%86%A0%EC%96%B4/@35.0990376,129.0294186,17z/data=!4m8!1m2!2m1!1z67aA7IKwIO2UjOuemOq3uOyLrSDsiqTthqDslrQ!3m4!1s0x3568e90adde9576d:0x6f9203ac6a3b9cb8!8m2!3d35.0990398!4d129.0316086',
        },
      ],
    }
  },
}
</script>
