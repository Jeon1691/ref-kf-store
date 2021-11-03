export default {
  data () {
    return {
      accordian: {
        active: false
      }
    }
  },
  methods: {
    toggleAccordian () {
      this.accordian.active = !this.accordian.active
    }
  }
}
