<template>
  <div class="layer">
    <img src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png"
         class="post_layer_close"
         alt="닫기 버튼"
         @click="hideModal">
    <div ref="layer"
         class="postcode_layer"></div>
  </div>
</template>

<script>
import ua from '@/common/ua'
import { mapState, mapMutations } from 'vuex'

export default {
  name: 'app-postcode',
  data() {
    return {
      isMobile: ua.device.type === 'mobile',
      orderPostalInput: document.getElementById('orderPostal'),
    }
  },
  computed: {
    ...mapState({
      isVisible: state => state.modal.isVisible,
      onComplete: state => state.modal.onComplete,
    }),
  },
  methods: {
    ...mapMutations(['HIDE_MODAL']),
    setPosition(position) {
      document.body.style.position = position
    },
    hideModal() {
      this.HIDE_MODAL()

      if (this.isMobile) {
        this.setPosition('static')
        this.orderPostalInput.scrollIntoView()
      }
    },
    execPostCode() {
      const { daum } = window

      new daum.Postcode({
        oncomplete: data => {
          let oaAddr1 = data.address
          let extraAddr = ''

          if (data.addressType === 'R') {
            if (data.bname) {
              extraAddr += data.bname
            }

            if (data.buildingName) {
              extraAddr += extraAddr ? `, ${data.buildingName}` : data.buildingName
            }

            oaAddr1 += extraAddr ? ` (${extraAddr})` : ''
          }

          this.onComplete({
            zonecode: data.zonecode,
            oaAddr1,
          })

          if (this.isMobile) {
            this.setPosition('static')
            this.orderPostalInput.scrollIntoView()
          }
        },
        width: '100%',
        height: '100%',
        maxSuggestItems: 5,
      }).embed(this.$refs.layer)
    },
  },
  mounted() {
    if (this.isMobile) {
      this.setPosition('fixed')
    }
    this.execPostCode()
  },
}
</script>

<style scoped>
.layer {
  position: absolute;
  left: 0px;
  top: 0px;
  z-index: 1;
  width: 100%;
  height: 100%;
  border: 0px solid;
}

.postcode_layer {
  height: 100%;
}

.post_layer_close {
  cursor: pointer;
  position: absolute;
  right: 0;
  top: -20px;
  z-index: 1;
}
</style>
