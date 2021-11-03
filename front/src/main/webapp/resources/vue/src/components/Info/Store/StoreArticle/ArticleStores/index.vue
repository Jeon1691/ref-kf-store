<template>
  <div class="inner_storeinfo">
    <div class="group_storelist">
      <div v-for="store in stores"
           :key="store.id"
           class="section_store">
        <div class="area_img">
          <img :src="store.img"
               alt=""
               class="thumb_g">
        </div>

        <div class="area_cont">
          <strong class="tit_store">{{ store.title }}</strong>

          <dl class="store_info">
            <dt v-if="store.tel !== ''">
              <span class="ico_newfriends_v1 ico_tel">{{ $t('stores.message.tel') }} :</span>
            </dt>
            <dd v-if="store.tel !== ''">{{ store.tel }}</dd>
            <dt>
              <span class="ico_newfriends_v1 ico_time">{{ $t('stores.message.hours') }} :</span>
            </dt>
            <dd v-html="store.hours"></dd>
            <dt>
              <span class="ico_newfriends_v1 ico_address">{{ $t('stores.message.address') }} :</span>
            </dt>
            <dd>{{ store.address }}</dd>
          </dl>

          <a :href="`https://www.google.com/maps/place/${urls[store.id]}`"
             class="link_location"
             target="_blank">
            <span class="ico_newfriends_v1 ico_location"></span>{{ $t('stores.message.view_map') }}</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'article-stores',
  data() {
    return {
      urls: {
        0: '신라면세점+인천공항점/@37.4488003,126.4496679,19z/data=!4m8!1m2!2m1!1z7J247LKc6rO17ZWtIOyLoOyEuOqzhOuptOyEuOygkA!3m4!1s0x357b9a5c50674e3b:0xd49fb87995adeb63!8m2!3d37.4482831!4d126.4485449',
        1: '롯데영프라자/@37.5632432,126.9796979,17z/data=!4m8!1m2!2m1!1z7ISc7Jq47Yq567OE7IucIOykkeq1rCDrqoXrj5nso7zrs4Droa_rjbAg7JiB7ZSM65287J6Q7KCQIOy5tOy5tOyYpO2UhOugjOymiA!3m4!1s0x357ca2f1761b7d15:0xb006aae66852fddf!8m2!3d37.5630346!4d126.9820817',
        2: '타임스퀘어/@37.5171711,126.9009994,17z/data=!4m8!1m2!2m1!1z7YOA7J6E7Iqk7YCY7Ja0IOyYgeuTse2PrOygkA!3m4!1s0x357c9efb5c308621:0x17d357f6aa05d974!8m2!3d37.5171639!4d126.9031758',
        3: '스타필드+고양/@37.6467805,126.8926336,17z/data=!3m1!4b1!4m5!3m4!1s0x357c9713f6961e85:0x33d53c6fd0151b38!8m2!3d37.6467805!4d126.8948223',
        4: '카카오프렌즈+부산플래그십스토어/@35.0995418,129.0273965,16z/data=!4m8!1m2!2m1!1z67aA7IKwIO2UjOuemOq3uOyLrSDsiqTthqDslrQ!3m4!1s0x3568e90adde9576d:0x6f9203ac6a3b9cb8!8m2!3d35.0990398!4d129.0316086',
        5: '롯데면세점+월드타워점/@37.5132307,127.1016425,17z/data=!3m1!4b1!4m5!3m4!1s0x357ca5a720cc0a33:0x39683f425d3aa95a!8m2!3d37.5132307!4d127.1038312',
        6: '카카오프렌즈+DDP점/@37.5661304,127.0069494,17z/data=!3m1!4b1!4m5!3m4!1s0x357ca33d22a26c29:0xad073aebbe173776!8m2!3d37.5661304!4d127.0091381',
        7: '카카오프렌즈샵/@35.8780575,128.6272665,17z/data=!3m1!4b1!4m5!3m4!1s0x3565e192876dbd31:0x26fa2ad026158130!8m2!3d35.8780575!4d128.6294552',
        8: '카카오프렌즈+홍대플래그십스토어/@37.5564418,126.9216196,17z/data=!3m1!4b1!4m5!3m4!1s0x357c98c2e4a3edc7:0x140dd20564986561!8m2!3d37.5564418!4d126.9238083',
        9: '스타필드+하남/@37.5456313,127.221339,17z/data=!3m1!4b1!4m5!3m4!1s0x357cb3d2021e0c6f:0xbf6f19bd4ac702bc!8m2!3d37.5456313!4d127.2235277',
        10: '신라아이파크면세점/@37.5288539,126.961856,17z/data=!3m1!4b1!4m5!3m4!1s0x357ca203479b1f7f:0xc7dc5ad49ace45a6!8m2!3d37.5288539!4d126.9640447',
        11: '카카오프렌즈+강남플래그십스토어/@37.5008429,127.0234929,17z/data=!3m1!4b1!4m5!3m4!1s0x357ca158e3eb7817:0x9477be46958f3844!8m2!3d37.5008429!4d127.0256816',
        12: '신세계면세점/@37.5603075,126.9786419,17z/data=!3m1!4b1!4m5!3m4!1s0x357ca2f402e427b1:0x926de623a14ef9fd!8m2!3d37.5603075!4d126.9808306',
        13: '롯데월드타워/@37.5132334,127.1013235,17z/data=!4m8!1m2!2m1!1z7J6g7IukIOuhr-uNsOyblOuTnOuqsA!3m4!1s0x357ca50a915f665b:0xabeb10cd5efdfce2!8m2!3d37.5127779!4d127.1025702',
        14: '신세계백화점+강남점/@37.5048269,127.0018946,17z/data=!4m8!1m2!2m1!1z7Iug7IS46rOE67Cx7ZmU7KCQIOqwleuCqOygkA!3m4!1s0x357ca1780001aa3d:0xe968dbc71dc9a2c3!8m2!3d37.5052498!4d127.0040312',
        15: '현대백화점+판교점/@37.3925707,127.1098073,17z/data=!3m1!4b1!4m5!3m4!1s0x357b585b10f7d4eb:0x23cd030dd3635aea!8m2!3d37.3925707!4d127.111996',
        16: 'CGV+여의도/@37.5250012,126.9239947,17z/data=!3m1!4b1!4m5!3m4!1s0x357c9f3c70eb9439:0xd9aeff44afa6fdf9!8m2!3d37.5250012!4d126.9261834',
        17: '롯데백화점+부산본점/@35.1568069,129.054233,17z/data=!3m1!4b1!4m5!3m4!1s0x3568eb6e1678f7ff:0x7bc6c334e233bc82!8m2!3d35.1568069!4d129.0564217',
        18: '스타필드+코엑스몰/@37.5116833,127.0569193,17z/data=!3m1!4b1!4m5!3m4!1s0x357ca2012d6bd01b:0x30702ebd32133065!8m2!3d37.5116833!4d127.059108',
        19: '현대백화점+대구점/@35.866801,128.5883563,17z/data=!3m1!4b1!4m5!3m4!1s0x3565e3ebb496599f:0x8bfb46ac9aaf6579!8m2!3d35.866801!4d128.590545',
        20: '현대백화점+신촌점/@37.5560736,126.933609,17z/data=!3m1!4b1!4m5!3m4!1s0x357c9895aeded545:0xe5abd4085bafffde!8m2!3d37.5560736!4d126.9357977',
        21: 'AK플라자+수원점/@37.2657879,126.9979137,17z/data=!4m8!1m2!2m1!1zQUvtlIzrnbzsnpAg7IiY7JuQ7KCQ!3m4!1s0x357b431c4eab2813:0x87d7679749e70fef!8m2!3d37.2654762!4d127.0003508',
        22: 'JDC면세점/@33.5059159,126.4935288,18z/data=!4m8!1m2!2m1!1z7KCc7KO86rO17ZWtIEpEQw!3m4!1s0x350cfb3b00720be5:0x6f3cd74e4ca57313!8m2!3d33.5067607!4d126.4929416',
      },
    }
  },
  computed: {
    ...mapState(['area']),
    stores() {
      if (!this.area.key) {
        return this.$t('stores.all')
      }
      return this.$t('stores.all').filter(store => store.area === this.area.key)
    },
  },
}
</script>

<style scoped>
.list-complete-item {
  transition: all 1s;
  display: inline-block;
  margin-right: 10px;
}
.list-complete-enter,
.list-complete-leave-to {
  opacity: 0;
  transform: translateY(30px);
}
.list-complete-leave-active {
  position: absolute;
}
</style>