import { mapState, mapMutations } from 'vuex'
import zip from 'lodash/zip'

export default {
  data() {
    return {
      AREA_KEY: ['', 'seoul', 'gyeonggi', 'incheon', 'daegu', 'busan', 'jeju'],
    }
  },
  computed: {
    ...mapState(['area']),
    filters() {
      console.log(this.AREA_KEY)
      return zip(this.AREA_KEY, this.$t('stores.areas')).map(area => ({
        key: area[0],
        name: area[1],
      }))
    },
  },
  methods: {
    ...mapMutations(['CHANGE_AREA']),
    onClick(area) {
      this.CHANGE_AREA(area)
    },
  },
}
